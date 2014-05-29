package com.baidu.tieba.im.live.service;

import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tieba.im.live.service.ILiveGroupManagerService;
/* loaded from: classes.dex */
class a extends ILiveGroupManagerService.Stub {
    final /* synthetic */ LiveGroupManagerService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LiveGroupManagerService liveGroupManagerService) {
        this.a = liveGroupManagerService;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void registerCallback(IRemoteCallback iRemoteCallback) {
        Handler handler;
        String str;
        Handler handler2;
        if (iRemoteCallback != null) {
            this.a.mCallbacks.register(iRemoteCallback);
            handler = this.a.mHandler;
            handler.sendEmptyMessage(1);
            str = this.a.mErrorPrompt;
            if (str == null) {
                return;
            }
            handler2 = this.a.mHandler;
            handler2.sendEmptyMessage(2);
        }
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void unregisterCallback(IRemoteCallback iRemoteCallback) {
        if (iRemoteCallback != null) {
            this.a.mCallbacks.unregister(iRemoteCallback);
        }
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public int getCurrentStatus() {
        int i;
        i = this.a.mStatus;
        return i;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void requestStatusRebroadcast() {
        Handler handler;
        handler = this.a.mHandler;
        handler.sendEmptyMessage(1);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public String getCurrentGroupId() {
        String str;
        str = this.a.mGroupId;
        return str;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public String getCurrentUrl() {
        String str;
        str = this.a.mUrl;
        return str;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void connectAndPublish(String str, String str2, String str3, String str4, String str5, String str6) {
        int i;
        Handler handler;
        Handler handler2;
        StringBuilder sb = new StringBuilder("connectAndStartPublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).toString());
        f fVar = new f(null);
        fVar.a = str;
        fVar.b = str2;
        fVar.c = str3;
        fVar.d = str4;
        fVar.e = str5;
        fVar.f = str6;
        handler = this.a.mHandler;
        handler2 = this.a.mHandler;
        handler.sendMessage(handler2.obtainMessage(10, fVar));
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void pausePublish(String str) {
        int i;
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        StringBuilder sb = new StringBuilder("pausePublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.a.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(11);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void resumePublish(String str) {
        int i;
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        StringBuilder sb = new StringBuilder("resumePublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.a.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(12);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void startRecordInPublish(String str) {
        int i;
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        StringBuilder sb = new StringBuilder("startRecordInPublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.a.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(13);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void stopRecordInPublish(String str) {
        int i;
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        StringBuilder sb = new StringBuilder("stopRecordInPublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.a.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(14);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void closePublish(String str, boolean z) {
        int i;
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        StringBuilder sb = new StringBuilder("closePublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.a.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(15);
        if (!z) {
            try {
                ((NotificationManager) this.a.getSystemService("notification")).cancel(20);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void startPublish(String str) {
        int i;
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        StringBuilder sb = new StringBuilder("startPublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.a.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(16);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void stopPublish(String str) {
        int i;
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        StringBuilder sb = new StringBuilder("stopPublish in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.a.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(17);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void startPlay(String str, String str2, int i) {
        int i2;
        LivePlayerControl livePlayerControl;
        Handler handler;
        Handler handler2;
        StringBuilder append = new StringBuilder("startPlay URL:").append(str2).append(" in status: ");
        i2 = this.a.mStatus;
        BdLog.d(append.append(i2).append(" startPos: ").append(i).toString());
        if (str == null || str2 == null) {
            return;
        }
        livePlayerControl = this.a.mPlayerCtrl;
        if (livePlayerControl != null) {
            e eVar = new e(null);
            eVar.a = str;
            eVar.b = str2;
            eVar.c = i;
            handler = this.a.mHandler;
            handler2 = this.a.mHandler;
            handler.sendMessage(handler2.obtainMessage(18, eVar));
        }
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void stopPlay(String str, boolean z) {
        int i;
        String str2;
        Handler handler;
        StringBuilder sb = new StringBuilder("stopPlay in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(19);
        if (!z && !LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            try {
                ((NotificationManager) this.a.getSystemService("notification")).cancel(20);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void pausePlay(String str) {
        int i;
        String str2;
        Handler handler;
        StringBuilder sb = new StringBuilder("pausePlay in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(20);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void resumePlay(String str) {
        int i;
        String str2;
        Handler handler;
        StringBuilder sb = new StringBuilder("resumePlay in status: ");
        i = this.a.mStatus;
        BdLog.d(sb.append(i).append("group: ").append(str).toString());
        if (str == null) {
            return;
        }
        str2 = this.a.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.a.mHandler;
        handler.sendEmptyMessage(21);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void seekPlayRecord(int i) {
        Handler handler;
        Handler handler2;
        BdLog.d("seekPlayRecord to: " + i);
        handler = this.a.mHandler;
        handler2 = this.a.mHandler;
        handler.sendMessage(handler2.obtainMessage(22, i, i));
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public int getDurationOfRecord() {
        String str;
        LivePlayerControl livePlayerControl;
        LivePlayerControl livePlayerControl2;
        int i;
        str = this.a.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            livePlayerControl = this.a.mPlayerCtrl;
            if (livePlayerControl != null) {
                LiveGroupManagerService liveGroupManagerService = this.a;
                livePlayerControl2 = this.a.mPlayerCtrl;
                liveGroupManagerService.mPlayDuration = livePlayerControl2.getDuration();
                i = this.a.mPlayDuration;
                return i;
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public int getPositionOfRecord() {
        String str;
        LivePlayerControl livePlayerControl;
        LivePlayerControl livePlayerControl2;
        int i;
        str = this.a.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            livePlayerControl = this.a.mPlayerCtrl;
            if (livePlayerControl != null) {
                LiveGroupManagerService liveGroupManagerService = this.a;
                livePlayerControl2 = this.a.mPlayerCtrl;
                liveGroupManagerService.mPlayPosition = livePlayerControl2.getCurrentPosition();
                i = this.a.mPlayPosition;
                return i;
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void retryPlay() {
        int i;
        String str;
        String str2;
        int i2;
        i = this.a.mStatus;
        if (i != 19) {
            i2 = this.a.mStatus;
            if (i2 != 18) {
                return;
            }
        }
        str = this.a.mGroupId;
        str2 = this.a.mUrl;
        playOrRecord(null, str, null, str2, null, null, true, true);
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public int getRecordStatus() {
        int i;
        boolean z;
        int i2;
        i = this.a.mStatus;
        if (i != 3) {
            i2 = this.a.mStatus;
            if (i2 != 4) {
                return 1;
            }
        }
        z = this.a.mIsRecording;
        return !z ? 2 : 3;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public int whatIsRunning() {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        i = this.a.mStatus;
        if (i >= 1) {
            i4 = this.a.mStatus;
            if (i4 < 17) {
                return 1;
            }
        }
        i2 = this.a.mStatus;
        if (i2 < 17) {
            i3 = this.a.mStatus;
            if (i3 == 0) {
                return 0;
            }
            return -1;
        }
        str = this.a.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            return 3;
        }
        return 2;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void stopAnyRunning(boolean z) {
        String str;
        String str2;
        switch (whatIsRunning()) {
            case 1:
                str2 = this.a.mGroupId;
                closePublish(str2, z);
                return;
            case 2:
            case 3:
                str = this.a.mGroupId;
                stopPlay(str, z);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void playOrRecord(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        int i;
        int i2;
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        f fVar6;
        String str7;
        String str8;
        boolean compareUrlsBeforeQuestionMark;
        int i3;
        int i4;
        String str9;
        String str10;
        if (str2 == null || str4 == null) {
            return;
        }
        i = this.a.mStatus;
        if (i == -1) {
            return;
        }
        i2 = this.a.mStatus;
        if (i2 != 0) {
            if (!z) {
                str7 = this.a.mGroupId;
                if (str2.equals(str7)) {
                    str8 = this.a.mUrl;
                    compareUrlsBeforeQuestionMark = LiveGroupManagerService.compareUrlsBeforeQuestionMark(str4, str8);
                    if (compareUrlsBeforeQuestionMark) {
                        i3 = this.a.mStatus;
                        if (i3 != 4) {
                            i4 = this.a.mStatus;
                            if (i4 != 20) {
                                return;
                            }
                            str9 = this.a.mGroupId;
                            resumePlay(str9);
                            return;
                        }
                        str10 = this.a.mGroupId;
                        resumePublish(str10);
                        return;
                    }
                }
            }
            stopAnyRunning(z2);
            this.a.argsToBeStarted = new f(null);
            fVar = this.a.argsToBeStarted;
            fVar.b = str2;
            fVar2 = this.a.argsToBeStarted;
            fVar2.d = str4;
            fVar3 = this.a.argsToBeStarted;
            fVar3.a = str;
            fVar4 = this.a.argsToBeStarted;
            fVar4.c = str3;
            fVar5 = this.a.argsToBeStarted;
            fVar5.e = str5;
            fVar6 = this.a.argsToBeStarted;
            fVar6.f = str6;
        } else if (StringUtils.isNull(str)) {
            startPlay(str2, str4, 0);
        } else {
            connectAndPublish(str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public int getSignalStrength() {
        int i;
        int i2;
        LivePlayerControl livePlayerControl;
        LivePlayerControl livePlayerControl2;
        LiveSenderControl liveSenderControl;
        LiveSenderControl liveSenderControl2;
        i = this.a.mStatus;
        if (i == 3) {
            liveSenderControl = this.a.mLiveSenderControl;
            if (liveSenderControl != null) {
                liveSenderControl2 = this.a.mLiveSenderControl;
                return liveSenderControl2.querySignalStrength();
            }
        }
        i2 = this.a.mStatus;
        if (i2 == 19) {
            livePlayerControl = this.a.mPlayerCtrl;
            if (livePlayerControl != null) {
                livePlayerControl2 = this.a.mPlayerCtrl;
                return livePlayerControl2.getSignalStrength();
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public int getRecordTime() {
        int i;
        i = this.a.mRecordTime;
        return i;
    }

    @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
    public void setPublisherPaused(boolean z) {
        int i;
        i = this.a.mStatus;
        if (i != 19) {
            return;
        }
        this.a.mIsPublisherPaused = z;
    }
}
