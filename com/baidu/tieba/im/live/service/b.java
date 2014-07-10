package com.baidu.tieba.im.live.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.util.Timer;
/* loaded from: classes.dex */
class b extends Handler {
    final /* synthetic */ LiveGroupManagerService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LiveGroupManagerService liveGroupManagerService) {
        this.a = liveGroupManagerService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x033c, code lost:
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
        f fVar;
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
                this.a.broadcastLiveStatusChanged();
                return;
            case 2:
                this.a.broadcastLiveError();
                return;
            case 3:
                this.a.notifyPlayProgressEvent();
                return;
            case 4:
                this.a.notifyRecordTimeEvent(message.arg1);
                return;
            case 5:
                this.a.broadcastPlayWarningEvent(message.arg1);
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                super.handleMessage(message);
                return;
            case 10:
                i24 = this.a.mStatus;
                if (i24 != 0) {
                    return;
                }
                liveSenderControl14 = this.a.mLiveSenderControl;
                if (liveSenderControl14 == null || (fVar = (f) message.obj) == null) {
                    return;
                }
                this.a.mStreamId = fVar.a;
                this.a.mGroupId = fVar.b;
                this.a.mDeviceId = fVar.c;
                this.a.mUrl = fVar.d;
                this.a.mAccessToken = fVar.e;
                this.a.mUserId = fVar.f;
                liveSenderControl15 = this.a.mLiveSenderControl;
                liveSenderControl15.prepare();
                liveSenderControl16 = this.a.mLiveSenderControl;
                str3 = this.a.mStreamId;
                liveSenderControl16.setOption("guid", str3);
                liveSenderControl17 = this.a.mLiveSenderControl;
                str4 = this.a.mGroupId;
                StringBuilder append = new StringBuilder(String.valueOf(str4)).append("_");
                str5 = this.a.mUserId;
                liveSenderControl17.setOption("publishtoken", append.append(str5).toString());
                liveSenderControl18 = this.a.mLiveSenderControl;
                str6 = this.a.mDeviceId;
                liveSenderControl18.setOption("devid", str6);
                liveSenderControl19 = this.a.mLiveSenderControl;
                str7 = this.a.mAccessToken;
                liveSenderControl19.setOption("accesstoken", str7);
                liveSenderControl20 = this.a.mLiveSenderControl;
                liveSenderControl20.setOption("devtype", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                liveSenderControl21 = this.a.mLiveSenderControl;
                liveSenderControl21.setOption("extjson", "");
                liveSenderControl22 = this.a.mLiveSenderControl;
                str8 = this.a.mUserId;
                liveSenderControl22.setOption("userId", str8);
                liveSenderControl23 = this.a.mLiveSenderControl;
                str9 = this.a.mGroupId;
                liveSenderControl23.setOption("groupId", str9);
                liveSenderControl24 = this.a.mLiveSenderControl;
                liveSenderControl24.setOption("identity", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                liveSenderControl25 = this.a.mLiveSenderControl;
                str10 = this.a.mStreamId;
                liveSenderControl25.setOption("streamId", str10);
                liveSenderControl26 = this.a.mLiveSenderControl;
                liveSenderControl26.setAudioParams(LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05, 2);
                this.a.mExecStartOnceConnected = true;
                liveSenderControl27 = this.a.mLiveSenderControl;
                str11 = this.a.mUrl;
                if (liveSenderControl27.connect(str11) == 0) {
                    return;
                }
                this.a.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_CONNECT_FAILED;
                handler = this.a.mHandler;
                handler.sendEmptyMessage(2);
                return;
            case 11:
                i23 = this.a.mStatus;
                if (i23 != 3) {
                    return;
                }
                liveSenderControl12 = this.a.mLiveSenderControl;
                liveSenderControl12.pause();
                liveSenderControl13 = this.a.mLiveSenderControl;
                liveSenderControl13.sendUserCmd("pausePublish", "");
                z6 = this.a.mIsRecording;
                if (!z6) {
                    return;
                }
                this.a.mIsRecordPaused = true;
                timer7 = this.a.mRecordTimer;
                if (timer7 == null) {
                    return;
                }
                timer8 = this.a.mRecordTimer;
                timer8.cancel();
                this.a.mRecordTimer = null;
                return;
            case 12:
                i22 = this.a.mStatus;
                if (i22 != 4) {
                    return;
                }
                liveSenderControl10 = this.a.mLiveSenderControl;
                liveSenderControl10.resume();
                liveSenderControl11 = this.a.mLiveSenderControl;
                liveSenderControl11.sendUserCmd("resumePublish", "");
                z4 = this.a.mIsRecording;
                if (!z4) {
                    return;
                }
                z5 = this.a.mIsRecordPaused;
                if (!z5) {
                    return;
                }
                this.a.mIsRecordPaused = false;
                c cVar = new c(this);
                this.a.mRecordTimer = null;
                this.a.mRecordTimer = new Timer();
                timer6 = this.a.mRecordTimer;
                timer6.schedule(cVar, 1000L, 1000L);
                return;
            case 13:
                z3 = this.a.mIsRecording;
                if (z3) {
                    return;
                }
                i18 = this.a.mStatus;
                if (i18 != 2) {
                    i20 = this.a.mStatus;
                    if (i20 != 3) {
                        i21 = this.a.mStatus;
                        if (i21 != 4) {
                            return;
                        }
                    }
                }
                LiveGroupManagerService liveGroupManagerService = this.a;
                liveSenderControl9 = this.a.mLiveSenderControl;
                liveGroupManagerService.mCmdIdStartRecord = liveSenderControl9.sendUserCmd("startRecord", "");
                this.a.mIsRecording = true;
                this.a.mRecordTime = 0;
                i19 = this.a.mStatus;
                if (i19 == 4) {
                    this.a.mIsRecordPaused = true;
                    return;
                }
                this.a.mIsRecordPaused = false;
                d dVar = new d(this);
                this.a.mRecordTimer = null;
                this.a.mRecordTimer = new Timer();
                timer5 = this.a.mRecordTimer;
                timer5.schedule(dVar, 1000L, 1000L);
                return;
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                z2 = this.a.mIsRecording;
                if (!z2) {
                    return;
                }
                i15 = this.a.mStatus;
                if (i15 != 2) {
                    i16 = this.a.mStatus;
                    if (i16 != 3) {
                        i17 = this.a.mStatus;
                        if (i17 != 4) {
                            return;
                        }
                    }
                }
                LiveGroupManagerService liveGroupManagerService2 = this.a;
                liveSenderControl8 = this.a.mLiveSenderControl;
                liveGroupManagerService2.mCmdIdStopRecord = liveSenderControl8.sendUserCmd("stopRecord", "");
                this.a.mIsRecording = false;
                this.a.mIsRecordPaused = false;
                timer3 = this.a.mRecordTimer;
                if (timer3 != null) {
                    timer4 = this.a.mRecordTimer;
                    timer4.cancel();
                    this.a.mRecordTimer = null;
                }
                this.a.mRecordTime = 0;
                return;
            case 15:
                i9 = this.a.mStatus;
                if (i9 != 1) {
                    i12 = this.a.mStatus;
                    if (i12 != 2) {
                        i13 = this.a.mStatus;
                        if (i13 != 3) {
                            i14 = this.a.mStatus;
                            if (i14 != 4) {
                                return;
                            }
                        }
                    }
                }
                liveSenderControl3 = this.a.mLiveSenderControl;
                if (liveSenderControl3 == null) {
                    return;
                }
                z = this.a.mIsRecording;
                if (z) {
                    LiveGroupManagerService liveGroupManagerService3 = this.a;
                    liveSenderControl7 = this.a.mLiveSenderControl;
                    liveGroupManagerService3.mCmdIdStopRecord = liveSenderControl7.sendUserCmd("stopRecord", "");
                    this.a.mIsRecording = false;
                    timer = this.a.mRecordTimer;
                    if (timer != null) {
                        timer2 = this.a.mRecordTimer;
                        timer2.cancel();
                        this.a.mRecordTimer = null;
                    }
                    this.a.mRecordTime = 0;
                }
                i10 = this.a.mStatus;
                if (i10 != 3) {
                    i11 = this.a.mStatus;
                    break;
                }
                liveSenderControl4 = this.a.mLiveSenderControl;
                liveSenderControl4.stop();
                liveSenderControl5 = this.a.mLiveSenderControl;
                liveSenderControl5.close();
                liveSenderControl6 = this.a.mLiveSenderControl;
                liveSenderControl6.shutdown();
                return;
            case 16:
                i8 = this.a.mStatus;
                if (i8 != 2) {
                    return;
                }
                liveSenderControl2 = this.a.mLiveSenderControl;
                liveSenderControl2.start();
                return;
            case 17:
                i6 = this.a.mStatus;
                if (i6 != 3) {
                    i7 = this.a.mStatus;
                    if (i7 != 4) {
                        return;
                    }
                }
                liveSenderControl = this.a.mLiveSenderControl;
                liveSenderControl.stop();
                return;
            case 18:
                e eVar = (e) message.obj;
                if (eVar == null) {
                    return;
                }
                i5 = this.a.mStatus;
                if (i5 != 0) {
                    return;
                }
                this.a.mGroupId = eVar.a;
                this.a.mUrl = eVar.b;
                int i25 = eVar.c;
                livePlayerControl9 = this.a.mPlayerCtrl;
                str2 = this.a.mUrl;
                livePlayerControl9.setVideoPath(str2);
                LiveGroupManagerService liveGroupManagerService4 = this.a;
                this.a.mPlayDuration = 0;
                liveGroupManagerService4.mPlayPosition = 0;
                if (i25 > 0) {
                    livePlayerControl11 = this.a.mPlayerCtrl;
                    livePlayerControl11.start(i25);
                    this.a.mPlayDuration = i25;
                    return;
                }
                livePlayerControl10 = this.a.mPlayerCtrl;
                livePlayerControl10.start();
                return;
            case 19:
                livePlayerControl7 = this.a.mPlayerCtrl;
                if (livePlayerControl7 == null) {
                    return;
                }
                livePlayerControl8 = this.a.mPlayerCtrl;
                livePlayerControl8.exit();
                return;
            case 20:
                livePlayerControl5 = this.a.mPlayerCtrl;
                if (livePlayerControl5 == null) {
                    return;
                }
                i4 = this.a.mStatus;
                if (i4 != 19) {
                    return;
                }
                livePlayerControl6 = this.a.mPlayerCtrl;
                livePlayerControl6.pause();
                return;
            case 21:
                livePlayerControl3 = this.a.mPlayerCtrl;
                if (livePlayerControl3 == null) {
                    return;
                }
                i3 = this.a.mStatus;
                if (i3 != 20) {
                    return;
                }
                livePlayerControl4 = this.a.mPlayerCtrl;
                livePlayerControl4.play();
                return;
            case 22:
                str = this.a.mGroupId;
                if (!LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
                    return;
                }
                livePlayerControl = this.a.mPlayerCtrl;
                if (livePlayerControl != null) {
                    int i26 = message.arg1;
                    i = this.a.mPlayDuration;
                    if (i26 < i) {
                        if (i26 < 0) {
                            i26 = 0;
                        }
                    } else {
                        i2 = this.a.mPlayDuration;
                        i26 = i2 - 1;
                    }
                    livePlayerControl2 = this.a.mPlayerCtrl;
                    livePlayerControl2.seekTo(i26);
                    return;
                }
                return;
        }
    }
}
