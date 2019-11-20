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
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.ala.liveroom.m.b dTJ;
    private com.baidu.live.tieba.e.b dWj;
    private c ehO;
    private AlaMasterLiveRoomActivity ehW;
    private ViewGroup ehX;
    private RelativeLayout ehY;
    private RelativeLayout ehZ;
    private FrameLayout eia;
    private AlaLiveRecorder eib;
    private View eic;
    private AlaLiveView eid;
    private String eie;
    private int eii;
    private short eik;
    private com.baidu.live.o.a eil;
    private d eim;
    private String mForumId;
    private String mForumName;
    private boolean eif = false;
    private Handler mHandler = new Handler();
    private boolean eig = false;
    private long eih = 0;
    private int eij = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b ein = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.eif = dVar.efc;
                if (dVar.eeY) {
                    a.this.aTf();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void nJ(int i) {
            if (i == 2) {
                a.this.aSY();
                if (a.this.eig) {
                    a.this.nG(2);
                }
                a.this.eib.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.eib.addRecorderCallback(a.this.eiq);
                a.this.eid.setBackgroundColor(a.this.ehW.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.eif) {
                    a.this.eib.switchOrientation(a.this.eif);
                    a.this.eib.addRecorderCallback(a.this.eiq);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void c(short s) {
            long j;
            long j2 = -1;
            a.this.eik = s;
            if (a.this.eik == 1) {
                a.this.ehW.aSV();
            } else {
                a.this.ehW.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.ehO == null || a.this.ehO.uk() == null || a.this.ehO.uk().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.ehO.uk().mLiveInfo.room_id;
                    j2 = a.this.ehO.uk().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRK() {
            if (a.this.eic != null) {
                if (a.this.eic.getParent() != null) {
                    ((ViewGroup) a.this.eic.getParent()).removeView(a.this.eic);
                }
                a.this.eic = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.eia.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.eia.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRL() {
            if (a.this.eic == null) {
                a.this.eic = a.this.eib.createPKPlayer();
            }
            if (a.this.eic != null && a.this.eic.getParent() == null) {
                a.this.eia.addView(a.this.eic, a.this.aTc());
            }
            if (a.this.eib != null && a.this.eib.getPreview() != null) {
                FrameLayout.LayoutParams aTb = a.this.aTb();
                if (a.this.eib.getVideoConfig() != null) {
                    aTb.height = (a.this.eib.getVideoConfig().getVideoHeight() * aTb.width) / a.this.eib.getVideoConfig().getVideoWidth();
                }
                a.this.eib.getPreview().setLayoutParams(aTb);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRM() {
            FrameLayout.LayoutParams aTb = a.this.aTb();
            int au = f.au(a.this.ehW.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.eia.getLayoutParams();
            layoutParams.height = aTb.height;
            layoutParams.topMargin = au;
            a.this.eia.setLayoutParams(layoutParams);
            if (a.this.eib.getVideoConfig() != null) {
                aTb.height = (a.this.eib.getVideoConfig().getVideoHeight() * aTb.width) / a.this.eib.getVideoConfig().getVideoWidth();
            }
            a.this.eib.getPreview().setLayoutParams(aTb);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRN() {
            a.this.aSY();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aRO() {
            a.this.aSZ();
        }
    };
    private CustomMessageListener eio = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.eib.stopRecord();
                } else {
                    a.this.eib.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0071a eip = new a.InterfaceC0071a() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
    };
    private RecorderCallback eiq = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.eim != null) {
                a.this.eim.aUx();
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.eim != null) {
                a.this.eim.aUx();
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.eim != null && a.this.eim.aUz() != null) {
                a.this.eim.aUz().lostRate = d;
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.eim != null) {
                a.this.eim.streamStateReceived(i, z, i2, z2);
            }
            a.this.eij = i2;
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.eim != null) {
                if (z) {
                    a.this.eim.ab(0, null);
                } else {
                    a.this.eim.ab(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.eim != null && a.this.eim.aUz() != null) {
                a.this.eim.aUz().errCode = 2;
                a.this.eim.ac(-5, null);
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.eim != null && a.this.eim.aUz() != null) {
                a.this.eim.aUz().linkTime = alaLiveDebugInfo.connectTime;
                a.this.eim.aUz().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.eim.aUz().startLiveTime == 0) {
                    a.this.eim.aUz().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.nI(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.ehW.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.eib != null && a.this.eib.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.eib.getPreview() != null) {
                        a.this.aSY();
                    }
                    a.this.eib.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.eib.addRecorderCallback(a.this.eiq);
                    a.this.eib.stopRecord();
                    if (a.this.eib.getPreview() != null) {
                        a.this.aSZ();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eib != null) {
                                a.this.eib.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.eib.changeVideoRecorderType(com.baidu.live.l.a.uB().ajF != null ? com.baidu.live.l.a.uB().ajF.Qs : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.eib.addRecorderCallback(a.this.eiq);
                if (a.this.eib.getPreview() != null) {
                    a.this.aSZ();
                }
                i2 = -4;
            }
            if (a.this.eim != null) {
                a.this.eim.ac(i2, str);
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.eim != null) {
                a.this.eim.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.eim != null) {
                a.this.eim.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.liveRecorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a eir = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.8
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                g aUZ = a.this.ehO.aUZ();
                a.this.eim.aUz().logID = aUZ.Po;
                a.this.eim.aUz().errCode = 5;
                if (!a.this.a(aUZ)) {
                    if (a.this.eim != null && a.this.eim.aUz() != null) {
                        a.this.eim.aUz().updateTime = System.currentTimeMillis() - a.this.eim.aUz().updateTime;
                    }
                    if (aUZ.efl != 1) {
                        if (a.this.eim != null && a.this.eim.aUz() != null) {
                            a.this.eim.aUz().errSubReason = -1;
                        }
                        a.this.ehW.showToast(aUZ.efm);
                        a.this.c((short) 1);
                        return;
                    }
                    if (aUZ.mErrorCode != 0) {
                        if (a.this.eim != null && a.this.eim.aUz() != null) {
                            a.this.eim.aUz().errCode = 5;
                            a.this.eim.aUz().errSubReason = aUZ.mErrorCode;
                        }
                        a.this.ehW.showToast(str);
                        if (aUZ.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.ehW.getActivity());
                        }
                        a.this.c((short) 1);
                    } else {
                        if (a.this.eim != null && a.this.eim.aUz() != null) {
                            a.this.eim.aUz().errCode = 0;
                            a.this.eim.aUz().errSubReason = 0;
                        }
                        if (a.this.eib != null) {
                            a.this.eib.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.l.a.uB().ajF.QG);
                            a.this.eib.setStartInfo(Long.toString(a.this.ehO.uk().mLiveInfo.live_id), a.this.ehO.uk().mLiveInfo.getSessionID(), com.baidu.live.l.a.uB().ajF.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.eim != null) {
                            a.this.eim.c(a.this.ehO.aUZ());
                        }
                        a.this.aTf();
                    }
                    if (a.this.eim != null && a.this.eim.aUz() != null) {
                        a.this.eim.aUz().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.eim != null) {
                    a.this.eim.aTM();
                }
            } else if (i2 == 1) {
                a.this.aTg();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.eim != null && a.this.eim.aUz() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.eku == 2) {
                            a.this.eim.aUz().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.eku == 3) {
                            a.this.eim.aUz().errSubReason = -3;
                        }
                    }
                    if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && a.this.eim != null && alaGetVerifyStrategyResponseHttpMessage.eks == 1 && alaGetVerifyStrategyResponseHttpMessage.eku == 1) {
                        a.this.eim.aRH();
                    }
                }
                if (a.this.eim != null) {
                    a.this.eim.aTY();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.eku != 3 ? 0 : 3;
                if (a.this.eil != null && a.this.eim != null) {
                    a.this.eil.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.eim.aRJ(), a.this.eie).cm(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.ehW = alaMasterLiveRoomActivity;
        this.dWj = new com.baidu.live.tieba.e.b(this.ehW.getActivity());
        aTj();
        this.dTJ = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.eio);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.o.a.class, this.ehW.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.eil = (com.baidu.live.o.a) runTask.getData();
            if (this.eil != null) {
                this.eil.a(this.eip);
            }
        }
    }

    public void a(c cVar) {
        this.ehO = cVar;
        if (this.ehO == null) {
            this.ehO = new c(this.ehW.getPageContext());
        }
        this.ehO.a(this.eir);
        if (this.eim != null) {
            this.eim.a(this.ehO);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.eie = str3;
        this.eig = false;
        hV(false);
        aTd();
        if (this.eim != null) {
            com.baidu.tieba.ala.liveroom.data.f fVar = new com.baidu.tieba.ala.liveroom.data.f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.efj = bundle;
            this.eim.b(fVar);
            if (this.eim.aRJ() == 1) {
                nG(this.eim.aRJ());
            }
        }
    }

    public void d(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.eii = alaLivePersonData.mLiveInfo.clarity;
        this.eig = true;
        this.eif = alaLivePersonData.mLiveInfo.screen_direction == 2;
        hV(true);
        aTd();
        if (this.eim != null) {
            com.baidu.tieba.ala.liveroom.data.f fVar = new com.baidu.tieba.ala.liveroom.data.f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.efi = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                nG(alaLivePersonData.mLiveInfo.live_type);
            }
            this.eim.b(fVar);
        }
    }

    private void aSW() {
        this.eif = com.baidu.live.c.np().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void aSX() {
        this.eii = com.baidu.live.c.np().getInt("live_recorder_resolution_level", 2);
    }

    private void hV(boolean z) {
        if (!z) {
            aSX();
            aSW();
        }
        this.ehX = (ViewGroup) View.inflate(this.ehW.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.ehW.addContentView(this.ehX, new FrameLayout.LayoutParams(-1, -1));
        this.ehW.setContentView(this.ehX);
        this.eia = (FrameLayout) this.ehX.findViewById(a.g.ala_live_render_view);
        this.eid = (AlaLiveView) this.ehX.findViewById(a.g.ala_liveroom_host_liveview);
        this.eid.setVisibility(8);
        this.eid.setSwipeClearEnable(true);
        this.ehY = (RelativeLayout) this.ehX.findViewById(a.g.ala_live_unremovable_host_top);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ehY.getLayoutParams();
        layoutParams.topMargin = this.ehW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.ehW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.ehY.requestLayout();
        this.ehZ = (RelativeLayout) this.ehX.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ehZ.getLayoutParams();
        layoutParams2.topMargin = this.ehW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams2.topMargin = this.ehW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.ehZ.requestLayout();
        this.ehX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.eid == null || a.this.eid.eqC) {
                    return false;
                }
                return a.this.eid.z(motionEvent);
            }
        });
        this.ehX.findViewById(a.g.ala_live_host_bottom).setVisibility(8);
        this.ehX.findViewById(a.g.ala_live_unremovable_bottom).setVisibility(8);
        AlaLiveVideoConfig i = AlaLiveRecordConfigHelper.aRu().i(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.l.a.uB().ajF != null && com.baidu.live.l.a.uB().ajF.Qt) {
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
        this.eib = new AlaLiveRecorder(this.ehW.getPageContext().getPageActivity(), i, VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_FACEUNITY);
        this.eib.setUserGameHardEncode(com.baidu.live.l.a.uB().ajF.Qv);
        this.eib.addRecorderCallback(this.eiq);
        if (!this.eif && this.eib.getPreview() != null) {
            aSZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSY() {
        if (this.eib != null && this.eib.getPreview() != null && this.eib.getPreview().getParent() != null) {
            ((ViewGroup) this.eib.getPreview().getParent()).removeView(this.eib.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSZ() {
        this.eib.getPreview().setEnabled(false);
        aSY();
        if (this.eic == null) {
            this.eia.addView(this.eib.getPreview(), 0, aTa());
        } else {
            this.eia.addView(this.eib.getPreview(), 0, aTb());
        }
    }

    private FrameLayout.LayoutParams aTa() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams aTb() {
        int i = BdUtilHelper.getScreenDimensions(this.ehW.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams aTc() {
        int i = BdUtilHelper.getScreenDimensions(this.ehW.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG(int i) {
        if (this.eig) {
            this.eib.setVideoConfig(AlaLiveRecordConfigHelper.aRu().i(this.eii, i, this.eif));
        } else {
            this.eib.setVideoConfig(AlaLiveRecordConfigHelper.aRu().i(i == 1 ? 0 : this.eii, i, i == 1 ? this.eif : false));
        }
    }

    private void aTd() {
        this.eim = new d(this.ehW.getPageContext(), this.eib, this.eid, this.ehX, this.dWj);
        this.eim.a(this.ehO);
        this.eim.a(this.ein);
    }

    public void aTe() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.ehW.getPageContext().getPageActivity());
        if (this.eib != null && this.eib.getPreview() != null && (this.eic == null || this.eic.getParent() == null)) {
            this.eib.getPreview().setLayoutParams(aTa());
        }
        if (this.eim != null) {
            this.eim.E(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.ehW.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eim != null) {
            this.eim.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTf() {
        if (this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null) {
            if (this.eim != null && this.eim.aUz() != null) {
                this.eim.aUz().liveID = Long.toString(this.ehO.uk().mLiveInfo.live_id);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            this.eih = System.currentTimeMillis() / 1000;
            this.ehO.s(this.ehO.uk().mLiveInfo.live_id, this.eih);
            this.ehO.cj(this.ehO.uk().mLiveInfo.live_id);
            com.baidu.live.c.np().putLong("last_live_room_id", this.ehO.uk().mLiveInfo.live_id);
            this.ehO.aVf();
            if (this.eim != null && this.eim.aUz() != null) {
                if (this.eim.aRJ() == 2) {
                    if (this.eif) {
                        this.eim.aUz().liveType = 5;
                    } else {
                        this.eim.aUz().liveType = 4;
                    }
                } else if (this.eim.aRJ() == 1) {
                    if (this.eif) {
                        this.eim.aUz().liveType = 2;
                    } else {
                        this.eim.aUz().liveType = 1;
                    }
                }
            }
            aTk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTg() {
        final i uk = this.ehO.uk();
        if (uk != null && uk.mLiveInfo != null) {
            if (this.eim == null || !this.eim.aUw()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ehO.s(uk.mLiveInfo.live_id, a.this.eih);
                    }
                }, uk.OW);
                if (this.eig && uk.mLiveInfo.group_id != 0) {
                    this.ehO.Q(String.valueOf(uk.mLiveInfo.getGroupID()), String.valueOf(uk.mLiveInfo.getLastMsgID()), String.valueOf(uk.mLiveInfo.getUserID()));
                    this.eig = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        this.ehW.closeLoadingDialog();
        if (gVar.mErrorCode == 6) {
            this.ehW.showToast(gVar.mErrorMsg);
            if (this.eim != null && this.eim.aUz() != null) {
                this.eim.aUz().errSubReason = 6;
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
        if (dVar != null && !dVar.eeY) {
            boolean z = dVar.eeZ;
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
            if (this.eim != null) {
                if (this.eim.aUz() != null) {
                    this.eim.aUz().updateTime = System.currentTimeMillis();
                }
                this.ehO.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.efa, dVar.efb ? 1 : 0, this.eim.aRJ(), this.eif ? 2 : 1, this.eii, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void aTh() {
        if (this.eim != null && !this.eim.aUy() && this.ehO.aUZ() == null && this.eim != null) {
            a(this.eim.aUA());
        }
    }

    public void onStop() {
        if (this.eim != null) {
            this.eim.aUu();
        }
    }

    public void onResume() {
        if (this.eib != null) {
            this.eib.setIsAutoStartFromBack(true);
        }
        if (this.eim != null) {
            this.eim.aUv();
        }
    }

    public void onPause() {
        if (this.eim != null) {
            this.eim.onPause();
        }
    }

    public void onFinish() {
        if (this.eim != null) {
            this.eim.f(this.eik);
        }
    }

    public void onDestroy() {
        if (this.dTJ != null) {
            this.dTJ.release();
            this.dTJ = null;
        }
        if (this.eim != null) {
            this.eim.onDestroy();
        }
        if (this.eil != null) {
            this.eil.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.dWj.stop();
        this.dWj = null;
        if (this.ehO != null) {
            this.ehO.destory();
            this.ehO = null;
        }
        if (this.eib != null) {
            n nVar = new n();
            nVar.Px = this.eif ? 2 : 1;
            nVar.mOpenType = 2;
            nVar.Pw = this.eim.aRJ();
            this.eib.setRoomInfo(nVar.toJsonString());
            String str = "";
            if (this.eim != null && this.eim.aUz() != null) {
                if (this.eim.aUz().startLiveTime != 0) {
                    str = Long.toString(this.eim.aUz().startLiveTime);
                }
                this.eib.setConfigBeforeStop(this.eim.aUz().getCpuMemJsonFormat(), str, "");
            }
            this.eib.removeRecorderCallback(this.eiq);
            this.eib.stopRecord();
            this.eib.release();
            this.eib = null;
        }
        if (this.eid != null) {
            this.eid.setOnTouchListener(null);
            this.eid.aWF();
            this.eid = null;
        }
        this.ehW = null;
        MessageManager.getInstance().unRegisterListener(this.eio);
    }

    public void bw(int i) {
        this.eid.bw(i);
        nH(i);
    }

    private void nH(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.ehW.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.ehW.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ehX.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.ehX.setLayoutParams(layoutParams);
            if (this.eig && this.eib != null && this.eib.getPreview() != null && this.eib.getPreview().getParent() == null) {
                aSZ();
            }
        }
        if (this.eim != null) {
            this.eim.E(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.ehW.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eim != null) {
            this.eim.onActivityResult(i, i2, intent);
        }
    }

    private int aTi() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTj() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eim.aUz().sampleMemAndCPU();
                    a.this.aTj();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTk() {
        if (this.mHandler != null && this.eib != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nI(0);
                    a.this.aTk();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nI(int i) {
        if (this.eim != null && this.eim.aUz() != null) {
            com.baidu.live.message.c cVar = new com.baidu.live.message.c();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.eib.getMediaStatus();
            if (this.ehO != null && this.ehO.aUZ() != null && this.ehO.aUZ().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.ehO.aUZ().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.ehO.aUZ().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.eib.getRecorderDebugInfo();
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
            if (this.ehW != null) {
                alaLiveExceptionInfo.appState = this.ehW.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.eij;
            alaLiveExceptionInfo.sessionChannel = aTi();
            alaLiveExceptionInfo.nodeIP = this.eib.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.eim.aUz().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.eim.aUz().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            cVar.a(alaLiveExceptionInfo);
            this.eim.aUz().reset();
            MessageManager.getInstance().sendMessage(cVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eim != null) {
            return this.eim.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void c(short s) {
        this.ein.c(s);
    }
}
