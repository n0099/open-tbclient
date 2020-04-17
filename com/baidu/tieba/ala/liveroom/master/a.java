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
import com.baidu.live.aa.a;
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
import com.baidu.live.data.aq;
import com.baidu.live.data.n;
import com.baidu.live.data.t;
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
    private AlaLiveRecorder aYD;
    private f eMU;
    private c fIH;
    private AlaMasterLiveRoomActivity fIR;
    private ViewGroup fIS;
    private RelativeLayout fIT;
    private FrameLayout fIU;
    private View fIV;
    private AlaLiveView fIW;
    private String fIX;
    private int fJb;
    private short fJd;
    private com.baidu.live.aa.a fJe;
    private d fJf;
    private com.baidu.tieba.ala.liveroom.m.b ftA;
    private com.baidu.live.tieba.e.b fwl;
    private String mForumId;
    private String mForumName;
    private boolean fIY = false;
    private Handler mHandler = new Handler();
    private boolean fIZ = false;
    private long fJa = 0;
    private int fJc = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fJg = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.fIY = eVar.fFA;
                if (eVar.fFw) {
                    a.this.bwW();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qI(int i) {
            if (i == 2) {
                a.this.bwP();
                if (a.this.fIZ) {
                    a.this.qF(2);
                }
                a.this.aYD.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.aYD.addRecorderCallback(a.this.fJj);
                a.this.fIW.setBackgroundColor(a.this.fIR.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.fIY) {
                    a.this.aYD.switchOrientation(a.this.fIY);
                    a.this.aYD.addRecorderCallback(a.this.fJj);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.fJd = s;
            if (a.this.fJd == 1) {
                a.this.fIR.bwL();
            } else {
                a.this.fIR.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fIH == null || a.this.fIH.DN() == null || a.this.fIH.DN().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fIH.DN().mLiveInfo.room_id;
                    j2 = a.this.fIH.DN().mLiveInfo.live_id;
                }
                FinishLiveManager.getInstance().getFinishListener().onFinishLive(j2, j);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem("1397", LogConfig.KEY_NOTICE, "live_close", "recordtime"));
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void Hp() {
            if (a.this.fIV != null) {
                if (a.this.fIV.getParent() != null) {
                    ((ViewGroup) a.this.fIV.getParent()).removeView(a.this.fIV);
                }
                a.this.fIV = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fIU.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.fIU.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aFe() {
            if (a.this.fIV == null) {
                a.this.fIV = a.this.aYD.createPKPlayer();
            }
            if (a.this.fIV != null && a.this.fIV.getParent() == null) {
                a.this.fIU.addView(a.this.fIV, a.this.bwT());
            }
            if (a.this.aYD != null && a.this.aYD.getPreview() != null) {
                FrameLayout.LayoutParams bwS = a.this.bwS();
                if (a.this.aYD.getVideoConfig() != null) {
                    bwS.height = (a.this.aYD.getVideoConfig().getVideoHeight() * bwS.width) / a.this.aYD.getVideoConfig().getVideoWidth();
                }
                a.this.aYD.getPreview().setLayoutParams(bwS);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bvk() {
            FrameLayout.LayoutParams bwS = a.this.bwS();
            int aw = g.aw(a.this.fIR.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fIU.getLayoutParams();
            layoutParams.height = bwS.height;
            layoutParams.topMargin = aw;
            a.this.fIU.setLayoutParams(layoutParams);
            if (a.this.aYD.getVideoConfig() != null) {
                bwS.height = (a.this.aYD.getVideoConfig().getVideoHeight() * bwS.width) / a.this.aYD.getVideoConfig().getVideoWidth();
            }
            a.this.aYD.getPreview().setLayoutParams(bwS);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bvl() {
            a.this.bwP();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bvm() {
            a.this.bwQ();
        }
    };
    private CustomMessageListener fJh = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.aYD.stopRecord();
                } else {
                    a.this.aYD.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0103a fJi = new a.InterfaceC0103a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback fJj = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.fJf != null) {
                a.this.fJf.byy();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.fJf != null) {
                a.this.fJf.byy();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.fJf != null && a.this.fJf.byA() != null) {
                a.this.fJf.byA().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.fJf != null) {
                a.this.fJf.streamStateReceived(i, z, i2, z2);
            }
            a.this.fJc = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.fJf != null) {
                if (z) {
                    a.this.fJf.aL(0, null);
                } else {
                    a.this.fJf.aL(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.fJf != null && a.this.fJf.byA() != null) {
                a.this.fJf.byA().errCode = 2;
                a.this.fJf.aM(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.fJf != null && a.this.fJf.byA() != null) {
                a.this.fJf.byA().linkTime = alaLiveDebugInfo.connectTime;
                a.this.fJf.byA().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.fJf.byA().startLiveTime == 0) {
                    a.this.fJf.byA().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.qH(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.fIR.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.aYD != null && a.this.aYD.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.aYD.getPreview() != null) {
                        a.this.bwP();
                    }
                    a.this.aYD.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.aYD.addRecorderCallback(a.this.fJj);
                    a.this.aYD.stopRecord();
                    if (a.this.aYD.getPreview() != null) {
                        a.this.bwQ();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.aYD != null) {
                                a.this.aYD.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.aYD.changeVideoRecorderType(com.baidu.live.v.a.Eo().aQp != null ? com.baidu.live.v.a.Eo().aQp.arR : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.aYD.addRecorderCallback(a.this.fJj);
                if (a.this.aYD.getPreview() != null) {
                    a.this.bwQ();
                }
                i2 = -4;
            }
            if (a.this.fJf != null) {
                a.this.fJf.aM(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.fJf != null) {
                a.this.fJf.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.fJf != null) {
                a.this.fJf.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a fJk = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                h bzf = a.this.fIH.bzf();
                a.this.fJf.byA().logID = bzf.aqG;
                a.this.fJf.byA().errCode = 5;
                if (!a.this.a(bzf)) {
                    if (a.this.fJf != null && a.this.fJf.byA() != null) {
                        a.this.fJf.byA().updateTime = System.currentTimeMillis() - a.this.fJf.byA().updateTime;
                    }
                    if (bzf.fFM != 1) {
                        if (a.this.fJf != null && a.this.fJf.byA() != null) {
                            a.this.fJf.byA().errSubReason = -1;
                        }
                        a.this.fIR.showToast(bzf.fFN);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bzf.mErrorCode != 0) {
                        if (a.this.fJf != null && a.this.fJf.byA() != null) {
                            a.this.fJf.byA().errCode = 5;
                            a.this.fJf.byA().errSubReason = bzf.mErrorCode;
                        }
                        a.this.fIR.showToast(str);
                        if (bzf.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.fIR.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.fJf != null && a.this.fJf.byA() != null) {
                            a.this.fJf.byA().errCode = 0;
                            a.this.fJf.byA().errSubReason = 0;
                        }
                        if (a.this.aYD != null) {
                            a.this.aYD.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.Eo().aQp.ase);
                            a.this.aYD.setStartInfo(Long.toString(a.this.fIH.DN().mLiveInfo.live_id), a.this.fIH.DN().mLiveInfo.getSessionID(), com.baidu.live.v.a.Eo().aQp.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.fJf != null) {
                            a.this.fJf.c(a.this.fIH.bzf());
                        }
                        a.this.bwW();
                    }
                    if (a.this.fJf != null && a.this.fJf.byA() != null) {
                        a.this.fJf.byA().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.fJf != null) {
                    a.this.fJf.bxJ();
                }
            } else if (i2 == 1) {
                a.this.bwX();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.fJf != null && a.this.fJf.byA() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fLG == 2) {
                            a.this.fJf.byA().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fLG == 3) {
                            a.this.fJf.byA().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fJf != null && alaGetVerifyStrategyResponseHttpMessage.fLE == 1 && alaGetVerifyStrategyResponseHttpMessage.fLG == 1) {
                            a.this.fJf.bvh();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.fJf != null && alaGetVerifyStrategyResponseHttpMessage.fLE == 1 && alaGetVerifyStrategyResponseHttpMessage.fLG == 1 && alaGetVerifyStrategyResponseHttpMessage.fLJ == 1) {
                        a.this.fJf.bvh();
                    }
                }
                if (a.this.fJf != null) {
                    a.this.fJf.bxV();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.fLG != 3 ? 0 : 3;
                if (a.this.fJe != null && a.this.fJf != null) {
                    a.this.fJe.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.fJf.bvj(), a.this.fIX).dk(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.fIR = alaMasterLiveRoomActivity;
        this.fwl = new com.baidu.live.tieba.e.b(this.fIR.getActivity());
        bxa();
        this.ftA = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.fJh);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.aa.a.class, this.fIR.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.fJe = (com.baidu.live.aa.a) runTask.getData();
            if (this.fJe != null) {
                this.fJe.a(this.fJi);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.fIH = cVar;
        if (this.fIH == null) {
            this.fIH = new c(this.fIR.getPageContext());
        }
        if (this.eMU == null && (runTask = MessageManager.getInstance().runTask(2913177, f.class, this.fIR.getPageContext().getPageActivity())) != null) {
            this.eMU = (f) runTask.getData();
        }
        if (this.eMU != null) {
            this.eMU.a(null);
        }
        this.fIH.a(this.fJk);
        if (this.fJf != null) {
            this.fJf.setArModel(this.eMU);
            this.fJf.a(this.fIH);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.fIX = str3;
        this.fIZ = false;
        kB(false);
        bwU();
        if (this.fJf != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.fFK = bundle;
            this.fJf.b(gVar);
            if (this.fJf.bvj() == 1) {
                qF(this.fJf.bvj());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.fJb = alaLivePersonData.mLiveInfo.clarity;
        this.fIZ = true;
        this.fIY = alaLivePersonData.mLiveInfo.screen_direction == 2;
        kB(true);
        bwU();
        if (this.fJf != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.fFJ = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                qF(alaLivePersonData.mLiveInfo.live_type);
            }
            this.fJf.b(gVar);
        }
        if (this.fIH != null) {
            this.fIH.h(alaLivePersonData);
        }
    }

    private void bwN() {
        this.fIY = com.baidu.live.c.tH().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bwO() {
        this.fJb = com.baidu.live.c.tH().getInt("live_recorder_resolution_level", 2);
    }

    private void kB(boolean z) {
        if (!z) {
            bwO();
            bwN();
        }
        this.fIS = (ViewGroup) View.inflate(this.fIR.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.fIR.addContentView(this.fIS, new FrameLayout.LayoutParams(-1, -1));
        this.fIR.setContentView(this.fIS);
        this.fIU = (FrameLayout) this.fIS.findViewById(a.g.ala_live_render_view);
        this.fIW = (AlaLiveView) this.fIS.findViewById(a.g.ala_liveroom_host_liveview);
        this.fIW.setVisibility(8);
        this.fIW.setSwipeClearEnable(true);
        this.fIT = (RelativeLayout) this.fIS.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fIT.getLayoutParams();
        layoutParams.topMargin = this.fIR.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fIR.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fIT.requestLayout();
        this.fIS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.fIW == null || a.this.fIW.fSf) {
                    return false;
                }
                return a.this.fIW.z(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.Ei().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.Eo().aQp != null && com.baidu.live.v.a.Eo().aQp.arS) {
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
        if (aq.b(com.baidu.live.v.a.Eo().aRw)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (aq.a(com.baidu.live.v.a.Eo().aRw)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (aq.c(com.baidu.live.v.a.Eo().aRw)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.aYD = new AlaLiveRecorder(this.fIR.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.aYD.setUserGameHardEncode(com.baidu.live.v.a.Eo().aQp.arU);
        this.aYD.addRecorderCallback(this.fJj);
        if (!this.fIY && this.aYD.getPreview() != null) {
            bwQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwP() {
        if (this.aYD != null && this.aYD.getPreview() != null && this.aYD.getPreview().getParent() != null) {
            ((ViewGroup) this.aYD.getPreview().getParent()).removeView(this.aYD.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwQ() {
        this.aYD.getPreview().setEnabled(false);
        bwP();
        if (this.fIV == null) {
            this.fIU.addView(this.aYD.getPreview(), 0, bwR());
        } else {
            this.fIU.addView(this.aYD.getPreview(), 0, bwS());
        }
    }

    private FrameLayout.LayoutParams bwR() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bwS() {
        int i = BdUtilHelper.getScreenDimensions(this.fIR.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bwT() {
        int i = BdUtilHelper.getScreenDimensions(this.fIR.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(int i) {
        if (this.fIZ) {
            this.aYD.setVideoConfig(LiveRecorderConfigHelper.Ei().d(this.fJb, i, this.fIY));
        } else {
            this.aYD.setVideoConfig(LiveRecorderConfigHelper.Ei().d(i == 1 ? 0 : this.fJb, i, i == 1 ? this.fIY : false));
        }
    }

    private void bwU() {
        this.fJf = new d(this.fIR, this.aYD, this.fIW, this.fIU, this.fIS, this.fwl, this.fIR.bwM());
        this.fJf.a(this.fIH);
        this.fJf.setArModel(this.eMU);
        this.fJf.a(this.fJg);
    }

    public void bwV() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fIR.getPageContext().getPageActivity());
        if (this.aYD != null && this.aYD.getPreview() != null && (this.fIV == null || this.fIV.getParent() == null)) {
            this.aYD.getPreview().setLayoutParams(bwR());
        }
        if (this.fJf != null) {
            this.fJf.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.fIR.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fJf != null) {
            this.fJf.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwW() {
        if (this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null) {
            if (this.fJf != null && this.fJf.byA() != null) {
                this.fJf.byA().liveID = Long.toString(this.fIH.DN().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.fIH.bzf().mLiveInfo.live_id), String.valueOf(this.fIH.bzf().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.fIH.bzf().mLiveInfo.live_id));
                jSONObject.put("vid", String.valueOf(this.fIH.bzf().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem("1397", LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.fJa = System.currentTimeMillis() / 1000;
            this.fIH.y(this.fIH.DN().mLiveInfo.live_id, this.fJa);
            this.fIH.dF(this.fIH.DN().mLiveInfo.live_id);
            com.baidu.live.c.tH().putLong("last_live_room_id", this.fIH.DN().mLiveInfo.live_id);
            this.fIH.bzl();
            if (this.fJf != null && this.fJf.byA() != null) {
                if (this.fJf.bvj() == 2) {
                    if (this.fIY) {
                        this.fJf.byA().liveType = 5;
                    } else {
                        this.fJf.byA().liveType = 4;
                    }
                } else if (this.fJf.bvj() == 1) {
                    if (this.fIY) {
                        this.fJf.byA().liveType = 2;
                    } else {
                        this.fJf.byA().liveType = 1;
                    }
                }
            }
            bxb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        final n DN = this.fIH.DN();
        if (DN != null && DN.mLiveInfo != null) {
            if (this.fJf == null || !this.fJf.byx()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fIH.y(DN.mLiveInfo.live_id, a.this.fJa);
                    }
                }, DN.aqi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        this.fIR.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.fIR.showToast(hVar.mErrorMsg);
            if (this.fJf != null && this.fJf.byA() != null) {
                this.fJf.byA().errSubReason = 6;
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
        if (eVar != null && !eVar.fFw) {
            boolean z = eVar.fFx;
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
            if (this.fJf != null) {
                if (this.fJf.byA() != null) {
                    this.fJf.byA().updateTime = System.currentTimeMillis();
                }
                this.fIH.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.fFy, eVar.fFz ? 1 : 0, this.fJf.bvj(), this.fIY ? 2 : 1, this.fJb, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bwY() {
        if (this.fJf != null && !this.fJf.byz() && this.fIH.bzf() == null && this.fJf != null) {
            a(this.fJf.byB());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.fJf != null) {
            this.fJf.byv();
        }
        if (this.fIR != null && !this.fIR.isFinishing()) {
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
        }
    }

    public void onResume() {
        if (this.aYD != null) {
            this.aYD.setIsAutoStartFromBack(true);
        }
        if (this.fJf != null) {
            this.fJf.byw();
        }
    }

    public void onPause() {
        if (this.fJf != null) {
            this.fJf.onPause();
        }
    }

    public void onFinish() {
        if (this.fJf != null) {
            this.fJf.i(this.fJd);
        }
    }

    public void onDestroy() {
        if (this.ftA != null) {
            this.ftA.release();
            this.ftA = null;
        }
        if (this.fJf != null) {
            this.fJf.onDestroy();
        }
        if (this.fJe != null) {
            this.fJe.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.fwl.stop();
        this.fwl = null;
        if (this.fIH != null) {
            this.fIH.destory();
            this.fIH = null;
        }
        if (this.eMU != null) {
            this.eMU.destory();
            this.eMU = null;
        }
        if (this.aYD != null) {
            t tVar = new t();
            tVar.aqS = this.fIY ? 2 : 1;
            tVar.mOpenType = 2;
            if (this.fJf != null) {
                tVar.aqR = this.fJf.bvj();
            }
            this.aYD.setRoomInfo(tVar.toJsonString());
            String str = "";
            if (this.fJf != null && this.fJf.byA() != null) {
                if (this.fJf.byA().startLiveTime != 0) {
                    str = Long.toString(this.fJf.byA().startLiveTime);
                }
                this.aYD.setConfigBeforeStop(this.fJf.byA().getCpuMemJsonFormat(), str, "");
            }
            this.aYD.removeRecorderCallback(this.fJj);
            this.aYD.stopRecord();
            this.aYD.release();
            this.aYD = null;
        }
        if (this.fIW != null) {
            this.fIW.setOnTouchListener(null);
            this.fIW.bAH();
            this.fIW = null;
        }
        this.fIR = null;
        MessageManager.getInstance().unRegisterListener(this.fJh);
    }

    public void cl(int i) {
        this.fIW.cl(i);
        qG(i);
    }

    private void qG(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fIR.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.fIR.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fIS.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.fIS.setLayoutParams(layoutParams);
            if (this.fIZ && this.aYD != null && this.aYD.getPreview() != null && this.aYD.getPreview().getParent() == null) {
                bwQ();
            }
        }
        if (this.fJf != null) {
            this.fJf.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.fIR.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fJf != null) {
            this.fJf.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fJf != null) {
            this.fJf.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bwZ() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxa() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJf.byA().sampleMemAndCPU();
                    a.this.bxa();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        if (this.mHandler != null && this.aYD != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.qH(0);
                    a.this.bxb();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qH(int i) {
        if (this.fJf != null && this.fJf.byA() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.aYD.getMediaStatus();
            if (this.fIH != null && this.fIH.bzf() != null && this.fIH.bzf().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fIH.bzf().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fIH.bzf().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.aYD.getRecorderDebugInfo();
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
            if (this.fIR != null) {
                alaLiveExceptionInfo.appState = this.fIR.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.fJc;
            alaLiveExceptionInfo.sessionChannel = bwZ();
            alaLiveExceptionInfo.nodeIP = this.aYD.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.fJf.byA().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.fJf.byA().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.fJf.byA().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fJf != null) {
            return this.fJf.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.fJg.f(s);
    }
}
