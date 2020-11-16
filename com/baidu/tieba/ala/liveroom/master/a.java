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
    private j bvD;
    private AlaLiveRecorder bvF;
    private c gTK;
    private com.baidu.live.tieba.e.b gVG;
    private d hkX;
    private com.baidu.tieba.ala.liveroom.master.a.d hlA;
    private AlaMasterLiveRoomActivity hlj;
    private ViewGroup hlk;
    private RelativeLayout hll;
    private FrameLayout hlm;
    private AlaLiveFoucsExposureViewContainer hln;
    private View hlo;
    private AlaLiveView hlp;
    private ViewGroup hlq;
    private LayerRootView hlr;
    private String hls;
    private int hlw;
    private short hly;
    private com.baidu.live.ah.a hlz;
    private String mForumId;
    private String mForumName;
    private boolean hlt = false;
    private Handler mHandler = new Handler();
    private boolean hlu = false;
    private long hlv = 0;
    private int hlx = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hlB = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.hlt = dVar.hgz;
                if (dVar.hgv) {
                    a.this.cdn();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ws(int i) {
            if (i == 2) {
                a.this.Rn();
                if (a.this.hlu) {
                    a.this.wq(2);
                }
                a.this.bvF.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bvF.addRecorderCallback(a.this.hlE);
                a.this.hlp.setBackgroundColor(a.this.hlj.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.hlt) {
                    a.this.bvF.switchOrientation(a.this.hlt);
                    a.this.bvF.addRecorderCallback(a.this.hlE);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2 = -1;
            a.this.hly = s;
            if (a.this.hlj != null) {
                if (a.this.hly == 1) {
                    a.this.hlj.cdb();
                } else {
                    a.this.hlj.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hkX == null || a.this.hkX.Gz() == null || a.this.hkX.Gz().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.hkX.Gz().mLiveInfo.room_id;
                    j2 = a.this.hkX.Gz().mLiveInfo.live_id;
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
        public void VJ() {
            if (a.this.hlo != null) {
                if (a.this.hlo.getParent() != null) {
                    ((ViewGroup) a.this.hlo.getParent()).removeView(a.this.hlo);
                }
                a.this.hlo = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hlm.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hlm.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void beP() {
            if (a.this.hlo == null) {
                a.this.hlo = a.this.bvF.createPKPlayer();
            }
            if (a.this.hlo != null && a.this.hlo.getParent() == null) {
                a.this.hlm.addView(a.this.hlo, a.this.cdk());
            }
            if (a.this.bvF != null && a.this.bvF.getPreview() != null) {
                FrameLayout.LayoutParams cdj = a.this.cdj();
                if (a.this.bvF.getVideoConfig() != null) {
                    cdj.height = (a.this.bvF.getVideoConfig().getVideoHeight() * cdj.width) / a.this.bvF.getVideoConfig().getVideoWidth();
                }
                a.this.bvF.getPreview().setLayoutParams(cdj);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void caL() {
            FrameLayout.LayoutParams cdj = a.this.cdj();
            int aD = h.aD(a.this.hlj.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hlm.getLayoutParams();
            layoutParams.height = cdj.height;
            layoutParams.topMargin = aD;
            a.this.hlm.setLayoutParams(layoutParams);
            if (a.this.bvF.getVideoConfig() != null) {
                cdj.height = (a.this.bvF.getVideoConfig().getVideoHeight() * cdj.width) / a.this.bvF.getVideoConfig().getVideoWidth();
            }
            a.this.bvF.getPreview().setLayoutParams(cdj);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void caM() {
            a.this.Rn();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void caN() {
            a.this.cdi();
        }
    };
    private CustomMessageListener hlC = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bvF.stopRecord();
                } else {
                    a.this.bvF.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0170a hlD = new a.InterfaceC0170a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hlE = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hlA != null) {
                a.this.hlA.ceV();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hlA != null) {
                a.this.hlA.ceV();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                a.this.hlA.ceX().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hlA != null) {
                a.this.hlA.streamStateReceived(i, z, i2, z2);
            }
            a.this.hlx = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hlA != null) {
                if (z) {
                    a.this.hlA.bi(0, null);
                } else {
                    a.this.hlA.bi(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hlA != null && a.this.hlA.ceX() != null) {
                a.this.hlA.ceX().errCode = 2;
                a.this.hlA.bj(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hlA != null && a.this.hlA.ceX() != null) {
                a.this.hlA.ceX().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hlA.ceX().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hlA.ceX().startLiveTime == 0) {
                    a.this.hlA.ceX().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.wr(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hlj.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bvF != null && a.this.bvF.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bvF.getPreview() != null) {
                        a.this.Rn();
                    }
                    a.this.bvF.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bvF.addRecorderCallback(a.this.hlE);
                    a.this.bvF.stopRecord();
                    if (a.this.bvF.getPreview() != null) {
                        a.this.cdi();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bvF != null) {
                                a.this.bvF.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bvF.changeVideoRecorderType(com.baidu.live.aa.a.Ph().bms != null ? com.baidu.live.aa.a.Ph().bms.aJQ : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bvF.addRecorderCallback(a.this.hlE);
                if (a.this.bvF.getPreview() != null) {
                    a.this.cdi();
                }
                i2 = -4;
            }
            if (a.this.hlA != null) {
                a.this.hlA.bj(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hlA != null) {
                a.this.hlA.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hlA != null) {
                a.this.hlA.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private d.a hlF = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.q.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                ap cfF = a.this.hkX.cfF();
                if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                    a.this.hlA.ceX().logID = cfF.logId;
                    a.this.hlA.ceX().errCode = 5;
                }
                if (!a.this.a(cfF)) {
                    if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                        a.this.hlA.ceX().updateTime = System.currentTimeMillis() - a.this.hlA.ceX().updateTime;
                    }
                    if (cfF.aMi != 1) {
                        if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                            a.this.hlA.ceX().errSubReason = -1;
                        }
                        a.this.hlj.showToast(cfF.aMj);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cfF.mErrorCode != 0) {
                        if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                            a.this.hlA.ceX().errCode = 5;
                            a.this.hlA.ceX().errSubReason = cfF.mErrorCode;
                        }
                        a.this.hlj.showToast(str);
                        if (cfF.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hlj.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                            a.this.hlA.ceX().errCode = 0;
                            a.this.hlA.ceX().errSubReason = 0;
                        }
                        if (a.this.bvF != null) {
                            a.this.bvF.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.aa.a.Ph().bms.aKd);
                            a.this.bvF.setStartInfo(Long.toString(a.this.hkX.Gz().mLiveInfo.live_id), a.this.hkX.Gz().mLiveInfo.getSessionID(), com.baidu.live.aa.a.Ph().bms.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.hlA != null) {
                            a.this.hlA.c(a.this.hkX.cfF());
                        }
                        a.this.cdn();
                    }
                    if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                        a.this.hlA.ceX().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hlA != null) {
                    a.this.hlA.cei();
                }
            } else if (i2 == 1) {
                a.this.cdo();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hoc == 2) {
                                a.this.hlA.ceX().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hoc == 3) {
                                a.this.hlA.ceX().errSubReason = -3;
                            }
                        }
                        if (a.this.hlA != null && alaGetVerifyStrategyResponseHttpMessage.hoa == 1 && alaGetVerifyStrategyResponseHttpMessage.hoc == 1 && alaGetVerifyStrategyResponseHttpMessage.hof == 1 && alaGetVerifyStrategyResponseHttpMessage.hoh == 1) {
                            a.this.hlA.caI();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hlj.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hlA != null) {
                    a.this.hlA.ceu();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hoc != 3 ? 0 : 3;
                    if (a.this.hlz != null && a.this.hlA != null) {
                        a.this.hlz.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hlA.caK(), a.this.hls).gc(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hlA != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hlA;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.nh(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hlj = alaMasterLiveRoomActivity;
        this.gVG = new com.baidu.live.tieba.e.b(this.hlj.getActivity());
        cdr();
        this.gTK = new c();
        MessageManager.getInstance().registerListener(this.hlC);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ah.a.class, this.hlj.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hlz = (com.baidu.live.ah.a) runTask.getData();
            if (this.hlz != null) {
                this.hlz.a(this.hlD);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.hkX = dVar;
        if (this.hkX == null) {
            this.hkX = new d(this.hlj.getPageContext());
        }
        if (this.bvD == null && (runTask = MessageManager.getInstance().runTask(2913177, j.class, this.hlj.getPageContext().getPageActivity())) != null) {
            this.bvD = (j) runTask.getData();
        }
        if (this.bvD != null) {
            this.bvD.b(null);
            this.bvD.a(null);
            this.bvD.c(null);
        }
        this.hkX.a(this.hlF);
        if (this.hlA != null) {
            this.hlA.setArModel(this.bvD);
            this.hlA.a(this.hkX);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hls = str3;
        this.hlu = false;
        nw(false);
        cdl();
        if (this.hlA != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hgL = bundle;
            this.hlA.b(fVar);
            if (this.hlA.caK() == 1) {
                wq(this.hlA.caK());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hlw = alaLivePersonData.mLiveInfo.clarity;
        this.hlu = true;
        this.hlt = alaLivePersonData.mLiveInfo.screen_direction == 2;
        nw(true);
        cdl();
        if (this.hlA != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hgK = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                wq(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hlA.b(fVar);
        }
        if (this.hkX != null) {
            this.hkX.h(alaLivePersonData);
        }
    }

    private void cdg() {
        this.hlt = com.baidu.live.d.Aq().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cdh() {
        this.hlw = com.baidu.live.d.Aq().getInt("live_recorder_resolution_level", 2);
    }

    private void nw(boolean z) {
        if (!z) {
            cdh();
            cdg();
        }
        this.hlk = (ViewGroup) View.inflate(this.hlj.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.hlj.addContentView(this.hlk, new FrameLayout.LayoutParams(-1, -1));
        this.hlj.setContentView(this.hlk);
        this.hlm = (FrameLayout) this.hlk.findViewById(a.f.ala_live_render_view);
        this.hlp = (AlaLiveView) this.hlk.findViewById(a.f.ala_liveroom_host_liveview);
        this.hlp.setVisibility(8);
        this.hlp.setSwipeClearEnable(true);
        this.hll = (RelativeLayout) this.hlk.findViewById(a.f.ala_live_unremovable_container);
        this.hlq = (ViewGroup) this.hlk.findViewById(a.f.func_view);
        this.hlr = (LayerRootView) this.hlk.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.Do().j(this.hlr);
        this.hll.requestLayout();
        this.hlk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hlp == null || a.this.hlp.hvP) {
                    return false;
                }
                a.this.hlp.W(motionEvent);
                a.this.hln.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.OE().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.aa.a.Ph().bms != null && com.baidu.live.aa.a.Ph().bms.aJR) {
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
        if (bl.b(com.baidu.live.aa.a.Ph().bsh)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bl.a(com.baidu.live.aa.a.Ph().bsh)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bl.c(com.baidu.live.aa.a.Ph().bsh)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bvF = new AlaLiveRecorder(this.hlj.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bvF.addRecorderCallback(this.hlE);
        LiveRecorderConfigHelper.OE().OG();
        if (!this.hlt && this.bvF.getPreview() != null) {
            cdi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rn() {
        if (this.bvF != null && this.bvF.getPreview() != null && this.bvF.getPreview().getParent() != null) {
            ((ViewGroup) this.bvF.getPreview().getParent()).removeView(this.bvF.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdi() {
        this.bvF.getPreview().setEnabled(false);
        Rn();
        if (this.hlo == null) {
            this.hlm.addView(this.bvF.getPreview(), 0, Rm());
        } else {
            this.hlm.addView(this.bvF.getPreview(), 0, cdj());
        }
        if (this.hln == null) {
            this.hln = new AlaLiveFoucsExposureViewContainer(this.hlm.getContext());
            this.hln.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hkX != null && a.this.hkX.Gz() != null) {
                        alaLiveInfoData = a.this.hkX.Gz().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bvF != null) {
                        a.this.bvF.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bvF != null) {
                        a.this.bvF.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void cdt() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hkX != null && a.this.hkX.Gz() != null) {
                        alaLiveInfoData = a.this.hkX.Gz().mLiveInfo;
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
                    if (a.this.bvF != null) {
                        return a.this.bvF.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hlm.addView(this.hln, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams Rm() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cdj() {
        int i = BdUtilHelper.getScreenDimensions(this.hlj.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gd(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cdk() {
        int i = BdUtilHelper.getScreenDimensions(this.hlj.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gd(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq(int i) {
        if (this.hlu) {
            this.bvF.setVideoConfig(LiveRecorderConfigHelper.OE().d(this.hlw, i, this.hlt));
        } else {
            this.bvF.setVideoConfig(LiveRecorderConfigHelper.OE().d(i == 1 ? 0 : this.hlw, i, i == 1 ? this.hlt : false));
        }
    }

    private void cdl() {
        this.hlA = new com.baidu.tieba.ala.liveroom.master.a.d(this.hlj, this.bvF, this.hlp, this.hlm, this.hlk, this.hlq, this.gVG, this.hlj.cdc(), this.hln);
        this.hlA.a(this.hkX);
        this.hlA.setArModel(this.bvD);
        this.hlA.a(this.hlB);
    }

    public void cdm() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hlj.getPageContext().getPageActivity());
        if (this.bvF != null && this.bvF.getPreview() != null && (this.hlo == null || this.hlo.getParent() == null)) {
            this.bvF.getPreview().setLayoutParams(Rm());
        }
        if (this.hlA != null) {
            this.hlA.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hlj.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hlA != null) {
            this.hlA.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdn() {
        if (this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null) {
            if (this.hlA != null && this.hlA.ceX() != null) {
                this.hlA.ceX().liveID = Long.toString(this.hkX.Gz().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hkX.cfF().mLiveInfo.live_id), String.valueOf(this.hkX.cfF().mLiveInfo.room_id), String.valueOf(this.hkX.cfF().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hkX.cfF().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hkX.cfF().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hkX.cfF().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.hlv = System.currentTimeMillis() / 1000;
            this.hkX.u(this.hkX.Gz().mLiveInfo.live_id, this.hlv);
            this.hkX.h(this.hkX.Gz().mLiveInfo.live_id, false);
            com.baidu.live.d.Aq().putLong("last_live_room_id", this.hkX.Gz().mLiveInfo.live_id);
            this.hkX.cfK();
            if (this.hlA != null && this.hlA.ceX() != null) {
                if (this.hlA.caK() == 2) {
                    if (this.hlt) {
                        this.hlA.ceX().liveType = 5;
                    } else {
                        this.hlA.ceX().liveType = 4;
                    }
                } else if (this.hlA.caK() == 1) {
                    if (this.hlt) {
                        this.hlA.ceX().liveType = 2;
                    } else {
                        this.hlA.ceX().liveType = 1;
                    }
                }
            }
            cds();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdo() {
        final w Gz = this.hkX.Gz();
        if (Gz != null && Gz.mLiveInfo != null) {
            if (this.hlA == null || !this.hlA.ceU()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hkX.u(Gz.mLiveInfo.live_id, a.this.hlv);
                    }
                }, Gz.aHp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ap apVar) {
        if (apVar == null) {
            return false;
        }
        this.hlj.closeLoadingDialog();
        if (apVar.mErrorCode == 6) {
            this.hlj.showToast(apVar.mErrorMsg);
            if (this.hlA != null && this.hlA.ceX() != null) {
                this.hlA.ceX().errSubReason = 6;
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
        if (dVar != null && !dVar.hgv) {
            boolean z = dVar.hgw;
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
            if (this.hlA != null) {
                if (this.hlA.ceX() != null) {
                    this.hlA.ceX().updateTime = System.currentTimeMillis();
                }
                this.hkX.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hgx, dVar.hgy ? 1 : 0, this.hlA.caK(), this.hlt ? 2 : 1, this.hlw, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void cdp() {
        if (this.hlA != null && !this.hlA.ceW() && this.hkX.cfF() == null && this.hlA != null) {
            a(this.hlA.ceY());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hlA != null) {
            this.hlA.ceS();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bvF != null) {
            this.bvF.setIsAutoStartFromBack(true);
        }
        if (this.hlA != null) {
            this.hlA.ceT();
        }
    }

    public void onPause() {
        if (this.hlA != null) {
            this.hlA.onPause();
        }
    }

    public void onFinish() {
        if (this.hlA != null) {
            this.hlA.j(this.hly);
        }
    }

    public void onDestroy() {
        if (this.gTK != null) {
            this.gTK.release();
            this.gTK = null;
        }
        if (this.hlA != null) {
            this.hlA.onDestroy();
        }
        if (this.hlz != null) {
            this.hlz.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gVG.stop();
        this.gVG = null;
        if (this.hkX != null) {
            this.hkX.destory();
            this.hkX = null;
        }
        if (this.bvD != null) {
            this.bvD.destory();
            this.bvD = null;
        }
        if (this.bvF != null) {
            ai aiVar = new ai();
            aiVar.aIM = this.hlt ? 2 : 1;
            aiVar.mOpenType = 2;
            if (this.hlA != null) {
                aiVar.aIL = this.hlA.caK();
            }
            this.bvF.setRoomInfo(aiVar.toJsonString());
            String str = "";
            if (this.hlA != null && this.hlA.ceX() != null) {
                if (this.hlA.ceX().startLiveTime != 0) {
                    str = Long.toString(this.hlA.ceX().startLiveTime);
                }
                this.bvF.setConfigBeforeStop(this.hlA.ceX().getCpuMemJsonFormat(), str, "");
            }
            this.bvF.removeRecorderCallback(this.hlE);
            this.bvF.stopRecord();
            this.bvF.release();
            this.bvF = null;
        }
        if (this.hlp != null) {
            this.hlp.setOnTouchListener(null);
            this.hlp.chq();
            this.hlp = null;
        }
        this.hlj = null;
        MessageManager.getInstance().unRegisterListener(this.hlC);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dE(int i) {
        this.hlp.dE(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hlj.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hlj.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hlk.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hlk.setLayoutParams(layoutParams);
            if (this.hlu && this.bvF != null && this.bvF.getPreview() != null && this.bvF.getPreview().getParent() == null) {
                cdi();
            }
        }
        if (this.hlA != null) {
            this.hlA.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hlj.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hlA != null) {
            this.hlA.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hlA != null) {
            this.hlA.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int cdq() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdr() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hlA != null && a.this.hlA.ceX() != null) {
                        a.this.hlA.ceX().sampleMemAndCPU();
                    }
                    a.this.cdr();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cds() {
        if (this.mHandler != null && this.bvF != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.wr(0);
                    a.this.cds();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wr(int i) {
        if (this.hlA != null && this.hlA.ceX() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bvF.getMediaStatus();
            if (this.hkX != null && this.hkX.cfF() != null && this.hkX.cfF().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hkX.cfF().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hkX.cfF().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bvF.getRecorderDebugInfo();
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
            if (this.hlj != null) {
                alaLiveExceptionInfo.appState = this.hlj.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hlx;
            alaLiveExceptionInfo.sessionChannel = cdq();
            alaLiveExceptionInfo.nodeIP = this.bvF.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hlA.ceX().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hlA.ceX().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hlA.ceX().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hlA != null) {
            return this.hlA.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hlB.g(s);
    }
}
