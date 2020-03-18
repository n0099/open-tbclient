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
    private com.baidu.tieba.ala.liveroom.m.b ePf;
    private com.baidu.live.tieba.e.b eRR;
    private AlaLiveRecorder faz;
    private AlaMasterLiveRoomActivity feI;
    private c feJ;
    private ViewGroup feK;
    private RelativeLayout feL;
    private FrameLayout feM;
    private View feN;
    private AlaLiveView feO;
    private String feP;
    private int feT;
    private short feV;
    private com.baidu.live.z.a feW;
    private d feX;
    private com.baidu.tieba.ala.liveroom.m.c fex;
    private String mForumId;
    private String mForumName;
    private boolean feQ = false;
    private Handler mHandler = new Handler();
    private boolean feR = false;
    private long feS = 0;
    private int feU = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b feY = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.feQ = eVar.fbr;
                if (eVar.fbn) {
                    a.this.bnF();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qp(int i) {
            if (i == 2) {
                a.this.bny();
                if (a.this.feR) {
                    a.this.qm(2);
                }
                a.this.faz.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.faz.addRecorderCallback(a.this.ffb);
                a.this.feO.setBackgroundColor(a.this.feI.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.feQ) {
                    a.this.faz.switchOrientation(a.this.feQ);
                    a.this.faz.addRecorderCallback(a.this.ffb);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.feV = s;
            if (a.this.feV == 1) {
                a.this.feI.bnu();
            } else {
                a.this.feI.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fex == null || a.this.fex.yT() == null || a.this.fex.yT().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fex.yT().mLiveInfo.room_id;
                    j2 = a.this.fex.yT().mLiveInfo.live_id;
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
        public void blT() {
            if (a.this.feN != null) {
                if (a.this.feN.getParent() != null) {
                    ((ViewGroup) a.this.feN.getParent()).removeView(a.this.feN);
                }
                a.this.feN = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.feM.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.feM.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void awT() {
            if (a.this.feN == null) {
                a.this.feN = a.this.faz.createPKPlayer();
            }
            if (a.this.feN != null && a.this.feN.getParent() == null) {
                a.this.feM.addView(a.this.feN, a.this.bnC());
            }
            if (a.this.faz != null && a.this.faz.getPreview() != null) {
                FrameLayout.LayoutParams bnB = a.this.bnB();
                if (a.this.faz.getVideoConfig() != null) {
                    bnB.height = (a.this.faz.getVideoConfig().getVideoHeight() * bnB.width) / a.this.faz.getVideoConfig().getVideoWidth();
                }
                a.this.faz.getPreview().setLayoutParams(bnB);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blU() {
            FrameLayout.LayoutParams bnB = a.this.bnB();
            int aJ = g.aJ(a.this.feI.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.feM.getLayoutParams();
            layoutParams.height = bnB.height;
            layoutParams.topMargin = aJ;
            a.this.feM.setLayoutParams(layoutParams);
            if (a.this.faz.getVideoConfig() != null) {
                bnB.height = (a.this.faz.getVideoConfig().getVideoHeight() * bnB.width) / a.this.faz.getVideoConfig().getVideoWidth();
            }
            a.this.faz.getPreview().setLayoutParams(bnB);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blV() {
            a.this.bny();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blW() {
            a.this.bnz();
        }
    };
    private CustomMessageListener feZ = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.faz.stopRecord();
                } else {
                    a.this.faz.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0108a ffa = new a.InterfaceC0108a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback ffb = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.feX != null) {
                a.this.feX.bpe();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.feX != null) {
                a.this.feX.bpe();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.feX != null && a.this.feX.bpg() != null) {
                a.this.feX.bpg().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.feX != null) {
                a.this.feX.streamStateReceived(i, z, i2, z2);
            }
            a.this.feU = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.feX != null) {
                if (z) {
                    a.this.feX.aw(0, null);
                } else {
                    a.this.feX.aw(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.feX != null && a.this.feX.bpg() != null) {
                a.this.feX.bpg().errCode = 2;
                a.this.feX.ax(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.feX != null && a.this.feX.bpg() != null) {
                a.this.feX.bpg().linkTime = alaLiveDebugInfo.connectTime;
                a.this.feX.bpg().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.feX.bpg().startLiveTime == 0) {
                    a.this.feX.bpg().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.qo(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.feI.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.faz != null && a.this.faz.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.faz.getPreview() != null) {
                        a.this.bny();
                    }
                    a.this.faz.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.faz.addRecorderCallback(a.this.ffb);
                    a.this.faz.stopRecord();
                    if (a.this.faz.getPreview() != null) {
                        a.this.bnz();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.faz != null) {
                                a.this.faz.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.faz.changeVideoRecorderType(com.baidu.live.v.a.zs().awM != null ? com.baidu.live.v.a.zs().awM.ZC : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.faz.addRecorderCallback(a.this.ffb);
                if (a.this.faz.getPreview() != null) {
                    a.this.bnz();
                }
                i2 = -4;
            }
            if (a.this.feX != null) {
                a.this.feX.ax(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.feX != null) {
                a.this.feX.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.feX != null) {
                a.this.feX.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a ffc = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                h bpK = a.this.fex.bpK();
                a.this.feX.bpg().logID = bpK.Yw;
                a.this.feX.bpg().errCode = 5;
                if (!a.this.a(bpK)) {
                    if (a.this.feX != null && a.this.feX.bpg() != null) {
                        a.this.feX.bpg().updateTime = System.currentTimeMillis() - a.this.feX.bpg().updateTime;
                    }
                    if (bpK.fbD != 1) {
                        if (a.this.feX != null && a.this.feX.bpg() != null) {
                            a.this.feX.bpg().errSubReason = -1;
                        }
                        a.this.feI.showToast(bpK.fbE);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bpK.mErrorCode != 0) {
                        if (a.this.feX != null && a.this.feX.bpg() != null) {
                            a.this.feX.bpg().errCode = 5;
                            a.this.feX.bpg().errSubReason = bpK.mErrorCode;
                        }
                        a.this.feI.showToast(str);
                        if (bpK.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.feI.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.feX != null && a.this.feX.bpg() != null) {
                            a.this.feX.bpg().errCode = 0;
                            a.this.feX.bpg().errSubReason = 0;
                        }
                        if (a.this.faz != null) {
                            a.this.faz.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.zs().awM.ZP);
                            a.this.faz.setStartInfo(Long.toString(a.this.fex.yT().mLiveInfo.live_id), a.this.fex.yT().mLiveInfo.getSessionID(), com.baidu.live.v.a.zs().awM.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.feX != null) {
                            a.this.feX.c(a.this.fex.bpK());
                        }
                        a.this.bnF();
                    }
                    if (a.this.feX != null && a.this.feX.bpg() != null) {
                        a.this.feX.bpg().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.feX != null) {
                    a.this.feX.bor();
                }
            } else if (i2 == 1) {
                a.this.bnG();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.feX != null && a.this.feX.bpg() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fhu == 2) {
                            a.this.feX.bpg().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fhu == 3) {
                            a.this.feX.bpg().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.feX != null && alaGetVerifyStrategyResponseHttpMessage.fhs == 1 && alaGetVerifyStrategyResponseHttpMessage.fhu == 1) {
                            a.this.feX.blQ();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.feX != null && alaGetVerifyStrategyResponseHttpMessage.fhs == 1 && alaGetVerifyStrategyResponseHttpMessage.fhu == 1 && alaGetVerifyStrategyResponseHttpMessage.fhx == 1) {
                        a.this.feX.blQ();
                    }
                }
                if (a.this.feX != null) {
                    a.this.feX.boD();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.fhu != 3 ? 0 : 3;
                if (a.this.feW != null && a.this.feX != null) {
                    a.this.feW.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.feX.blS(), a.this.feP).cV(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.feI = alaMasterLiveRoomActivity;
        this.eRR = new com.baidu.live.tieba.e.b(this.feI.getActivity());
        bnJ();
        this.ePf = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.feZ);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.z.a.class, this.feI.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.feW = (com.baidu.live.z.a) runTask.getData();
            if (this.feW != null) {
                this.feW.a(this.ffa);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        CustomResponsedMessage runTask;
        this.fex = cVar;
        if (this.fex == null) {
            this.fex = new com.baidu.tieba.ala.liveroom.m.c(this.feI.getPageContext());
        }
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (this.feJ == null && (runTask = MessageManager.getInstance().runTask(2913177, com.baidu.live.ar.c.class, this.feI)) != null) {
                this.feJ = (com.baidu.live.ar.c) runTask.getData();
            }
            if (this.feJ != null) {
                this.feJ.a(null);
            }
        }
        this.fex.a(this.ffc);
        if (this.feX != null) {
            this.feX.setArModel(this.feJ);
            this.feX.a(this.fex);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.feP = str3;
        this.feR = false;
        jA(false);
        bnD();
        if (this.feX != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.fbB = bundle;
            this.feX.b(gVar);
            if (this.feX.blS() == 1) {
                qm(this.feX.blS());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.feT = alaLivePersonData.mLiveInfo.clarity;
        this.feR = true;
        this.feQ = alaLivePersonData.mLiveInfo.screen_direction == 2;
        jA(true);
        bnD();
        if (this.feX != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.fbA = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                qm(alaLivePersonData.mLiveInfo.live_type);
            }
            this.feX.b(gVar);
        }
        if (this.fex != null) {
            this.fex.h(alaLivePersonData);
        }
    }

    private void bnw() {
        this.feQ = com.baidu.live.c.pw().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bnx() {
        this.feT = com.baidu.live.c.pw().getInt("live_recorder_resolution_level", 2);
    }

    private void jA(boolean z) {
        if (!z) {
            bnx();
            bnw();
        }
        this.feK = (ViewGroup) View.inflate(this.feI.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.feI.addContentView(this.feK, new FrameLayout.LayoutParams(-1, -1));
        this.feI.setContentView(this.feK);
        this.feM = (FrameLayout) this.feK.findViewById(a.g.ala_live_render_view);
        this.feO = (AlaLiveView) this.feK.findViewById(a.g.ala_liveroom_host_liveview);
        this.feO.setVisibility(8);
        this.feO.setSwipeClearEnable(true);
        this.feL = (RelativeLayout) this.feK.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.feL.getLayoutParams();
        layoutParams.topMargin = this.feI.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.feI.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.feL.requestLayout();
        this.feK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.feO == null || a.this.feO.isDestroy) {
                    return false;
                }
                return a.this.feO.z(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.zn().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.zs().awM != null && com.baidu.live.v.a.zs().awM.ZD) {
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
            if (an.b(com.baidu.live.v.a.zs().axR)) {
                videoBeautyType = VideoBeautyType.DUMIX_AR;
            } else if (an.a(com.baidu.live.v.a.zs().axR)) {
                videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
            } else if (an.c(com.baidu.live.v.a.zs().axR)) {
                videoBeautyType = VideoBeautyType.BEAUTY_TIEBA;
            }
        }
        this.faz = new AlaLiveRecorder(this.feI.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType);
        this.faz.setUserGameHardEncode(com.baidu.live.v.a.zs().awM.ZF);
        this.faz.addRecorderCallback(this.ffb);
        if (!this.feQ && this.faz.getPreview() != null) {
            bnz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bny() {
        if (this.faz != null && this.faz.getPreview() != null && this.faz.getPreview().getParent() != null) {
            ((ViewGroup) this.faz.getPreview().getParent()).removeView(this.faz.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnz() {
        this.faz.getPreview().setEnabled(false);
        bny();
        if (this.feN == null) {
            this.feM.addView(this.faz.getPreview(), 0, bnA());
        } else {
            this.feM.addView(this.faz.getPreview(), 0, bnB());
        }
    }

    private FrameLayout.LayoutParams bnA() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnB() {
        int i = BdUtilHelper.getScreenDimensions(this.feI.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnC() {
        int i = BdUtilHelper.getScreenDimensions(this.feI.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(int i) {
        if (this.feR) {
            this.faz.setVideoConfig(LiveRecorderConfigHelper.zn().d(this.feT, i, this.feQ));
        } else {
            this.faz.setVideoConfig(LiveRecorderConfigHelper.zn().d(i == 1 ? 0 : this.feT, i, i == 1 ? this.feQ : false));
        }
    }

    private void bnD() {
        this.feX = new d(this.feI, this.faz, this.feO, this.feM, this.feK, this.eRR, this.feI.bnv());
        this.feX.a(this.fex);
        this.feX.setArModel(this.feJ);
        this.feX.a(this.feY);
    }

    public void bnE() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.feI.getPageContext().getPageActivity());
        if (this.faz != null && this.faz.getPreview() != null && (this.feN == null || this.feN.getParent() == null)) {
            this.faz.getPreview().setLayoutParams(bnA());
        }
        if (this.feX != null) {
            this.feX.j(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.feI.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.feX != null) {
            this.feX.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnF() {
        if (this.fex.yT() != null && this.fex.yT().mLiveInfo != null) {
            if (this.feX != null && this.feX.bpg() != null) {
                this.feX.bpg().liveID = Long.toString(this.fex.yT().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            this.feS = System.currentTimeMillis() / 1000;
            this.fex.x(this.fex.yT().mLiveInfo.live_id, this.feS);
            this.fex.cX(this.fex.yT().mLiveInfo.live_id);
            com.baidu.live.c.pw().putLong("last_live_room_id", this.fex.yT().mLiveInfo.live_id);
            this.fex.bpQ();
            if (this.feX != null && this.feX.bpg() != null) {
                if (this.feX.blS() == 2) {
                    if (this.feQ) {
                        this.feX.bpg().liveType = 5;
                    } else {
                        this.feX.bpg().liveType = 4;
                    }
                } else if (this.feX.blS() == 1) {
                    if (this.feQ) {
                        this.feX.bpg().liveType = 2;
                    } else {
                        this.feX.bpg().liveType = 1;
                    }
                }
            }
            bnK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnG() {
        final m yT = this.fex.yT();
        if (yT != null && yT.mLiveInfo != null) {
            if (this.feX == null || !this.feX.bpd()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fex.x(yT.mLiveInfo.live_id, a.this.feS);
                    }
                }, yT.Ye);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        this.feI.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.feI.showToast(hVar.mErrorMsg);
            if (this.feX != null && this.feX.bpg() != null) {
                this.feX.bpg().errSubReason = 6;
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
        if (eVar != null && !eVar.fbn) {
            boolean z = eVar.fbo;
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
            if (this.feX != null) {
                if (this.feX.bpg() != null) {
                    this.feX.bpg().updateTime = System.currentTimeMillis();
                }
                this.fex.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.fbp, eVar.fbq ? 1 : 0, this.feX.blS(), this.feQ ? 2 : 1, this.feT, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bnH() {
        if (this.feX != null && !this.feX.bpf() && this.fex.bpK() == null && this.feX != null) {
            a(this.feX.bph());
        }
    }

    public void onStop() {
        if (this.feX != null) {
            this.feX.bpb();
        }
    }

    public void onResume() {
        if (this.faz != null) {
            this.faz.setIsAutoStartFromBack(true);
        }
        if (this.feX != null) {
            this.feX.bpc();
        }
    }

    public void onPause() {
        if (this.feX != null) {
            this.feX.onPause();
        }
    }

    public void onFinish() {
        if (this.feX != null) {
            this.feX.i(this.feV);
        }
    }

    public void onDestroy() {
        if (this.ePf != null) {
            this.ePf.release();
            this.ePf = null;
        }
        if (this.feX != null) {
            this.feX.onDestroy();
        }
        if (this.feW != null) {
            this.feW.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.eRR.stop();
        this.eRR = null;
        if (this.fex != null) {
            this.fex.destory();
            this.fex = null;
        }
        if (this.feJ != null) {
            this.feJ.destory();
            this.feJ = null;
        }
        if (this.faz != null) {
            s sVar = new s();
            sVar.YI = this.feQ ? 2 : 1;
            sVar.mOpenType = 2;
            if (this.feX != null) {
                sVar.YH = this.feX.blS();
            }
            this.faz.setRoomInfo(sVar.toJsonString());
            String str = "";
            if (this.feX != null && this.feX.bpg() != null) {
                if (this.feX.bpg().startLiveTime != 0) {
                    str = Long.toString(this.feX.bpg().startLiveTime);
                }
                this.faz.setConfigBeforeStop(this.feX.bpg().getCpuMemJsonFormat(), str, "");
            }
            this.faz.removeRecorderCallback(this.ffb);
            this.faz.stopRecord();
            this.faz.release();
            this.faz = null;
        }
        if (this.feO != null) {
            this.feO.setOnTouchListener(null);
            this.feO.brh();
            this.feO = null;
        }
        this.feI = null;
        MessageManager.getInstance().unRegisterListener(this.feZ);
    }

    public void bW(int i) {
        this.feO.bW(i);
        qn(i);
    }

    private void qn(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.feI.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.feI.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.feK.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.feK.setLayoutParams(layoutParams);
            if (this.feR && this.faz != null && this.faz.getPreview() != null && this.faz.getPreview().getParent() == null) {
                bnz();
            }
        }
        if (this.feX != null) {
            this.feX.j(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.feI.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.feX != null) {
            this.feX.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.feX != null) {
            this.feX.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bnI() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnJ() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.feX.bpg().sampleMemAndCPU();
                    a.this.bnJ();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnK() {
        if (this.mHandler != null && this.faz != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.qo(0);
                    a.this.bnK();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo(int i) {
        if (this.feX != null && this.feX.bpg() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.faz.getMediaStatus();
            if (this.fex != null && this.fex.bpK() != null && this.fex.bpK().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fex.bpK().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fex.bpK().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.faz.getRecorderDebugInfo();
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
            if (this.feI != null) {
                alaLiveExceptionInfo.appState = this.feI.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.feU;
            alaLiveExceptionInfo.sessionChannel = bnI();
            alaLiveExceptionInfo.nodeIP = this.faz.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.feX.bpg().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.feX.bpg().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.feX.bpg().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.feX != null) {
            return this.feX.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.feY.f(s);
    }
}
