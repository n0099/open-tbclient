package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.ar.g;
import com.baidu.live.data.AlaLivePerfBaseData;
import com.baidu.live.data.ao;
import com.baidu.live.data.bo;
import com.baidu.live.data.l;
import com.baidu.live.data.s;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveCategoryActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlbumActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.messages.AlaGetAnchorCategoryResponseMessagge;
import com.baidu.tieba.ala.liveroom.messages.LivePrepareListHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends a {
    private int bAW;
    private TextView bEH;
    private CustomMessageListener bFG;
    private long enterTime;
    private com.baidu.tieba.ala.category.b.a hJD;
    private e.a hRA;
    private LinearLayout hRB;
    private ImageView hRC;
    private ImageView hRD;
    private ImageView hRE;
    private View hRF;
    private ImageView hRG;
    private RoundRectRelativeLayout hRH;
    private TbImageView hRI;
    private TextView hRJ;
    private boolean hRK;
    private String hRL;
    private boolean hRM;
    private String hRN;
    private boolean hRO;
    private ImageView hRP;
    private com.baidu.tieba.ala.liveroom.share.d hRQ;
    private List<String> hRR;
    private String hRS;
    private String hRT;
    private Random hRU;
    private int hRV;
    private boolean hRW;
    protected View hRX;
    private CheckedTextView hRY;
    private l hRZ;
    private boolean hSa;
    private Boolean hSb;
    private boolean hSc;
    AlaLivePerfBaseData hSd;
    private RelativeLayout hSe;
    private TextView hSf;
    private FrameLayout hSg;
    private LinearLayout hSh;
    private View.OnClickListener hSi;
    private View.OnClickListener hSj;
    private HttpMessageListener hSk;
    private CustomMessageListener hSl;
    private HttpMessageListener hSm;
    private CustomMessageListener hSn;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.activeview.b hqE;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hRK = false;
        this.hRM = false;
        this.hRO = false;
        this.hRV = 0;
        this.hRW = false;
        this.handler = new Handler();
        this.bAW = 0;
        this.hSa = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.cnN();
                c.this.hRO = z;
                c.this.coj();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.cnN();
                if (z) {
                    c.this.hRD.setEnabled(false);
                    c.this.hRD.setVisibility(4);
                    c.this.hRO = false;
                    c.this.coj();
                    return;
                }
                c.this.hRD.setEnabled(true);
                c.this.hRD.setVisibility(0);
                if (c.this.bCM.isFlashingLightOpen()) {
                    c.this.hRO = true;
                    c.this.coj();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void streamLostPackageRateReceived(double d) {
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStart(boolean z, int i, int i2) {
                boolean isBackCamera = c.this.bCM.isBackCamera();
                if (!isBackCamera) {
                    c.this.hRD.setEnabled(false);
                    c.this.hRD.setVisibility(4);
                } else {
                    c.this.hRD.setEnabled(true);
                    c.this.hRD.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hRO = c.this.bCM.isFlashingLightOpen();
                    c.this.coj();
                }
                if (c.this.bCM.hasBeauty() >= 0) {
                    c.this.bCM.setBeauty(com.baidu.live.d.Ba().getInt("live_beauty_level", 3));
                }
                c.this.Ur();
                if (!z && c.this.hRA != null) {
                    c.this.hRA.clf();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hRK) {
                    c.this.col();
                    c.this.hRK = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hRA != null) {
                    c.this.hRA.clg();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
                c.this.hSd.sampleMemAndCPU();
                c.this.hSd.getCpuMemJsonFormat();
            }
        };
        this.hSd = new AlaLivePerfBaseData();
        this.hSi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bCM != null) {
                        c.this.bCM.switchFlashingLight();
                        c.this.hRO = c.this.bCM.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.coj();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hSj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.cnN();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hPz != null) {
                                    c.this.hPz.clh();
                                    return;
                                }
                                return;
                            }
                            c.this.cnJ();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hRK = true;
                        c.this.bCM.stopRecord();
                        if (TextUtils.isEmpty(c.this.hRN)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bCM != null) {
                                c.this.bCM.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_beauty || view.getId() == a.f.beauty_textView) {
                        c.this.hSa = true;
                        com.baidu.live.d.Ba().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hPz != null) {
                            c.this.hPz.clj();
                        }
                        if (c.this.hSc) {
                            c.this.oK(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hRX != null && c.this.mRootView.indexOfChild(c.this.hRX) >= 0) {
                                    c.this.mRootView.removeView(c.this.hRX);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hPz != null) {
                            c.this.hPz.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.cor();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.cok();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hJD), com.baidu.tieba.ala.category.b.a.b(c.this.hJD))));
                    }
                }
            }
        };
        this.hSk = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hJV != null && livePrepareListHttpResponseMessage.hJV.size() > 0) {
                        c.this.hRR = new ArrayList(livePrepareListHttpResponseMessage.hJV);
                        c.this.cor();
                    } else {
                        c.this.hRR = new ArrayList();
                    }
                    c.this.hRS = livePrepareListHttpResponseMessage.hJT;
                    c.this.hRT = livePrepareListHttpResponseMessage.hJU;
                }
            }
        };
        this.bFG = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aFk != null) {
                    if (data.aFk.aFt == 1) {
                        if (!c.this.hSa) {
                            c.this.z(data.aFk.mText, 1500L);
                        } else {
                            return;
                        }
                    }
                    com.baidu.live.d.Ba().putInt("beauty_new_bubble", data.aFk.aFt);
                    com.baidu.live.d.Ba().putInt("beauty_subitem_redot", data.aFk.aFu);
                    com.baidu.live.d.Ba().putInt("beauty_tab_redot", data.aFk.aFv);
                }
            }
        };
        this.hSl = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.isDebug()) {
                    c.this.d("onMessage ..." + customResponsedMessage);
                }
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof g)) {
                    if (c.isDebug()) {
                        c.this.d("onMessage null");
                        return;
                    }
                    return;
                }
                g gVar = (g) customResponsedMessage.getData();
                if (gVar == null || !gVar.CJ()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage not show");
                    }
                } else if (c.this.hSc || c.this.con()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hSc + ", tiped=" + c.this.con());
                    }
                } else {
                    c.this.hSc = true;
                    c.this.z(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hSm = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hJD = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).clJ();
                    }
                    c.this.coq();
                }
            }
        };
        this.hSn = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hJD = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.coq();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.coq();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        coo();
        cop();
        MessageManager.getInstance().registerListener(this.hSk);
        MessageManager.getInstance().registerListener(this.bFG);
        MessageManager.getInstance().registerListener(this.hSl);
        MessageManager.getInstance().registerListener(this.hSm);
        MessageManager.getInstance().registerListener(this.hSn);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.hRU = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hRQ = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hRQ.o(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hRQ.cB(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hRQ = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hRQ != null) {
            this.hRQ.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hRL = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.cnM();
                c.this.cnN();
                return false;
            }
        });
        cnE();
        this.hPv.setOnClickListener(this.hSj);
        this.hRB = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hRH = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hRI = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hRJ = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hRI.setIsRound(false);
        this.hRI.setGifIconSupport(false);
        String cnI = cnI();
        this.hRJ.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(cnI)) {
            this.hRI.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            m.a(this.hRI, cnI, true, false);
            this.hRJ.setText(a.h.ala_live_change_cover);
            this.hRN = cnI;
        }
        this.hPv.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hRC = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hRC.setOnClickListener(this.hSj);
        this.hRE = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hRE.setOnClickListener(this.hSj);
        this.hRD = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hSh = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hRF = this.mRootView.findViewById(a.f.beauty_layout);
        this.hRG = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bEH = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hRG.setOnClickListener(this.hSj);
        this.bEH.setOnClickListener(this.hSj);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hRB.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hRB.setLayoutParams(layoutParams);
        }
        this.hSe = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hSf = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hSg = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hSe.setOnClickListener(this.hSj);
        this.hRP = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hRP.setOnClickListener(this.hSj);
        this.hRY = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hRY.setOnClickListener(this.hSj);
        Hi();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hRW = true;
        coh();
        coi();
        this.enterTime = System.currentTimeMillis();
    }

    private s cog() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPc == null) {
            return null;
        }
        return com.baidu.live.af.a.SE().bwi.aPc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coh() {
        s cog = cog();
        if (cog != null && cog.aKH != null && cog.aKH.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hRZ = cog.aKH.get(this.hRV % cog.aKH.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hRZ.getText());
            this.hSe.setVisibility(0);
            this.hSf.setText(sb);
            this.hRV++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hRW) {
                        c.this.coh();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hSe.setVisibility(8);
    }

    private void coi() {
        if (com.baidu.live.d.Ba().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hSe != null && this.hSe.getVisibility() == 0) {
            com.baidu.live.d.Ba().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hSg.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        super.destroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void IK(String str) {
        com.baidu.live.d.Ba().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void Hi() {
        this.hRH.setOnClickListener(this.hSj);
        this.hRD.setOnClickListener(this.hSi);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void cnN() {
        if (this.hPz != null) {
            this.hPz.clk();
        }
    }

    public void chu() {
        cnJ();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int cnO() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean cnP() {
        return false;
    }

    public boolean chs() {
        if (this.hRQ != null) {
            this.hRQ.cnm();
        }
        return this.hRQ != null && this.hRQ.chs();
    }

    public void cht() {
        if (this.hRQ != null) {
            this.hRQ.x(this.hRN, getLiveTitle(), this.hRS, this.hRT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coj() {
        if (this.hRO) {
            this.hRD.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hRD.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cok() {
        this.hSg.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.hqE == null) {
                this.hqE = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hRZ != null && !TextUtils.isEmpty(this.hRZ.EA())) {
                this.hqE.Id(this.hRZ.EA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.hRX != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hRX = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hRX.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hRX != null) {
                        int[] iArr = new int[2];
                        c.this.hRF.getLocationOnScreen(iArr);
                        c.this.hRX.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hRF.getWidth() / 2)) - (c.this.hRX.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hRX.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hRX.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hRX, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        if (bo.c(com.baidu.live.af.a.SE().bCb)) {
            this.hRF.setVisibility(0);
            if (bo.c(com.baidu.live.af.a.SE().bCb)) {
                this.hRG.setAlpha(0.2f);
                this.bEH.setAlpha(0.2f);
            }
        } else if (this.bCM != null && this.bCM.hasBeauty() < 0) {
            this.hRF.setVisibility(8);
        } else {
            this.hRF.setVisibility(0);
        }
    }

    public boolean cho() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void col() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Ip(String str) {
        this.hRM = true;
        this.hRN = str;
        this.hRJ.setText(a.h.ala_live_change_cover);
        IK(str);
        m.a(this.hRI, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String chr() {
        return cnI();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        com();
        Ur();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a cnL() {
        return this.hJD;
    }

    public void chl() {
        this.bCM.setVideoConfig(LiveRecorderConfigHelper.Sb().d(2, 1, false));
    }

    private void com() {
        if (this.bCM != null) {
            Ur();
            if (this.bCM.isBackCamera()) {
                this.hRD.setEnabled(true);
                this.hRD.setVisibility(0);
                this.hRO = this.bCM.isFlashingLightOpen();
            } else {
                this.hRD.setEnabled(false);
                this.hRD.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bCM != null) {
                        c.this.bCM.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        cnN();
        if (this.hRQ != null && z) {
            this.hRQ.cnl();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bUl() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hRA = aVar;
    }

    public void onResume() {
        this.hRK = false;
        if (this.bCM != null) {
            if (this.bCM.isBackCamera()) {
                this.hRD.setEnabled(true);
                this.hRD.setVisibility(0);
                this.hRO = this.bCM.isFlashingLightOpen();
                coj();
            } else {
                this.hRD.setEnabled(false);
                this.hRD.setVisibility(4);
            }
        }
        if (this.hPw != null && this.hPw.cou() && TextUtils.isEmpty(this.hPw.coA())) {
            this.hPw.coz();
        }
        if (!con()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean con() {
        if (this.hSb == null) {
            this.hSb = Boolean.valueOf(com.baidu.live.d.Ba().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + con());
            }
        }
        return this.hSb.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oK(boolean z) {
        if (con() != z) {
            this.hSb = Boolean.valueOf(z);
            com.baidu.live.d.Ba().putBoolean("makeup_new_bubble_tiped", this.hSb.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hSb);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        CustomMessage customMessage = new CustomMessage(2913246);
        customMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(customMessage);
        if (isDebug()) {
            d("requestMakeupData sendMessage ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Log.d("getMakeupData_ComView", str);
    }

    public void onRefresh() {
    }

    public void oa(boolean z) {
        this.hPv.setClickable(z);
    }

    public void release() {
        this.hRW = true;
        if (this.bCM != null) {
            this.bCM.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hSk);
        MessageManager.getInstance().unRegisterListener(this.bFG);
        MessageManager.getInstance().unRegisterListener(this.hSl);
        MessageManager.getInstance().unRegisterListener(this.hSm);
        MessageManager.getInstance().unRegisterListener(this.hSn);
        if (this.hRQ != null) {
            this.hRQ.release();
        }
        if (this.hqE != null) {
            this.hqE.release();
            this.hqE = null;
        }
    }

    private void coo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cop() {
        if (ao.ET()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coq() {
        if (ao.ET()) {
            this.hRY.setVisibility(0);
            if (this.hJD != null && this.hJD.bWA() != null && !StringUtils.isNull(this.hJD.bWA().getName())) {
                this.hRY.setText(this.hJD.bWA().getName());
                this.hRY.setChecked(true);
                return;
            }
            this.hRY.setText(a.h.ala_live_prepare_select_livetype);
            this.hRY.setChecked(false);
            return;
        }
        this.hRY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cor() {
        if (this.hRU != null && this.hRR != null && this.hRR.size() > 0) {
            String str = this.hRR.get(this.hRU.nextInt(100) % this.hRR.size());
            if (!TextUtils.isEmpty(str)) {
                this.hPq.clearFocus();
                this.hPq.setText(str);
            }
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.n.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a cw = aVar.cw(true);
            View rootLayout = cw.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            cw.setTargetView(this.hPv);
            this.hSh.addView(rootLayout, 0);
            aVar.OM();
        }
    }
}
