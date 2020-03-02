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
    private com.baidu.tieba.ala.liveroom.m.b eOu;
    private com.baidu.live.tieba.e.b eRg;
    private AlaLiveRecorder eZO;
    private c fdL;
    private AlaMasterLiveRoomActivity fdW;
    private com.baidu.live.ar.c fdX;
    private ViewGroup fdY;
    private RelativeLayout fdZ;
    private FrameLayout fea;
    private View feb;
    private AlaLiveView fec;
    private String fed;
    private int feh;
    private short fej;
    private com.baidu.live.z.a fek;
    private d fel;
    private String mForumId;
    private String mForumName;
    private boolean fee = false;
    private Handler mHandler = new Handler();
    private boolean fef = false;
    private long feg = 0;
    private int fei = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fem = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.fee = eVar.faG;
                if (eVar.faC) {
                    a.this.bnz();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qn(int i) {
            if (i == 2) {
                a.this.bns();
                if (a.this.fef) {
                    a.this.qk(2);
                }
                a.this.eZO.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.eZO.addRecorderCallback(a.this.fep);
                a.this.fec.setBackgroundColor(a.this.fdW.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.fee) {
                    a.this.eZO.switchOrientation(a.this.fee);
                    a.this.eZO.addRecorderCallback(a.this.fep);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.fej = s;
            if (a.this.fej == 1) {
                a.this.fdW.bno();
            } else {
                a.this.fdW.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fdL == null || a.this.fdL.yO() == null || a.this.fdL.yO().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fdL.yO().mLiveInfo.room_id;
                    j2 = a.this.fdL.yO().mLiveInfo.live_id;
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
        public void blN() {
            if (a.this.feb != null) {
                if (a.this.feb.getParent() != null) {
                    ((ViewGroup) a.this.feb.getParent()).removeView(a.this.feb);
                }
                a.this.feb = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fea.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.fea.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void awQ() {
            if (a.this.feb == null) {
                a.this.feb = a.this.eZO.createPKPlayer();
            }
            if (a.this.feb != null && a.this.feb.getParent() == null) {
                a.this.fea.addView(a.this.feb, a.this.bnw());
            }
            if (a.this.eZO != null && a.this.eZO.getPreview() != null) {
                FrameLayout.LayoutParams bnv = a.this.bnv();
                if (a.this.eZO.getVideoConfig() != null) {
                    bnv.height = (a.this.eZO.getVideoConfig().getVideoHeight() * bnv.width) / a.this.eZO.getVideoConfig().getVideoWidth();
                }
                a.this.eZO.getPreview().setLayoutParams(bnv);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blO() {
            FrameLayout.LayoutParams bnv = a.this.bnv();
            int aK = g.aK(a.this.fdW.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fea.getLayoutParams();
            layoutParams.height = bnv.height;
            layoutParams.topMargin = aK;
            a.this.fea.setLayoutParams(layoutParams);
            if (a.this.eZO.getVideoConfig() != null) {
                bnv.height = (a.this.eZO.getVideoConfig().getVideoHeight() * bnv.width) / a.this.eZO.getVideoConfig().getVideoWidth();
            }
            a.this.eZO.getPreview().setLayoutParams(bnv);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blP() {
            a.this.bns();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blQ() {
            a.this.bnt();
        }
    };
    private CustomMessageListener fen = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.eZO.stopRecord();
                } else {
                    a.this.eZO.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0108a feo = new a.InterfaceC0108a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback fep = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.fel != null) {
                a.this.fel.boY();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.fel != null) {
                a.this.fel.boY();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.fel != null && a.this.fel.bpa() != null) {
                a.this.fel.bpa().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.fel != null) {
                a.this.fel.streamStateReceived(i, z, i2, z2);
            }
            a.this.fei = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.fel != null) {
                if (z) {
                    a.this.fel.aw(0, null);
                } else {
                    a.this.fel.aw(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.fel != null && a.this.fel.bpa() != null) {
                a.this.fel.bpa().errCode = 2;
                a.this.fel.ax(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.fel != null && a.this.fel.bpa() != null) {
                a.this.fel.bpa().linkTime = alaLiveDebugInfo.connectTime;
                a.this.fel.bpa().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.fel.bpa().startLiveTime == 0) {
                    a.this.fel.bpa().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
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
                a.this.fdW.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.eZO != null && a.this.eZO.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.eZO.getPreview() != null) {
                        a.this.bns();
                    }
                    a.this.eZO.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.eZO.addRecorderCallback(a.this.fep);
                    a.this.eZO.stopRecord();
                    if (a.this.eZO.getPreview() != null) {
                        a.this.bnt();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eZO != null) {
                                a.this.eZO.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.eZO.changeVideoRecorderType(com.baidu.live.v.a.zl().awB != null ? com.baidu.live.v.a.zl().awB.Zs : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.eZO.addRecorderCallback(a.this.fep);
                if (a.this.eZO.getPreview() != null) {
                    a.this.bnt();
                }
                i2 = -4;
            }
            if (a.this.fel != null) {
                a.this.fel.ax(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.fel != null) {
                a.this.fel.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.fel != null) {
                a.this.fel.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a feq = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                h bpE = a.this.fdL.bpE();
                a.this.fel.bpa().logID = bpE.Ym;
                a.this.fel.bpa().errCode = 5;
                if (!a.this.a(bpE)) {
                    if (a.this.fel != null && a.this.fel.bpa() != null) {
                        a.this.fel.bpa().updateTime = System.currentTimeMillis() - a.this.fel.bpa().updateTime;
                    }
                    if (bpE.faS != 1) {
                        if (a.this.fel != null && a.this.fel.bpa() != null) {
                            a.this.fel.bpa().errSubReason = -1;
                        }
                        a.this.fdW.showToast(bpE.faT);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bpE.mErrorCode != 0) {
                        if (a.this.fel != null && a.this.fel.bpa() != null) {
                            a.this.fel.bpa().errCode = 5;
                            a.this.fel.bpa().errSubReason = bpE.mErrorCode;
                        }
                        a.this.fdW.showToast(str);
                        if (bpE.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.fdW.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.fel != null && a.this.fel.bpa() != null) {
                            a.this.fel.bpa().errCode = 0;
                            a.this.fel.bpa().errSubReason = 0;
                        }
                        if (a.this.eZO != null) {
                            a.this.eZO.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.zl().awB.ZF);
                            a.this.eZO.setStartInfo(Long.toString(a.this.fdL.yO().mLiveInfo.live_id), a.this.fdL.yO().mLiveInfo.getSessionID(), com.baidu.live.v.a.zl().awB.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.fel != null) {
                            a.this.fel.c(a.this.fdL.bpE());
                        }
                        a.this.bnz();
                    }
                    if (a.this.fel != null && a.this.fel.bpa() != null) {
                        a.this.fel.bpa().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.fel != null) {
                    a.this.fel.bol();
                }
            } else if (i2 == 1) {
                a.this.bnA();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.fel != null && a.this.fel.bpa() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fgI == 2) {
                            a.this.fel.bpa().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fgI == 3) {
                            a.this.fel.bpa().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fel != null && alaGetVerifyStrategyResponseHttpMessage.fgG == 1 && alaGetVerifyStrategyResponseHttpMessage.fgI == 1) {
                            a.this.fel.blK();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.fel != null && alaGetVerifyStrategyResponseHttpMessage.fgG == 1 && alaGetVerifyStrategyResponseHttpMessage.fgI == 1 && alaGetVerifyStrategyResponseHttpMessage.fgL == 1) {
                        a.this.fel.blK();
                    }
                }
                if (a.this.fel != null) {
                    a.this.fel.box();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.fgI != 3 ? 0 : 3;
                if (a.this.fek != null && a.this.fel != null) {
                    a.this.fek.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.fel.blM(), a.this.fed).cV(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.fdW = alaMasterLiveRoomActivity;
        this.eRg = new com.baidu.live.tieba.e.b(this.fdW.getActivity());
        bnD();
        this.eOu = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.fen);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.z.a.class, this.fdW.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.fek = (com.baidu.live.z.a) runTask.getData();
            if (this.fek != null) {
                this.fek.a(this.feo);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.fdL = cVar;
        if (this.fdL == null) {
            this.fdL = new c(this.fdW.getPageContext());
        }
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (this.fdX == null && (runTask = MessageManager.getInstance().runTask(2913177, com.baidu.live.ar.c.class, this.fdW)) != null) {
                this.fdX = (com.baidu.live.ar.c) runTask.getData();
            }
            if (this.fdX != null) {
                this.fdX.a(null);
            }
        }
        this.fdL.a(this.feq);
        if (this.fel != null) {
            this.fel.setArModel(this.fdX);
            this.fel.a(this.fdL);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.fed = str3;
        this.fef = false;
        jy(false);
        bnx();
        if (this.fel != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.faQ = bundle;
            this.fel.b(gVar);
            if (this.fel.blM() == 1) {
                qk(this.fel.blM());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.feh = alaLivePersonData.mLiveInfo.clarity;
        this.fef = true;
        this.fee = alaLivePersonData.mLiveInfo.screen_direction == 2;
        jy(true);
        bnx();
        if (this.fel != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.faP = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                qk(alaLivePersonData.mLiveInfo.live_type);
            }
            this.fel.b(gVar);
        }
        if (this.fdL != null) {
            this.fdL.h(alaLivePersonData);
        }
    }

    private void bnq() {
        this.fee = com.baidu.live.c.pr().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bnr() {
        this.feh = com.baidu.live.c.pr().getInt("live_recorder_resolution_level", 2);
    }

    private void jy(boolean z) {
        if (!z) {
            bnr();
            bnq();
        }
        this.fdY = (ViewGroup) View.inflate(this.fdW.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.fdW.addContentView(this.fdY, new FrameLayout.LayoutParams(-1, -1));
        this.fdW.setContentView(this.fdY);
        this.fea = (FrameLayout) this.fdY.findViewById(a.g.ala_live_render_view);
        this.fec = (AlaLiveView) this.fdY.findViewById(a.g.ala_liveroom_host_liveview);
        this.fec.setVisibility(8);
        this.fec.setSwipeClearEnable(true);
        this.fdZ = (RelativeLayout) this.fdY.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdZ.getLayoutParams();
        layoutParams.topMargin = this.fdW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fdW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fdZ.requestLayout();
        this.fdY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.fec == null || a.this.fec.isDestroy) {
                    return false;
                }
                return a.this.fec.z(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.zg().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.zl().awB != null && com.baidu.live.v.a.zl().awB.Zt) {
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
            if (an.b(com.baidu.live.v.a.zl().axC)) {
                videoBeautyType = VideoBeautyType.DUMIX_AR;
            } else if (an.a(com.baidu.live.v.a.zl().axC)) {
                videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
            } else if (an.c(com.baidu.live.v.a.zl().axC)) {
                videoBeautyType = VideoBeautyType.BEAUTY_TIEBA;
            }
        }
        this.eZO = new AlaLiveRecorder(this.fdW.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType);
        this.eZO.setUserGameHardEncode(com.baidu.live.v.a.zl().awB.Zv);
        this.eZO.addRecorderCallback(this.fep);
        if (!this.fee && this.eZO.getPreview() != null) {
            bnt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bns() {
        if (this.eZO != null && this.eZO.getPreview() != null && this.eZO.getPreview().getParent() != null) {
            ((ViewGroup) this.eZO.getPreview().getParent()).removeView(this.eZO.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnt() {
        this.eZO.getPreview().setEnabled(false);
        bns();
        if (this.feb == null) {
            this.fea.addView(this.eZO.getPreview(), 0, bnu());
        } else {
            this.fea.addView(this.eZO.getPreview(), 0, bnv());
        }
    }

    private FrameLayout.LayoutParams bnu() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnv() {
        int i = BdUtilHelper.getScreenDimensions(this.fdW.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnw() {
        int i = BdUtilHelper.getScreenDimensions(this.fdW.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk(int i) {
        if (this.fef) {
            this.eZO.setVideoConfig(LiveRecorderConfigHelper.zg().d(this.feh, i, this.fee));
        } else {
            this.eZO.setVideoConfig(LiveRecorderConfigHelper.zg().d(i == 1 ? 0 : this.feh, i, i == 1 ? this.fee : false));
        }
    }

    private void bnx() {
        this.fel = new d(this.fdW, this.eZO, this.fec, this.fea, this.fdY, this.eRg, this.fdW.bnp());
        this.fel.a(this.fdL);
        this.fel.setArModel(this.fdX);
        this.fel.a(this.fem);
    }

    public void bny() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fdW.getPageContext().getPageActivity());
        if (this.eZO != null && this.eZO.getPreview() != null && (this.feb == null || this.feb.getParent() == null)) {
            this.eZO.getPreview().setLayoutParams(bnu());
        }
        if (this.fel != null) {
            this.fel.j(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.fdW.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fel != null) {
            this.fel.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnz() {
        if (this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null) {
            if (this.fel != null && this.fel.bpa() != null) {
                this.fel.bpa().liveID = Long.toString(this.fdL.yO().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            this.feg = System.currentTimeMillis() / 1000;
            this.fdL.x(this.fdL.yO().mLiveInfo.live_id, this.feg);
            this.fdL.cX(this.fdL.yO().mLiveInfo.live_id);
            com.baidu.live.c.pr().putLong("last_live_room_id", this.fdL.yO().mLiveInfo.live_id);
            this.fdL.bpK();
            if (this.fel != null && this.fel.bpa() != null) {
                if (this.fel.blM() == 2) {
                    if (this.fee) {
                        this.fel.bpa().liveType = 5;
                    } else {
                        this.fel.bpa().liveType = 4;
                    }
                } else if (this.fel.blM() == 1) {
                    if (this.fee) {
                        this.fel.bpa().liveType = 2;
                    } else {
                        this.fel.bpa().liveType = 1;
                    }
                }
            }
            bnE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnA() {
        final m yO = this.fdL.yO();
        if (yO != null && yO.mLiveInfo != null) {
            if (this.fel == null || !this.fel.boX()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fdL.x(yO.mLiveInfo.live_id, a.this.feg);
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
        this.fdW.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.fdW.showToast(hVar.mErrorMsg);
            if (this.fel != null && this.fel.bpa() != null) {
                this.fel.bpa().errSubReason = 6;
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
        if (eVar != null && !eVar.faC) {
            boolean z = eVar.faD;
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
            if (this.fel != null) {
                if (this.fel.bpa() != null) {
                    this.fel.bpa().updateTime = System.currentTimeMillis();
                }
                this.fdL.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.faE, eVar.faF ? 1 : 0, this.fel.blM(), this.fee ? 2 : 1, this.feh, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bnB() {
        if (this.fel != null && !this.fel.boZ() && this.fdL.bpE() == null && this.fel != null) {
            a(this.fel.bpb());
        }
    }

    public void onStop() {
        if (this.fel != null) {
            this.fel.boV();
        }
    }

    public void onResume() {
        if (this.eZO != null) {
            this.eZO.setIsAutoStartFromBack(true);
        }
        if (this.fel != null) {
            this.fel.boW();
        }
    }

    public void onPause() {
        if (this.fel != null) {
            this.fel.onPause();
        }
    }

    public void onFinish() {
        if (this.fel != null) {
            this.fel.i(this.fej);
        }
    }

    public void onDestroy() {
        if (this.eOu != null) {
            this.eOu.release();
            this.eOu = null;
        }
        if (this.fel != null) {
            this.fel.onDestroy();
        }
        if (this.fek != null) {
            this.fek.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.eRg.stop();
        this.eRg = null;
        if (this.fdL != null) {
            this.fdL.destory();
            this.fdL = null;
        }
        if (this.fdX != null) {
            this.fdX.destory();
            this.fdX = null;
        }
        if (this.eZO != null) {
            s sVar = new s();
            sVar.Yy = this.fee ? 2 : 1;
            sVar.mOpenType = 2;
            if (this.fel != null) {
                sVar.Yx = this.fel.blM();
            }
            this.eZO.setRoomInfo(sVar.toJsonString());
            String str = "";
            if (this.fel != null && this.fel.bpa() != null) {
                if (this.fel.bpa().startLiveTime != 0) {
                    str = Long.toString(this.fel.bpa().startLiveTime);
                }
                this.eZO.setConfigBeforeStop(this.fel.bpa().getCpuMemJsonFormat(), str, "");
            }
            this.eZO.removeRecorderCallback(this.fep);
            this.eZO.stopRecord();
            this.eZO.release();
            this.eZO = null;
        }
        if (this.fec != null) {
            this.fec.setOnTouchListener(null);
            this.fec.brb();
            this.fec = null;
        }
        this.fdW = null;
        MessageManager.getInstance().unRegisterListener(this.fen);
    }

    public void bW(int i) {
        this.fec.bW(i);
        ql(i);
    }

    private void ql(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fdW.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.fdW.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdY.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.fdY.setLayoutParams(layoutParams);
            if (this.fef && this.eZO != null && this.eZO.getPreview() != null && this.eZO.getPreview().getParent() == null) {
                bnt();
            }
        }
        if (this.fel != null) {
            this.fel.j(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.fdW.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fel != null) {
            this.fel.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fel != null) {
            this.fel.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bnC() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnD() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fel.bpa().sampleMemAndCPU();
                    a.this.bnD();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnE() {
        if (this.mHandler != null && this.eZO != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.qm(0);
                    a.this.bnE();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(int i) {
        if (this.fel != null && this.fel.bpa() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.eZO.getMediaStatus();
            if (this.fdL != null && this.fdL.bpE() != null && this.fdL.bpE().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fdL.bpE().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fdL.bpE().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.eZO.getRecorderDebugInfo();
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
            if (this.fdW != null) {
                alaLiveExceptionInfo.appState = this.fdW.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.fei;
            alaLiveExceptionInfo.sessionChannel = bnC();
            alaLiveExceptionInfo.nodeIP = this.eZO.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.fel.bpa().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.fel.bpa().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.fel.bpa().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fel != null) {
            return this.fel.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.fem.f(s);
    }
}
