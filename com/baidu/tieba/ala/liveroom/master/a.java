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
import com.baidu.live.ag.a;
import com.baidu.live.ar.i;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.ah;
import com.baidu.live.data.ao;
import com.baidu.live.data.bk;
import com.baidu.live.data.w;
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
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.g;
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
    private AlaLiveRecorder bAM;
    private i fZS;
    private c gNE;
    private com.baidu.live.tieba.e.b gPV;
    private AlaMasterLiveRoomActivity hfH;
    private ViewGroup hfI;
    private RelativeLayout hfJ;
    private FrameLayout hfK;
    private AlaLiveFoucsExposureViewContainer hfL;
    private View hfM;
    private AlaLiveView hfN;
    private ViewGroup hfO;
    private LayerRootView hfP;
    private String hfQ;
    private int hfU;
    private short hfW;
    private com.baidu.live.ag.a hfX;
    private d hfY;
    private com.baidu.tieba.ala.liveroom.q.d hfu;
    private String mForumId;
    private String mForumName;
    private boolean hfR = false;
    private Handler mHandler = new Handler();
    private boolean hfS = false;
    private long hfT = 0;
    private int hfV = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hfZ = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.hfR = eVar.haY;
                if (eVar.haU) {
                    a.this.cbv();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void vH(int i) {
            if (i == 2) {
                a.this.cbo();
                if (a.this.hfS) {
                    a.this.vF(2);
                }
                a.this.bAM.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bAM.addRecorderCallback(a.this.hgc);
                a.this.hfN.setBackgroundColor(a.this.hfH.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.hfR) {
                    a.this.bAM.switchOrientation(a.this.hfR);
                    a.this.bAM.addRecorderCallback(a.this.hgc);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2 = -1;
            a.this.hfW = s;
            if (a.this.hfH != null) {
                if (a.this.hfW == 1) {
                    a.this.hfH.cbh();
                } else {
                    a.this.hfH.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hfu == null || a.this.hfu.GH() == null || a.this.hfu.GH().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.hfu.GH().mLiveInfo.room_id;
                    j2 = a.this.hfu.GH().mLiveInfo.live_id;
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
        public void TS() {
            if (a.this.hfM != null) {
                if (a.this.hfM.getParent() != null) {
                    ((ViewGroup) a.this.hfM.getParent()).removeView(a.this.hfM);
                }
                a.this.hfM = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hfK.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hfK.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bcW() {
            if (a.this.hfM == null) {
                a.this.hfM = a.this.bAM.createPKPlayer();
            }
            if (a.this.hfM != null && a.this.hfM.getParent() == null) {
                a.this.hfK.addView(a.this.hfM, a.this.cbs());
            }
            if (a.this.bAM != null && a.this.bAM.getPreview() != null) {
                FrameLayout.LayoutParams cbr = a.this.cbr();
                if (a.this.bAM.getVideoConfig() != null) {
                    cbr.height = (a.this.bAM.getVideoConfig().getVideoHeight() * cbr.width) / a.this.bAM.getVideoConfig().getVideoWidth();
                }
                a.this.bAM.getPreview().setLayoutParams(cbr);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bYQ() {
            FrameLayout.LayoutParams cbr = a.this.cbr();
            int aC = h.aC(a.this.hfH.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hfK.getLayoutParams();
            layoutParams.height = cbr.height;
            layoutParams.topMargin = aC;
            a.this.hfK.setLayoutParams(layoutParams);
            if (a.this.bAM.getVideoConfig() != null) {
                cbr.height = (a.this.bAM.getVideoConfig().getVideoHeight() * cbr.width) / a.this.bAM.getVideoConfig().getVideoWidth();
            }
            a.this.bAM.getPreview().setLayoutParams(cbr);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bYR() {
            a.this.cbo();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bYS() {
            a.this.cbp();
        }
    };
    private CustomMessageListener hga = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bAM.stopRecord();
                } else {
                    a.this.bAM.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0171a hgb = new a.InterfaceC0171a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hgc = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hfY != null) {
                a.this.hfY.cdb();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hfY != null) {
                a.this.hfY.cdb();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                a.this.hfY.cdd().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hfY != null) {
                a.this.hfY.streamStateReceived(i, z, i2, z2);
            }
            a.this.hfV = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hfY != null) {
                if (z) {
                    a.this.hfY.bg(0, null);
                } else {
                    a.this.hfY.bg(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hfY != null && a.this.hfY.cdd() != null) {
                a.this.hfY.cdd().errCode = 2;
                a.this.hfY.bh(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hfY != null && a.this.hfY.cdd() != null) {
                a.this.hfY.cdd().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hfY.cdd().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hfY.cdd().startLiveTime == 0) {
                    a.this.hfY.cdd().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.vG(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hfH.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.bAM != null && a.this.bAM.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bAM.getPreview() != null) {
                        a.this.cbo();
                    }
                    a.this.bAM.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bAM.addRecorderCallback(a.this.hgc);
                    a.this.bAM.stopRecord();
                    if (a.this.bAM.getPreview() != null) {
                        a.this.cbp();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bAM != null) {
                                a.this.bAM.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bAM.changeVideoRecorderType(com.baidu.live.z.a.Pq().bmJ != null ? com.baidu.live.z.a.Pq().bmJ.aKB : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bAM.addRecorderCallback(a.this.hgc);
                if (a.this.bAM.getPreview() != null) {
                    a.this.cbp();
                }
                i2 = -4;
            }
            if (a.this.hfY != null) {
                a.this.hfY.bh(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hfY != null) {
                a.this.hfY.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hfY != null) {
                a.this.hfY.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private d.a hgd = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.q.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                ao cdL = a.this.hfu.cdL();
                if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                    a.this.hfY.cdd().logID = cdL.logId;
                    a.this.hfY.cdd().errCode = 5;
                }
                if (!a.this.a(cdL)) {
                    if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                        a.this.hfY.cdd().updateTime = System.currentTimeMillis() - a.this.hfY.cdd().updateTime;
                    }
                    if (cdL.aMR != 1) {
                        if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                            a.this.hfY.cdd().errSubReason = -1;
                        }
                        a.this.hfH.showToast(cdL.aMS);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cdL.mErrorCode != 0) {
                        if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                            a.this.hfY.cdd().errCode = 5;
                            a.this.hfY.cdd().errSubReason = cdL.mErrorCode;
                        }
                        a.this.hfH.showToast(str);
                        if (cdL.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hfH.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                            a.this.hfY.cdd().errCode = 0;
                            a.this.hfY.cdd().errSubReason = 0;
                        }
                        if (a.this.bAM != null) {
                            a.this.bAM.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.z.a.Pq().bmJ.aKO);
                            a.this.bAM.setStartInfo(Long.toString(a.this.hfu.GH().mLiveInfo.live_id), a.this.hfu.GH().mLiveInfo.getSessionID(), com.baidu.live.z.a.Pq().bmJ.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.hfY != null) {
                            a.this.hfY.c(a.this.hfu.cdL());
                        }
                        a.this.cbv();
                    }
                    if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                        a.this.hfY.cdd().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hfY != null) {
                    a.this.hfY.cco();
                }
            } else if (i2 == 1) {
                a.this.cbw();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hiE == 2) {
                                a.this.hfY.cdd().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hiE == 3) {
                                a.this.hfY.cdd().errSubReason = -3;
                            }
                        }
                        if (a.this.hfY != null && alaGetVerifyStrategyResponseHttpMessage.hiC == 1 && alaGetVerifyStrategyResponseHttpMessage.hiE == 1 && alaGetVerifyStrategyResponseHttpMessage.hiH == 1 && alaGetVerifyStrategyResponseHttpMessage.hiJ == 1) {
                            a.this.hfY.bYN();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hfH.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hfY != null) {
                    a.this.hfY.ccA();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hiE != 3 ? 0 : 3;
                    if (a.this.hfX != null && a.this.hfY != null) {
                        a.this.hfX.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hfY.bYP(), a.this.hfQ).fT(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hfY != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hfY;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.mX(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hfH = alaMasterLiveRoomActivity;
        this.gPV = new com.baidu.live.tieba.e.b(this.hfH.getActivity());
        cbz();
        this.gNE = new c();
        MessageManager.getInstance().registerListener(this.hga);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ag.a.class, this.hfH.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hfX = (com.baidu.live.ag.a) runTask.getData();
            if (this.hfX != null) {
                this.hfX.a(this.hgb);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        CustomResponsedMessage runTask;
        this.hfu = dVar;
        if (this.hfu == null) {
            this.hfu = new com.baidu.tieba.ala.liveroom.q.d(this.hfH.getPageContext());
        }
        if (this.fZS == null && (runTask = MessageManager.getInstance().runTask(2913177, i.class, this.hfH.getPageContext().getPageActivity())) != null) {
            this.fZS = (i) runTask.getData();
        }
        if (this.fZS != null) {
            this.fZS.b(null);
            this.fZS.a(null);
            this.fZS.c(null);
        }
        this.hfu.a(this.hgd);
        if (this.hfY != null) {
            this.hfY.setArModel(this.fZS);
            this.hfY.a(this.hfu);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hfQ = str3;
        this.hfS = false;
        nm(false);
        cbt();
        if (this.hfY != null) {
            g gVar = new g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.hbj = bundle;
            this.hfY.b(gVar);
            if (this.hfY.bYP() == 1) {
                vF(this.hfY.bYP());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hfU = alaLivePersonData.mLiveInfo.clarity;
        this.hfS = true;
        this.hfR = alaLivePersonData.mLiveInfo.screen_direction == 2;
        nm(true);
        cbt();
        if (this.hfY != null) {
            g gVar = new g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.hbi = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                vF(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hfY.b(gVar);
        }
        if (this.hfu != null) {
            this.hfu.h(alaLivePersonData);
        }
    }

    private void cbm() {
        this.hfR = com.baidu.live.d.AZ().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cbn() {
        this.hfU = com.baidu.live.d.AZ().getInt("live_recorder_resolution_level", 2);
    }

    private void nm(boolean z) {
        if (!z) {
            cbn();
            cbm();
        }
        this.hfI = (ViewGroup) View.inflate(this.hfH.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.hfH.addContentView(this.hfI, new FrameLayout.LayoutParams(-1, -1));
        this.hfH.setContentView(this.hfI);
        this.hfK = (FrameLayout) this.hfI.findViewById(a.g.ala_live_render_view);
        this.hfN = (AlaLiveView) this.hfI.findViewById(a.g.ala_liveroom_host_liveview);
        this.hfN.setVisibility(8);
        this.hfN.setSwipeClearEnable(true);
        this.hfJ = (RelativeLayout) this.hfI.findViewById(a.g.ala_live_unremovable_container);
        this.hfO = (ViewGroup) this.hfI.findViewById(a.g.func_view);
        this.hfP = (LayerRootView) this.hfI.findViewById(a.g.layer_root_view);
        com.baidu.live.core.layer.b.DE().n(this.hfP);
        this.hfJ.requestLayout();
        this.hfI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hfN == null || a.this.hfN.hqk) {
                    return false;
                }
                a.this.hfN.V(motionEvent);
                a.this.hfL.Q(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.ON().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.z.a.Pq().bmJ != null && com.baidu.live.z.a.Pq().bmJ.aKC) {
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
        if (bk.b(com.baidu.live.z.a.Pq().bsy)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bk.a(com.baidu.live.z.a.Pq().bsy)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bk.c(com.baidu.live.z.a.Pq().bsy)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bAM = new AlaLiveRecorder(this.hfH.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bAM.addRecorderCallback(this.hgc);
        LiveRecorderConfigHelper.ON().OP();
        if (!this.hfR && this.bAM.getPreview() != null) {
            cbp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbo() {
        if (this.bAM != null && this.bAM.getPreview() != null && this.bAM.getPreview().getParent() != null) {
            ((ViewGroup) this.bAM.getPreview().getParent()).removeView(this.bAM.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbp() {
        this.bAM.getPreview().setEnabled(false);
        cbo();
        if (this.hfM == null) {
            this.hfK.addView(this.bAM.getPreview(), 0, cbq());
        } else {
            this.hfK.addView(this.bAM.getPreview(), 0, cbr());
        }
        if (this.hfL == null) {
            this.hfL = new AlaLiveFoucsExposureViewContainer(this.hfK.getContext());
            this.hfL.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hfu != null && a.this.hfu.GH() != null) {
                        alaLiveInfoData = a.this.hfu.GH().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bAM != null) {
                        a.this.bAM.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bAM != null) {
                        a.this.bAM.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void cbB() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hfu != null && a.this.hfu.GH() != null) {
                        alaLiveInfoData = a.this.hfu.GH().mLiveInfo;
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
                    if (a.this.bAM != null) {
                        return a.this.bAM.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hfK.addView(this.hfL, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams cbq() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cbr() {
        int i = BdUtilHelper.getScreenDimensions(this.hfH.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fU(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cbs() {
        int i = BdUtilHelper.getScreenDimensions(this.hfH.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fU(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        if (this.hfS) {
            this.bAM.setVideoConfig(LiveRecorderConfigHelper.ON().d(this.hfU, i, this.hfR));
        } else {
            this.bAM.setVideoConfig(LiveRecorderConfigHelper.ON().d(i == 1 ? 0 : this.hfU, i, i == 1 ? this.hfR : false));
        }
    }

    private void cbt() {
        this.hfY = new com.baidu.tieba.ala.liveroom.master.a.d(this.hfH, this.bAM, this.hfN, this.hfK, this.hfI, this.hfO, this.gPV, this.hfH.cbi());
        this.hfY.a(this.hfu);
        this.hfY.setArModel(this.fZS);
        this.hfY.a(this.hfZ);
    }

    public void cbu() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hfH.getPageContext().getPageActivity());
        if (this.bAM != null && this.bAM.getPreview() != null && (this.hfM == null || this.hfM.getParent() == null)) {
            this.bAM.getPreview().setLayoutParams(cbq());
        }
        if (this.hfY != null) {
            this.hfY.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hfH.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hfY != null) {
            this.hfY.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbv() {
        if (this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null) {
            if (this.hfY != null && this.hfY.cdd() != null) {
                this.hfY.cdd().liveID = Long.toString(this.hfu.GH().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hfu.cdL().mLiveInfo.live_id), String.valueOf(this.hfu.cdL().mLiveInfo.room_id), String.valueOf(this.hfu.cdL().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hfu.cdL().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hfu.cdL().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hfu.cdL().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.hfT = System.currentTimeMillis() / 1000;
            this.hfu.t(this.hfu.GH().mLiveInfo.live_id, this.hfT);
            this.hfu.h(this.hfu.GH().mLiveInfo.live_id, false);
            com.baidu.live.d.AZ().putLong("last_live_room_id", this.hfu.GH().mLiveInfo.live_id);
            this.hfu.cdQ();
            if (this.hfY != null && this.hfY.cdd() != null) {
                if (this.hfY.bYP() == 2) {
                    if (this.hfR) {
                        this.hfY.cdd().liveType = 5;
                    } else {
                        this.hfY.cdd().liveType = 4;
                    }
                } else if (this.hfY.bYP() == 1) {
                    if (this.hfR) {
                        this.hfY.cdd().liveType = 2;
                    } else {
                        this.hfY.cdd().liveType = 1;
                    }
                }
            }
            cbA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbw() {
        final w GH = this.hfu.GH();
        if (GH != null && GH.mLiveInfo != null) {
            if (this.hfY == null || !this.hfY.cda()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hfu.t(GH.mLiveInfo.live_id, a.this.hfT);
                    }
                }, GH.aIj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ao aoVar) {
        if (aoVar == null) {
            return false;
        }
        this.hfH.closeLoadingDialog();
        if (aoVar.mErrorCode == 6) {
            this.hfH.showToast(aoVar.mErrorMsg);
            if (this.hfY != null && this.hfY.cdd() != null) {
                this.hfY.cdd().errSubReason = 6;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (eVar != null && !eVar.haU) {
            boolean z = eVar.haV;
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
            if (this.hfY != null) {
                if (this.hfY.cdd() != null) {
                    this.hfY.cdd().updateTime = System.currentTimeMillis();
                }
                this.hfu.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.haW, eVar.haX ? 1 : 0, this.hfY.bYP(), this.hfR ? 2 : 1, this.hfU, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void cbx() {
        if (this.hfY != null && !this.hfY.cdc() && this.hfu.cdL() == null && this.hfY != null) {
            a(this.hfY.cde());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hfY != null) {
            this.hfY.ccY();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bAM != null) {
            this.bAM.setIsAutoStartFromBack(true);
        }
        if (this.hfY != null) {
            this.hfY.ccZ();
        }
    }

    public void onPause() {
        if (this.hfY != null) {
            this.hfY.onPause();
        }
    }

    public void onFinish() {
        if (this.hfY != null) {
            this.hfY.j(this.hfW);
        }
    }

    public void onDestroy() {
        if (this.gNE != null) {
            this.gNE.release();
            this.gNE = null;
        }
        if (this.hfY != null) {
            this.hfY.onDestroy();
        }
        if (this.hfX != null) {
            this.hfX.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gPV.stop();
        this.gPV = null;
        if (this.hfu != null) {
            this.hfu.destory();
            this.hfu = null;
        }
        if (this.fZS != null) {
            this.fZS.destory();
            this.fZS = null;
        }
        if (this.bAM != null) {
            ah ahVar = new ah();
            ahVar.aJx = this.hfR ? 2 : 1;
            ahVar.mOpenType = 2;
            if (this.hfY != null) {
                ahVar.aJw = this.hfY.bYP();
            }
            this.bAM.setRoomInfo(ahVar.toJsonString());
            String str = "";
            if (this.hfY != null && this.hfY.cdd() != null) {
                if (this.hfY.cdd().startLiveTime != 0) {
                    str = Long.toString(this.hfY.cdd().startLiveTime);
                }
                this.bAM.setConfigBeforeStop(this.hfY.cdd().getCpuMemJsonFormat(), str, "");
            }
            this.bAM.removeRecorderCallback(this.hgc);
            this.bAM.stopRecord();
            this.bAM.release();
            this.bAM = null;
        }
        if (this.hfN != null) {
            this.hfN.setOnTouchListener(null);
            this.hfN.cfu();
            this.hfN = null;
        }
        this.hfH = null;
        MessageManager.getInstance().unRegisterListener(this.hga);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dI(int i) {
        this.hfN.dI(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hfH.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hfH.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfI.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hfI.setLayoutParams(layoutParams);
            if (this.hfS && this.bAM != null && this.bAM.getPreview() != null && this.bAM.getPreview().getParent() == null) {
                cbp();
            }
        }
        if (this.hfY != null) {
            this.hfY.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hfH.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hfY != null) {
            this.hfY.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hfY != null) {
            this.hfY.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int cby() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbz() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hfY != null && a.this.hfY.cdd() != null) {
                        a.this.hfY.cdd().sampleMemAndCPU();
                    }
                    a.this.cbz();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbA() {
        if (this.mHandler != null && this.bAM != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.vG(0);
                    a.this.cbA();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vG(int i) {
        if (this.hfY != null && this.hfY.cdd() != null) {
            com.baidu.live.message.e eVar = new com.baidu.live.message.e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bAM.getMediaStatus();
            if (this.hfu != null && this.hfu.cdL() != null && this.hfu.cdL().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hfu.cdL().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hfu.cdL().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bAM.getRecorderDebugInfo();
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
            if (this.hfH != null) {
                alaLiveExceptionInfo.appState = this.hfH.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hfV;
            alaLiveExceptionInfo.sessionChannel = cby();
            alaLiveExceptionInfo.nodeIP = this.bAM.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hfY.cdd().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hfY.cdd().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hfY.cdd().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hfY != null) {
            return this.hfY.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hfZ.g(s);
    }
}
