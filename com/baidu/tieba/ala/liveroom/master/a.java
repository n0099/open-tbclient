package com.baidu.tieba.ala.liveroom.master;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.al.a;
import com.baidu.live.ar.j;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.aj;
import com.baidu.live.data.aq;
import com.baidu.live.data.bm;
import com.baidu.live.data.w;
import com.baidu.live.message.e;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.live.finish.FinishLiveManager;
import com.baidu.live.tbadk.load.library.LoadLibraryManager;
import com.baidu.live.tbadk.location.LocationInfo;
import com.baidu.live.tbadk.location.LocationManager;
import com.baidu.live.tbadk.location.interfaces.ILocation;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.p.c;
import com.baidu.tieba.ala.liveroom.p.d;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private j bAN;
    private AlaLiveRecorder bAP;
    private c hcX;
    private com.baidu.live.tieba.e.b hfa;
    private AlaMasterLiveRoomActivity huI;
    private ViewGroup huJ;
    private RelativeLayout huK;
    private FrameLayout huL;
    private AlaLiveFoucsExposureViewContainer huM;
    private View huN;
    private AlaLiveView huO;
    private ViewGroup huP;
    private LayerRootView huQ;
    private String huR;
    private int huV;
    private short huX;
    private com.baidu.live.al.a huY;
    private d huZ;
    private com.baidu.tieba.ala.liveroom.p.d huw;
    private String mForumId;
    private String mForumName;
    private boolean huS = false;
    private Handler mHandler = new Handler();
    private boolean huT = false;
    private long huU = 0;
    private int huW = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hva = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.huS = dVar.hqg;
                if (dVar.hqc) {
                    a.this.chf();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void wX(int i) {
            if (i == 2) {
                a.this.TL();
                if (a.this.huT) {
                    a.this.wV(2);
                }
                a.this.bAP.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bAP.addRecorderCallback(a.this.hvd);
                a.this.huO.setBackgroundColor(a.this.huI.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.huS) {
                    a.this.bAP.switchOrientation(a.this.huS);
                    a.this.bAP.addRecorderCallback(a.this.hvd);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2 = -1;
            a.this.huX = s;
            if (a.this.huI != null) {
                if (a.this.huX == 1) {
                    a.this.huI.cgT();
                } else {
                    a.this.huI.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.huw == null || a.this.huw.Iq() == null || a.this.huw.Iq().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.huw.Iq().mLiveInfo.room_id;
                    j2 = a.this.huw.Iq().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime"));
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void Yj() {
            if (a.this.huN != null) {
                if (a.this.huN.getParent() != null) {
                    ((ViewGroup) a.this.huN.getParent()).removeView(a.this.huN);
                }
                a.this.huN = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.huL.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.huL.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bhU() {
            if (a.this.huN == null) {
                a.this.huN = a.this.bAP.createPKPlayer();
            }
            if (a.this.huN != null && a.this.huN.getParent() == null) {
                a.this.huL.addView(a.this.huN, a.this.chc());
            }
            if (a.this.bAP != null && a.this.bAP.getPreview() != null) {
                FrameLayout.LayoutParams chb = a.this.chb();
                if (a.this.bAP.getVideoConfig() != null) {
                    chb.height = (a.this.bAP.getVideoConfig().getVideoHeight() * chb.width) / a.this.bAP.getVideoConfig().getVideoWidth();
                }
                a.this.bAP.getPreview().setLayoutParams(chb);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceG() {
            FrameLayout.LayoutParams chb = a.this.chb();
            int bh = h.bh(a.this.huI.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.huL.getLayoutParams();
            layoutParams.height = chb.height;
            layoutParams.topMargin = bh;
            a.this.huL.setLayoutParams(layoutParams);
            if (a.this.bAP.getVideoConfig() != null) {
                chb.height = (a.this.bAP.getVideoConfig().getVideoHeight() * chb.width) / a.this.bAP.getVideoConfig().getVideoWidth();
            }
            a.this.bAP.getPreview().setLayoutParams(chb);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceH() {
            a.this.TL();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceI() {
            a.this.cha();
        }
    };
    private CustomMessageListener hvb = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bAP.stopRecord();
                } else {
                    a.this.bAP.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0175a hvc = new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hvd = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.huZ != null) {
                a.this.huZ.ciP();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.huZ != null) {
                a.this.huZ.ciP();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                a.this.huZ.ciR().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.huZ != null) {
                a.this.huZ.streamStateReceived(i, z, i2, z2);
            }
            a.this.huW = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.huZ != null) {
                if (z) {
                    a.this.huZ.bi(0, null);
                } else {
                    a.this.huZ.bi(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.huZ != null && a.this.huZ.ciR() != null) {
                a.this.huZ.ciR().errCode = 2;
                a.this.huZ.bj(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.huZ != null && a.this.huZ.ciR() != null) {
                a.this.huZ.ciR().linkTime = alaLiveDebugInfo.connectTime;
                a.this.huZ.ciR().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.huZ.ciR().startLiveTime == 0) {
                    a.this.huZ.ciR().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.wW(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.huI.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bAP != null && a.this.bAP.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bAP.getPreview() != null) {
                        a.this.TL();
                    }
                    a.this.bAP.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bAP.addRecorderCallback(a.this.hvd);
                    a.this.bAP.stopRecord();
                    if (a.this.bAP.getPreview() != null) {
                        a.this.cha();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bAP != null) {
                                a.this.bAP.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bAP.changeVideoRecorderType(com.baidu.live.ae.a.RB().brA != null ? com.baidu.live.ae.a.RB().brA.aML : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bAP.addRecorderCallback(a.this.hvd);
                if (a.this.bAP.getPreview() != null) {
                    a.this.cha();
                }
                i2 = -4;
            }
            if (a.this.huZ != null) {
                a.this.huZ.bj(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.huZ != null) {
                a.this.huZ.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.huZ != null) {
                a.this.huZ.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void sendBufferChanged(int i) {
            if (a.this.huZ != null) {
                a.this.huZ.sendBufferChanged(i);
            }
        }
    };
    private d.a hve = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.p.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                aq cjz = a.this.huw.cjz();
                if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                    a.this.huZ.ciR().logID = cjz.logId;
                    a.this.huZ.ciR().errCode = 5;
                }
                if (!a.this.a(cjz)) {
                    if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                        a.this.huZ.ciR().updateTime = System.currentTimeMillis() - a.this.huZ.ciR().updateTime;
                    }
                    if (cjz.aPf != 1) {
                        if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                            a.this.huZ.ciR().errSubReason = -1;
                        }
                        a.this.huI.showToast(cjz.aPg);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cjz.mErrorCode != 0) {
                        if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                            a.this.huZ.ciR().errCode = 5;
                            a.this.huZ.ciR().errSubReason = cjz.mErrorCode;
                        }
                        a.this.huI.showToast(str);
                        if (cjz.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.huI.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                            a.this.huZ.ciR().errCode = 0;
                            a.this.huZ.ciR().errSubReason = 0;
                        }
                        if (a.this.bAP != null) {
                            a.this.bAP.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.ae.a.RB().brA.aMY);
                            a.this.bAP.setStartInfo(Long.toString(a.this.huw.Iq().mLiveInfo.live_id), a.this.huw.Iq().mLiveInfo.getSessionID(), com.baidu.live.ae.a.RB().brA.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.huZ != null) {
                            a.this.huZ.c(a.this.huw.cjz());
                        }
                        a.this.chf();
                    }
                    if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                        a.this.huZ.ciR().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.huZ != null) {
                    a.this.huZ.cic();
                }
            } else if (i2 == 1) {
                a.this.chg();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hxG == 2) {
                                a.this.huZ.ciR().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hxG == 3) {
                                a.this.huZ.ciR().errSubReason = -3;
                            }
                        }
                        if (a.this.huZ != null && alaGetVerifyStrategyResponseHttpMessage.hxE == 1 && alaGetVerifyStrategyResponseHttpMessage.hxG == 1 && alaGetVerifyStrategyResponseHttpMessage.hxJ == 1 && alaGetVerifyStrategyResponseHttpMessage.hxL == 1) {
                            a.this.huZ.ceD();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.huI.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.huZ != null) {
                    a.this.huZ.cio();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hxG != 3 ? 0 : 3;
                    if (a.this.huY != null && a.this.huZ != null) {
                        a.this.huY.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.huZ.ceF(), a.this.huR).gB(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.huZ != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.huZ;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.nC(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.huI = alaMasterLiveRoomActivity;
        this.hfa = new com.baidu.live.tieba.e.b(this.huI.getActivity());
        chj();
        this.hcX = new c();
        MessageManager.getInstance().registerListener(this.hvb);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.al.a.class, this.huI.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.huY = (com.baidu.live.al.a) runTask.getData();
            if (this.huY != null) {
                this.huY.a(this.hvc);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        CustomResponsedMessage runTask;
        this.huw = dVar;
        if (this.huw == null) {
            this.huw = new com.baidu.tieba.ala.liveroom.p.d(this.huI.getPageContext());
        }
        if (this.bAN == null && (runTask = MessageManager.getInstance().runTask(2913177, j.class, this.huI.getPageContext().getPageActivity())) != null) {
            this.bAN = (j) runTask.getData();
        }
        if (this.bAN != null) {
            this.bAN.b(null);
            this.bAN.a(null);
            this.bAN.c(null);
        }
        this.huw.a(this.hve);
        if (this.huZ != null) {
            this.huZ.setArModel(this.bAN);
            this.huZ.a(this.huw);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.huR = str3;
        this.huT = false;
        nR(false);
        chd();
        if (this.huZ != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hqs = bundle;
            this.huZ.b(fVar);
            if (this.huZ.ceF() == 1) {
                wV(this.huZ.ceF());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.huV = alaLivePersonData.mLiveInfo.clarity;
        this.huT = true;
        this.huS = alaLivePersonData.mLiveInfo.screen_direction == 2;
        nR(true);
        chd();
        if (this.huZ != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hqr = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                wV(alaLivePersonData.mLiveInfo.live_type);
            }
            this.huZ.b(fVar);
        }
        if (this.huw != null) {
            this.huw.h(alaLivePersonData);
        }
    }

    private void cgY() {
        this.huS = com.baidu.live.d.BM().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cgZ() {
        this.huV = com.baidu.live.d.BM().getInt("live_recorder_resolution_level", 2);
    }

    private void nR(boolean z) {
        if (!z) {
            cgZ();
            cgY();
        }
        this.huJ = (ViewGroup) View.inflate(this.huI.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.huI.addContentView(this.huJ, new FrameLayout.LayoutParams(-1, -1));
        this.huI.setContentView(this.huJ);
        this.huL = (FrameLayout) this.huJ.findViewById(a.f.ala_live_render_view);
        this.huO = (AlaLiveView) this.huJ.findViewById(a.f.ala_liveroom_host_liveview);
        this.huO.setVisibility(8);
        this.huO.setSwipeClearEnable(true);
        this.huK = (RelativeLayout) this.huJ.findViewById(a.f.ala_live_unremovable_container);
        this.huP = (ViewGroup) this.huJ.findViewById(a.f.func_view);
        this.huQ = (LayerRootView) this.huJ.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.EY().j(this.huQ);
        this.huK.requestLayout();
        this.huJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.huO == null || a.this.huO.hFt) {
                    return false;
                }
                a.this.huO.W(motionEvent);
                a.this.huM.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.QY().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aMM) {
            VideoBeautyType videoBeautyType2 = VideoBeautyType.BEAUTY_FACEUNITY;
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            if (LoadLibraryManager.getInstance().getLoadLibraryCallback() != null) {
                AlaLiveRecorderConfig.setILoadLibraryCallback(new AlaLiveRecorderConfig.ILoadLibrary() { // from class: com.baidu.tieba.ala.liveroom.master.a.8
                    @Override // com.baidu.ala.recorder.AlaLiveRecorderConfig.ILoadLibrary
                    public boolean loadlibrary(String str) {
                        return LoadLibraryManager.getInstance().getLoadLibraryCallback().loadLibrary(str);
                    }
                });
            }
            if (LoadLibraryManager.getInstance().getFaceUnityCallBack() != null) {
                AlaLiveRecorderConfig.setFaceUnityCallback(new AlaLiveRecorderConfig.FaceUnityCallBack() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
                    @Override // com.baidu.ala.recorder.AlaLiveRecorderConfig.FaceUnityCallBack
                    public byte[] getAuthPackCert() {
                        return LoadLibraryManager.getInstance().getFaceUnityCallBack().getAuthPackCert();
                    }

                    @Override // com.baidu.ala.recorder.AlaLiveRecorderConfig.FaceUnityCallBack
                    public byte[] getFaceBeautificationData() {
                        return LoadLibraryManager.getInstance().getFaceUnityCallBack().getFaceBeautificationData();
                    }

                    @Override // com.baidu.ala.recorder.AlaLiveRecorderConfig.FaceUnityCallBack
                    public byte[] getV3Data() {
                        return LoadLibraryManager.getInstance().getFaceUnityCallBack().getV3Data();
                    }
                });
            }
        }
        VideoBeautyType videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        if (bm.b(com.baidu.live.ae.a.RB().bxq)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bm.a(com.baidu.live.ae.a.RB().bxq)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bAP = new AlaLiveRecorder(this.huI.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bAP.addRecorderCallback(this.hvd);
        LiveRecorderConfigHelper.QY().Ra();
        if (!this.huS && this.bAP.getPreview() != null) {
            cha();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TL() {
        if (this.bAP != null && this.bAP.getPreview() != null && this.bAP.getPreview().getParent() != null) {
            ((ViewGroup) this.bAP.getPreview().getParent()).removeView(this.bAP.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cha() {
        this.bAP.getPreview().setEnabled(false);
        TL();
        if (this.huN == null) {
            this.huL.addView(this.bAP.getPreview(), 0, TK());
        } else {
            this.huL.addView(this.bAP.getPreview(), 0, chb());
        }
        if (this.huM == null) {
            this.huM = new AlaLiveFoucsExposureViewContainer(this.huL.getContext());
            this.huM.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.huw != null && a.this.huw.Iq() != null) {
                        alaLiveInfoData = a.this.huw.Iq().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bAP != null) {
                        a.this.bAP.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bAP != null) {
                        a.this.bAP.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void chl() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.huw != null && a.this.huw.Iq() != null) {
                        alaLiveInfoData = a.this.huw.Iq().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "biasbar_click").setContentExt(jSONObject));
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public float getExposure() {
                    if (a.this.bAP != null) {
                        return a.this.bAP.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.huL.addView(this.huM, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams TK() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams chb() {
        int i = BdUtilHelper.getScreenDimensions(this.huI.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gC(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams chc() {
        int i = BdUtilHelper.getScreenDimensions(this.huI.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gC(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        if (this.huT) {
            this.bAP.setVideoConfig(LiveRecorderConfigHelper.QY().d(this.huV, i, this.huS));
        } else {
            this.bAP.setVideoConfig(LiveRecorderConfigHelper.QY().d(i == 1 ? 0 : this.huV, i, i == 1 ? this.huS : false));
        }
    }

    private void chd() {
        this.huZ = new com.baidu.tieba.ala.liveroom.master.a.d(this.huI, this.bAP, this.huO, this.huL, this.huJ, this.huP, this.hfa, this.huI.cgU(), this.huM);
        this.huZ.a(this.huw);
        this.huZ.setArModel(this.bAN);
        this.huZ.a(this.hva);
    }

    public void che() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.huI.getPageContext().getPageActivity());
        if (this.bAP != null && this.bAP.getPreview() != null && (this.huN == null || this.huN.getParent() == null)) {
            this.bAP.getPreview().setLayoutParams(TK());
        }
        if (this.huZ != null) {
            this.huZ.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.huI.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.huZ != null) {
            this.huZ.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        if (this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null) {
            if (this.huZ != null && this.huZ.ciR() != null) {
                this.huZ.ciR().liveID = Long.toString(this.huw.Iq().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.huw.cjz().mLiveInfo.live_id), String.valueOf(this.huw.cjz().mLiveInfo.room_id), String.valueOf(this.huw.cjz().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.huw.cjz().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.huw.cjz().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.huw.cjz().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime").setContentExt(jSONObject));
            this.huU = System.currentTimeMillis() / 1000;
            this.huw.u(this.huw.Iq().mLiveInfo.live_id, this.huU);
            this.huw.h(this.huw.Iq().mLiveInfo.live_id, false);
            com.baidu.live.d.BM().putLong("last_live_room_id", this.huw.Iq().mLiveInfo.live_id);
            this.huw.cjE();
            if (this.huZ != null && this.huZ.ciR() != null) {
                if (this.huZ.ceF() == 2) {
                    if (this.huS) {
                        this.huZ.ciR().liveType = 5;
                    } else {
                        this.huZ.ciR().liveType = 4;
                    }
                } else if (this.huZ.ceF() == 1) {
                    if (this.huS) {
                        this.huZ.ciR().liveType = 2;
                    } else {
                        this.huZ.ciR().liveType = 1;
                    }
                }
            }
            chk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chg() {
        final w Iq = this.huw.Iq();
        if (Iq != null && Iq.mLiveInfo != null) {
            if (this.huZ == null || !this.huZ.ciO()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.huw.u(Iq.mLiveInfo.live_id, a.this.huU);
                    }
                }, Iq.aKa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aq aqVar) {
        if (aqVar == null) {
            return false;
        }
        this.huI.closeLoadingDialog();
        if (aqVar.mErrorCode == 6) {
            this.huI.showToast(aqVar.mErrorMsg);
            if (this.huZ != null && this.huZ.ciR() != null) {
                this.huZ.ciR().errSubReason = 6;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hqc) {
            boolean z = dVar.hqd;
            String str2 = null;
            String str3 = null;
            double d = 0.0d;
            double d2 = 0.0d;
            if (!z || (buildLocation = LocationManager.getInstance().buildLocation()) == null || buildLocation.getLocationInfo() == null) {
                str = null;
            } else {
                LocationInfo locationInfo = buildLocation.getLocationInfo();
                str2 = locationInfo.getCurCityName();
                if (!TextUtils.isEmpty(str2) && (md5 = Md5.toMd5("千@奇#百￥怪" + str2 + "哈哈·嘻嘻※嘿嘿")) != null) {
                    str3 = md5.toLowerCase();
                }
                d = locationInfo.latitude;
                d2 = locationInfo.longitude;
                str = str3;
            }
            if (this.huZ != null) {
                if (this.huZ.ciR() != null) {
                    this.huZ.ciR().updateTime = System.currentTimeMillis();
                }
                this.huw.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hqe, dVar.hqf ? 1 : 0, this.huZ.ceF(), this.huS ? 2 : 1, this.huV, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void chh() {
        if (this.huZ != null && !this.huZ.ciQ() && this.huw.cjz() == null && this.huZ != null) {
            a(this.huZ.ciS());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.huZ != null) {
            this.huZ.markEnterBackground();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bAP != null) {
            this.bAP.setIsAutoStartFromBack(true);
        }
        if (this.huZ != null) {
            this.huZ.markEnterForeground();
        }
    }

    public void onPause() {
        if (this.huZ != null) {
            this.huZ.onPause();
        }
    }

    public void onFinish() {
        if (this.huZ != null) {
            this.huZ.j(this.huX);
        }
    }

    public void onDestroy() {
        if (this.hcX != null) {
            this.hcX.release();
            this.hcX = null;
        }
        if (this.huZ != null) {
            this.huZ.onDestroy();
        }
        if (this.huY != null) {
            this.huY.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.hfa.stop();
        this.hfa = null;
        if (this.huw != null) {
            this.huw.destory();
            this.huw = null;
        }
        if (this.bAN != null) {
            this.bAN.destory();
            this.bAN = null;
        }
        if (this.bAP != null) {
            aj ajVar = new aj();
            ajVar.aLF = this.huS ? 2 : 1;
            ajVar.mOpenType = 2;
            if (this.huZ != null) {
                ajVar.aLE = this.huZ.ceF();
            }
            this.bAP.setRoomInfo(ajVar.toJsonString());
            String str = "";
            if (this.huZ != null && this.huZ.ciR() != null) {
                if (this.huZ.ciR().startLiveTime != 0) {
                    str = Long.toString(this.huZ.ciR().startLiveTime);
                }
                this.bAP.setConfigBeforeStop(this.huZ.ciR().getCpuMemJsonFormat(), str, "");
            }
            this.bAP.stopRecord();
            this.bAP.release();
            this.bAP.removeRecorderCallback(this.hvd);
            this.bAP = null;
        }
        if (this.huO != null) {
            this.huO.setOnTouchListener(null);
            this.huO.cll();
            this.huO = null;
        }
        this.huI = null;
        MessageManager.getInstance().unRegisterListener(this.hvb);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dX(int i) {
        this.huO.dX(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.huI.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.huI.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.huJ.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.huJ.setLayoutParams(layoutParams);
            if (this.huT && this.bAP != null && this.bAP.getPreview() != null && this.bAP.getPreview().getParent() == null) {
                cha();
            }
        }
        if (this.huZ != null) {
            this.huZ.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.huI.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.huZ != null) {
            this.huZ.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.huZ != null) {
            this.huZ.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int chi() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chj() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.huZ != null && a.this.huZ.ciR() != null) {
                        a.this.huZ.ciR().sampleMemAndCPU();
                    }
                    a.this.chj();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chk() {
        if (this.mHandler != null && this.bAP != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.wW(0);
                    a.this.chk();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wW(int i) {
        if (this.huZ != null && this.huZ.ciR() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bAP.getMediaStatus();
            if (this.huw != null && this.huw.cjz() != null && this.huw.cjz().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.huw.cjz().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.huw.cjz().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bAP.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveExceptionInfo.dropFrame = (recorderDebugInfo.currentDropA > 0 ? 4 : 0) + (recorderDebugInfo.currentDropI > 0 ? 2 : 0) + (recorderDebugInfo.currentDropP > 0 ? 1 : 0);
                if (recorderDebugInfo.monitorInterval != 0) {
                    alaLiveExceptionInfo.netSpped = String.format("%.2f", Float.valueOf(((float) (recorderDebugInfo.currentBandWidth / recorderDebugInfo.monitorInterval)) / 1024.0f));
                }
                alaLiveExceptionInfo.fpsMin = recorderDebugInfo.fpsMin;
                alaLiveExceptionInfo.fpsMax = recorderDebugInfo.fpsMax;
                alaLiveExceptionInfo.fpsAvg = recorderDebugInfo.fpsAvg;
                alaLiveExceptionInfo.failureAudio = recorderDebugInfo.failureAudio;
                alaLiveExceptionInfo.failureVideo = recorderDebugInfo.failureVideo;
                alaLiveExceptionInfo.connectCount = recorderDebugInfo.connectCnt;
                alaLiveExceptionInfo.playFail = recorderDebugInfo.statusCode;
            }
            if (i != 0) {
                alaLiveExceptionInfo.dropFrame = i;
            }
            if (this.huI != null) {
                alaLiveExceptionInfo.appState = this.huI.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.huW;
            alaLiveExceptionInfo.sessionChannel = chi();
            alaLiveExceptionInfo.nodeIP = this.bAP.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.huZ.ciR().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.huZ.ciR().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.huZ.ciR().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.huZ != null) {
            return this.huZ.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hva.g(s);
    }
}
