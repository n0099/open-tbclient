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
    private AlaLiveRecorder bxQ;
    private h fQL;
    private c gBQ;
    private com.baidu.live.tieba.e.b gEg;
    private d gTH;
    private AlaMasterLiveRoomActivity gTU;
    private ViewGroup gTV;
    private RelativeLayout gTW;
    private FrameLayout gTX;
    private AlaLiveFoucsExposureViewContainer gTY;
    private View gTZ;
    private AlaLiveView gUa;
    private ViewGroup gUb;
    private LayerRootView gUc;
    private String gUd;
    private int gUh;
    private short gUj;
    private com.baidu.live.ad.a gUk;
    private com.baidu.tieba.ala.liveroom.master.a.d gUl;
    private String mForumId;
    private String mForumName;
    private boolean gUe = false;
    private Handler mHandler = new Handler();
    private boolean gUf = false;
    private long gUg = 0;
    private int gUi = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b gUm = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.gUe = eVar.gPk;
                if (eVar.gPg) {
                    a.this.bYu();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void vn(int i) {
            if (i == 2) {
                a.this.bYn();
                if (a.this.gUf) {
                    a.this.vl(2);
                }
                a.this.bxQ.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bxQ.addRecorderCallback(a.this.gUp);
                a.this.gUa.setBackgroundColor(a.this.gTU.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.gUe) {
                    a.this.bxQ.switchOrientation(a.this.gUe);
                    a.this.bxQ.addRecorderCallback(a.this.gUp);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.gUj = s;
            if (a.this.gTU != null) {
                if (a.this.gUj == 1) {
                    a.this.gTU.bYg();
                } else {
                    a.this.gTU.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.gTH == null || a.this.gTH.Gm() == null || a.this.gTH.Gm().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.gTH.Gm().mLiveInfo.room_id;
                    j2 = a.this.gTH.Gm().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime"));
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ST() {
            if (a.this.gTZ != null) {
                if (a.this.gTZ.getParent() != null) {
                    ((ViewGroup) a.this.gTZ.getParent()).removeView(a.this.gTZ);
                }
                a.this.gTZ = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gTX.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.gTX.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bbd() {
            if (a.this.gTZ == null) {
                a.this.gTZ = a.this.bxQ.createPKPlayer();
            }
            if (a.this.gTZ != null && a.this.gTZ.getParent() == null) {
                a.this.gTX.addView(a.this.gTZ, a.this.bYr());
            }
            if (a.this.bxQ != null && a.this.bxQ.getPreview() != null) {
                FrameLayout.LayoutParams bYq = a.this.bYq();
                if (a.this.bxQ.getVideoConfig() != null) {
                    bYq.height = (a.this.bxQ.getVideoConfig().getVideoHeight() * bYq.width) / a.this.bxQ.getVideoConfig().getVideoWidth();
                }
                a.this.bxQ.getPreview().setLayoutParams(bYq);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bVR() {
            FrameLayout.LayoutParams bYq = a.this.bYq();
            int aC = com.baidu.live.utils.h.aC(a.this.gTU.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gTX.getLayoutParams();
            layoutParams.height = bYq.height;
            layoutParams.topMargin = aC;
            a.this.gTX.setLayoutParams(layoutParams);
            if (a.this.bxQ.getVideoConfig() != null) {
                bYq.height = (a.this.bxQ.getVideoConfig().getVideoHeight() * bYq.width) / a.this.bxQ.getVideoConfig().getVideoWidth();
            }
            a.this.bxQ.getPreview().setLayoutParams(bYq);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bVS() {
            a.this.bYn();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bVT() {
            a.this.bYo();
        }
    };
    private CustomMessageListener gUn = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bxQ.stopRecord();
                } else {
                    a.this.bxQ.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0170a gUo = new a.InterfaceC0170a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback gUp = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.gUl != null) {
                a.this.gUl.bZX();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.gUl != null) {
                a.this.gUl.bZX();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                a.this.gUl.bZZ().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.gUl != null) {
                a.this.gUl.streamStateReceived(i, z, i2, z2);
            }
            a.this.gUi = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.gUl != null) {
                if (z) {
                    a.this.gUl.be(0, null);
                } else {
                    a.this.gUl.be(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.gUl != null && a.this.gUl.bZZ() != null) {
                a.this.gUl.bZZ().errCode = 2;
                a.this.gUl.bf(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.gUl != null && a.this.gUl.bZZ() != null) {
                a.this.gUl.bZZ().linkTime = alaLiveDebugInfo.connectTime;
                a.this.gUl.bZZ().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.gUl.bZZ().startLiveTime == 0) {
                    a.this.gUl.bZZ().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.vm(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.gTU.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.bxQ != null && a.this.bxQ.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bxQ.getPreview() != null) {
                        a.this.bYn();
                    }
                    a.this.bxQ.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bxQ.addRecorderCallback(a.this.gUp);
                    a.this.bxQ.stopRecord();
                    if (a.this.bxQ.getPreview() != null) {
                        a.this.bYo();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bxQ != null) {
                                a.this.bxQ.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bxQ.changeVideoRecorderType(com.baidu.live.x.a.OS().blo != null ? com.baidu.live.x.a.OS().blo.aJZ : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bxQ.addRecorderCallback(a.this.gUp);
                if (a.this.bxQ.getPreview() != null) {
                    a.this.bYo();
                }
                i2 = -4;
            }
            if (a.this.gUl != null) {
                a.this.gUl.bf(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.gUl != null) {
                a.this.gUl.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.gUl != null) {
                a.this.gUl.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private d.a gUq = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.q.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                al caH = a.this.gTH.caH();
                if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                    a.this.gUl.bZZ().logID = caH.logId;
                    a.this.gUl.bZZ().errCode = 5;
                }
                if (!a.this.a(caH)) {
                    if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                        a.this.gUl.bZZ().updateTime = System.currentTimeMillis() - a.this.gUl.bZZ().updateTime;
                    }
                    if (caH.aMm != 1) {
                        if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                            a.this.gUl.bZZ().errSubReason = -1;
                        }
                        a.this.gTU.showToast(caH.aMn);
                        a.this.f((short) 1);
                        return;
                    }
                    if (caH.mErrorCode != 0) {
                        if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                            a.this.gUl.bZZ().errCode = 5;
                            a.this.gUl.bZZ().errSubReason = caH.mErrorCode;
                        }
                        a.this.gTU.showToast(str);
                        if (caH.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.gTU.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                            a.this.gUl.bZZ().errCode = 0;
                            a.this.gUl.bZZ().errSubReason = 0;
                        }
                        if (a.this.bxQ != null) {
                            a.this.bxQ.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.x.a.OS().blo.aKm);
                            a.this.bxQ.setStartInfo(Long.toString(a.this.gTH.Gm().mLiveInfo.live_id), a.this.gTH.Gm().mLiveInfo.getSessionID(), com.baidu.live.x.a.OS().blo.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.gUl != null) {
                            a.this.gUl.c(a.this.gTH.caH());
                        }
                        a.this.bYu();
                    }
                    if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                        a.this.gUl.bZZ().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.gUl != null) {
                    a.this.gUl.bZk();
                }
            } else if (i2 == 1) {
                a.this.bYv();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.gWO == 2) {
                                a.this.gUl.bZZ().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gWO == 3) {
                                a.this.gUl.bZZ().errSubReason = -3;
                            }
                        }
                        if (a.this.gUl != null && alaGetVerifyStrategyResponseHttpMessage.gWM == 1 && alaGetVerifyStrategyResponseHttpMessage.gWO == 1 && alaGetVerifyStrategyResponseHttpMessage.gWR == 1 && alaGetVerifyStrategyResponseHttpMessage.gWT == 1) {
                            a.this.gUl.bVO();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.gTU.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.gUl != null) {
                    a.this.gUl.bZw();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.gWO != 3 ? 0 : 3;
                    if (a.this.gUk != null && a.this.gUl != null) {
                        a.this.gUk.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.gUl.bVQ(), a.this.gUd).fO(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.gUl != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.gUl;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.mH(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.gTU = alaMasterLiveRoomActivity;
        this.gEg = new com.baidu.live.tieba.e.b(this.gTU.getActivity());
        bYy();
        this.gBQ = new c();
        MessageManager.getInstance().registerListener(this.gUn);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ad.a.class, this.gTU.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.gUk = (com.baidu.live.ad.a) runTask.getData();
            if (this.gUk != null) {
                this.gUk.a(this.gUo);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.gTH = dVar;
        if (this.gTH == null) {
            this.gTH = new d(this.gTU.getPageContext());
        }
        if (this.fQL == null && (runTask = MessageManager.getInstance().runTask(2913177, h.class, this.gTU.getPageContext().getPageActivity())) != null) {
            this.fQL = (h) runTask.getData();
        }
        if (this.fQL != null) {
            this.fQL.b(null);
            this.fQL.a(null);
        }
        this.gTH.a(this.gUq);
        if (this.gUl != null) {
            this.gUl.setArModel(this.fQL);
            this.gUl.a(this.gTH);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.gUd = str3;
        this.gUf = false;
        mW(false);
        bYs();
        if (this.gUl != null) {
            g gVar = new g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.gPv = bundle;
            this.gUl.b(gVar);
            if (this.gUl.bVQ() == 1) {
                vl(this.gUl.bVQ());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.gUh = alaLivePersonData.mLiveInfo.clarity;
        this.gUf = true;
        this.gUe = alaLivePersonData.mLiveInfo.screen_direction == 2;
        mW(true);
        bYs();
        if (this.gUl != null) {
            g gVar = new g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.gPu = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                vl(alaLivePersonData.mLiveInfo.live_type);
            }
            this.gUl.b(gVar);
        }
        if (this.gTH != null) {
            this.gTH.h(alaLivePersonData);
        }
    }

    private void bYl() {
        this.gUe = com.baidu.live.c.AZ().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bYm() {
        this.gUh = com.baidu.live.c.AZ().getInt("live_recorder_resolution_level", 2);
    }

    private void mW(boolean z) {
        if (!z) {
            bYm();
            bYl();
        }
        this.gTV = (ViewGroup) View.inflate(this.gTU.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.gTU.addContentView(this.gTV, new FrameLayout.LayoutParams(-1, -1));
        this.gTU.setContentView(this.gTV);
        this.gTX = (FrameLayout) this.gTV.findViewById(a.g.ala_live_render_view);
        this.gUa = (AlaLiveView) this.gTV.findViewById(a.g.ala_liveroom_host_liveview);
        this.gUa.setVisibility(8);
        this.gUa.setSwipeClearEnable(true);
        this.gTW = (RelativeLayout) this.gTV.findViewById(a.g.ala_live_unremovable_container);
        this.gUb = (ViewGroup) this.gTV.findViewById(a.g.func_view);
        this.gUc = (LayerRootView) this.gTV.findViewById(a.g.layer_root_view);
        com.baidu.live.core.layer.b.Dx().n(this.gUc);
        this.gTW.requestLayout();
        this.gTV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.gUa == null || a.this.gUa.heo) {
                    return false;
                }
                a.this.gUa.V(motionEvent);
                a.this.gTY.Q(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.Op().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.x.a.OS().blo != null && com.baidu.live.x.a.OS().blo.aKa) {
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
        if (bh.b(com.baidu.live.x.a.OS().bqJ)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bh.a(com.baidu.live.x.a.OS().bqJ)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bh.c(com.baidu.live.x.a.OS().bqJ)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bxQ = new AlaLiveRecorder(this.gTU.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bxQ.addRecorderCallback(this.gUp);
        LiveRecorderConfigHelper.Op().Or();
        if (!this.gUe && this.bxQ.getPreview() != null) {
            bYo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYn() {
        if (this.bxQ != null && this.bxQ.getPreview() != null && this.bxQ.getPreview().getParent() != null) {
            ((ViewGroup) this.bxQ.getPreview().getParent()).removeView(this.bxQ.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYo() {
        this.bxQ.getPreview().setEnabled(false);
        bYn();
        if (this.gTZ == null) {
            this.gTX.addView(this.bxQ.getPreview(), 0, bYp());
        } else {
            this.gTX.addView(this.bxQ.getPreview(), 0, bYq());
        }
        if (this.gTY == null) {
            this.gTY = new AlaLiveFoucsExposureViewContainer(this.gTX.getContext());
            this.gTY.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    if (a.this.bxQ != null) {
                        a.this.bxQ.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bxQ != null) {
                        a.this.bxQ.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public float getExposure() {
                    if (a.this.bxQ != null) {
                        return a.this.bxQ.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.gTX.addView(this.gTY, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams bYp() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bYq() {
        int i = BdUtilHelper.getScreenDimensions(this.gTU.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, com.baidu.live.utils.h.fP(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bYr() {
        int i = BdUtilHelper.getScreenDimensions(this.gTU.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, com.baidu.live.utils.h.fP(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl(int i) {
        if (this.gUf) {
            this.bxQ.setVideoConfig(LiveRecorderConfigHelper.Op().d(this.gUh, i, this.gUe));
        } else {
            this.bxQ.setVideoConfig(LiveRecorderConfigHelper.Op().d(i == 1 ? 0 : this.gUh, i, i == 1 ? this.gUe : false));
        }
    }

    private void bYs() {
        this.gUl = new com.baidu.tieba.ala.liveroom.master.a.d(this.gTU, this.bxQ, this.gUa, this.gTX, this.gTV, this.gUb, this.gEg, this.gTU.bYh());
        this.gUl.a(this.gTH);
        this.gUl.setArModel(this.fQL);
        this.gUl.a(this.gUm);
    }

    public void bYt() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gTU.getPageContext().getPageActivity());
        if (this.bxQ != null && this.bxQ.getPreview() != null && (this.gTZ == null || this.gTZ.getParent() == null)) {
            this.bxQ.getPreview().setLayoutParams(bYp());
        }
        if (this.gUl != null) {
            this.gUl.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.gTU.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gUl != null) {
            this.gUl.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
        if (this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null) {
            if (this.gUl != null && this.gUl.bZZ() != null) {
                this.gUl.bZZ().liveID = Long.toString(this.gTH.Gm().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.gTH.caH().mLiveInfo.live_id), String.valueOf(this.gTH.caH().mLiveInfo.room_id), String.valueOf(this.gTH.caH().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.gTH.caH().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.gTH.caH().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.gTH.caH().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.gUg = System.currentTimeMillis() / 1000;
            this.gTH.t(this.gTH.Gm().mLiveInfo.live_id, this.gUg);
            this.gTH.g(this.gTH.Gm().mLiveInfo.live_id, false);
            com.baidu.live.c.AZ().putLong("last_live_room_id", this.gTH.Gm().mLiveInfo.live_id);
            this.gTH.caM();
            if (this.gUl != null && this.gUl.bZZ() != null) {
                if (this.gUl.bVQ() == 2) {
                    if (this.gUe) {
                        this.gUl.bZZ().liveType = 5;
                    } else {
                        this.gUl.bZZ().liveType = 4;
                    }
                } else if (this.gUl.bVQ() == 1) {
                    if (this.gUe) {
                        this.gUl.bZZ().liveType = 2;
                    } else {
                        this.gUl.bZZ().liveType = 1;
                    }
                }
            }
            bYz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYv() {
        final u Gm = this.gTH.Gm();
        if (Gm != null && Gm.mLiveInfo != null) {
            if (this.gUl == null || !this.gUl.bZW()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gTH.t(Gm.mLiveInfo.live_id, a.this.gUg);
                    }
                }, Gm.aHI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(al alVar) {
        if (alVar == null) {
            return false;
        }
        this.gTU.closeLoadingDialog();
        if (alVar.mErrorCode == 6) {
            this.gTU.showToast(alVar.mErrorMsg);
            if (this.gUl != null && this.gUl.bZZ() != null) {
                this.gUl.bZZ().errSubReason = 6;
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
        if (eVar != null && !eVar.gPg) {
            boolean z = eVar.gPh;
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
            if (this.gUl != null) {
                if (this.gUl.bZZ() != null) {
                    this.gUl.bZZ().updateTime = System.currentTimeMillis();
                }
                this.gTH.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.gPi, eVar.gPj ? 1 : 0, this.gUl.bVQ(), this.gUe ? 2 : 1, this.gUh, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bYw() {
        if (this.gUl != null && !this.gUl.bZY() && this.gTH.caH() == null && this.gUl != null) {
            a(this.gUl.caa());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.gUl != null) {
            this.gUl.bZU();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bxQ != null) {
            this.bxQ.setIsAutoStartFromBack(true);
        }
        if (this.gUl != null) {
            this.gUl.bZV();
        }
    }

    public void onPause() {
        if (this.gUl != null) {
            this.gUl.onPause();
        }
    }

    public void onFinish() {
        if (this.gUl != null) {
            this.gUl.i(this.gUj);
        }
    }

    public void onDestroy() {
        if (this.gBQ != null) {
            this.gBQ.release();
            this.gBQ = null;
        }
        if (this.gUl != null) {
            this.gUl.onDestroy();
        }
        if (this.gUk != null) {
            this.gUk.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gEg.stop();
        this.gEg = null;
        if (this.gTH != null) {
            this.gTH.destory();
            this.gTH = null;
        }
        if (this.fQL != null) {
            this.fQL.destory();
            this.fQL = null;
        }
        if (this.bxQ != null) {
            ae aeVar = new ae();
            aeVar.aIV = this.gUe ? 2 : 1;
            aeVar.mOpenType = 2;
            if (this.gUl != null) {
                aeVar.aIU = this.gUl.bVQ();
            }
            this.bxQ.setRoomInfo(aeVar.toJsonString());
            String str = "";
            if (this.gUl != null && this.gUl.bZZ() != null) {
                if (this.gUl.bZZ().startLiveTime != 0) {
                    str = Long.toString(this.gUl.bZZ().startLiveTime);
                }
                this.bxQ.setConfigBeforeStop(this.gUl.bZZ().getCpuMemJsonFormat(), str, "");
            }
            this.bxQ.removeRecorderCallback(this.gUp);
            this.bxQ.stopRecord();
            this.bxQ.release();
            this.bxQ = null;
        }
        if (this.gUa != null) {
            this.gUa.setOnTouchListener(null);
            this.gUa.ccq();
            this.gUa = null;
        }
        this.gTU = null;
        MessageManager.getInstance().unRegisterListener(this.gUn);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dI(int i) {
        this.gUa.dI(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gTU.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.gTU.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gTV.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.gTV.setLayoutParams(layoutParams);
            if (this.gUf && this.bxQ != null && this.bxQ.getPreview() != null && this.bxQ.getPreview().getParent() == null) {
                bYo();
            }
        }
        if (this.gUl != null) {
            this.gUl.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.gTU.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gUl != null) {
            this.gUl.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gUl != null) {
            this.gUl.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bYx() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYy() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gUl != null && a.this.gUl.bZZ() != null) {
                        a.this.gUl.bZZ().sampleMemAndCPU();
                    }
                    a.this.bYy();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYz() {
        if (this.mHandler != null && this.bxQ != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.vm(0);
                    a.this.bYz();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm(int i) {
        if (this.gUl != null && this.gUl.bZZ() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bxQ.getMediaStatus();
            if (this.gTH != null && this.gTH.caH() != null && this.gTH.caH().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.gTH.caH().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.gTH.caH().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bxQ.getRecorderDebugInfo();
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
            if (this.gTU != null) {
                alaLiveExceptionInfo.appState = this.gTU.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.gUi;
            alaLiveExceptionInfo.sessionChannel = bYx();
            alaLiveExceptionInfo.nodeIP = this.bxQ.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.gUl.bZZ().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.gUl.bZZ().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.gUl.bZZ().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gUl != null) {
            return this.gUl.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.gUm.f(s);
    }
}
