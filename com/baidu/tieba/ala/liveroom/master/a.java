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
import com.baidu.live.ac.a;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.ar.h;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.ag;
import com.baidu.live.data.bc;
import com.baidu.live.data.r;
import com.baidu.live.data.z;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.g;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.p.c;
import com.baidu.tieba.ala.liveroom.p.d;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private AlaLiveRecorder brl;
    private h fBm;
    private d gBF;
    private AlaMasterLiveRoomActivity gBT;
    private ViewGroup gBU;
    private RelativeLayout gBV;
    private FrameLayout gBW;
    private AlaLiveFoucsExposureViewContainer gBX;
    private View gBY;
    private AlaLiveView gBZ;
    private ViewGroup gCa;
    private LayerRootView gCb;
    private String gCc;
    private int gCg;
    private short gCi;
    private com.baidu.live.ac.a gCj;
    private com.baidu.tieba.ala.liveroom.master.a.d gCk;
    private c gkm;
    private com.baidu.live.tieba.e.b gmC;
    private String mForumId;
    private String mForumName;
    private boolean gCd = false;
    private Handler mHandler = new Handler();
    private boolean gCe = false;
    private long gCf = 0;
    private int gCh = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b gCl = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.gCd = eVar.gxC;
                if (eVar.gxy) {
                    a.this.bTp();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void up(int i) {
            if (i == 2) {
                a.this.bTi();
                if (a.this.gCe) {
                    a.this.un(2);
                }
                a.this.brl.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.brl.addRecorderCallback(a.this.gCo);
                a.this.gBZ.setBackgroundColor(a.this.gBT.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.gCd) {
                    a.this.brl.switchOrientation(a.this.gCd);
                    a.this.brl.addRecorderCallback(a.this.gCo);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.gCi = s;
            if (a.this.gBT != null) {
                if (a.this.gCi == 1) {
                    a.this.gBT.bTb();
                } else {
                    a.this.gBT.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.gBF == null || a.this.gBF.LC() == null || a.this.gBF.LC().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.gBF.LC().mLiveInfo.room_id;
                    j2 = a.this.gBF.LC().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime"));
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void Qt() {
            if (a.this.gBY != null) {
                if (a.this.gBY.getParent() != null) {
                    ((ViewGroup) a.this.gBY.getParent()).removeView(a.this.gBY);
                }
                a.this.gBY = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gBW.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.gBW.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aXJ() {
            if (a.this.gBY == null) {
                a.this.gBY = a.this.brl.createPKPlayer();
            }
            if (a.this.gBY != null && a.this.gBY.getParent() == null) {
                a.this.gBW.addView(a.this.gBY, a.this.bTm());
            }
            if (a.this.brl != null && a.this.brl.getPreview() != null) {
                FrameLayout.LayoutParams bTl = a.this.bTl();
                if (a.this.brl.getVideoConfig() != null) {
                    bTl.height = (a.this.brl.getVideoConfig().getVideoHeight() * bTl.width) / a.this.brl.getVideoConfig().getVideoWidth();
                }
                a.this.brl.getPreview().setLayoutParams(bTl);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bRb() {
            FrameLayout.LayoutParams bTl = a.this.bTl();
            int az = g.az(a.this.gBT.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gBW.getLayoutParams();
            layoutParams.height = bTl.height;
            layoutParams.topMargin = az;
            a.this.gBW.setLayoutParams(layoutParams);
            if (a.this.brl.getVideoConfig() != null) {
                bTl.height = (a.this.brl.getVideoConfig().getVideoHeight() * bTl.width) / a.this.brl.getVideoConfig().getVideoWidth();
            }
            a.this.brl.getPreview().setLayoutParams(bTl);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bRc() {
            a.this.bTi();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bRd() {
            a.this.bTj();
        }
    };
    private CustomMessageListener gCm = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.brl.stopRecord();
                } else {
                    a.this.brl.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0164a gCn = new a.InterfaceC0164a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback gCo = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.gCk != null) {
                a.this.gCk.bUR();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.gCk != null) {
                a.this.gCk.bUR();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                a.this.gCk.bUT().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.gCk != null) {
                a.this.gCk.streamStateReceived(i, z, i2, z2);
            }
            a.this.gCh = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.gCk != null) {
                if (z) {
                    a.this.gCk.aU(0, null);
                } else {
                    a.this.gCk.aU(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.gCk != null && a.this.gCk.bUT() != null) {
                a.this.gCk.bUT().errCode = 2;
                a.this.gCk.aV(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.gCk != null && a.this.gCk.bUT() != null) {
                a.this.gCk.bUT().linkTime = alaLiveDebugInfo.connectTime;
                a.this.gCk.bUT().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.gCk.bUT().startLiveTime == 0) {
                    a.this.gCk.bUT().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.uo(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.gBT.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.brl != null && a.this.brl.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.brl.getPreview() != null) {
                        a.this.bTi();
                    }
                    a.this.brl.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.brl.addRecorderCallback(a.this.gCo);
                    a.this.brl.stopRecord();
                    if (a.this.brl.getPreview() != null) {
                        a.this.bTj();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.brl != null) {
                                a.this.brl.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.brl.changeVideoRecorderType(com.baidu.live.w.a.Nk().beH != null ? com.baidu.live.w.a.Nk().beH.aFE : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.brl.addRecorderCallback(a.this.gCo);
                if (a.this.brl.getPreview() != null) {
                    a.this.bTj();
                }
                i2 = -4;
            }
            if (a.this.gCk != null) {
                a.this.gCk.aV(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.gCk != null) {
                a.this.gCk.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.gCk != null) {
                a.this.gCk.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private d.a gCp = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.p.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                ag bVB = a.this.gBF.bVB();
                if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                    a.this.gCk.bUT().logID = bVB.aEm;
                    a.this.gCk.bUT().errCode = 5;
                }
                if (!a.this.a(bVB)) {
                    if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                        a.this.gCk.bUT().updateTime = System.currentTimeMillis() - a.this.gCk.bUT().updateTime;
                    }
                    if (bVB.aHL != 1) {
                        if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                            a.this.gCk.bUT().errSubReason = -1;
                        }
                        a.this.gBT.showToast(bVB.aHM);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bVB.mErrorCode != 0) {
                        if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                            a.this.gCk.bUT().errCode = 5;
                            a.this.gCk.bUT().errSubReason = bVB.mErrorCode;
                        }
                        a.this.gBT.showToast(str);
                        if (bVB.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.gBT.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                            a.this.gCk.bUT().errCode = 0;
                            a.this.gCk.bUT().errSubReason = 0;
                        }
                        if (a.this.brl != null) {
                            a.this.brl.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.w.a.Nk().beH.aFR);
                            a.this.brl.setStartInfo(Long.toString(a.this.gBF.LC().mLiveInfo.live_id), a.this.gBF.LC().mLiveInfo.getSessionID(), com.baidu.live.w.a.Nk().beH.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.gCk != null) {
                            a.this.gCk.c(a.this.gBF.bVB());
                        }
                        a.this.bTp();
                    }
                    if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                        a.this.gCk.bUT().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.gCk != null) {
                    a.this.gCk.bUe();
                }
            } else if (i2 == 1) {
                a.this.bTq();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.gEM == 2) {
                                a.this.gCk.bUT().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gEM == 3) {
                                a.this.gCk.bUT().errSubReason = -3;
                            }
                        }
                        if (a.this.gCk != null && alaGetVerifyStrategyResponseHttpMessage.gEK == 1 && alaGetVerifyStrategyResponseHttpMessage.gEM == 1 && alaGetVerifyStrategyResponseHttpMessage.gEP == 1 && alaGetVerifyStrategyResponseHttpMessage.gER == 1) {
                            a.this.gCk.bQY();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.gBT.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.gCk != null) {
                    a.this.gCk.bUq();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.gEM != 3 ? 0 : 3;
                    if (a.this.gCj != null && a.this.gCk != null) {
                        a.this.gCj.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.gCk.bRa(), a.this.gCc).fu(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.gCk != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.gCk;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.ma(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.gBT = alaMasterLiveRoomActivity;
        this.gmC = new com.baidu.live.tieba.e.b(this.gBT.getActivity());
        bTt();
        this.gkm = new c();
        MessageManager.getInstance().registerListener(this.gCm);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ac.a.class, this.gBT.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.gCj = (com.baidu.live.ac.a) runTask.getData();
            if (this.gCj != null) {
                this.gCj.a(this.gCn);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.gBF = dVar;
        if (this.gBF == null) {
            this.gBF = new d(this.gBT.getPageContext());
        }
        if (this.fBm == null && (runTask = MessageManager.getInstance().runTask(2913177, h.class, this.gBT.getPageContext().getPageActivity())) != null) {
            this.fBm = (h) runTask.getData();
        }
        if (this.fBm != null) {
            this.fBm.b(null);
            this.fBm.a(null);
        }
        this.gBF.a(this.gCp);
        if (this.gCk != null) {
            this.gCk.setArModel(this.fBm);
            this.gCk.a(this.gBF);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.gCc = str3;
        this.gCe = false;
        mo(false);
        bTn();
        if (this.gCk != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.gxN = bundle;
            this.gCk.b(gVar);
            if (this.gCk.bRa() == 1) {
                un(this.gCk.bRa());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.gCg = alaLivePersonData.mLiveInfo.clarity;
        this.gCe = true;
        this.gCd = alaLivePersonData.mLiveInfo.screen_direction == 2;
        mo(true);
        bTn();
        if (this.gCk != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.gxM = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                un(alaLivePersonData.mLiveInfo.live_type);
            }
            this.gCk.b(gVar);
        }
        if (this.gBF != null) {
            this.gBF.h(alaLivePersonData);
        }
    }

    private void bTg() {
        this.gCd = com.baidu.live.c.AD().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bTh() {
        this.gCg = com.baidu.live.c.AD().getInt("live_recorder_resolution_level", 2);
    }

    private void mo(boolean z) {
        if (!z) {
            bTh();
            bTg();
        }
        this.gBU = (ViewGroup) View.inflate(this.gBT.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.gBT.addContentView(this.gBU, new FrameLayout.LayoutParams(-1, -1));
        this.gBT.setContentView(this.gBU);
        this.gBW = (FrameLayout) this.gBU.findViewById(a.g.ala_live_render_view);
        this.gBZ = (AlaLiveView) this.gBU.findViewById(a.g.ala_liveroom_host_liveview);
        this.gBZ.setVisibility(8);
        this.gBZ.setSwipeClearEnable(true);
        this.gBV = (RelativeLayout) this.gBU.findViewById(a.g.ala_live_unremovable_container);
        this.gCa = (ViewGroup) this.gBU.findViewById(a.g.func_view);
        this.gCb = (LayerRootView) this.gBU.findViewById(a.g.layer_root_view);
        com.baidu.live.core.layer.b.Cl().m(this.gCb);
        this.gBV.requestLayout();
        this.gBU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.gBZ == null || a.this.gBZ.gLX) {
                    return false;
                }
                a.this.gBZ.V(motionEvent);
                a.this.gBX.Q(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.MC().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.w.a.Nk().beH != null && com.baidu.live.w.a.Nk().beH.aFF) {
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
        if (bc.b(com.baidu.live.w.a.Nk().bka)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bc.a(com.baidu.live.w.a.Nk().bka)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bc.c(com.baidu.live.w.a.Nk().bka)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.brl = new AlaLiveRecorder(this.gBT.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.brl.addRecorderCallback(this.gCo);
        LiveRecorderConfigHelper.MC().ME();
        if (!this.gCd && this.brl.getPreview() != null) {
            bTj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTi() {
        if (this.brl != null && this.brl.getPreview() != null && this.brl.getPreview().getParent() != null) {
            ((ViewGroup) this.brl.getPreview().getParent()).removeView(this.brl.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTj() {
        this.brl.getPreview().setEnabled(false);
        bTi();
        if (this.gBY == null) {
            this.gBW.addView(this.brl.getPreview(), 0, bTk());
        } else {
            this.gBW.addView(this.brl.getPreview(), 0, bTl());
        }
        if (this.gBX == null) {
            this.gBX = new AlaLiveFoucsExposureViewContainer(this.gBW.getContext());
            this.gBX.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    if (a.this.brl != null) {
                        a.this.brl.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.brl != null) {
                        a.this.brl.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public float getExposure() {
                    if (a.this.brl != null) {
                        return a.this.brl.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.gBW.addView(this.gBX, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams bTk() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bTl() {
        int i = BdUtilHelper.getScreenDimensions(this.gBT.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, g.fv(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bTm() {
        int i = BdUtilHelper.getScreenDimensions(this.gBT.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, g.fv(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un(int i) {
        if (this.gCe) {
            this.brl.setVideoConfig(LiveRecorderConfigHelper.MC().d(this.gCg, i, this.gCd));
        } else {
            this.brl.setVideoConfig(LiveRecorderConfigHelper.MC().d(i == 1 ? 0 : this.gCg, i, i == 1 ? this.gCd : false));
        }
    }

    private void bTn() {
        this.gCk = new com.baidu.tieba.ala.liveroom.master.a.d(this.gBT, this.brl, this.gBZ, this.gBW, this.gBU, this.gCa, this.gmC, this.gBT.bTc());
        this.gCk.a(this.gBF);
        this.gCk.setArModel(this.fBm);
        this.gCk.a(this.gCl);
    }

    public void bTo() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gBT.getPageContext().getPageActivity());
        if (this.brl != null && this.brl.getPreview() != null && (this.gBY == null || this.gBY.getParent() == null)) {
            this.brl.getPreview().setLayoutParams(bTk());
        }
        if (this.gCk != null) {
            this.gCk.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.gBT.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gCk != null) {
            this.gCk.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTp() {
        if (this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
            if (this.gCk != null && this.gCk.bUT() != null) {
                this.gCk.bUT().liveID = Long.toString(this.gBF.LC().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.gBF.bVB().mLiveInfo.live_id), String.valueOf(this.gBF.bVB().mLiveInfo.room_id), String.valueOf(this.gBF.bVB().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.gBF.bVB().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.gBF.bVB().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.gBF.bVB().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.gCf = System.currentTimeMillis() / 1000;
            this.gBF.y(this.gBF.LC().mLiveInfo.live_id, this.gCf);
            this.gBF.f(this.gBF.LC().mLiveInfo.live_id, false);
            com.baidu.live.c.AD().putLong("last_live_room_id", this.gBF.LC().mLiveInfo.live_id);
            this.gBF.bVG();
            if (this.gCk != null && this.gCk.bUT() != null) {
                if (this.gCk.bRa() == 2) {
                    if (this.gCd) {
                        this.gCk.bUT().liveType = 5;
                    } else {
                        this.gCk.bUT().liveType = 4;
                    }
                } else if (this.gCk.bRa() == 1) {
                    if (this.gCd) {
                        this.gCk.bUT().liveType = 2;
                    } else {
                        this.gCk.bUT().liveType = 1;
                    }
                }
            }
            bTu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTq() {
        final r LC = this.gBF.LC();
        if (LC != null && LC.mLiveInfo != null) {
            if (this.gCk == null || !this.gCk.bUQ()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gBF.y(LC.mLiveInfo.live_id, a.this.gCf);
                    }
                }, LC.aDI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ag agVar) {
        if (agVar == null) {
            return false;
        }
        this.gBT.closeLoadingDialog();
        if (agVar.mErrorCode == 6) {
            this.gBT.showToast(agVar.mErrorMsg);
            if (this.gCk != null && this.gCk.bUT() != null) {
                this.gCk.bUT().errSubReason = 6;
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
        if (eVar != null && !eVar.gxy) {
            boolean z = eVar.gxz;
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
            if (this.gCk != null) {
                if (this.gCk.bUT() != null) {
                    this.gCk.bUT().updateTime = System.currentTimeMillis();
                }
                this.gBF.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.gxA, eVar.gxB ? 1 : 0, this.gCk.bRa(), this.gCd ? 2 : 1, this.gCg, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bTr() {
        if (this.gCk != null && !this.gCk.bUS() && this.gBF.bVB() == null && this.gCk != null) {
            a(this.gCk.bUU());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.gCk != null) {
            this.gCk.bUO();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.brl != null) {
            this.brl.setIsAutoStartFromBack(true);
        }
        if (this.gCk != null) {
            this.gCk.bUP();
        }
    }

    public void onPause() {
        if (this.gCk != null) {
            this.gCk.onPause();
        }
    }

    public void onFinish() {
        if (this.gCk != null) {
            this.gCk.i(this.gCi);
        }
    }

    public void onDestroy() {
        if (this.gkm != null) {
            this.gkm.release();
            this.gkm = null;
        }
        if (this.gCk != null) {
            this.gCk.onDestroy();
        }
        if (this.gCj != null) {
            this.gCj.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gmC.stop();
        this.gmC = null;
        if (this.gBF != null) {
            this.gBF.destory();
            this.gBF = null;
        }
        if (this.fBm != null) {
            this.fBm.destory();
            this.fBm = null;
        }
        if (this.brl != null) {
            z zVar = new z();
            zVar.aEE = this.gCd ? 2 : 1;
            zVar.mOpenType = 2;
            if (this.gCk != null) {
                zVar.aED = this.gCk.bRa();
            }
            this.brl.setRoomInfo(zVar.toJsonString());
            String str = "";
            if (this.gCk != null && this.gCk.bUT() != null) {
                if (this.gCk.bUT().startLiveTime != 0) {
                    str = Long.toString(this.gCk.bUT().startLiveTime);
                }
                this.brl.setConfigBeforeStop(this.gCk.bUT().getCpuMemJsonFormat(), str, "");
            }
            this.brl.removeRecorderCallback(this.gCo);
            this.brl.stopRecord();
            this.brl.release();
            this.brl = null;
        }
        if (this.gBZ != null) {
            this.gBZ.setOnTouchListener(null);
            this.gBZ.bXk();
            this.gBZ = null;
        }
        this.gBT = null;
        MessageManager.getInstance().unRegisterListener(this.gCm);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dz(int i) {
        this.gBZ.dz(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gBT.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.gBT.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBU.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.gBU.setLayoutParams(layoutParams);
            if (this.gCe && this.brl != null && this.brl.getPreview() != null && this.brl.getPreview().getParent() == null) {
                bTj();
            }
        }
        if (this.gCk != null) {
            this.gCk.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.gBT.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gCk != null) {
            this.gCk.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gCk != null) {
            this.gCk.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bTs() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTt() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gCk != null && a.this.gCk.bUT() != null) {
                        a.this.gCk.bUT().sampleMemAndCPU();
                    }
                    a.this.bTt();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTu() {
        if (this.mHandler != null && this.brl != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.uo(0);
                    a.this.bTu();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo(int i) {
        if (this.gCk != null && this.gCk.bUT() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.brl.getMediaStatus();
            if (this.gBF != null && this.gBF.bVB() != null && this.gBF.bVB().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.gBF.bVB().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.gBF.bVB().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.brl.getRecorderDebugInfo();
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
            if (this.gBT != null) {
                alaLiveExceptionInfo.appState = this.gBT.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.gCh;
            alaLiveExceptionInfo.sessionChannel = bTs();
            alaLiveExceptionInfo.nodeIP = this.brl.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.gCk.bUT().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.gCk.bUT().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.gCk.bUT().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gCk != null) {
            return this.gCk.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.gCl.f(s);
    }
}
