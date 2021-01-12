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
import com.baidu.live.am.a;
import com.baidu.live.ar.k;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.al;
import com.baidu.live.data.as;
import com.baidu.live.data.bo;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class a {
    private k bAO;
    private AlaLiveRecorder bAQ;
    private d hBO;
    private AlaMasterLiveRoomActivity hCa;
    private ViewGroup hCb;
    private RelativeLayout hCc;
    private FrameLayout hCd;
    private AlaLiveFoucsExposureViewContainer hCe;
    private View hCf;
    private AlaLiveView hCg;
    private ViewGroup hCh;
    private LayerRootView hCi;
    private String hCj;
    private int hCn;
    private short hCp;
    private com.baidu.live.am.a hCq;
    private com.baidu.tieba.ala.liveroom.master.a.d hCr;
    private c hkf;
    private com.baidu.live.tieba.e.b hmi;
    private String mForumId;
    private String mForumName;
    private boolean hCk = false;
    private Handler mHandler = new Handler();
    private boolean hCl = false;
    private long hCm = 0;
    private int hCo = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hCs = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.hCk = dVar.hxy;
                if (dVar.hxu) {
                    a.this.cgd();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void vC(int i) {
            if (i == 2) {
                a.this.QV();
                if (a.this.hCl) {
                    a.this.vA(2);
                }
                a.this.bAQ.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bAQ.addRecorderCallback(a.this.hCv);
                a.this.hCg.setBackgroundColor(a.this.hCa.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.hCk) {
                    a.this.bAQ.switchOrientation(a.this.hCk);
                    a.this.bAQ.addRecorderCallback(a.this.hCv);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2;
            a.this.hCp = s;
            if (a.this.hCa != null) {
                if (a.this.hCp == 1) {
                    a.this.hCa.cfR();
                } else {
                    a.this.hCa.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hBO == null || a.this.hBO.DW() == null || a.this.hBO.DW().mLiveInfo == null) {
                    j = -1;
                    j2 = -1;
                } else {
                    long j3 = a.this.hBO.DW().mLiveInfo.room_id;
                    j = a.this.hBO.DW().mLiveInfo.live_id;
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
        public void Vz() {
            if (a.this.hCf != null) {
                if (a.this.hCf.getParent() != null) {
                    ((ViewGroup) a.this.hCf.getParent()).removeView(a.this.hCf);
                }
                a.this.hCf = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hCd.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hCd.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void cdF() {
            if (a.this.hCf == null) {
                a.this.hCf = a.this.bAQ.createPKPlayer();
            }
            if (a.this.hCf != null && a.this.hCf.getParent() == null) {
                a.this.hCd.addView(a.this.hCf, a.this.cga());
            }
            if (a.this.bAQ != null && a.this.bAQ.getPreview() != null) {
                FrameLayout.LayoutParams cfZ = a.this.cfZ();
                if (a.this.bAQ.getVideoConfig() != null) {
                    cfZ.height = (a.this.bAQ.getVideoConfig().getVideoHeight() * cfZ.width) / a.this.bAQ.getVideoConfig().getVideoWidth();
                }
                a.this.bAQ.getPreview().setLayoutParams(cfZ);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void cdG() {
            FrameLayout.LayoutParams cfZ = a.this.cfZ();
            int bm = h.bm(a.this.hCa.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hCd.getLayoutParams();
            layoutParams.height = cfZ.height;
            layoutParams.topMargin = bm;
            a.this.hCd.setLayoutParams(layoutParams);
            if (a.this.bAQ.getVideoConfig() != null) {
                cfZ.height = (a.this.bAQ.getVideoConfig().getVideoHeight() * cfZ.width) / a.this.bAQ.getVideoConfig().getVideoWidth();
            }
            a.this.bAQ.getPreview().setLayoutParams(cfZ);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void cdH() {
            a.this.QV();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void cdI() {
            a.this.cfY();
        }
    };
    private CustomMessageListener hCt = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bAQ.stopRecord();
                } else {
                    a.this.bAQ.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0163a hCu = new a.InterfaceC0163a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hCv = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hCr != null) {
                a.this.hCr.chL();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hCr != null) {
                a.this.hCr.chL();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hCr != null && a.this.hCr.chN() != null) {
                a.this.hCr.chN().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hCr != null) {
                a.this.hCr.streamStateReceived(i, z, i2, z2);
            }
            a.this.hCo = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hCr != null) {
                if (z) {
                    a.this.hCr.bl(0, null);
                } else {
                    a.this.hCr.bl(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hCr != null && a.this.hCr.chN() != null) {
                a.this.hCr.chN().errCode = 2;
                a.this.hCr.bm(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hCr != null && a.this.hCr.chN() != null) {
                a.this.hCr.chN().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hCr.chN().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hCr.chN().startLiveTime == 0) {
                    a.this.hCr.chN().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.vB(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hCa.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bAQ != null && a.this.bAQ.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bAQ.getPreview() != null) {
                        a.this.QV();
                    }
                    a.this.bAQ.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bAQ.addRecorderCallback(a.this.hCv);
                    a.this.bAQ.stopRecord();
                    if (a.this.bAQ.getPreview() != null) {
                        a.this.cfY();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bAQ != null) {
                                a.this.bAQ.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bAQ.changeVideoRecorderType(com.baidu.live.af.a.OJ().bru != null ? com.baidu.live.af.a.OJ().bru.aIC : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bAQ.addRecorderCallback(a.this.hCv);
                if (a.this.bAQ.getPreview() != null) {
                    a.this.cfY();
                }
                i2 = -4;
            }
            if (a.this.hCr != null) {
                a.this.hCr.bm(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hCr != null) {
                a.this.hCr.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hCr != null) {
                a.this.hCr.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void sendBufferChanged(int i) {
            if (a.this.hCr != null) {
                a.this.hCr.sendBufferChanged(i);
            }
        }
    };
    private d.a hCw = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.p.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                as civ = a.this.hBO.civ();
                if (a.this.hCr != null && a.this.hCr.chN() != null) {
                    a.this.hCr.chN().logID = civ.logId;
                    a.this.hCr.chN().errCode = 5;
                }
                if (!a.this.a(civ)) {
                    if (a.this.hCr != null && a.this.hCr.chN() != null) {
                        a.this.hCr.chN().updateTime = System.currentTimeMillis() - a.this.hCr.chN().updateTime;
                    }
                    if (civ.aLh != 1) {
                        if (a.this.hCr != null && a.this.hCr.chN() != null) {
                            a.this.hCr.chN().errSubReason = -1;
                        }
                        a.this.hCa.showToast(civ.aLi);
                        a.this.g((short) 1);
                        return;
                    }
                    if (civ.mErrorCode != 0) {
                        if (a.this.hCr != null && a.this.hCr.chN() != null) {
                            a.this.hCr.chN().errCode = 5;
                            a.this.hCr.chN().errSubReason = civ.mErrorCode;
                        }
                        a.this.hCa.showToast(str);
                        if (civ.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hCa.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hCr != null && a.this.hCr.chN() != null) {
                            a.this.hCr.chN().errCode = 0;
                            a.this.hCr.chN().errSubReason = 0;
                        }
                        if (a.this.bAQ != null) {
                            a.this.bAQ.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.af.a.OJ().bru.aIP);
                            a.this.bAQ.setStartInfo(Long.toString(a.this.hBO.DW().mLiveInfo.live_id), a.this.hBO.DW().mLiveInfo.getSessionID(), com.baidu.live.af.a.OJ().bru.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.hCr != null) {
                            a.this.hCr.c(a.this.hBO.civ());
                        }
                        a.this.cgd();
                    }
                    if (a.this.hCr != null && a.this.hCr.chN() != null) {
                        a.this.hCr.chN().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hCr != null) {
                    a.this.hCr.cgZ();
                }
            } else if (i2 == 1) {
                a.this.cge();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hCr != null && a.this.hCr.chN() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hFa == 2) {
                                a.this.hCr.chN().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hFa == 3) {
                                a.this.hCr.chN().errSubReason = -3;
                            }
                        }
                        if (a.this.hCr != null && alaGetVerifyStrategyResponseHttpMessage.hEY == 1 && alaGetVerifyStrategyResponseHttpMessage.hFa == 1 && alaGetVerifyStrategyResponseHttpMessage.hFd == 1 && alaGetVerifyStrategyResponseHttpMessage.hFf == 1) {
                            a.this.hCr.cdD();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hCa.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hCr != null) {
                    a.this.hCr.chl();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hFa != 3 ? 0 : 3;
                    if (a.this.hCq != null && a.this.hCr != null) {
                        a.this.hCq.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hCr.bQu(), a.this.hCj).eV(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hCr != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hCr;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.nY(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hCa = alaMasterLiveRoomActivity;
        this.hmi = new com.baidu.live.tieba.e.b(this.hCa.getActivity());
        cgh();
        this.hkf = new c();
        MessageManager.getInstance().registerListener(this.hCt);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.am.a.class, this.hCa.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hCq = (com.baidu.live.am.a) runTask.getData();
            if (this.hCq != null) {
                this.hCq.a(this.hCu);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.hBO = dVar;
        if (this.hBO == null) {
            this.hBO = new d(this.hCa.getPageContext());
        }
        if (this.bAO == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.hCa.getPageContext().getPageActivity())) != null) {
            this.bAO = (k) runTask.getData();
        }
        if (this.bAO != null) {
            this.bAO.b(null);
            this.bAO.a(null);
            this.bAO.c(null);
        }
        this.hBO.a(this.hCw);
        if (this.hCr != null) {
            this.hCr.setArModel(this.bAO);
            this.hCr.a(this.hBO);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hCj = str3;
        this.hCl = false;
        on(false);
        cgb();
        if (this.hCr != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hxK = bundle;
            this.hCr.b(fVar);
            if (this.hCr.bQu() == 1) {
                vA(this.hCr.bQu());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hCn = alaLivePersonData.mLiveInfo.clarity;
        this.hCl = true;
        this.hCk = alaLivePersonData.mLiveInfo.screen_direction == 2;
        on(true);
        cgb();
        if (this.hCr != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hxJ = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                vA(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hCr.b(fVar);
        }
        if (this.hBO != null) {
            this.hBO.h(alaLivePersonData);
        }
    }

    private void cfW() {
        this.hCk = com.baidu.live.d.xf().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cfX() {
        this.hCn = com.baidu.live.d.xf().getInt("live_recorder_resolution_level", 2);
    }

    private void on(boolean z) {
        if (!z) {
            cfX();
            cfW();
        }
        this.hCb = (ViewGroup) View.inflate(this.hCa.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.hCa.addContentView(this.hCb, new FrameLayout.LayoutParams(-1, -1));
        this.hCa.setContentView(this.hCb);
        this.hCd = (FrameLayout) this.hCb.findViewById(a.f.ala_live_render_view);
        this.hCg = (AlaLiveView) this.hCb.findViewById(a.f.ala_liveroom_host_liveview);
        this.hCg.setVisibility(8);
        this.hCg.setSwipeClearEnable(true);
        this.hCc = (RelativeLayout) this.hCb.findViewById(a.f.ala_live_unremovable_container);
        this.hCh = (ViewGroup) this.hCb.findViewById(a.f.func_view);
        this.hCi = (LayerRootView) this.hCb.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.As().l(this.hCi);
        this.hCc.requestLayout();
        this.hCb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hCg == null || a.this.hCg.hMP) {
                    return false;
                }
                a.this.hCg.X(motionEvent);
                a.this.hCe.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.Og().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aID) {
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
        if (bo.b(com.baidu.live.af.a.OJ().bxp)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bo.a(com.baidu.live.af.a.OJ().bxp)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bo.c(com.baidu.live.af.a.OJ().bxp)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bAQ = new AlaLiveRecorder(this.hCa.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, new com.baidu.live.recorder.helper.a(), videoBeautyType3);
        this.bAQ.addRecorderCallback(this.hCv);
        LiveRecorderConfigHelper.Og().Oi();
        if (!this.hCk && this.bAQ.getPreview() != null) {
            cfY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QV() {
        if (this.bAQ != null && this.bAQ.getPreview() != null && this.bAQ.getPreview().getParent() != null) {
            ((ViewGroup) this.bAQ.getPreview().getParent()).removeView(this.bAQ.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfY() {
        this.bAQ.getPreview().setEnabled(false);
        QV();
        if (this.hCf == null) {
            this.hCd.addView(this.bAQ.getPreview(), 0, QU());
        } else {
            this.hCd.addView(this.bAQ.getPreview(), 0, cfZ());
        }
        if (this.hCe == null) {
            this.hCe = new AlaLiveFoucsExposureViewContainer(this.hCd.getContext());
            this.hCe.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hBO != null && a.this.hBO.DW() != null) {
                        alaLiveInfoData = a.this.hBO.DW().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bAQ != null) {
                        a.this.bAQ.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bAQ != null) {
                        a.this.bAQ.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void cgj() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hBO != null && a.this.hBO.DW() != null) {
                        alaLiveInfoData = a.this.hBO.DW().mLiveInfo;
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
                    if (a.this.bAQ != null) {
                        return a.this.bAQ.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hCd.addView(this.hCe, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams QU() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cfZ() {
        int i = BdUtilHelper.getScreenDimensions(this.hCa.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.eW(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cga() {
        int i = BdUtilHelper.getScreenDimensions(this.hCa.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.eW(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(int i) {
        if (this.hCl) {
            this.bAQ.setVideoConfig(LiveRecorderConfigHelper.Og().d(this.hCn, i, this.hCk));
        } else {
            this.bAQ.setVideoConfig(LiveRecorderConfigHelper.Og().d(i == 1 ? 0 : this.hCn, i, i == 1 ? this.hCk : false));
        }
    }

    private void cgb() {
        this.hCr = new com.baidu.tieba.ala.liveroom.master.a.d(this.hCa, this.bAQ, this.hCg, this.hCd, this.hCb, this.hCh, this.hmi, this.hCa.cfS(), this.hCe);
        this.hCr.a(this.hBO);
        this.hCr.setArModel(this.bAO);
        this.hCr.a(this.hCs);
    }

    public void cgc() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hCa.getPageContext().getPageActivity());
        if (this.bAQ != null && this.bAQ.getPreview() != null && (this.hCf == null || this.hCf.getParent() == null)) {
            this.bAQ.getPreview().setLayoutParams(QU());
        }
        if (this.hCr != null) {
            this.hCr.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hCa.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hCr != null) {
            this.hCr.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgd() {
        if (this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null) {
            if (this.hCr != null && this.hCr.chN() != null) {
                this.hCr.chN().liveID = Long.toString(this.hBO.DW().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hBO.civ().mLiveInfo.live_id), String.valueOf(this.hBO.civ().mLiveInfo.room_id), String.valueOf(this.hBO.civ().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hBO.civ().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hBO.civ().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hBO.civ().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime").setContentExt(jSONObject));
            this.hCm = System.currentTimeMillis() / 1000;
            this.hBO.x(this.hBO.DW().mLiveInfo.live_id, this.hCm);
            this.hBO.j(this.hBO.DW().mLiveInfo.live_id, false);
            com.baidu.live.d.xf().putLong("last_live_room_id", this.hBO.DW().mLiveInfo.live_id);
            this.hBO.ciA();
            if (this.hCr != null && this.hCr.chN() != null) {
                if (this.hCr.bQu() == 2) {
                    if (this.hCk) {
                        this.hCr.chN().liveType = 5;
                    } else {
                        this.hCr.chN().liveType = 4;
                    }
                } else if (this.hCr.bQu() == 1) {
                    if (this.hCk) {
                        this.hCr.chN().liveType = 2;
                    } else {
                        this.hCr.chN().liveType = 1;
                    }
                }
            }
            cgi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cge() {
        final x DW = this.hBO.DW();
        if (DW != null && DW.mLiveInfo != null) {
            if (this.hCr == null || !this.hCr.chK()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hBO.x(DW.mLiveInfo.live_id, a.this.hCm);
                    }
                }, DW.aFM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(as asVar) {
        if (asVar == null) {
            return false;
        }
        this.hCa.closeLoadingDialog();
        if (asVar.mErrorCode == 6) {
            this.hCa.showToast(asVar.mErrorMsg);
            if (this.hCr != null && this.hCr.chN() != null) {
                this.hCr.chN().errSubReason = 6;
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
        if (dVar != null && !dVar.hxu) {
            boolean z = dVar.hxv;
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
            if (this.hCr != null) {
                if (this.hCr.chN() != null) {
                    this.hCr.chN().updateTime = System.currentTimeMillis();
                }
                this.hBO.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hxw, dVar.hxx ? 1 : 0, this.hCr.bQu(), this.hCk ? 2 : 1, this.hCn, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void cgf() {
        if (this.hCr != null && !this.hCr.chM() && this.hBO.civ() == null && this.hCr != null) {
            a(this.hCr.chO());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hCr != null) {
            this.hCr.markEnterBackground();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bAQ != null) {
            this.bAQ.setIsAutoStartFromBack(true);
        }
        if (this.hCr != null) {
            this.hCr.markEnterForeground();
        }
    }

    public void onPause() {
        if (this.hCr != null) {
            this.hCr.onPause();
        }
    }

    public void onFinish() {
        if (this.hCr != null) {
            this.hCr.j(this.hCp);
        }
    }

    public void onDestroy() {
        if (this.hkf != null) {
            this.hkf.release();
            this.hkf = null;
        }
        if (this.hCr != null) {
            this.hCr.onDestroy();
        }
        if (this.hCq != null) {
            this.hCq.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.hmi.stop();
        this.hmi = null;
        if (this.hBO != null) {
            this.hBO.destory();
            this.hBO = null;
        }
        if (this.bAO != null) {
            this.bAO.destory();
            this.bAO = null;
        }
        if (this.bAQ != null) {
            al alVar = new al();
            alVar.aHw = this.hCk ? 2 : 1;
            alVar.mOpenType = 2;
            if (this.hCr != null) {
                alVar.aHv = this.hCr.bQu();
            }
            this.bAQ.setRoomInfo(alVar.toJsonString());
            String str = "";
            if (this.hCr != null && this.hCr.chN() != null) {
                if (this.hCr.chN().startLiveTime != 0) {
                    str = Long.toString(this.hCr.chN().startLiveTime);
                }
                this.bAQ.setConfigBeforeStop(this.hCr.chN().getCpuMemJsonFormat(), str, "");
            }
            this.bAQ.stopRecord();
            this.bAQ.release();
            this.bAQ.removeRecorderCallback(this.hCv);
            this.bAQ = null;
        }
        if (this.hCg != null) {
            this.hCg.setOnTouchListener(null);
            this.hCg.ckm();
            this.hCg = null;
        }
        this.hCa = null;
        MessageManager.getInstance().unRegisterListener(this.hCt);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void co(int i) {
        this.hCg.co(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hCa.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hCa.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hCb.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hCb.setLayoutParams(layoutParams);
            if (this.hCl && this.bAQ != null && this.bAQ.getPreview() != null && this.bAQ.getPreview().getParent() == null) {
                cfY();
            }
        }
        if (this.hCr != null) {
            this.hCr.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hCa.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hCr != null) {
            this.hCr.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hCr != null) {
            this.hCr.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int cgg() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgh() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hCr != null && a.this.hCr.chN() != null) {
                        a.this.hCr.chN().sampleMemAndCPU();
                    }
                    a.this.cgh();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgi() {
        if (this.mHandler != null && this.bAQ != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.vB(0);
                    a.this.cgi();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(int i) {
        if (this.hCr != null && this.hCr.chN() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bAQ.getMediaStatus();
            if (this.hBO != null && this.hBO.civ() != null && this.hBO.civ().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hBO.civ().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hBO.civ().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bAQ.getRecorderDebugInfo();
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
            if (this.hCa != null) {
                alaLiveExceptionInfo.appState = this.hCa.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hCo;
            alaLiveExceptionInfo.sessionChannel = cgg();
            alaLiveExceptionInfo.nodeIP = this.bAQ.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hCr.chN().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hCr.chN().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hCr.chN().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hCr != null) {
            return this.hCr.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hCs.g(s);
    }
}
