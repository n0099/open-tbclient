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
import com.baidu.live.am.a;
import com.baidu.live.ar.k;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.al;
import com.baidu.live.data.as;
import com.baidu.live.data.bo;
import com.baidu.live.data.x;
import com.baidu.live.message.e;
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
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.p.c;
import com.baidu.tieba.ala.liveroom.p.d;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private k bFA;
    private AlaLiveRecorder bFC;
    private AlaMasterLiveRoomActivity hGG;
    private ViewGroup hGH;
    private RelativeLayout hGI;
    private FrameLayout hGJ;
    private AlaLiveFoucsExposureViewContainer hGK;
    private View hGL;
    private AlaLiveView hGM;
    private ViewGroup hGN;
    private LayerRootView hGO;
    private String hGP;
    private int hGT;
    private short hGV;
    private com.baidu.live.am.a hGW;
    private d hGX;
    private com.baidu.tieba.ala.liveroom.p.d hGu;
    private c hoM;
    private com.baidu.live.tieba.e.b hqP;
    private String mForumId;
    private String mForumName;
    private boolean hGQ = false;
    private Handler mHandler = new Handler();
    private boolean hGR = false;
    private long hGS = 0;
    private int hGU = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hGY = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.hGQ = dVar.hCe;
                if (dVar.hCa) {
                    a.this.cjU();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void xi(int i) {
            if (i == 2) {
                a.this.UQ();
                if (a.this.hGR) {
                    a.this.xg(2);
                }
                a.this.bFC.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bFC.addRecorderCallback(a.this.hHb);
                a.this.hGM.setBackgroundColor(a.this.hGG.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.hGQ) {
                    a.this.bFC.switchOrientation(a.this.hGQ);
                    a.this.bFC.addRecorderCallback(a.this.hHb);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2;
            a.this.hGV = s;
            if (a.this.hGG != null) {
                if (a.this.hGV == 1) {
                    a.this.hGG.cjI();
                } else {
                    a.this.hGG.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hGu == null || a.this.hGu.HR() == null || a.this.hGu.HR().mLiveInfo == null) {
                    j = -1;
                    j2 = -1;
                } else {
                    long j3 = a.this.hGu.HR().mLiveInfo.room_id;
                    j = a.this.hGu.HR().mLiveInfo.live_id;
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
        public void Zr() {
            if (a.this.hGL != null) {
                if (a.this.hGL.getParent() != null) {
                    ((ViewGroup) a.this.hGL.getParent()).removeView(a.this.hGL);
                }
                a.this.hGL = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hGJ.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hGJ.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void chw() {
            if (a.this.hGL == null) {
                a.this.hGL = a.this.bFC.createPKPlayer();
            }
            if (a.this.hGL != null && a.this.hGL.getParent() == null) {
                a.this.hGJ.addView(a.this.hGL, a.this.cjR());
            }
            if (a.this.bFC != null && a.this.bFC.getPreview() != null) {
                FrameLayout.LayoutParams cjQ = a.this.cjQ();
                if (a.this.bFC.getVideoConfig() != null) {
                    cjQ.height = (a.this.bFC.getVideoConfig().getVideoHeight() * cjQ.width) / a.this.bFC.getVideoConfig().getVideoWidth();
                }
                a.this.bFC.getPreview().setLayoutParams(cjQ);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void chx() {
            FrameLayout.LayoutParams cjQ = a.this.cjQ();
            int bn = h.bn(a.this.hGG.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hGJ.getLayoutParams();
            layoutParams.height = cjQ.height;
            layoutParams.topMargin = bn;
            a.this.hGJ.setLayoutParams(layoutParams);
            if (a.this.bFC.getVideoConfig() != null) {
                cjQ.height = (a.this.bFC.getVideoConfig().getVideoHeight() * cjQ.width) / a.this.bFC.getVideoConfig().getVideoWidth();
            }
            a.this.bFC.getPreview().setLayoutParams(cjQ);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void chy() {
            a.this.UQ();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void chz() {
            a.this.cjP();
        }
    };
    private CustomMessageListener hGZ = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bFC.stopRecord();
                } else {
                    a.this.bFC.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0172a hHa = new a.InterfaceC0172a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hHb = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hGX != null) {
                a.this.hGX.clC();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hGX != null) {
                a.this.hGX.clC();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hGX != null && a.this.hGX.clE() != null) {
                a.this.hGX.clE().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hGX != null) {
                a.this.hGX.streamStateReceived(i, z, i2, z2);
            }
            a.this.hGU = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hGX != null) {
                if (z) {
                    a.this.hGX.bk(0, null);
                } else {
                    a.this.hGX.bk(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hGX != null && a.this.hGX.clE() != null) {
                a.this.hGX.clE().errCode = 2;
                a.this.hGX.bl(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hGX != null && a.this.hGX.clE() != null) {
                a.this.hGX.clE().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hGX.clE().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hGX.clE().startLiveTime == 0) {
                    a.this.hGX.clE().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.xh(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hGG.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bFC != null && a.this.bFC.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bFC.getPreview() != null) {
                        a.this.UQ();
                    }
                    a.this.bFC.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bFC.addRecorderCallback(a.this.hHb);
                    a.this.bFC.stopRecord();
                    if (a.this.bFC.getPreview() != null) {
                        a.this.cjP();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bFC != null) {
                                a.this.bFC.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bFC.changeVideoRecorderType(com.baidu.live.af.a.SE().bwi != null ? com.baidu.live.af.a.SE().bwi.aNp : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bFC.addRecorderCallback(a.this.hHb);
                if (a.this.bFC.getPreview() != null) {
                    a.this.cjP();
                }
                i2 = -4;
            }
            if (a.this.hGX != null) {
                a.this.hGX.bl(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hGX != null) {
                a.this.hGX.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hGX != null) {
                a.this.hGX.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void sendBufferChanged(int i) {
            if (a.this.hGX != null) {
                a.this.hGX.sendBufferChanged(i);
            }
        }
    };
    private d.a hHc = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.p.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                as cmm = a.this.hGu.cmm();
                if (a.this.hGX != null && a.this.hGX.clE() != null) {
                    a.this.hGX.clE().logID = cmm.logId;
                    a.this.hGX.clE().errCode = 5;
                }
                if (!a.this.a(cmm)) {
                    if (a.this.hGX != null && a.this.hGX.clE() != null) {
                        a.this.hGX.clE().updateTime = System.currentTimeMillis() - a.this.hGX.clE().updateTime;
                    }
                    if (cmm.aPU != 1) {
                        if (a.this.hGX != null && a.this.hGX.clE() != null) {
                            a.this.hGX.clE().errSubReason = -1;
                        }
                        a.this.hGG.showToast(cmm.aPV);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cmm.mErrorCode != 0) {
                        if (a.this.hGX != null && a.this.hGX.clE() != null) {
                            a.this.hGX.clE().errCode = 5;
                            a.this.hGX.clE().errSubReason = cmm.mErrorCode;
                        }
                        a.this.hGG.showToast(str);
                        if (cmm.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hGG.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hGX != null && a.this.hGX.clE() != null) {
                            a.this.hGX.clE().errCode = 0;
                            a.this.hGX.clE().errSubReason = 0;
                        }
                        if (a.this.bFC != null) {
                            a.this.bFC.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.af.a.SE().bwi.aNC);
                            a.this.bFC.setStartInfo(Long.toString(a.this.hGu.HR().mLiveInfo.live_id), a.this.hGu.HR().mLiveInfo.getSessionID(), com.baidu.live.af.a.SE().bwi.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.hGX != null) {
                            a.this.hGX.c(a.this.hGu.cmm());
                        }
                        a.this.cjU();
                    }
                    if (a.this.hGX != null && a.this.hGX.clE() != null) {
                        a.this.hGX.clE().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hGX != null) {
                    a.this.hGX.ckQ();
                }
            } else if (i2 == 1) {
                a.this.cjV();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hGX != null && a.this.hGX.clE() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hJG == 2) {
                                a.this.hGX.clE().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hJG == 3) {
                                a.this.hGX.clE().errSubReason = -3;
                            }
                        }
                        if (a.this.hGX != null && alaGetVerifyStrategyResponseHttpMessage.hJE == 1 && alaGetVerifyStrategyResponseHttpMessage.hJG == 1 && alaGetVerifyStrategyResponseHttpMessage.hJJ == 1 && alaGetVerifyStrategyResponseHttpMessage.hJL == 1) {
                            a.this.hGX.chu();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hGG.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hGX != null) {
                    a.this.hGX.clc();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hJG != 3 ? 0 : 3;
                    if (a.this.hGW != null && a.this.hGX != null) {
                        a.this.hGW.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hGX.bUl(), a.this.hGP).gC(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hGX != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hGX;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.oc(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hGG = alaMasterLiveRoomActivity;
        this.hqP = new com.baidu.live.tieba.e.b(this.hGG.getActivity());
        cjY();
        this.hoM = new c();
        MessageManager.getInstance().registerListener(this.hGZ);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.am.a.class, this.hGG.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hGW = (com.baidu.live.am.a) runTask.getData();
            if (this.hGW != null) {
                this.hGW.a(this.hHa);
            }
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        CustomResponsedMessage runTask;
        this.hGu = dVar;
        if (this.hGu == null) {
            this.hGu = new com.baidu.tieba.ala.liveroom.p.d(this.hGG.getPageContext());
        }
        if (this.bFA == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.hGG.getPageContext().getPageActivity())) != null) {
            this.bFA = (k) runTask.getData();
        }
        if (this.bFA != null) {
            this.bFA.b(null);
            this.bFA.a(null);
            this.bFA.c(null);
        }
        this.hGu.a(this.hHc);
        if (this.hGX != null) {
            this.hGX.setArModel(this.bFA);
            this.hGX.a(this.hGu);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hGP = str3;
        this.hGR = false;
        or(false);
        cjS();
        if (this.hGX != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hCq = bundle;
            this.hGX.b(fVar);
            if (this.hGX.bUl() == 1) {
                xg(this.hGX.bUl());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hGT = alaLivePersonData.mLiveInfo.clarity;
        this.hGR = true;
        this.hGQ = alaLivePersonData.mLiveInfo.screen_direction == 2;
        or(true);
        cjS();
        if (this.hGX != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hCp = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                xg(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hGX.b(fVar);
        }
        if (this.hGu != null) {
            this.hGu.h(alaLivePersonData);
        }
    }

    private void cjN() {
        this.hGQ = com.baidu.live.d.Ba().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void cjO() {
        this.hGT = com.baidu.live.d.Ba().getInt("live_recorder_resolution_level", 2);
    }

    private void or(boolean z) {
        if (!z) {
            cjO();
            cjN();
        }
        this.hGH = (ViewGroup) View.inflate(this.hGG.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.hGG.addContentView(this.hGH, new FrameLayout.LayoutParams(-1, -1));
        this.hGG.setContentView(this.hGH);
        this.hGJ = (FrameLayout) this.hGH.findViewById(a.f.ala_live_render_view);
        this.hGM = (AlaLiveView) this.hGH.findViewById(a.f.ala_liveroom_host_liveview);
        this.hGM.setVisibility(8);
        this.hGM.setSwipeClearEnable(true);
        this.hGI = (RelativeLayout) this.hGH.findViewById(a.f.ala_live_unremovable_container);
        this.hGN = (ViewGroup) this.hGH.findViewById(a.f.func_view);
        this.hGO = (LayerRootView) this.hGH.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.En().l(this.hGO);
        this.hGI.requestLayout();
        this.hGH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hGM == null || a.this.hGM.hRv) {
                    return false;
                }
                a.this.hGM.W(motionEvent);
                a.this.hGK.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.Sb().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aNq) {
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
        if (bo.b(com.baidu.live.af.a.SE().bCb)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bo.a(com.baidu.live.af.a.SE().bCb)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bo.c(com.baidu.live.af.a.SE().bCb)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bFC = new AlaLiveRecorder(this.hGG.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, new com.baidu.live.recorder.helper.a(), videoBeautyType3);
        this.bFC.addRecorderCallback(this.hHb);
        LiveRecorderConfigHelper.Sb().Sd();
        if (!this.hGQ && this.bFC.getPreview() != null) {
            cjP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UQ() {
        if (this.bFC != null && this.bFC.getPreview() != null && this.bFC.getPreview().getParent() != null) {
            ((ViewGroup) this.bFC.getPreview().getParent()).removeView(this.bFC.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjP() {
        this.bFC.getPreview().setEnabled(false);
        UQ();
        if (this.hGL == null) {
            this.hGJ.addView(this.bFC.getPreview(), 0, UP());
        } else {
            this.hGJ.addView(this.bFC.getPreview(), 0, cjQ());
        }
        if (this.hGK == null) {
            this.hGK = new AlaLiveFoucsExposureViewContainer(this.hGJ.getContext());
            this.hGK.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hGu != null && a.this.hGu.HR() != null) {
                        alaLiveInfoData = a.this.hGu.HR().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bFC != null) {
                        a.this.bFC.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bFC != null) {
                        a.this.bFC.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void cka() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hGu != null && a.this.hGu.HR() != null) {
                        alaLiveInfoData = a.this.hGu.HR().mLiveInfo;
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
                    if (a.this.bFC != null) {
                        return a.this.bFC.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hGJ.addView(this.hGK, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams UP() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cjQ() {
        int i = BdUtilHelper.getScreenDimensions(this.hGG.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gD(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams cjR() {
        int i = BdUtilHelper.getScreenDimensions(this.hGG.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.gD(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(int i) {
        if (this.hGR) {
            this.bFC.setVideoConfig(LiveRecorderConfigHelper.Sb().d(this.hGT, i, this.hGQ));
        } else {
            this.bFC.setVideoConfig(LiveRecorderConfigHelper.Sb().d(i == 1 ? 0 : this.hGT, i, i == 1 ? this.hGQ : false));
        }
    }

    private void cjS() {
        this.hGX = new com.baidu.tieba.ala.liveroom.master.a.d(this.hGG, this.bFC, this.hGM, this.hGJ, this.hGH, this.hGN, this.hqP, this.hGG.cjJ(), this.hGK);
        this.hGX.a(this.hGu);
        this.hGX.setArModel(this.bFA);
        this.hGX.a(this.hGY);
    }

    public void cjT() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hGG.getPageContext().getPageActivity());
        if (this.bFC != null && this.bFC.getPreview() != null && (this.hGL == null || this.hGL.getParent() == null)) {
            this.bFC.getPreview().setLayoutParams(UP());
        }
        if (this.hGX != null) {
            this.hGX.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hGG.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hGX != null) {
            this.hGX.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjU() {
        if (this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null) {
            if (this.hGX != null && this.hGX.clE() != null) {
                this.hGX.clE().liveID = Long.toString(this.hGu.HR().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hGu.cmm().mLiveInfo.live_id), String.valueOf(this.hGu.cmm().mLiveInfo.room_id), String.valueOf(this.hGu.cmm().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hGu.cmm().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hGu.cmm().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hGu.cmm().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime").setContentExt(jSONObject));
            this.hGS = System.currentTimeMillis() / 1000;
            this.hGu.x(this.hGu.HR().mLiveInfo.live_id, this.hGS);
            this.hGu.i(this.hGu.HR().mLiveInfo.live_id, false);
            com.baidu.live.d.Ba().putLong("last_live_room_id", this.hGu.HR().mLiveInfo.live_id);
            this.hGu.cmr();
            if (this.hGX != null && this.hGX.clE() != null) {
                if (this.hGX.bUl() == 2) {
                    if (this.hGQ) {
                        this.hGX.clE().liveType = 5;
                    } else {
                        this.hGX.clE().liveType = 4;
                    }
                } else if (this.hGX.bUl() == 1) {
                    if (this.hGQ) {
                        this.hGX.clE().liveType = 2;
                    } else {
                        this.hGX.clE().liveType = 1;
                    }
                }
            }
            cjZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjV() {
        final x HR = this.hGu.HR();
        if (HR != null && HR.mLiveInfo != null) {
            if (this.hGX == null || !this.hGX.clB()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hGu.x(HR.mLiveInfo.live_id, a.this.hGS);
                    }
                }, HR.aKz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(as asVar) {
        if (asVar == null) {
            return false;
        }
        this.hGG.closeLoadingDialog();
        if (asVar.mErrorCode == 6) {
            this.hGG.showToast(asVar.mErrorMsg);
            if (this.hGX != null && this.hGX.clE() != null) {
                this.hGX.clE().errSubReason = 6;
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
        if (dVar != null && !dVar.hCa) {
            boolean z = dVar.hCb;
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
            if (this.hGX != null) {
                if (this.hGX.clE() != null) {
                    this.hGX.clE().updateTime = System.currentTimeMillis();
                }
                this.hGu.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hCc, dVar.hCd ? 1 : 0, this.hGX.bUl(), this.hGQ ? 2 : 1, this.hGT, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void cjW() {
        if (this.hGX != null && !this.hGX.clD() && this.hGu.cmm() == null && this.hGX != null) {
            a(this.hGX.clF());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hGX != null) {
            this.hGX.markEnterBackground();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bFC != null) {
            this.bFC.setIsAutoStartFromBack(true);
        }
        if (this.hGX != null) {
            this.hGX.markEnterForeground();
        }
    }

    public void onPause() {
        if (this.hGX != null) {
            this.hGX.onPause();
        }
    }

    public void onFinish() {
        if (this.hGX != null) {
            this.hGX.j(this.hGV);
        }
    }

    public void onDestroy() {
        if (this.hoM != null) {
            this.hoM.release();
            this.hoM = null;
        }
        if (this.hGX != null) {
            this.hGX.onDestroy();
        }
        if (this.hGW != null) {
            this.hGW.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.hqP.stop();
        this.hqP = null;
        if (this.hGu != null) {
            this.hGu.destory();
            this.hGu = null;
        }
        if (this.bFA != null) {
            this.bFA.destory();
            this.bFA = null;
        }
        if (this.bFC != null) {
            al alVar = new al();
            alVar.aMj = this.hGQ ? 2 : 1;
            alVar.mOpenType = 2;
            if (this.hGX != null) {
                alVar.aMi = this.hGX.bUl();
            }
            this.bFC.setRoomInfo(alVar.toJsonString());
            String str = "";
            if (this.hGX != null && this.hGX.clE() != null) {
                if (this.hGX.clE().startLiveTime != 0) {
                    str = Long.toString(this.hGX.clE().startLiveTime);
                }
                this.bFC.setConfigBeforeStop(this.hGX.clE().getCpuMemJsonFormat(), str, "");
            }
            this.bFC.stopRecord();
            this.bFC.release();
            this.bFC.removeRecorderCallback(this.hHb);
            this.bFC = null;
        }
        if (this.hGM != null) {
            this.hGM.setOnTouchListener(null);
            this.hGM.cod();
            this.hGM = null;
        }
        this.hGG = null;
        MessageManager.getInstance().unRegisterListener(this.hGZ);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void dU(int i) {
        this.hGM.dU(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hGG.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hGG.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hGH.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hGH.setLayoutParams(layoutParams);
            if (this.hGR && this.bFC != null && this.bFC.getPreview() != null && this.bFC.getPreview().getParent() == null) {
                cjP();
            }
        }
        if (this.hGX != null) {
            this.hGX.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hGG.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hGX != null) {
            this.hGX.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hGX != null) {
            this.hGX.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int cjX() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjY() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hGX != null && a.this.hGX.clE() != null) {
                        a.this.hGX.clE().sampleMemAndCPU();
                    }
                    a.this.cjY();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjZ() {
        if (this.mHandler != null && this.bFC != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.xh(0);
                    a.this.cjZ();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(int i) {
        if (this.hGX != null && this.hGX.clE() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bFC.getMediaStatus();
            if (this.hGu != null && this.hGu.cmm() != null && this.hGu.cmm().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hGu.cmm().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hGu.cmm().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bFC.getRecorderDebugInfo();
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
            if (this.hGG != null) {
                alaLiveExceptionInfo.appState = this.hGG.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hGU;
            alaLiveExceptionInfo.sessionChannel = cjX();
            alaLiveExceptionInfo.nodeIP = this.bFC.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hGX.clE().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hGX.clE().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hGX.clE().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hGX != null) {
            return this.hGX.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hGY.g(s);
    }
}
