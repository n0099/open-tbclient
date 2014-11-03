package com.baidu.tbadk.live.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.util.Timer;
/* loaded from: classes.dex */
class h extends Handler {
    final /* synthetic */ LiveGroupManagerService Vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LiveGroupManagerService liveGroupManagerService) {
        this.Vz = liveGroupManagerService;
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
                this.Vz.broadcastLiveStatusChanged();
                return;
            case 2:
                this.Vz.broadcastLiveError();
                return;
            case 3:
                this.Vz.notifyPlayProgressEvent();
                return;
            case 4:
                this.Vz.notifyRecordTimeEvent(message.arg1);
                return;
            case 5:
                this.Vz.broadcastPlayWarningEvent(message.arg1);
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                super.handleMessage(message);
                return;
            case 10:
                i24 = this.Vz.mStatus;
                if (i24 != 0) {
                    return;
                }
                liveSenderControl14 = this.Vz.mLiveSenderControl;
                if (liveSenderControl14 == null || (lVar = (l) message.obj) == null) {
                    return;
                }
                this.Vz.mStreamId = lVar.streamId;
                this.Vz.mGroupId = lVar.groupId;
                this.Vz.mDeviceId = lVar.VC;
                this.Vz.mUrl = lVar.url;
                this.Vz.mAccessToken = lVar.accessToken;
                this.Vz.mUserId = lVar.userId;
                liveSenderControl15 = this.Vz.mLiveSenderControl;
                liveSenderControl15.prepare();
                liveSenderControl16 = this.Vz.mLiveSenderControl;
                str3 = this.Vz.mStreamId;
                liveSenderControl16.setOption("guid", str3);
                liveSenderControl17 = this.Vz.mLiveSenderControl;
                str4 = this.Vz.mGroupId;
                StringBuilder append = new StringBuilder(String.valueOf(str4)).append("_");
                str5 = this.Vz.mUserId;
                liveSenderControl17.setOption("publishtoken", append.append(str5).toString());
                liveSenderControl18 = this.Vz.mLiveSenderControl;
                str6 = this.Vz.mDeviceId;
                liveSenderControl18.setOption("devid", str6);
                liveSenderControl19 = this.Vz.mLiveSenderControl;
                str7 = this.Vz.mAccessToken;
                liveSenderControl19.setOption("accesstoken", str7);
                liveSenderControl20 = this.Vz.mLiveSenderControl;
                liveSenderControl20.setOption("devtype", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                liveSenderControl21 = this.Vz.mLiveSenderControl;
                liveSenderControl21.setOption("extjson", "");
                liveSenderControl22 = this.Vz.mLiveSenderControl;
                str8 = this.Vz.mUserId;
                liveSenderControl22.setOption("userId", str8);
                liveSenderControl23 = this.Vz.mLiveSenderControl;
                str9 = this.Vz.mGroupId;
                liveSenderControl23.setOption("groupId", str9);
                liveSenderControl24 = this.Vz.mLiveSenderControl;
                liveSenderControl24.setOption("identity", "1");
                liveSenderControl25 = this.Vz.mLiveSenderControl;
                str10 = this.Vz.mStreamId;
                liveSenderControl25.setOption("streamId", str10);
                liveSenderControl26 = this.Vz.mLiveSenderControl;
                liveSenderControl26.setAudioParams(LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05, 2);
                this.Vz.mExecStartOnceConnected = true;
                liveSenderControl27 = this.Vz.mLiveSenderControl;
                str11 = this.Vz.mUrl;
                if (liveSenderControl27.connect(str11) == 0) {
                    return;
                }
                this.Vz.mErrorPrompt = LiveStatusChangeDefinition.ERROR_PROMPT_CONNECT_FAILED;
                handler = this.Vz.mHandler;
                handler.sendEmptyMessage(2);
                return;
            case 11:
                i23 = this.Vz.mStatus;
                if (i23 != 3) {
                    return;
                }
                liveSenderControl12 = this.Vz.mLiveSenderControl;
                liveSenderControl12.pause();
                liveSenderControl13 = this.Vz.mLiveSenderControl;
                liveSenderControl13.sendUserCmd("pausePublish", "");
                z6 = this.Vz.mIsRecording;
                if (!z6) {
                    return;
                }
                this.Vz.mIsRecordPaused = true;
                timer7 = this.Vz.mRecordTimer;
                if (timer7 == null) {
                    return;
                }
                timer8 = this.Vz.mRecordTimer;
                timer8.cancel();
                this.Vz.mRecordTimer = null;
                return;
            case 12:
                i22 = this.Vz.mStatus;
                if (i22 != 4) {
                    return;
                }
                liveSenderControl10 = this.Vz.mLiveSenderControl;
                liveSenderControl10.resume();
                liveSenderControl11 = this.Vz.mLiveSenderControl;
                liveSenderControl11.sendUserCmd("resumePublish", "");
                z4 = this.Vz.mIsRecording;
                if (!z4) {
                    return;
                }
                z5 = this.Vz.mIsRecordPaused;
                if (!z5) {
                    return;
                }
                this.Vz.mIsRecordPaused = false;
                i iVar = new i(this);
                this.Vz.mRecordTimer = null;
                this.Vz.mRecordTimer = new Timer();
                timer6 = this.Vz.mRecordTimer;
                timer6.schedule(iVar, 1000L, 1000L);
                return;
            case 13:
                z3 = this.Vz.mIsRecording;
                if (z3) {
                    return;
                }
                i18 = this.Vz.mStatus;
                if (i18 != 2) {
                    i20 = this.Vz.mStatus;
                    if (i20 != 3) {
                        i21 = this.Vz.mStatus;
                        if (i21 != 4) {
                            return;
                        }
                    }
                }
                LiveGroupManagerService liveGroupManagerService = this.Vz;
                liveSenderControl9 = this.Vz.mLiveSenderControl;
                liveGroupManagerService.mCmdIdStartRecord = liveSenderControl9.sendUserCmd("startRecord", "");
                this.Vz.mIsRecording = true;
                this.Vz.mRecordTime = 0;
                i19 = this.Vz.mStatus;
                if (i19 == 4) {
                    this.Vz.mIsRecordPaused = true;
                    return;
                }
                this.Vz.mIsRecordPaused = false;
                j jVar = new j(this);
                this.Vz.mRecordTimer = null;
                this.Vz.mRecordTimer = new Timer();
                timer5 = this.Vz.mRecordTimer;
                timer5.schedule(jVar, 1000L, 1000L);
                return;
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                z2 = this.Vz.mIsRecording;
                if (!z2) {
                    return;
                }
                i15 = this.Vz.mStatus;
                if (i15 != 2) {
                    i16 = this.Vz.mStatus;
                    if (i16 != 3) {
                        i17 = this.Vz.mStatus;
                        if (i17 != 4) {
                            return;
                        }
                    }
                }
                LiveGroupManagerService liveGroupManagerService2 = this.Vz;
                liveSenderControl8 = this.Vz.mLiveSenderControl;
                liveGroupManagerService2.mCmdIdStopRecord = liveSenderControl8.sendUserCmd("stopRecord", "");
                this.Vz.mIsRecording = false;
                this.Vz.mIsRecordPaused = false;
                timer3 = this.Vz.mRecordTimer;
                if (timer3 != null) {
                    timer4 = this.Vz.mRecordTimer;
                    timer4.cancel();
                    this.Vz.mRecordTimer = null;
                }
                this.Vz.mRecordTime = 0;
                return;
            case 15:
                i9 = this.Vz.mStatus;
                if (i9 != 1) {
                    i12 = this.Vz.mStatus;
                    if (i12 != 2) {
                        i13 = this.Vz.mStatus;
                        if (i13 != 3) {
                            i14 = this.Vz.mStatus;
                            if (i14 != 4) {
                                return;
                            }
                        }
                    }
                }
                liveSenderControl3 = this.Vz.mLiveSenderControl;
                if (liveSenderControl3 == null) {
                    return;
                }
                z = this.Vz.mIsRecording;
                if (z) {
                    LiveGroupManagerService liveGroupManagerService3 = this.Vz;
                    liveSenderControl7 = this.Vz.mLiveSenderControl;
                    liveGroupManagerService3.mCmdIdStopRecord = liveSenderControl7.sendUserCmd("stopRecord", "");
                    this.Vz.mIsRecording = false;
                    timer = this.Vz.mRecordTimer;
                    if (timer != null) {
                        timer2 = this.Vz.mRecordTimer;
                        timer2.cancel();
                        this.Vz.mRecordTimer = null;
                    }
                    this.Vz.mRecordTime = 0;
                }
                i10 = this.Vz.mStatus;
                if (i10 != 3) {
                    i11 = this.Vz.mStatus;
                    break;
                }
                liveSenderControl4 = this.Vz.mLiveSenderControl;
                liveSenderControl4.stop();
                liveSenderControl5 = this.Vz.mLiveSenderControl;
                liveSenderControl5.close();
                liveSenderControl6 = this.Vz.mLiveSenderControl;
                liveSenderControl6.shutdown();
                return;
            case 16:
                i8 = this.Vz.mStatus;
                if (i8 != 2) {
                    return;
                }
                liveSenderControl2 = this.Vz.mLiveSenderControl;
                liveSenderControl2.start();
                return;
            case 17:
                i6 = this.Vz.mStatus;
                if (i6 != 3) {
                    i7 = this.Vz.mStatus;
                    if (i7 != 4) {
                        return;
                    }
                }
                liveSenderControl = this.Vz.mLiveSenderControl;
                liveSenderControl.stop();
                return;
            case 18:
                k kVar = (k) message.obj;
                if (kVar == null) {
                    return;
                }
                i5 = this.Vz.mStatus;
                if (i5 != 0) {
                    return;
                }
                this.Vz.mGroupId = kVar.groupId;
                this.Vz.mUrl = kVar.url;
                int i25 = kVar.VB;
                livePlayerControl9 = this.Vz.mPlayerCtrl;
                str2 = this.Vz.mUrl;
                livePlayerControl9.setVideoPath(str2);
                LiveGroupManagerService liveGroupManagerService4 = this.Vz;
                this.Vz.mPlayDuration = 0;
                liveGroupManagerService4.mPlayPosition = 0;
                if (i25 > 0) {
                    livePlayerControl11 = this.Vz.mPlayerCtrl;
                    livePlayerControl11.start(i25);
                    this.Vz.mPlayDuration = i25;
                    return;
                }
                livePlayerControl10 = this.Vz.mPlayerCtrl;
                livePlayerControl10.start();
                return;
            case 19:
                livePlayerControl7 = this.Vz.mPlayerCtrl;
                if (livePlayerControl7 == null) {
                    return;
                }
                livePlayerControl8 = this.Vz.mPlayerCtrl;
                livePlayerControl8.exit();
                return;
            case 20:
                livePlayerControl5 = this.Vz.mPlayerCtrl;
                if (livePlayerControl5 == null) {
                    return;
                }
                i4 = this.Vz.mStatus;
                if (i4 != 19) {
                    return;
                }
                livePlayerControl6 = this.Vz.mPlayerCtrl;
                livePlayerControl6.pause();
                return;
            case 21:
                livePlayerControl3 = this.Vz.mPlayerCtrl;
                if (livePlayerControl3 == null) {
                    return;
                }
                i3 = this.Vz.mStatus;
                if (i3 != 20) {
                    return;
                }
                livePlayerControl4 = this.Vz.mPlayerCtrl;
                livePlayerControl4.play();
                return;
            case 22:
                str = this.Vz.mGroupId;
                if (!LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(str)) {
                    return;
                }
                livePlayerControl = this.Vz.mPlayerCtrl;
                if (livePlayerControl != null) {
                    int i26 = message.arg1;
                    i = this.Vz.mPlayDuration;
                    if (i26 < i) {
                        if (i26 < 0) {
                            i26 = 0;
                        }
                    } else {
                        i2 = this.Vz.mPlayDuration;
                        i26 = i2 - 1;
                    }
                    livePlayerControl2 = this.Vz.mPlayerCtrl;
                    livePlayerControl2.seekTo(i26);
                    return;
                }
                return;
        }
    }
}
