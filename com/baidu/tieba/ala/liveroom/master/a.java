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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.ak.a;
import com.baidu.live.ar.k;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.ab;
import com.baidu.live.data.ap;
import com.baidu.live.data.aw;
import com.baidu.live.data.bt;
import com.baidu.live.message.e;
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
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.n.c;
import com.baidu.tieba.ala.liveroom.n.d;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private k bEu;
    private AlaLiveRecorder bEw;
    private d hFX;
    private com.baidu.tieba.ala.liveroom.master.a.d hGA;
    private AlaMasterLiveRoomActivity hGj;
    private ViewGroup hGk;
    private RelativeLayout hGl;
    private FrameLayout hGm;
    private AlaLiveFoucsExposureViewContainer hGn;
    private View hGo;
    private AlaLiveView hGp;
    private ViewGroup hGq;
    private LayerRootView hGr;
    private String hGs;
    private int hGw;
    private short hGy;
    private com.baidu.live.ak.a hGz;
    private c hox;
    private com.baidu.live.tieba.e.b hqw;
    private String mForumId;
    private String mForumName;
    private boolean hGt = false;
    private Handler mHandler = new Handler();
    private boolean hGu = false;
    private long hGv = 0;
    private int hGx = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hGB = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.hGt = dVar.hBI;
                if (dVar.hBE) {
                    a.this.cgW();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void vN(int i) {
            if (i == 2) {
                a.this.SF();
                if (a.this.hGu) {
                    a.this.vL(2);
                }
                a.this.bEw.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bEw.addRecorderCallback(a.this.hGE);
                a.this.hGp.setBackgroundColor(a.this.hGj.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.hGt) {
                    a.this.bEw.switchOrientation(a.this.hGt);
                    a.this.bEw.addRecorderCallback(a.this.hGE);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2;
            a.this.hGy = s;
            if (a.this.hGj != null) {
                if (a.this.hGy == 1) {
                    a.this.hGj.cgK();
                } else {
                    a.this.hGj.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hFX == null || a.this.hFX.Fm() == null || a.this.hFX.Fm().mLiveInfo == null) {
                    j = -1;
                    j2 = -1;
                } else {
                    long j3 = a.this.hFX.Fm().mLiveInfo.room_id;
                    j = a.this.hFX.Fm().mLiveInfo.live_id;
                    j2 = j3;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j, j2);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime"));
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void Xi() {
            if (a.this.hGo != null) {
                if (a.this.hGo.getParent() != null) {
                    ((ViewGroup) a.this.hGo.getParent()).removeView(a.this.hGo);
                }
                a.this.hGo = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hGm.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hGm.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceA() {
            if (a.this.hGo == null) {
                a.this.hGo = a.this.bEw.createPKPlayer();
            }
            if (a.this.hGo != null && a.this.hGo.getParent() == null) {
                a.this.hGm.addView(a.this.hGo, a.this.cgT());
            }
            if (a.this.bEw != null && a.this.bEw.getPreview() != null) {
                FrameLayout.LayoutParams cgS = a.this.cgS();
                if (a.this.bEw.getVideoConfig() != null) {
                    cgS.height = (a.this.bEw.getVideoConfig().getVideoHeight() * cgS.width) / a.this.bEw.getVideoConfig().getVideoWidth();
                }
                a.this.bEw.getPreview().setLayoutParams(cgS);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceB() {
            FrameLayout.LayoutParams cgS = a.this.cgS();
            int bm = h.bm(a.this.hGj.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hGm.getLayoutParams();
            layoutParams.height = cgS.height;
            layoutParams.topMargin = bm;
            a.this.hGm.setLayoutParams(layoutParams);
            if (a.this.bEw.getVideoConfig() != null) {
                cgS.height = (a.this.bEw.getVideoConfig().getVideoHeight() * cgS.width) / a.this.bEw.getVideoConfig().getVideoWidth();
            }
            a.this.bEw.getPreview().setLayoutParams(cgS);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceC() {
            a.this.SF();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceD() {
            a.this.cgR();
        }
    };
    private CustomMessageListener hGC = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bEw.stopRecord();
                } else {
                    a.this.bEw.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0158a hGD = new a.InterfaceC0158a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hGE = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hGA != null) {
                a.this.hGA.ciE();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hGA != null) {
                a.this.hGA.ciE();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                a.this.hGA.ciG().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hGA != null) {
                a.this.hGA.streamStateReceived(i, z, i2, z2);
            }
            a.this.hGx = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hGA != null) {
                if (z) {
                    a.this.hGA.bq(0, null);
                } else {
                    a.this.hGA.bq(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hGA != null && a.this.hGA.ciG() != null) {
                a.this.hGA.ciG().errCode = 2;
                a.this.hGA.br(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hGA != null && a.this.hGA.ciG() != null) {
                a.this.hGA.ciG().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hGA.ciG().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hGA.ciG().startLiveTime == 0) {
                    a.this.hGA.ciG().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.vM(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hGj.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bEw != null && a.this.bEw.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bEw.getPreview() != null) {
                        a.this.SF();
                    }
                    a.this.bEw.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bEw.addRecorderCallback(a.this.hGE);
                    a.this.bEw.stopRecord();
                    if (a.this.bEw.getPreview() != null) {
                        a.this.cgR();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bEw != null) {
                                a.this.bEw.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bEw.changeVideoRecorderType(com.baidu.live.ae.a.Qj().buX != null ? com.baidu.live.ae.a.Qj().buX.aLm : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bEw.addRecorderCallback(a.this.hGE);
                if (a.this.bEw.getPreview() != null) {
                    a.this.cgR();
                }
                i2 = -4;
            }
            if (a.this.hGA != null) {
                a.this.hGA.br(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hGA != null) {
                a.this.hGA.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hGA != null) {
                a.this.hGA.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void sendBufferChanged(int i) {
            if (a.this.hGA != null) {
                a.this.hGA.sendBufferChanged(i);
            }
        }
    };
    private d.a hGF = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.n.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                aw cjo = a.this.hFX.cjo();
                if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                    a.this.hGA.ciG().logID = cjo.logId;
                    a.this.hGA.ciG().errCode = 5;
                }
                if (!a.this.a(cjo)) {
                    if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                        a.this.hGA.ciG().updateTime = System.currentTimeMillis() - a.this.hGA.ciG().updateTime;
                    }
                    if (cjo.aOd != 1) {
                        if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                            a.this.hGA.ciG().errSubReason = -1;
                        }
                        a.this.hGj.showToast(cjo.aOe);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cjo.mErrorCode != 0) {
                        if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                            a.this.hGA.ciG().errCode = 5;
                            a.this.hGA.ciG().errSubReason = cjo.mErrorCode;
                        }
                        a.this.hGj.showToast(str);
                        if (cjo.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hGj.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                            a.this.hGA.ciG().errCode = 0;
                            a.this.hGA.ciG().errSubReason = 0;
                        }
                        if (a.this.bEw != null) {
                            a.this.bEw.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.ae.a.Qj().buX.aLz);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("clientIp", com.baidu.live.ae.a.Qj().buX.clientIP);
                                jSONObject.put("liveId", a.this.hFX.Fm().mLiveInfo.live_id);
                                jSONObject.put("roomId", a.this.hFX.Fm().mLiveInfo.room_id);
                                jSONObject.put("subApp", TbConfig.getSubappType());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            a.this.bEw.setStartInfo(jSONObject);
                        }
                        if (a.this.hGA != null) {
                            a.this.hGA.c(a.this.hFX.cjo());
                        }
                        a.this.cgW();
                    }
                    if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                        a.this.hGA.ciG().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hGA != null) {
                    a.this.hGA.chS();
                }
            } else if (i2 == 1) {
                a.this.cgX();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hJm == 2) {
                                a.this.hGA.ciG().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hJm == 3) {
                                a.this.hGA.ciG().errSubReason = -3;
                            }
                        }
                        if (a.this.hGA != null && alaGetVerifyStrategyResponseHttpMessage.hJk == 1 && alaGetVerifyStrategyResponseHttpMessage.hJm == 1 && alaGetVerifyStrategyResponseHttpMessage.hJp == 1 && alaGetVerifyStrategyResponseHttpMessage.hJr == 1) {
                            a.this.hGA.cey();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hGj.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hGA != null) {
                    a.this.hGA.cie();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hJm != 3 ? 0 : 3;
                    if (a.this.hGz != null && a.this.hGA != null) {
                        a.this.hGz.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hGA.bQY(), a.this.hGs).eZ(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hGA != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hGA;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.oj(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hGj = alaMasterLiveRoomActivity;
        this.hqw = new com.baidu.live.tieba.e.b(this.hGj.getActivity());
        cha();
        this.hox = new c();
        MessageManager.getInstance().registerListener(this.hGC);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ak.a.class, this.hGj.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hGz = (com.baidu.live.ak.a) runTask.getData();
            if (this.hGz != null) {
                this.hGz.a(this.hGD);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.hFX = dVar;
        if (this.hFX == null) {
            this.hFX = new d(this.hGj.getPageContext());
        }
        if (this.bEu == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.hGj.getPageContext().getPageActivity())) != null) {
            this.bEu = (k) runTask.getData();
        }
        if (this.bEu != null) {
            this.bEu.b(null);
            this.bEu.a(null);
            this.bEu.c(null);
        }
        this.hFX.a(this.hGF);
        if (this.hGA != null) {
            this.hGA.setArModel(this.bEu);
            this.hGA.a(this.hFX);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hGs = str3;
        this.hGu = false;
        ox(false);
        cgU();
        if (this.hGA != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hBU = bundle;
            this.hGA.b(fVar);
            if (this.hGA.bQY() == 1) {
                vL(this.hGA.bQY());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hGw = alaLivePersonData.mLiveInfo.clarity;
        this.hGu = true;
        this.hGt = alaLivePersonData.mLiveInfo.screen_direction == 2;
        ox(true);
        cgU();
        if (this.hGA != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hBT = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                vL(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hGA.b(fVar);
        }
        if (this.hFX != null) {
            this.hFX.h(alaLivePersonData);
        }
    }

    private void cgP() {
        this.hGt = com.baidu.live.d.xc().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cgQ() {
        this.hGw = com.baidu.live.d.xc().getInt("live_recorder_resolution_level", 2);
    }

    private void ox(boolean z) {
        if (!z) {
            cgQ();
            cgP();
        }
        this.hGk = (ViewGroup) View.inflate(this.hGj.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.hGj.addContentView(this.hGk, new FrameLayout.LayoutParams(-1, -1));
        this.hGj.setContentView(this.hGk);
        this.hGm = (FrameLayout) this.hGk.findViewById(a.f.ala_live_render_view);
        this.hGp = (AlaLiveView) this.hGk.findViewById(a.f.ala_liveroom_host_liveview);
        this.hGp.setVisibility(8);
        this.hGp.setSwipeClearEnable(true);
        this.hGl = (RelativeLayout) this.hGk.findViewById(a.f.ala_live_unremovable_container);
        this.hGq = (ViewGroup) this.hGk.findViewById(a.f.func_view);
        this.hGr = (LayerRootView) this.hGk.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.Bc().l(this.hGr);
        this.hGl.requestLayout();
        this.hGk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hGp == null || a.this.hGp.hRj) {
                    return false;
                }
                a.this.hGp.X(motionEvent);
                a.this.hGn.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = com.baidu.live.z.a.b.PF().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aLn) {
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
        if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bt.a(com.baidu.live.ae.a.Qj().bAS)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bEw = new AlaLiveRecorder(this.hGj.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, new com.baidu.live.z.a.a(), videoBeautyType3);
        this.bEw.addRecorderCallback(this.hGE);
        boolean z2 = com.baidu.live.ae.a.Qj().buX.aLd;
        this.bEw.setUseDummyVideoCapture(z2);
        this.bEw.setUseDummyAudioCapture(z2);
        com.baidu.live.z.a.b.PF().PH();
        if (!this.hGt && this.bEw.getPreview() != null) {
            cgR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SF() {
        if (this.bEw != null && this.bEw.getPreview() != null && this.bEw.getPreview().getParent() != null) {
            ((ViewGroup) this.bEw.getPreview().getParent()).removeView(this.bEw.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgR() {
        this.bEw.getPreview().setEnabled(false);
        SF();
        if (this.hGo == null) {
            this.hGm.addView(this.bEw.getPreview(), 0, SE());
        } else {
            this.hGm.addView(this.bEw.getPreview(), 0, cgS());
        }
        if (this.hGn == null) {
            this.hGn = new AlaLiveFoucsExposureViewContainer(this.hGm.getContext());
            this.hGn.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hFX != null && a.this.hFX.Fm() != null) {
                        alaLiveInfoData = a.this.hFX.Fm().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bEw != null) {
                        a.this.bEw.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bEw != null) {
                        a.this.bEw.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void chc() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hFX != null && a.this.hFX.Fm() != null) {
                        alaLiveInfoData = a.this.hFX.Fm().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "biasbar_click").setContentExt(jSONObject));
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public float getExposure() {
                    if (a.this.bEw != null) {
                        return a.this.bEw.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hGm.addView(this.hGn, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams SE() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cgS() {
        int i = BdUtilHelper.getScreenDimensions(this.hGj.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fa(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cgT() {
        int i = BdUtilHelper.getScreenDimensions(this.hGj.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fa(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL(int i) {
        if (this.hGu) {
            this.bEw.setVideoConfig(com.baidu.live.z.a.b.PF().d(this.hGw, i, this.hGt));
        } else {
            this.bEw.setVideoConfig(com.baidu.live.z.a.b.PF().d(i == 1 ? 0 : this.hGw, i, i == 1 ? this.hGt : false));
        }
    }

    private void cgU() {
        this.hGA = new com.baidu.tieba.ala.liveroom.master.a.d(this.hGj, this.bEw, this.hGp, this.hGm, this.hGk, this.hGq, this.hqw, this.hGj.cgL(), this.hGn);
        this.hGA.a(this.hFX);
        this.hGA.setArModel(this.bEu);
        this.hGA.a(this.hGB);
    }

    public void cgV() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hGj.getPageContext().getPageActivity());
        if (this.bEw != null && this.bEw.getPreview() != null && (this.hGo == null || this.hGo.getParent() == null)) {
            this.bEw.getPreview().setLayoutParams(SE());
        }
        if (this.hGA != null) {
            this.hGA.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hGj.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hGA != null) {
            this.hGA.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgW() {
        if (this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null) {
            if (this.hGA != null && this.hGA.ciG() != null) {
                this.hGA.ciG().liveID = Long.toString(this.hFX.Fm().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hFX.cjo().mLiveInfo.live_id), String.valueOf(this.hFX.cjo().mLiveInfo.room_id), String.valueOf(this.hFX.cjo().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hFX.cjo().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hFX.cjo().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hFX.cjo().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime").setContentExt(jSONObject));
            this.hGv = System.currentTimeMillis() / 1000;
            this.hFX.B(this.hFX.Fm().mLiveInfo.live_id, this.hGv);
            this.hFX.j(this.hFX.Fm().mLiveInfo.live_id, false);
            com.baidu.live.d.xc().putLong("last_live_room_id", this.hFX.Fm().mLiveInfo.live_id);
            this.hFX.cjt();
            if (this.hGA != null && this.hGA.ciG() != null) {
                if (this.hGA.bQY() == 2) {
                    if (this.hGt) {
                        this.hGA.ciG().liveType = 5;
                    } else {
                        this.hGA.ciG().liveType = 4;
                    }
                } else if (this.hGA.bQY() == 1) {
                    if (this.hGt) {
                        this.hGA.ciG().liveType = 2;
                    } else {
                        this.hGA.ciG().liveType = 1;
                    }
                }
            }
            chb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgX() {
        final ab Fm = this.hFX.Fm();
        if (Fm != null && Fm.mLiveInfo != null) {
            if (this.hGA == null || !this.hGA.ciD()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hFX.B(Fm.mLiveInfo.live_id, a.this.hGv);
                    }
                }, Fm.aIi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aw awVar) {
        if (awVar == null) {
            return false;
        }
        this.hGj.closeLoadingDialog();
        if (awVar.mErrorCode == 6) {
            this.hGj.showToast(awVar.mErrorMsg);
            if (this.hGA != null && this.hGA.ciG() != null) {
                this.hGA.ciG().errSubReason = 6;
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
        if (dVar != null && !dVar.hBE) {
            boolean z = dVar.hBF;
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
            if (this.hGA != null) {
                if (this.hGA.ciG() != null) {
                    this.hGA.ciG().updateTime = System.currentTimeMillis();
                }
                this.hFX.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hBG, dVar.hBH ? 1 : 0, this.hGA.bQY(), this.hGt ? 2 : 1, this.hGw, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void cgY() {
        if (this.hGA != null && !this.hGA.ciF() && this.hFX.cjo() == null && this.hGA != null) {
            a(this.hGA.ciH());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hGA != null) {
            this.hGA.markEnterBackground();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bEw != null) {
            this.bEw.setIsAutoStartFromBack(true);
        }
        if (this.hGA != null) {
            this.hGA.markEnterForeground();
        }
    }

    public void onPause() {
        if (this.hGA != null) {
            this.hGA.onPause();
        }
    }

    public void onFinish() {
        if (this.hGA != null) {
            this.hGA.j(this.hGy);
        }
    }

    public void onDestroy() {
        if (this.hox != null) {
            this.hox.release();
            this.hox = null;
        }
        if (this.hGA != null) {
            this.hGA.onDestroy();
        }
        if (this.hGz != null) {
            this.hGz.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.hqw.stop();
        this.hqw = null;
        if (this.hFX != null) {
            this.hFX.destory();
            this.hFX = null;
        }
        if (this.bEu != null) {
            this.bEu.destory();
            this.bEu = null;
        }
        if (this.bEw != null) {
            ap apVar = new ap();
            apVar.aKb = this.hGt ? 2 : 1;
            apVar.mOpenType = 2;
            if (this.hGA != null) {
                apVar.aKa = this.hGA.bQY();
            }
            this.bEw.setRoomInfo(apVar.toJsonString());
            String str = "";
            if (this.hGA != null && this.hGA.ciG() != null) {
                if (this.hGA.ciG().startLiveTime != 0) {
                    str = Long.toString(this.hGA.ciG().startLiveTime);
                }
                this.bEw.setConfigBeforeStop(this.hGA.ciG().getCpuMemJsonFormat(), str, "");
            }
            this.bEw.stopRecord();
            this.bEw.release();
            this.bEw.removeRecorderCallback(this.hGE);
            this.bEw = null;
        }
        if (this.hGp != null) {
            this.hGp.setOnTouchListener(null);
            this.hGp.clk();
            this.hGp = null;
        }
        this.hGj = null;
        MessageManager.getInstance().unRegisterListener(this.hGC);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void cr(int i) {
        this.hGp.cr(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hGj.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hGj.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hGk.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hGk.setLayoutParams(layoutParams);
            if (this.hGu && this.bEw != null && this.bEw.getPreview() != null && this.bEw.getPreview().getParent() == null) {
                cgR();
            }
        }
        if (this.hGA != null) {
            this.hGA.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hGj.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hGA != null) {
            this.hGA.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hGA != null) {
            this.hGA.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int cgZ() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cha() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hGA != null && a.this.hGA.ciG() != null) {
                        a.this.hGA.ciG().sampleMemAndCPU();
                    }
                    a.this.cha();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chb() {
        if (this.mHandler != null && this.bEw != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.vM(0);
                    a.this.chb();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM(int i) {
        if (this.hGA != null && this.hGA.ciG() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bEw.getMediaStatus();
            if (this.hFX != null && this.hFX.cjo() != null && this.hFX.cjo().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hFX.cjo().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hFX.cjo().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bEw.getRecorderDebugInfo();
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
            if (this.hGj != null) {
                alaLiveExceptionInfo.appState = this.hGj.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hGx;
            alaLiveExceptionInfo.sessionChannel = cgZ();
            alaLiveExceptionInfo.nodeIP = this.bEw.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hGA.ciG().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hGA.ciG().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hGA.ciG().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hGA != null) {
            return this.hGA.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hGB.g(s);
    }

    public void VC() {
        if (this.hGA != null) {
            this.hGA.VC();
        }
    }
}
