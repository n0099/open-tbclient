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
import com.baidu.live.ar.h;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.ae;
import com.baidu.live.data.ba;
import com.baidu.live.data.q;
import com.baidu.live.data.x;
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
import com.baidu.tieba.ala.liveroom.master.a.d;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.o.c;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRecorder blF;
    private com.baidu.tieba.ala.liveroom.o.b fYo;
    private h fpQ;
    private com.baidu.live.tieba.e.b gaA;
    private c goP;
    private AlaMasterLiveRoomActivity gpd;
    private ViewGroup gpe;
    private RelativeLayout gpf;
    private FrameLayout gpg;
    private View gph;
    private AlaLiveView gpi;
    private ViewGroup gpj;
    private LayerRootView gpk;
    private String gpl;
    private int gpp;
    private short gpr;
    private com.baidu.live.ab.a gps;
    private d gpt;
    private String mForumId;
    private String mForumName;
    private boolean gpm = false;
    private Handler mHandler = new Handler();
    private boolean gpn = false;
    private long gpo = 0;
    private int gpq = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b gpu = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.gpm = eVar.gly;
                if (eVar.glu) {
                    a.this.bJo();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void rZ(int i) {
            if (i == 2) {
                a.this.bJh();
                if (a.this.gpn) {
                    a.this.rX(2);
                }
                a.this.blF.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.blF.addRecorderCallback(a.this.gpx);
                a.this.gpi.setBackgroundColor(a.this.gpd.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.gpm) {
                    a.this.blF.switchOrientation(a.this.gpm);
                    a.this.blF.addRecorderCallback(a.this.gpx);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.gpr = s;
            if (a.this.gpd != null) {
                if (a.this.gpr == 1) {
                    a.this.gpd.bJa();
                } else {
                    a.this.gpd.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.goP == null || a.this.goP.FO() == null || a.this.goP.FO().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.goP.FO().mLiveInfo.room_id;
                    j2 = a.this.goP.FO().mLiveInfo.live_id;
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
        public void KB() {
            if (a.this.gph != null) {
                if (a.this.gph.getParent() != null) {
                    ((ViewGroup) a.this.gph.getParent()).removeView(a.this.gph);
                }
                a.this.gph = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gpg.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.gpg.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aPt() {
            if (a.this.gph == null) {
                a.this.gph = a.this.blF.createPKPlayer();
            }
            if (a.this.gph != null && a.this.gph.getParent() == null) {
                a.this.gpg.addView(a.this.gph, a.this.bJl());
            }
            if (a.this.blF != null && a.this.blF.getPreview() != null) {
                FrameLayout.LayoutParams bJk = a.this.bJk();
                if (a.this.blF.getVideoConfig() != null) {
                    bJk.height = (a.this.blF.getVideoConfig().getVideoHeight() * bJk.width) / a.this.blF.getVideoConfig().getVideoWidth();
                }
                a.this.blF.getPreview().setLayoutParams(bJk);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bHx() {
            FrameLayout.LayoutParams bJk = a.this.bJk();
            int av = g.av(a.this.gpd.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gpg.getLayoutParams();
            layoutParams.height = bJk.height;
            layoutParams.topMargin = av;
            a.this.gpg.setLayoutParams(layoutParams);
            if (a.this.blF.getVideoConfig() != null) {
                bJk.height = (a.this.blF.getVideoConfig().getVideoHeight() * bJk.width) / a.this.blF.getVideoConfig().getVideoWidth();
            }
            a.this.blF.getPreview().setLayoutParams(bJk);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bHy() {
            a.this.bJh();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bHz() {
            a.this.bJi();
        }
    };
    private CustomMessageListener gpv = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.blF.stopRecord();
                } else {
                    a.this.blF.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0156a gpw = new a.InterfaceC0156a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback gpx = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.gpt != null) {
                a.this.gpt.bKO();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.gpt != null) {
                a.this.gpt.bKO();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.gpt != null && a.this.gpt.bKQ() != null) {
                a.this.gpt.bKQ().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.gpt != null) {
                a.this.gpt.streamStateReceived(i, z, i2, z2);
            }
            a.this.gpq = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.gpt != null) {
                if (z) {
                    a.this.gpt.aW(0, null);
                } else {
                    a.this.gpt.aW(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.gpt != null && a.this.gpt.bKQ() != null) {
                a.this.gpt.bKQ().errCode = 2;
                a.this.gpt.aX(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.gpt != null && a.this.gpt.bKQ() != null) {
                a.this.gpt.bKQ().linkTime = alaLiveDebugInfo.connectTime;
                a.this.gpt.bKQ().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.gpt.bKQ().startLiveTime == 0) {
                    a.this.gpt.bKQ().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.rY(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.gpd.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.blF != null && a.this.blF.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.blF.getPreview() != null) {
                        a.this.bJh();
                    }
                    a.this.blF.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.blF.addRecorderCallback(a.this.gpx);
                    a.this.blF.stopRecord();
                    if (a.this.blF.getPreview() != null) {
                        a.this.bJi();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.blF != null) {
                                a.this.blF.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.blF.changeVideoRecorderType(com.baidu.live.v.a.Hs().aZn != null ? com.baidu.live.v.a.Hs().aZn.aAu : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.blF.addRecorderCallback(a.this.gpx);
                if (a.this.blF.getPreview() != null) {
                    a.this.bJi();
                }
                i2 = -4;
            }
            if (a.this.gpt != null) {
                a.this.gpt.aX(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.gpt != null) {
                a.this.gpt.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.gpt != null) {
                a.this.gpt.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a gpy = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.o.c.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                ae bLx = a.this.goP.bLx();
                a.this.gpt.bKQ().logID = bLx.aze;
                a.this.gpt.bKQ().errCode = 5;
                if (!a.this.a(bLx)) {
                    if (a.this.gpt != null && a.this.gpt.bKQ() != null) {
                        a.this.gpt.bKQ().updateTime = System.currentTimeMillis() - a.this.gpt.bKQ().updateTime;
                    }
                    if (bLx.aCB != 1) {
                        if (a.this.gpt != null && a.this.gpt.bKQ() != null) {
                            a.this.gpt.bKQ().errSubReason = -1;
                        }
                        a.this.gpd.showToast(bLx.aCC);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bLx.mErrorCode != 0) {
                        if (a.this.gpt != null && a.this.gpt.bKQ() != null) {
                            a.this.gpt.bKQ().errCode = 5;
                            a.this.gpt.bKQ().errSubReason = bLx.mErrorCode;
                        }
                        a.this.gpd.showToast(str);
                        if (bLx.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.gpd.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.gpt != null && a.this.gpt.bKQ() != null) {
                            a.this.gpt.bKQ().errCode = 0;
                            a.this.gpt.bKQ().errSubReason = 0;
                        }
                        if (a.this.blF != null) {
                            a.this.blF.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.Hs().aZn.aAH);
                            a.this.blF.setStartInfo(Long.toString(a.this.goP.FO().mLiveInfo.live_id), a.this.goP.FO().mLiveInfo.getSessionID(), com.baidu.live.v.a.Hs().aZn.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.gpt != null) {
                            a.this.gpt.c(a.this.goP.bLx());
                        }
                        a.this.bJo();
                    }
                    if (a.this.gpt != null && a.this.gpt.bKQ() != null) {
                        a.this.gpt.bKQ().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.gpt != null) {
                    a.this.gpt.bKb();
                }
            } else if (i2 == 1) {
                a.this.bJp();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.gpt != null && a.this.gpt.bKQ() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.grR == 2) {
                                a.this.gpt.bKQ().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.grR == 3) {
                                a.this.gpt.bKQ().errSubReason = -3;
                            }
                        }
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (a.this.gpt != null && alaGetVerifyStrategyResponseHttpMessage.grP == 1 && alaGetVerifyStrategyResponseHttpMessage.grR == 1 && alaGetVerifyStrategyResponseHttpMessage.grW == 1) {
                                a.this.gpt.bHu();
                            }
                        } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.gpt != null && alaGetVerifyStrategyResponseHttpMessage.grP == 1 && alaGetVerifyStrategyResponseHttpMessage.grR == 1 && alaGetVerifyStrategyResponseHttpMessage.grU == 1 && alaGetVerifyStrategyResponseHttpMessage.grW == 1) {
                            a.this.gpt.bHu();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.gpd.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.gpt != null) {
                    a.this.gpt.bKn();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.grR != 3 ? 0 : 3;
                    if (a.this.gps != null && a.this.gpt != null) {
                        a.this.gps.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.gpt.bHw(), a.this.gpl).dB(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.gpt != null) {
                d dVar = a.this.gpt;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.lz(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.gpd = alaMasterLiveRoomActivity;
        this.gaA = new com.baidu.live.tieba.e.b(this.gpd.getActivity());
        bJs();
        this.fYo = new com.baidu.tieba.ala.liveroom.o.b();
        MessageManager.getInstance().registerListener(this.gpv);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ab.a.class, this.gpd.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.gps = (com.baidu.live.ab.a) runTask.getData();
            if (this.gps != null) {
                this.gps.a(this.gpw);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.goP = cVar;
        if (this.goP == null) {
            this.goP = new c(this.gpd.getPageContext());
        }
        if (this.fpQ == null && (runTask = MessageManager.getInstance().runTask(2913177, h.class, this.gpd.getPageContext().getPageActivity())) != null) {
            this.fpQ = (h) runTask.getData();
        }
        if (this.fpQ != null) {
            this.fpQ.b(null);
            this.fpQ.a(null);
        }
        this.goP.a(this.gpy);
        if (this.gpt != null) {
            this.gpt.setArModel(this.fpQ);
            this.gpt.a(this.goP);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.gpl = str3;
        this.gpn = false;
        lK(false);
        bJm();
        if (this.gpt != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.glJ = bundle;
            this.gpt.b(gVar);
            if (this.gpt.bHw() == 1) {
                rX(this.gpt.bHw());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.gpp = alaLivePersonData.mLiveInfo.clarity;
        this.gpn = true;
        this.gpm = alaLivePersonData.mLiveInfo.screen_direction == 2;
        lK(true);
        bJm();
        if (this.gpt != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.glI = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                rX(alaLivePersonData.mLiveInfo.live_type);
            }
            this.gpt.b(gVar);
        }
        if (this.goP != null) {
            this.goP.h(alaLivePersonData);
        }
    }

    private void bJf() {
        this.gpm = com.baidu.live.c.vf().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bJg() {
        this.gpp = com.baidu.live.c.vf().getInt("live_recorder_resolution_level", 2);
    }

    private void lK(boolean z) {
        if (!z) {
            bJg();
            bJf();
        }
        this.gpe = (ViewGroup) View.inflate(this.gpd.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.gpd.addContentView(this.gpe, new FrameLayout.LayoutParams(-1, -1));
        this.gpd.setContentView(this.gpe);
        this.gpg = (FrameLayout) this.gpe.findViewById(a.g.ala_live_render_view);
        this.gpi = (AlaLiveView) this.gpe.findViewById(a.g.ala_liveroom_host_liveview);
        this.gpi.setVisibility(8);
        this.gpi.setSwipeClearEnable(true);
        this.gpf = (RelativeLayout) this.gpe.findViewById(a.g.ala_live_unremovable_container);
        this.gpj = (ViewGroup) this.gpe.findViewById(a.g.func_view);
        this.gpk = (LayerRootView) this.gpe.findViewById(a.g.layer_root_view);
        com.baidu.live.core.layer.b.wN().l(this.gpk);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpf.getLayoutParams();
        layoutParams.topMargin = this.gpd.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.gpd.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.gpf.requestLayout();
        this.gpe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.gpi == null || a.this.gpi.gzA) {
                    return false;
                }
                return a.this.gpi.E(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.GN().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.Hs().aZn != null && com.baidu.live.v.a.Hs().aZn.aAv) {
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
        if (ba.b(com.baidu.live.v.a.Hs().beo)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (ba.a(com.baidu.live.v.a.Hs().beo)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (ba.c(com.baidu.live.v.a.Hs().beo)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.blF = new AlaLiveRecorder(this.gpd.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.blF.setUserGameHardEncode(com.baidu.live.v.a.Hs().aZn.aAx);
        this.blF.addRecorderCallback(this.gpx);
        LiveRecorderConfigHelper.GN().GP();
        if (!this.gpm && this.blF.getPreview() != null) {
            bJi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJh() {
        if (this.blF != null && this.blF.getPreview() != null && this.blF.getPreview().getParent() != null) {
            ((ViewGroup) this.blF.getPreview().getParent()).removeView(this.blF.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJi() {
        this.blF.getPreview().setEnabled(false);
        bJh();
        if (this.gph == null) {
            this.gpg.addView(this.blF.getPreview(), 0, bJj());
        } else {
            this.gpg.addView(this.blF.getPreview(), 0, bJk());
        }
    }

    private FrameLayout.LayoutParams bJj() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bJk() {
        int i = BdUtilHelper.getScreenDimensions(this.gpd.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bJl() {
        int i = BdUtilHelper.getScreenDimensions(this.gpd.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rX(int i) {
        if (this.gpn) {
            this.blF.setVideoConfig(LiveRecorderConfigHelper.GN().d(this.gpp, i, this.gpm));
        } else {
            this.blF.setVideoConfig(LiveRecorderConfigHelper.GN().d(i == 1 ? 0 : this.gpp, i, i == 1 ? this.gpm : false));
        }
    }

    private void bJm() {
        this.gpt = new d(this.gpd, this.blF, this.gpi, this.gpg, this.gpe, this.gpj, this.gaA, this.gpd.bJb());
        this.gpt.a(this.goP);
        this.gpt.setArModel(this.fpQ);
        this.gpt.a(this.gpu);
    }

    public void bJn() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gpd.getPageContext().getPageActivity());
        if (this.blF != null && this.blF.getPreview() != null && (this.gph == null || this.gph.getParent() == null)) {
            this.blF.getPreview().setLayoutParams(bJj());
        }
        if (this.gpt != null) {
            this.gpt.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.gpd.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gpt != null) {
            this.gpt.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJo() {
        if (this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
            if (this.gpt != null && this.gpt.bKQ() != null) {
                this.gpt.bKQ().liveID = Long.toString(this.goP.FO().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.goP.bLx().mLiveInfo.live_id), String.valueOf(this.goP.bLx().mLiveInfo.room_id), String.valueOf(this.goP.bLx().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.goP.bLx().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.goP.bLx().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.goP.bLx().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.gpo = System.currentTimeMillis() / 1000;
            this.goP.y(this.goP.FO().mLiveInfo.live_id, this.gpo);
            this.goP.f(this.goP.FO().mLiveInfo.live_id, false);
            com.baidu.live.c.vf().putLong("last_live_room_id", this.goP.FO().mLiveInfo.live_id);
            this.goP.bLD();
            if (this.gpt != null && this.gpt.bKQ() != null) {
                if (this.gpt.bHw() == 2) {
                    if (this.gpm) {
                        this.gpt.bKQ().liveType = 5;
                    } else {
                        this.gpt.bKQ().liveType = 4;
                    }
                } else if (this.gpt.bHw() == 1) {
                    if (this.gpm) {
                        this.gpt.bKQ().liveType = 2;
                    } else {
                        this.gpt.bKQ().liveType = 1;
                    }
                }
            }
            bJt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJp() {
        final q FO = this.goP.FO();
        if (FO != null && FO.mLiveInfo != null) {
            if (this.gpt == null || !this.gpt.bKN()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.goP.y(FO.mLiveInfo.live_id, a.this.gpo);
                    }
                }, FO.ayG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ae aeVar) {
        if (aeVar == null) {
            return false;
        }
        this.gpd.closeLoadingDialog();
        if (aeVar.mErrorCode == 6) {
            this.gpd.showToast(aeVar.mErrorMsg);
            if (this.gpt != null && this.gpt.bKQ() != null) {
                this.gpt.bKQ().errSubReason = 6;
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
        if (eVar != null && !eVar.glu) {
            boolean z = eVar.glv;
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
            if (this.gpt != null) {
                if (this.gpt.bKQ() != null) {
                    this.gpt.bKQ().updateTime = System.currentTimeMillis();
                }
                this.goP.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.glw, eVar.glx ? 1 : 0, this.gpt.bHw(), this.gpm ? 2 : 1, this.gpp, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bJq() {
        if (this.gpt != null && !this.gpt.bKP() && this.goP.bLx() == null && this.gpt != null) {
            a(this.gpt.bKR());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.gpt != null) {
            this.gpt.bKL();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.blF != null) {
            this.blF.setIsAutoStartFromBack(true);
        }
        if (this.gpt != null) {
            this.gpt.bKM();
        }
    }

    public void onPause() {
        if (this.gpt != null) {
            this.gpt.onPause();
        }
    }

    public void onFinish() {
        if (this.gpt != null) {
            this.gpt.i(this.gpr);
        }
    }

    public void onDestroy() {
        if (this.fYo != null) {
            this.fYo.release();
            this.fYo = null;
        }
        if (this.gpt != null) {
            this.gpt.onDestroy();
        }
        if (this.gps != null) {
            this.gps.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.gaA.stop();
        this.gaA = null;
        if (this.goP != null) {
            this.goP.destory();
            this.goP = null;
        }
        if (this.fpQ != null) {
            this.fpQ.destory();
            this.fpQ = null;
        }
        if (this.blF != null) {
            x xVar = new x();
            xVar.azt = this.gpm ? 2 : 1;
            xVar.mOpenType = 2;
            if (this.gpt != null) {
                xVar.azs = this.gpt.bHw();
            }
            this.blF.setRoomInfo(xVar.toJsonString());
            String str = "";
            if (this.gpt != null && this.gpt.bKQ() != null) {
                if (this.gpt.bKQ().startLiveTime != 0) {
                    str = Long.toString(this.gpt.bKQ().startLiveTime);
                }
                this.blF.setConfigBeforeStop(this.gpt.bKQ().getCpuMemJsonFormat(), str, "");
            }
            this.blF.removeRecorderCallback(this.gpx);
            this.blF.stopRecord();
            this.blF.release();
            this.blF = null;
        }
        if (this.gpi != null) {
            this.gpi.setOnTouchListener(null);
            this.gpi.bNk();
            this.gpi = null;
        }
        this.gpd = null;
        MessageManager.getInstance().unRegisterListener(this.gpv);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void bN(int i) {
        this.gpi.bN(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gpd.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.gpd.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpe.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.gpe.setLayoutParams(layoutParams);
            if (this.gpn && this.blF != null && this.blF.getPreview() != null && this.blF.getPreview().getParent() == null) {
                bJi();
            }
        }
        if (this.gpt != null) {
            this.gpt.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.gpd.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gpt != null) {
            this.gpt.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gpt != null) {
            this.gpt.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bJr() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJs() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gpt.bKQ().sampleMemAndCPU();
                    a.this.bJs();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJt() {
        if (this.mHandler != null && this.blF != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.rY(0);
                    a.this.bJt();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(int i) {
        if (this.gpt != null && this.gpt.bKQ() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.blF.getMediaStatus();
            if (this.goP != null && this.goP.bLx() != null && this.goP.bLx().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.goP.bLx().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.goP.bLx().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.blF.getRecorderDebugInfo();
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
            if (this.gpd != null) {
                alaLiveExceptionInfo.appState = this.gpd.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.gpq;
            alaLiveExceptionInfo.sessionChannel = bJr();
            alaLiveExceptionInfo.nodeIP = this.blF.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.gpt.bKQ().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.gpt.bKQ().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.gpt.bKQ().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gpt != null) {
            return this.gpt.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.gpu.f(s);
    }
}
