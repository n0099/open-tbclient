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
import com.baidu.live.ab.a;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.ar.f;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.av;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
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
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.g;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRecorder bge;
    private f eZH;
    private com.baidu.tieba.ala.liveroom.m.b fHM;
    private com.baidu.live.tieba.e.b fKx;
    private c fWT;
    private AlaMasterLiveRoomActivity fXf;
    private ViewGroup fXg;
    private RelativeLayout fXh;
    private FrameLayout fXi;
    private View fXj;
    private AlaLiveView fXk;
    private String fXl;
    private int fXp;
    private short fXr;
    private com.baidu.live.ab.a fXs;
    private d fXt;
    private String mForumId;
    private String mForumName;
    private boolean fXm = false;
    private Handler mHandler = new Handler();
    private boolean fXn = false;
    private long fXo = 0;
    private int fXq = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fXu = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.fXm = eVar.fTK;
                if (eVar.fTG) {
                    a.this.bCZ();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void rl(int i) {
            if (i == 2) {
                a.this.bCS();
                if (a.this.fXn) {
                    a.this.ri(2);
                }
                a.this.bge.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bge.addRecorderCallback(a.this.fXx);
                a.this.fXk.setBackgroundColor(a.this.fXf.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.fXm) {
                    a.this.bge.switchOrientation(a.this.fXm);
                    a.this.bge.addRecorderCallback(a.this.fXx);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.fXr = s;
            if (a.this.fXr == 1) {
                a.this.fXf.bCL();
            } else {
                a.this.fXf.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fWT == null || a.this.fWT.Fk() == null || a.this.fWT.Fk().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fWT.Fk().mLiveInfo.room_id;
                    j2 = a.this.fWT.Fk().mLiveInfo.live_id;
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
        public void Jh() {
            if (a.this.fXj != null) {
                if (a.this.fXj.getParent() != null) {
                    ((ViewGroup) a.this.fXj.getParent()).removeView(a.this.fXj);
                }
                a.this.fXj = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fXi.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.fXi.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aKz() {
            if (a.this.fXj == null) {
                a.this.fXj = a.this.bge.createPKPlayer();
            }
            if (a.this.fXj != null && a.this.fXj.getParent() == null) {
                a.this.fXi.addView(a.this.fXj, a.this.bCW());
            }
            if (a.this.bge != null && a.this.bge.getPreview() != null) {
                FrameLayout.LayoutParams bCV = a.this.bCV();
                if (a.this.bge.getVideoConfig() != null) {
                    bCV.height = (a.this.bge.getVideoConfig().getVideoHeight() * bCV.width) / a.this.bge.getVideoConfig().getVideoWidth();
                }
                a.this.bge.getPreview().setLayoutParams(bCV);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bBj() {
            FrameLayout.LayoutParams bCV = a.this.bCV();
            int au = g.au(a.this.fXf.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fXi.getLayoutParams();
            layoutParams.height = bCV.height;
            layoutParams.topMargin = au;
            a.this.fXi.setLayoutParams(layoutParams);
            if (a.this.bge.getVideoConfig() != null) {
                bCV.height = (a.this.bge.getVideoConfig().getVideoHeight() * bCV.width) / a.this.bge.getVideoConfig().getVideoWidth();
            }
            a.this.bge.getPreview().setLayoutParams(bCV);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bBk() {
            a.this.bCS();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bBl() {
            a.this.bCT();
        }
    };
    private CustomMessageListener fXv = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bge.stopRecord();
                } else {
                    a.this.bge.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0155a fXw = new a.InterfaceC0155a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback fXx = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.fXt != null) {
                a.this.fXt.bEB();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.fXt != null) {
                a.this.fXt.bEB();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.fXt != null && a.this.fXt.bED() != null) {
                a.this.fXt.bED().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.fXt != null) {
                a.this.fXt.streamStateReceived(i, z, i2, z2);
            }
            a.this.fXq = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.fXt != null) {
                if (z) {
                    a.this.fXt.aQ(0, null);
                } else {
                    a.this.fXt.aQ(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.fXt != null && a.this.fXt.bED() != null) {
                a.this.fXt.bED().errCode = 2;
                a.this.fXt.aR(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.fXt != null && a.this.fXt.bED() != null) {
                a.this.fXt.bED().linkTime = alaLiveDebugInfo.connectTime;
                a.this.fXt.bED().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.fXt.bED().startLiveTime == 0) {
                    a.this.fXt.bED().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.rk(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.fXf.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.bge != null && a.this.bge.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bge.getPreview() != null) {
                        a.this.bCS();
                    }
                    a.this.bge.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bge.addRecorderCallback(a.this.fXx);
                    a.this.bge.stopRecord();
                    if (a.this.bge.getPreview() != null) {
                        a.this.bCT();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bge != null) {
                                a.this.bge.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bge.changeVideoRecorderType(com.baidu.live.v.a.Ge().aWF != null ? com.baidu.live.v.a.Ge().aWF.awY : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bge.addRecorderCallback(a.this.fXx);
                if (a.this.bge.getPreview() != null) {
                    a.this.bCT();
                }
                i2 = -4;
            }
            if (a.this.fXt != null) {
                a.this.fXt.aR(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.fXt != null) {
                a.this.fXt.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.fXt != null) {
                a.this.fXt.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a fXy = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                h bFl = a.this.fWT.bFl();
                a.this.fXt.bED().logID = bFl.avL;
                a.this.fXt.bED().errCode = 5;
                if (!a.this.a(bFl)) {
                    if (a.this.fXt != null && a.this.fXt.bED() != null) {
                        a.this.fXt.bED().updateTime = System.currentTimeMillis() - a.this.fXt.bED().updateTime;
                    }
                    if (bFl.fTW != 1) {
                        if (a.this.fXt != null && a.this.fXt.bED() != null) {
                            a.this.fXt.bED().errSubReason = -1;
                        }
                        a.this.fXf.showToast(bFl.fTX);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bFl.mErrorCode != 0) {
                        if (a.this.fXt != null && a.this.fXt.bED() != null) {
                            a.this.fXt.bED().errCode = 5;
                            a.this.fXt.bED().errSubReason = bFl.mErrorCode;
                        }
                        a.this.fXf.showToast(str);
                        if (bFl.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.fXf.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.fXt != null && a.this.fXt.bED() != null) {
                            a.this.fXt.bED().errCode = 0;
                            a.this.fXt.bED().errSubReason = 0;
                        }
                        if (a.this.bge != null) {
                            a.this.bge.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.Ge().aWF.axl);
                            a.this.bge.setStartInfo(Long.toString(a.this.fWT.Fk().mLiveInfo.live_id), a.this.fWT.Fk().mLiveInfo.getSessionID(), com.baidu.live.v.a.Ge().aWF.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.fXt != null) {
                            a.this.fXt.c(a.this.fWT.bFl());
                        }
                        a.this.bCZ();
                    }
                    if (a.this.fXt != null && a.this.fXt.bED() != null) {
                        a.this.fXt.bED().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.fXt != null) {
                    a.this.fXt.bDM();
                }
            } else if (i2 == 1) {
                a.this.bDa();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.fXt != null && a.this.fXt.bED() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.fZV == 2) {
                                a.this.fXt.bED().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.fZV == 3) {
                                a.this.fXt.bED().errSubReason = -3;
                            }
                        }
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (a.this.fXt != null && alaGetVerifyStrategyResponseHttpMessage.fZT == 1 && alaGetVerifyStrategyResponseHttpMessage.fZV == 1 && alaGetVerifyStrategyResponseHttpMessage.gaa == 1) {
                                a.this.fXt.bBg();
                            }
                        } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.fXt != null && alaGetVerifyStrategyResponseHttpMessage.fZT == 1 && alaGetVerifyStrategyResponseHttpMessage.fZV == 1 && alaGetVerifyStrategyResponseHttpMessage.fZY == 1 && alaGetVerifyStrategyResponseHttpMessage.gaa == 1) {
                            a.this.fXt.bBg();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.fXf.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.fXt != null) {
                    a.this.fXt.bDY();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.fZV != 3 ? 0 : 3;
                    if (a.this.fXs != null && a.this.fXt != null) {
                        a.this.fXs.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.fXt.bBi(), a.this.fXl).dr(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.fXt != null) {
                d dVar = a.this.fXt;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.kL(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.fXf = alaMasterLiveRoomActivity;
        this.fKx = new com.baidu.live.tieba.e.b(this.fXf.getActivity());
        bDd();
        this.fHM = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.fXv);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ab.a.class, this.fXf.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.fXs = (com.baidu.live.ab.a) runTask.getData();
            if (this.fXs != null) {
                this.fXs.a(this.fXw);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.fWT = cVar;
        if (this.fWT == null) {
            this.fWT = new c(this.fXf.getPageContext());
        }
        if (this.eZH == null && (runTask = MessageManager.getInstance().runTask(2913177, f.class, this.fXf.getPageContext().getPageActivity())) != null) {
            this.eZH = (f) runTask.getData();
        }
        if (this.eZH != null) {
            this.eZH.a(null);
        }
        this.fWT.a(this.fXy);
        if (this.fXt != null) {
            this.fXt.setArModel(this.eZH);
            this.fXt.a(this.fWT);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.fXl = str3;
        this.fXn = false;
        kW(false);
        bCX();
        if (this.fXt != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.fTU = bundle;
            this.fXt.b(gVar);
            if (this.fXt.bBi() == 1) {
                ri(this.fXt.bBi());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.fXp = alaLivePersonData.mLiveInfo.clarity;
        this.fXn = true;
        this.fXm = alaLivePersonData.mLiveInfo.screen_direction == 2;
        kW(true);
        bCX();
        if (this.fXt != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.fTT = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                ri(alaLivePersonData.mLiveInfo.live_type);
            }
            this.fXt.b(gVar);
        }
        if (this.fWT != null) {
            this.fWT.h(alaLivePersonData);
        }
    }

    private void bCQ() {
        this.fXm = com.baidu.live.c.uN().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bCR() {
        this.fXp = com.baidu.live.c.uN().getInt("live_recorder_resolution_level", 2);
    }

    private void kW(boolean z) {
        if (!z) {
            bCR();
            bCQ();
        }
        this.fXg = (ViewGroup) View.inflate(this.fXf.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.fXf.addContentView(this.fXg, new FrameLayout.LayoutParams(-1, -1));
        this.fXf.setContentView(this.fXg);
        this.fXi = (FrameLayout) this.fXg.findViewById(a.g.ala_live_render_view);
        this.fXk = (AlaLiveView) this.fXg.findViewById(a.g.ala_liveroom_host_liveview);
        this.fXk.setVisibility(8);
        this.fXk.setSwipeClearEnable(true);
        this.fXh = (RelativeLayout) this.fXg.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXh.getLayoutParams();
        layoutParams.topMargin = this.fXf.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fXf.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fXh.requestLayout();
        this.fXg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.fXk == null || a.this.fXk.ghg) {
                    return false;
                }
                return a.this.fXk.E(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.FX().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.Ge().aWF != null && com.baidu.live.v.a.Ge().aWF.awZ) {
            VideoBeautyType videoBeautyType2 = VideoBeautyType.BEAUTY_FACEUNITY;
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
        VideoBeautyType videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        if (av.b(com.baidu.live.v.a.Ge().aYP)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (av.a(com.baidu.live.v.a.Ge().aYP)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (av.c(com.baidu.live.v.a.Ge().aYP)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bge = new AlaLiveRecorder(this.fXf.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bge.setUserGameHardEncode(com.baidu.live.v.a.Ge().aWF.axb);
        this.bge.addRecorderCallback(this.fXx);
        LiveRecorderConfigHelper.FX().FZ();
        if (!this.fXm && this.bge.getPreview() != null) {
            bCT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCS() {
        if (this.bge != null && this.bge.getPreview() != null && this.bge.getPreview().getParent() != null) {
            ((ViewGroup) this.bge.getPreview().getParent()).removeView(this.bge.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCT() {
        this.bge.getPreview().setEnabled(false);
        bCS();
        if (this.fXj == null) {
            this.fXi.addView(this.bge.getPreview(), 0, bCU());
        } else {
            this.fXi.addView(this.bge.getPreview(), 0, bCV());
        }
    }

    private FrameLayout.LayoutParams bCU() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bCV() {
        int i = BdUtilHelper.getScreenDimensions(this.fXf.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bCW() {
        int i = BdUtilHelper.getScreenDimensions(this.fXf.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(int i) {
        if (this.fXn) {
            this.bge.setVideoConfig(LiveRecorderConfigHelper.FX().d(this.fXp, i, this.fXm));
        } else {
            this.bge.setVideoConfig(LiveRecorderConfigHelper.FX().d(i == 1 ? 0 : this.fXp, i, i == 1 ? this.fXm : false));
        }
    }

    private void bCX() {
        this.fXt = new d(this.fXf, this.bge, this.fXk, this.fXi, this.fXg, this.fKx, this.fXf.bCM());
        this.fXt.a(this.fWT);
        this.fXt.setArModel(this.eZH);
        this.fXt.a(this.fXu);
    }

    public void bCY() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fXf.getPageContext().getPageActivity());
        if (this.bge != null && this.bge.getPreview() != null && (this.fXj == null || this.fXj.getParent() == null)) {
            this.bge.getPreview().setLayoutParams(bCU());
        }
        if (this.fXt != null) {
            this.fXt.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.fXf.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fXt != null) {
            this.fXt.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCZ() {
        if (this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
            if (this.fXt != null && this.fXt.bED() != null) {
                this.fXt.bED().liveID = Long.toString(this.fWT.Fk().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.fWT.bFl().mLiveInfo.live_id), String.valueOf(this.fWT.bFl().mLiveInfo.room_id), String.valueOf(this.fWT.bFl().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.fWT.bFl().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.fWT.bFl().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.fWT.bFl().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.fXo = System.currentTimeMillis() / 1000;
            this.fWT.z(this.fWT.Fk().mLiveInfo.live_id, this.fXo);
            this.fWT.f(this.fWT.Fk().mLiveInfo.live_id, false);
            com.baidu.live.c.uN().putLong("last_live_room_id", this.fWT.Fk().mLiveInfo.live_id);
            this.fWT.bFr();
            if (this.fXt != null && this.fXt.bED() != null) {
                if (this.fXt.bBi() == 2) {
                    if (this.fXm) {
                        this.fXt.bED().liveType = 5;
                    } else {
                        this.fXt.bED().liveType = 4;
                    }
                } else if (this.fXt.bBi() == 1) {
                    if (this.fXm) {
                        this.fXt.bED().liveType = 2;
                    } else {
                        this.fXt.bED().liveType = 1;
                    }
                }
            }
            bDe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        final q Fk = this.fWT.Fk();
        if (Fk != null && Fk.mLiveInfo != null) {
            if (this.fXt == null || !this.fXt.bEA()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fWT.z(Fk.mLiveInfo.live_id, a.this.fXo);
                    }
                }, Fk.avn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        this.fXf.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.fXf.showToast(hVar.mErrorMsg);
            if (this.fXt != null && this.fXt.bED() != null) {
                this.fXt.bED().errSubReason = 6;
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
        if (eVar != null && !eVar.fTG) {
            boolean z = eVar.fTH;
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
            if (this.fXt != null) {
                if (this.fXt.bED() != null) {
                    this.fXt.bED().updateTime = System.currentTimeMillis();
                }
                this.fWT.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.fTI, eVar.fTJ ? 1 : 0, this.fXt.bBi(), this.fXm ? 2 : 1, this.fXp, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bDb() {
        if (this.fXt != null && !this.fXt.bEC() && this.fWT.bFl() == null && this.fXt != null) {
            a(this.fXt.bEE());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.fXt != null) {
            this.fXt.bEy();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bge != null) {
            this.bge.setIsAutoStartFromBack(true);
        }
        if (this.fXt != null) {
            this.fXt.bEz();
        }
    }

    public void onPause() {
        if (this.fXt != null) {
            this.fXt.onPause();
        }
    }

    public void onFinish() {
        if (this.fXt != null) {
            this.fXt.i(this.fXr);
        }
    }

    public void onDestroy() {
        if (this.fHM != null) {
            this.fHM.release();
            this.fHM = null;
        }
        if (this.fXt != null) {
            this.fXt.onDestroy();
        }
        if (this.fXs != null) {
            this.fXs.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.fKx.stop();
        this.fKx = null;
        if (this.fWT != null) {
            this.fWT.destory();
            this.fWT = null;
        }
        if (this.eZH != null) {
            this.eZH.destory();
            this.eZH = null;
        }
        if (this.bge != null) {
            w wVar = new w();
            wVar.avY = this.fXm ? 2 : 1;
            wVar.mOpenType = 2;
            if (this.fXt != null) {
                wVar.avX = this.fXt.bBi();
            }
            this.bge.setRoomInfo(wVar.toJsonString());
            String str = "";
            if (this.fXt != null && this.fXt.bED() != null) {
                if (this.fXt.bED().startLiveTime != 0) {
                    str = Long.toString(this.fXt.bED().startLiveTime);
                }
                this.bge.setConfigBeforeStop(this.fXt.bED().getCpuMemJsonFormat(), str, "");
            }
            this.bge.removeRecorderCallback(this.fXx);
            this.bge.stopRecord();
            this.bge.release();
            this.bge = null;
        }
        if (this.fXk != null) {
            this.fXk.setOnTouchListener(null);
            this.fXk.bGW();
            this.fXk = null;
        }
        this.fXf = null;
        MessageManager.getInstance().unRegisterListener(this.fXv);
    }

    public void cu(int i) {
        this.fXk.cu(i);
        rj(i);
    }

    private void rj(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fXf.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.fXf.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXg.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.fXg.setLayoutParams(layoutParams);
            if (this.fXn && this.bge != null && this.bge.getPreview() != null && this.bge.getPreview().getParent() == null) {
                bCT();
            }
        }
        if (this.fXt != null) {
            this.fXt.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.fXf.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fXt != null) {
            this.fXt.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fXt != null) {
            this.fXt.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bDc() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDd() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fXt.bED().sampleMemAndCPU();
                    a.this.bDd();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDe() {
        if (this.mHandler != null && this.bge != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.rk(0);
                    a.this.bDe();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(int i) {
        if (this.fXt != null && this.fXt.bED() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bge.getMediaStatus();
            if (this.fWT != null && this.fWT.bFl() != null && this.fWT.bFl().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fWT.bFl().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fWT.bFl().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bge.getRecorderDebugInfo();
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
            if (this.fXf != null) {
                alaLiveExceptionInfo.appState = this.fXf.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.fXq;
            alaLiveExceptionInfo.sessionChannel = bDc();
            alaLiveExceptionInfo.nodeIP = this.bge.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.fXt.bED().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.fXt.bED().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.fXt.bED().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fXt != null) {
            return this.fXt.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.fXu.f(s);
    }
}
