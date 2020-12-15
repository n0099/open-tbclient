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
    private c hcZ;
    private com.baidu.live.tieba.e.b hfc;
    private AlaMasterLiveRoomActivity huK;
    private ViewGroup huL;
    private RelativeLayout huM;
    private FrameLayout huN;
    private AlaLiveFoucsExposureViewContainer huO;
    private View huP;
    private AlaLiveView huQ;
    private ViewGroup huR;
    private LayerRootView huS;
    private String huT;
    private int huX;
    private short huZ;
    private d huy;
    private com.baidu.live.al.a hva;
    private com.baidu.tieba.ala.liveroom.master.a.d hvb;
    private String mForumId;
    private String mForumName;
    private boolean huU = false;
    private Handler mHandler = new Handler();
    private boolean huV = false;
    private long huW = 0;
    private int huY = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hvc = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.huU = dVar.hqi;
                if (dVar.hqe) {
                    a.this.chg();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void wX(int i) {
            if (i == 2) {
                a.this.TL();
                if (a.this.huV) {
                    a.this.wV(2);
                }
                a.this.bAP.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bAP.addRecorderCallback(a.this.hvf);
                a.this.huQ.setBackgroundColor(a.this.huK.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.huU) {
                    a.this.bAP.switchOrientation(a.this.huU);
                    a.this.bAP.addRecorderCallback(a.this.hvf);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2 = -1;
            a.this.huZ = s;
            if (a.this.huK != null) {
                if (a.this.huZ == 1) {
                    a.this.huK.cgU();
                } else {
                    a.this.huK.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.huy == null || a.this.huy.Iq() == null || a.this.huy.Iq().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.huy.Iq().mLiveInfo.room_id;
                    j2 = a.this.huy.Iq().mLiveInfo.live_id;
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
            if (a.this.huP != null) {
                if (a.this.huP.getParent() != null) {
                    ((ViewGroup) a.this.huP.getParent()).removeView(a.this.huP);
                }
                a.this.huP = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.huN.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.huN.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bhU() {
            if (a.this.huP == null) {
                a.this.huP = a.this.bAP.createPKPlayer();
            }
            if (a.this.huP != null && a.this.huP.getParent() == null) {
                a.this.huN.addView(a.this.huP, a.this.chd());
            }
            if (a.this.bAP != null && a.this.bAP.getPreview() != null) {
                FrameLayout.LayoutParams chc = a.this.chc();
                if (a.this.bAP.getVideoConfig() != null) {
                    chc.height = (a.this.bAP.getVideoConfig().getVideoHeight() * chc.width) / a.this.bAP.getVideoConfig().getVideoWidth();
                }
                a.this.bAP.getPreview().setLayoutParams(chc);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceH() {
            FrameLayout.LayoutParams chc = a.this.chc();
            int bh = h.bh(a.this.huK.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.huN.getLayoutParams();
            layoutParams.height = chc.height;
            layoutParams.topMargin = bh;
            a.this.huN.setLayoutParams(layoutParams);
            if (a.this.bAP.getVideoConfig() != null) {
                chc.height = (a.this.bAP.getVideoConfig().getVideoHeight() * chc.width) / a.this.bAP.getVideoConfig().getVideoWidth();
            }
            a.this.bAP.getPreview().setLayoutParams(chc);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceI() {
            a.this.TL();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceJ() {
            a.this.chb();
        }
    };
    private CustomMessageListener hvd = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
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
    private a.InterfaceC0175a hve = new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hvf = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hvb != null) {
                a.this.hvb.ciQ();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hvb != null) {
                a.this.hvb.ciQ();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                a.this.hvb.ciS().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hvb != null) {
                a.this.hvb.streamStateReceived(i, z, i2, z2);
            }
            a.this.huY = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hvb != null) {
                if (z) {
                    a.this.hvb.bi(0, null);
                } else {
                    a.this.hvb.bi(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hvb != null && a.this.hvb.ciS() != null) {
                a.this.hvb.ciS().errCode = 2;
                a.this.hvb.bj(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hvb != null && a.this.hvb.ciS() != null) {
                a.this.hvb.ciS().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hvb.ciS().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hvb.ciS().startLiveTime == 0) {
                    a.this.hvb.ciS().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
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
                a.this.huK.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bAP != null && a.this.bAP.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bAP.getPreview() != null) {
                        a.this.TL();
                    }
                    a.this.bAP.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bAP.addRecorderCallback(a.this.hvf);
                    a.this.bAP.stopRecord();
                    if (a.this.bAP.getPreview() != null) {
                        a.this.chb();
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
                a.this.bAP.addRecorderCallback(a.this.hvf);
                if (a.this.bAP.getPreview() != null) {
                    a.this.chb();
                }
                i2 = -4;
            }
            if (a.this.hvb != null) {
                a.this.hvb.bj(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hvb != null) {
                a.this.hvb.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hvb != null) {
                a.this.hvb.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void sendBufferChanged(int i) {
            if (a.this.hvb != null) {
                a.this.hvb.sendBufferChanged(i);
            }
        }
    };
    private d.a hvg = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.p.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                aq cjA = a.this.huy.cjA();
                if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                    a.this.hvb.ciS().logID = cjA.logId;
                    a.this.hvb.ciS().errCode = 5;
                }
                if (!a.this.a(cjA)) {
                    if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                        a.this.hvb.ciS().updateTime = System.currentTimeMillis() - a.this.hvb.ciS().updateTime;
                    }
                    if (cjA.aPf != 1) {
                        if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                            a.this.hvb.ciS().errSubReason = -1;
                        }
                        a.this.huK.showToast(cjA.aPg);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cjA.mErrorCode != 0) {
                        if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                            a.this.hvb.ciS().errCode = 5;
                            a.this.hvb.ciS().errSubReason = cjA.mErrorCode;
                        }
                        a.this.huK.showToast(str);
                        if (cjA.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.huK.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                            a.this.hvb.ciS().errCode = 0;
                            a.this.hvb.ciS().errSubReason = 0;
                        }
                        if (a.this.bAP != null) {
                            a.this.bAP.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.ae.a.RB().brA.aMY);
                            a.this.bAP.setStartInfo(Long.toString(a.this.huy.Iq().mLiveInfo.live_id), a.this.huy.Iq().mLiveInfo.getSessionID(), com.baidu.live.ae.a.RB().brA.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.hvb != null) {
                            a.this.hvb.c(a.this.huy.cjA());
                        }
                        a.this.chg();
                    }
                    if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                        a.this.hvb.ciS().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hvb != null) {
                    a.this.hvb.cid();
                }
            } else if (i2 == 1) {
                a.this.chh();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hxI == 2) {
                                a.this.hvb.ciS().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hxI == 3) {
                                a.this.hvb.ciS().errSubReason = -3;
                            }
                        }
                        if (a.this.hvb != null && alaGetVerifyStrategyResponseHttpMessage.hxG == 1 && alaGetVerifyStrategyResponseHttpMessage.hxI == 1 && alaGetVerifyStrategyResponseHttpMessage.hxL == 1 && alaGetVerifyStrategyResponseHttpMessage.hxN == 1) {
                            a.this.hvb.ceE();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.huK.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hvb != null) {
                    a.this.hvb.cip();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hxI != 3 ? 0 : 3;
                    if (a.this.hva != null && a.this.hvb != null) {
                        a.this.hva.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hvb.ceG(), a.this.huT).gB(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hvb != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hvb;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.nC(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.huK = alaMasterLiveRoomActivity;
        this.hfc = new com.baidu.live.tieba.e.b(this.huK.getActivity());
        chk();
        this.hcZ = new c();
        MessageManager.getInstance().registerListener(this.hvd);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.al.a.class, this.huK.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hva = (com.baidu.live.al.a) runTask.getData();
            if (this.hva != null) {
                this.hva.a(this.hve);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.huy = dVar;
        if (this.huy == null) {
            this.huy = new d(this.huK.getPageContext());
        }
        if (this.bAN == null && (runTask = MessageManager.getInstance().runTask(2913177, j.class, this.huK.getPageContext().getPageActivity())) != null) {
            this.bAN = (j) runTask.getData();
        }
        if (this.bAN != null) {
            this.bAN.b(null);
            this.bAN.a(null);
            this.bAN.c(null);
        }
        this.huy.a(this.hvg);
        if (this.hvb != null) {
            this.hvb.setArModel(this.bAN);
            this.hvb.a(this.huy);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.huT = str3;
        this.huV = false;
        nR(false);
        che();
        if (this.hvb != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hqu = bundle;
            this.hvb.b(fVar);
            if (this.hvb.ceG() == 1) {
                wV(this.hvb.ceG());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.huX = alaLivePersonData.mLiveInfo.clarity;
        this.huV = true;
        this.huU = alaLivePersonData.mLiveInfo.screen_direction == 2;
        nR(true);
        che();
        if (this.hvb != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hqt = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                wV(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hvb.b(fVar);
        }
        if (this.huy != null) {
            this.huy.h(alaLivePersonData);
        }
    }

    private void cgZ() {
        this.huU = com.baidu.live.d.BM().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cha() {
        this.huX = com.baidu.live.d.BM().getInt("live_recorder_resolution_level", 2);
    }

    private void nR(boolean z) {
        if (!z) {
            cha();
            cgZ();
        }
        this.huL = (ViewGroup) View.inflate(this.huK.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.huK.addContentView(this.huL, new FrameLayout.LayoutParams(-1, -1));
        this.huK.setContentView(this.huL);
        this.huN = (FrameLayout) this.huL.findViewById(a.f.ala_live_render_view);
        this.huQ = (AlaLiveView) this.huL.findViewById(a.f.ala_liveroom_host_liveview);
        this.huQ.setVisibility(8);
        this.huQ.setSwipeClearEnable(true);
        this.huM = (RelativeLayout) this.huL.findViewById(a.f.ala_live_unremovable_container);
        this.huR = (ViewGroup) this.huL.findViewById(a.f.func_view);
        this.huS = (LayerRootView) this.huL.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.EY().j(this.huS);
        this.huM.requestLayout();
        this.huL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.huQ == null || a.this.huQ.hFv) {
                    return false;
                }
                a.this.huQ.W(motionEvent);
                a.this.huO.R(motionEvent);
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
        this.bAP = new AlaLiveRecorder(this.huK.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bAP.addRecorderCallback(this.hvf);
        LiveRecorderConfigHelper.QY().Ra();
        if (!this.huU && this.bAP.getPreview() != null) {
            chb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TL() {
        if (this.bAP != null && this.bAP.getPreview() != null && this.bAP.getPreview().getParent() != null) {
            ((ViewGroup) this.bAP.getPreview().getParent()).removeView(this.bAP.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chb() {
        this.bAP.getPreview().setEnabled(false);
        TL();
        if (this.huP == null) {
            this.huN.addView(this.bAP.getPreview(), 0, TK());
        } else {
            this.huN.addView(this.bAP.getPreview(), 0, chc());
        }
        if (this.huO == null) {
            this.huO = new AlaLiveFoucsExposureViewContainer(this.huN.getContext());
            this.huO.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.huy != null && a.this.huy.Iq() != null) {
                        alaLiveInfoData = a.this.huy.Iq().mLiveInfo;
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
                public void chm() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.huy != null && a.this.huy.Iq() != null) {
                        alaLiveInfoData = a.this.huy.Iq().mLiveInfo;
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
            this.huN.addView(this.huO, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams TK() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams chc() {
        int i = BdUtilHelper.getScreenDimensions(this.huK.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gC(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams chd() {
        int i = BdUtilHelper.getScreenDimensions(this.huK.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gC(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        if (this.huV) {
            this.bAP.setVideoConfig(LiveRecorderConfigHelper.QY().d(this.huX, i, this.huU));
        } else {
            this.bAP.setVideoConfig(LiveRecorderConfigHelper.QY().d(i == 1 ? 0 : this.huX, i, i == 1 ? this.huU : false));
        }
    }

    private void che() {
        this.hvb = new com.baidu.tieba.ala.liveroom.master.a.d(this.huK, this.bAP, this.huQ, this.huN, this.huL, this.huR, this.hfc, this.huK.cgV(), this.huO);
        this.hvb.a(this.huy);
        this.hvb.setArModel(this.bAN);
        this.hvb.a(this.hvc);
    }

    public void chf() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.huK.getPageContext().getPageActivity());
        if (this.bAP != null && this.bAP.getPreview() != null && (this.huP == null || this.huP.getParent() == null)) {
            this.bAP.getPreview().setLayoutParams(TK());
        }
        if (this.hvb != null) {
            this.hvb.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.huK.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hvb != null) {
            this.hvb.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chg() {
        if (this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null) {
            if (this.hvb != null && this.hvb.ciS() != null) {
                this.hvb.ciS().liveID = Long.toString(this.huy.Iq().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.huy.cjA().mLiveInfo.live_id), String.valueOf(this.huy.cjA().mLiveInfo.room_id), String.valueOf(this.huy.cjA().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.huy.cjA().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.huy.cjA().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.huy.cjA().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime").setContentExt(jSONObject));
            this.huW = System.currentTimeMillis() / 1000;
            this.huy.u(this.huy.Iq().mLiveInfo.live_id, this.huW);
            this.huy.h(this.huy.Iq().mLiveInfo.live_id, false);
            com.baidu.live.d.BM().putLong("last_live_room_id", this.huy.Iq().mLiveInfo.live_id);
            this.huy.cjF();
            if (this.hvb != null && this.hvb.ciS() != null) {
                if (this.hvb.ceG() == 2) {
                    if (this.huU) {
                        this.hvb.ciS().liveType = 5;
                    } else {
                        this.hvb.ciS().liveType = 4;
                    }
                } else if (this.hvb.ceG() == 1) {
                    if (this.huU) {
                        this.hvb.ciS().liveType = 2;
                    } else {
                        this.hvb.ciS().liveType = 1;
                    }
                }
            }
            chl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chh() {
        final w Iq = this.huy.Iq();
        if (Iq != null && Iq.mLiveInfo != null) {
            if (this.hvb == null || !this.hvb.ciP()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.huy.u(Iq.mLiveInfo.live_id, a.this.huW);
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
        this.huK.closeLoadingDialog();
        if (aqVar.mErrorCode == 6) {
            this.huK.showToast(aqVar.mErrorMsg);
            if (this.hvb != null && this.hvb.ciS() != null) {
                this.hvb.ciS().errSubReason = 6;
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
        if (dVar != null && !dVar.hqe) {
            boolean z = dVar.hqf;
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
            if (this.hvb != null) {
                if (this.hvb.ciS() != null) {
                    this.hvb.ciS().updateTime = System.currentTimeMillis();
                }
                this.huy.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hqg, dVar.hqh ? 1 : 0, this.hvb.ceG(), this.huU ? 2 : 1, this.huX, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void chi() {
        if (this.hvb != null && !this.hvb.ciR() && this.huy.cjA() == null && this.hvb != null) {
            a(this.hvb.ciT());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hvb != null) {
            this.hvb.markEnterBackground();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bAP != null) {
            this.bAP.setIsAutoStartFromBack(true);
        }
        if (this.hvb != null) {
            this.hvb.markEnterForeground();
        }
    }

    public void onPause() {
        if (this.hvb != null) {
            this.hvb.onPause();
        }
    }

    public void onFinish() {
        if (this.hvb != null) {
            this.hvb.j(this.huZ);
        }
    }

    public void onDestroy() {
        if (this.hcZ != null) {
            this.hcZ.release();
            this.hcZ = null;
        }
        if (this.hvb != null) {
            this.hvb.onDestroy();
        }
        if (this.hva != null) {
            this.hva.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.hfc.stop();
        this.hfc = null;
        if (this.huy != null) {
            this.huy.destory();
            this.huy = null;
        }
        if (this.bAN != null) {
            this.bAN.destory();
            this.bAN = null;
        }
        if (this.bAP != null) {
            aj ajVar = new aj();
            ajVar.aLF = this.huU ? 2 : 1;
            ajVar.mOpenType = 2;
            if (this.hvb != null) {
                ajVar.aLE = this.hvb.ceG();
            }
            this.bAP.setRoomInfo(ajVar.toJsonString());
            String str = "";
            if (this.hvb != null && this.hvb.ciS() != null) {
                if (this.hvb.ciS().startLiveTime != 0) {
                    str = Long.toString(this.hvb.ciS().startLiveTime);
                }
                this.bAP.setConfigBeforeStop(this.hvb.ciS().getCpuMemJsonFormat(), str, "");
            }
            this.bAP.stopRecord();
            this.bAP.release();
            this.bAP.removeRecorderCallback(this.hvf);
            this.bAP = null;
        }
        if (this.huQ != null) {
            this.huQ.setOnTouchListener(null);
            this.huQ.clm();
            this.huQ = null;
        }
        this.huK = null;
        MessageManager.getInstance().unRegisterListener(this.hvd);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dX(int i) {
        this.huQ.dX(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.huK.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.huK.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.huL.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.huL.setLayoutParams(layoutParams);
            if (this.huV && this.bAP != null && this.bAP.getPreview() != null && this.bAP.getPreview().getParent() == null) {
                chb();
            }
        }
        if (this.hvb != null) {
            this.hvb.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.huK.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hvb != null) {
            this.hvb.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hvb != null) {
            this.hvb.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int chj() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chk() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hvb != null && a.this.hvb.ciS() != null) {
                        a.this.hvb.ciS().sampleMemAndCPU();
                    }
                    a.this.chk();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chl() {
        if (this.mHandler != null && this.bAP != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.wW(0);
                    a.this.chl();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wW(int i) {
        if (this.hvb != null && this.hvb.ciS() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bAP.getMediaStatus();
            if (this.huy != null && this.huy.cjA() != null && this.huy.cjA().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.huy.cjA().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.huy.cjA().mLiveInfo.getPushUrl();
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
            if (this.huK != null) {
                alaLiveExceptionInfo.appState = this.huK.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.huY;
            alaLiveExceptionInfo.sessionChannel = chj();
            alaLiveExceptionInfo.nodeIP = this.bAP.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hvb.ciS().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hvb.ciS().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hvb.ciS().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hvb != null) {
            return this.hvb.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hvc.g(s);
    }
}
