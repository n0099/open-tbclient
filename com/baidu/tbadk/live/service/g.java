package com.baidu.tbadk.live.service;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
/* loaded from: classes.dex */
class g extends b {
    final /* synthetic */ LiveGroupManagerService Vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LiveGroupManagerService liveGroupManagerService) {
        this.Vz = liveGroupManagerService;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void a(d dVar) {
        Handler handler;
        String str;
        Handler handler2;
        if (dVar != null) {
            this.Vz.mCallbacks.register(dVar);
            handler = this.Vz.mHandler;
            handler.sendEmptyMessage(1);
            str = this.Vz.mErrorPrompt;
            if (str == null) {
                return;
            }
            handler2 = this.Vz.mHandler;
            handler2.sendEmptyMessage(2);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void b(d dVar) {
        if (dVar != null) {
            this.Vz.mCallbacks.unregister(dVar);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getCurrentStatus() {
        int i;
        i = this.Vz.mStatus;
        return i;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void sw() {
        Handler handler;
        handler = this.Vz.mHandler;
        handler.sendEmptyMessage(1);
    }

    @Override // com.baidu.tbadk.live.service.a
    public String getCurrentGroupId() {
        String str;
        str = this.Vz.mGroupId;
        return str;
    }

    @Override // com.baidu.tbadk.live.service.a
    public String getCurrentUrl() {
        String str;
        str = this.Vz.mUrl;
        return str;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        Handler handler;
        Handler handler2;
        l lVar = new l(null);
        lVar.streamId = str;
        lVar.groupId = str2;
        lVar.VC = str3;
        lVar.url = str4;
        lVar.accessToken = str5;
        lVar.userId = str6;
        handler = this.Vz.mHandler;
        handler2 = this.Vz.mHandler;
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
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.Vz.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.Vz.mHandler;
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
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.Vz.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.Vz.mHandler;
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
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.Vz.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.Vz.mHandler;
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
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.Vz.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.Vz.mHandler;
        handler.sendEmptyMessage(14);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void o(String str, boolean z) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.Vz.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.Vz.mHandler;
        handler.sendEmptyMessage(15);
        if (!z) {
            NotificationHelper.cancelNotification(this.Vz, 20);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void dC(String str) {
        String str2;
        LiveSenderControl liveSenderControl;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.Vz.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.Vz.mHandler;
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
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        liveSenderControl = this.Vz.mLiveSenderControl;
        if (liveSenderControl == null) {
            return;
        }
        handler = this.Vz.mHandler;
        handler.sendEmptyMessage(17);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void c(String str, String str2, int i) {
        LivePlayerControl livePlayerControl;
        Handler handler;
        Handler handler2;
        if (str == null || str2 == null) {
            return;
        }
        livePlayerControl = this.Vz.mPlayerCtrl;
        if (livePlayerControl != null) {
            k kVar = new k(null);
            kVar.groupId = str;
            kVar.url = str2;
            kVar.VB = i;
            handler = this.Vz.mHandler;
            handler2 = this.Vz.mHandler;
            handler.sendMessage(handler2.obtainMessage(18, kVar));
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void p(String str, boolean z) {
        String str2;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.Vz.mHandler;
        handler.sendEmptyMessage(19);
        if (!z && !LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            NotificationHelper.cancelNotification(this.Vz, 20);
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void dD(String str) {
        String str2;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.Vz.mHandler;
        handler.sendEmptyMessage(20);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void dE(String str) {
        String str2;
        Handler handler;
        if (str == null) {
            return;
        }
        str2 = this.Vz.mGroupId;
        if (!str.equals(str2)) {
            return;
        }
        handler = this.Vz.mHandler;
        handler.sendEmptyMessage(21);
    }

    @Override // com.baidu.tbadk.live.service.a
    public void seekPlayRecord(int i) {
        Handler handler;
        Handler handler2;
        handler = this.Vz.mHandler;
        handler2 = this.Vz.mHandler;
        handler.sendMessage(handler2.obtainMessage(22, i, i));
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getDurationOfRecord() {
        String str;
        LivePlayerControl livePlayerControl;
        LivePlayerControl livePlayerControl2;
        int i;
        str = this.Vz.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            livePlayerControl = this.Vz.mPlayerCtrl;
            if (livePlayerControl != null) {
                LiveGroupManagerService liveGroupManagerService = this.Vz;
                livePlayerControl2 = this.Vz.mPlayerCtrl;
                liveGroupManagerService.mPlayDuration = livePlayerControl2.getDuration();
                i = this.Vz.mPlayDuration;
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
        str = this.Vz.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            livePlayerControl = this.Vz.mPlayerCtrl;
            if (livePlayerControl != null) {
                LiveGroupManagerService liveGroupManagerService = this.Vz;
                livePlayerControl2 = this.Vz.mPlayerCtrl;
                liveGroupManagerService.mPlayPosition = livePlayerControl2.getCurrentPosition();
                i = this.Vz.mPlayPosition;
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
        i = this.Vz.mStatus;
        if (i != 19) {
            i2 = this.Vz.mStatus;
            if (i2 != 18) {
                return;
            }
        }
        str = this.Vz.mGroupId;
        str2 = this.Vz.mUrl;
        a(null, str, null, str2, null, null, true, true);
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getRecordStatus() {
        int i;
        boolean z;
        int i2;
        i = this.Vz.mStatus;
        if (i != 3) {
            i2 = this.Vz.mStatus;
            if (i2 != 4) {
                return 1;
            }
        }
        z = this.Vz.mIsRecording;
        return !z ? 2 : 3;
    }

    @Override // com.baidu.tbadk.live.service.a
    public int whatIsRunning() {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        i = this.Vz.mStatus;
        if (i >= 1) {
            i4 = this.Vz.mStatus;
            if (i4 < 17) {
                return 1;
            }
        }
        i2 = this.Vz.mStatus;
        if (i2 < 17) {
            i3 = this.Vz.mStatus;
            if (i3 == 0) {
                return 0;
            }
            return -1;
        }
        str = this.Vz.mGroupId;
        if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
            return 3;
        }
        return 2;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void ax(boolean z) {
        String str;
        String str2;
        switch (whatIsRunning()) {
            case 1:
                str2 = this.Vz.mGroupId;
                o(str2, z);
                return;
            case 2:
            case 3:
                str = this.Vz.mGroupId;
                p(str, z);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
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
        i = this.Vz.mStatus;
        if (i == -1) {
            return;
        }
        i2 = this.Vz.mStatus;
        if (i2 != 0) {
            if (!z) {
                str7 = this.Vz.mGroupId;
                if (str2.equals(str7)) {
                    str8 = this.Vz.mUrl;
                    compareUrlsBeforeQuestionMark = LiveGroupManagerService.compareUrlsBeforeQuestionMark(str4, str8);
                    if (compareUrlsBeforeQuestionMark) {
                        i3 = this.Vz.mStatus;
                        if (i3 != 4) {
                            i4 = this.Vz.mStatus;
                            if (i4 != 20) {
                                return;
                            }
                            str9 = this.Vz.mGroupId;
                            dE(str9);
                            return;
                        }
                        str10 = this.Vz.mGroupId;
                        resumePublish(str10);
                        return;
                    }
                }
            }
            ax(z2);
            this.Vz.argsToBeStarted = new l(null);
            lVar = this.Vz.argsToBeStarted;
            lVar.groupId = str2;
            lVar2 = this.Vz.argsToBeStarted;
            lVar2.url = str4;
            lVar3 = this.Vz.argsToBeStarted;
            lVar3.streamId = str;
            lVar4 = this.Vz.argsToBeStarted;
            lVar4.VC = str3;
            lVar5 = this.Vz.argsToBeStarted;
            lVar5.accessToken = str5;
            lVar6 = this.Vz.argsToBeStarted;
            lVar6.userId = str6;
        } else if (StringUtils.isNull(str)) {
            c(str2, str4, 0);
        } else {
            a(str, str2, str3, str4, str5, str6);
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
        i = this.Vz.mStatus;
        if (i == 3) {
            liveSenderControl = this.Vz.mLiveSenderControl;
            if (liveSenderControl != null) {
                liveSenderControl2 = this.Vz.mLiveSenderControl;
                return liveSenderControl2.querySignalStrength();
            }
        }
        i2 = this.Vz.mStatus;
        if (i2 == 19) {
            livePlayerControl = this.Vz.mPlayerCtrl;
            if (livePlayerControl != null) {
                livePlayerControl2 = this.Vz.mPlayerCtrl;
                return livePlayerControl2.getSignalStrength();
            }
        }
        return 0;
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getRecordTime() {
        int i;
        i = this.Vz.mRecordTime;
        return i;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void setPublisherPaused(boolean z) {
        int i;
        i = this.Vz.mStatus;
        if (i != 19) {
            return;
        }
        this.Vz.mIsPublisherPaused = z;
    }
}
