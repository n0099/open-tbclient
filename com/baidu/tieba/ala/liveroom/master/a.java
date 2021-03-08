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
/* loaded from: classes10.dex */
public class a {
    private k bFU;
    private AlaLiveRecorder bFW;
    private d hHU;
    private AlaMasterLiveRoomActivity hIg;
    private ViewGroup hIh;
    private RelativeLayout hIi;
    private FrameLayout hIj;
    private AlaLiveFoucsExposureViewContainer hIk;
    private View hIl;
    private AlaLiveView hIm;
    private ViewGroup hIn;
    private LayerRootView hIo;
    private String hIp;
    private int hIt;
    private short hIv;
    private com.baidu.live.ak.a hIw;
    private com.baidu.tieba.ala.liveroom.master.a.d hIx;
    private c hqu;
    private com.baidu.live.tieba.e.b hst;
    private String mForumId;
    private String mForumName;
    private boolean hIq = false;
    private Handler mHandler = new Handler();
    private boolean hIr = false;
    private long hIs = 0;
    private int hIu = 1;
    private com.baidu.tieba.ala.liveroom.master.a.b hIy = new com.baidu.tieba.ala.liveroom.master.a.b() { // from class: com.baidu.tieba.ala.liveroom.master.a.1
        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void b(com.baidu.tieba.ala.liveroom.data.d dVar) {
            if (dVar != null) {
                a.this.mForumName = dVar.forumName;
                a.this.mForumId = dVar.forumId;
                a.this.hIq = dVar.hDF;
                if (dVar.hDB) {
                    a.this.chj();
                } else {
                    a.this.a(dVar);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void vP(int i) {
            if (i == 2) {
                a.this.SI();
                if (a.this.hIr) {
                    a.this.vN(2);
                }
                a.this.bFW.changeVideoRecorderType(VideoRecorderType.SCREEN);
                a.this.bFW.addRecorderCallback(a.this.hIB);
                a.this.hIm.setBackgroundColor(a.this.hIg.getResources().getColor(a.c.sdk_cp_cont_b));
                if (a.this.hIq) {
                    a.this.bFW.switchOrientation(a.this.hIq);
                    a.this.bFW.addRecorderCallback(a.this.hIB);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void g(short s) {
            long j;
            long j2;
            a.this.hIv = s;
            if (a.this.hIg != null) {
                if (a.this.hIv == 1) {
                    a.this.hIg.cgX();
                } else {
                    a.this.hIg.finish();
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                if (a.this.hHU == null || a.this.hHU.Fp() == null || a.this.hHU.Fp().mLiveInfo == null) {
                    j = -1;
                    j2 = -1;
                } else {
                    long j3 = a.this.hHU.Fp().mLiveInfo.room_id;
                    j = a.this.hHU.Fp().mLiveInfo.live_id;
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
        public void Xl() {
            if (a.this.hIl != null) {
                if (a.this.hIl.getParent() != null) {
                    ((ViewGroup) a.this.hIl.getParent()).removeView(a.this.hIl);
                }
                a.this.hIl = null;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hIj.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            a.this.hIj.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceN() {
            if (a.this.hIl == null) {
                a.this.hIl = a.this.bFW.createPKPlayer();
            }
            if (a.this.hIl != null && a.this.hIl.getParent() == null) {
                a.this.hIj.addView(a.this.hIl, a.this.chg());
            }
            if (a.this.bFW != null && a.this.bFW.getPreview() != null) {
                FrameLayout.LayoutParams chf = a.this.chf();
                if (a.this.bFW.getVideoConfig() != null) {
                    chf.height = (a.this.bFW.getVideoConfig().getVideoHeight() * chf.width) / a.this.bFW.getVideoConfig().getVideoWidth();
                }
                a.this.bFW.getPreview().setLayoutParams(chf);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceO() {
            FrameLayout.LayoutParams chf = a.this.chf();
            int bl = h.bl(a.this.hIg.getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.hIj.getLayoutParams();
            layoutParams.height = chf.height;
            layoutParams.topMargin = bl;
            a.this.hIj.setLayoutParams(layoutParams);
            if (a.this.bFW.getVideoConfig() != null) {
                chf.height = (a.this.bFW.getVideoConfig().getVideoHeight() * chf.width) / a.this.bFW.getVideoConfig().getVideoWidth();
            }
            a.this.bFW.getPreview().setLayoutParams(chf);
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceP() {
            a.this.SI();
        }

        @Override // com.baidu.tieba.ala.liveroom.master.a.b
        public void ceQ() {
            a.this.che();
        }
    };
    private CustomMessageListener hIz = new CustomMessageListener(2913018) { // from class: com.baidu.tieba.ala.liveroom.master.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    a.this.bFW.stopRecord();
                } else {
                    a.this.bFW.startRecord();
                }
            }
        }
    };
    private a.InterfaceC0164a hIA = new a.InterfaceC0164a() { // from class: com.baidu.tieba.ala.liveroom.master.a.6
    };
    private RecorderCallback hIB = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.master.a.11
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
            if (a.this.hIx != null) {
                a.this.hIx.ciR();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
            if (a.this.hIx != null) {
                a.this.hIx.ciR();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
            if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                a.this.hIx.ciT().lostRate = d;
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            if (a.this.hIx != null) {
                a.this.hIx.streamStateReceived(i, z, i2, z2);
            }
            a.this.hIu = i2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
            if (a.this.hIx != null) {
                if (z) {
                    a.this.hIx.bq(0, null);
                } else {
                    a.this.hIx.bq(-1, null);
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
            if (!z && a.this.hIx != null && a.this.hIx.ciT() != null) {
                a.this.hIx.ciT().errCode = 2;
                a.this.hIx.br(-5, null);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo != null && a.this.hIx != null && a.this.hIx.ciT() != null) {
                a.this.hIx.ciT().linkTime = alaLiveDebugInfo.connectTime;
                a.this.hIx.ciT().linkCount = alaLiveDebugInfo.connectCnt;
                if (a.this.hIx.ciT().startLiveTime == 0) {
                    a.this.hIx.ciT().startLiveTime = System.currentTimeMillis() - alaLiveDebugInfo.connectTime;
                }
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            int i2 = 0;
            i2 = 0;
            if (i == 4) {
                a.this.vO(JavaTypesHelper.toInt(str, 0));
            } else if (i == 3) {
                i2 = -2;
            } else if (i == 4) {
                i2 = -6;
            } else if (i == 1) {
                i2 = -3;
                i2 = -3;
                i2 = -3;
                a.this.hIg.showToast(a.h.device_not_support_beauty_toast_msg);
                if (a.this.bFW != null && a.this.bFW.getVideoRecorderType() != VideoRecorderType.CAMERA) {
                    if (a.this.bFW.getPreview() != null) {
                        a.this.SI();
                    }
                    a.this.bFW.changeVideoRecorderType(VideoRecorderType.CAMERA);
                    a.this.bFW.addRecorderCallback(a.this.hIB);
                    a.this.bFW.stopRecord();
                    if (a.this.bFW.getPreview() != null) {
                        a.this.che();
                    }
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bFW != null) {
                                a.this.bFW.startRecord();
                            }
                        }
                    }, 1000L);
                }
            } else if (i == 2) {
                a.this.bFW.changeVideoRecorderType(com.baidu.live.ae.a.Qm().bwx != null ? com.baidu.live.ae.a.Qm().bwx.aMM : false ? VideoRecorderType.CAMERA : VideoRecorderType.CAMERA);
                a.this.bFW.addRecorderCallback(a.this.hIB);
                if (a.this.bFW.getPreview() != null) {
                    a.this.che();
                }
                i2 = -4;
            }
            if (a.this.hIx != null) {
                a.this.hIx.br(i2, str);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            if (a.this.hIx != null) {
                a.this.hIx.onRtcConnected(i);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.hIx != null) {
                a.this.hIx.onPKPlayerFirstFrame();
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void sendBufferChanged(int i) {
            if (a.this.hIx != null) {
                a.this.hIx.sendBufferChanged(i);
            }
        }
    };
    private d.a hIC = new d.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.12
        @Override // com.baidu.tieba.ala.liveroom.n.d.a
        public void a(int i, String str, int i2, Object obj) {
            boolean z = false;
            if (i2 == 6) {
                aw cjB = a.this.hHU.cjB();
                if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                    a.this.hIx.ciT().logID = cjB.logId;
                    a.this.hIx.ciT().errCode = 5;
                }
                if (!a.this.a(cjB)) {
                    if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                        a.this.hIx.ciT().updateTime = System.currentTimeMillis() - a.this.hIx.ciT().updateTime;
                    }
                    if (cjB.aPD != 1) {
                        if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                            a.this.hIx.ciT().errSubReason = -1;
                        }
                        a.this.hIg.showToast(cjB.aPE);
                        a.this.g((short) 1);
                        return;
                    }
                    if (cjB.mErrorCode != 0) {
                        if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                            a.this.hIx.ciT().errCode = 5;
                            a.this.hIx.ciT().errSubReason = cjB.mErrorCode;
                        }
                        a.this.hIg.showToast(str);
                        if (cjB.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.hIg.getActivity());
                        }
                        a.this.g((short) 1);
                    } else {
                        if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                            a.this.hIx.ciT().errCode = 0;
                            a.this.hIx.ciT().errSubReason = 0;
                        }
                        if (a.this.bFW != null) {
                            a.this.bFW.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.ae.a.Qm().bwx.aMZ);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("clientIp", com.baidu.live.ae.a.Qm().bwx.clientIP);
                                jSONObject.put("liveId", a.this.hHU.Fp().mLiveInfo.live_id);
                                jSONObject.put("roomId", a.this.hHU.Fp().mLiveInfo.room_id);
                                jSONObject.put("subApp", TbConfig.getSubappType());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            a.this.bFW.setStartInfo(jSONObject);
                        }
                        if (a.this.hIx != null) {
                            a.this.hIx.c(a.this.hHU.cjB());
                        }
                        a.this.chj();
                    }
                    if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                        a.this.hIx.ciT().sampleMemAndCPU();
                    }
                }
            } else if (i2 == 2) {
                if (a.this.hIx != null) {
                    a.this.hIx.cif();
                }
            } else if (i2 == 1) {
                a.this.chk();
            } else if (i2 == 7) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    if (alaGetVerifyStrategyResponseHttpMessage.getError() == 0) {
                        if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                            if (alaGetVerifyStrategyResponseHttpMessage.hLj == 2) {
                                a.this.hIx.ciT().errSubReason = -2;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hLj == 3) {
                                a.this.hIx.ciT().errSubReason = -3;
                            }
                        }
                        if (a.this.hIx != null && alaGetVerifyStrategyResponseHttpMessage.hLh == 1 && alaGetVerifyStrategyResponseHttpMessage.hLj == 1 && alaGetVerifyStrategyResponseHttpMessage.hLm == 1 && alaGetVerifyStrategyResponseHttpMessage.hLo == 1) {
                            a.this.hIx.ceL();
                        }
                    } else {
                        BdUtilHelper.showToast(a.this.hIg.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                    }
                }
                if (a.this.hIx != null) {
                    a.this.hIx.cir();
                }
            } else if (i2 == 8) {
                if (obj instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage2 = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                    int i3 = alaGetVerifyStrategyResponseHttpMessage2.hLj != 3 ? 0 : 3;
                    if (a.this.hIw != null && a.this.hIx != null) {
                        a.this.hIw.a(i3, TbadkCoreApplication.getCurrentAccount(), "from_start_live", a.this.mForumName, a.this.mForumId, a.this.hIx.bRl(), a.this.hIp).fa(alaGetVerifyStrategyResponseHttpMessage2.verifyType);
                    }
                }
            } else if (i2 == 10 && a.this.hIx != null) {
                com.baidu.tieba.ala.liveroom.master.a.d dVar = a.this.hIx;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z = true;
                }
                dVar.oj(z);
            }
        }
    };

    public a(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity) {
        this.hIg = alaMasterLiveRoomActivity;
        this.hst = new com.baidu.live.tieba.e.b(this.hIg.getActivity());
        chn();
        this.hqu = new c();
        MessageManager.getInstance().registerListener(this.hIz);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913049, com.baidu.live.ak.a.class, this.hIg.getPageContext());
        if (runTask != null && runTask.getData() != null) {
            this.hIw = (com.baidu.live.ak.a) runTask.getData();
            if (this.hIw != null) {
                this.hIw.a(this.hIA);
            }
        }
    }

    public void a(d dVar) {
        CustomResponsedMessage runTask;
        this.hHU = dVar;
        if (this.hHU == null) {
            this.hHU = new d(this.hIg.getPageContext());
        }
        if (this.bFU == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.hIg.getPageContext().getPageActivity())) != null) {
            this.bFU = (k) runTask.getData();
        }
        if (this.bFU != null) {
            this.bFU.b(null);
            this.bFU.a(null);
            this.bFU.c(null);
        }
        this.hHU.a(this.hIC);
        if (this.hIx != null) {
            this.hIx.setArModel(this.bFU);
            this.hIx.a(this.hHU);
        }
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hIp = str3;
        this.hIr = false;
        ox(false);
        chh();
        if (this.hIx != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.specialForumType = str3;
            fVar.hDR = bundle;
            this.hIx.b(fVar);
            if (this.hIx.bRl() == 1) {
                vN(this.hIx.bRl());
            }
        }
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        this.mForumName = alaLivePersonData.mLiveInfo.forum_name;
        this.mForumId = Long.toString(alaLivePersonData.mLiveInfo.forum_id);
        this.hIt = alaLivePersonData.mLiveInfo.clarity;
        this.hIr = true;
        this.hIq = alaLivePersonData.mLiveInfo.screen_direction == 2;
        ox(true);
        chh();
        if (this.hIx != null) {
            f fVar = new f();
            fVar.forumName = this.mForumName;
            fVar.forumId = this.mForumId;
            fVar.hDQ = alaLivePersonData;
            if (alaLivePersonData.mLiveInfo != null) {
                vN(alaLivePersonData.mLiveInfo.live_type);
            }
            this.hIx.b(fVar);
        }
        if (this.hHU != null) {
            this.hHU.h(alaLivePersonData);
        }
    }

    private void chc() {
        this.hIq = com.baidu.live.d.xf().getBoolean("live_prepare_screen_distance_mode", false);
    }

    private void chd() {
        this.hIt = com.baidu.live.d.xf().getInt("live_recorder_resolution_level", 2);
    }

    private void ox(boolean z) {
        if (!z) {
            chd();
            chc();
        }
        this.hIh = (ViewGroup) View.inflate(this.hIg.getPageContext().getPageActivity(), a.g.ala_liveroom_host_main_layout, null);
        this.hIg.addContentView(this.hIh, new FrameLayout.LayoutParams(-1, -1));
        this.hIg.setContentView(this.hIh);
        this.hIj = (FrameLayout) this.hIh.findViewById(a.f.ala_live_render_view);
        this.hIm = (AlaLiveView) this.hIh.findViewById(a.f.ala_liveroom_host_liveview);
        this.hIm.setVisibility(8);
        this.hIm.setSwipeClearEnable(true);
        this.hIi = (RelativeLayout) this.hIh.findViewById(a.f.ala_live_unremovable_container);
        this.hIn = (ViewGroup) this.hIh.findViewById(a.f.func_view);
        this.hIo = (LayerRootView) this.hIh.findViewById(a.f.layer_root_view);
        com.baidu.live.core.layer.b.Bf().l(this.hIo);
        this.hIi.requestLayout();
        this.hIh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.a.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.hIm == null || a.this.hIm.hTg) {
                    return false;
                }
                a.this.hIm.X(motionEvent);
                a.this.hIk.R(motionEvent);
                return true;
            }
        });
        AlaLiveVideoConfig d = com.baidu.live.z.a.b.PI().d(2, 1, false);
        VideoBeautyType videoBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        if (com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aMN) {
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
        if (bt.b(com.baidu.live.ae.a.Qm().bCs)) {
            videoBeautyType3 = VideoBeautyType.DUMIX_AR;
        } else if (bt.a(com.baidu.live.ae.a.Qm().bCs)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_FACEUNITY;
        } else if (bt.c(com.baidu.live.ae.a.Qm().bCs)) {
            videoBeautyType3 = VideoBeautyType.BEAUTY_TIEBA;
        }
        this.bFW = new AlaLiveRecorder(this.hIg.getPageContext().getPageActivity(), d, VideoRecorderType.CAMERA, new com.baidu.live.z.a.a(), videoBeautyType3);
        this.bFW.addRecorderCallback(this.hIB);
        boolean z2 = com.baidu.live.ae.a.Qm().bwx.aMD;
        this.bFW.setUseDummyVideoCapture(z2);
        this.bFW.setUseDummyAudioCapture(z2);
        com.baidu.live.z.a.b.PI().PK();
        if (!this.hIq && this.bFW.getPreview() != null) {
            che();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SI() {
        if (this.bFW != null && this.bFW.getPreview() != null && this.bFW.getPreview().getParent() != null) {
            ((ViewGroup) this.bFW.getPreview().getParent()).removeView(this.bFW.getPreview());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void che() {
        this.bFW.getPreview().setEnabled(false);
        SI();
        if (this.hIl == null) {
            this.hIj.addView(this.bFW.getPreview(), 0, SH());
        } else {
            this.hIj.addView(this.bFW.getPreview(), 0, chf());
        }
        if (this.hIk == null) {
            this.hIk = new AlaLiveFoucsExposureViewContainer(this.hIj.getContext());
            this.hIk.setFoucsListener(new AlaLiveFoucsExposureViewContainer.a() { // from class: com.baidu.tieba.ala.liveroom.master.a.10
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onFocus(int i, int i2, int i3, int i4) {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hHU != null && a.this.hHU.Fp() != null) {
                        alaLiveInfoData = a.this.hHU.Fp().mLiveInfo;
                    }
                    if (alaLiveInfoData == null || alaLiveInfoData.live_status != 1) {
                        str = UbcStatConstant.Page.LIVE_ACTION;
                    } else {
                        str = "author_liveroom";
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str, "bias_click").setContentExt(jSONObject));
                    if (a.this.bFW != null) {
                        a.this.bFW.onFocus(i, i2, i3, i4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void onExposure(float f) {
                    if (a.this.bFW != null) {
                        a.this.bFW.onExposure(f);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.a
                public void chp() {
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    AlaLiveInfoData alaLiveInfoData = null;
                    if (a.this.hHU != null && a.this.hHU.Fp() != null) {
                        alaLiveInfoData = a.this.hHU.Fp().mLiveInfo;
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
                    if (a.this.bFW != null) {
                        return a.this.bFW.getExposure();
                    }
                    return -1.0f;
                }
            });
            this.hIj.addView(this.hIk, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private FrameLayout.LayoutParams SH() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams chf() {
        int i = BdUtilHelper.getScreenDimensions(this.hIg.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fb(i));
        layoutParams.gravity = 19;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams chg() {
        int i = BdUtilHelper.getScreenDimensions(this.hIg.getPageContext().getPageActivity())[0] / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, h.fb(i));
        layoutParams.gravity = 21;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vN(int i) {
        if (this.hIr) {
            this.bFW.setVideoConfig(com.baidu.live.z.a.b.PI().d(this.hIt, i, this.hIq));
        } else {
            this.bFW.setVideoConfig(com.baidu.live.z.a.b.PI().d(i == 1 ? 0 : this.hIt, i, i == 1 ? this.hIq : false));
        }
    }

    private void chh() {
        this.hIx = new com.baidu.tieba.ala.liveroom.master.a.d(this.hIg, this.bFW, this.hIm, this.hIj, this.hIh, this.hIn, this.hst, this.hIg.cgY(), this.hIk);
        this.hIx.a(this.hHU);
        this.hIx.setArModel(this.bFU);
        this.hIx.a(this.hIy);
    }

    public void chi() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hIg.getPageContext().getPageActivity());
        if (this.bFW != null && this.bFW.getPreview() != null && (this.hIl == null || this.hIl.getParent() == null)) {
            this.bFW.getPreview().setLayoutParams(SH());
        }
        if (this.hIx != null) {
            this.hIx.l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(this.hIg.getActivity()));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hIx != null) {
            this.hIx.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chj() {
        if (this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null) {
            if (this.hIx != null && this.hIx.ciT() != null) {
                this.hIx.ciT().liveID = Long.toString(this.hHU.Fp().mLiveInfo.live_id);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTERLIVE_BEGIN);
                alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_LIVE));
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.hHU.cjB().mLiveInfo.live_id), String.valueOf(this.hHU.cjB().mLiveInfo.room_id), String.valueOf(this.hHU.cjB().mLiveInfo.feed_id), null, false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", String.valueOf(this.hHU.cjB().mLiveInfo.live_id));
                jSONObject.put("room_id", String.valueOf(this.hHU.cjB().mLiveInfo.room_id));
                jSONObject.put("vid", String.valueOf(this.hHU.cjB().mLiveInfo.feed_id));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "live_close", "recordtime").setContentExt(jSONObject));
            this.hIs = System.currentTimeMillis() / 1000;
            this.hHU.B(this.hHU.Fp().mLiveInfo.live_id, this.hIs);
            this.hHU.j(this.hHU.Fp().mLiveInfo.live_id, false);
            com.baidu.live.d.xf().putLong("last_live_room_id", this.hHU.Fp().mLiveInfo.live_id);
            this.hHU.cjG();
            if (this.hIx != null && this.hIx.ciT() != null) {
                if (this.hIx.bRl() == 2) {
                    if (this.hIq) {
                        this.hIx.ciT().liveType = 5;
                    } else {
                        this.hIx.ciT().liveType = 4;
                    }
                } else if (this.hIx.bRl() == 1) {
                    if (this.hIq) {
                        this.hIx.ciT().liveType = 2;
                    } else {
                        this.hIx.ciT().liveType = 1;
                    }
                }
            }
            cho();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chk() {
        final ab Fp = this.hHU.Fp();
        if (Fp != null && Fp.mLiveInfo != null) {
            if (this.hIx == null || !this.hIx.ciQ()) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hHU.B(Fp.mLiveInfo.live_id, a.this.hIs);
                    }
                }, Fp.aJI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aw awVar) {
        if (awVar == null) {
            return false;
        }
        this.hIg.closeLoadingDialog();
        if (awVar.mErrorCode == 6) {
            this.hIg.showToast(awVar.mErrorMsg);
            if (this.hIx != null && this.hIx.ciT() != null) {
                this.hIx.ciT().errSubReason = 6;
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
        if (dVar != null && !dVar.hDB) {
            boolean z = dVar.hDC;
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
            if (this.hIx != null) {
                if (this.hIx.ciT() != null) {
                    this.hIx.ciT().updateTime = System.currentTimeMillis();
                }
                this.hHU.a(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hDD, dVar.hDE ? 1 : 0, this.hIx.bRl(), this.hIq ? 2 : 1, this.hIt, dVar.gameId, dVar.gameName);
            }
        }
    }

    public void chl() {
        if (this.hIx != null && !this.hIx.ciS() && this.hHU.cjB() == null && this.hIx != null) {
            a(this.hIx.ciU());
        }
    }

    public void onStart() {
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
    }

    public void onStop() {
        if (this.hIx != null) {
            this.hIx.markEnterBackground();
        }
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void onResume() {
        if (this.bFW != null) {
            this.bFW.setIsAutoStartFromBack(true);
        }
        if (this.hIx != null) {
            this.hIx.markEnterForeground();
        }
    }

    public void onPause() {
        if (this.hIx != null) {
            this.hIx.onPause();
        }
    }

    public void onFinish() {
        if (this.hIx != null) {
            this.hIx.j(this.hIv);
        }
    }

    public void onDestroy() {
        if (this.hqu != null) {
            this.hqu.release();
            this.hqu = null;
        }
        if (this.hIx != null) {
            this.hIx.onDestroy();
        }
        if (this.hIw != null) {
            this.hIw.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.hst.stop();
        this.hst = null;
        if (this.hHU != null) {
            this.hHU.destory();
            this.hHU = null;
        }
        if (this.bFU != null) {
            this.bFU.destory();
            this.bFU = null;
        }
        if (this.bFW != null) {
            ap apVar = new ap();
            apVar.aLB = this.hIq ? 2 : 1;
            apVar.mOpenType = 2;
            if (this.hIx != null) {
                apVar.aLA = this.hIx.bRl();
            }
            this.bFW.setRoomInfo(apVar.toJsonString());
            String str = "";
            if (this.hIx != null && this.hIx.ciT() != null) {
                if (this.hIx.ciT().startLiveTime != 0) {
                    str = Long.toString(this.hIx.ciT().startLiveTime);
                }
                this.bFW.setConfigBeforeStop(this.hIx.ciT().getCpuMemJsonFormat(), str, "");
            }
            this.bFW.stopRecord();
            this.bFW.release();
            this.bFW.removeRecorderCallback(this.hIB);
            this.bFW = null;
        }
        if (this.hIm != null) {
            this.hIm.setOnTouchListener(null);
            this.hIm.clx();
            this.hIm = null;
        }
        this.hIg = null;
        MessageManager.getInstance().unRegisterListener(this.hIz);
        AlaLiveRecorderConfig.setFaceUnityCallback(null);
    }

    public void cs(int i) {
        this.hIm.cs(i);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.hIg.getPageContext().getPageActivity());
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.hIg.getPageContext().getPageActivity(), 48.0f) : 0;
        if (i == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hIh.getLayoutParams();
            layoutParams.topMargin = dip2px;
            this.hIh.setLayoutParams(layoutParams);
            if (this.hIr && this.bFW != null && this.bFW.getPreview() != null && this.bFW.getPreview().getParent() == null) {
                che();
            }
        }
        if (this.hIx != null) {
            this.hIx.l(screenDimensions[0], screenDimensions[1] - dip2px, UtilHelper.getRealScreenOrientation(this.hIg.getActivity()));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hIx != null) {
            this.hIx.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hIx != null) {
            this.hIx.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private int chm() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chn() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hIx != null && a.this.hIx.ciT() != null) {
                        a.this.hIx.ciT().sampleMemAndCPU();
                    }
                    a.this.chn();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cho() {
        if (this.mHandler != null && this.bFW != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.vO(0);
                    a.this.cho();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(int i) {
        if (this.hIx != null && this.hIx.ciT() != null) {
            e eVar = new e();
            AlaLiveExceptionInfo alaLiveExceptionInfo = new AlaLiveExceptionInfo();
            alaLiveExceptionInfo.mediaStatus = this.bFW.getMediaStatus();
            if (this.hHU != null && this.hHU.cjB() != null && this.hHU.cjB().mLiveInfo != null) {
                alaLiveExceptionInfo.liveID = this.hHU.cjB().mLiveInfo.live_id;
                alaLiveExceptionInfo.streamUrl = this.hHU.cjB().mLiveInfo.getPushUrl();
            }
            AlaLiveDebugInfo recorderDebugInfo = this.bFW.getRecorderDebugInfo();
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
            if (this.hIg != null) {
                alaLiveExceptionInfo.appState = this.hIg.isBackground() ? 2 : 0;
            }
            alaLiveExceptionInfo.videoLevel = this.hIu;
            alaLiveExceptionInfo.sessionChannel = chm();
            alaLiveExceptionInfo.nodeIP = this.bFW.getPushStreamIp();
            alaLiveExceptionInfo.lostRate = (float) this.hIx.ciT().lostRate;
            alaLiveExceptionInfo.phone = TbadkCoreApplication.getInst().getIsPhoneCalling();
            alaLiveExceptionInfo.liveType = this.hIx.ciT().liveType;
            alaLiveExceptionInfo.networkType = BdNetTypeUtil.netTypeNameInUpperCase();
            alaLiveExceptionInfo.status = 1;
            alaLiveExceptionInfo.connect = BdNetTypeUtil.isNetWorkAvailable();
            eVar.a(alaLiveExceptionInfo);
            this.hIx.ciT().reset();
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hIx != null) {
            return this.hIx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void g(short s) {
        this.hIy.g(s);
    }

    public void VF() {
        if (this.hIx != null) {
            this.hIx.VF();
        }
    }
}
