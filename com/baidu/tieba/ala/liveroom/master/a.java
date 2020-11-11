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
import com.baidu.live.ah.a;
import com.baidu.live.ar.j;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.ai;
import com.baidu.live.data.ap;
import com.baidu.live.data.bl;
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
import com.baidu.live.tbadk.log.LogConfig;
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
import com.baidu.tieba.ala.liveroom.q.c;
import com.baidu.tieba.ala.liveroom.q.d;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private j bxo;
    private AlaLiveRecorder bxq;
    private c gUd;
    private com.baidu.live.tieba.e.b gVZ;
    private AlaMasterLiveRoomActivity hlC;
    private ViewGroup hlD;
    private RelativeLayout hlE;
    private FrameLayout hlF;
    private AlaLiveFoucsExposureViewContainer hlG;
    private View hlH;
    private AlaLiveView hlI;
    private ViewGroup hlJ;
    private LayerRootView hlK;
    private String hlL;
    private int hlP;
    private short hlR;
    private com.baidu.live.ah.a hlS;
    private d hlT;
    private com.baidu.tieba.ala.liveroom.q.d hlq;
    private String mForumId;
    private String mForumName;
    private boolean hlM = false;
    private Handler mHandler = new Handler();
    private boolean hlN = false;
    private long hlO = 0;
    private int hlQ = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hlU = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.hlM = dVar.hgS;
                if (dVar.hgO) {
                    a.this.cdU();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void vU(int i) {
            if (i == 2) {
                a.this.RW();
                if (a.this.hlN) {
                    a.this.vS(2);
                }
                a.this.bxq.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bxq.addRecorderCallback(a.this.hlX);
                a.this.hlI.setBackgroundColor(a.this.hlC.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.hlM) {
                    a.this.bxq.switchOrientation(a.this.hlM);
                    a.this.bxq.addRecorderCallback(a.this.hlX);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2 = -1;
            a.this.hlR = s;
            if (a.this.hlC != null) {
                if (a.this.hlR == 1) {
                    a.this.hlC.cdI();
                } else {
                    a.this.hlC.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hlq == null || a.this.hlq.Hi() == null || a.this.hlq.Hi().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.hlq.Hi().mLiveInfo.room_id;
                    j2 = a.this.hlq.Hi().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime"));
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void Ws() {
            if (a.this.hlH != null) {
                if (a.this.hlH.getParent() != null) {
                    ((ViewGroup) a.this.hlH.getParent()).removeView(a.this.hlH);
                }
                a.this.hlH = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hlF.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hlF.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bfw() {
            if (a.this.hlH == null) {
                a.this.hlH = a.this.bxq.createPKPlayer();
            }
            if (a.this.hlH != null && a.this.hlH.getParent() == null) {
                a.this.hlF.addView(a.this.hlH, a.this.cdR());
            }
            if (a.this.bxq != null && a.this.bxq.getPreview() != null) {
                FrameLayout.LayoutParams cdQ = a.this.cdQ();
                if (a.this.bxq.getVideoConfig() != null) {
                    cdQ.height = (a.this.bxq.getVideoConfig().getVideoHeight() * cdQ.width) / a.this.bxq.getVideoConfig().getVideoWidth();
                }
                a.this.bxq.getPreview().setLayoutParams(cdQ);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void cbs() {
            FrameLayout.LayoutParams cdQ = a.this.cdQ();
            int aD = h.aD(a.this.hlC.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hlF.getLayoutParams();
            layoutParams.height = cdQ.height;
            layoutParams.topMargin = aD;
            a.this.hlF.setLayoutParams(layoutParams);
            if (a.this.bxq.getVideoConfig() != null) {
                cdQ.height = (a.this.bxq.getVideoConfig().getVideoHeight() * cdQ.width) / a.this.bxq.getVideoConfig().getVideoWidth();
            }
            a.this.bxq.getPreview().setLayoutParams(cdQ);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void cbt() {
            a.this.RW();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void cbu() {
            a.this.cdP();
        }
    };
    private CustomMessageListener hlV = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bxq.stopRecord();
                } else {
                    a.this.bxq.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0172a hlW = new a.InterfaceC0172a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hlX = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hlT != null) {
                a.this.hlT.cfC();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hlT != null) {
                a.this.hlT.cfC();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                a.this.hlT.cfE().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hlT != null) {
                a.this.hlT.streamStateReceived(i, z, i2, z2);
            }
            a.this.hlQ = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hlT != null) {
                if (z) {
                    a.this.hlT.bk(0, null);
                } else {
                    a.this.hlT.bk(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hlT != null && a.this.hlT.cfE() != null) {
                a.this.hlT.cfE().errCode = 2;
                a.this.hlT.bl(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hlT != null && a.this.hlT.cfE() != null) {
                a.this.hlT.cfE().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hlT.cfE().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hlT.cfE().startLiveTime == 0) {
                    a.this.hlT.cfE().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.vT(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hlC.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bxq != null && a.this.bxq.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bxq.getPreview() != null) {
                        a.this.RW();
                    }
                    a.this.bxq.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bxq.addRecorderCallback(a.this.hlX);
                    a.this.bxq.stopRecord();
                    if (a.this.bxq.getPreview() != null) {
                        a.this.cdP();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bxq != null) {
                                a.this.bxq.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bxq.changeVideoRecorderType(com.baidu.live.aa.a.PQ().bod != null ? com.baidu.live.aa.a.PQ().bod.aLB : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bxq.addRecorderCallback(a.this.hlX);
                if (a.this.bxq.getPreview() != null) {
                    a.this.cdP();
                }
                i2 = -4;
            }
            if (a.this.hlT != null) {
                a.this.hlT.bl(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hlT != null) {
                a.this.hlT.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hlT != null) {
                a.this.hlT.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private d.a hlY = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.q.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                ap cgm = a.this.hlq.cgm();
                if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                    a.this.hlT.cfE().logID = cgm.logId;
                    a.this.hlT.cfE().errCode = 5;
                }
                if (!a.this.a(cgm)) {
                    if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                        a.this.hlT.cfE().updateTime = System.currentTimeMillis() - a.this.hlT.cfE().updateTime;
                    }
                    if (cgm.aNT != 1) {
                        if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                            a.this.hlT.cfE().errSubReason = -1;
                        }
                        a.this.hlC.showToast(cgm.aNU);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cgm.mErrorCode != 0) {
                        if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                            a.this.hlT.cfE().errCode = 5;
                            a.this.hlT.cfE().errSubReason = cgm.mErrorCode;
                        }
                        a.this.hlC.showToast(str);
                        if (cgm.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hlC.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                            a.this.hlT.cfE().errCode = 0;
                            a.this.hlT.cfE().errSubReason = 0;
                        }
                        if (a.this.bxq != null) {
                            a.this.bxq.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.aa.a.PQ().bod.aLO);
                            a.this.bxq.setStartInfo(Long.toString(a.this.hlq.Hi().mLiveInfo.live_id), a.this.hlq.Hi().mLiveInfo.getSessionID(), com.baidu.live.aa.a.PQ().bod.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.hlT != null) {
                            a.this.hlT.c(a.this.hlq.cgm());
                        }
                        a.this.cdU();
                    }
                    if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                        a.this.hlT.cfE().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hlT != null) {
                    a.this.hlT.ceP();
                }
            } else if (i2 == 1) {
                a.this.cdV();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hov == 2) {
                                a.this.hlT.cfE().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hov == 3) {
                                a.this.hlT.cfE().errSubReason = -3;
                            }
                        }
                        if (a.this.hlT != null && alaGetVerifyStrategyResponseHttpMessage.hot == 1 && alaGetVerifyStrategyResponseHttpMessage.hov == 1 && alaGetVerifyStrategyResponseHttpMessage.hoy == 1 && alaGetVerifyStrategyResponseHttpMessage.hoA == 1) {
                            a.this.hlT.cbp();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hlC.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hlT != null) {
                    a.this.hlT.cfb();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hov != 3 ? 0 : 3;
                    if (a.this.hlS != null && a.this.hlT != null) {
                        a.this.hlS.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hlT.cbr(), a.this.hlL).gg(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hlT != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hlT;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.ng(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hlC = alaMasterLiveRoomActivity;
        this.gVZ = new com.baidu.live.tieba.e.b(this.hlC.getActivity());
        cdY();
        this.gUd = new c();
        MessageManager.getInstance().registerListener(this.hlV);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ah.a.class, this.hlC.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hlS = (com.baidu.live.ah.a) runTask.getData();
            if (this.hlS != null) {
                this.hlS.a(this.hlW);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        CustomResponsedMessage runTask;
        this.hlq = dVar;
        if (this.hlq == null) {
            this.hlq = new com.baidu.tieba.ala.liveroom.q.d(this.hlC.getPageContext());
        }
        if (this.bxo == null && (runTask = MessageManager.getInstance().runTask(2913177, j.class, this.hlC.getPageContext().getPageActivity())) != null) {
            this.bxo = (j) runTask.getData();
        }
        if (this.bxo != null) {
            this.bxo.b(null);
            this.bxo.a(null);
            this.bxo.c(null);
        }
        this.hlq.a(this.hlY);
        if (this.hlT != null) {
            this.hlT.setArModel(this.bxo);
            this.hlT.a(this.hlq);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hlL = str3;
        this.hlN = false;
        nv(false);
        cdS();
        if (this.hlT != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hhe = bundle;
            this.hlT.b(fVar);
            if (this.hlT.cbr() == 1) {
                vS(this.hlT.cbr());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hlP = alaLivePersonData.mLiveInfo.clarity;
        this.hlN = true;
        this.hlM = alaLivePersonData.mLiveInfo.screen_direction == 2;
        nv(true);
        cdS();
        if (this.hlT != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hhd = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                vS(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hlT.b(fVar);
        }
        if (this.hlq != null) {
            this.hlq.h(alaLivePersonData);
        }
    }

    private void cdN() {
        this.hlM = com.baidu.live.d.AZ().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cdO() {
        this.hlP = com.baidu.live.d.AZ().getInt("live_recorder_resolution_level", 2);
    }

    private void nv(boolean z) {
        if (!z) {
            cdO();
            cdN();
        }
        this.hlD = (ViewGroup) View.inflate(this.hlC.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.hlC.addContentView(this.hlD, new FrameLayout.LayoutParams(-1, -1));
        this.hlC.setContentView(this.hlD);
        this.hlF = (FrameLayout) this.hlD.findViewById(a.f.ala_live_render_view);
        this.hlI = (AlaLiveView) this.hlD.findViewById(a.f.ala_liveroom_host_liveview);
        this.hlI.setVisibility(8);
        this.hlI.setSwipeClearEnable(true);
        this.hlE = (RelativeLayout) this.hlD.findViewById(a.f.ala_live_unremovable_container);
        this.hlJ = (ViewGroup) this.hlD.findViewById(a.f.func_view);
        this.hlK = (LayerRootView) this.hlD.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.DX().n(this.hlK);
        this.hlE.requestLayout();
        this.hlD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hlI == null || a.this.hlI.hwi) {
                    return false;
                }
                a.this.hlI.W(motionEvent);
                a.this.hlG.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.Pn().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.aa.a.PQ().bod != null && com.baidu.live.aa.a.PQ().bod.aLC) {
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
        if (bl.b(com.baidu.live.aa.a.PQ().btT)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bl.a(com.baidu.live.aa.a.PQ().btT)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bl.c(com.baidu.live.aa.a.PQ().btT)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bxq = new AlaLiveRecorder(this.hlC.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bxq.addRecorderCallback(this.hlX);
        LiveRecorderConfigHelper.Pn().Pp();
        if (!this.hlM && this.bxq.getPreview() != null) {
            cdP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RW() {
        if (this.bxq != null && this.bxq.getPreview() != null && this.bxq.getPreview().getParent() != null) {
            ((ViewGroup) this.bxq.getPreview().getParent()).removeView(this.bxq.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdP() {
        this.bxq.getPreview().setEnabled(false);
        RW();
        if (this.hlH == null) {
            this.hlF.addView(this.bxq.getPreview(), 0, RV());
        } else {
            this.hlF.addView(this.bxq.getPreview(), 0, cdQ());
        }
        if (this.hlG == null) {
            this.hlG = new AlaLiveFoucsExposureViewContainer(this.hlF.getContext());
            this.hlG.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hlq != null && a.this.hlq.Hi() != null) {
                        alaLiveInfoData = a.this.hlq.Hi().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bxq != null) {
                        a.this.bxq.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bxq != null) {
                        a.this.bxq.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void cea() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hlq != null && a.this.hlq.Hi() != null) {
                        alaLiveInfoData = a.this.hlq.Hi().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "biasbar_click").setContentExt(jSONObject));
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public float getExposure() {
                    if (a.this.bxq != null) {
                        return a.this.bxq.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hlF.addView(this.hlG, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams RV() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cdQ() {
        int i = BdUtilHelper.getScreenDimensions(this.hlC.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gh(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cdR() {
        int i = BdUtilHelper.getScreenDimensions(this.hlC.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gh(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        if (this.hlN) {
            this.bxq.setVideoConfig(LiveRecorderConfigHelper.Pn().d(this.hlP, i, this.hlM));
        } else {
            this.bxq.setVideoConfig(LiveRecorderConfigHelper.Pn().d(i == 1 ? 0 : this.hlP, i, i == 1 ? this.hlM : false));
        }
    }

    private void cdS() {
        this.hlT = new com.baidu.tieba.ala.liveroom.master.a.d(this.hlC, this.bxq, this.hlI, this.hlF, this.hlD, this.hlJ, this.gVZ, this.hlC.cdJ(), this.hlG);
        this.hlT.a(this.hlq);
        this.hlT.setArModel(this.bxo);
        this.hlT.a(this.hlU);
    }

    public void cdT() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hlC.getPageContext().getPageActivity());
        if (this.bxq != null && this.bxq.getPreview() != null && (this.hlH == null || this.hlH.getParent() == null)) {
            this.bxq.getPreview().setLayoutParams(RV());
        }
        if (this.hlT != null) {
            this.hlT.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hlC.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hlT != null) {
            this.hlT.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdU() {
        if (this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null) {
            if (this.hlT != null && this.hlT.cfE() != null) {
                this.hlT.cfE().liveID = Long.toString(this.hlq.Hi().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hlq.cgm().mLiveInfo.live_id), String.valueOf(this.hlq.cgm().mLiveInfo.room_id), String.valueOf(this.hlq.cgm().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hlq.cgm().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hlq.cgm().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hlq.cgm().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.hlO = System.currentTimeMillis() / 1000;
            this.hlq.u(this.hlq.Hi().mLiveInfo.live_id, this.hlO);
            this.hlq.h(this.hlq.Hi().mLiveInfo.live_id, false);
            com.baidu.live.d.AZ().putLong("last_live_room_id", this.hlq.Hi().mLiveInfo.live_id);
            this.hlq.cgr();
            if (this.hlT != null && this.hlT.cfE() != null) {
                if (this.hlT.cbr() == 2) {
                    if (this.hlM) {
                        this.hlT.cfE().liveType = 5;
                    } else {
                        this.hlT.cfE().liveType = 4;
                    }
                } else if (this.hlT.cbr() == 1) {
                    if (this.hlM) {
                        this.hlT.cfE().liveType = 2;
                    } else {
                        this.hlT.cfE().liveType = 1;
                    }
                }
            }
            cdZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdV() {
        final w Hi = this.hlq.Hi();
        if (Hi != null && Hi.mLiveInfo != null) {
            if (this.hlT == null || !this.hlT.cfB()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hlq.u(Hi.mLiveInfo.live_id, a.this.hlO);
                    }
                }, Hi.aJa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ap apVar) {
        if (apVar == null) {
            return false;
        }
        this.hlC.closeLoadingDialog();
        if (apVar.mErrorCode == 6) {
            this.hlC.showToast(apVar.mErrorMsg);
            if (this.hlT != null && this.hlT.cfE() != null) {
                this.hlT.cfE().errSubReason = 6;
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
        if (dVar != null && !dVar.hgO) {
            boolean z = dVar.hgP;
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
            if (this.hlT != null) {
                if (this.hlT.cfE() != null) {
                    this.hlT.cfE().updateTime = System.currentTimeMillis();
                }
                this.hlq.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hgQ, dVar.hgR ? 1 : 0, this.hlT.cbr(), this.hlM ? 2 : 1, this.hlP, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void cdW() {
        if (this.hlT != null && !this.hlT.cfD() && this.hlq.cgm() == null && this.hlT != null) {
            a(this.hlT.cfF());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hlT != null) {
            this.hlT.cfz();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bxq != null) {
            this.bxq.setIsAutoStartFromBack(true);
        }
        if (this.hlT != null) {
            this.hlT.cfA();
        }
    }

    public void onPause() {
        if (this.hlT != null) {
            this.hlT.onPause();
        }
    }

    public void onFinish() {
        if (this.hlT != null) {
            this.hlT.j(this.hlR);
        }
    }

    public void onDestroy() {
        if (this.gUd != null) {
            this.gUd.release();
            this.gUd = null;
        }
        if (this.hlT != null) {
            this.hlT.onDestroy();
        }
        if (this.hlS != null) {
            this.hlS.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gVZ.stop();
        this.gVZ = null;
        if (this.hlq != null) {
            this.hlq.destory();
            this.hlq = null;
        }
        if (this.bxo != null) {
            this.bxo.destory();
            this.bxo = null;
        }
        if (this.bxq != null) {
            ai aiVar = new ai();
            aiVar.aKx = this.hlM ? 2 : 1;
            aiVar.mOpenType = 2;
            if (this.hlT != null) {
                aiVar.aKw = this.hlT.cbr();
            }
            this.bxq.setRoomInfo(aiVar.toJsonString());
            String str = "";
            if (this.hlT != null && this.hlT.cfE() != null) {
                if (this.hlT.cfE().startLiveTime != 0) {
                    str = Long.toString(this.hlT.cfE().startLiveTime);
                }
                this.bxq.setConfigBeforeStop(this.hlT.cfE().getCpuMemJsonFormat(), str, "");
            }
            this.bxq.removeRecorderCallback(this.hlX);
            this.bxq.stopRecord();
            this.bxq.release();
            this.bxq = null;
        }
        if (this.hlI != null) {
            this.hlI.setOnTouchListener(null);
            this.hlI.chX();
            this.hlI = null;
        }
        this.hlC = null;
        MessageManager.getInstance().unRegisterListener(this.hlV);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dI(int i) {
        this.hlI.dI(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hlC.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hlC.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hlD.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hlD.setLayoutParams(layoutParams);
            if (this.hlN && this.bxq != null && this.bxq.getPreview() != null && this.bxq.getPreview().getParent() == null) {
                cdP();
            }
        }
        if (this.hlT != null) {
            this.hlT.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hlC.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hlT != null) {
            this.hlT.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hlT != null) {
            this.hlT.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int cdX() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdY() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hlT != null && a.this.hlT.cfE() != null) {
                        a.this.hlT.cfE().sampleMemAndCPU();
                    }
                    a.this.cdY();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdZ() {
        if (this.mHandler != null && this.bxq != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.vT(0);
                    a.this.cdZ();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(int i) {
        if (this.hlT != null && this.hlT.cfE() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bxq.getMediaStatus();
            if (this.hlq != null && this.hlq.cgm() != null && this.hlq.cgm().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hlq.cgm().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hlq.cgm().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bxq.getRecorderDebugInfo();
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
            if (this.hlC != null) {
                alaLiveExceptionInfo.appState = this.hlC.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hlQ;
            alaLiveExceptionInfo.sessionChannel = cdX();
            alaLiveExceptionInfo.nodeIP = this.bxq.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hlT.cfE().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hlT.cfE().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hlT.cfE().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hlT != null) {
            return this.hlT.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hlU.g(s);
    }
}
