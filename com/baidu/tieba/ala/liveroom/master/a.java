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
    private AlaLiveRecorder bro;
    private h fBq;
    private d gBJ;
    private AlaMasterLiveRoomActivity gBX;
    private ViewGroup gBY;
    private RelativeLayout gBZ;
    private FrameLayout gCa;
    private AlaLiveFoucsExposureViewContainer gCb;
    private View gCc;
    private AlaLiveView gCd;
    private ViewGroup gCe;
    private LayerRootView gCf;
    private String gCg;
    private int gCk;
    private short gCm;
    private com.baidu.live.ac.a gCn;
    private com.baidu.tieba.ala.liveroom.master.a.d gCo;
    private c gkq;
    private com.baidu.live.tieba.e.b gmG;
    private String mForumId;
    private String mForumName;
    private boolean gCh = false;
    private Handler mHandler = new Handler();
    private boolean gCi = false;
    private long gCj = 0;
    private int gCl = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b gCp = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.gCh = eVar.gxG;
                if (eVar.gxC) {
                    a.this.bTq();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void up(int i) {
            if (i == 2) {
                a.this.bTj();
                if (a.this.gCi) {
                    a.this.un(2);
                }
                a.this.bro.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bro.addRecorderCallback(a.this.gCs);
                a.this.gCd.setBackgroundColor(a.this.gBX.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.gCh) {
                    a.this.bro.switchOrientation(a.this.gCh);
                    a.this.bro.addRecorderCallback(a.this.gCs);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.gCm = s;
            if (a.this.gBX != null) {
                if (a.this.gCm == 1) {
                    a.this.gBX.bTc();
                } else {
                    a.this.gBX.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.gBJ == null || a.this.gBJ.LC() == null || a.this.gBJ.LC().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.gBJ.LC().mLiveInfo.room_id;
                    j2 = a.this.gBJ.LC().mLiveInfo.live_id;
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
            if (a.this.gCc != null) {
                if (a.this.gCc.getParent() != null) {
                    ((ViewGroup) a.this.gCc.getParent()).removeView(a.this.gCc);
                }
                a.this.gCc = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gCa.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.gCa.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aXJ() {
            if (a.this.gCc == null) {
                a.this.gCc = a.this.bro.createPKPlayer();
            }
            if (a.this.gCc != null && a.this.gCc.getParent() == null) {
                a.this.gCa.addView(a.this.gCc, a.this.bTn());
            }
            if (a.this.bro != null && a.this.bro.getPreview() != null) {
                FrameLayout.LayoutParams bTm = a.this.bTm();
                if (a.this.bro.getVideoConfig() != null) {
                    bTm.height = (a.this.bro.getVideoConfig().getVideoHeight() * bTm.width) / a.this.bro.getVideoConfig().getVideoWidth();
                }
                a.this.bro.getPreview().setLayoutParams(bTm);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bRc() {
            FrameLayout.LayoutParams bTm = a.this.bTm();
            int az = g.az(a.this.gBX.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gCa.getLayoutParams();
            layoutParams.height = bTm.height;
            layoutParams.topMargin = az;
            a.this.gCa.setLayoutParams(layoutParams);
            if (a.this.bro.getVideoConfig() != null) {
                bTm.height = (a.this.bro.getVideoConfig().getVideoHeight() * bTm.width) / a.this.bro.getVideoConfig().getVideoWidth();
            }
            a.this.bro.getPreview().setLayoutParams(bTm);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bRd() {
            a.this.bTj();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bRe() {
            a.this.bTk();
        }
    };
    private CustomMessageListener gCq = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bro.stopRecord();
                } else {
                    a.this.bro.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0164a gCr = new a.InterfaceC0164a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback gCs = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.gCo != null) {
                a.this.gCo.bUS();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.gCo != null) {
                a.this.gCo.bUS();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                a.this.gCo.bUU().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.gCo != null) {
                a.this.gCo.streamStateReceived(i, z, i2, z2);
            }
            a.this.gCl = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.gCo != null) {
                if (z) {
                    a.this.gCo.aT(0, null);
                } else {
                    a.this.gCo.aT(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.gCo != null && a.this.gCo.bUU() != null) {
                a.this.gCo.bUU().errCode = 2;
                a.this.gCo.aU(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.gCo != null && a.this.gCo.bUU() != null) {
                a.this.gCo.bUU().linkTime = alaLiveDebugInfo.connectTime;
                a.this.gCo.bUU().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.gCo.bUU().startLiveTime == 0) {
                    a.this.gCo.bUU().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
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
                a.this.gBX.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.bro != null && a.this.bro.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bro.getPreview() != null) {
                        a.this.bTj();
                    }
                    a.this.bro.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bro.addRecorderCallback(a.this.gCs);
                    a.this.bro.stopRecord();
                    if (a.this.bro.getPreview() != null) {
                        a.this.bTk();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bro != null) {
                                a.this.bro.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bro.changeVideoRecorderType(com.baidu.live.w.a.Nk().beJ != null ? com.baidu.live.w.a.Nk().beJ.aFG : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bro.addRecorderCallback(a.this.gCs);
                if (a.this.bro.getPreview() != null) {
                    a.this.bTk();
                }
                i2 = -4;
            }
            if (a.this.gCo != null) {
                a.this.gCo.aU(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.gCo != null) {
                a.this.gCo.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.gCo != null) {
                a.this.gCo.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private d.a gCt = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.p.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                ag bVC = a.this.gBJ.bVC();
                if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                    a.this.gCo.bUU().logID = bVC.aEo;
                    a.this.gCo.bUU().errCode = 5;
                }
                if (!a.this.a(bVC)) {
                    if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                        a.this.gCo.bUU().updateTime = System.currentTimeMillis() - a.this.gCo.bUU().updateTime;
                    }
                    if (bVC.aHN != 1) {
                        if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                            a.this.gCo.bUU().errSubReason = -1;
                        }
                        a.this.gBX.showToast(bVC.aHO);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bVC.mErrorCode != 0) {
                        if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                            a.this.gCo.bUU().errCode = 5;
                            a.this.gCo.bUU().errSubReason = bVC.mErrorCode;
                        }
                        a.this.gBX.showToast(str);
                        if (bVC.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.gBX.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                            a.this.gCo.bUU().errCode = 0;
                            a.this.gCo.bUU().errSubReason = 0;
                        }
                        if (a.this.bro != null) {
                            a.this.bro.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.w.a.Nk().beJ.aFT);
                            a.this.bro.setStartInfo(Long.toString(a.this.gBJ.LC().mLiveInfo.live_id), a.this.gBJ.LC().mLiveInfo.getSessionID(), com.baidu.live.w.a.Nk().beJ.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.gCo != null) {
                            a.this.gCo.c(a.this.gBJ.bVC());
                        }
                        a.this.bTq();
                    }
                    if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                        a.this.gCo.bUU().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.gCo != null) {
                    a.this.gCo.bUf();
                }
            } else if (i2 == 1) {
                a.this.bTr();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.gEQ == 2) {
                                a.this.gCo.bUU().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gEQ == 3) {
                                a.this.gCo.bUU().errSubReason = -3;
                            }
                        }
                        if (a.this.gCo != null && alaGetVerifyStrategyResponseHttpMessage.gEO == 1 && alaGetVerifyStrategyResponseHttpMessage.gEQ == 1 && alaGetVerifyStrategyResponseHttpMessage.gET == 1 && alaGetVerifyStrategyResponseHttpMessage.gEV == 1) {
                            a.this.gCo.bQZ();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.gBX.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.gCo != null) {
                    a.this.gCo.bUr();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.gEQ != 3 ? 0 : 3;
                    if (a.this.gCn != null && a.this.gCo != null) {
                        a.this.gCn.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.gCo.bRb(), a.this.gCg).fu(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.gCo != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.gCo;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.mc(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.gBX = alaMasterLiveRoomActivity;
        this.gmG = new com.baidu.live.tieba.e.b(this.gBX.getActivity());
        bTu();
        this.gkq = new c();
        MessageManager.getInstance().registerListener(this.gCq);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ac.a.class, this.gBX.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.gCn = (com.baidu.live.ac.a) runTask.getData();
            if (this.gCn != null) {
                this.gCn.a(this.gCr);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.gBJ = dVar;
        if (this.gBJ == null) {
            this.gBJ = new d(this.gBX.getPageContext());
        }
        if (this.fBq == null && (runTask = MessageManager.getInstance().runTask(2913177, h.class, this.gBX.getPageContext().getPageActivity())) != null) {
            this.fBq = (h) runTask.getData();
        }
        if (this.fBq != null) {
            this.fBq.b(null);
            this.fBq.a(null);
        }
        this.gBJ.a(this.gCt);
        if (this.gCo != null) {
            this.gCo.setArModel(this.fBq);
            this.gCo.a(this.gBJ);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.gCg = str3;
        this.gCi = false;
        mq(false);
        bTo();
        if (this.gCo != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.gxR = bundle;
            this.gCo.b(gVar);
            if (this.gCo.bRb() == 1) {
                un(this.gCo.bRb());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.gCk = alaLivePersonData.mLiveInfo.clarity;
        this.gCi = true;
        this.gCh = alaLivePersonData.mLiveInfo.screen_direction == 2;
        mq(true);
        bTo();
        if (this.gCo != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.gxQ = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                un(alaLivePersonData.mLiveInfo.live_type);
            }
            this.gCo.b(gVar);
        }
        if (this.gBJ != null) {
            this.gBJ.h(alaLivePersonData);
        }
    }

    private void bTh() {
        this.gCh = com.baidu.live.c.AD().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bTi() {
        this.gCk = com.baidu.live.c.AD().getInt("live_recorder_resolution_level", 2);
    }

    private void mq(boolean z) {
        if (!z) {
            bTi();
            bTh();
        }
        this.gBY = (ViewGroup) View.inflate(this.gBX.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.gBX.addContentView(this.gBY, new FrameLayout.LayoutParams(-1, -1));
        this.gBX.setContentView(this.gBY);
        this.gCa = (FrameLayout) this.gBY.findViewById(a.g.ala_live_render_view);
        this.gCd = (AlaLiveView) this.gBY.findViewById(a.g.ala_liveroom_host_liveview);
        this.gCd.setVisibility(8);
        this.gCd.setSwipeClearEnable(true);
        this.gBZ = (RelativeLayout) this.gBY.findViewById(a.g.ala_live_unremovable_container);
        this.gCe = (ViewGroup) this.gBY.findViewById(a.g.func_view);
        this.gCf = (LayerRootView) this.gBY.findViewById(a.g.layer_root_view);
        com.baidu.live.core.layer.b.Cl().m(this.gCf);
        this.gBZ.requestLayout();
        this.gBY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.gCd == null || a.this.gCd.gMb) {
                    return false;
                }
                a.this.gCd.V(motionEvent);
                a.this.gCb.Q(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.MC().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.w.a.Nk().beJ != null && com.baidu.live.w.a.Nk().beJ.aFH) {
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
        if (bc.b(com.baidu.live.w.a.Nk().bkd)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bc.a(com.baidu.live.w.a.Nk().bkd)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bc.c(com.baidu.live.w.a.Nk().bkd)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bro = new AlaLiveRecorder(this.gBX.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bro.addRecorderCallback(this.gCs);
        LiveRecorderConfigHelper.MC().ME();
        if (!this.gCh && this.bro.getPreview() != null) {
            bTk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTj() {
        if (this.bro != null && this.bro.getPreview() != null && this.bro.getPreview().getParent() != null) {
            ((ViewGroup) this.bro.getPreview().getParent()).removeView(this.bro.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTk() {
        this.bro.getPreview().setEnabled(false);
        bTj();
        if (this.gCc == null) {
            this.gCa.addView(this.bro.getPreview(), 0, bTl());
        } else {
            this.gCa.addView(this.bro.getPreview(), 0, bTm());
        }
        if (this.gCb == null) {
            this.gCb = new AlaLiveFoucsExposureViewContainer(this.gCa.getContext());
            this.gCb.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    if (a.this.bro != null) {
                        a.this.bro.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bro != null) {
                        a.this.bro.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public float getExposure() {
                    if (a.this.bro != null) {
                        return a.this.bro.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.gCa.addView(this.gCb, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams bTl() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bTm() {
        int i = BdUtilHelper.getScreenDimensions(this.gBX.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, g.fv(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bTn() {
        int i = BdUtilHelper.getScreenDimensions(this.gBX.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, g.fv(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un(int i) {
        if (this.gCi) {
            this.bro.setVideoConfig(LiveRecorderConfigHelper.MC().d(this.gCk, i, this.gCh));
        } else {
            this.bro.setVideoConfig(LiveRecorderConfigHelper.MC().d(i == 1 ? 0 : this.gCk, i, i == 1 ? this.gCh : false));
        }
    }

    private void bTo() {
        this.gCo = new com.baidu.tieba.ala.liveroom.master.a.d(this.gBX, this.bro, this.gCd, this.gCa, this.gBY, this.gCe, this.gmG, this.gBX.bTd());
        this.gCo.a(this.gBJ);
        this.gCo.setArModel(this.fBq);
        this.gCo.a(this.gCp);
    }

    public void bTp() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gBX.getPageContext().getPageActivity());
        if (this.bro != null && this.bro.getPreview() != null && (this.gCc == null || this.gCc.getParent() == null)) {
            this.bro.getPreview().setLayoutParams(bTl());
        }
        if (this.gCo != null) {
            this.gCo.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.gBX.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gCo != null) {
            this.gCo.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTq() {
        if (this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
            if (this.gCo != null && this.gCo.bUU() != null) {
                this.gCo.bUU().liveID = Long.toString(this.gBJ.LC().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.gBJ.bVC().mLiveInfo.live_id), String.valueOf(this.gBJ.bVC().mLiveInfo.room_id), String.valueOf(this.gBJ.bVC().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.gBJ.bVC().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.gBJ.bVC().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.gBJ.bVC().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.gCj = System.currentTimeMillis() / 1000;
            this.gBJ.y(this.gBJ.LC().mLiveInfo.live_id, this.gCj);
            this.gBJ.f(this.gBJ.LC().mLiveInfo.live_id, false);
            com.baidu.live.c.AD().putLong("last_live_room_id", this.gBJ.LC().mLiveInfo.live_id);
            this.gBJ.bVH();
            if (this.gCo != null && this.gCo.bUU() != null) {
                if (this.gCo.bRb() == 2) {
                    if (this.gCh) {
                        this.gCo.bUU().liveType = 5;
                    } else {
                        this.gCo.bUU().liveType = 4;
                    }
                } else if (this.gCo.bRb() == 1) {
                    if (this.gCh) {
                        this.gCo.bUU().liveType = 2;
                    } else {
                        this.gCo.bUU().liveType = 1;
                    }
                }
            }
            bTv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTr() {
        final r LC = this.gBJ.LC();
        if (LC != null && LC.mLiveInfo != null) {
            if (this.gCo == null || !this.gCo.bUR()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gBJ.y(LC.mLiveInfo.live_id, a.this.gCj);
                    }
                }, LC.aDK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ag agVar) {
        if (agVar == null) {
            return false;
        }
        this.gBX.closeLoadingDialog();
        if (agVar.mErrorCode == 6) {
            this.gBX.showToast(agVar.mErrorMsg);
            if (this.gCo != null && this.gCo.bUU() != null) {
                this.gCo.bUU().errSubReason = 6;
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
        if (eVar != null && !eVar.gxC) {
            boolean z = eVar.gxD;
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
            if (this.gCo != null) {
                if (this.gCo.bUU() != null) {
                    this.gCo.bUU().updateTime = System.currentTimeMillis();
                }
                this.gBJ.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.gxE, eVar.gxF ? 1 : 0, this.gCo.bRb(), this.gCh ? 2 : 1, this.gCk, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bTs() {
        if (this.gCo != null && !this.gCo.bUT() && this.gBJ.bVC() == null && this.gCo != null) {
            a(this.gCo.bUV());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.gCo != null) {
            this.gCo.bUP();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bro != null) {
            this.bro.setIsAutoStartFromBack(true);
        }
        if (this.gCo != null) {
            this.gCo.bUQ();
        }
    }

    public void onPause() {
        if (this.gCo != null) {
            this.gCo.onPause();
        }
    }

    public void onFinish() {
        if (this.gCo != null) {
            this.gCo.i(this.gCm);
        }
    }

    public void onDestroy() {
        if (this.gkq != null) {
            this.gkq.release();
            this.gkq = null;
        }
        if (this.gCo != null) {
            this.gCo.onDestroy();
        }
        if (this.gCn != null) {
            this.gCn.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gmG.stop();
        this.gmG = null;
        if (this.gBJ != null) {
            this.gBJ.destory();
            this.gBJ = null;
        }
        if (this.fBq != null) {
            this.fBq.destory();
            this.fBq = null;
        }
        if (this.bro != null) {
            z zVar = new z();
            zVar.aEG = this.gCh ? 2 : 1;
            zVar.mOpenType = 2;
            if (this.gCo != null) {
                zVar.aEF = this.gCo.bRb();
            }
            this.bro.setRoomInfo(zVar.toJsonString());
            String str = "";
            if (this.gCo != null && this.gCo.bUU() != null) {
                if (this.gCo.bUU().startLiveTime != 0) {
                    str = Long.toString(this.gCo.bUU().startLiveTime);
                }
                this.bro.setConfigBeforeStop(this.gCo.bUU().getCpuMemJsonFormat(), str, "");
            }
            this.bro.removeRecorderCallback(this.gCs);
            this.bro.stopRecord();
            this.bro.release();
            this.bro = null;
        }
        if (this.gCd != null) {
            this.gCd.setOnTouchListener(null);
            this.gCd.bXl();
            this.gCd = null;
        }
        this.gBX = null;
        MessageManager.getInstance().unRegisterListener(this.gCq);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dz(int i) {
        this.gCd.dz(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gBX.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.gBX.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBY.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.gBY.setLayoutParams(layoutParams);
            if (this.gCi && this.bro != null && this.bro.getPreview() != null && this.bro.getPreview().getParent() == null) {
                bTk();
            }
        }
        if (this.gCo != null) {
            this.gCo.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.gBX.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gCo != null) {
            this.gCo.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gCo != null) {
            this.gCo.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bTt() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTu() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gCo != null && a.this.gCo.bUU() != null) {
                        a.this.gCo.bUU().sampleMemAndCPU();
                    }
                    a.this.bTu();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTv() {
        if (this.mHandler != null && this.bro != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.uo(0);
                    a.this.bTv();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo(int i) {
        if (this.gCo != null && this.gCo.bUU() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bro.getMediaStatus();
            if (this.gBJ != null && this.gBJ.bVC() != null && this.gBJ.bVC().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.gBJ.bVC().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.gBJ.bVC().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bro.getRecorderDebugInfo();
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
            if (this.gBX != null) {
                alaLiveExceptionInfo.appState = this.gBX.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.gCl;
            alaLiveExceptionInfo.sessionChannel = bTt();
            alaLiveExceptionInfo.nodeIP = this.bro.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.gCo.bUU().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.gCo.bUU().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.gCo.bUU().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gCo != null) {
            return this.gCo.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.gCp.f(s);
    }
}
