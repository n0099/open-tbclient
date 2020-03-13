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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.an;
import com.baidu.live.data.m;
import com.baidu.live.data.s;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.g;
import com.baidu.live.z.a;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.ala.liveroom.m.b eOH;
    private com.baidu.live.tieba.e.b eRt;
    private AlaLiveRecorder fab;
    private c fdY;
    private AlaMasterLiveRoomActivity fej;
    private com.baidu.live.ar.c fek;
    private ViewGroup fel;
    private RelativeLayout fem;
    private FrameLayout fen;
    private View feo;
    private AlaLiveView fep;
    private String feq;
    private int feu;
    private short few;
    private com.baidu.live.z.a fex;
    private d fey;
    private String mForumId;
    private String mForumName;
    private boolean fer = false;
    private Handler mHandler = new Handler();
    private boolean fes = false;
    private long fet = 0;
    private int fev = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fez = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.fer = eVar.faT;
                if (eVar.faP) {
                    a.this.bnA();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qn(int i) {
            if (i == 2) {
                a.this.bnt();
                if (a.this.fes) {
                    a.this.qk(2);
                }
                a.this.fab.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.fab.addRecorderCallback(a.this.feC);
                a.this.fep.setBackgroundColor(a.this.fej.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.fer) {
                    a.this.fab.switchOrientation(a.this.fer);
                    a.this.fab.addRecorderCallback(a.this.feC);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.few = s;
            if (a.this.few == 1) {
                a.this.fej.bnp();
            } else {
                a.this.fej.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fdY == null || a.this.fdY.yO() == null || a.this.fdY.yO().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fdY.yO().mLiveInfo.room_id;
                    j2 = a.this.fdY.yO().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blO() {
            if (a.this.feo != null) {
                if (a.this.feo.getParent() != null) {
                    ((ViewGroup) a.this.feo.getParent()).removeView(a.this.feo);
                }
                a.this.feo = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fen.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.fen.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void awQ() {
            if (a.this.feo == null) {
                a.this.feo = a.this.fab.createPKPlayer();
            }
            if (a.this.feo != null && a.this.feo.getParent() == null) {
                a.this.fen.addView(a.this.feo, a.this.bnx());
            }
            if (a.this.fab != null && a.this.fab.getPreview() != null) {
                FrameLayout.LayoutParams bnw = a.this.bnw();
                if (a.this.fab.getVideoConfig() != null) {
                    bnw.height = (a.this.fab.getVideoConfig().getVideoHeight() * bnw.width) / a.this.fab.getVideoConfig().getVideoWidth();
                }
                a.this.fab.getPreview().setLayoutParams(bnw);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blP() {
            FrameLayout.LayoutParams bnw = a.this.bnw();
            int aK = g.aK(a.this.fej.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fen.getLayoutParams();
            layoutParams.height = bnw.height;
            layoutParams.topMargin = aK;
            a.this.fen.setLayoutParams(layoutParams);
            if (a.this.fab.getVideoConfig() != null) {
                bnw.height = (a.this.fab.getVideoConfig().getVideoHeight() * bnw.width) / a.this.fab.getVideoConfig().getVideoWidth();
            }
            a.this.fab.getPreview().setLayoutParams(bnw);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blQ() {
            a.this.bnt();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blR() {
            a.this.bnu();
        }
    };
    private CustomMessageListener feA = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.fab.stopRecord();
                } else {
                    a.this.fab.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0108a feB = new a.InterfaceC0108a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback feC = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.fey != null) {
                a.this.fey.boZ();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.fey != null) {
                a.this.fey.boZ();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.fey != null && a.this.fey.bpb() != null) {
                a.this.fey.bpb().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.fey != null) {
                a.this.fey.streamStateReceived(i, z, i2, z2);
            }
            a.this.fev = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.fey != null) {
                if (z) {
                    a.this.fey.aw(0, null);
                } else {
                    a.this.fey.aw(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.fey != null && a.this.fey.bpb() != null) {
                a.this.fey.bpb().errCode = 2;
                a.this.fey.ax(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.fey != null && a.this.fey.bpb() != null) {
                a.this.fey.bpb().linkTime = alaLiveDebugInfo.connectTime;
                a.this.fey.bpb().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.fey.bpb().startLiveTime == 0) {
                    a.this.fey.bpb().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.qm(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.fej.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.fab != null && a.this.fab.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.fab.getPreview() != null) {
                        a.this.bnt();
                    }
                    a.this.fab.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.fab.addRecorderCallback(a.this.feC);
                    a.this.fab.stopRecord();
                    if (a.this.fab.getPreview() != null) {
                        a.this.bnu();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fab != null) {
                                a.this.fab.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.fab.changeVideoRecorderType(com.baidu.live.v.a.zl().awC != null ? com.baidu.live.v.a.zl().awC.Zs : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.fab.addRecorderCallback(a.this.feC);
                if (a.this.fab.getPreview() != null) {
                    a.this.bnu();
                }
                i2 = -4;
            }
            if (a.this.fey != null) {
                a.this.fey.ax(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.fey != null) {
                a.this.fey.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.fey != null) {
                a.this.fey.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a feD = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                h bpF = a.this.fdY.bpF();
                a.this.fey.bpb().logID = bpF.Ym;
                a.this.fey.bpb().errCode = 5;
                if (!a.this.a(bpF)) {
                    if (a.this.fey != null && a.this.fey.bpb() != null) {
                        a.this.fey.bpb().updateTime = System.currentTimeMillis() - a.this.fey.bpb().updateTime;
                    }
                    if (bpF.fbf != 1) {
                        if (a.this.fey != null && a.this.fey.bpb() != null) {
                            a.this.fey.bpb().errSubReason = -1;
                        }
                        a.this.fej.showToast(bpF.fbg);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bpF.mErrorCode != 0) {
                        if (a.this.fey != null && a.this.fey.bpb() != null) {
                            a.this.fey.bpb().errCode = 5;
                            a.this.fey.bpb().errSubReason = bpF.mErrorCode;
                        }
                        a.this.fej.showToast(str);
                        if (bpF.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.fej.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.fey != null && a.this.fey.bpb() != null) {
                            a.this.fey.bpb().errCode = 0;
                            a.this.fey.bpb().errSubReason = 0;
                        }
                        if (a.this.fab != null) {
                            a.this.fab.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.zl().awC.ZF);
                            a.this.fab.setStartInfo(Long.toString(a.this.fdY.yO().mLiveInfo.live_id), a.this.fdY.yO().mLiveInfo.getSessionID(), com.baidu.live.v.a.zl().awC.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.fey != null) {
                            a.this.fey.c(a.this.fdY.bpF());
                        }
                        a.this.bnA();
                    }
                    if (a.this.fey != null && a.this.fey.bpb() != null) {
                        a.this.fey.bpb().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.fey != null) {
                    a.this.fey.bom();
                }
            } else if (i2 == 1) {
                a.this.bnB();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.fey != null && a.this.fey.bpb() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fgV == 2) {
                            a.this.fey.bpb().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fgV == 3) {
                            a.this.fey.bpb().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fey != null && alaGetVerifyStrategyResponseHttpMessage.fgT == 1 && alaGetVerifyStrategyResponseHttpMessage.fgV == 1) {
                            a.this.fey.blL();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.fey != null && alaGetVerifyStrategyResponseHttpMessage.fgT == 1 && alaGetVerifyStrategyResponseHttpMessage.fgV == 1 && alaGetVerifyStrategyResponseHttpMessage.fgY == 1) {
                        a.this.fey.blL();
                    }
                }
                if (a.this.fey != null) {
                    a.this.fey.boy();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.fgV != 3 ? 0 : 3;
                if (a.this.fex != null && a.this.fey != null) {
                    a.this.fex.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.fey.blN(), a.this.feq).cV(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.fej = alaMasterLiveRoomActivity;
        this.eRt = new com.baidu.live.tieba.e.b(this.fej.getActivity());
        bnE();
        this.eOH = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.feA);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.z.a.class, this.fej.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.fex = (com.baidu.live.z.a) runTask.getData();
            if (this.fex != null) {
                this.fex.a(this.feB);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.fdY = cVar;
        if (this.fdY == null) {
            this.fdY = new c(this.fej.getPageContext());
        }
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (this.fek == null && (runTask = MessageManager.getInstance().runTask(2913177, com.baidu.live.ar.c.class, this.fej)) != null) {
                this.fek = (com.baidu.live.ar.c) runTask.getData();
            }
            if (this.fek != null) {
                this.fek.a(null);
            }
        }
        this.fdY.a(this.feD);
        if (this.fey != null) {
            this.fey.setArModel(this.fek);
            this.fey.a(this.fdY);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.feq = str3;
        this.fes = false;
        jy(false);
        bny();
        if (this.fey != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.fbd = bundle;
            this.fey.b(gVar);
            if (this.fey.blN() == 1) {
                qk(this.fey.blN());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.feu = alaLivePersonData.mLiveInfo.clarity;
        this.fes = true;
        this.fer = alaLivePersonData.mLiveInfo.screen_direction == 2;
        jy(true);
        bny();
        if (this.fey != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.fbc = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                qk(alaLivePersonData.mLiveInfo.live_type);
            }
            this.fey.b(gVar);
        }
        if (this.fdY != null) {
            this.fdY.h(alaLivePersonData);
        }
    }

    private void bnr() {
        this.fer = com.baidu.live.c.pr().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bns() {
        this.feu = com.baidu.live.c.pr().getInt("live_recorder_resolution_level", 2);
    }

    private void jy(boolean z) {
        if (!z) {
            bns();
            bnr();
        }
        this.fel = (ViewGroup) View.inflate(this.fej.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.fej.addContentView(this.fel, new FrameLayout.LayoutParams(-1, -1));
        this.fej.setContentView(this.fel);
        this.fen = (FrameLayout) this.fel.findViewById(a.g.ala_live_render_view);
        this.fep = (AlaLiveView) this.fel.findViewById(a.g.ala_liveroom_host_liveview);
        this.fep.setVisibility(8);
        this.fep.setSwipeClearEnable(true);
        this.fem = (RelativeLayout) this.fel.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fem.getLayoutParams();
        layoutParams.topMargin = this.fej.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fej.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fem.requestLayout();
        this.fel.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.fep == null || a.this.fep.isDestroy) {
                    return false;
                }
                return a.this.fep.z(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.zg().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.zl().awC != null && com.baidu.live.v.a.zl().awC.Zt) {
            videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            if (LoadLibraryManager.getInstance().getLoadLibraryCallback() != null) {
                AlaLiveRecorderConfig.setILoadLibraryCallback(new AlaLiveRecorderConfig.ILoadLibrary() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
                    @Override // com.baidu.ala.recorder.AlaLiveRecorderConfig.ILoadLibrary
                    public boolean loadlibrary(String str) {
                        return LoadLibraryManager.getInstance().getLoadLibraryCallback().loadLibrary(str);
                    }
                });
            }
            if (LoadLibraryManager.getInstance().getFaceUnityCallBack() != null) {
                AlaLiveRecorderConfig.setFaceUnityCallback(new AlaLiveRecorderConfig.FaceUnityCallBack() { // from class: com.baidu.tieba.ala.liveroom.master.a.8
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
        if (!TbadkCoreApplication.getInst().isTieba()) {
            videoBeautyType = VideoBeautyType.DUMIX_AR;
            if (an.b(com.baidu.live.v.a.zl().axD)) {
                videoBeautyType = VideoBeautyType.DUMIX_AR;
            } else if (an.a(com.baidu.live.v.a.zl().axD)) {
                videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
            } else if (an.c(com.baidu.live.v.a.zl().axD)) {
                videoBeautyType = VideoBeautyType.BEAUTY_TIEBA;
            }
        }
        this.fab = new AlaLiveRecorder(this.fej.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType);
        this.fab.setUserGameHardEncode(com.baidu.live.v.a.zl().awC.Zv);
        this.fab.addRecorderCallback(this.feC);
        if (!this.fer && this.fab.getPreview() != null) {
            bnu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnt() {
        if (this.fab != null && this.fab.getPreview() != null && this.fab.getPreview().getParent() != null) {
            ((ViewGroup) this.fab.getPreview().getParent()).removeView(this.fab.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnu() {
        this.fab.getPreview().setEnabled(false);
        bnt();
        if (this.feo == null) {
            this.fen.addView(this.fab.getPreview(), 0, bnv());
        } else {
            this.fen.addView(this.fab.getPreview(), 0, bnw());
        }
    }

    private FrameLayout.LayoutParams bnv() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnw() {
        int i = BdUtilHelper.getScreenDimensions(this.fej.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnx() {
        int i = BdUtilHelper.getScreenDimensions(this.fej.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk(int i) {
        if (this.fes) {
            this.fab.setVideoConfig(LiveRecorderConfigHelper.zg().d(this.feu, i, this.fer));
        } else {
            this.fab.setVideoConfig(LiveRecorderConfigHelper.zg().d(i == 1 ? 0 : this.feu, i, i == 1 ? this.fer : false));
        }
    }

    private void bny() {
        this.fey = new d(this.fej, this.fab, this.fep, this.fen, this.fel, this.eRt, this.fej.bnq());
        this.fey.a(this.fdY);
        this.fey.setArModel(this.fek);
        this.fey.a(this.fez);
    }

    public void bnz() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fej.getPageContext().getPageActivity());
        if (this.fab != null && this.fab.getPreview() != null && (this.feo == null || this.feo.getParent() == null)) {
            this.fab.getPreview().setLayoutParams(bnv());
        }
        if (this.fey != null) {
            this.fey.j(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.fej.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fey != null) {
            this.fey.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnA() {
        if (this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null) {
            if (this.fey != null && this.fey.bpb() != null) {
                this.fey.bpb().liveID = Long.toString(this.fdY.yO().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            this.fet = System.currentTimeMillis() / 1000;
            this.fdY.x(this.fdY.yO().mLiveInfo.live_id, this.fet);
            this.fdY.cX(this.fdY.yO().mLiveInfo.live_id);
            com.baidu.live.c.pr().putLong("last_live_room_id", this.fdY.yO().mLiveInfo.live_id);
            this.fdY.bpL();
            if (this.fey != null && this.fey.bpb() != null) {
                if (this.fey.blN() == 2) {
                    if (this.fer) {
                        this.fey.bpb().liveType = 5;
                    } else {
                        this.fey.bpb().liveType = 4;
                    }
                } else if (this.fey.blN() == 1) {
                    if (this.fer) {
                        this.fey.bpb().liveType = 2;
                    } else {
                        this.fey.bpb().liveType = 1;
                    }
                }
            }
            bnF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnB() {
        final m yO = this.fdY.yO();
        if (yO != null && yO.mLiveInfo != null) {
            if (this.fey == null || !this.fey.boY()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fdY.x(yO.mLiveInfo.live_id, a.this.fet);
                    }
                }, yO.XU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        this.fej.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.fej.showToast(hVar.mErrorMsg);
            if (this.fey != null && this.fey.bpb() != null) {
                this.fey.bpb().errSubReason = 6;
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
        if (eVar != null && !eVar.faP) {
            boolean z = eVar.faQ;
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
            if (this.fey != null) {
                if (this.fey.bpb() != null) {
                    this.fey.bpb().updateTime = System.currentTimeMillis();
                }
                this.fdY.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.faR, eVar.faS ? 1 : 0, this.fey.blN(), this.fer ? 2 : 1, this.feu, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bnC() {
        if (this.fey != null && !this.fey.bpa() && this.fdY.bpF() == null && this.fey != null) {
            a(this.fey.bpc());
        }
    }

    public void onStop() {
        if (this.fey != null) {
            this.fey.boW();
        }
    }

    public void onResume() {
        if (this.fab != null) {
            this.fab.setIsAutoStartFromBack(true);
        }
        if (this.fey != null) {
            this.fey.boX();
        }
    }

    public void onPause() {
        if (this.fey != null) {
            this.fey.onPause();
        }
    }

    public void onFinish() {
        if (this.fey != null) {
            this.fey.i(this.few);
        }
    }

    public void onDestroy() {
        if (this.eOH != null) {
            this.eOH.release();
            this.eOH = null;
        }
        if (this.fey != null) {
            this.fey.onDestroy();
        }
        if (this.fex != null) {
            this.fex.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.eRt.stop();
        this.eRt = null;
        if (this.fdY != null) {
            this.fdY.destory();
            this.fdY = null;
        }
        if (this.fek != null) {
            this.fek.destory();
            this.fek = null;
        }
        if (this.fab != null) {
            s sVar = new s();
            sVar.Yy = this.fer ? 2 : 1;
            sVar.mOpenType = 2;
            if (this.fey != null) {
                sVar.Yx = this.fey.blN();
            }
            this.fab.setRoomInfo(sVar.toJsonString());
            String str = "";
            if (this.fey != null && this.fey.bpb() != null) {
                if (this.fey.bpb().startLiveTime != 0) {
                    str = Long.toString(this.fey.bpb().startLiveTime);
                }
                this.fab.setConfigBeforeStop(this.fey.bpb().getCpuMemJsonFormat(), str, "");
            }
            this.fab.removeRecorderCallback(this.feC);
            this.fab.stopRecord();
            this.fab.release();
            this.fab = null;
        }
        if (this.fep != null) {
            this.fep.setOnTouchListener(null);
            this.fep.brc();
            this.fep = null;
        }
        this.fej = null;
        MessageManager.getInstance().unRegisterListener(this.feA);
    }

    public void bW(int i) {
        this.fep.bW(i);
        ql(i);
    }

    private void ql(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fej.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.fej.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fel.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.fel.setLayoutParams(layoutParams);
            if (this.fes && this.fab != null && this.fab.getPreview() != null && this.fab.getPreview().getParent() == null) {
                bnu();
            }
        }
        if (this.fey != null) {
            this.fey.j(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.fej.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fey != null) {
            this.fey.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fey != null) {
            this.fey.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bnD() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnE() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fey.bpb().sampleMemAndCPU();
                    a.this.bnE();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnF() {
        if (this.mHandler != null && this.fab != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.qm(0);
                    a.this.bnF();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(int i) {
        if (this.fey != null && this.fey.bpb() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.fab.getMediaStatus();
            if (this.fdY != null && this.fdY.bpF() != null && this.fdY.bpF().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fdY.bpF().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fdY.bpF().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.fab.getRecorderDebugInfo();
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
            if (this.fej != null) {
                alaLiveExceptionInfo.appState = this.fej.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.fev;
            alaLiveExceptionInfo.sessionChannel = bnD();
            alaLiveExceptionInfo.nodeIP = this.fab.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.fey.bpb().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.fey.bpb().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.fey.bpb().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fey != null) {
            return this.fey.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.fez.f(s);
    }
}
