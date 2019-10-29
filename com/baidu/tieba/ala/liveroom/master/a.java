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
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.ala.liveRecorder.AlaLiveRecorderConfig;
import com.baidu.ala.liveRecorder.RecorderCallback;
import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
import com.baidu.ala.liveRecorder.video.VideoBeautyType;
import com.baidu.ala.liveRecorder.video.VideoRecorderType;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.i;
import com.baidu.live.data.n;
import com.baidu.live.k.a;
import com.baidu.live.o.a;
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
import com.baidu.live.utils.f;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.ala.liveroom.m.b dUA;
    private com.baidu.live.tieba.e.b dXa;
    private c eiF;
    private AlaMasterLiveRoomActivity eiN;
    private ViewGroup eiO;
    private RelativeLayout eiP;
    private RelativeLayout eiQ;
    private FrameLayout eiR;
    private AlaLiveRecorder eiS;
    private View eiT;
    private AlaLiveView eiU;
    private String eiV;
    private int eiZ;
    private short ejb;
    private com.baidu.live.o.a ejc;
    private d ejd;
    private String mForumId;
    private String mForumName;
    private boolean eiW = false;
    private Handler mHandler = new Handler();
    private boolean eiX = false;
    private long eiY = 0;
    private int eja = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b eje = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.eiW = dVar.efT;
                if (dVar.efP) {
                    a.this.aTh();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void nK(int i) {
            if (i == 2) {
                a.this.aTa();
                if (a.this.eiX) {
                    a.this.nH(2);
                }
                a.this.eiS.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.eiS.addRecorderCallback(a.this.ejh);
                a.this.eiU.setBackgroundColor(a.this.eiN.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.eiW) {
                    a.this.eiS.switchOrientation(a.this.eiW);
                    a.this.eiS.addRecorderCallback(a.this.ejh);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void d(short s) {
            long j;
            long j2 = -1;
            a.this.ejb = s;
            if (a.this.ejb == 1) {
                a.this.eiN.aSX();
            } else {
                a.this.eiN.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.eiF == null || a.this.eiF.uj() == null || a.this.eiF.uj().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.eiF.uj().mLiveInfo.room_id;
                    j2 = a.this.eiF.uj().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRM() {
            if (a.this.eiT != null) {
                if (a.this.eiT.getParent() != null) {
                    ((ViewGroup) a.this.eiT.getParent()).removeView(a.this.eiT);
                }
                a.this.eiT = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.eiR.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.eiR.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRN() {
            if (a.this.eiT == null) {
                a.this.eiT = a.this.eiS.createPKPlayer();
            }
            if (a.this.eiT != null && a.this.eiT.getParent() == null) {
                a.this.eiR.addView(a.this.eiT, a.this.aTe());
            }
            if (a.this.eiS != null && a.this.eiS.getPreview() != null) {
                FrameLayout.LayoutParams aTd = a.this.aTd();
                if (a.this.eiS.getVideoConfig() != null) {
                    aTd.height = (a.this.eiS.getVideoConfig().getVideoHeight() * aTd.width) / a.this.eiS.getVideoConfig().getVideoWidth();
                }
                a.this.eiS.getPreview().setLayoutParams(aTd);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRO() {
            FrameLayout.LayoutParams aTd = a.this.aTd();
            int au = f.au(a.this.eiN.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.eiR.getLayoutParams();
            layoutParams.height = aTd.height;
            layoutParams.topMargin = au;
            a.this.eiR.setLayoutParams(layoutParams);
            if (a.this.eiS.getVideoConfig() != null) {
                aTd.height = (a.this.eiS.getVideoConfig().getVideoHeight() * aTd.width) / a.this.eiS.getVideoConfig().getVideoWidth();
            }
            a.this.eiS.getPreview().setLayoutParams(aTd);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRP() {
            a.this.aTa();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRQ() {
            a.this.aTb();
        }
    };
    private CustomMessageListener ejf = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.eiS.stopRecord();
                } else {
                    a.this.eiS.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0071a ejg = new a.InterfaceC0071a() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
    };
    private RecorderCallback ejh = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.ejd != null) {
                a.this.ejd.aUz();
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.ejd != null) {
                a.this.ejd.aUz();
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.ejd != null && a.this.ejd.aUB() != null) {
                a.this.ejd.aUB().lostRate = d;
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.ejd != null) {
                a.this.ejd.streamStateReceived(i, z, i2, z2);
            }
            a.this.eja = i2;
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.ejd != null) {
                if (z) {
                    a.this.ejd.ac(0, null);
                } else {
                    a.this.ejd.ac(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.ejd != null && a.this.ejd.aUB() != null) {
                a.this.ejd.aUB().errCode = 2;
                a.this.ejd.ad(-5, null);
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.ejd != null && a.this.ejd.aUB() != null) {
                a.this.ejd.aUB().linkTime = alaLiveDebugInfo.connectTime;
                a.this.ejd.aUB().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.ejd.aUB().startLiveTime == 0) {
                    a.this.ejd.aUB().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.nJ(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.eiN.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.eiS != null && a.this.eiS.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.eiS.getPreview() != null) {
                        a.this.aTa();
                    }
                    a.this.eiS.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.eiS.addRecorderCallback(a.this.ejh);
                    a.this.eiS.stopRecord();
                    if (a.this.eiS.getPreview() != null) {
                        a.this.aTb();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eiS != null) {
                                a.this.eiS.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.eiS.changeVideoRecorderType(com.baidu.live.l.a.uA().ajX != null ? com.baidu.live.l.a.uA().ajX.QU : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.eiS.addRecorderCallback(a.this.ejh);
                if (a.this.eiS.getPreview() != null) {
                    a.this.aTb();
                }
                i2 = -4;
            }
            if (a.this.ejd != null) {
                a.this.ejd.ad(i2, str);
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.ejd != null) {
                a.this.ejd.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.ejd != null) {
                a.this.ejd.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a eji = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.8
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                g aVb = a.this.eiF.aVb();
                a.this.ejd.aUB().logID = aVb.PT;
                a.this.ejd.aUB().errCode = 5;
                if (!a.this.a(aVb)) {
                    if (a.this.ejd != null && a.this.ejd.aUB() != null) {
                        a.this.ejd.aUB().updateTime = System.currentTimeMillis() - a.this.ejd.aUB().updateTime;
                    }
                    if (aVb.egc != 1) {
                        if (a.this.ejd != null && a.this.ejd.aUB() != null) {
                            a.this.ejd.aUB().errSubReason = -1;
                        }
                        a.this.eiN.showToast(aVb.egd);
                        a.this.d((short) 1);
                        return;
                    }
                    if (aVb.mErrorCode != 0) {
                        if (a.this.ejd != null && a.this.ejd.aUB() != null) {
                            a.this.ejd.aUB().errCode = 5;
                            a.this.ejd.aUB().errSubReason = aVb.mErrorCode;
                        }
                        a.this.eiN.showToast(str);
                        if (aVb.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.eiN.getActivity());
                        }
                        a.this.d((short) 1);
                    } else {
                        if (a.this.ejd != null && a.this.ejd.aUB() != null) {
                            a.this.ejd.aUB().errCode = 0;
                            a.this.ejd.aUB().errSubReason = 0;
                        }
                        if (a.this.eiS != null) {
                            a.this.eiS.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.l.a.uA().ajX.Rh);
                            a.this.eiS.setStartInfo(Long.toString(a.this.eiF.uj().mLiveInfo.live_id), a.this.eiF.uj().mLiveInfo.getSessionID(), com.baidu.live.l.a.uA().ajX.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.ejd != null) {
                            a.this.ejd.c(a.this.eiF.aVb());
                        }
                        a.this.aTh();
                    }
                    if (a.this.ejd != null && a.this.ejd.aUB() != null) {
                        a.this.ejd.aUB().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.ejd != null) {
                    a.this.ejd.aTO();
                }
            } else if (i2 == 1) {
                a.this.aTi();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.ejd != null && a.this.ejd.aUB() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.ell == 2) {
                            a.this.ejd.aUB().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.ell == 3) {
                            a.this.ejd.aUB().errSubReason = -3;
                        }
                    }
                    if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && a.this.ejd != null && alaGetVerifyStrategyResponseHttpMessage.elj == 1 && alaGetVerifyStrategyResponseHttpMessage.ell == 1) {
                        a.this.ejd.aRJ();
                    }
                }
                if (a.this.ejd != null) {
                    a.this.ejd.aUa();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.ell != 3 ? 0 : 3;
                if (a.this.ejc != null && a.this.ejd != null) {
                    a.this.ejc.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.ejd.aRL(), a.this.eiV).cm(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.eiN = alaMasterLiveRoomActivity;
        this.dXa = new com.baidu.live.tieba.e.b(this.eiN.getActivity());
        aTl();
        this.dUA = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.ejf);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.o.a.class, this.eiN.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.ejc = (com.baidu.live.o.a) runTask.getData();
            if (this.ejc != null) {
                this.ejc.a(this.ejg);
            }
        }
    }

    public void a(c cVar) {
        this.eiF = cVar;
        if (this.eiF == null) {
            this.eiF = new c(this.eiN.getPageContext());
        }
        this.eiF.a(this.eji);
        if (this.ejd != null) {
            this.ejd.a(this.eiF);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.eiV = str3;
        this.eiX = false;
        hV(false);
        aTf();
        if (this.ejd != null) {
            com.baidu.tieba.ala.liveroom.data.f fVar = new com.baidu.tieba.ala.liveroom.data.f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.ega = bundle;
            this.ejd.b(fVar);
            if (this.ejd.aRL() == 1) {
                nH(this.ejd.aRL());
            }
        }
    }

    public void d(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.eiZ = alaLivePersonData.mLiveInfo.clarity;
        this.eiX = true;
        this.eiW = alaLivePersonData.mLiveInfo.screen_direction == 2;
        hV(true);
        aTf();
        if (this.ejd != null) {
            com.baidu.tieba.ala.liveroom.data.f fVar = new com.baidu.tieba.ala.liveroom.data.f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.efZ = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                nH(alaLivePersonData.mLiveInfo.live_type);
            }
            this.ejd.b(fVar);
        }
    }

    private void aSY() {
        this.eiW = com.baidu.live.c.np().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void aSZ() {
        this.eiZ = com.baidu.live.c.np().getInt("live_recorder_resolution_level", 2);
    }

    private void hV(boolean z) {
        if (!z) {
            aSZ();
            aSY();
        }
        this.eiO = (ViewGroup) View.inflate(this.eiN.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.eiN.addContentView(this.eiO, new FrameLayout.LayoutParams(-1, -1));
        this.eiN.setContentView(this.eiO);
        this.eiR = (FrameLayout) this.eiO.findViewById(a.g.ala_live_render_view);
        this.eiU = (AlaLiveView) this.eiO.findViewById(a.g.ala_liveroom_host_liveview);
        this.eiU.setVisibility(8);
        this.eiU.setSwipeClearEnable(true);
        this.eiP = (RelativeLayout) this.eiO.findViewById(a.g.ala_live_unremovable_host_top);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eiP.getLayoutParams();
        layoutParams.topMargin = this.eiN.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.eiN.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.eiP.requestLayout();
        this.eiQ = (RelativeLayout) this.eiO.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eiQ.getLayoutParams();
        layoutParams2.topMargin = this.eiN.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams2.topMargin = this.eiN.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.eiQ.requestLayout();
        this.eiO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.eiU == null || a.this.eiU.eru) {
                    return false;
                }
                return a.this.eiU.z(motionEvent);
            }
        });
        this.eiO.findViewById(a.g.ala_live_host_bottom).setVisibility(8);
        this.eiO.findViewById(a.g.ala_live_unremovable_bottom).setVisibility(8);
        AlaLiveVideoConfig i = AlaLiveRecordConfigHelper.aRw().i(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.l.a.uA().ajX != null && com.baidu.live.l.a.uA().ajX.QV) {
            VideoBeautyType videoBeautyType2 = VideoBeautyType.BEAUTY_FACEUNITY;
        }
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && LoadLibraryManager.getInstance().getLoadLibraryCallback() != null) {
            AlaLiveRecorderConfig.setILoadLibraryCallback(new AlaLiveRecorderConfig.ILoadLibrary() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
                @Override // com.baidu.ala.liveRecorder.AlaLiveRecorderConfig.ILoadLibrary
                public boolean loadlibrary(String str) {
                    return LoadLibraryManager.getInstance().getLoadLibraryCallback().loadLibrary(str);
                }
            });
        }
        this.eiS = new AlaLiveRecorder(this.eiN.getPageContext().getPageActivity(), i, VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_FACEUNITY);
        this.eiS.setUserGameHardEncode(com.baidu.live.l.a.uA().ajX.QX);
        this.eiS.addRecorderCallback(this.ejh);
        if (!this.eiW && this.eiS.getPreview() != null) {
            aTb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTa() {
        if (this.eiS != null && this.eiS.getPreview() != null && this.eiS.getPreview().getParent() != null) {
            ((ViewGroup) this.eiS.getPreview().getParent()).removeView(this.eiS.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTb() {
        this.eiS.getPreview().setEnabled(false);
        aTa();
        if (this.eiT == null) {
            this.eiR.addView(this.eiS.getPreview(), 0, aTc());
        } else {
            this.eiR.addView(this.eiS.getPreview(), 0, aTd());
        }
    }

    private FrameLayout.LayoutParams aTc() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams aTd() {
        int i = BdUtilHelper.getScreenDimensions(this.eiN.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams aTe() {
        int i = BdUtilHelper.getScreenDimensions(this.eiN.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(int i) {
        if (this.eiX) {
            this.eiS.setVideoConfig(AlaLiveRecordConfigHelper.aRw().i(this.eiZ, i, this.eiW));
        } else {
            this.eiS.setVideoConfig(AlaLiveRecordConfigHelper.aRw().i(i == 1 ? 0 : this.eiZ, i, i == 1 ? this.eiW : false));
        }
    }

    private void aTf() {
        this.ejd = new d(this.eiN.getPageContext(), this.eiS, this.eiU, this.eiO, this.dXa);
        this.ejd.a(this.eiF);
        this.ejd.a(this.eje);
    }

    public void aTg() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.eiN.getPageContext().getPageActivity());
        if (this.eiS != null && this.eiS.getPreview() != null && (this.eiT == null || this.eiT.getParent() == null)) {
            this.eiS.getPreview().setLayoutParams(aTc());
        }
        if (this.ejd != null) {
            this.ejd.E(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.eiN.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ejd != null) {
            this.ejd.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        if (this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null) {
            if (this.ejd != null && this.ejd.aUB() != null) {
                this.ejd.aUB().liveID = Long.toString(this.eiF.uj().mLiveInfo.live_id);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            this.eiY = System.currentTimeMillis() / 1000;
            this.eiF.s(this.eiF.uj().mLiveInfo.live_id, this.eiY);
            this.eiF.ck(this.eiF.uj().mLiveInfo.live_id);
            com.baidu.live.c.np().putLong("last_live_room_id", this.eiF.uj().mLiveInfo.live_id);
            this.eiF.aVh();
            if (this.ejd != null && this.ejd.aUB() != null) {
                if (this.ejd.aRL() == 2) {
                    if (this.eiW) {
                        this.ejd.aUB().liveType = 5;
                    } else {
                        this.ejd.aUB().liveType = 4;
                    }
                } else if (this.ejd.aRL() == 1) {
                    if (this.eiW) {
                        this.ejd.aUB().liveType = 2;
                    } else {
                        this.ejd.aUB().liveType = 1;
                    }
                }
            }
            aTm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTi() {
        final i uj = this.eiF.uj();
        if (uj != null && uj.mLiveInfo != null) {
            if (this.ejd == null || !this.ejd.aUy()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eiF.s(uj.mLiveInfo.live_id, a.this.eiY);
                    }
                }, uj.Pw);
                if (this.eiX && uj.mLiveInfo.group_id != 0) {
                    this.eiF.Q(String.valueOf(uj.mLiveInfo.getGroupID()), String.valueOf(uj.mLiveInfo.getLastMsgID()), String.valueOf(uj.mLiveInfo.getUserID()));
                    this.eiX = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        this.eiN.closeLoadingDialog();
        if (gVar.mErrorCode == 6) {
            this.eiN.showToast(gVar.mErrorMsg);
            if (this.ejd != null && this.ejd.aUB() != null) {
                this.ejd.aUB().errSubReason = 6;
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
        if (dVar != null && !dVar.efP) {
            boolean z = dVar.efQ;
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
            if (this.ejd != null) {
                if (this.ejd.aUB() != null) {
                    this.ejd.aUB().updateTime = System.currentTimeMillis();
                }
                this.eiF.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.efR, dVar.efS ? 1 : 0, this.ejd.aRL(), this.eiW ? 2 : 1, this.eiZ, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void aTj() {
        if (this.ejd != null && !this.ejd.aUA() && this.eiF.aVb() == null && this.ejd != null) {
            a(this.ejd.aUC());
        }
    }

    public void onStop() {
        if (this.ejd != null) {
            this.ejd.aUw();
        }
    }

    public void onResume() {
        if (this.eiS != null) {
            this.eiS.setIsAutoStartFromBack(true);
        }
        if (this.ejd != null) {
            this.ejd.aUx();
        }
    }

    public void onPause() {
        if (this.ejd != null) {
            this.ejd.onPause();
        }
    }

    public void onFinish() {
        if (this.ejd != null) {
            this.ejd.g(this.ejb);
        }
    }

    public void onDestroy() {
        if (this.dUA != null) {
            this.dUA.release();
            this.dUA = null;
        }
        if (this.ejd != null) {
            this.ejd.onDestroy();
        }
        if (this.ejc != null) {
            this.ejc.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.dXa.stop();
        this.dXa = null;
        if (this.eiF != null) {
            this.eiF.destory();
            this.eiF = null;
        }
        if (this.eiS != null) {
            n nVar = new n();
            nVar.Qd = this.eiW ? 2 : 1;
            nVar.mOpenType = 2;
            nVar.Qc = this.ejd.aRL();
            this.eiS.setRoomInfo(nVar.toJsonString());
            String str = "";
            if (this.ejd != null && this.ejd.aUB() != null) {
                if (this.ejd.aUB().startLiveTime != 0) {
                    str = Long.toString(this.ejd.aUB().startLiveTime);
                }
                this.eiS.setConfigBeforeStop(this.ejd.aUB().getCpuMemJsonFormat(), str, "");
            }
            this.eiS.removeRecorderCallback(this.ejh);
            this.eiS.stopRecord();
            this.eiS.release();
            this.eiS = null;
        }
        if (this.eiU != null) {
            this.eiU.setOnTouchListener(null);
            this.eiU.aWH();
            this.eiU = null;
        }
        this.eiN = null;
        MessageManager.getInstance().unRegisterListener(this.ejf);
    }

    public void bw(int i) {
        this.eiU.bw(i);
        nI(i);
    }

    private void nI(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.eiN.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.eiN.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eiO.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.eiO.setLayoutParams(layoutParams);
            if (this.eiX && this.eiS != null && this.eiS.getPreview() != null && this.eiS.getPreview().getParent() == null) {
                aTb();
            }
        }
        if (this.ejd != null) {
            this.ejd.E(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.eiN.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ejd != null) {
            this.ejd.onActivityResult(i, i2, intent);
        }
    }

    private int aTk() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTl() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ejd.aUB().sampleMemAndCPU();
                    a.this.aTl();
                }
            }, ReportUserInfoModel.TIME_INTERVAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTm() {
        if (this.mHandler != null && this.eiS != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nJ(0);
                    a.this.aTm();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(int i) {
        if (this.ejd != null && this.ejd.aUB() != null) {
            com.baidu.live.message.c cVar = new com.baidu.live.message.c();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.eiS.getMediaStatus();
            if (this.eiF != null && this.eiF.aVb() != null && this.eiF.aVb().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.eiF.aVb().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.eiF.aVb().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.eiS.getRecorderDebugInfo();
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
            }
            if (i != 0) {
                alaLiveExceptionInfo.dropFrame = i;
            }
            if (this.eiN != null) {
                alaLiveExceptionInfo.appState = this.eiN.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.eja;
            alaLiveExceptionInfo.sessionChannel = aTk();
            alaLiveExceptionInfo.nodeIP = this.eiS.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.ejd.aUB().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.ejd.aUB().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            cVar.a(alaLiveExceptionInfo);
            this.ejd.aUB().reset();
            MessageManager.getInstance().sendMessage(cVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ejd != null) {
            return this.ejd.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void d(short s) {
        this.eje.d(s);
    }
}
