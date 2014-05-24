package com.baidu.tieba.im.live;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.live.LiveErrorMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tieba.im.live.service.ILiveGroupManagerService;
import com.baidu.tieba.im.live.service.IRemoteCallback;
import com.baidu.tieba.im.live.service.LiveGroupManagerService;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b {
    public static b a = new b();
    private String d;
    private final String b = "LiveGroupManager";
    private String c = null;
    private boolean e = false;
    private String f = null;
    private String g = null;
    private int h = 0;
    private k i = null;
    private CustomMessageListener j = new c(this, MessageTypes.CMD_LIVE_STATUS_REQUEST);
    private CustomMessageListener k = new d(this, MessageTypes.CMD_ACCESS_TOKEN_UPDATED);
    private CustomMessageListener l = new e(this, MessageTypes.CMD_NETWORK_CHANGE);
    private final CustomMessageListener m = new f(this, MessageTypes.CMD_LIVE_CHAT_ROOM_EVENT);
    private final CustomMessageListener n = new g(this, MessageTypes.CMD_EXIT_APP);
    private ILiveGroupManagerService o = null;
    private IRemoteCallback p = new h(this);
    private Handler q = new i(this);
    private ServiceConnection r = new j(this);

    public void a() {
        if (a != null) {
            BdLog.d("onAccountChanged, and init flag is " + this.e);
            if (this.e) {
                s();
                this.d = TbadkApplication.getCurrentAccount();
                String currentBduss = TbadkApplication.getCurrentBduss();
                if (currentBduss != null) {
                    AccessTokenManager.getInstance().getAccesssTokenInBackground(currentBduss);
                } else {
                    this.c = null;
                }
            }
        }
    }

    private b() {
    }

    public static b b() {
        return a;
    }

    public void c() {
        if (!this.e) {
            BdLog.addLogPackage("com.baidu.tieba.im.live.LiveGroupManager");
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.k);
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().registerListener(this.m);
            MessageManager.getInstance().registerListener(this.n);
            AccessTokenManager.getInstance().getAccesssTokenInBackground(TbadkApplication.getCurrentBduss());
            this.d = TbadkApplication.getCurrentAccount();
            u();
            f();
            this.e = true;
        }
    }

    public void d() {
        if (this.f == null) {
            int g = g();
            BdLog.e("Got incoming call when live status is: " + g);
            if (g == 3) {
                a(i());
            } else if (g == 19) {
                String i = i();
                String j = j();
                if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.f)) {
                    int o = o();
                    k();
                    this.h = o;
                } else {
                    d(i);
                }
                this.f = i;
                this.g = j;
            }
        }
    }

    public void e() {
        BdLog.e("Got callEnd when live status is: " + g());
        if (this.f != null && this.g != null) {
            if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.f)) {
                a(this.g, this.h);
            } else {
                a(this.f, this.g);
            }
        }
        this.f = null;
        this.g = null;
        this.h = 0;
    }

    public void f() {
        ((TelephonyManager) TbadkApplication.m252getInst().getApp().getSystemService("phone")).listen(new l(this, null), 32);
    }

    public void a(k kVar) {
        this.i = kVar;
    }

    public int g() {
        try {
            if (this.o != null) {
                return this.o.getCurrentStatus();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getCurrentStatus", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public int h() {
        try {
            if (this.o != null) {
                int currentStatus = this.o.getCurrentStatus();
                this.o.requestStatusRebroadcast();
                return currentStatus;
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "queryCurrentStatus", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public String i() {
        try {
            if (this.o != null) {
                return this.o.getCurrentGroupId();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getCurrentGroupId", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public String j() {
        try {
            if (this.o != null) {
                return this.o.getCurrentUrl();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getCurrentUrl", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public void a(String str) {
        try {
            if (this.o != null) {
                this.o.pausePublish(str);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "pausePublish", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void b(String str) {
        try {
            if (this.o != null) {
                this.o.startRecordInPublish(str);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "startRecordInPublish", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void c(String str) {
        try {
            if (this.o != null) {
                this.o.stopRecordInPublish(str);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopRecordInPublish", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, String str2) {
        try {
            if (this.o != null) {
                this.o.startPlay(str, str2, 0);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "startPlayLive", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, int i) {
        try {
            if (this.o != null) {
                this.o.startPlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, str, i);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "startPlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void d(String str) {
        BdLog.d("stopPlayLive groupId =" + str + " ; status= " + g());
        this.f = null;
        this.g = null;
        try {
            if (this.o != null) {
                this.o.stopPlay(str);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopPlayLive", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void k() {
        BdLog.d("stopPlayRecord status= " + g());
        this.f = null;
        this.g = null;
        this.h = 0;
        try {
            if (this.o != null) {
                this.o.stopPlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopPlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void l() {
        try {
            if (this.o != null) {
                this.o.pausePlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "pausePlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void m() {
        try {
            if (this.o != null) {
                this.o.resumePlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "resumePlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(int i) {
        try {
            if (this.o != null) {
                this.o.seekPlayRecord(i);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "seekPlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int n() {
        try {
            if (this.o != null) {
                return this.o.getDurationOfRecord();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getDurationOfRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public int o() {
        try {
            if (this.o != null) {
                return this.o.getPositionOfRecord();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getPositionOfRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public void p() {
        try {
            if (this.o != null) {
                this.o.retryPlay();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "retryPlay", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int q() {
        try {
            if (this.o != null) {
                return this.o.getRecordStatus();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getRecordStatus", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 1;
    }

    public int r() {
        try {
            if (this.o != null) {
                return this.o.whatIsRunning();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "whatIsRunning", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public void s() {
        BdLog.d("stopAnyRunning status= " + g());
        try {
            if (this.o != null) {
                this.o.stopAnyRunning();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopAnyRunning", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, String str2, String str3, String str4, boolean z) {
        if (str2 != null && str4 != null) {
            if (this.c == null) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_accesstoken_null_or_expire);
                AccessTokenManager.getInstance().getAccesssTokenInBackground(TbadkApplication.getCurrentBduss());
                BdLog.e("The access token is null yet.");
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_TOKEN_EXPIRED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_TOKEN_EXPIRED), "");
                e(LiveStatusChangeDefinition.ERROR_PROMPT_TOKEN_EXPIRED);
            } else if (this.d == null) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_user_not_login);
                BdLog.e("The user ID is null yet.");
                e(LiveStatusChangeDefinition.ERROR_PROMPT_USER_NULL);
            } else {
                BdLog.d("playOrRecord groupId = " + str2 + "; status= " + g() + "; stopCurrent= " + z);
                try {
                    if (this.o != null) {
                        this.o.playOrRecord(str, str2, str3, str4, this.c, this.d, z);
                    }
                } catch (RemoteException e) {
                    BdLog.e("LiveGroupManager", "playOrRecord", e);
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
                }
            }
        }
    }

    public int t() {
        try {
            if (this.o == null) {
                return 0;
            }
            return this.o.getRecordTime();
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getRecordTime", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        BdLog.d("setPublisherPaused: " + z);
        try {
            if (this.o != null) {
                this.o.setPublisherPaused(z);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "setPublisherPaused", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveStatusChangeMessage.LiveStatusData liveStatusData) {
        if (liveStatusData != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveStatusChangeMessage(liveStatusData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveErrorMessage(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        PlayProgressChangedMessage playProgressChangedMessage = new PlayProgressChangedMessage(str);
        playProgressChangedMessage.setCurrentPosition(i2);
        playProgressChangedMessage.setDuration(i);
        MessageManager.getInstance().dispatchResponsedMessageToUI(playProgressChangedMessage);
    }

    private void u() {
        TbadkApplication.m252getInst().getApp().bindService(new Intent(LiveGroupManagerService.ACTION), this.r, 1);
    }
}
