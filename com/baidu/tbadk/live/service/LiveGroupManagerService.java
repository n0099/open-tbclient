package com.baidu.tbadk.live.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.channelrtc.medialivesender.LiveNativeSender;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.channelrtc.medialivesender.OnStatusEventListener;
import com.baidu.channelrtc.medialivesender.OnUserCmdEventListener;
import com.baidu.channelrtc.medialivesender.UserCmdResponse;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import java.util.Timer;
/* loaded from: classes.dex */
public class LiveGroupManagerService extends Service implements OnStatusEventListener, OnUserCmdEventListener, LivePlayerControllerListener {
    public static final String ACTION = "com.baidu.tieba.im.live.service.BACKUPLiveGroup";
    private static final int CLOSE_PUBLISH_EVENT = 15;
    private static final int CONNECT_PUBLISH_EVENT = 10;
    private static final String CUSTOM_COMMAND_PAUSE_PUBLISH = "pausePublish";
    private static final String CUSTOM_COMMAND_RESUME_PUBLISH = "resumePublish";
    private static final String CUSTOM_COMMAND_START_RECORD = "startRecord";
    private static final String CUSTOM_COMMAND_STOP_RECORD = "stopRecord";
    private static final String DEV_TYPE = "2";
    private static final String IDENTITY_PUBLISHER = "1";
    private static final int PAUSE_PLAY_EVENT = 20;
    private static final int PAUSE_PUBLISH_EVENT = 11;
    private static final int RECORD_TIMER_INTERVAL = 1000;
    private static final int REQUEST_ERROR_EVENT = 2;
    private static final int REQUEST_PLAY_WARNING_EVENT = 5;
    private static final int REQUEST_PROGRESS_EVENT = 3;
    private static final int REQUEST_RECORDTIME_EVENT = 4;
    private static final int REQUEST_STATUS_EVENT = 1;
    private static final int RESUME_PLAY_EVENT = 21;
    private static final int RESUME_PUBLISH_EVENT = 12;
    private static final int SAMPLE_CHANNEL = 2;
    private static final int SAMPLE_RATE = 22050;
    private static final int SEEK_PLAY_RECORD_EVENT = 22;
    private static final int START_PLAY_EVENT = 18;
    private static final int START_PUBLISH_EVENT = 16;
    private static final int START_RECORD_PUBLISH_EVENT = 13;
    private static final int STOP_PLAY_EVENT = 19;
    private static final int STOP_PUBLISH_EVENT = 17;
    private static final int STOP_RECORD_PUBLISH_EVENT = 14;
    private static boolean mSystemSupport = false;
    private String mDeviceId;
    private String mGroupId;
    private int mPlayDuration;
    private int mPlayPosition;
    private Timer mRecordTimer;
    private String mStreamId;
    private String mUrl;
    private String mUserId;
    final RemoteCallbackList<d> mCallbacks = new RemoteCallbackList<>();
    private final b mBinder = new g(this);
    private final Handler mHandler = new h(this);
    private LiveSenderControl mLiveSenderControl = null;
    private LivePlayerControl mPlayerCtrl = null;
    private int mStatus = -1;
    private boolean mIsRecording = false;
    private boolean mIsRecordPaused = false;
    private int mRecordTime = 0;
    private int mCmdIdStartRecord = 0;
    private int mCmdIdStopRecord = 0;
    private String mAccessToken = null;
    private String mErrorPrompt = null;
    private boolean mExecStartOnceConnected = false;
    private boolean mIsPublisherPaused = false;
    private l argsToBeStarted = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        mSystemSupport = LiveSenderControl.checkSDKCap();
        if (!mSystemSupport) {
            this.mStatus = -1;
            this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_NOT_SUPPORT;
        } else {
            boolean z = true;
            try {
                if (PluginHelper.isOsArchARM()) {
                    System.loadLibrary(LiveNativeSender.FFMPEGLIB);
                    System.loadLibrary(LiveNativeSender.AUDIOENGINE);
                    System.loadLibrary(LiveNativeSender.LIVESENDER);
                    System.loadLibrary("liveplayer");
                } else {
                    PluginCenter.getInstance().loadNativeLibrary(PluginNameList.NAME_LIVE, LiveNativeSender.FFMPEGLIB);
                    PluginCenter.getInstance().loadNativeLibrary(PluginNameList.NAME_LIVE, LiveNativeSender.AUDIOENGINE);
                    PluginCenter.getInstance().loadNativeLibrary(PluginNameList.NAME_LIVE, LiveNativeSender.LIVESENDER);
                    PluginCenter.getInstance().loadNativeLibrary(PluginNameList.NAME_LIVE, "liveplayer");
                }
            } catch (UnsatisfiedLinkError e) {
                z = false;
            }
            if (!z) {
                this.mStatus = -1;
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_NOT_SUPPORT;
            } else {
                this.mStatus = 0;
                this.mLiveSenderControl = new LiveSenderControl();
                this.mLiveSenderControl.setEventListener(this);
                this.mLiveSenderControl.setUserCmdListener(this);
                this.mPlayerCtrl = new LivePlayerControl();
                this.mPlayerCtrl.setControllerListener(this);
                if (TbadkApplication.m251getInst().isDebugMode()) {
                    this.mLiveSenderControl.setLogLevel(3);
                    this.mPlayerCtrl.setLogLevel(Constants.LOGLEVEL.LOG_LEVEL_I);
                }
            }
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(4);
        this.mHandler.removeMessages(5);
        this.mHandler.removeMessages(10);
        this.mHandler.removeMessages(11);
        this.mHandler.removeMessages(12);
        this.mHandler.removeMessages(13);
        this.mHandler.removeMessages(14);
        this.mHandler.removeMessages(15);
        this.mHandler.removeMessages(16);
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(18);
        this.mHandler.removeMessages(19);
        this.mHandler.removeMessages(20);
        this.mHandler.removeMessages(21);
        this.mHandler.removeMessages(22);
    }

    @Override // com.baidu.channelrtc.medialivesender.OnUserCmdEventListener
    public void onCmdErrorReport(UserCmdResponse userCmdResponse) {
    }

    @Override // com.baidu.channelrtc.medialivesender.OnUserCmdEventListener
    public void onCmdResultReport(UserCmdResponse userCmdResponse) {
        if (userCmdResponse.getCallID() != this.mCmdIdStartRecord && userCmdResponse.getCallID() == this.mCmdIdStopRecord) {
        }
    }

    @Override // com.baidu.channelrtc.medialivesender.OnStatusEventListener
    public void onErrorReport(int i) {
        switch (i) {
            case -100:
            case -4:
                return;
            case com.baidu.channelrtc.medialivesender.Constants.ERROR_OPEN_CONNECTION /* -8 */:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_CONNECTION_CLOSED;
                break;
            case -7:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_TOKEN_EXPIRED;
                break;
            case -6:
            case -5:
            case -3:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_CREATE_ENGINE_FAILED;
                try {
                    this.mBinder.o(this.mGroupId, false);
                    break;
                } catch (RemoteException e) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    break;
                }
            case -2:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_START_PUB;
                try {
                    this.mBinder.o(this.mGroupId, false);
                    break;
                } catch (RemoteException e2) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e2.getMessage());
                    break;
                }
            case -1:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_CONNECT_PREPARE;
                break;
        }
        this.mHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.channelrtc.medialivesender.OnStatusEventListener
    public void onStatusReport(int i) {
        switch (i) {
            case 100:
                if (this.mStatus != 0) {
                    this.mStatus = 0;
                    this.mGroupId = "";
                    this.mUrl = "";
                    this.mHandler.sendEmptyMessage(1);
                    if (this.argsToBeStarted != null && !StringUtils.isNull(this.argsToBeStarted.groupId)) {
                        try {
                            this.mBinder.a(this.argsToBeStarted.streamId, this.argsToBeStarted.groupId, this.argsToBeStarted.Vy, this.argsToBeStarted.url, this.argsToBeStarted.accessToken, this.argsToBeStarted.userId, false, false);
                        } catch (RemoteException e) {
                            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                        }
                        this.argsToBeStarted = null;
                        return;
                    }
                    return;
                }
                return;
            case 101:
            default:
                return;
            case 102:
                if (this.mStatus != 2) {
                    this.mStatus = 2;
                    if (this.mExecStartOnceConnected) {
                        this.mExecStartOnceConnected = false;
                        try {
                            this.mBinder.dC(this.mGroupId);
                        } catch (RemoteException e2) {
                            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e2.getMessage());
                        }
                    }
                    this.mHandler.sendEmptyMessage(1);
                    return;
                }
                return;
            case 103:
                if (this.mStatus != 3) {
                    this.mStatus = 3;
                    this.mHandler.sendEmptyMessage(1);
                    return;
                }
                return;
            case 104:
                if (this.mStatus != 4) {
                    this.mStatus = 4;
                    this.mHandler.sendEmptyMessage(1);
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onCacheStatusChanged(LivePlayerControl.CACHE_STATUS cache_status) {
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onCachingUpdate(int i) {
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onDurationUpdate(int i) {
        this.mPlayDuration = i;
        this.mHandler.sendEmptyMessage(3);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onPositionUpdate(int i) {
        this.mPlayPosition = i;
        this.mHandler.sendEmptyMessage(3);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onError(int i) {
        switch (i) {
            case -102:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_PLAY_NET_ERROR;
                try {
                    this.mBinder.p(this.mGroupId, false);
                    break;
                } catch (RemoteException e) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    break;
                }
            case -101:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_PLAY_INVALID_CODEC;
                try {
                    this.mBinder.p(this.mGroupId, false);
                    break;
                } catch (RemoteException e2) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e2.getMessage());
                    break;
                }
            case -100:
                this.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_PLAY_FILE_ERROR;
                try {
                    this.mBinder.p(this.mGroupId, false);
                    break;
                } catch (RemoteException e3) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e3.getMessage());
                    break;
                }
            default:
                this.mErrorPrompt = "Error in LivePlay #: " + i;
                break;
        }
        this.mHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onPlayStatusChanged(LivePlayerControl.PLAYER_STATUS player_status, int i, int i2) {
        if (player_status == LivePlayerControl.PLAYER_STATUS.PLAYER_STOPPED || player_status == LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE) {
            if (this.mStatus != 0) {
                this.mGroupId = "";
                this.mUrl = "";
                this.mStatus = 0;
                this.mHandler.sendEmptyMessage(1);
                if (this.argsToBeStarted != null && !StringUtils.isNull(this.argsToBeStarted.groupId)) {
                    try {
                        this.mBinder.a(this.argsToBeStarted.streamId, this.argsToBeStarted.groupId, this.argsToBeStarted.Vy, this.argsToBeStarted.url, this.argsToBeStarted.accessToken, this.argsToBeStarted.userId, false, false);
                    } catch (RemoteException e) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    }
                    this.argsToBeStarted = null;
                }
            }
        } else if (player_status == LivePlayerControl.PLAYER_STATUS.PLAYER_INIT || player_status == LivePlayerControl.PLAYER_STATUS.PLAYER_PREPARED) {
            if (this.mStatus != 18) {
                this.mStatus = 18;
                this.mHandler.sendEmptyMessage(1);
            }
        } else if (player_status == LivePlayerControl.PLAYER_STATUS.PLAYER_PLAYING) {
            if (this.mStatus != 19) {
                this.mStatus = 19;
                this.mIsPublisherPaused = false;
                this.mHandler.sendEmptyMessage(1);
            }
        } else if (player_status == LivePlayerControl.PLAYER_STATUS.PLAYER_PAUSED) {
            if (this.mStatus != 20) {
                this.mStatus = 20;
                this.mHandler.sendEmptyMessage(1);
            }
        } else if (player_status == LivePlayerControl.PLAYER_STATUS.PLAYER_COMPLETE && this.mStatus != 17) {
            this.mStatus = 17;
            this.mHandler.sendEmptyMessage(1);
            if (this.mPlayerCtrl != null) {
                this.mPlayerCtrl.exit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastLiveStatusChanged() {
        LiveStatusParcelable liveStatusParcelable = new LiveStatusParcelable();
        liveStatusParcelable.groupId = this.mGroupId;
        liveStatusParcelable.status = this.mStatus;
        liveStatusParcelable.url = this.mUrl;
        liveStatusParcelable.errorString = this.mErrorPrompt;
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                this.mCallbacks.getBroadcastItem(i).a(liveStatusParcelable);
            } catch (RemoteException e) {
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                try {
                    this.mBinder.ax(false);
                } catch (RemoteException e2) {
                }
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastLiveError() {
        if (this.mErrorPrompt != null) {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    this.mCallbacks.getBroadcastItem(i).dB(this.mErrorPrompt);
                } catch (RemoteException e) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    try {
                        this.mBinder.ax(false);
                    } catch (RemoteException e2) {
                    }
                }
            }
            this.mErrorPrompt = null;
            this.mCallbacks.finishBroadcast();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPlayProgressEvent() {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                this.mCallbacks.getBroadcastItem(i).e(this.mUrl, this.mPlayDuration, this.mPlayPosition);
            } catch (RemoteException e) {
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                try {
                    this.mBinder.ax(false);
                } catch (RemoteException e2) {
                }
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRecordTimeEvent(int i) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                this.mCallbacks.getBroadcastItem(i2).cU(i);
            } catch (RemoteException e) {
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                try {
                    this.mBinder.ax(false);
                } catch (RemoteException e2) {
                }
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastPlayWarningEvent(int i) {
        if (this.mStatus != 19 || !this.mIsPublisherPaused) {
            if (this.mStatus == 19 || this.mStatus == 18) {
                int beginBroadcast = this.mCallbacks.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        this.mCallbacks.getBroadcastItem(i2).cV(i);
                    } catch (RemoteException e) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                        try {
                            this.mBinder.ax(false);
                        } catch (RemoteException e2) {
                        }
                    }
                }
                this.mCallbacks.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onDebugInfoUpdate(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean compareUrlsBeforeQuestionMark(String str, String str2) {
        int indexOf;
        int indexOf2;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || (indexOf = str.indexOf(63)) != (indexOf2 = str2.indexOf(63))) {
            return false;
        }
        if (indexOf == -1) {
            return str.equals(str2);
        }
        return str.substring(0, indexOf).equals(str2.substring(0, indexOf2));
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControllerListener
    public void onWarning(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, i));
    }
}
