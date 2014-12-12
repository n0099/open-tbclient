package com.baidu.tbadk.live.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import java.util.Timer;
/* loaded from: classes.dex */
class h extends Handler {
    final /* synthetic */ LiveGroupManagerService abB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LiveGroupManagerService liveGroupManagerService) {
        this.abB = liveGroupManagerService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0323, code lost:
        if (r0 == 4) goto L96;
     */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchMessage(Message message) {
        String str;
        LivePlayerControl livePlayerControl;
        int i;
        LivePlayerControl livePlayerControl2;
        int i2;
        LivePlayerControl livePlayerControl3;
        int i3;
        LivePlayerControl livePlayerControl4;
        LivePlayerControl livePlayerControl5;
        int i4;
        LivePlayerControl livePlayerControl6;
        LivePlayerControl livePlayerControl7;
        LivePlayerControl livePlayerControl8;
        int i5;
        LivePlayerControl livePlayerControl9;
        String str2;
        LivePlayerControl livePlayerControl10;
        LivePlayerControl livePlayerControl11;
        int i6;
        LiveSenderControl liveSenderControl;
        int i7;
        int i8;
        LiveSenderControl liveSenderControl2;
        int i9;
        LiveSenderControl liveSenderControl3;
        boolean z;
        int i10;
        LiveSenderControl liveSenderControl4;
        LiveSenderControl liveSenderControl5;
        LiveSenderControl liveSenderControl6;
        int i11;
        LiveSenderControl liveSenderControl7;
        Timer timer;
        Timer timer2;
        int i12;
        int i13;
        int i14;
        boolean z2;
        int i15;
        LiveSenderControl liveSenderControl8;
        Timer timer3;
        Timer timer4;
        int i16;
        int i17;
        boolean z3;
        int i18;
        LiveSenderControl liveSenderControl9;
        int i19;
        Timer timer5;
        int i20;
        int i21;
        int i22;
        LiveSenderControl liveSenderControl10;
        LiveSenderControl liveSenderControl11;
        boolean z4;
        boolean z5;
        Timer timer6;
        int i23;
        LiveSenderControl liveSenderControl12;
        LiveSenderControl liveSenderControl13;
        boolean z6;
        Timer timer7;
        Timer timer8;
        int i24;
        LiveSenderControl liveSenderControl14;
        l lVar;
        LiveSenderControl liveSenderControl15;
        LiveSenderControl liveSenderControl16;
        String str3;
        LiveSenderControl liveSenderControl17;
        String str4;
        String str5;
        LiveSenderControl liveSenderControl18;
        String str6;
        LiveSenderControl liveSenderControl19;
        String str7;
        LiveSenderControl liveSenderControl20;
        LiveSenderControl liveSenderControl21;
        LiveSenderControl liveSenderControl22;
        String str8;
        LiveSenderControl liveSenderControl23;
        String str9;
        LiveSenderControl liveSenderControl24;
        LiveSenderControl liveSenderControl25;
        String str10;
        LiveSenderControl liveSenderControl26;
        LiveSenderControl liveSenderControl27;
        String str11;
        Handler handler;
        switch (message.what) {
            case 1:
                this.abB.broadcastLiveStatusChanged();
                return;
            case 2:
                this.abB.broadcastLiveError();
                return;
            case 3:
                this.abB.notifyPlayProgressEvent();
                return;
            case 4:
                this.abB.notifyRecordTimeEvent(message.arg1);
                return;
            case 5:
                this.abB.broadcastPlayWarningEvent(message.arg1);
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                super.handleMessage(message);
                return;
            case 10:
                i24 = this.abB.mStatus;
                if (i24 != 0) {
                    return;
                }
                liveSenderControl14 = this.abB.mLiveSenderControl;
                if (liveSenderControl14 == null || (lVar = (l) message.obj) == null) {
                    return;
                }
                this.abB.mStreamId = lVar.streamId;
                this.abB.mGroupId = lVar.groupId;
                this.abB.mDeviceId = lVar.deviceId;
                this.abB.mUrl = lVar.url;
                this.abB.mAccessToken = lVar.accessToken;
                this.abB.mUserId = lVar.userId;
                liveSenderControl15 = this.abB.mLiveSenderControl;
                liveSenderControl15.prepare();
                liveSenderControl16 = this.abB.mLiveSenderControl;
                str3 = this.abB.mStreamId;
                liveSenderControl16.setOption("guid", str3);
                liveSenderControl17 = this.abB.mLiveSenderControl;
                str4 = this.abB.mGroupId;
                StringBuilder append = new StringBuilder(String.valueOf(str4)).append("_");
                str5 = this.abB.mUserId;
                liveSenderControl17.setOption("publishtoken", append.append(str5).toString());
                liveSenderControl18 = this.abB.mLiveSenderControl;
                str6 = this.abB.mDeviceId;
                liveSenderControl18.setOption("devid", str6);
                liveSenderControl19 = this.abB.mLiveSenderControl;
                str7 = this.abB.mAccessToken;
                liveSenderControl19.setOption("accesstoken", str7);
                liveSenderControl20 = this.abB.mLiveSenderControl;
                liveSenderControl20.setOption("devtype", "2");
                liveSenderControl21 = this.abB.mLiveSenderControl;
                liveSenderControl21.setOption("extjson", "");
                liveSenderControl22 = this.abB.mLiveSenderControl;
                str8 = this.abB.mUserId;
                liveSenderControl22.setOption("userId", str8);
                liveSenderControl23 = this.abB.mLiveSenderControl;
                str9 = this.abB.mGroupId;
                liveSenderControl23.setOption("groupId", str9);
                liveSenderControl24 = this.abB.mLiveSenderControl;
                liveSenderControl24.setOption("identity", "1");
                liveSenderControl25 = this.abB.mLiveSenderControl;
                str10 = this.abB.mStreamId;
                liveSenderControl25.setOption("streamId", str10);
                liveSenderControl26 = this.abB.mLiveSenderControl;
                liveSenderControl26.setAudioParams(LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05, 2);
                this.abB.mExecStartOnceConnected = true;
                liveSenderControl27 = this.abB.mLiveSenderControl;
                str11 = this.abB.mUrl;
                if (liveSenderControl27.connect(str11) == 0) {
                    return;
                }
                this.abB.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_CONNECT_FAILED;
                handler = this.abB.mHandler;
                handler.sendEmptyMessage(2);
                return;
            case 11:
                i23 = this.abB.mStatus;
                if (i23 != 3) {
                    return;
                }
                liveSenderControl12 = this.abB.mLiveSenderControl;
                liveSenderControl12.pause();
                liveSenderControl13 = this.abB.mLiveSenderControl;
                liveSenderControl13.sendUserCmd("pausePublish", "");
                z6 = this.abB.mIsRecording;
                if (!z6) {
                    return;
                }
                this.abB.mIsRecordPaused = true;
                timer7 = this.abB.mRecordTimer;
                if (timer7 == null) {
                    return;
                }
                timer8 = this.abB.mRecordTimer;
                timer8.cancel();
                this.abB.mRecordTimer = null;
                return;
            case 12:
                i22 = this.abB.mStatus;
                if (i22 != 4) {
                    return;
                }
                liveSenderControl10 = this.abB.mLiveSenderControl;
                liveSenderControl10.resume();
                liveSenderControl11 = this.abB.mLiveSenderControl;
                liveSenderControl11.sendUserCmd("resumePublish", "");
                z4 = this.abB.mIsRecording;
                if (!z4) {
                    return;
                }
                z5 = this.abB.mIsRecordPaused;
                if (!z5) {
                    return;
                }
                this.abB.mIsRecordPaused = false;
                i iVar = new i(this);
                this.abB.mRecordTimer = null;
                this.abB.mRecordTimer = new Timer();
                timer6 = this.abB.mRecordTimer;
                timer6.schedule(iVar, 1000L, 1000L);
                return;
            case 13:
                z3 = this.abB.mIsRecording;
                if (z3) {
                    return;
                }
                i18 = this.abB.mStatus;
                if (i18 != 2) {
                    i20 = this.abB.mStatus;
                    if (i20 != 3) {
                        i21 = this.abB.mStatus;
                        if (i21 != 4) {
                            return;
                        }
                    }
                }
                LiveGroupManagerService liveGroupManagerService = this.abB;
                liveSenderControl9 = this.abB.mLiveSenderControl;
                liveGroupManagerService.mCmdIdStartRecord = liveSenderControl9.sendUserCmd("startRecord", "");
                this.abB.mIsRecording = true;
                this.abB.mRecordTime = 0;
                i19 = this.abB.mStatus;
                if (i19 == 4) {
                    this.abB.mIsRecordPaused = true;
                    return;
                }
                this.abB.mIsRecordPaused = false;
                j jVar = new j(this);
                this.abB.mRecordTimer = null;
                this.abB.mRecordTimer = new Timer();
                timer5 = this.abB.mRecordTimer;
                timer5.schedule(jVar, 1000L, 1000L);
                return;
            case 14:
                z2 = this.abB.mIsRecording;
                if (!z2) {
                    return;
                }
                i15 = this.abB.mStatus;
                if (i15 != 2) {
                    i16 = this.abB.mStatus;
                    if (i16 != 3) {
                        i17 = this.abB.mStatus;
                        if (i17 != 4) {
                            return;
                        }
                    }
                }
                LiveGroupManagerService liveGroupManagerService2 = this.abB;
                liveSenderControl8 = this.abB.mLiveSenderControl;
                liveGroupManagerService2.mCmdIdStopRecord = liveSenderControl8.sendUserCmd("stopRecord", "");
                this.abB.mIsRecording = false;
                this.abB.mIsRecordPaused = false;
                timer3 = this.abB.mRecordTimer;
                if (timer3 != null) {
                    timer4 = this.abB.mRecordTimer;
                    timer4.cancel();
                    this.abB.mRecordTimer = null;
                }
                this.abB.mRecordTime = 0;
                return;
            case 15:
                i9 = this.abB.mStatus;
                if (i9 != 1) {
                    i12 = this.abB.mStatus;
                    if (i12 != 2) {
                        i13 = this.abB.mStatus;
                        if (i13 != 3) {
                            i14 = this.abB.mStatus;
                            if (i14 != 4) {
                                return;
                            }
                        }
                    }
                }
                liveSenderControl3 = this.abB.mLiveSenderControl;
                if (liveSenderControl3 == null) {
                    return;
                }
                z = this.abB.mIsRecording;
                if (z) {
                    LiveGroupManagerService liveGroupManagerService3 = this.abB;
                    liveSenderControl7 = this.abB.mLiveSenderControl;
                    liveGroupManagerService3.mCmdIdStopRecord = liveSenderControl7.sendUserCmd("stopRecord", "");
                    this.abB.mIsRecording = false;
                    timer = this.abB.mRecordTimer;
                    if (timer != null) {
                        timer2 = this.abB.mRecordTimer;
                        timer2.cancel();
                        this.abB.mRecordTimer = null;
                    }
                    this.abB.mRecordTime = 0;
                }
                i10 = this.abB.mStatus;
                if (i10 != 3) {
                    i11 = this.abB.mStatus;
                    break;
                }
                liveSenderControl4 = this.abB.mLiveSenderControl;
                liveSenderControl4.stop();
                liveSenderControl5 = this.abB.mLiveSenderControl;
                liveSenderControl5.close();
                liveSenderControl6 = this.abB.mLiveSenderControl;
                liveSenderControl6.shutdown();
                return;
            case 16:
                i8 = this.abB.mStatus;
                if (i8 != 2) {
                    return;
                }
                liveSenderControl2 = this.abB.mLiveSenderControl;
                liveSenderControl2.start();
                return;
            case 17:
                i6 = this.abB.mStatus;
                if (i6 != 3) {
                    i7 = this.abB.mStatus;
                    if (i7 != 4) {
                        return;
                    }
                }
                liveSenderControl = this.abB.mLiveSenderControl;
                liveSenderControl.stop();
                return;
            case 18:
                k kVar = (k) message.obj;
                if (kVar == null) {
                    return;
                }
                i5 = this.abB.mStatus;
                if (i5 != 0) {
                    return;
                }
                this.abB.mGroupId = kVar.groupId;
                this.abB.mUrl = kVar.url;
                int i25 = kVar.startPos;
                livePlayerControl9 = this.abB.mPlayerCtrl;
                str2 = this.abB.mUrl;
                livePlayerControl9.setVideoPath(str2);
                LiveGroupManagerService liveGroupManagerService4 = this.abB;
                this.abB.mPlayDuration = 0;
                liveGroupManagerService4.mPlayPosition = 0;
                if (i25 > 0) {
                    livePlayerControl11 = this.abB.mPlayerCtrl;
                    livePlayerControl11.start(i25);
                    this.abB.mPlayDuration = i25;
                    return;
                }
                livePlayerControl10 = this.abB.mPlayerCtrl;
                livePlayerControl10.start();
                return;
            case 19:
                livePlayerControl7 = this.abB.mPlayerCtrl;
                if (livePlayerControl7 == null) {
                    return;
                }
                livePlayerControl8 = this.abB.mPlayerCtrl;
                livePlayerControl8.exit();
                return;
            case 20:
                livePlayerControl5 = this.abB.mPlayerCtrl;
                if (livePlayerControl5 == null) {
                    return;
                }
                i4 = this.abB.mStatus;
                if (i4 != 19) {
                    return;
                }
                livePlayerControl6 = this.abB.mPlayerCtrl;
                livePlayerControl6.pause();
                return;
            case 21:
                livePlayerControl3 = this.abB.mPlayerCtrl;
                if (livePlayerControl3 == null) {
                    return;
                }
                i3 = this.abB.mStatus;
                if (i3 != 20) {
                    return;
                }
                livePlayerControl4 = this.abB.mPlayerCtrl;
                livePlayerControl4.play();
                return;
            case 22:
                str = this.abB.mGroupId;
                if (!LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
                    return;
                }
                livePlayerControl = this.abB.mPlayerCtrl;
                if (livePlayerControl != null) {
                    int i26 = message.arg1;
                    i = this.abB.mPlayDuration;
                    if (i26 < i) {
                        if (i26 < 0) {
                            i26 = 0;
                        }
                    } else {
                        i2 = this.abB.mPlayDuration;
                        i26 = i2 - 1;
                    }
                    livePlayerControl2 = this.abB.mPlayerCtrl;
                    livePlayerControl2.seekTo(i26);
                    return;
                }
                return;
        }
    }
}
