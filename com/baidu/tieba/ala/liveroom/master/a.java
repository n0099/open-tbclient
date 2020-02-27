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
    private com.baidu.tieba.ala.liveroom.m.b eOt;
    private com.baidu.live.tieba.e.b eRf;
    private AlaLiveRecorder eZN;
    private c fdK;
    private AlaMasterLiveRoomActivity fdV;
    private com.baidu.live.ar.c fdW;
    private ViewGroup fdX;
    private RelativeLayout fdY;
    private FrameLayout fdZ;
    private View fea;
    private AlaLiveView feb;
    private String fec;
    private int feg;
    private short fei;
    private com.baidu.live.z.a fej;
    private d fek;
    private String mForumId;
    private String mForumName;
    private boolean fed = false;
    private Handler mHandler = new Handler();
    private boolean fee = false;
    private long fef = 0;
    private int feh = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fel = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.fed = eVar.faF;
                if (eVar.faB) {
                    a.this.bnx();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qn(int i) {
            if (i == 2) {
                a.this.bnq();
                if (a.this.fee) {
                    a.this.qk(2);
                }
                a.this.eZN.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.eZN.addRecorderCallback(a.this.feo);
                a.this.feb.setBackgroundColor(a.this.fdV.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.fed) {
                    a.this.eZN.switchOrientation(a.this.fed);
                    a.this.eZN.addRecorderCallback(a.this.feo);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.fei = s;
            if (a.this.fei == 1) {
                a.this.fdV.bnm();
            } else {
                a.this.fdV.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fdK == null || a.this.fdK.yN() == null || a.this.fdK.yN().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fdK.yN().mLiveInfo.room_id;
                    j2 = a.this.fdK.yN().mLiveInfo.live_id;
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
        public void blL() {
            if (a.this.fea != null) {
                if (a.this.fea.getParent() != null) {
                    ((ViewGroup) a.this.fea.getParent()).removeView(a.this.fea);
                }
                a.this.fea = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fdZ.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.fdZ.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void awO() {
            if (a.this.fea == null) {
                a.this.fea = a.this.eZN.createPKPlayer();
            }
            if (a.this.fea != null && a.this.fea.getParent() == null) {
                a.this.fdZ.addView(a.this.fea, a.this.bnu());
            }
            if (a.this.eZN != null && a.this.eZN.getPreview() != null) {
                FrameLayout.LayoutParams bnt = a.this.bnt();
                if (a.this.eZN.getVideoConfig() != null) {
                    bnt.height = (a.this.eZN.getVideoConfig().getVideoHeight() * bnt.width) / a.this.eZN.getVideoConfig().getVideoWidth();
                }
                a.this.eZN.getPreview().setLayoutParams(bnt);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blM() {
            FrameLayout.LayoutParams bnt = a.this.bnt();
            int aK = g.aK(a.this.fdV.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fdZ.getLayoutParams();
            layoutParams.height = bnt.height;
            layoutParams.topMargin = aK;
            a.this.fdZ.setLayoutParams(layoutParams);
            if (a.this.eZN.getVideoConfig() != null) {
                bnt.height = (a.this.eZN.getVideoConfig().getVideoHeight() * bnt.width) / a.this.eZN.getVideoConfig().getVideoWidth();
            }
            a.this.eZN.getPreview().setLayoutParams(bnt);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blN() {
            a.this.bnq();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void blO() {
            a.this.bnr();
        }
    };
    private CustomMessageListener fem = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.eZN.stopRecord();
                } else {
                    a.this.eZN.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0108a fen = new a.InterfaceC0108a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback feo = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.fek != null) {
                a.this.fek.boW();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.fek != null) {
                a.this.fek.boW();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.fek != null && a.this.fek.boY() != null) {
                a.this.fek.boY().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.fek != null) {
                a.this.fek.streamStateReceived(i, z, i2, z2);
            }
            a.this.feh = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.fek != null) {
                if (z) {
                    a.this.fek.aw(0, null);
                } else {
                    a.this.fek.aw(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.fek != null && a.this.fek.boY() != null) {
                a.this.fek.boY().errCode = 2;
                a.this.fek.ax(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.fek != null && a.this.fek.boY() != null) {
                a.this.fek.boY().linkTime = alaLiveDebugInfo.connectTime;
                a.this.fek.boY().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.fek.boY().startLiveTime == 0) {
                    a.this.fek.boY().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
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
                a.this.fdV.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.eZN != null && a.this.eZN.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.eZN.getPreview() != null) {
                        a.this.bnq();
                    }
                    a.this.eZN.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.eZN.addRecorderCallback(a.this.feo);
                    a.this.eZN.stopRecord();
                    if (a.this.eZN.getPreview() != null) {
                        a.this.bnr();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eZN != null) {
                                a.this.eZN.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.eZN.changeVideoRecorderType(com.baidu.live.v.a.zj().awA != null ? com.baidu.live.v.a.zj().awA.Zs : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.eZN.addRecorderCallback(a.this.feo);
                if (a.this.eZN.getPreview() != null) {
                    a.this.bnr();
                }
                i2 = -4;
            }
            if (a.this.fek != null) {
                a.this.fek.ax(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.fek != null) {
                a.this.fek.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.fek != null) {
                a.this.fek.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a fep = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                h bpC = a.this.fdK.bpC();
                a.this.fek.boY().logID = bpC.Ym;
                a.this.fek.boY().errCode = 5;
                if (!a.this.a(bpC)) {
                    if (a.this.fek != null && a.this.fek.boY() != null) {
                        a.this.fek.boY().updateTime = System.currentTimeMillis() - a.this.fek.boY().updateTime;
                    }
                    if (bpC.faR != 1) {
                        if (a.this.fek != null && a.this.fek.boY() != null) {
                            a.this.fek.boY().errSubReason = -1;
                        }
                        a.this.fdV.showToast(bpC.faS);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bpC.mErrorCode != 0) {
                        if (a.this.fek != null && a.this.fek.boY() != null) {
                            a.this.fek.boY().errCode = 5;
                            a.this.fek.boY().errSubReason = bpC.mErrorCode;
                        }
                        a.this.fdV.showToast(str);
                        if (bpC.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.fdV.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.fek != null && a.this.fek.boY() != null) {
                            a.this.fek.boY().errCode = 0;
                            a.this.fek.boY().errSubReason = 0;
                        }
                        if (a.this.eZN != null) {
                            a.this.eZN.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.zj().awA.ZF);
                            a.this.eZN.setStartInfo(Long.toString(a.this.fdK.yN().mLiveInfo.live_id), a.this.fdK.yN().mLiveInfo.getSessionID(), com.baidu.live.v.a.zj().awA.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.fek != null) {
                            a.this.fek.c(a.this.fdK.bpC());
                        }
                        a.this.bnx();
                    }
                    if (a.this.fek != null && a.this.fek.boY() != null) {
                        a.this.fek.boY().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.fek != null) {
                    a.this.fek.boj();
                }
            } else if (i2 == 1) {
                a.this.bny();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.fek != null && a.this.fek.boY() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fgH == 2) {
                            a.this.fek.boY().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fgH == 3) {
                            a.this.fek.boY().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fek != null && alaGetVerifyStrategyResponseHttpMessage.fgF == 1 && alaGetVerifyStrategyResponseHttpMessage.fgH == 1) {
                            a.this.fek.blI();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.fek != null && alaGetVerifyStrategyResponseHttpMessage.fgF == 1 && alaGetVerifyStrategyResponseHttpMessage.fgH == 1 && alaGetVerifyStrategyResponseHttpMessage.fgK == 1) {
                        a.this.fek.blI();
                    }
                }
                if (a.this.fek != null) {
                    a.this.fek.bov();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.fgH != 3 ? 0 : 3;
                if (a.this.fej != null && a.this.fek != null) {
                    a.this.fej.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.fek.blK(), a.this.fec).cV(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.fdV = alaMasterLiveRoomActivity;
        this.eRf = new com.baidu.live.tieba.e.b(this.fdV.getActivity());
        bnB();
        this.eOt = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.fem);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.z.a.class, this.fdV.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.fej = (com.baidu.live.z.a) runTask.getData();
            if (this.fej != null) {
                this.fej.a(this.fen);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.fdK = cVar;
        if (this.fdK == null) {
            this.fdK = new c(this.fdV.getPageContext());
        }
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (this.fdW == null && (runTask = MessageManager.getInstance().runTask(2913177, com.baidu.live.ar.c.class, this.fdV)) != null) {
                this.fdW = (com.baidu.live.ar.c) runTask.getData();
            }
            if (this.fdW != null) {
                this.fdW.a(null);
            }
        }
        this.fdK.a(this.fep);
        if (this.fek != null) {
            this.fek.setArModel(this.fdW);
            this.fek.a(this.fdK);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.fec = str3;
        this.fee = false;
        jy(false);
        bnv();
        if (this.fek != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.faP = bundle;
            this.fek.b(gVar);
            if (this.fek.blK() == 1) {
                qk(this.fek.blK());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.feg = alaLivePersonData.mLiveInfo.clarity;
        this.fee = true;
        this.fed = alaLivePersonData.mLiveInfo.screen_direction == 2;
        jy(true);
        bnv();
        if (this.fek != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.faO = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                qk(alaLivePersonData.mLiveInfo.live_type);
            }
            this.fek.b(gVar);
        }
        if (this.fdK != null) {
            this.fdK.h(alaLivePersonData);
        }
    }

    private void bno() {
        this.fed = com.baidu.live.c.pr().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bnp() {
        this.feg = com.baidu.live.c.pr().getInt("live_recorder_resolution_level", 2);
    }

    private void jy(boolean z) {
        if (!z) {
            bnp();
            bno();
        }
        this.fdX = (ViewGroup) View.inflate(this.fdV.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.fdV.addContentView(this.fdX, new FrameLayout.LayoutParams(-1, -1));
        this.fdV.setContentView(this.fdX);
        this.fdZ = (FrameLayout) this.fdX.findViewById(a.g.ala_live_render_view);
        this.feb = (AlaLiveView) this.fdX.findViewById(a.g.ala_liveroom_host_liveview);
        this.feb.setVisibility(8);
        this.feb.setSwipeClearEnable(true);
        this.fdY = (RelativeLayout) this.fdX.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdY.getLayoutParams();
        layoutParams.topMargin = this.fdV.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fdV.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fdY.requestLayout();
        this.fdX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.feb == null || a.this.feb.isDestroy) {
                    return false;
                }
                return a.this.feb.z(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.ze().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.zj().awA != null && com.baidu.live.v.a.zj().awA.Zt) {
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
            if (an.b(com.baidu.live.v.a.zj().axB)) {
                videoBeautyType = VideoBeautyType.DUMIX_AR;
            } else if (an.a(com.baidu.live.v.a.zj().axB)) {
                videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
            } else if (an.c(com.baidu.live.v.a.zj().axB)) {
                videoBeautyType = VideoBeautyType.BEAUTY_TIEBA;
            }
        }
        this.eZN = new AlaLiveRecorder(this.fdV.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType);
        this.eZN.setUserGameHardEncode(com.baidu.live.v.a.zj().awA.Zv);
        this.eZN.addRecorderCallback(this.feo);
        if (!this.fed && this.eZN.getPreview() != null) {
            bnr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnq() {
        if (this.eZN != null && this.eZN.getPreview() != null && this.eZN.getPreview().getParent() != null) {
            ((ViewGroup) this.eZN.getPreview().getParent()).removeView(this.eZN.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnr() {
        this.eZN.getPreview().setEnabled(false);
        bnq();
        if (this.fea == null) {
            this.fdZ.addView(this.eZN.getPreview(), 0, bns());
        } else {
            this.fdZ.addView(this.eZN.getPreview(), 0, bnt());
        }
    }

    private FrameLayout.LayoutParams bns() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnt() {
        int i = BdUtilHelper.getScreenDimensions(this.fdV.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bnu() {
        int i = BdUtilHelper.getScreenDimensions(this.fdV.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk(int i) {
        if (this.fee) {
            this.eZN.setVideoConfig(LiveRecorderConfigHelper.ze().d(this.feg, i, this.fed));
        } else {
            this.eZN.setVideoConfig(LiveRecorderConfigHelper.ze().d(i == 1 ? 0 : this.feg, i, i == 1 ? this.fed : false));
        }
    }

    private void bnv() {
        this.fek = new d(this.fdV, this.eZN, this.feb, this.fdZ, this.fdX, this.eRf, this.fdV.bnn());
        this.fek.a(this.fdK);
        this.fek.setArModel(this.fdW);
        this.fek.a(this.fel);
    }

    public void bnw() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fdV.getPageContext().getPageActivity());
        if (this.eZN != null && this.eZN.getPreview() != null && (this.fea == null || this.fea.getParent() == null)) {
            this.eZN.getPreview().setLayoutParams(bns());
        }
        if (this.fek != null) {
            this.fek.j(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.fdV.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fek != null) {
            this.fek.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnx() {
        if (this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null) {
            if (this.fek != null && this.fek.boY() != null) {
                this.fek.boY().liveID = Long.toString(this.fdK.yN().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            this.fef = System.currentTimeMillis() / 1000;
            this.fdK.x(this.fdK.yN().mLiveInfo.live_id, this.fef);
            this.fdK.cX(this.fdK.yN().mLiveInfo.live_id);
            com.baidu.live.c.pr().putLong("last_live_room_id", this.fdK.yN().mLiveInfo.live_id);
            this.fdK.bpI();
            if (this.fek != null && this.fek.boY() != null) {
                if (this.fek.blK() == 2) {
                    if (this.fed) {
                        this.fek.boY().liveType = 5;
                    } else {
                        this.fek.boY().liveType = 4;
                    }
                } else if (this.fek.blK() == 1) {
                    if (this.fed) {
                        this.fek.boY().liveType = 2;
                    } else {
                        this.fek.boY().liveType = 1;
                    }
                }
            }
            bnC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bny() {
        final m yN = this.fdK.yN();
        if (yN != null && yN.mLiveInfo != null) {
            if (this.fek == null || !this.fek.boV()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fdK.x(yN.mLiveInfo.live_id, a.this.fef);
                    }
                }, yN.XU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        this.fdV.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.fdV.showToast(hVar.mErrorMsg);
            if (this.fek != null && this.fek.boY() != null) {
                this.fek.boY().errSubReason = 6;
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
        if (eVar != null && !eVar.faB) {
            boolean z = eVar.faC;
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
            if (this.fek != null) {
                if (this.fek.boY() != null) {
                    this.fek.boY().updateTime = System.currentTimeMillis();
                }
                this.fdK.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.faD, eVar.faE ? 1 : 0, this.fek.blK(), this.fed ? 2 : 1, this.feg, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bnz() {
        if (this.fek != null && !this.fek.boX() && this.fdK.bpC() == null && this.fek != null) {
            a(this.fek.boZ());
        }
    }

    public void onStop() {
        if (this.fek != null) {
            this.fek.boT();
        }
    }

    public void onResume() {
        if (this.eZN != null) {
            this.eZN.setIsAutoStartFromBack(true);
        }
        if (this.fek != null) {
            this.fek.boU();
        }
    }

    public void onPause() {
        if (this.fek != null) {
            this.fek.onPause();
        }
    }

    public void onFinish() {
        if (this.fek != null) {
            this.fek.i(this.fei);
        }
    }

    public void onDestroy() {
        if (this.eOt != null) {
            this.eOt.release();
            this.eOt = null;
        }
        if (this.fek != null) {
            this.fek.onDestroy();
        }
        if (this.fej != null) {
            this.fej.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.eRf.stop();
        this.eRf = null;
        if (this.fdK != null) {
            this.fdK.destory();
            this.fdK = null;
        }
        if (this.fdW != null) {
            this.fdW.destory();
            this.fdW = null;
        }
        if (this.eZN != null) {
            s sVar = new s();
            sVar.Yy = this.fed ? 2 : 1;
            sVar.mOpenType = 2;
            if (this.fek != null) {
                sVar.Yx = this.fek.blK();
            }
            this.eZN.setRoomInfo(sVar.toJsonString());
            String str = "";
            if (this.fek != null && this.fek.boY() != null) {
                if (this.fek.boY().startLiveTime != 0) {
                    str = Long.toString(this.fek.boY().startLiveTime);
                }
                this.eZN.setConfigBeforeStop(this.fek.boY().getCpuMemJsonFormat(), str, "");
            }
            this.eZN.removeRecorderCallback(this.feo);
            this.eZN.stopRecord();
            this.eZN.release();
            this.eZN = null;
        }
        if (this.feb != null) {
            this.feb.setOnTouchListener(null);
            this.feb.bqZ();
            this.feb = null;
        }
        this.fdV = null;
        MessageManager.getInstance().unRegisterListener(this.fem);
    }

    public void bW(int i) {
        this.feb.bW(i);
        ql(i);
    }

    private void ql(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fdV.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.fdV.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdX.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.fdX.setLayoutParams(layoutParams);
            if (this.fee && this.eZN != null && this.eZN.getPreview() != null && this.eZN.getPreview().getParent() == null) {
                bnr();
            }
        }
        if (this.fek != null) {
            this.fek.j(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.fdV.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fek != null) {
            this.fek.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fek != null) {
            this.fek.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bnA() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnB() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fek.boY().sampleMemAndCPU();
                    a.this.bnB();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnC() {
        if (this.mHandler != null && this.eZN != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.qm(0);
                    a.this.bnC();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(int i) {
        if (this.fek != null && this.fek.boY() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.eZN.getMediaStatus();
            if (this.fdK != null && this.fdK.bpC() != null && this.fdK.bpC().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fdK.bpC().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fdK.bpC().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.eZN.getRecorderDebugInfo();
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
            if (this.fdV != null) {
                alaLiveExceptionInfo.appState = this.fdV.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.feh;
            alaLiveExceptionInfo.sessionChannel = bnA();
            alaLiveExceptionInfo.nodeIP = this.eZN.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.fek.boY().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.fek.boY().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.fek.boY().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fek != null) {
            return this.fek.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.fel.f(s);
    }
}
