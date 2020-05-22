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
    private f eZw;
    private com.baidu.tieba.ala.liveroom.m.b fHB;
    private com.baidu.live.tieba.e.b fKm;
    private c fWI;
    private AlaMasterLiveRoomActivity fWU;
    private ViewGroup fWV;
    private RelativeLayout fWW;
    private FrameLayout fWX;
    private View fWY;
    private AlaLiveView fWZ;
    private String fXa;
    private int fXe;
    private short fXg;
    private com.baidu.live.ab.a fXh;
    private d fXi;
    private String mForumId;
    private String mForumName;
    private boolean fXb = false;
    private Handler mHandler = new Handler();
    private boolean fXc = false;
    private long fXd = 0;
    private int fXf = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fXj = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.fXb = eVar.fTz;
                if (eVar.fTv) {
                    a.this.bCX();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void rj(int i) {
            if (i == 2) {
                a.this.bCQ();
                if (a.this.fXc) {
                    a.this.rg(2);
                }
                a.this.bge.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bge.addRecorderCallback(a.this.fXm);
                a.this.fWZ.setBackgroundColor(a.this.fWU.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.fXb) {
                    a.this.bge.switchOrientation(a.this.fXb);
                    a.this.bge.addRecorderCallback(a.this.fXm);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.fXg = s;
            if (a.this.fXg == 1) {
                a.this.fWU.bCJ();
            } else {
                a.this.fWU.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fWI == null || a.this.fWI.Fk() == null || a.this.fWI.Fk().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fWI.Fk().mLiveInfo.room_id;
                    j2 = a.this.fWI.Fk().mLiveInfo.live_id;
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
            if (a.this.fWY != null) {
                if (a.this.fWY.getParent() != null) {
                    ((ViewGroup) a.this.fWY.getParent()).removeView(a.this.fWY);
                }
                a.this.fWY = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fWX.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.fWX.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aKz() {
            if (a.this.fWY == null) {
                a.this.fWY = a.this.bge.createPKPlayer();
            }
            if (a.this.fWY != null && a.this.fWY.getParent() == null) {
                a.this.fWX.addView(a.this.fWY, a.this.bCU());
            }
            if (a.this.bge != null && a.this.bge.getPreview() != null) {
                FrameLayout.LayoutParams bCT = a.this.bCT();
                if (a.this.bge.getVideoConfig() != null) {
                    bCT.height = (a.this.bge.getVideoConfig().getVideoHeight() * bCT.width) / a.this.bge.getVideoConfig().getVideoWidth();
                }
                a.this.bge.getPreview().setLayoutParams(bCT);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bBh() {
            FrameLayout.LayoutParams bCT = a.this.bCT();
            int au = g.au(a.this.fWU.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fWX.getLayoutParams();
            layoutParams.height = bCT.height;
            layoutParams.topMargin = au;
            a.this.fWX.setLayoutParams(layoutParams);
            if (a.this.bge.getVideoConfig() != null) {
                bCT.height = (a.this.bge.getVideoConfig().getVideoHeight() * bCT.width) / a.this.bge.getVideoConfig().getVideoWidth();
            }
            a.this.bge.getPreview().setLayoutParams(bCT);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bBi() {
            a.this.bCQ();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bBj() {
            a.this.bCR();
        }
    };
    private CustomMessageListener fXk = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
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
    private a.InterfaceC0155a fXl = new a.InterfaceC0155a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback fXm = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.fXi != null) {
                a.this.fXi.bEz();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.fXi != null) {
                a.this.fXi.bEz();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.fXi != null && a.this.fXi.bEB() != null) {
                a.this.fXi.bEB().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.fXi != null) {
                a.this.fXi.streamStateReceived(i, z, i2, z2);
            }
            a.this.fXf = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.fXi != null) {
                if (z) {
                    a.this.fXi.aQ(0, null);
                } else {
                    a.this.fXi.aQ(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.fXi != null && a.this.fXi.bEB() != null) {
                a.this.fXi.bEB().errCode = 2;
                a.this.fXi.aR(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.fXi != null && a.this.fXi.bEB() != null) {
                a.this.fXi.bEB().linkTime = alaLiveDebugInfo.connectTime;
                a.this.fXi.bEB().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.fXi.bEB().startLiveTime == 0) {
                    a.this.fXi.bEB().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.ri(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.fWU.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.bge != null && a.this.bge.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bge.getPreview() != null) {
                        a.this.bCQ();
                    }
                    a.this.bge.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bge.addRecorderCallback(a.this.fXm);
                    a.this.bge.stopRecord();
                    if (a.this.bge.getPreview() != null) {
                        a.this.bCR();
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
                a.this.bge.addRecorderCallback(a.this.fXm);
                if (a.this.bge.getPreview() != null) {
                    a.this.bCR();
                }
                i2 = -4;
            }
            if (a.this.fXi != null) {
                a.this.fXi.aR(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.fXi != null) {
                a.this.fXi.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.fXi != null) {
                a.this.fXi.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a fXn = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                h bFj = a.this.fWI.bFj();
                a.this.fXi.bEB().logID = bFj.avL;
                a.this.fXi.bEB().errCode = 5;
                if (!a.this.a(bFj)) {
                    if (a.this.fXi != null && a.this.fXi.bEB() != null) {
                        a.this.fXi.bEB().updateTime = System.currentTimeMillis() - a.this.fXi.bEB().updateTime;
                    }
                    if (bFj.fTL != 1) {
                        if (a.this.fXi != null && a.this.fXi.bEB() != null) {
                            a.this.fXi.bEB().errSubReason = -1;
                        }
                        a.this.fWU.showToast(bFj.fTM);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bFj.mErrorCode != 0) {
                        if (a.this.fXi != null && a.this.fXi.bEB() != null) {
                            a.this.fXi.bEB().errCode = 5;
                            a.this.fXi.bEB().errSubReason = bFj.mErrorCode;
                        }
                        a.this.fWU.showToast(str);
                        if (bFj.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.fWU.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.fXi != null && a.this.fXi.bEB() != null) {
                            a.this.fXi.bEB().errCode = 0;
                            a.this.fXi.bEB().errSubReason = 0;
                        }
                        if (a.this.bge != null) {
                            a.this.bge.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.Ge().aWF.axl);
                            a.this.bge.setStartInfo(Long.toString(a.this.fWI.Fk().mLiveInfo.live_id), a.this.fWI.Fk().mLiveInfo.getSessionID(), com.baidu.live.v.a.Ge().aWF.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.fXi != null) {
                            a.this.fXi.c(a.this.fWI.bFj());
                        }
                        a.this.bCX();
                    }
                    if (a.this.fXi != null && a.this.fXi.bEB() != null) {
                        a.this.fXi.bEB().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.fXi != null) {
                    a.this.fXi.bDK();
                }
            } else if (i2 == 1) {
                a.this.bCY();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.fXi != null && a.this.fXi.bEB() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.fZK == 2) {
                                a.this.fXi.bEB().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.fZK == 3) {
                                a.this.fXi.bEB().errSubReason = -3;
                            }
                        }
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (a.this.fXi != null && alaGetVerifyStrategyResponseHttpMessage.fZI == 1 && alaGetVerifyStrategyResponseHttpMessage.fZK == 1 && alaGetVerifyStrategyResponseHttpMessage.fZP == 1) {
                                a.this.fXi.bBe();
                            }
                        } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.fXi != null && alaGetVerifyStrategyResponseHttpMessage.fZI == 1 && alaGetVerifyStrategyResponseHttpMessage.fZK == 1 && alaGetVerifyStrategyResponseHttpMessage.fZN == 1 && alaGetVerifyStrategyResponseHttpMessage.fZP == 1) {
                            a.this.fXi.bBe();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.fWU.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.fXi != null) {
                    a.this.fXi.bDW();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.fZK != 3 ? 0 : 3;
                    if (a.this.fXh != null && a.this.fXi != null) {
                        a.this.fXh.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.fXi.bBg(), a.this.fXa).dp(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.fXi != null) {
                d dVar = a.this.fXi;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.kL(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.fWU = alaMasterLiveRoomActivity;
        this.fKm = new com.baidu.live.tieba.e.b(this.fWU.getActivity());
        bDb();
        this.fHB = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.fXk);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ab.a.class, this.fWU.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.fXh = (com.baidu.live.ab.a) runTask.getData();
            if (this.fXh != null) {
                this.fXh.a(this.fXl);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.fWI = cVar;
        if (this.fWI == null) {
            this.fWI = new c(this.fWU.getPageContext());
        }
        if (this.eZw == null && (runTask = MessageManager.getInstance().runTask(2913177, f.class, this.fWU.getPageContext().getPageActivity())) != null) {
            this.eZw = (f) runTask.getData();
        }
        if (this.eZw != null) {
            this.eZw.a(null);
        }
        this.fWI.a(this.fXn);
        if (this.fXi != null) {
            this.fXi.setArModel(this.eZw);
            this.fXi.a(this.fWI);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.fXa = str3;
        this.fXc = false;
        kW(false);
        bCV();
        if (this.fXi != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.fTJ = bundle;
            this.fXi.b(gVar);
            if (this.fXi.bBg() == 1) {
                rg(this.fXi.bBg());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.fXe = alaLivePersonData.mLiveInfo.clarity;
        this.fXc = true;
        this.fXb = alaLivePersonData.mLiveInfo.screen_direction == 2;
        kW(true);
        bCV();
        if (this.fXi != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.fTI = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                rg(alaLivePersonData.mLiveInfo.live_type);
            }
            this.fXi.b(gVar);
        }
        if (this.fWI != null) {
            this.fWI.h(alaLivePersonData);
        }
    }

    private void bCO() {
        this.fXb = com.baidu.live.c.uN().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bCP() {
        this.fXe = com.baidu.live.c.uN().getInt("live_recorder_resolution_level", 2);
    }

    private void kW(boolean z) {
        if (!z) {
            bCP();
            bCO();
        }
        this.fWV = (ViewGroup) View.inflate(this.fWU.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.fWU.addContentView(this.fWV, new FrameLayout.LayoutParams(-1, -1));
        this.fWU.setContentView(this.fWV);
        this.fWX = (FrameLayout) this.fWV.findViewById(a.g.ala_live_render_view);
        this.fWZ = (AlaLiveView) this.fWV.findViewById(a.g.ala_liveroom_host_liveview);
        this.fWZ.setVisibility(8);
        this.fWZ.setSwipeClearEnable(true);
        this.fWW = (RelativeLayout) this.fWV.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fWW.getLayoutParams();
        layoutParams.topMargin = this.fWU.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fWU.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fWW.requestLayout();
        this.fWV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.fWZ == null || a.this.fWZ.ggV) {
                    return false;
                }
                return a.this.fWZ.E(motionEvent);
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
        this.bge = new AlaLiveRecorder(this.fWU.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bge.setUserGameHardEncode(com.baidu.live.v.a.Ge().aWF.axb);
        this.bge.addRecorderCallback(this.fXm);
        LiveRecorderConfigHelper.FX().FZ();
        if (!this.fXb && this.bge.getPreview() != null) {
            bCR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCQ() {
        if (this.bge != null && this.bge.getPreview() != null && this.bge.getPreview().getParent() != null) {
            ((ViewGroup) this.bge.getPreview().getParent()).removeView(this.bge.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCR() {
        this.bge.getPreview().setEnabled(false);
        bCQ();
        if (this.fWY == null) {
            this.fWX.addView(this.bge.getPreview(), 0, bCS());
        } else {
            this.fWX.addView(this.bge.getPreview(), 0, bCT());
        }
    }

    private FrameLayout.LayoutParams bCS() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bCT() {
        int i = BdUtilHelper.getScreenDimensions(this.fWU.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bCU() {
        int i = BdUtilHelper.getScreenDimensions(this.fWU.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(int i) {
        if (this.fXc) {
            this.bge.setVideoConfig(LiveRecorderConfigHelper.FX().d(this.fXe, i, this.fXb));
        } else {
            this.bge.setVideoConfig(LiveRecorderConfigHelper.FX().d(i == 1 ? 0 : this.fXe, i, i == 1 ? this.fXb : false));
        }
    }

    private void bCV() {
        this.fXi = new d(this.fWU, this.bge, this.fWZ, this.fWX, this.fWV, this.fKm, this.fWU.bCK());
        this.fXi.a(this.fWI);
        this.fXi.setArModel(this.eZw);
        this.fXi.a(this.fXj);
    }

    public void bCW() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fWU.getPageContext().getPageActivity());
        if (this.bge != null && this.bge.getPreview() != null && (this.fWY == null || this.fWY.getParent() == null)) {
            this.bge.getPreview().setLayoutParams(bCS());
        }
        if (this.fXi != null) {
            this.fXi.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.fWU.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fXi != null) {
            this.fXi.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCX() {
        if (this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
            if (this.fXi != null && this.fXi.bEB() != null) {
                this.fXi.bEB().liveID = Long.toString(this.fWI.Fk().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.fWI.bFj().mLiveInfo.live_id), String.valueOf(this.fWI.bFj().mLiveInfo.room_id), String.valueOf(this.fWI.bFj().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.fWI.bFj().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.fWI.bFj().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.fWI.bFj().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.fXd = System.currentTimeMillis() / 1000;
            this.fWI.z(this.fWI.Fk().mLiveInfo.live_id, this.fXd);
            this.fWI.f(this.fWI.Fk().mLiveInfo.live_id, false);
            com.baidu.live.c.uN().putLong("last_live_room_id", this.fWI.Fk().mLiveInfo.live_id);
            this.fWI.bFp();
            if (this.fXi != null && this.fXi.bEB() != null) {
                if (this.fXi.bBg() == 2) {
                    if (this.fXb) {
                        this.fXi.bEB().liveType = 5;
                    } else {
                        this.fXi.bEB().liveType = 4;
                    }
                } else if (this.fXi.bBg() == 1) {
                    if (this.fXb) {
                        this.fXi.bEB().liveType = 2;
                    } else {
                        this.fXi.bEB().liveType = 1;
                    }
                }
            }
            bDc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCY() {
        final q Fk = this.fWI.Fk();
        if (Fk != null && Fk.mLiveInfo != null) {
            if (this.fXi == null || !this.fXi.bEy()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fWI.z(Fk.mLiveInfo.live_id, a.this.fXd);
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
        this.fWU.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.fWU.showToast(hVar.mErrorMsg);
            if (this.fXi != null && this.fXi.bEB() != null) {
                this.fXi.bEB().errSubReason = 6;
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
        if (eVar != null && !eVar.fTv) {
            boolean z = eVar.fTw;
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
            if (this.fXi != null) {
                if (this.fXi.bEB() != null) {
                    this.fXi.bEB().updateTime = System.currentTimeMillis();
                }
                this.fWI.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.fTx, eVar.fTy ? 1 : 0, this.fXi.bBg(), this.fXb ? 2 : 1, this.fXe, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bCZ() {
        if (this.fXi != null && !this.fXi.bEA() && this.fWI.bFj() == null && this.fXi != null) {
            a(this.fXi.bEC());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.fXi != null) {
            this.fXi.bEw();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bge != null) {
            this.bge.setIsAutoStartFromBack(true);
        }
        if (this.fXi != null) {
            this.fXi.bEx();
        }
    }

    public void onPause() {
        if (this.fXi != null) {
            this.fXi.onPause();
        }
    }

    public void onFinish() {
        if (this.fXi != null) {
            this.fXi.i(this.fXg);
        }
    }

    public void onDestroy() {
        if (this.fHB != null) {
            this.fHB.release();
            this.fHB = null;
        }
        if (this.fXi != null) {
            this.fXi.onDestroy();
        }
        if (this.fXh != null) {
            this.fXh.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.fKm.stop();
        this.fKm = null;
        if (this.fWI != null) {
            this.fWI.destory();
            this.fWI = null;
        }
        if (this.eZw != null) {
            this.eZw.destory();
            this.eZw = null;
        }
        if (this.bge != null) {
            w wVar = new w();
            wVar.avY = this.fXb ? 2 : 1;
            wVar.mOpenType = 2;
            if (this.fXi != null) {
                wVar.avX = this.fXi.bBg();
            }
            this.bge.setRoomInfo(wVar.toJsonString());
            String str = "";
            if (this.fXi != null && this.fXi.bEB() != null) {
                if (this.fXi.bEB().startLiveTime != 0) {
                    str = Long.toString(this.fXi.bEB().startLiveTime);
                }
                this.bge.setConfigBeforeStop(this.fXi.bEB().getCpuMemJsonFormat(), str, "");
            }
            this.bge.removeRecorderCallback(this.fXm);
            this.bge.stopRecord();
            this.bge.release();
            this.bge = null;
        }
        if (this.fWZ != null) {
            this.fWZ.setOnTouchListener(null);
            this.fWZ.bGU();
            this.fWZ = null;
        }
        this.fWU = null;
        MessageManager.getInstance().unRegisterListener(this.fXk);
    }

    public void cs(int i) {
        this.fWZ.cs(i);
        rh(i);
    }

    private void rh(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fWU.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.fWU.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fWV.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.fWV.setLayoutParams(layoutParams);
            if (this.fXc && this.bge != null && this.bge.getPreview() != null && this.bge.getPreview().getParent() == null) {
                bCR();
            }
        }
        if (this.fXi != null) {
            this.fXi.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.fWU.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fXi != null) {
            this.fXi.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fXi != null) {
            this.fXi.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bDa() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDb() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fXi.bEB().sampleMemAndCPU();
                    a.this.bDb();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDc() {
        if (this.mHandler != null && this.bge != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ri(0);
                    a.this.bDc();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(int i) {
        if (this.fXi != null && this.fXi.bEB() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bge.getMediaStatus();
            if (this.fWI != null && this.fWI.bFj() != null && this.fWI.bFj().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fWI.bFj().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fWI.bFj().mLiveInfo.getPushUrl();
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
            if (this.fWU != null) {
                alaLiveExceptionInfo.appState = this.fWU.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.fXf;
            alaLiveExceptionInfo.sessionChannel = bDa();
            alaLiveExceptionInfo.nodeIP = this.bge.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.fXi.bEB().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.fXi.bEB().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.fXi.bEB().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fXi != null) {
            return this.fXi.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.fXj.f(s);
    }
}
