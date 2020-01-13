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
import com.baidu.live.ar.c;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.am;
import com.baidu.live.data.l;
import com.baidu.live.data.r;
import com.baidu.live.r.a;
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
import com.baidu.live.utils.g;
import com.baidu.live.w.a;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.o.c;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.ala.liveroom.o.b eKy;
    private com.baidu.live.tieba.e.b eNc;
    private AlaLiveRecorder eVX;
    private AlaMasterLiveRoomActivity faJ;
    private c faK;
    private ViewGroup faL;
    private RelativeLayout faM;
    private RelativeLayout faN;
    private FrameLayout faO;
    private View faP;
    private AlaLiveView faQ;
    private String faR;
    private int faV;
    private short faX;
    private com.baidu.live.w.a faY;
    private d faZ;
    private com.baidu.tieba.ala.liveroom.o.c fay;
    private String mForumId;
    private String mForumName;
    private boolean faS = false;
    private Handler mHandler = new Handler();
    private boolean faT = false;
    private long faU = 0;
    private int faW = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fba = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.faS = eVar.eWQ;
                if (eVar.eWM) {
                    a.this.blP();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qf(int i) {
            if (i == 2) {
                a.this.blI();
                if (a.this.faT) {
                    a.this.qc(2);
                }
                a.this.eVX.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.eVX.addRecorderCallback(a.this.fbd);
                a.this.faQ.setBackgroundColor(a.this.faJ.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.faS) {
                    a.this.eVX.switchOrientation(a.this.faS);
                    a.this.eVX.addRecorderCallback(a.this.fbd);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void d(short s) {
            long j;
            long j2 = -1;
            a.this.faX = s;
            if (a.this.faX == 1) {
                a.this.faJ.blE();
            } else {
                a.this.faJ.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fay == null || a.this.fay.ww() == null || a.this.fay.ww().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fay.ww().mLiveInfo.room_id;
                    j2 = a.this.fay.ww().mLiveInfo.live_id;
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
        public void bjX() {
            if (a.this.faP != null) {
                if (a.this.faP.getParent() != null) {
                    ((ViewGroup) a.this.faP.getParent()).removeView(a.this.faP);
                }
                a.this.faP = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.faO.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.faO.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void auA() {
            if (a.this.faP == null) {
                a.this.faP = a.this.eVX.createPKPlayer();
            }
            if (a.this.faP != null && a.this.faP.getParent() == null) {
                a.this.faO.addView(a.this.faP, a.this.blM());
            }
            if (a.this.eVX != null && a.this.eVX.getPreview() != null) {
                FrameLayout.LayoutParams blL = a.this.blL();
                if (a.this.eVX.getVideoConfig() != null) {
                    blL.height = (a.this.eVX.getVideoConfig().getVideoHeight() * blL.width) / a.this.eVX.getVideoConfig().getVideoWidth();
                }
                a.this.eVX.getPreview().setLayoutParams(blL);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bjY() {
            FrameLayout.LayoutParams blL = a.this.blL();
            int aG = g.aG(a.this.faJ.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.faO.getLayoutParams();
            layoutParams.height = blL.height;
            layoutParams.topMargin = aG;
            a.this.faO.setLayoutParams(layoutParams);
            if (a.this.eVX.getVideoConfig() != null) {
                blL.height = (a.this.eVX.getVideoConfig().getVideoHeight() * blL.width) / a.this.eVX.getVideoConfig().getVideoWidth();
            }
            a.this.eVX.getPreview().setLayoutParams(blL);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bjZ() {
            a.this.blI();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bka() {
            a.this.blJ();
        }
    };
    private CustomMessageListener fbb = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.eVX.stopRecord();
                } else {
                    a.this.eVX.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0099a fbc = new a.InterfaceC0099a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback fbd = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.faZ != null) {
                a.this.faZ.bnm();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.faZ != null) {
                a.this.faZ.bnm();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.faZ != null && a.this.faZ.bno() != null) {
                a.this.faZ.bno().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.faZ != null) {
                a.this.faZ.streamStateReceived(i, z, i2, z2);
            }
            a.this.faW = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.faZ != null) {
                if (z) {
                    a.this.faZ.av(0, null);
                } else {
                    a.this.faZ.av(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.faZ != null && a.this.faZ.bno() != null) {
                a.this.faZ.bno().errCode = 2;
                a.this.faZ.aw(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.faZ != null && a.this.faZ.bno() != null) {
                a.this.faZ.bno().linkTime = alaLiveDebugInfo.connectTime;
                a.this.faZ.bno().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.faZ.bno().startLiveTime == 0) {
                    a.this.faZ.bno().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.qe(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.faJ.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.eVX != null && a.this.eVX.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.eVX.getPreview() != null) {
                        a.this.blI();
                    }
                    a.this.eVX.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.eVX.addRecorderCallback(a.this.fbd);
                    a.this.eVX.stopRecord();
                    if (a.this.eVX.getPreview() != null) {
                        a.this.blJ();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eVX != null) {
                                a.this.eVX.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.eVX.changeVideoRecorderType(com.baidu.live.s.a.wR().asq != null ? com.baidu.live.s.a.wR().asq.XB : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.eVX.addRecorderCallback(a.this.fbd);
                if (a.this.eVX.getPreview() != null) {
                    a.this.blJ();
                }
                i2 = -4;
            }
            if (a.this.faZ != null) {
                a.this.faZ.aw(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.faZ != null) {
                a.this.faZ.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.faZ != null) {
                a.this.faZ.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a fbe = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.o.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                h bnQ = a.this.fay.bnQ();
                a.this.faZ.bno().logID = bnQ.WA;
                a.this.faZ.bno().errCode = 5;
                if (!a.this.a(bnQ)) {
                    if (a.this.faZ != null && a.this.faZ.bno() != null) {
                        a.this.faZ.bno().updateTime = System.currentTimeMillis() - a.this.faZ.bno().updateTime;
                    }
                    if (bnQ.eXa != 1) {
                        if (a.this.faZ != null && a.this.faZ.bno() != null) {
                            a.this.faZ.bno().errSubReason = -1;
                        }
                        a.this.faJ.showToast(bnQ.eXb);
                        a.this.d((short) 1);
                        return;
                    }
                    if (bnQ.mErrorCode != 0) {
                        if (a.this.faZ != null && a.this.faZ.bno() != null) {
                            a.this.faZ.bno().errCode = 5;
                            a.this.faZ.bno().errSubReason = bnQ.mErrorCode;
                        }
                        a.this.faJ.showToast(str);
                        if (bnQ.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.faJ.getActivity());
                        }
                        a.this.d((short) 1);
                    } else {
                        if (a.this.faZ != null && a.this.faZ.bno() != null) {
                            a.this.faZ.bno().errCode = 0;
                            a.this.faZ.bno().errSubReason = 0;
                        }
                        if (a.this.eVX != null) {
                            a.this.eVX.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.s.a.wR().asq.XO);
                            a.this.eVX.setStartInfo(Long.toString(a.this.fay.ww().mLiveInfo.live_id), a.this.fay.ww().mLiveInfo.getSessionID(), com.baidu.live.s.a.wR().asq.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.faZ != null) {
                            a.this.faZ.c(a.this.fay.bnQ());
                        }
                        a.this.blP();
                    }
                    if (a.this.faZ != null && a.this.faZ.bno() != null) {
                        a.this.faZ.bno().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.faZ != null) {
                    a.this.faZ.bmB();
                }
            } else if (i2 == 1) {
                a.this.blQ();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.faZ != null && a.this.faZ.bno() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fdx == 2) {
                            a.this.faZ.bno().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fdx == 3) {
                            a.this.faZ.bno().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.faZ != null && alaGetVerifyStrategyResponseHttpMessage.fdv == 1 && alaGetVerifyStrategyResponseHttpMessage.fdx == 1) {
                            a.this.faZ.bjU();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) && a.this.faZ != null && alaGetVerifyStrategyResponseHttpMessage.fdv == 1 && alaGetVerifyStrategyResponseHttpMessage.fdx == 1 && alaGetVerifyStrategyResponseHttpMessage.fdA == 1) {
                        a.this.faZ.bjU();
                    }
                }
                if (a.this.faZ != null) {
                    a.this.faZ.bmN();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.fdx != 3 ? 0 : 3;
                if (a.this.faY != null && a.this.faZ != null) {
                    a.this.faY.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.faZ.bjW(), a.this.faR).cF(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.faJ = alaMasterLiveRoomActivity;
        this.eNc = new com.baidu.live.tieba.e.b(this.faJ.getActivity());
        blT();
        this.eKy = new com.baidu.tieba.ala.liveroom.o.b();
        MessageManager.getInstance().registerListener(this.fbb);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.w.a.class, this.faJ.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.faY = (com.baidu.live.w.a) runTask.getData();
            if (this.faY != null) {
                this.faY.a(this.fbc);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.o.c cVar) {
        CustomResponsedMessage runTask;
        this.fay = cVar;
        if (this.fay == null) {
            this.fay = new com.baidu.tieba.ala.liveroom.o.c(this.faJ.getPageContext());
        }
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (this.faK == null && (runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.ar.c.class, this.faJ)) != null) {
                this.faK = (com.baidu.live.ar.c) runTask.getData();
            }
            this.faK.a(null);
        }
        this.fay.a(this.fbe);
        if (this.faZ != null) {
            this.faZ.setArModel(this.faK);
            this.faZ.a(this.fay);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.faR = str3;
        this.faT = false;
        jw(false);
        blN();
        if (this.faZ != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.eWY = bundle;
            this.faZ.b(gVar);
            if (this.faZ.bjW() == 1) {
                qc(this.faZ.bjW());
            }
        }
    }

    public void e(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.faV = alaLivePersonData.mLiveInfo.clarity;
        this.faT = true;
        this.faS = alaLivePersonData.mLiveInfo.screen_direction == 2;
        jw(true);
        blN();
        if (this.faZ != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.eWX = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                qc(alaLivePersonData.mLiveInfo.live_type);
            }
            this.faZ.b(gVar);
        }
    }

    private void blG() {
        this.faS = com.baidu.live.c.oJ().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void blH() {
        this.faV = com.baidu.live.c.oJ().getInt("live_recorder_resolution_level", 2);
    }

    private void jw(boolean z) {
        if (!z) {
            blH();
            blG();
        }
        this.faL = (ViewGroup) View.inflate(this.faJ.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.faJ.addContentView(this.faL, new FrameLayout.LayoutParams(-1, -1));
        this.faJ.setContentView(this.faL);
        this.faO = (FrameLayout) this.faL.findViewById(a.g.ala_live_render_view);
        this.faQ = (AlaLiveView) this.faL.findViewById(a.g.ala_liveroom_host_liveview);
        this.faQ.setVisibility(8);
        this.faQ.setSwipeClearEnable(true);
        this.faM = (RelativeLayout) this.faL.findViewById(a.g.ala_live_unremovable_host_top);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.faM.getLayoutParams();
        layoutParams.topMargin = this.faJ.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.faJ.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.faM.requestLayout();
        this.faN = (RelativeLayout) this.faL.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.faN.getLayoutParams();
        layoutParams2.topMargin = this.faJ.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams2.topMargin = this.faJ.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.faN.requestLayout();
        this.faL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.faQ == null || a.this.faQ.isDestroy) {
                    return false;
                }
                return a.this.faQ.z(motionEvent);
            }
        });
        this.faL.findViewById(a.g.ala_live_host_bottom).setVisibility(8);
        this.faL.findViewById(a.g.ala_live_unremovable_bottom).setVisibility(8);
        AlaLiveVideoConfig k = AlaLiveRecordConfigHelper.bjH().k(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.s.a.wR().asq != null && com.baidu.live.s.a.wR().asq.XC) {
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
            if (am.b(com.baidu.live.s.a.wR().atk)) {
                videoBeautyType = VideoBeautyType.DUMIX_AR;
            } else if (am.a(com.baidu.live.s.a.wR().atk)) {
                videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
            } else if (am.c(com.baidu.live.s.a.wR().atk)) {
                videoBeautyType = VideoBeautyType.BEAUTY_TIEBA;
            }
        }
        this.eVX = new AlaLiveRecorder(this.faJ.getPageContext().getPageActivity(), k, VideoRecorderType.CAMERA, videoBeautyType);
        this.eVX.setUserGameHardEncode(com.baidu.live.s.a.wR().asq.XE);
        this.eVX.addRecorderCallback(this.fbd);
        if (!this.faS && this.eVX.getPreview() != null) {
            blJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blI() {
        if (this.eVX != null && this.eVX.getPreview() != null && this.eVX.getPreview().getParent() != null) {
            ((ViewGroup) this.eVX.getPreview().getParent()).removeView(this.eVX.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blJ() {
        this.eVX.getPreview().setEnabled(false);
        blI();
        if (this.faP == null) {
            this.faO.addView(this.eVX.getPreview(), 0, blK());
        } else {
            this.faO.addView(this.eVX.getPreview(), 0, blL());
        }
    }

    private FrameLayout.LayoutParams blK() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams blL() {
        int i = BdUtilHelper.getScreenDimensions(this.faJ.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams blM() {
        int i = BdUtilHelper.getScreenDimensions(this.faJ.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(int i) {
        if (this.faT) {
            this.eVX.setVideoConfig(AlaLiveRecordConfigHelper.bjH().k(this.faV, i, this.faS));
        } else {
            this.eVX.setVideoConfig(AlaLiveRecordConfigHelper.bjH().k(i == 1 ? 0 : this.faV, i, i == 1 ? this.faS : false));
        }
    }

    private void blN() {
        this.faZ = new d(this.faJ.getPageContext(), this.eVX, this.faQ, this.faL, this.eNc, this.faJ.blF());
        this.faZ.a(this.fay);
        this.faZ.setArModel(this.faK);
        this.faZ.a(this.fba);
    }

    public void blO() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.faJ.getPageContext().getPageActivity());
        if (this.eVX != null && this.eVX.getPreview() != null && (this.faP == null || this.faP.getParent() == null)) {
            this.eVX.getPreview().setLayoutParams(blK());
        }
        if (this.faZ != null) {
            this.faZ.E(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.faJ.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.faZ != null) {
            this.faZ.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blP() {
        if (this.fay.ww() != null && this.fay.ww().mLiveInfo != null) {
            if (this.faZ != null && this.faZ.bno() != null) {
                this.faZ.bno().liveID = Long.toString(this.fay.ww().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            this.faU = System.currentTimeMillis() / 1000;
            this.fay.x(this.fay.ww().mLiveInfo.live_id, this.faU);
            this.fay.cU(this.fay.ww().mLiveInfo.live_id);
            com.baidu.live.c.oJ().putLong("last_live_room_id", this.fay.ww().mLiveInfo.live_id);
            this.fay.bnW();
            if (this.faZ != null && this.faZ.bno() != null) {
                if (this.faZ.bjW() == 2) {
                    if (this.faS) {
                        this.faZ.bno().liveType = 5;
                    } else {
                        this.faZ.bno().liveType = 4;
                    }
                } else if (this.faZ.bjW() == 1) {
                    if (this.faS) {
                        this.faZ.bno().liveType = 2;
                    } else {
                        this.faZ.bno().liveType = 1;
                    }
                }
            }
            blU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blQ() {
        final l ww = this.fay.ww();
        if (ww != null && ww.mLiveInfo != null) {
            if (this.faZ == null || !this.faZ.bnl()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fay.x(ww.mLiveInfo.live_id, a.this.faU);
                    }
                }, ww.Wj);
                if (this.faT && ww.mLiveInfo.group_id != 0) {
                    this.fay.ac(String.valueOf(ww.mLiveInfo.getGroupID()), String.valueOf(ww.mLiveInfo.getLastMsgID()), String.valueOf(ww.mLiveInfo.getUserID()));
                    this.faT = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        this.faJ.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.faJ.showToast(hVar.mErrorMsg);
            if (this.faZ != null && this.faZ.bno() != null) {
                this.faZ.bno().errSubReason = 6;
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
        if (eVar != null && !eVar.eWM) {
            boolean z = eVar.eWN;
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
            if (this.faZ != null) {
                if (this.faZ.bno() != null) {
                    this.faZ.bno().updateTime = System.currentTimeMillis();
                }
                this.fay.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.eWO, eVar.eWP ? 1 : 0, this.faZ.bjW(), this.faS ? 2 : 1, this.faV, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void blR() {
        if (this.faZ != null && !this.faZ.bnn() && this.fay.bnQ() == null && this.faZ != null) {
            a(this.faZ.bnp());
        }
    }

    public void onStop() {
        if (this.faZ != null) {
            this.faZ.bnj();
        }
    }

    public void onResume() {
        if (this.eVX != null) {
            this.eVX.setIsAutoStartFromBack(true);
        }
        if (this.faZ != null) {
            this.faZ.bnk();
        }
    }

    public void onPause() {
        if (this.faZ != null) {
            this.faZ.onPause();
        }
    }

    public void onFinish() {
        if (this.faZ != null) {
            this.faZ.g(this.faX);
        }
    }

    public void onDestroy() {
        if (this.eKy != null) {
            this.eKy.release();
            this.eKy = null;
        }
        if (this.faZ != null) {
            this.faZ.onDestroy();
        }
        if (this.faY != null) {
            this.faY.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.eNc.stop();
        this.eNc = null;
        if (this.fay != null) {
            this.fay.destory();
            this.fay = null;
        }
        if (this.faK != null) {
            this.faK.destory();
            this.faK = null;
        }
        if (this.eVX != null) {
            r rVar = new r();
            rVar.WM = this.faS ? 2 : 1;
            rVar.mOpenType = 2;
            if (this.faZ != null) {
                rVar.WL = this.faZ.bjW();
            }
            this.eVX.setRoomInfo(rVar.toJsonString());
            String str = "";
            if (this.faZ != null && this.faZ.bno() != null) {
                if (this.faZ.bno().startLiveTime != 0) {
                    str = Long.toString(this.faZ.bno().startLiveTime);
                }
                this.eVX.setConfigBeforeStop(this.faZ.bno().getCpuMemJsonFormat(), str, "");
            }
            this.eVX.removeRecorderCallback(this.fbd);
            this.eVX.stopRecord();
            this.eVX.release();
            this.eVX = null;
        }
        if (this.faQ != null) {
            this.faQ.setOnTouchListener(null);
            this.faQ.bpt();
            this.faQ = null;
        }
        this.faJ = null;
        MessageManager.getInstance().unRegisterListener(this.fbb);
    }

    public void bN(int i) {
        this.faQ.bN(i);
        qd(i);
    }

    private void qd(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.faJ.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.faJ.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.faL.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.faL.setLayoutParams(layoutParams);
            if (this.faT && this.eVX != null && this.eVX.getPreview() != null && this.eVX.getPreview().getParent() == null) {
                blJ();
            }
        }
        if (this.faZ != null) {
            this.faZ.E(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.faJ.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.faZ != null) {
            this.faZ.onActivityResult(i, i2, intent);
        }
    }

    private int blS() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blT() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.faZ.bno().sampleMemAndCPU();
                    a.this.blT();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blU() {
        if (this.mHandler != null && this.eVX != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.qe(0);
                    a.this.blU();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(int i) {
        if (this.faZ != null && this.faZ.bno() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.eVX.getMediaStatus();
            if (this.fay != null && this.fay.bnQ() != null && this.fay.bnQ().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fay.bnQ().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fay.bnQ().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.eVX.getRecorderDebugInfo();
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
            if (this.faJ != null) {
                alaLiveExceptionInfo.appState = this.faJ.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.faW;
            alaLiveExceptionInfo.sessionChannel = blS();
            alaLiveExceptionInfo.nodeIP = this.eVX.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.faZ.bno().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.faZ.bno().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.faZ.bno().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.faZ != null) {
            return this.faZ.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void d(short s) {
        this.fba.d(s);
    }
}
