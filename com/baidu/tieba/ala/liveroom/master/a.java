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
import com.baidu.live.data.k;
import com.baidu.live.data.p;
import com.baidu.live.q.a;
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
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.ala.liveroom.m.b eJo;
    private com.baidu.live.tieba.e.b eLQ;
    private c eXZ;
    private AlaMasterLiveRoomActivity eYh;
    private ViewGroup eYi;
    private RelativeLayout eYj;
    private RelativeLayout eYk;
    private FrameLayout eYl;
    private AlaLiveRecorder eYm;
    private View eYn;
    private AlaLiveView eYo;
    private String eYp;
    private int eYt;
    private short eYv;
    private com.baidu.live.u.a eYw;
    private d eYx;
    private String mForumId;
    private String mForumName;
    private boolean eYq = false;
    private Handler mHandler = new Handler();
    private boolean eYr = false;
    private long eYs = 0;
    private int eYu = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b eYy = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.eYq = dVar.eUW;
                if (dVar.eUS) {
                    a.this.bkS();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qa(int i) {
            if (i == 2) {
                a.this.bkL();
                if (a.this.eYr) {
                    a.this.pX(2);
                }
                a.this.eYm.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.eYm.addRecorderCallback(a.this.eYB);
                a.this.eYo.setBackgroundColor(a.this.eYh.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.eYq) {
                    a.this.eYm.switchOrientation(a.this.eYq);
                    a.this.eYm.addRecorderCallback(a.this.eYB);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void d(short s) {
            long j;
            long j2 = -1;
            a.this.eYv = s;
            if (a.this.eYv == 1) {
                a.this.eYh.bkI();
            } else {
                a.this.eYh.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.eXZ == null || a.this.eXZ.wf() == null || a.this.eXZ.wf().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.eXZ.wf().mLiveInfo.room_id;
                    j2 = a.this.eXZ.wf().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bjl() {
            if (a.this.eYn != null) {
                if (a.this.eYn.getParent() != null) {
                    ((ViewGroup) a.this.eYn.getParent()).removeView(a.this.eYn);
                }
                a.this.eYn = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.eYl.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.eYl.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void auh() {
            if (a.this.eYn == null) {
                a.this.eYn = a.this.eYm.createPKPlayer();
            }
            if (a.this.eYn != null && a.this.eYn.getParent() == null) {
                a.this.eYl.addView(a.this.eYn, a.this.bkP());
            }
            if (a.this.eYm != null && a.this.eYm.getPreview() != null) {
                FrameLayout.LayoutParams bkO = a.this.bkO();
                if (a.this.eYm.getVideoConfig() != null) {
                    bkO.height = (a.this.eYm.getVideoConfig().getVideoHeight() * bkO.width) / a.this.eYm.getVideoConfig().getVideoWidth();
                }
                a.this.eYm.getPreview().setLayoutParams(bkO);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bjm() {
            FrameLayout.LayoutParams bkO = a.this.bkO();
            int aG = g.aG(a.this.eYh.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.eYl.getLayoutParams();
            layoutParams.height = bkO.height;
            layoutParams.topMargin = aG;
            a.this.eYl.setLayoutParams(layoutParams);
            if (a.this.eYm.getVideoConfig() != null) {
                bkO.height = (a.this.eYm.getVideoConfig().getVideoHeight() * bkO.width) / a.this.eYm.getVideoConfig().getVideoWidth();
            }
            a.this.eYm.getPreview().setLayoutParams(bkO);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bjn() {
            a.this.bkL();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bjo() {
            a.this.bkM();
        }
    };
    private CustomMessageListener eYz = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.eYm.stopRecord();
                } else {
                    a.this.eYm.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0095a eYA = new a.InterfaceC0095a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback eYB = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.eYx != null) {
                a.this.eYx.bmo();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.eYx != null) {
                a.this.eYx.bmo();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.eYx != null && a.this.eYx.bmq() != null) {
                a.this.eYx.bmq().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.eYx != null) {
                a.this.eYx.streamStateReceived(i, z, i2, z2);
            }
            a.this.eYu = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.eYx != null) {
                if (z) {
                    a.this.eYx.aq(0, null);
                } else {
                    a.this.eYx.aq(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.eYx != null && a.this.eYx.bmq() != null) {
                a.this.eYx.bmq().errCode = 2;
                a.this.eYx.ar(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.eYx != null && a.this.eYx.bmq() != null) {
                a.this.eYx.bmq().linkTime = alaLiveDebugInfo.connectTime;
                a.this.eYx.bmq().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.eYx.bmq().startLiveTime == 0) {
                    a.this.eYx.bmq().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.pZ(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.eYh.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.eYm != null && a.this.eYm.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.eYm.getPreview() != null) {
                        a.this.bkL();
                    }
                    a.this.eYm.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.eYm.addRecorderCallback(a.this.eYB);
                    a.this.eYm.stopRecord();
                    if (a.this.eYm.getPreview() != null) {
                        a.this.bkM();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eYm != null) {
                                a.this.eYm.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.eYm.changeVideoRecorderType(com.baidu.live.r.a.wA().arE != null ? com.baidu.live.r.a.wA().arE.Xi : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.eYm.addRecorderCallback(a.this.eYB);
                if (a.this.eYm.getPreview() != null) {
                    a.this.bkM();
                }
                i2 = -4;
            }
            if (a.this.eYx != null) {
                a.this.eYx.ar(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.eYx != null) {
                a.this.eYx.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.eYx != null) {
                a.this.eYx.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a eYC = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                com.baidu.tieba.ala.liveroom.data.g bmR = a.this.eXZ.bmR();
                a.this.eYx.bmq().logID = bmR.Wj;
                a.this.eYx.bmq().errCode = 5;
                if (!a.this.a(bmR)) {
                    if (a.this.eYx != null && a.this.eYx.bmq() != null) {
                        a.this.eYx.bmq().updateTime = System.currentTimeMillis() - a.this.eYx.bmq().updateTime;
                    }
                    if (bmR.eVf != 1) {
                        if (a.this.eYx != null && a.this.eYx.bmq() != null) {
                            a.this.eYx.bmq().errSubReason = -1;
                        }
                        a.this.eYh.showToast(bmR.eVg);
                        a.this.d((short) 1);
                        return;
                    }
                    if (bmR.mErrorCode != 0) {
                        if (a.this.eYx != null && a.this.eYx.bmq() != null) {
                            a.this.eYx.bmq().errCode = 5;
                            a.this.eYx.bmq().errSubReason = bmR.mErrorCode;
                        }
                        a.this.eYh.showToast(str);
                        if (bmR.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.eYh.getActivity());
                        }
                        a.this.d((short) 1);
                    } else {
                        if (a.this.eYx != null && a.this.eYx.bmq() != null) {
                            a.this.eYx.bmq().errCode = 0;
                            a.this.eYx.bmq().errSubReason = 0;
                        }
                        if (a.this.eYm != null) {
                            a.this.eYm.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.r.a.wA().arE.Xv);
                            a.this.eYm.setStartInfo(Long.toString(a.this.eXZ.wf().mLiveInfo.live_id), a.this.eXZ.wf().mLiveInfo.getSessionID(), com.baidu.live.r.a.wA().arE.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.eYx != null) {
                            a.this.eYx.c(a.this.eXZ.bmR());
                        }
                        a.this.bkS();
                    }
                    if (a.this.eYx != null && a.this.eYx.bmq() != null) {
                        a.this.eYx.bmq().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.eYx != null) {
                    a.this.eYx.blD();
                }
            } else if (i2 == 1) {
                a.this.bkT();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.eYx != null && a.this.eYx.bmq() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.faJ == 2) {
                            a.this.eYx.bmq().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.faJ == 3) {
                            a.this.eYx.bmq().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.eYx != null && alaGetVerifyStrategyResponseHttpMessage.faH == 1 && alaGetVerifyStrategyResponseHttpMessage.faJ == 1) {
                            a.this.eYx.bji();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) && a.this.eYx != null && alaGetVerifyStrategyResponseHttpMessage.faH == 1 && alaGetVerifyStrategyResponseHttpMessage.faJ == 1 && alaGetVerifyStrategyResponseHttpMessage.faM == 1) {
                        a.this.eYx.bji();
                    }
                }
                if (a.this.eYx != null) {
                    a.this.eYx.blP();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.faJ != 3 ? 0 : 3;
                if (a.this.eYw != null && a.this.eYx != null) {
                    a.this.eYw.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.eYx.bjk(), a.this.eYp).cE(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.eYh = alaMasterLiveRoomActivity;
        this.eLQ = new com.baidu.live.tieba.e.b(this.eYh.getActivity());
        bkW();
        this.eJo = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.eYz);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.u.a.class, this.eYh.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.eYw = (com.baidu.live.u.a) runTask.getData();
            if (this.eYw != null) {
                this.eYw.a(this.eYA);
            }
        }
    }

    public void a(c cVar) {
        this.eXZ = cVar;
        if (this.eXZ == null) {
            this.eXZ = new c(this.eYh.getPageContext());
        }
        this.eXZ.a(this.eYC);
        if (this.eYx != null) {
            this.eYx.a(this.eXZ);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.eYp = str3;
        this.eYr = false;
        jl(false);
        bkQ();
        if (this.eYx != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.eVd = bundle;
            this.eYx.b(fVar);
            if (this.eYx.bjk() == 1) {
                pX(this.eYx.bjk());
            }
        }
    }

    public void e(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.eYt = alaLivePersonData.mLiveInfo.clarity;
        this.eYr = true;
        this.eYq = alaLivePersonData.mLiveInfo.screen_direction == 2;
        jl(true);
        bkQ();
        if (this.eYx != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.eVc = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                pX(alaLivePersonData.mLiveInfo.live_type);
            }
            this.eYx.b(fVar);
        }
    }

    private void bkJ() {
        this.eYq = com.baidu.live.c.oI().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bkK() {
        this.eYt = com.baidu.live.c.oI().getInt("live_recorder_resolution_level", 2);
    }

    private void jl(boolean z) {
        if (!z) {
            bkK();
            bkJ();
        }
        this.eYi = (ViewGroup) View.inflate(this.eYh.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.eYh.addContentView(this.eYi, new FrameLayout.LayoutParams(-1, -1));
        this.eYh.setContentView(this.eYi);
        this.eYl = (FrameLayout) this.eYi.findViewById(a.g.ala_live_render_view);
        this.eYo = (AlaLiveView) this.eYi.findViewById(a.g.ala_liveroom_host_liveview);
        this.eYo.setVisibility(8);
        this.eYo.setSwipeClearEnable(true);
        this.eYj = (RelativeLayout) this.eYi.findViewById(a.g.ala_live_unremovable_host_top);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYj.getLayoutParams();
        layoutParams.topMargin = this.eYh.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.eYh.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.eYj.requestLayout();
        this.eYk = (RelativeLayout) this.eYi.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eYk.getLayoutParams();
        layoutParams2.topMargin = this.eYh.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams2.topMargin = this.eYh.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.eYk.requestLayout();
        this.eYi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.eYo == null || a.this.eYo.isDestroy) {
                    return false;
                }
                return a.this.eYo.z(motionEvent);
            }
        });
        this.eYi.findViewById(a.g.ala_live_host_bottom).setVisibility(8);
        this.eYi.findViewById(a.g.ala_live_unremovable_bottom).setVisibility(8);
        AlaLiveVideoConfig k = AlaLiveRecordConfigHelper.biV().k(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.r.a.wA().arE != null && com.baidu.live.r.a.wA().arE.Xj) {
            VideoBeautyType videoBeautyType2 = VideoBeautyType.BEAUTY_FACEUNITY;
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
        this.eYm = new AlaLiveRecorder(this.eYh.getPageContext().getPageActivity(), k, VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_FACEUNITY);
        this.eYm.setUserGameHardEncode(com.baidu.live.r.a.wA().arE.Xl);
        this.eYm.addRecorderCallback(this.eYB);
        if (!this.eYq && this.eYm.getPreview() != null) {
            bkM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkL() {
        if (this.eYm != null && this.eYm.getPreview() != null && this.eYm.getPreview().getParent() != null) {
            ((ViewGroup) this.eYm.getPreview().getParent()).removeView(this.eYm.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkM() {
        this.eYm.getPreview().setEnabled(false);
        bkL();
        if (this.eYn == null) {
            this.eYl.addView(this.eYm.getPreview(), 0, bkN());
        } else {
            this.eYl.addView(this.eYm.getPreview(), 0, bkO());
        }
    }

    private FrameLayout.LayoutParams bkN() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bkO() {
        int i = BdUtilHelper.getScreenDimensions(this.eYh.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bkP() {
        int i = BdUtilHelper.getScreenDimensions(this.eYh.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        if (this.eYr) {
            this.eYm.setVideoConfig(AlaLiveRecordConfigHelper.biV().k(this.eYt, i, this.eYq));
        } else {
            this.eYm.setVideoConfig(AlaLiveRecordConfigHelper.biV().k(i == 1 ? 0 : this.eYt, i, i == 1 ? this.eYq : false));
        }
    }

    private void bkQ() {
        this.eYx = new d(this.eYh.getPageContext(), this.eYm, this.eYo, this.eYi, this.eLQ);
        this.eYx.a(this.eXZ);
        this.eYx.a(this.eYy);
    }

    public void bkR() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.eYh.getPageContext().getPageActivity());
        if (this.eYm != null && this.eYm.getPreview() != null && (this.eYn == null || this.eYn.getParent() == null)) {
            this.eYm.getPreview().setLayoutParams(bkN());
        }
        if (this.eYx != null) {
            this.eYx.E(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.eYh.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eYx != null) {
            this.eYx.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkS() {
        if (this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null) {
            if (this.eYx != null && this.eYx.bmq() != null) {
                this.eYx.bmq().liveID = Long.toString(this.eXZ.wf().mLiveInfo.live_id);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            this.eYs = System.currentTimeMillis() / 1000;
            this.eXZ.x(this.eXZ.wf().mLiveInfo.live_id, this.eYs);
            this.eXZ.cP(this.eXZ.wf().mLiveInfo.live_id);
            com.baidu.live.c.oI().putLong("last_live_room_id", this.eXZ.wf().mLiveInfo.live_id);
            this.eXZ.bmX();
            if (this.eYx != null && this.eYx.bmq() != null) {
                if (this.eYx.bjk() == 2) {
                    if (this.eYq) {
                        this.eYx.bmq().liveType = 5;
                    } else {
                        this.eYx.bmq().liveType = 4;
                    }
                } else if (this.eYx.bjk() == 1) {
                    if (this.eYq) {
                        this.eYx.bmq().liveType = 2;
                    } else {
                        this.eYx.bmq().liveType = 1;
                    }
                }
            }
            bkX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkT() {
        final k wf = this.eXZ.wf();
        if (wf != null && wf.mLiveInfo != null) {
            if (this.eYx == null || !this.eYx.bmn()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eXZ.x(wf.mLiveInfo.live_id, a.this.eYs);
                    }
                }, wf.VT);
                if (this.eYr && wf.mLiveInfo.group_id != 0) {
                    this.eXZ.ab(String.valueOf(wf.mLiveInfo.getGroupID()), String.valueOf(wf.mLiveInfo.getLastMsgID()), String.valueOf(wf.mLiveInfo.getUserID()));
                    this.eYr = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.ala.liveroom.data.g gVar) {
        if (gVar == null) {
            return false;
        }
        this.eYh.closeLoadingDialog();
        if (gVar.mErrorCode == 6) {
            this.eYh.showToast(gVar.mErrorMsg);
            if (this.eYx != null && this.eYx.bmq() != null) {
                this.eYx.bmq().errSubReason = 6;
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
        if (dVar != null && !dVar.eUS) {
            boolean z = dVar.eUT;
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
            if (this.eYx != null) {
                if (this.eYx.bmq() != null) {
                    this.eYx.bmq().updateTime = System.currentTimeMillis();
                }
                this.eXZ.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.eUU, dVar.eUV ? 1 : 0, this.eYx.bjk(), this.eYq ? 2 : 1, this.eYt, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void bkU() {
        if (this.eYx != null && !this.eYx.bmp() && this.eXZ.bmR() == null && this.eYx != null) {
            a(this.eYx.bmr());
        }
    }

    public void onStop() {
        if (this.eYx != null) {
            this.eYx.bml();
        }
    }

    public void onResume() {
        if (this.eYm != null) {
            this.eYm.setIsAutoStartFromBack(true);
        }
        if (this.eYx != null) {
            this.eYx.bmm();
        }
    }

    public void onPause() {
        if (this.eYx != null) {
            this.eYx.onPause();
        }
    }

    public void onFinish() {
        if (this.eYx != null) {
            this.eYx.g(this.eYv);
        }
    }

    public void onDestroy() {
        if (this.eJo != null) {
            this.eJo.release();
            this.eJo = null;
        }
        if (this.eYx != null) {
            this.eYx.onDestroy();
        }
        if (this.eYw != null) {
            this.eYw.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.eLQ.stop();
        this.eLQ = null;
        if (this.eXZ != null) {
            this.eXZ.destory();
            this.eXZ = null;
        }
        if (this.eYm != null) {
            p pVar = new p();
            pVar.Wt = this.eYq ? 2 : 1;
            pVar.mOpenType = 2;
            pVar.Ws = this.eYx.bjk();
            this.eYm.setRoomInfo(pVar.toJsonString());
            String str = "";
            if (this.eYx != null && this.eYx.bmq() != null) {
                if (this.eYx.bmq().startLiveTime != 0) {
                    str = Long.toString(this.eYx.bmq().startLiveTime);
                }
                this.eYm.setConfigBeforeStop(this.eYx.bmq().getCpuMemJsonFormat(), str, "");
            }
            this.eYm.removeRecorderCallback(this.eYB);
            this.eYm.stopRecord();
            this.eYm.release();
            this.eYm = null;
        }
        if (this.eYo != null) {
            this.eYo.setOnTouchListener(null);
            this.eYo.bot();
            this.eYo = null;
        }
        this.eYh = null;
        MessageManager.getInstance().unRegisterListener(this.eYz);
    }

    public void bN(int i) {
        this.eYo.bN(i);
        pY(i);
    }

    private void pY(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.eYh.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.eYh.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eYi.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.eYi.setLayoutParams(layoutParams);
            if (this.eYr && this.eYm != null && this.eYm.getPreview() != null && this.eYm.getPreview().getParent() == null) {
                bkM();
            }
        }
        if (this.eYx != null) {
            this.eYx.E(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.eYh.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eYx != null) {
            this.eYx.onActivityResult(i, i2, intent);
        }
    }

    private int bkV() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkW() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eYx.bmq().sampleMemAndCPU();
                    a.this.bkW();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkX() {
        if (this.mHandler != null && this.eYm != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.pZ(0);
                    a.this.bkX();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(int i) {
        if (this.eYx != null && this.eYx.bmq() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.eYm.getMediaStatus();
            if (this.eXZ != null && this.eXZ.bmR() != null && this.eXZ.bmR().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.eXZ.bmR().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.eXZ.bmR().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.eYm.getRecorderDebugInfo();
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
            if (this.eYh != null) {
                alaLiveExceptionInfo.appState = this.eYh.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.eYu;
            alaLiveExceptionInfo.sessionChannel = bkV();
            alaLiveExceptionInfo.nodeIP = this.eYm.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.eYx.bmq().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.eYx.bmq().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.eYx.bmq().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eYx != null) {
            return this.eYx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void d(short s) {
        this.eYy.d(s);
    }
}
