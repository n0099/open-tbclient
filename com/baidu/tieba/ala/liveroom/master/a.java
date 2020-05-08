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
    private AlaLiveRecorder aYI;
    private f eMZ;
    private c fIM;
    private AlaMasterLiveRoomActivity fIW;
    private ViewGroup fIX;
    private RelativeLayout fIY;
    private FrameLayout fIZ;
    private View fJa;
    private AlaLiveView fJb;
    private String fJc;
    private int fJg;
    private short fJi;
    private com.baidu.live.aa.a fJj;
    private d fJk;
    private com.baidu.tieba.ala.liveroom.m.b ftF;
    private com.baidu.live.tieba.e.b fwq;
    private String mForumId;
    private String mForumName;
    private boolean fJd = false;
    private Handler mHandler = new Handler();
    private boolean fJe = false;
    private long fJf = 0;
    private int fJh = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b fJl = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.fJd = eVar.fFF;
                if (eVar.fFB) {
                    a.this.bwU();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void qI(int i) {
            if (i == 2) {
                a.this.bwN();
                if (a.this.fJe) {
                    a.this.qF(2);
                }
                a.this.aYI.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.aYI.addRecorderCallback(a.this.fJo);
                a.this.fJb.setBackgroundColor(a.this.fIW.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.fJd) {
                    a.this.aYI.switchOrientation(a.this.fJd);
                    a.this.aYI.addRecorderCallback(a.this.fJo);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.fJi = s;
            if (a.this.fJi == 1) {
                a.this.fIW.bwJ();
            } else {
                a.this.fIW.finish();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.fIM == null || a.this.fIM.DM() == null || a.this.fIM.DM().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.fIM.DM().mLiveInfo.room_id;
                    j2 = a.this.fIM.DM().mLiveInfo.live_id;
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
        public void Ho() {
            if (a.this.fJa != null) {
                if (a.this.fJa.getParent() != null) {
                    ((ViewGroup) a.this.fJa.getParent()).removeView(a.this.fJa);
                }
                a.this.fJa = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fIZ.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.fIZ.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aFe() {
            if (a.this.fJa == null) {
                a.this.fJa = a.this.aYI.createPKPlayer();
            }
            if (a.this.fJa != null && a.this.fJa.getParent() == null) {
                a.this.fIZ.addView(a.this.fJa, a.this.bwR());
            }
            if (a.this.aYI != null && a.this.aYI.getPreview() != null) {
                FrameLayout.LayoutParams bwQ = a.this.bwQ();
                if (a.this.aYI.getVideoConfig() != null) {
                    bwQ.height = (a.this.aYI.getVideoConfig().getVideoHeight() * bwQ.width) / a.this.aYI.getVideoConfig().getVideoWidth();
                }
                a.this.aYI.getPreview().setLayoutParams(bwQ);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bvi() {
            FrameLayout.LayoutParams bwQ = a.this.bwQ();
            int ak = g.ak(a.this.fIW.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.fIZ.getLayoutParams();
            layoutParams.height = bwQ.height;
            layoutParams.topMargin = ak;
            a.this.fIZ.setLayoutParams(layoutParams);
            if (a.this.aYI.getVideoConfig() != null) {
                bwQ.height = (a.this.aYI.getVideoConfig().getVideoHeight() * bwQ.width) / a.this.aYI.getVideoConfig().getVideoWidth();
            }
            a.this.aYI.getPreview().setLayoutParams(bwQ);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bvj() {
            a.this.bwN();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bvk() {
            a.this.bwO();
        }
    };
    private CustomMessageListener fJm = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.aYI.stopRecord();
                } else {
                    a.this.aYI.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0124a fJn = new a.InterfaceC0124a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback fJo = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.fJk != null) {
                a.this.fJk.byw();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.fJk != null) {
                a.this.fJk.byw();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.fJk != null && a.this.fJk.byy() != null) {
                a.this.fJk.byy().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.fJk != null) {
                a.this.fJk.streamStateReceived(i, z, i2, z2);
            }
            a.this.fJh = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.fJk != null) {
                if (z) {
                    a.this.fJk.aL(0, null);
                } else {
                    a.this.fJk.aL(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.fJk != null && a.this.fJk.byy() != null) {
                a.this.fJk.byy().errCode = 2;
                a.this.fJk.aM(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.fJk != null && a.this.fJk.byy() != null) {
                a.this.fJk.byy().linkTime = alaLiveDebugInfo.connectTime;
                a.this.fJk.byy().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.fJk.byy().startLiveTime == 0) {
                    a.this.fJk.byy().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
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
                a.this.fIW.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.aYI != null && a.this.aYI.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.aYI.getPreview() != null) {
                        a.this.bwN();
                    }
                    a.this.aYI.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.aYI.addRecorderCallback(a.this.fJo);
                    a.this.aYI.stopRecord();
                    if (a.this.aYI.getPreview() != null) {
                        a.this.bwO();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.aYI != null) {
                                a.this.aYI.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.aYI.changeVideoRecorderType(com.baidu.live.v.a.En().aQu != null ? com.baidu.live.v.a.En().aQu.arX : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.aYI.addRecorderCallback(a.this.fJo);
                if (a.this.aYI.getPreview() != null) {
                    a.this.bwO();
                }
                i2 = -4;
            }
            if (a.this.fJk != null) {
                a.this.fJk.aM(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.fJk != null) {
                a.this.fJk.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.fJk != null) {
                a.this.fJk.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a fJp = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.m.c.a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                h bzd = a.this.fIM.bzd();
                a.this.fJk.byy().logID = bzd.aqM;
                a.this.fJk.byy().errCode = 5;
                if (!a.this.a(bzd)) {
                    if (a.this.fJk != null && a.this.fJk.byy() != null) {
                        a.this.fJk.byy().updateTime = System.currentTimeMillis() - a.this.fJk.byy().updateTime;
                    }
                    if (bzd.fFR != 1) {
                        if (a.this.fJk != null && a.this.fJk.byy() != null) {
                            a.this.fJk.byy().errSubReason = -1;
                        }
                        a.this.fIW.showToast(bzd.fFS);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bzd.mErrorCode != 0) {
                        if (a.this.fJk != null && a.this.fJk.byy() != null) {
                            a.this.fJk.byy().errCode = 5;
                            a.this.fJk.byy().errSubReason = bzd.mErrorCode;
                        }
                        a.this.fIW.showToast(str);
                        if (bzd.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.fIW.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.fJk != null && a.this.fJk.byy() != null) {
                            a.this.fJk.byy().errCode = 0;
                            a.this.fJk.byy().errSubReason = 0;
                        }
                        if (a.this.aYI != null) {
                            a.this.aYI.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.En().aQu.ask);
                            a.this.aYI.setStartInfo(Long.toString(a.this.fIM.DM().mLiveInfo.live_id), a.this.fIM.DM().mLiveInfo.getSessionID(), com.baidu.live.v.a.En().aQu.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.fJk != null) {
                            a.this.fJk.c(a.this.fIM.bzd());
                        }
                        a.this.bwU();
                    }
                    if (a.this.fJk != null && a.this.fJk.byy() != null) {
                        a.this.fJk.byy().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.fJk != null) {
                    a.this.fJk.bxH();
                }
            } else if (i2 == 1) {
                a.this.bwV();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (a.this.fJk != null && a.this.fJk.byy() != null) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fLL == 2) {
                            a.this.fJk.byy().errSubReason = -2;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fLL == 3) {
                            a.this.fJk.byy().errSubReason = -3;
                        }
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fJk != null && alaGetVerifyStrategyResponseHttpMessage.fLJ == 1 && alaGetVerifyStrategyResponseHttpMessage.fLL == 1) {
                            a.this.fJk.bvf();
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.fJk != null && alaGetVerifyStrategyResponseHttpMessage.fLJ == 1 && alaGetVerifyStrategyResponseHttpMessage.fLL == 1 && alaGetVerifyStrategyResponseHttpMessage.fLO == 1) {
                        a.this.fJk.bvf();
                    }
                }
                if (a.this.fJk != null) {
                    a.this.fJk.bxT();
                }
            } else if (i2 == 8 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                int i3 = alaGetVerifyStrategyResponseHttpMessage2.fLL != 3 ? 0 : 3;
                if (a.this.fJj != null && a.this.fJk != null) {
                    a.this.fJj.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.fJk.bvh(), a.this.fJc).dk(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                }
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.fIW = alaMasterLiveRoomActivity;
        this.fwq = new com.baidu.live.tieba.e.b(this.fIW.getActivity());
        bwY();
        this.ftF = new com.baidu.tieba.ala.liveroom.m.b();
        MessageManager.getInstance().registerListener(this.fJm);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.aa.a.class, this.fIW.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.fJj = (com.baidu.live.aa.a) runTask.getData();
            if (this.fJj != null) {
                this.fJj.a(this.fJn);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.fIM = cVar;
        if (this.fIM == null) {
            this.fIM = new c(this.fIW.getPageContext());
        }
        if (this.eMZ == null && (runTask = MessageManager.getInstance().runTask(2913177, f.class, this.fIW.getPageContext().getPageActivity())) != null) {
            this.eMZ = (f) runTask.getData();
        }
        if (this.eMZ != null) {
            this.eMZ.a(null);
        }
        this.fIM.a(this.fJp);
        if (this.fJk != null) {
            this.fJk.setArModel(this.eMZ);
            this.fJk.a(this.fIM);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.fJc = str3;
        this.fJe = false;
        kB(false);
        bwS();
        if (this.fJk != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.fFP = bundle;
            this.fJk.b(gVar);
            if (this.fJk.bvh() == 1) {
                qF(this.fJk.bvh());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.fJg = alaLivePersonData.mLiveInfo.clarity;
        this.fJe = true;
        this.fJd = alaLivePersonData.mLiveInfo.screen_direction == 2;
        kB(true);
        bwS();
        if (this.fJk != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.fFO = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                qF(alaLivePersonData.mLiveInfo.live_type);
            }
            this.fJk.b(gVar);
        }
        if (this.fIM != null) {
            this.fIM.h(alaLivePersonData);
        }
    }

    private void bwL() {
        this.fJd = com.baidu.live.c.tG().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bwM() {
        this.fJg = com.baidu.live.c.tG().getInt("live_recorder_resolution_level", 2);
    }

    private void kB(boolean z) {
        if (!z) {
            bwM();
            bwL();
        }
        this.fIX = (ViewGroup) View.inflate(this.fIW.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.fIW.addContentView(this.fIX, new FrameLayout.LayoutParams(-1, -1));
        this.fIW.setContentView(this.fIX);
        this.fIZ = (FrameLayout) this.fIX.findViewById(a.g.ala_live_render_view);
        this.fJb = (AlaLiveView) this.fIX.findViewById(a.g.ala_liveroom_host_liveview);
        this.fJb.setVisibility(8);
        this.fJb.setSwipeClearEnable(true);
        this.fIY = (RelativeLayout) this.fIX.findViewById(a.g.ala_live_unremovable_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fIY.getLayoutParams();
        layoutParams.topMargin = this.fIW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fIW.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fIY.requestLayout();
        this.fIX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.fJb == null || a.this.fJb.fSk) {
                    return false;
                }
                return a.this.fJb.z(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.Eh().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.En().aQu != null && com.baidu.live.v.a.En().aQu.arY) {
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
        if (aq.b(com.baidu.live.v.a.En().aRB)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (aq.a(com.baidu.live.v.a.En().aRB)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (aq.c(com.baidu.live.v.a.En().aRB)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.aYI = new AlaLiveRecorder(this.fIW.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.aYI.setUserGameHardEncode(com.baidu.live.v.a.En().aQu.asa);
        this.aYI.addRecorderCallback(this.fJo);
        if (!this.fJd && this.aYI.getPreview() != null) {
            bwO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwN() {
        if (this.aYI != null && this.aYI.getPreview() != null && this.aYI.getPreview().getParent() != null) {
            ((ViewGroup) this.aYI.getPreview().getParent()).removeView(this.aYI.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwO() {
        this.aYI.getPreview().setEnabled(false);
        bwN();
        if (this.fJa == null) {
            this.fIZ.addView(this.aYI.getPreview(), 0, bwP());
        } else {
            this.fIZ.addView(this.aYI.getPreview(), 0, bwQ());
        }
    }

    private FrameLayout.LayoutParams bwP() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bwQ() {
        int i = BdUtilHelper.getScreenDimensions(this.fIW.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bwR() {
        int i = BdUtilHelper.getScreenDimensions(this.fIW.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(int i) {
        if (this.fJe) {
            this.aYI.setVideoConfig(LiveRecorderConfigHelper.Eh().d(this.fJg, i, this.fJd));
        } else {
            this.aYI.setVideoConfig(LiveRecorderConfigHelper.Eh().d(i == 1 ? 0 : this.fJg, i, i == 1 ? this.fJd : false));
        }
    }

    private void bwS() {
        this.fJk = new d(this.fIW, this.aYI, this.fJb, this.fIZ, this.fIX, this.fwq, this.fIW.bwK());
        this.fJk.a(this.fIM);
        this.fJk.setArModel(this.eMZ);
        this.fJk.a(this.fJl);
    }

    public void bwT() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fIW.getPageContext().getPageActivity());
        if (this.aYI != null && this.aYI.getPreview() != null && (this.fJa == null || this.fJa.getParent() == null)) {
            this.aYI.getPreview().setLayoutParams(bwP());
        }
        if (this.fJk != null) {
            this.fJk.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.fIW.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fJk != null) {
            this.fJk.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwU() {
        if (this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null) {
            if (this.fJk != null && this.fJk.byy() != null) {
                this.fJk.byy().liveID = Long.toString(this.fIM.DM().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.fIM.bzd().mLiveInfo.live_id), String.valueOf(this.fIM.bzd().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.fIM.bzd().mLiveInfo.live_id));
                jSONObject.put("vid", String.valueOf(this.fIM.bzd().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem("1397", LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.fJf = System.currentTimeMillis() / 1000;
            this.fIM.y(this.fIM.DM().mLiveInfo.live_id, this.fJf);
            this.fIM.dF(this.fIM.DM().mLiveInfo.live_id);
            com.baidu.live.c.tG().putLong("last_live_room_id", this.fIM.DM().mLiveInfo.live_id);
            this.fIM.bzj();
            if (this.fJk != null && this.fJk.byy() != null) {
                if (this.fJk.bvh() == 2) {
                    if (this.fJd) {
                        this.fJk.byy().liveType = 5;
                    } else {
                        this.fJk.byy().liveType = 4;
                    }
                } else if (this.fJk.bvh() == 1) {
                    if (this.fJd) {
                        this.fJk.byy().liveType = 2;
                    } else {
                        this.fJk.byy().liveType = 1;
                    }
                }
            }
            bwZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwV() {
        final n DM = this.fIM.DM();
        if (DM != null && DM.mLiveInfo != null) {
            if (this.fJk == null || !this.fJk.byv()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fIM.y(DM.mLiveInfo.live_id, a.this.fJf);
                    }
                }, DM.aqo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        this.fIW.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.fIW.showToast(hVar.mErrorMsg);
            if (this.fJk != null && this.fJk.byy() != null) {
                this.fJk.byy().errSubReason = 6;
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
        if (eVar != null && !eVar.fFB) {
            boolean z = eVar.fFC;
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
            if (this.fJk != null) {
                if (this.fJk.byy() != null) {
                    this.fJk.byy().updateTime = System.currentTimeMillis();
                }
                this.fIM.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.fFD, eVar.fFE ? 1 : 0, this.fJk.bvh(), this.fJd ? 2 : 1, this.fJg, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bwW() {
        if (this.fJk != null && !this.fJk.byx() && this.fIM.bzd() == null && this.fJk != null) {
            a(this.fJk.byz());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.fJk != null) {
            this.fJk.byt();
        }
        if (this.fIW != null && !this.fIW.isFinishing()) {
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
        }
    }

    public void onResume() {
        if (this.aYI != null) {
            this.aYI.setIsAutoStartFromBack(true);
        }
        if (this.fJk != null) {
            this.fJk.byu();
        }
    }

    public void onPause() {
        if (this.fJk != null) {
            this.fJk.onPause();
        }
    }

    public void onFinish() {
        if (this.fJk != null) {
            this.fJk.i(this.fJi);
        }
    }

    public void onDestroy() {
        if (this.ftF != null) {
            this.ftF.release();
            this.ftF = null;
        }
        if (this.fJk != null) {
            this.fJk.onDestroy();
        }
        if (this.fJj != null) {
            this.fJj.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.fwq.stop();
        this.fwq = null;
        if (this.fIM != null) {
            this.fIM.destory();
            this.fIM = null;
        }
        if (this.eMZ != null) {
            this.eMZ.destory();
            this.eMZ = null;
        }
        if (this.aYI != null) {
            t tVar = new t();
            tVar.aqY = this.fJd ? 2 : 1;
            tVar.mOpenType = 2;
            if (this.fJk != null) {
                tVar.aqX = this.fJk.bvh();
            }
            this.aYI.setRoomInfo(tVar.toJsonString());
            String str = "";
            if (this.fJk != null && this.fJk.byy() != null) {
                if (this.fJk.byy().startLiveTime != 0) {
                    str = Long.toString(this.fJk.byy().startLiveTime);
                }
                this.aYI.setConfigBeforeStop(this.fJk.byy().getCpuMemJsonFormat(), str, "");
            }
            this.aYI.removeRecorderCallback(this.fJo);
            this.aYI.stopRecord();
            this.aYI.release();
            this.aYI = null;
        }
        if (this.fJb != null) {
            this.fJb.setOnTouchListener(null);
            this.fJb.bAF();
            this.fJb = null;
        }
        this.fIW = null;
        MessageManager.getInstance().unRegisterListener(this.fJm);
    }

    public void cl(int i) {
        this.fJb.cl(i);
        qG(i);
    }

    private void qG(int i) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.fIW.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.fIW.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fIX.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.fIX.setLayoutParams(layoutParams);
            if (this.fJe && this.aYI != null && this.aYI.getPreview() != null && this.aYI.getPreview().getParent() == null) {
                bwO();
            }
        }
        if (this.fJk != null) {
            this.fJk.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.fIW.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fJk != null) {
            this.fJk.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fJk != null) {
            this.fJk.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bwX() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwY() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJk.byy().sampleMemAndCPU();
                    a.this.bwY();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwZ() {
        if (this.mHandler != null && this.aYI != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.qH(0);
                    a.this.bwZ();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qH(int i) {
        if (this.fJk != null && this.fJk.byy() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.aYI.getMediaStatus();
            if (this.fIM != null && this.fIM.bzd() != null && this.fIM.bzd().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.fIM.bzd().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.fIM.bzd().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.aYI.getRecorderDebugInfo();
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
            if (this.fIW != null) {
                alaLiveExceptionInfo.appState = this.fIW.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.fJh;
            alaLiveExceptionInfo.sessionChannel = bwX();
            alaLiveExceptionInfo.nodeIP = this.aYI.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.fJk.byy().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.fJk.byy().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.fJk.byy().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fJk != null) {
            return this.fJk.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.fJl.f(s);
    }
}
