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
import com.baidu.live.data.az;
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
import com.baidu.tieba.ala.liveroom.n.c;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRecorder bll;
    private com.baidu.tieba.ala.liveroom.n.b fSV;
    private com.baidu.live.tieba.e.b fVv;
    private h fkI;
    private c gjQ;
    private AlaMasterLiveRoomActivity gke;
    private ViewGroup gkf;
    private RelativeLayout gkg;
    private FrameLayout gkh;
    private View gki;
    private AlaLiveView gkj;
    private ViewGroup gkk;
    private LayerRootView gkl;
    private String gkm;
    private int gkq;
    private short gks;
    private com.baidu.live.ab.a gkt;
    private d gku;
    private String mForumId;
    private String mForumName;
    private boolean gkn = false;
    private Handler mHandler = new Handler();
    private boolean gko = false;
    private long gkp = 0;
    private int gkr = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b gkv = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(e eVar) {
            if (eVar != null) {
                a.this.mForumName = eVar.forumName;
                a.this.mForumId = eVar.forumId;
                a.this.gkn = eVar.ggq;
                if (eVar.ggm) {
                    a.this.bGf();
                } else {
                    a.this.a(eVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void rJ(int i) {
            if (i == 2) {
                a.this.bFY();
                if (a.this.gko) {
                    a.this.rH(2);
                }
                a.this.bll.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bll.addRecorderCallback(a.this.gky);
                a.this.gkj.setBackgroundColor(a.this.gke.getResources().getColor(a.d.sdk_cp_cont_b));
                if (a.this.gkn) {
                    a.this.bll.switchOrientation(a.this.gkn);
                    a.this.bll.addRecorderCallback(a.this.gky);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void f(short s) {
            long j;
            long j2 = -1;
            a.this.gks = s;
            if (a.this.gke != null) {
                if (a.this.gks == 1) {
                    a.this.gke.bFR();
                } else {
                    a.this.gke.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.gjQ == null || a.this.gjQ.FU() == null || a.this.gjQ.FU().mLiveInfo == null) {
                    j = -1;
                } else {
                    j = a.this.gjQ.FU().mLiveInfo.room_id;
                    j2 = a.this.gjQ.FU().mLiveInfo.live_id;
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
        public void Ku() {
            if (a.this.gki != null) {
                if (a.this.gki.getParent() != null) {
                    ((ViewGroup) a.this.gki.getParent()).removeView(a.this.gki);
                }
                a.this.gki = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gkh.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.gkh.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void aLF() {
            if (a.this.gki == null) {
                a.this.gki = a.this.bll.createPKPlayer();
            }
            if (a.this.gki != null && a.this.gki.getParent() == null) {
                a.this.gkh.addView(a.this.gki, a.this.bGc());
            }
            if (a.this.bll != null && a.this.bll.getPreview() != null) {
                FrameLayout.LayoutParams bGb = a.this.bGb();
                if (a.this.bll.getVideoConfig() != null) {
                    bGb.height = (a.this.bll.getVideoConfig().getVideoHeight() * bGb.width) / a.this.bll.getVideoConfig().getVideoWidth();
                }
                a.this.bll.getPreview().setLayoutParams(bGb);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bEl() {
            FrameLayout.LayoutParams bGb = a.this.bGb();
            int av = g.av(a.this.gke.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.gkh.getLayoutParams();
            layoutParams.height = bGb.height;
            layoutParams.topMargin = av;
            a.this.gkh.setLayoutParams(layoutParams);
            if (a.this.bll.getVideoConfig() != null) {
                bGb.height = (a.this.bll.getVideoConfig().getVideoHeight() * bGb.width) / a.this.bll.getVideoConfig().getVideoWidth();
            }
            a.this.bll.getPreview().setLayoutParams(bGb);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bEm() {
            a.this.bFY();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void bEn() {
            a.this.bFZ();
        }
    };
    private CustomMessageListener gkw = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bll.stopRecord();
                } else {
                    a.this.bll.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0157a gkx = new a.InterfaceC0157a() { // from class: com.baidu.tieba.ala.liveroom.master.a.5
    };
    private RecorderCallback gky = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.9
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.gku != null) {
                a.this.gku.bHH();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.gku != null) {
                a.this.gku.bHH();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.gku != null && a.this.gku.bHJ() != null) {
                a.this.gku.bHJ().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.gku != null) {
                a.this.gku.streamStateReceived(i, z, i2, z2);
            }
            a.this.gkr = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.gku != null) {
                if (z) {
                    a.this.gku.aU(0, null);
                } else {
                    a.this.gku.aU(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.gku != null && a.this.gku.bHJ() != null) {
                a.this.gku.bHJ().errCode = 2;
                a.this.gku.aV(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.gku != null && a.this.gku.bHJ() != null) {
                a.this.gku.bHJ().linkTime = alaLiveDebugInfo.connectTime;
                a.this.gku.bHJ().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.gku.bHJ().startLiveTime == 0) {
                    a.this.gku.bHJ().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.rI(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.gke.showToast(a.i.device_not_support_beauty_toast_msg);
                if (a.this.bll != null && a.this.bll.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bll.getPreview() != null) {
                        a.this.bFY();
                    }
                    a.this.bll.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bll.addRecorderCallback(a.this.gky);
                    a.this.bll.stopRecord();
                    if (a.this.bll.getPreview() != null) {
                        a.this.bFZ();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bll != null) {
                                a.this.bll.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bll.changeVideoRecorderType(com.baidu.live.v.a.Hm().aZp != null ? com.baidu.live.v.a.Hm().aZp.azh : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bll.addRecorderCallback(a.this.gky);
                if (a.this.bll.getPreview() != null) {
                    a.this.bFZ();
                }
                i2 = -4;
            }
            if (a.this.gku != null) {
                a.this.gku.aV(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.gku != null) {
                a.this.gku.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.gku != null) {
                a.this.gku.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private c.a gkz = new c.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
        @Override // com.baidu.tieba.ala.liveroom.n.c.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                com.baidu.tieba.ala.liveroom.data.h bIr = a.this.gjQ.bIr();
                a.this.gku.bHJ().logID = bIr.axR;
                a.this.gku.bHJ().errCode = 5;
                if (!a.this.a(bIr)) {
                    if (a.this.gku != null && a.this.gku.bHJ() != null) {
                        a.this.gku.bHJ().updateTime = System.currentTimeMillis() - a.this.gku.bHJ().updateTime;
                    }
                    if (bIr.ggD != 1) {
                        if (a.this.gku != null && a.this.gku.bHJ() != null) {
                            a.this.gku.bHJ().errSubReason = -1;
                        }
                        a.this.gke.showToast(bIr.ggE);
                        a.this.f((short) 1);
                        return;
                    }
                    if (bIr.mErrorCode != 0) {
                        if (a.this.gku != null && a.this.gku.bHJ() != null) {
                            a.this.gku.bHJ().errCode = 5;
                            a.this.gku.bHJ().errSubReason = bIr.mErrorCode;
                        }
                        a.this.gke.showToast(str);
                        if (bIr.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.gke.getActivity());
                        }
                        a.this.f((short) 1);
                    } else {
                        if (a.this.gku != null && a.this.gku.bHJ() != null) {
                            a.this.gku.bHJ().errCode = 0;
                            a.this.gku.bHJ().errSubReason = 0;
                        }
                        if (a.this.bll != null) {
                            a.this.bll.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.Hm().aZp.azu);
                            a.this.bll.setStartInfo(Long.toString(a.this.gjQ.FU().mLiveInfo.live_id), a.this.gjQ.FU().mLiveInfo.getSessionID(), com.baidu.live.v.a.Hm().aZp.clientIP, TbConfig.getSubappType());
                        }
                        if (a.this.gku != null) {
                            a.this.gku.c(a.this.gjQ.bIr());
                        }
                        a.this.bGf();
                    }
                    if (a.this.gku != null && a.this.gku.bHJ() != null) {
                        a.this.gku.bHJ().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.gku != null) {
                    a.this.gku.bGU();
                }
            } else if (i2 == 1) {
                a.this.bGg();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.gku != null && a.this.gku.bHJ() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.gmT == 2) {
                                a.this.gku.bHJ().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gmT == 3) {
                                a.this.gku.bHJ().errSubReason = -3;
                            }
                        }
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (a.this.gku != null && alaGetVerifyStrategyResponseHttpMessage.gmR == 1 && alaGetVerifyStrategyResponseHttpMessage.gmT == 1 && alaGetVerifyStrategyResponseHttpMessage.gmY == 1) {
                                a.this.gku.bEi();
                            }
                        } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && a.this.gku != null && alaGetVerifyStrategyResponseHttpMessage.gmR == 1 && alaGetVerifyStrategyResponseHttpMessage.gmT == 1 && alaGetVerifyStrategyResponseHttpMessage.gmW == 1 && alaGetVerifyStrategyResponseHttpMessage.gmY == 1) {
                            a.this.gku.bEi();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.gke.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.gku != null) {
                    a.this.gku.bHg();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.gmT != 3 ? 0 : 3;
                    if (a.this.gkt != null && a.this.gku != null) {
                        a.this.gkt.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.gku.bEk(), a.this.gkm).dB(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.gku != null) {
                d dVar = a.this.gku;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.kW(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.gke = alaMasterLiveRoomActivity;
        this.fVv = new com.baidu.live.tieba.e.b(this.gke.getActivity());
        bGj();
        this.fSV = new com.baidu.tieba.ala.liveroom.n.b();
        MessageManager.getInstance().registerListener(this.gkw);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ab.a.class, this.gke.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.gkt = (com.baidu.live.ab.a) runTask.getData();
            if (this.gkt != null) {
                this.gkt.a(this.gkx);
            }
        }
    }

    public void a(c cVar) {
        CustomResponsedMessage runTask;
        this.gjQ = cVar;
        if (this.gjQ == null) {
            this.gjQ = new c(this.gke.getPageContext());
        }
        if (this.fkI == null && (runTask = MessageManager.getInstance().runTask(2913177, h.class, this.gke.getPageContext().getPageActivity())) != null) {
            this.fkI = (h) runTask.getData();
        }
        if (this.fkI != null) {
            this.fkI.b(null);
            this.fkI.a(null);
        }
        this.gjQ.a(this.gkz);
        if (this.gku != null) {
            this.gku.setArModel(this.fkI);
            this.gku.a(this.gjQ);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.gkm = str3;
        this.gko = false;
        lh(false);
        bGd();
        if (this.gku != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.specialForumType = str3;
            gVar.ggB = bundle;
            this.gku.b(gVar);
            if (this.gku.bEk() == 1) {
                rH(this.gku.bEk());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.gkq = alaLivePersonData.mLiveInfo.clarity;
        this.gko = true;
        this.gkn = alaLivePersonData.mLiveInfo.screen_direction == 2;
        lh(true);
        bGd();
        if (this.gku != null) {
            com.baidu.tieba.ala.liveroom.data.g gVar = new com.baidu.tieba.ala.liveroom.data.g();
            gVar.forumName = this.mForumName;
            gVar.forumId = this.mForumId;
            gVar.ggA = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                rH(alaLivePersonData.mLiveInfo.live_type);
            }
            this.gku.b(gVar);
        }
        if (this.gjQ != null) {
            this.gjQ.h(alaLivePersonData);
        }
    }

    private void bFW() {
        this.gkn = com.baidu.live.c.vf().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void bFX() {
        this.gkq = com.baidu.live.c.vf().getInt("live_recorder_resolution_level", 2);
    }

    private void lh(boolean z) {
        if (!z) {
            bFX();
            bFW();
        }
        this.gkf = (ViewGroup) View.inflate(this.gke.getPageContext().getPageActivity(), a.h.ala_liveroom_host_main_layout, null);
        this.gke.addContentView(this.gkf, new FrameLayout.LayoutParams(-1, -1));
        this.gke.setContentView(this.gkf);
        this.gkh = (FrameLayout) this.gkf.findViewById(a.g.ala_live_render_view);
        this.gkj = (AlaLiveView) this.gkf.findViewById(a.g.ala_liveroom_host_liveview);
        this.gkj.setVisibility(8);
        this.gkj.setSwipeClearEnable(true);
        this.gkg = (RelativeLayout) this.gkf.findViewById(a.g.ala_live_unremovable_container);
        this.gkk = (ViewGroup) this.gkf.findViewById(a.g.func_view);
        this.gkl = (LayerRootView) this.gkf.findViewById(a.g.layer_root_view);
        com.baidu.live.core.layer.b.wk().k(this.gkl);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gkg.getLayoutParams();
        layoutParams.topMargin = this.gke.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.gke.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.gkg.requestLayout();
        this.gkf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.gkj == null || a.this.gkj.gud) {
                    return false;
                }
                return a.this.gkj.E(motionEvent);
            }
        });
        AlaLiveVideoConfig d = LiveRecorderConfigHelper.GG().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.v.a.Hm().aZp != null && com.baidu.live.v.a.Hm().aZp.azi) {
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
        if (az.b(com.baidu.live.v.a.Hm().bdV)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (az.a(com.baidu.live.v.a.Hm().bdV)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (az.c(com.baidu.live.v.a.Hm().bdV)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bll = new AlaLiveRecorder(this.gke.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, videoBeautyType3);
        this.bll.setUserGameHardEncode(com.baidu.live.v.a.Hm().aZp.azk);
        this.bll.addRecorderCallback(this.gky);
        LiveRecorderConfigHelper.GG().GI();
        if (!this.gkn && this.bll.getPreview() != null) {
            bFZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFY() {
        if (this.bll != null && this.bll.getPreview() != null && this.bll.getPreview().getParent() != null) {
            ((ViewGroup) this.bll.getPreview().getParent()).removeView(this.bll.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFZ() {
        this.bll.getPreview().setEnabled(false);
        bFY();
        if (this.gki == null) {
            this.gkh.addView(this.bll.getPreview(), 0, bGa());
        } else {
            this.gkh.addView(this.bll.getPreview(), 0, bGb());
        }
    }

    private FrameLayout.LayoutParams bGa() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bGb() {
        int i = BdUtilHelper.getScreenDimensions(this.gke.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams bGc() {
        int i = BdUtilHelper.getScreenDimensions(this.gke.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 4) / 3);
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(int i) {
        if (this.gko) {
            this.bll.setVideoConfig(LiveRecorderConfigHelper.GG().d(this.gkq, i, this.gkn));
        } else {
            this.bll.setVideoConfig(LiveRecorderConfigHelper.GG().d(i == 1 ? 0 : this.gkq, i, i == 1 ? this.gkn : false));
        }
    }

    private void bGd() {
        this.gku = new d(this.gke, this.bll, this.gkj, this.gkh, this.gkf, this.gkk, this.fVv, this.gke.bFS());
        this.gku.a(this.gjQ);
        this.gku.setArModel(this.fkI);
        this.gku.a(this.gkv);
    }

    public void bGe() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gke.getPageContext().getPageActivity());
        if (this.bll != null && this.bll.getPreview() != null && (this.gki == null || this.gki.getParent() == null)) {
            this.bll.getPreview().setLayoutParams(bGa());
        }
        if (this.gku != null) {
            this.gku.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.gke.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gku != null) {
            this.gku.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGf() {
        if (this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
            if (this.gku != null && this.gku.bHJ() != null) {
                this.gku.bHJ().liveID = Long.toString(this.gjQ.FU().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.gjQ.bIr().mLiveInfo.live_id), String.valueOf(this.gjQ.bIr().mLiveInfo.room_id), String.valueOf(this.gjQ.bIr().mLiveInfo.feed_id), null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.gjQ.bIr().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.gjQ.bIr().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.gjQ.bIr().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "live_close", "recordtime").setContentExt(jSONObject));
            this.gkp = System.currentTimeMillis() / 1000;
            this.gjQ.y(this.gjQ.FU().mLiveInfo.live_id, this.gkp);
            this.gjQ.f(this.gjQ.FU().mLiveInfo.live_id, false);
            com.baidu.live.c.vf().putLong("last_live_room_id", this.gjQ.FU().mLiveInfo.live_id);
            this.gjQ.bIx();
            if (this.gku != null && this.gku.bHJ() != null) {
                if (this.gku.bEk() == 2) {
                    if (this.gkn) {
                        this.gku.bHJ().liveType = 5;
                    } else {
                        this.gku.bHJ().liveType = 4;
                    }
                } else if (this.gku.bEk() == 1) {
                    if (this.gkn) {
                        this.gku.bHJ().liveType = 2;
                    } else {
                        this.gku.bHJ().liveType = 1;
                    }
                }
            }
            bGk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGg() {
        final q FU = this.gjQ.FU();
        if (FU != null && FU.mLiveInfo != null) {
            if (this.gku == null || !this.gku.bHG()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gjQ.y(FU.mLiveInfo.live_id, a.this.gkp);
                    }
                }, FU.axt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.ala.liveroom.data.h hVar) {
        if (hVar == null) {
            return false;
        }
        this.gke.closeLoadingDialog();
        if (hVar.mErrorCode == 6) {
            this.gke.showToast(hVar.mErrorMsg);
            if (this.gku != null && this.gku.bHJ() != null) {
                this.gku.bHJ().errSubReason = 6;
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
        if (eVar != null && !eVar.ggm) {
            boolean z = eVar.ggn;
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
            if (this.gku != null) {
                if (this.gku.bHJ() != null) {
                    this.gku.bHJ().updateTime = System.currentTimeMillis();
                }
                this.gjQ.a(eVar.forumName, eVar.forumId, eVar.title, z ? 2 : 1, d, d2, str2, str, 1, eVar.ggo, eVar.ggp ? 1 : 0, this.gku.bEk(), this.gkn ? 2 : 1, this.gkq, eVar.gameId, eVar.gameName);
            }
        }
    }

    public void bGh() {
        if (this.gku != null && !this.gku.bHI() && this.gjQ.bIr() == null && this.gku != null) {
            a(this.gku.bHK());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.gku != null) {
            this.gku.bHE();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bll != null) {
            this.bll.setIsAutoStartFromBack(true);
        }
        if (this.gku != null) {
            this.gku.bHF();
        }
    }

    public void onPause() {
        if (this.gku != null) {
            this.gku.onPause();
        }
    }

    public void onFinish() {
        if (this.gku != null) {
            this.gku.i(this.gks);
        }
    }

    public void onDestroy() {
        if (this.fSV != null) {
            this.fSV.release();
            this.fSV = null;
        }
        if (this.gku != null) {
            this.gku.onDestroy();
        }
        if (this.gkt != null) {
            this.gkt.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.fVv.stop();
        this.fVv = null;
        if (this.gjQ != null) {
            this.gjQ.destory();
            this.gjQ = null;
        }
        if (this.fkI != null) {
            this.fkI.destory();
            this.fkI = null;
        }
        if (this.bll != null) {
            x xVar = new x();
            xVar.ayg = this.gkn ? 2 : 1;
            xVar.mOpenType = 2;
            if (this.gku != null) {
                xVar.ayf = this.gku.bEk();
            }
            this.bll.setRoomInfo(xVar.toJsonString());
            String str = "";
            if (this.gku != null && this.gku.bHJ() != null) {
                if (this.gku.bHJ().startLiveTime != 0) {
                    str = Long.toString(this.gku.bHJ().startLiveTime);
                }
                this.bll.setConfigBeforeStop(this.gku.bHJ().getCpuMemJsonFormat(), str, "");
            }
            this.bll.removeRecorderCallback(this.gky);
            this.bll.stopRecord();
            this.bll.release();
            this.bll = null;
        }
        if (this.gkj != null) {
            this.gkj.setOnTouchListener(null);
            this.gkj.bKd();
            this.gkj = null;
        }
        this.gke = null;
        MessageManager.getInstance().unRegisterListener(this.gkw);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void cA(int i) {
        this.gkj.cA(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.gke.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.gke.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gkf.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.gkf.setLayoutParams(layoutParams);
            if (this.gko && this.bll != null && this.bll.getPreview() != null && this.bll.getPreview().getParent() == null) {
                bFZ();
            }
        }
        if (this.gku != null) {
            this.gku.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.gke.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gku != null) {
            this.gku.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gku != null) {
            this.gku.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int bGi() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gku.bHJ().sampleMemAndCPU();
                    a.this.bGj();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGk() {
        if (this.mHandler != null && this.bll != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.rI(0);
                    a.this.bGk();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(int i) {
        if (this.gku != null && this.gku.bHJ() != null) {
            com.baidu.live.message.d dVar = new com.baidu.live.message.d();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bll.getMediaStatus();
            if (this.gjQ != null && this.gjQ.bIr() != null && this.gjQ.bIr().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.gjQ.bIr().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.gjQ.bIr().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bll.getRecorderDebugInfo();
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
            if (this.gke != null) {
                alaLiveExceptionInfo.appState = this.gke.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.gkr;
            alaLiveExceptionInfo.sessionChannel = bGi();
            alaLiveExceptionInfo.nodeIP = this.bll.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.gku.bHJ().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.gku.bHJ().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            dVar.a(alaLiveExceptionInfo);
            this.gku.bHJ().reset();
            MessageManager.getInstance().sendMessage(dVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gku != null) {
            return this.gku.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void f(short s) {
        this.gkv.f(s);
    }
}
