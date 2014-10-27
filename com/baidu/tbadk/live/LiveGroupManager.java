package com.baidu.tbadk.live;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.live.LiveErrorMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tbadk.live.service.LiveGroupManagerService;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class LiveGroupManager {
    private static final int LIVE_ERROR_EVENT = 2;
    private static final int LIVE_PLAY_PROGRESS_UPDATE_EVENT = 3;
    private static final int LIVE_PLAY_WARNING_EVENT = 5;
    private static final int LIVE_RECORD_TIME_UPDATE_EVENT = 4;
    private static final int LIVE_STATUS_CHANGE_EVENT = 1;
    private static final int LIVE_STATUS_REQUEST_EVENT = 10;
    private static final int MAX_RETRY_TIMES_WHEN_NO_STREAM = 3;
    private static final int TIME_INTERVAL_OF_WHEN_NO_STREAM = 20000;
    public static LiveGroupManager mManager = new LiveGroupManager();
    private String mUserId;
    private String mAccessToken = null;
    private boolean mInit = false;
    private int mAccTimesWhenNoStreamWarning = 0;
    private int mRetryTimesWhenNoStream = 0;
    private boolean mHasBookedWarningTask = false;
    private int mLastStatusBroadcasted = -1;
    private String mGroupStoppedForCall = null;
    private String mUrlStoppedForCall = null;
    private int mStopPostionOfRecord = 0;
    private n mRecordTimeWatcher = null;
    private CustomMessageListener mLiveStatusRequestWatcher = new e(this, 2001162);
    private CustomMessageListener mAccessTokenUpdateWatcher = new f(this, 2001164);
    private CustomMessageListener mNetworkChangeWatcher = new g(this, 2001121);
    private final CustomMessageListener mChatRoomMessageListener = new h(this, 2001166);
    private final CustomMessageListener mExitAppMessageListener = new i(this, 2001171);
    private com.baidu.tbadk.live.service.a mRemoteService = null;
    private com.baidu.tbadk.live.service.d mCallback = new j(this);
    private Handler mHandler = new k(this);
    private Runnable mStreamWarningTask = new l(this);
    private ServiceConnection servRemoteConnection = new m(this);

    public void onAccountChanged() {
        if (mManager != null && this.mInit) {
            stopAnyRunning();
            this.mUserId = TbadkApplication.getCurrentAccount();
            String currentBduss = TbadkApplication.getCurrentBduss();
            if (currentBduss != null) {
                a.ss().dy(currentBduss);
            } else {
                this.mAccessToken = null;
            }
        }
    }

    private LiveGroupManager() {
    }

    public static LiveGroupManager getInstance() {
        return mManager;
    }

    public void init() {
        if (!this.mInit) {
            MessageManager.getInstance().registerListener(this.mLiveStatusRequestWatcher);
            MessageManager.getInstance().registerListener(this.mAccessTokenUpdateWatcher);
            MessageManager.getInstance().registerListener(this.mNetworkChangeWatcher);
            MessageManager.getInstance().registerListener(this.mChatRoomMessageListener);
            MessageManager.getInstance().registerListener(this.mExitAppMessageListener);
            a.ss().dy(TbadkApplication.getCurrentBduss());
            this.mUserId = TbadkApplication.getCurrentAccount();
            doBindRemoteService();
            createPhoneListener();
            this.mInit = true;
        }
    }

    public void onIncomingOrPlacingCall() {
        if (this.mGroupStoppedForCall == null) {
            int currentStatus = getCurrentStatus();
            if (currentStatus == 3) {
                pausePublish(getCurrentGroupId());
            } else if (currentStatus == 19) {
                String currentGroupId = getCurrentGroupId();
                String currentUrl = getCurrentUrl();
                if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.mGroupStoppedForCall)) {
                    int positionOfRecord = getPositionOfRecord();
                    stopPlayRecord();
                    this.mStopPostionOfRecord = positionOfRecord;
                } else {
                    stopPlayLive(currentGroupId);
                }
                this.mGroupStoppedForCall = currentGroupId;
                this.mUrlStoppedForCall = currentUrl;
            }
        }
    }

    public void onEndCall() {
        if (this.mGroupStoppedForCall != null && this.mUrlStoppedForCall != null) {
            if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.mGroupStoppedForCall)) {
                startPlayRecord(this.mUrlStoppedForCall, this.mStopPostionOfRecord);
            } else {
                startPlayLive(this.mGroupStoppedForCall, this.mUrlStoppedForCall);
            }
        }
        this.mGroupStoppedForCall = null;
        this.mUrlStoppedForCall = null;
        this.mStopPostionOfRecord = 0;
    }

    public void createPhoneListener() {
        try {
            ((TelephonyManager) TbadkApplication.m251getInst().getApp().getSystemService("phone")).listen(new o(this, null), 32);
        } catch (SecurityException e) {
        }
    }

    public void setLiveRecordTimeWatcher(n nVar) {
        this.mRecordTimeWatcher = nVar;
    }

    public int getCurrentStatus() {
        try {
            if (this.mRemoteService != null) {
                return this.mRemoteService.getCurrentStatus();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public int queryCurrentStatus() {
        try {
            if (this.mRemoteService != null) {
                int currentStatus = this.mRemoteService.getCurrentStatus();
                this.mRemoteService.su();
                return currentStatus;
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public String getCurrentGroupId() {
        try {
            if (this.mRemoteService != null) {
                return this.mRemoteService.getCurrentGroupId();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public String getCurrentUrl() {
        try {
            if (this.mRemoteService != null) {
                return this.mRemoteService.getCurrentUrl();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public void connectAndStartPublish(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && str3 != null && str4 != null) {
            if (this.mAccessToken == null) {
                UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_accesstoken_null_or_expire);
                a.ss().dy(TbadkApplication.getCurrentBduss());
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_TOKEN_EXPIRED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_TOKEN_EXPIRED), "");
            } else if (this.mUserId == null) {
                UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_user_not_login);
            } else {
                try {
                    if (this.mRemoteService != null) {
                        this.mRemoteService.a(str, str2, str3, str4, this.mAccessToken, this.mUserId);
                    }
                } catch (RemoteException e) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
                }
            }
        }
    }

    public void pausePublish(String str) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.pausePublish(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void resumePublish(String str) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.resumePublish(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void startRecordInPublish(String str) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.startRecordInPublish(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void stopRecordInPublish(String str) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.stopRecordInPublish(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void stopPublish(String str) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.o(str, false);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void startPlayLive(String str, String str2) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.c(str, str2, 0);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void pausePlayLive(String str) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.dD(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void resumePlayLive(String str) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.dE(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void startPlayRecord(String str, int i) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.c(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, str, i);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void stopPlayLive(String str) {
        this.mGroupStoppedForCall = null;
        this.mUrlStoppedForCall = null;
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.p(str, false);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void stopPlayRecord() {
        this.mGroupStoppedForCall = null;
        this.mUrlStoppedForCall = null;
        this.mStopPostionOfRecord = 0;
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.p(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, false);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void pausePlayRecord() {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.dD(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void resumePlayRecord() {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.dE(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void seekPlayRecord(int i) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.seekPlayRecord(i);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int getDurationOfRecord() {
        try {
            if (this.mRemoteService != null) {
                return this.mRemoteService.getDurationOfRecord();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public int getPositionOfRecord() {
        try {
            if (this.mRemoteService != null) {
                return this.mRemoteService.getPositionOfRecord();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public void retryPlay() {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.retryPlay();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int getRecordStatus() {
        try {
            if (this.mRemoteService != null) {
                return this.mRemoteService.getRecordStatus();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 1;
    }

    public int whatIsRunning() {
        try {
            if (this.mRemoteService != null) {
                return this.mRemoteService.whatIsRunning();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public void stopAnyRunning() {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.ax(false);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void playOrRecord(String str, String str2, String str3, String str4, boolean z) {
        if (str2 != null && str4 != null) {
            if (this.mAccessToken == null) {
                UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_accesstoken_null_or_expire);
                a.ss().dy(TbadkApplication.getCurrentBduss());
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_TOKEN_EXPIRED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_TOKEN_EXPIRED), "");
                broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_TOKEN_EXPIRED);
            } else if (this.mUserId == null) {
                UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_user_not_login);
                broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_USER_NULL);
            } else {
                try {
                    if (this.mRemoteService != null) {
                        this.mRemoteService.a(str, str2, str3, str4, this.mAccessToken, this.mUserId, z, false);
                    }
                } catch (RemoteException e) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
                }
            }
        }
    }

    public int getSignalStrength() {
        try {
            if (this.mRemoteService == null) {
                return 0;
            }
            return this.mRemoteService.getSignalStrength();
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
            return 0;
        }
    }

    public int getRecordTime() {
        try {
            if (this.mRemoteService == null) {
                return 0;
            }
            return this.mRemoteService.getRecordTime();
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublisherPaused(boolean z) {
        try {
            if (this.mRemoteService != null) {
                this.mRemoteService.setPublisherPaused(z);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastLiveStatusChanged(LiveStatusChangeMessage.LiveStatusData liveStatusData) {
        if (liveStatusData != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveStatusChangeMessage(liveStatusData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastLiveError(String str) {
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveErrorMessage(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPositionEvent(String str, int i, int i2) {
        PlayProgressChangedMessage playProgressChangedMessage = new PlayProgressChangedMessage(str);
        playProgressChangedMessage.setCurrentPosition(i2);
        playProgressChangedMessage.setDuration(i);
        MessageManager.getInstance().dispatchResponsedMessageToUI(playProgressChangedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGroup() {
        Intent intent;
        String string = TbadkApplication.m251getInst().getApp().getResources().getString(y.app_name);
        String string2 = TbadkApplication.m251getInst().getApp().getResources().getString(y.live_end_notify);
        if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
            intent = new Intent("com.baidu.tieba.live.HOTLIVELIST");
        } else {
            intent = new Intent("com.baidu.tieba.live.BACKUPHOTLIVELIST");
        }
        intent.setFlags(268435456);
        NotificationHelper.showNotification(TbadkApplication.m251getInst().getApp(), 22, string, string2, string, PendingIntent.getActivity(TbadkApplication.m251getInst().getApp(), y.app_name, intent, 134217728), false);
    }

    private void doBindRemoteService() {
        TbadkApplication.m251getInst().getApp().bindService(new Intent(LiveGroupManagerService.ACTION), this.servRemoteConnection, 1);
    }
}
