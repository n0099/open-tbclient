package com.baidu.tbadk.live.service;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
/* loaded from: classes.dex */
class g extends b {
    final /* synthetic */ LiveGroupManagerService abB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LiveGroupManagerService liveGroupManagerService) {
        this.abB = liveGroupManagerService;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void a(d dVar) {
        Handler handler;
        String str;
        Handler handler2;
        if (dVar != null) {
            this.abB.mCallbacks.register(dVar);
            handler = this.abB.mHandler;
            handler.sendEmptyMessage(1);
            str = this.abB.mErrorPrompt;
            if (str == null) {
                return;
            }
            handler2 = this.abB.mHandler;
            handler2.sendEmptyMessage(2);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void b(d dVar) {
        if (dVar != null) {
            this.abB.mCallbacks.unregister(dVar);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getCurrentStatus() {
        int i;
        i = this.abB.mStatus;
        return i;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void requestStatusRebroadcast() {
        Handler handler;
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(1);
    }

    @Override // com.baidu.tbadk.live.service.a
    public String getCurrentGroupId() {
        String str;
        str = this.abB.mGroupId;
        return str;
    }

    @Override // com.baidu.tbadk.live.service.a
    public String getCurrentUrl() {
        String str;
        str = this.abB.mUrl;
        return str;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void connectAndPublish(String str, String str2, String str3, String str4, String str5, String str6) {
        Handler handler;
        Handler handler2;
        l lVar = new l(null);
        lVar.streamId = str;
        lVar.groupId = str2;
        lVar.deviceId = str3;
        lVar.url = str4;
        lVar.accessToken = str5;
        lVar.userId = str6;
        handler = this.abB.mHandler;
        handler2 = this.abB.mHandler;
        handler.sendMessage(handler2.obtainMessage(10, lVar));
    }

    @Override // com.baidu.tbadk.live.service.a
    public void pausePublish(String str) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.abB.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(11);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void resumePublish(String str) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.abB.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(12);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void startRecordInPublish(String str) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.abB.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(13);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void stopRecordInPublish(String str) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.abB.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(14);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void closePublish(String str, boolean z) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.abB.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(15);
        if (!z) {
            NotificationHelper.cancelNotification(this.abB, 20);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void startPublish(String str) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.abB.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(16);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void stopPublish(String str) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.abB.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(17);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void startPlay(String str, String str2, int i) {
        LivePlayerControl livePlayerControl;
        Handler handler;
        Handler handler2;
        if (str == null || str2 == null) {
            return;
        }
        livePlayerControl = this.abB.mPlayerCtrl;
        if (livePlayerControl != null) {
            k kVar = new k(null);
            kVar.groupId = str;
            kVar.url = str2;
            kVar.startPos = i;
            handler = this.abB.mHandler;
            handler2 = this.abB.mHandler;
            handler.sendMessage(handler2.obtainMessage(18, kVar));
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void stopPlay(String str, boolean z) {
        String str2;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(19);
        if (!z && !LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            NotificationHelper.cancelNotification(this.abB, 20);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void pausePlay(String str) {
        String str2;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(20);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void resumePlay(String str) {
        String str2;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.abB.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.abB.mHandler;
        handler.sendEmptyMessage(21);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void seekPlayRecord(int i) {
        Handler handler;
        Handler handler2;
        handler = this.abB.mHandler;
        handler2 = this.abB.mHandler;
        handler.sendMessage(handler2.obtainMessage(22, i, i));
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getDurationOfRecord() {
        String str;
        LivePlayerControl livePlayerControl;
        LivePlayerControl livePlayerControl2;
        int i;
        str = this.abB.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            livePlayerControl = this.abB.mPlayerCtrl;
            if (livePlayerControl != null) {
                LiveGroupManagerService liveGroupManagerService = this.abB;
                livePlayerControl2 = this.abB.mPlayerCtrl;
                liveGroupManagerService.mPlayDuration = livePlayerControl2.getDuration();
                i = this.abB.mPlayDuration;
                return i;
            }
        }
        return 0;
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getPositionOfRecord() {
        String str;
        LivePlayerControl livePlayerControl;
        LivePlayerControl livePlayerControl2;
        int i;
        str = this.abB.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            livePlayerControl = this.abB.mPlayerCtrl;
            if (livePlayerControl != null) {
                LiveGroupManagerService liveGroupManagerService = this.abB;
                livePlayerControl2 = this.abB.mPlayerCtrl;
                liveGroupManagerService.mPlayPosition = livePlayerControl2.getCurrentPosition();
                i = this.abB.mPlayPosition;
                return i;
            }
        }
        return 0;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void retryPlay() {
        int i;
        String str;
        String str2;
        int i2;
        i = this.abB.mStatus;
        if (i != 19) {
            i2 = this.abB.mStatus;
            if (i2 != 18) {
                return;
            }
        }
        str = this.abB.mGroupId;
        str2 = this.abB.mUrl;
        playOrRecord(null, str, null, str2, null, null, true, true);
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getRecordStatus() {
        int i;
        boolean z;
        int i2;
        i = this.abB.mStatus;
        if (i != 3) {
            i2 = this.abB.mStatus;
            if (i2 != 4) {
                return 1;
            }
        }
        z = this.abB.mIsRecording;
        return !z ? 2 : 3;
    }

    @Override // com.baidu.tbadk.live.service.a
    public int whatIsRunning() {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        i = this.abB.mStatus;
        if (i >= 1) {
            i4 = this.abB.mStatus;
            if (i4 < 17) {
                return 1;
            }
        }
        i2 = this.abB.mStatus;
        if (i2 < 17) {
            i3 = this.abB.mStatus;
            if (i3 == 0) {
                return 0;
            }
            return -1;
        }
        str = this.abB.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            return 3;
        }
        return 2;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void stopAnyRunning(boolean z) {
        String str;
        String str2;
        switch (whatIsRunning()) {
            case 1:
                str2 = this.abB.mGroupId;
                closePublish(str2, z);
                return;
            case 2:
            case 3:
                str = this.abB.mGroupId;
                stopPlay(str, z);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void playOrRecord(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        int i;
        int i2;
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
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
        i = this.abB.mStatus;
        if (i == -1) {
            return;
        }
        i2 = this.abB.mStatus;
        if (i2 != 0) {
            if (!z) {
                str7 = this.abB.mGroupId;
                if (str2.equals(str7)) {
                    str8 = this.abB.mUrl;
                    compareUrlsBeforeQuestionMark = LiveGroupManagerService.compareUrlsBeforeQuestionMark(str4, str8);
                    if (compareUrlsBeforeQuestionMark) {
                        i3 = this.abB.mStatus;
                        if (i3 != 4) {
                            i4 = this.abB.mStatus;
                            if (i4 != 20) {
                                return;
                            }
                            str9 = this.abB.mGroupId;
                            resumePlay(str9);
                            return;
                        }
                        str10 = this.abB.mGroupId;
                        resumePublish(str10);
                        return;
                    }
                }
            }
            stopAnyRunning(z2);
            this.abB.argsToBeStarted = new l(null);
            lVar = this.abB.argsToBeStarted;
            lVar.groupId = str2;
            lVar2 = this.abB.argsToBeStarted;
            lVar2.url = str4;
            lVar3 = this.abB.argsToBeStarted;
            lVar3.streamId = str;
            lVar4 = this.abB.argsToBeStarted;
            lVar4.deviceId = str3;
            lVar5 = this.abB.argsToBeStarted;
            lVar5.accessToken = str5;
            lVar6 = this.abB.argsToBeStarted;
            lVar6.userId = str6;
        } else if (StringUtils.isNull(str)) {
            startPlay(str2, str4, 0);
        } else {
            connectAndPublish(str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getSignalStrength() {
        int i;
        int i2;
        LivePlayerControl livePlayerControl;
        LivePlayerControl livePlayerControl2;
        LiveSenderControl liveSenderControl;
        LiveSenderControl liveSenderControl2;
        i = this.abB.mStatus;
        if (i == 3) {
            liveSenderControl = this.abB.mLiveSenderControl;
            if (liveSenderControl != null) {
                liveSenderControl2 = this.abB.mLiveSenderControl;
                return liveSenderControl2.querySignalStrength();
            }
        }
        i2 = this.abB.mStatus;
        if (i2 == 19) {
            livePlayerControl = this.abB.mPlayerCtrl;
            if (livePlayerControl != null) {
                livePlayerControl2 = this.abB.mPlayerCtrl;
                return livePlayerControl2.getSignalStrength();
            }
        }
        return 0;
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getRecordTime() {
        int i;
        i = this.abB.mRecordTime;
        return i;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void setPublisherPaused(boolean z) {
        int i;
        i = this.abB.mStatus;
        if (i != 19) {
            return;
        }
        this.abB.mIsPublisherPaused = z;
    }
}
