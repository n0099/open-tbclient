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
import com.baidu.live.ad.a;
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
import com.baidu.live.data.ae;
import com.baidu.live.data.al;
import com.baidu.live.data.bh;
import com.baidu.live.data.u;
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
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.a.d;
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
    private AlaLiveRecorder buD;
    private h fEC;
    private AlaLiveFoucsExposureViewContainer gFA;
    private View gFB;
    private AlaLiveView gFC;
    private ViewGroup gFD;
    private LayerRootView gFE;
    private String gFF;
    private int gFJ;
    private short gFL;
    private com.baidu.live.ad.a gFM;
    private d gFN;
    private com.baidu.tieba.ala.liveroom.q.d gFj;
    private AlaMasterLiveRoomActivity gFw;
    private ViewGroup gFx;
    private RelativeLayout gFy;
    private FrameLayout gFz;
    private c gnx;
    private com.baidu.live.tieba.e.b gpN;
    private String mForumId;
    private String mForumName;
    private boolean gFG = false;
    private Handler mHandler = new Handler();
    private boolean gFH = false;
    private long gFI = 0;
    private int gFK = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b gFO = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.gFG = eVar.gAR;
                if (eVar.gAN) {
                    a.this.bVb();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void uI(int i) {
            if (i == 2) {
                a.this.bUU();
                if (a.this.gFH) {
                    a.this.uG(2);
                }
                a.this.buD.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.buD.addRecorderCallback(a.this.gFR);
                a.this.gFC.setBackgroundColor(a.this.gFw.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.gFG) {
                    a.this.buD.switchOrientation(a.this.gFG);
                    a.this.buD.addRecorderCallback(a.this.gFR);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.gFL = s;
            if (a.this.gFw != null) {
                if (a.this.gFL == 1) {
                    a.this.gFw.bUN();
                } else {
                    a.this.gFw.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.gFj == null || a.this.gFj.Fq() == null || a.this.gFj.Fq().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.gFj.Fq().mLiveInfo.room_id;
                    j2 = a.this.gFj.Fq().mLiveInfo.live_id;
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
        public void Rb() {
            if (a.this.gFB != null) {
                if (a.this.gFB.getParent() != null) {
                    ((ViewGroup) a.this.gFB.getParent()).removeView(a.this.gFB);
                }
                a.this.gFB = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gFz.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.gFz.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aYv() {
            if (a.this.gFB == null) {
                a.this.gFB = a.this.buD.createPKPlayer();
            }
            if (a.this.gFB != null && a.this.gFB.getParent() == null) {
                a.this.gFz.addView(a.this.gFB, a.this.bUY());
            }
            if (a.this.buD != null && a.this.buD.getPreview() != null) {
                FrameLayout.LayoutParams bUX = a.this.bUX();
                if (a.this.buD.getVideoConfig() != null) {
                    bUX.height = (a.this.buD.getVideoConfig().getVideoHeight() * bUX.width) / a.this.buD.getVideoConfig().getVideoWidth();
                }
                a.this.buD.getPreview().setLayoutParams(bUX);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bSy() {
            FrameLayout.LayoutParams bUX = a.this.bUX();
            int az = com.baidu.live.utils.h.az(a.this.gFw.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gFz.getLayoutParams();
            layoutParams.height = bUX.height;
            layoutParams.topMargin = az;
            a.this.gFz.setLayoutParams(layoutParams);
            if (a.this.buD.getVideoConfig() != null) {
                bUX.height = (a.this.buD.getVideoConfig().getVideoHeight() * bUX.width) / a.this.buD.getVideoConfig().getVideoWidth();
            }
            a.this.buD.getPreview().setLayoutParams(bUX);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bSz() {
            a.this.bUU();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bSA() {
            a.this.bUV();
        }
    };
    private CustomMessageListener gFP = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.buD.stopRecord();
                } else {
                    a.this.buD.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0166a gFQ = new a.InterfaceC0166a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback gFR = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.gFN != null) {
                a.this.gFN.bWC();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.gFN != null) {
                a.this.gFN.bWC();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                a.this.gFN.bWE().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.gFN != null) {
                a.this.gFN.streamStateReceived(i, z, i2, z2);
            }
            a.this.gFK = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.gFN != null) {
                if (z) {
                    a.this.gFN.aU(0, null);
                } else {
                    a.this.gFN.aU(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.gFN != null && a.this.gFN.bWE() != null) {
                a.this.gFN.bWE().errCode = 2;
                a.this.gFN.aV(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.gFN != null && a.this.gFN.bWE() != null) {
                a.this.gFN.bWE().linkTime = alaLiveDebugInfo.connectTime;
                a.this.gFN.bWE().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.gFN.bWE().startLiveTime == 0) {
                    a.this.gFN.bWE().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.uH(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.gFw.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.buD != null && a.this.buD.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.buD.getPreview() != null) {
                        a.this.bUU();
                    }
                    a.this.buD.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.buD.addRecorderCallback(a.this.gFR);
                    a.this.buD.stopRecord();
                    if (a.this.buD.getPreview() != null) {
                        a.this.bUV();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.buD != null) {
                                a.this.buD.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.buD.changeVideoRecorderType(com.baidu.live.x.a.NN().bhy != null ? com.baidu.live.x.a.NN().bhy.aGV : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.buD.addRecorderCallback(a.this.gFR);
                if (a.this.buD.getPreview() != null) {
                    a.this.bUV();
                }
                i2 = -4;
            }
            if (a.this.gFN != null) {
                a.this.gFN.aV(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.gFN != null) {
                a.this.gFN.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.gFN != null) {
                a.this.gFN.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private d.a gFS = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.q.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                al bXm = a.this.gFj.bXm();
                if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                    a.this.gFN.bWE().logID = bXm.logId;
                    a.this.gFN.bWE().errCode = 5;
                }
                if (!a.this.a(bXm)) {
                    if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                        a.this.gFN.bWE().updateTime = System.currentTimeMillis() - a.this.gFN.bWE().updateTime;
                    }
                    if (bXm.aJh != 1) {
                        if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                            a.this.gFN.bWE().errSubReason = -1;
                        }
                        a.this.gFw.showToast(bXm.aJi);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bXm.mErrorCode != 0) {
                        if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                            a.this.gFN.bWE().errCode = 5;
                            a.this.gFN.bWE().errSubReason = bXm.mErrorCode;
                        }
                        a.this.gFw.showToast(str);
                        if (bXm.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.gFw.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                            a.this.gFN.bWE().errCode = 0;
                            a.this.gFN.bWE().errSubReason = 0;
                        }
                        if (a.this.buD != null) {
                            a.this.buD.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.x.a.NN().bhy.aHi);
                            a.this.buD.setStartInfo(Long.toString(a.this.gFj.Fq().mLiveInfo.live_id), a.this.gFj.Fq().mLiveInfo.getSessionID(), com.baidu.live.x.a.NN().bhy.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.gFN != null) {
                            a.this.gFN.c(a.this.gFj.bXm());
                        }
                        a.this.bVb();
                    }
                    if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                        a.this.gFN.bWE().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.gFN != null) {
                    a.this.gFN.bVP();
                }
            } else if (i2 == 1) {
                a.this.bVc();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.gIo == 2) {
                                a.this.gFN.bWE().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gIo == 3) {
                                a.this.gFN.bWE().errSubReason = -3;
                            }
                        }
                        if (a.this.gFN != null && alaGetVerifyStrategyResponseHttpMessage.gIm == 1 && alaGetVerifyStrategyResponseHttpMessage.gIo == 1 && alaGetVerifyStrategyResponseHttpMessage.gIr == 1 && alaGetVerifyStrategyResponseHttpMessage.gIt == 1) {
                            a.this.gFN.bSv();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.gFw.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.gFN != null) {
                    a.this.gFN.bWb();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.gIo != 3 ? 0 : 3;
                    if (a.this.gFM != null && a.this.gFN != null) {
                        a.this.gFM.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.gFN.bSx(), a.this.gFF).fF(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.gFN != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.gFN;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.mf(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.gFw = alaMasterLiveRoomActivity;
        this.gpN = new com.baidu.live.tieba.e.b(this.gFw.getActivity());
        bVf();
        this.gnx = new c();
        MessageManager.getInstance().registerListener(this.gFP);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ad.a.class, this.gFw.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.gFM = (com.baidu.live.ad.a) runTask.getData();
            if (this.gFM != null) {
                this.gFM.a(this.gFQ);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        CustomResponsedMessage runTask;
        this.gFj = dVar;
        if (this.gFj == null) {
            this.gFj = new com.baidu.tieba.ala.liveroom.q.d(this.gFw.getPageContext());
        }
        if (this.fEC == null && (runTask = MessageManager.getInstance().runTask(2913177, h.class, this.gFw.getPageContext().getPageActivity())) != null) {
            this.fEC = (h) runTask.getData();
        }
        if (this.fEC != null) {
            this.fEC.b(null);
            this.fEC.a(null);
        }
        this.gFj.a(this.gFS);
        if (this.gFN != null) {
            this.gFN.setArModel(this.fEC);
            this.gFN.a(this.gFj);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.gFF = str3;
        this.gFH = false;
        mu(false);
        bUZ();
        if (this.gFN != null) {
            g gVar = new g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.gBc = bundle;
            this.gFN.b(gVar);
            if (this.gFN.bSx() == 1) {
                uG(this.gFN.bSx());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.gFJ = alaLivePersonData.mLiveInfo.clarity;
        this.gFH = true;
        this.gFG = alaLivePersonData.mLiveInfo.screen_direction == 2;
        mu(true);
        bUZ();
        if (this.gFN != null) {
            g gVar = new g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.gBb = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                uG(alaLivePersonData.mLiveInfo.live_type);
            }
            this.gFN.b(gVar);
        }
        if (this.gFj != null) {
            this.gFj.h(alaLivePersonData);
        }
    }

    private void bUS() {
        this.gFG = com.baidu.live.c.AR().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bUT() {
        this.gFJ = com.baidu.live.c.AR().getInt("live_recorder_resolution_level", 2);
    }

    private void mu(boolean z) {
        if (!z) {
            bUT();
            bUS();
        }
        this.gFx = (ViewGroup) View.inflate(this.gFw.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.gFw.addContentView(this.gFx, new FrameLayout.LayoutParams(-1, -1));
        this.gFw.setContentView(this.gFx);
        this.gFz = (FrameLayout) this.gFx.findViewById(a.g.ala_live_render_view);
        this.gFC = (AlaLiveView) this.gFx.findViewById(a.g.ala_liveroom_host_liveview);
        this.gFC.setVisibility(8);
        this.gFC.setSwipeClearEnable(true);
        this.gFy = (RelativeLayout) this.gFx.findViewById(a.g.ala_live_unremovable_container);
        this.gFD = (ViewGroup) this.gFx.findViewById(a.g.func_view);
        this.gFE = (LayerRootView) this.gFx.findViewById(a.g.layer_root_view);
        com.baidu.live.core.layer.b.CA().n(this.gFE);
        this.gFy.requestLayout();
        this.gFx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.gFC == null || a.this.gFC.gPr) {
                    return false;
                }
                a.this.gFC.V(motionEvent);
                a.this.gFA.Q(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.Nk().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.x.a.NN().bhy != null && com.baidu.live.x.a.NN().bhy.aGW) {
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
        if (bh.b(com.baidu.live.x.a.NN().bmW)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bh.a(com.baidu.live.x.a.NN().bmW)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bh.c(com.baidu.live.x.a.NN().bmW)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.buD = new AlaLiveRecorder(this.gFw.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.buD.addRecorderCallback(this.gFR);
        LiveRecorderConfigHelper.Nk().Nm();
        if (!this.gFG && this.buD.getPreview() != null) {
            bUV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUU() {
        if (this.buD != null && this.buD.getPreview() != null && this.buD.getPreview().getParent() != null) {
            ((ViewGroup) this.buD.getPreview().getParent()).removeView(this.buD.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUV() {
        this.buD.getPreview().setEnabled(false);
        bUU();
        if (this.gFB == null) {
            this.gFz.addView(this.buD.getPreview(), 0, bUW());
        } else {
            this.gFz.addView(this.buD.getPreview(), 0, bUX());
        }
        if (this.gFA == null) {
            this.gFA = new AlaLiveFoucsExposureViewContainer(this.gFz.getContext());
            this.gFA.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    if (a.this.buD != null) {
                        a.this.buD.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.buD != null) {
                        a.this.buD.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public float getExposure() {
                    if (a.this.buD != null) {
                        return a.this.buD.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.gFz.addView(this.gFA, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams bUW() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bUX() {
        int i = BdUtilHelper.getScreenDimensions(this.gFw.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, com.baidu.live.utils.h.fG(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bUY() {
        int i = BdUtilHelper.getScreenDimensions(this.gFw.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, com.baidu.live.utils.h.fG(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(int i) {
        if (this.gFH) {
            this.buD.setVideoConfig(LiveRecorderConfigHelper.Nk().d(this.gFJ, i, this.gFG));
        } else {
            this.buD.setVideoConfig(LiveRecorderConfigHelper.Nk().d(i == 1 ? 0 : this.gFJ, i, i == 1 ? this.gFG : false));
        }
    }

    private void bUZ() {
        this.gFN = new com.baidu.tieba.ala.liveroom.master.a.d(this.gFw, this.buD, this.gFC, this.gFz, this.gFx, this.gFD, this.gpN, this.gFw.bUO());
        this.gFN.a(this.gFj);
        this.gFN.setArModel(this.fEC);
        this.gFN.a(this.gFO);
    }

    public void bVa() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gFw.getPageContext().getPageActivity());
        if (this.buD != null && this.buD.getPreview() != null && (this.gFB == null || this.gFB.getParent() == null)) {
            this.buD.getPreview().setLayoutParams(bUW());
        }
        if (this.gFN != null) {
            this.gFN.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.gFw.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gFN != null) {
            this.gFN.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVb() {
        if (this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null) {
            if (this.gFN != null && this.gFN.bWE() != null) {
                this.gFN.bWE().liveID = Long.toString(this.gFj.Fq().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.gFj.bXm().mLiveInfo.live_id), String.valueOf(this.gFj.bXm().mLiveInfo.room_id), String.valueOf(this.gFj.bXm().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.gFj.bXm().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.gFj.bXm().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.gFj.bXm().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.gFI = System.currentTimeMillis() / 1000;
            this.gFj.t(this.gFj.Fq().mLiveInfo.live_id, this.gFI);
            this.gFj.g(this.gFj.Fq().mLiveInfo.live_id, false);
            com.baidu.live.c.AR().putLong("last_live_room_id", this.gFj.Fq().mLiveInfo.live_id);
            this.gFj.bXr();
            if (this.gFN != null && this.gFN.bWE() != null) {
                if (this.gFN.bSx() == 2) {
                    if (this.gFG) {
                        this.gFN.bWE().liveType = 5;
                    } else {
                        this.gFN.bWE().liveType = 4;
                    }
                } else if (this.gFN.bSx() == 1) {
                    if (this.gFG) {
                        this.gFN.bWE().liveType = 2;
                    } else {
                        this.gFN.bWE().liveType = 1;
                    }
                }
            }
            bVg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVc() {
        final u Fq = this.gFj.Fq();
        if (Fq != null && Fq.mLiveInfo != null) {
            if (this.gFN == null || !this.gFN.bWB()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gFj.t(Fq.mLiveInfo.live_id, a.this.gFI);
                    }
                }, Fq.aEE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(al alVar) {
        if (alVar == null) {
            return false;
        }
        this.gFw.closeLoadingDialog();
        if (alVar.mErrorCode == 6) {
            this.gFw.showToast(alVar.mErrorMsg);
            if (this.gFN != null && this.gFN.bWE() != null) {
                this.gFN.bWE().errSubReason = 6;
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
        if (eVar != null && !eVar.gAN) {
            boolean z = eVar.gAO;
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
            if (this.gFN != null) {
                if (this.gFN.bWE() != null) {
                    this.gFN.bWE().updateTime = System.currentTimeMillis();
                }
                this.gFj.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.gAP, eVar.gAQ ? 1 : 0, this.gFN.bSx(), this.gFG ? 2 : 1, this.gFJ, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bVd() {
        if (this.gFN != null && !this.gFN.bWD() && this.gFj.bXm() == null && this.gFN != null) {
            a(this.gFN.bWF());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.gFN != null) {
            this.gFN.bWz();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.buD != null) {
            this.buD.setIsAutoStartFromBack(true);
        }
        if (this.gFN != null) {
            this.gFN.bWA();
        }
    }

    public void onPause() {
        if (this.gFN != null) {
            this.gFN.onPause();
        }
    }

    public void onFinish() {
        if (this.gFN != null) {
            this.gFN.i(this.gFL);
        }
    }

    public void onDestroy() {
        if (this.gnx != null) {
            this.gnx.release();
            this.gnx = null;
        }
        if (this.gFN != null) {
            this.gFN.onDestroy();
        }
        if (this.gFM != null) {
            this.gFM.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gpN.stop();
        this.gpN = null;
        if (this.gFj != null) {
            this.gFj.destory();
            this.gFj = null;
        }
        if (this.fEC != null) {
            this.fEC.destory();
            this.fEC = null;
        }
        if (this.buD != null) {
            ae aeVar = new ae();
            aeVar.aFR = this.gFG ? 2 : 1;
            aeVar.mOpenType = 2;
            if (this.gFN != null) {
                aeVar.aFQ = this.gFN.bSx();
            }
            this.buD.setRoomInfo(aeVar.toJsonString());
            String str = "";
            if (this.gFN != null && this.gFN.bWE() != null) {
                if (this.gFN.bWE().startLiveTime != 0) {
                    str = Long.toString(this.gFN.bWE().startLiveTime);
                }
                this.buD.setConfigBeforeStop(this.gFN.bWE().getCpuMemJsonFormat(), str, "");
            }
            this.buD.removeRecorderCallback(this.gFR);
            this.buD.stopRecord();
            this.buD.release();
            this.buD = null;
        }
        if (this.gFC != null) {
            this.gFC.setOnTouchListener(null);
            this.gFC.bYS();
            this.gFC = null;
        }
        this.gFw = null;
        MessageManager.getInstance().unRegisterListener(this.gFP);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dD(int i) {
        this.gFC.dD(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gFw.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.gFw.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gFx.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.gFx.setLayoutParams(layoutParams);
            if (this.gFH && this.buD != null && this.buD.getPreview() != null && this.buD.getPreview().getParent() == null) {
                bUV();
            }
        }
        if (this.gFN != null) {
            this.gFN.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.gFw.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gFN != null) {
            this.gFN.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gFN != null) {
            this.gFN.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bVe() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVf() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gFN != null && a.this.gFN.bWE() != null) {
                        a.this.gFN.bWE().sampleMemAndCPU();
                    }
                    a.this.bVf();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVg() {
        if (this.mHandler != null && this.buD != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.uH(0);
                    a.this.bVg();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(int i) {
        if (this.gFN != null && this.gFN.bWE() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.buD.getMediaStatus();
            if (this.gFj != null && this.gFj.bXm() != null && this.gFj.bXm().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.gFj.bXm().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.gFj.bXm().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.buD.getRecorderDebugInfo();
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
            if (this.gFw != null) {
                alaLiveExceptionInfo.appState = this.gFw.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.gFK;
            alaLiveExceptionInfo.sessionChannel = bVe();
            alaLiveExceptionInfo.nodeIP = this.buD.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.gFN.bWE().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.gFN.bWE().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.gFN.bWE().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gFN != null) {
            return this.gFN.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.gFO.f(s);
    }
}
