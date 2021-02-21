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
import com.baidu.live.ak.a;
import com.baidu.live.ar.k;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.ab;
import com.baidu.live.data.ap;
import com.baidu.live.data.aw;
import com.baidu.live.data.bt;
import com.baidu.live.message.e;
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
import com.baidu.tieba.ala.liveroom.n.c;
import com.baidu.tieba.ala.liveroom.n.d;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private k bEu;
    private AlaLiveRecorder bEw;
    private FrameLayout hGA;
    private AlaLiveFoucsExposureViewContainer hGB;
    private View hGC;
    private AlaLiveView hGD;
    private ViewGroup hGE;
    private LayerRootView hGF;
    private String hGG;
    private int hGK;
    private short hGM;
    private com.baidu.live.ak.a hGN;
    private d hGO;
    private com.baidu.tieba.ala.liveroom.n.d hGl;
    private AlaMasterLiveRoomActivity hGx;
    private ViewGroup hGy;
    private RelativeLayout hGz;
    private c hoL;
    private com.baidu.live.tieba.e.b hqK;
    private String mForumId;
    private String mForumName;
    private boolean hGH = false;
    private Handler mHandler = new Handler();
    private boolean hGI = false;
    private long hGJ = 0;
    private int hGL = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hGP = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.hGH = dVar.hBW;
                if (dVar.hBS) {
                    a.this.chd();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void vN(int i) {
            if (i == 2) {
                a.this.SF();
                if (a.this.hGI) {
                    a.this.vL(2);
                }
                a.this.bEw.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bEw.addRecorderCallback(a.this.hGS);
                a.this.hGD.setBackgroundColor(a.this.hGx.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.hGH) {
                    a.this.bEw.switchOrientation(a.this.hGH);
                    a.this.bEw.addRecorderCallback(a.this.hGS);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2;
            a.this.hGM = s;
            if (a.this.hGx != null) {
                if (a.this.hGM == 1) {
                    a.this.hGx.cgR();
                } else {
                    a.this.hGx.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hGl == null || a.this.hGl.Fm() == null || a.this.hGl.Fm().mLiveInfo == null) {
                    j = -1;
                    j2 = -1;
                } else {
                    long j3 = a.this.hGl.Fm().mLiveInfo.room_id;
                    j = a.this.hGl.Fm().mLiveInfo.live_id;
                    j2 = j3;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j, j2);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime"));
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void Xi() {
            if (a.this.hGC != null) {
                if (a.this.hGC.getParent() != null) {
                    ((ViewGroup) a.this.hGC.getParent()).removeView(a.this.hGC);
                }
                a.this.hGC = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hGA.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hGA.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceH() {
            if (a.this.hGC == null) {
                a.this.hGC = a.this.bEw.createPKPlayer();
            }
            if (a.this.hGC != null && a.this.hGC.getParent() == null) {
                a.this.hGA.addView(a.this.hGC, a.this.cha());
            }
            if (a.this.bEw != null && a.this.bEw.getPreview() != null) {
                FrameLayout.LayoutParams cgZ = a.this.cgZ();
                if (a.this.bEw.getVideoConfig() != null) {
                    cgZ.height = (a.this.bEw.getVideoConfig().getVideoHeight() * cgZ.width) / a.this.bEw.getVideoConfig().getVideoWidth();
                }
                a.this.bEw.getPreview().setLayoutParams(cgZ);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceI() {
            FrameLayout.LayoutParams cgZ = a.this.cgZ();
            int bm = h.bm(a.this.hGx.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hGA.getLayoutParams();
            layoutParams.height = cgZ.height;
            layoutParams.topMargin = bm;
            a.this.hGA.setLayoutParams(layoutParams);
            if (a.this.bEw.getVideoConfig() != null) {
                cgZ.height = (a.this.bEw.getVideoConfig().getVideoHeight() * cgZ.width) / a.this.bEw.getVideoConfig().getVideoWidth();
            }
            a.this.bEw.getPreview().setLayoutParams(cgZ);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceJ() {
            a.this.SF();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceK() {
            a.this.cgY();
        }
    };
    private CustomMessageListener hGQ = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bEw.stopRecord();
                } else {
                    a.this.bEw.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0158a hGR = new a.InterfaceC0158a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hGS = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hGO != null) {
                a.this.hGO.ciL();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hGO != null) {
                a.this.hGO.ciL();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                a.this.hGO.ciN().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hGO != null) {
                a.this.hGO.streamStateReceived(i, z, i2, z2);
            }
            a.this.hGL = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hGO != null) {
                if (z) {
                    a.this.hGO.bq(0, null);
                } else {
                    a.this.hGO.bq(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hGO != null && a.this.hGO.ciN() != null) {
                a.this.hGO.ciN().errCode = 2;
                a.this.hGO.br(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hGO != null && a.this.hGO.ciN() != null) {
                a.this.hGO.ciN().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hGO.ciN().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hGO.ciN().startLiveTime == 0) {
                    a.this.hGO.ciN().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.vM(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hGx.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bEw != null && a.this.bEw.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bEw.getPreview() != null) {
                        a.this.SF();
                    }
                    a.this.bEw.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bEw.addRecorderCallback(a.this.hGS);
                    a.this.bEw.stopRecord();
                    if (a.this.bEw.getPreview() != null) {
                        a.this.cgY();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bEw != null) {
                                a.this.bEw.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bEw.changeVideoRecorderType(com.baidu.live.ae.a.Qj().buX != null ? com.baidu.live.ae.a.Qj().buX.aLm : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bEw.addRecorderCallback(a.this.hGS);
                if (a.this.bEw.getPreview() != null) {
                    a.this.cgY();
                }
                i2 = -4;
            }
            if (a.this.hGO != null) {
                a.this.hGO.br(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hGO != null) {
                a.this.hGO.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hGO != null) {
                a.this.hGO.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void sendBufferChanged(int i) {
            if (a.this.hGO != null) {
                a.this.hGO.sendBufferChanged(i);
            }
        }
    };
    private d.a hGT = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.n.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                aw cjv = a.this.hGl.cjv();
                if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                    a.this.hGO.ciN().logID = cjv.logId;
                    a.this.hGO.ciN().errCode = 5;
                }
                if (!a.this.a(cjv)) {
                    if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                        a.this.hGO.ciN().updateTime = System.currentTimeMillis() - a.this.hGO.ciN().updateTime;
                    }
                    if (cjv.aOd != 1) {
                        if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                            a.this.hGO.ciN().errSubReason = -1;
                        }
                        a.this.hGx.showToast(cjv.aOe);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cjv.mErrorCode != 0) {
                        if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                            a.this.hGO.ciN().errCode = 5;
                            a.this.hGO.ciN().errSubReason = cjv.mErrorCode;
                        }
                        a.this.hGx.showToast(str);
                        if (cjv.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hGx.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                            a.this.hGO.ciN().errCode = 0;
                            a.this.hGO.ciN().errSubReason = 0;
                        }
                        if (a.this.bEw != null) {
                            a.this.bEw.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.ae.a.Qj().buX.aLz);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("clientIp", com.baidu.live.ae.a.Qj().buX.clientIP);
                                jSONObject.put("liveId", a.this.hGl.Fm().mLiveInfo.live_id);
                                jSONObject.put("roomId", a.this.hGl.Fm().mLiveInfo.room_id);
                                jSONObject.put("subApp", TbConfig.getSubappType());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            a.this.bEw.setStartInfo(jSONObject);
                        }
                        if (a.this.hGO != null) {
                            a.this.hGO.c(a.this.hGl.cjv());
                        }
                        a.this.chd();
                    }
                    if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                        a.this.hGO.ciN().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hGO != null) {
                    a.this.hGO.chZ();
                }
            } else if (i2 == 1) {
                a.this.che();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hJA == 2) {
                                a.this.hGO.ciN().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hJA == 3) {
                                a.this.hGO.ciN().errSubReason = -3;
                            }
                        }
                        if (a.this.hGO != null && alaGetVerifyStrategyResponseHttpMessage.hJy == 1 && alaGetVerifyStrategyResponseHttpMessage.hJA == 1 && alaGetVerifyStrategyResponseHttpMessage.hJD == 1 && alaGetVerifyStrategyResponseHttpMessage.hJF == 1) {
                            a.this.hGO.ceF();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hGx.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hGO != null) {
                    a.this.hGO.cil();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hJA != 3 ? 0 : 3;
                    if (a.this.hGN != null && a.this.hGO != null) {
                        a.this.hGN.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hGO.bRf(), a.this.hGG).eZ(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hGO != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hGO;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.oj(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hGx = alaMasterLiveRoomActivity;
        this.hqK = new com.baidu.live.tieba.e.b(this.hGx.getActivity());
        chh();
        this.hoL = new c();
        MessageManager.getInstance().registerListener(this.hGQ);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ak.a.class, this.hGx.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hGN = (com.baidu.live.ak.a) runTask.getData();
            if (this.hGN != null) {
                this.hGN.a(this.hGR);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.n.d dVar) {
        CustomResponsedMessage runTask;
        this.hGl = dVar;
        if (this.hGl == null) {
            this.hGl = new com.baidu.tieba.ala.liveroom.n.d(this.hGx.getPageContext());
        }
        if (this.bEu == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.hGx.getPageContext().getPageActivity())) != null) {
            this.bEu = (k) runTask.getData();
        }
        if (this.bEu != null) {
            this.bEu.b(null);
            this.bEu.a(null);
            this.bEu.c(null);
        }
        this.hGl.a(this.hGT);
        if (this.hGO != null) {
            this.hGO.setArModel(this.bEu);
            this.hGO.a(this.hGl);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hGG = str3;
        this.hGI = false;
        ox(false);
        chb();
        if (this.hGO != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hCi = bundle;
            this.hGO.b(fVar);
            if (this.hGO.bRf() == 1) {
                vL(this.hGO.bRf());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hGK = alaLivePersonData.mLiveInfo.clarity;
        this.hGI = true;
        this.hGH = alaLivePersonData.mLiveInfo.screen_direction == 2;
        ox(true);
        chb();
        if (this.hGO != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hCh = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                vL(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hGO.b(fVar);
        }
        if (this.hGl != null) {
            this.hGl.h(alaLivePersonData);
        }
    }

    private void cgW() {
        this.hGH = com.baidu.live.d.xc().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cgX() {
        this.hGK = com.baidu.live.d.xc().getInt("live_recorder_resolution_level", 2);
    }

    private void ox(boolean z) {
        if (!z) {
            cgX();
            cgW();
        }
        this.hGy = (ViewGroup) View.inflate(this.hGx.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.hGx.addContentView(this.hGy, new FrameLayout.LayoutParams(-1, -1));
        this.hGx.setContentView(this.hGy);
        this.hGA = (FrameLayout) this.hGy.findViewById(a.f.ala_live_render_view);
        this.hGD = (AlaLiveView) this.hGy.findViewById(a.f.ala_liveroom_host_liveview);
        this.hGD.setVisibility(8);
        this.hGD.setSwipeClearEnable(true);
        this.hGz = (RelativeLayout) this.hGy.findViewById(a.f.ala_live_unremovable_container);
        this.hGE = (ViewGroup) this.hGy.findViewById(a.f.func_view);
        this.hGF = (LayerRootView) this.hGy.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.Bc().l(this.hGF);
        this.hGz.requestLayout();
        this.hGy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hGD == null || a.this.hGD.hRx) {
                    return false;
                }
                a.this.hGD.X(motionEvent);
                a.this.hGB.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = com.baidu.live.z.a.b.PF().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aLn) {
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
        if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bt.a(com.baidu.live.ae.a.Qj().bAS)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bEw = new AlaLiveRecorder(this.hGx.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, new com.baidu.live.z.a.a(), videoBeautyType3);
        this.bEw.addRecorderCallback(this.hGS);
        boolean z2 = com.baidu.live.ae.a.Qj().buX.aLd;
        this.bEw.setUseDummyVideoCapture(z2);
        this.bEw.setUseDummyAudioCapture(z2);
        com.baidu.live.z.a.b.PF().PH();
        if (!this.hGH && this.bEw.getPreview() != null) {
            cgY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SF() {
        if (this.bEw != null && this.bEw.getPreview() != null && this.bEw.getPreview().getParent() != null) {
            ((ViewGroup) this.bEw.getPreview().getParent()).removeView(this.bEw.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        this.bEw.getPreview().setEnabled(false);
        SF();
        if (this.hGC == null) {
            this.hGA.addView(this.bEw.getPreview(), 0, SE());
        } else {
            this.hGA.addView(this.bEw.getPreview(), 0, cgZ());
        }
        if (this.hGB == null) {
            this.hGB = new AlaLiveFoucsExposureViewContainer(this.hGA.getContext());
            this.hGB.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hGl != null && a.this.hGl.Fm() != null) {
                        alaLiveInfoData = a.this.hGl.Fm().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bEw != null) {
                        a.this.bEw.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bEw != null) {
                        a.this.bEw.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void chj() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hGl != null && a.this.hGl.Fm() != null) {
                        alaLiveInfoData = a.this.hGl.Fm().mLiveInfo;
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
                    if (a.this.bEw != null) {
                        return a.this.bEw.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hGA.addView(this.hGB, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams SE() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cgZ() {
        int i = BdUtilHelper.getScreenDimensions(this.hGx.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fa(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cha() {
        int i = BdUtilHelper.getScreenDimensions(this.hGx.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fa(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL(int i) {
        if (this.hGI) {
            this.bEw.setVideoConfig(com.baidu.live.z.a.b.PF().d(this.hGK, i, this.hGH));
        } else {
            this.bEw.setVideoConfig(com.baidu.live.z.a.b.PF().d(i == 1 ? 0 : this.hGK, i, i == 1 ? this.hGH : false));
        }
    }

    private void chb() {
        this.hGO = new com.baidu.tieba.ala.liveroom.master.a.d(this.hGx, this.bEw, this.hGD, this.hGA, this.hGy, this.hGE, this.hqK, this.hGx.cgS(), this.hGB);
        this.hGO.a(this.hGl);
        this.hGO.setArModel(this.bEu);
        this.hGO.a(this.hGP);
    }

    public void chc() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hGx.getPageContext().getPageActivity());
        if (this.bEw != null && this.bEw.getPreview() != null && (this.hGC == null || this.hGC.getParent() == null)) {
            this.bEw.getPreview().setLayoutParams(SE());
        }
        if (this.hGO != null) {
            this.hGO.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hGx.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hGO != null) {
            this.hGO.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chd() {
        if (this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null) {
            if (this.hGO != null && this.hGO.ciN() != null) {
                this.hGO.ciN().liveID = Long.toString(this.hGl.Fm().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hGl.cjv().mLiveInfo.live_id), String.valueOf(this.hGl.cjv().mLiveInfo.room_id), String.valueOf(this.hGl.cjv().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hGl.cjv().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hGl.cjv().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hGl.cjv().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime").setContentExt(jSONObject));
            this.hGJ = System.currentTimeMillis() / 1000;
            this.hGl.B(this.hGl.Fm().mLiveInfo.live_id, this.hGJ);
            this.hGl.j(this.hGl.Fm().mLiveInfo.live_id, false);
            com.baidu.live.d.xc().putLong("last_live_room_id", this.hGl.Fm().mLiveInfo.live_id);
            this.hGl.cjA();
            if (this.hGO != null && this.hGO.ciN() != null) {
                if (this.hGO.bRf() == 2) {
                    if (this.hGH) {
                        this.hGO.ciN().liveType = 5;
                    } else {
                        this.hGO.ciN().liveType = 4;
                    }
                } else if (this.hGO.bRf() == 1) {
                    if (this.hGH) {
                        this.hGO.ciN().liveType = 2;
                    } else {
                        this.hGO.ciN().liveType = 1;
                    }
                }
            }
            chi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void che() {
        final ab Fm = this.hGl.Fm();
        if (Fm != null && Fm.mLiveInfo != null) {
            if (this.hGO == null || !this.hGO.ciK()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hGl.B(Fm.mLiveInfo.live_id, a.this.hGJ);
                    }
                }, Fm.aIi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aw awVar) {
        if (awVar == null) {
            return false;
        }
        this.hGx.closeLoadingDialog();
        if (awVar.mErrorCode == 6) {
            this.hGx.showToast(awVar.mErrorMsg);
            if (this.hGO != null && this.hGO.ciN() != null) {
                this.hGO.ciN().errSubReason = 6;
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
        if (dVar != null && !dVar.hBS) {
            boolean z = dVar.hBT;
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
            if (this.hGO != null) {
                if (this.hGO.ciN() != null) {
                    this.hGO.ciN().updateTime = System.currentTimeMillis();
                }
                this.hGl.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hBU, dVar.hBV ? 1 : 0, this.hGO.bRf(), this.hGH ? 2 : 1, this.hGK, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void chf() {
        if (this.hGO != null && !this.hGO.ciM() && this.hGl.cjv() == null && this.hGO != null) {
            a(this.hGO.ciO());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hGO != null) {
            this.hGO.markEnterBackground();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bEw != null) {
            this.bEw.setIsAutoStartFromBack(true);
        }
        if (this.hGO != null) {
            this.hGO.markEnterForeground();
        }
    }

    public void onPause() {
        if (this.hGO != null) {
            this.hGO.onPause();
        }
    }

    public void onFinish() {
        if (this.hGO != null) {
            this.hGO.j(this.hGM);
        }
    }

    public void onDestroy() {
        if (this.hoL != null) {
            this.hoL.release();
            this.hoL = null;
        }
        if (this.hGO != null) {
            this.hGO.onDestroy();
        }
        if (this.hGN != null) {
            this.hGN.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.hqK.stop();
        this.hqK = null;
        if (this.hGl != null) {
            this.hGl.destory();
            this.hGl = null;
        }
        if (this.bEu != null) {
            this.bEu.destory();
            this.bEu = null;
        }
        if (this.bEw != null) {
            ap apVar = new ap();
            apVar.aKb = this.hGH ? 2 : 1;
            apVar.mOpenType = 2;
            if (this.hGO != null) {
                apVar.aKa = this.hGO.bRf();
            }
            this.bEw.setRoomInfo(apVar.toJsonString());
            String str = "";
            if (this.hGO != null && this.hGO.ciN() != null) {
                if (this.hGO.ciN().startLiveTime != 0) {
                    str = Long.toString(this.hGO.ciN().startLiveTime);
                }
                this.bEw.setConfigBeforeStop(this.hGO.ciN().getCpuMemJsonFormat(), str, "");
            }
            this.bEw.stopRecord();
            this.bEw.release();
            this.bEw.removeRecorderCallback(this.hGS);
            this.bEw = null;
        }
        if (this.hGD != null) {
            this.hGD.setOnTouchListener(null);
            this.hGD.clr();
            this.hGD = null;
        }
        this.hGx = null;
        MessageManager.getInstance().unRegisterListener(this.hGQ);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void cr(int i) {
        this.hGD.cr(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hGx.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hGx.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hGy.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hGy.setLayoutParams(layoutParams);
            if (this.hGI && this.bEw != null && this.bEw.getPreview() != null && this.bEw.getPreview().getParent() == null) {
                cgY();
            }
        }
        if (this.hGO != null) {
            this.hGO.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hGx.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hGO != null) {
            this.hGO.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hGO != null) {
            this.hGO.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int chg() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chh() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hGO != null && a.this.hGO.ciN() != null) {
                        a.this.hGO.ciN().sampleMemAndCPU();
                    }
                    a.this.chh();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chi() {
        if (this.mHandler != null && this.bEw != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.vM(0);
                    a.this.chi();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM(int i) {
        if (this.hGO != null && this.hGO.ciN() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bEw.getMediaStatus();
            if (this.hGl != null && this.hGl.cjv() != null && this.hGl.cjv().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hGl.cjv().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hGl.cjv().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bEw.getRecorderDebugInfo();
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
            if (this.hGx != null) {
                alaLiveExceptionInfo.appState = this.hGx.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hGL;
            alaLiveExceptionInfo.sessionChannel = chg();
            alaLiveExceptionInfo.nodeIP = this.bEw.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hGO.ciN().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hGO.ciN().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hGO.ciN().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hGO != null) {
            return this.hGO.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hGP.g(s);
    }

    public void VC() {
        if (this.hGO != null) {
            this.hGO.VC();
        }
    }
}
