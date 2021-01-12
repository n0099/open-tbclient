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
/* loaded from: classes10.dex */
public class c extends a {
    private CustomMessageListener bAU;
    private int bwk;
    private TextView bzV;
    private long enterTime;
    private com.baidu.tieba.ala.category.b.a hEX;
    private e.a hMU;
    private LinearLayout hMV;
    private ImageView hMW;
    private ImageView hMX;
    private ImageView hMY;
    private View hMZ;
    private FrameLayout hNA;
    private LinearLayout hNB;
    private View.OnClickListener hNC;
    private View.OnClickListener hND;
    private HttpMessageListener hNE;
    private CustomMessageListener hNF;
    private HttpMessageListener hNG;
    private CustomMessageListener hNH;
    private ImageView hNa;
    private RoundRectRelativeLayout hNb;
    private TbImageView hNc;
    private TextView hNd;
    private boolean hNe;
    private String hNf;
    private boolean hNg;
    private String hNh;
    private boolean hNi;
    private ImageView hNj;
    private com.baidu.tieba.ala.liveroom.share.d hNk;
    private List<String> hNl;
    private String hNm;
    private String hNn;
    private Random hNo;
    private int hNp;
    private boolean hNq;
    protected View hNr;
    private CheckedTextView hNs;
    private l hNt;
    private boolean hNu;
    private Boolean hNv;
    private boolean hNw;
    AlaLivePerfBaseData hNx;
    private RelativeLayout hNy;
    private TextView hNz;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.activeview.b hlX;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hNe = false;
        this.hNg = false;
        this.hNi = false;
        this.hNp = 0;
        this.hNq = false;
        this.handler = new Handler();
        this.bwk = 0;
        this.hNu = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.cjW();
                c.this.hNi = z;
                c.this.cks();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.cjW();
                if (z) {
                    c.this.hMX.setEnabled(false);
                    c.this.hMX.setVisibility(4);
                    c.this.hNi = false;
                    c.this.cks();
                    return;
                }
                c.this.hMX.setEnabled(true);
                c.this.hMX.setVisibility(0);
                if (c.this.bya.isFlashingLightOpen()) {
                    c.this.hNi = true;
                    c.this.cks();
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
                boolean isBackCamera = c.this.bya.isBackCamera();
                if (!isBackCamera) {
                    c.this.hMX.setEnabled(false);
                    c.this.hMX.setVisibility(4);
                } else {
                    c.this.hMX.setEnabled(true);
                    c.this.hMX.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hNi = c.this.bya.isFlashingLightOpen();
                    c.this.cks();
                }
                if (c.this.bya.hasBeauty() >= 0) {
                    c.this.bya.setBeauty(com.baidu.live.d.xf().getInt("live_beauty_level", 3));
                }
                c.this.Qw();
                if (!z && c.this.hMU != null) {
                    c.this.hMU.cho();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hNe) {
                    c.this.cku();
                    c.this.hNe = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hMU != null) {
                    c.this.hMU.chp();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
                c.this.hNx.sampleMemAndCPU();
                c.this.hNx.getCpuMemJsonFormat();
            }
        };
        this.hNx = new AlaLivePerfBaseData();
        this.hNC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bya != null) {
                        c.this.bya.switchFlashingLight();
                        c.this.hNi = c.this.bya.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.cks();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hND = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.cjW();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hKT != null) {
                                    c.this.hKT.chq();
                                    return;
                                }
                                return;
                            }
                            c.this.cjS();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hNe = true;
                        c.this.bya.stopRecord();
                        if (TextUtils.isEmpty(c.this.hNh)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bya != null) {
                                c.this.bya.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_beauty || view.getId() == a.f.beauty_textView) {
                        c.this.hNu = true;
                        com.baidu.live.d.xf().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hKT != null) {
                            c.this.hKT.chs();
                        }
                        if (c.this.hNw) {
                            c.this.oG(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hNr != null && c.this.mRootView.indexOfChild(c.this.hNr) >= 0) {
                                    c.this.mRootView.removeView(c.this.hNr);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hKT != null) {
                            c.this.hKT.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.ckA();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.ckt();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hEX), com.baidu.tieba.ala.category.b.a.b(c.this.hEX))));
                    }
                }
            }
        };
        this.hNE = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hFp != null && livePrepareListHttpResponseMessage.hFp.size() > 0) {
                        c.this.hNl = new ArrayList(livePrepareListHttpResponseMessage.hFp);
                        c.this.ckA();
                    } else {
                        c.this.hNl = new ArrayList();
                    }
                    c.this.hNm = livePrepareListHttpResponseMessage.hFn;
                    c.this.hNn = livePrepareListHttpResponseMessage.hFo;
                }
            }
        };
        this.bAU = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aAx != null) {
                    if (data.aAx.aAG == 1) {
                        if (!c.this.hNu) {
                            c.this.z(data.aAx.mText, 1500L);
                        } else {
                            return;
                        }
                    }
                    com.baidu.live.d.xf().putInt("beauty_new_bubble", data.aAx.aAG);
                    com.baidu.live.d.xf().putInt("beauty_subitem_redot", data.aAx.aAH);
                    com.baidu.live.d.xf().putInt("beauty_tab_redot", data.aAx.aAI);
                }
            }
        };
        this.hNF = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
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
                if (gVar == null || !gVar.yO()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage not show");
                    }
                } else if (c.this.hNw || c.this.ckw()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hNw + ", tiped=" + c.this.ckw());
                    }
                } else {
                    c.this.hNw = true;
                    c.this.z(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hNG = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hEX = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).chS();
                    }
                    c.this.ckz();
                }
            }
        };
        this.hNH = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hEX = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.ckz();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.ckz();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        ckx();
        cky();
        MessageManager.getInstance().registerListener(this.hNE);
        MessageManager.getInstance().registerListener(this.bAU);
        MessageManager.getInstance().registerListener(this.hNF);
        MessageManager.getInstance().registerListener(this.hNG);
        MessageManager.getInstance().registerListener(this.hNH);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.hNo = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hNk = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hNk.o(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hNk.cB(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hNk = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hNk != null) {
            this.hNk.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hNf = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.cjV();
                c.this.cjW();
                return false;
            }
        });
        cjN();
        this.hKP.setOnClickListener(this.hND);
        this.hMV = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hNb = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hNc = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hNd = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hNc.setIsRound(false);
        this.hNc.setGifIconSupport(false);
        String cjR = cjR();
        this.hNd.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(cjR)) {
            this.hNc.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            m.a(this.hNc, cjR, true, false);
            this.hNd.setText(a.h.ala_live_change_cover);
            this.hNh = cjR;
        }
        this.hKP.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hMW = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hMW.setOnClickListener(this.hND);
        this.hMY = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hMY.setOnClickListener(this.hND);
        this.hMX = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hNB = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hMZ = this.mRootView.findViewById(a.f.beauty_layout);
        this.hNa = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bzV = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hNa.setOnClickListener(this.hND);
        this.bzV.setOnClickListener(this.hND);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hMV.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hMV.setLayoutParams(layoutParams);
        }
        this.hNy = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hNz = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hNA = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hNy.setOnClickListener(this.hND);
        this.hNj = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hNj.setOnClickListener(this.hND);
        this.hNs = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hNs.setOnClickListener(this.hND);
        Dn();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hNq = true;
        ckq();
        ckr();
        this.enterTime = System.currentTimeMillis();
    }

    private s ckp() {
        if (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKp == null) {
            return null;
        }
        return com.baidu.live.af.a.OJ().bru.aKp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckq() {
        s ckp = ckp();
        if (ckp != null && ckp.aFU != null && ckp.aFU.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hNt = ckp.aFU.get(this.hNp % ckp.aFU.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hNt.getText());
            this.hNy.setVisibility(0);
            this.hNz.setText(sb);
            this.hNp++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hNq) {
                        c.this.ckq();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hNy.setVisibility(8);
    }

    private void ckr() {
        if (com.baidu.live.d.xf().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hNy != null && this.hNy.getVisibility() == 0) {
            com.baidu.live.d.xf().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hNA.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        super.destroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Hy(String str) {
        com.baidu.live.d.xf().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void Dn() {
        this.hNb.setOnClickListener(this.hND);
        this.hMX.setOnClickListener(this.hNC);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void cjW() {
        if (this.hKT != null) {
            this.hKT.cht();
        }
    }

    public void cdD() {
        cjS();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int cjX() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean cjY() {
        return false;
    }

    public boolean cdB() {
        if (this.hNk != null) {
            this.hNk.cjv();
        }
        return this.hNk != null && this.hNk.cdB();
    }

    public void cdC() {
        if (this.hNk != null) {
            this.hNk.x(this.hNh, getLiveTitle(), this.hNm, this.hNn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cks() {
        if (this.hNi) {
            this.hMX.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hMX.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckt() {
        this.hNA.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.hlX == null) {
                this.hlX = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hNt != null && !TextUtils.isEmpty(this.hNt.AF())) {
                this.hlX.GR(this.hNt.AF());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.hNr != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hNr = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hNr.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hNr != null) {
                        int[] iArr = new int[2];
                        c.this.hMZ.getLocationOnScreen(iArr);
                        c.this.hNr.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hMZ.getWidth() / 2)) - (c.this.hNr.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hNr.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hNr.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hNr, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qw() {
        if (bo.c(com.baidu.live.af.a.OJ().bxp)) {
            this.hMZ.setVisibility(0);
            if (bo.c(com.baidu.live.af.a.OJ().bxp)) {
                this.hNa.setAlpha(0.2f);
                this.bzV.setAlpha(0.2f);
            }
        } else if (this.bya != null && this.bya.hasBeauty() < 0) {
            this.hMZ.setVisibility(8);
        } else {
            this.hMZ.setVisibility(0);
        }
    }

    public boolean cdx() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cku() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Hd(String str) {
        this.hNg = true;
        this.hNh = str;
        this.hNd.setText(a.h.ala_live_change_cover);
        Hy(str);
        m.a(this.hNc, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String cdA() {
        return cjR();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        ckv();
        Qw();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a cjU() {
        return this.hEX;
    }

    public void cdu() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.Og().d(2, 1, false));
    }

    private void ckv() {
        if (this.bya != null) {
            Qw();
            if (this.bya.isBackCamera()) {
                this.hMX.setEnabled(true);
                this.hMX.setVisibility(0);
                this.hNi = this.bya.isFlashingLightOpen();
            } else {
                this.hMX.setEnabled(false);
                this.hMX.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bya != null) {
                        c.this.bya.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        cjW();
        if (this.hNk != null && z) {
            this.hNk.cju();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bQu() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hMU = aVar;
    }

    public void onResume() {
        this.hNe = false;
        if (this.bya != null) {
            if (this.bya.isBackCamera()) {
                this.hMX.setEnabled(true);
                this.hMX.setVisibility(0);
                this.hNi = this.bya.isFlashingLightOpen();
                cks();
            } else {
                this.hMX.setEnabled(false);
                this.hMX.setVisibility(4);
            }
        }
        if (this.hKQ != null && this.hKQ.ckD() && TextUtils.isEmpty(this.hKQ.ckJ())) {
            this.hKQ.ckI();
        }
        if (!ckw()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ckw() {
        if (this.hNv == null) {
            this.hNv = Boolean.valueOf(com.baidu.live.d.xf().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + ckw());
            }
        }
        return this.hNv.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oG(boolean z) {
        if (ckw() != z) {
            this.hNv = Boolean.valueOf(z);
            com.baidu.live.d.xf().putBoolean("makeup_new_bubble_tiped", this.hNv.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hNv);
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

    public void nW(boolean z) {
        this.hKP.setClickable(z);
    }

    public void release() {
        this.hNq = true;
        if (this.bya != null) {
            this.bya.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hNE);
        MessageManager.getInstance().unRegisterListener(this.bAU);
        MessageManager.getInstance().unRegisterListener(this.hNF);
        MessageManager.getInstance().unRegisterListener(this.hNG);
        MessageManager.getInstance().unRegisterListener(this.hNH);
        if (this.hNk != null) {
            this.hNk.release();
        }
        if (this.hlX != null) {
            this.hlX.release();
            this.hlX = null;
        }
    }

    private void ckx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cky() {
        if (ao.AY()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckz() {
        if (ao.AY()) {
            this.hNs.setVisibility(0);
            if (this.hEX != null && this.hEX.bSJ() != null && !StringUtils.isNull(this.hEX.bSJ().getName())) {
                this.hNs.setText(this.hEX.bSJ().getName());
                this.hNs.setChecked(true);
                return;
            }
            this.hNs.setText(a.h.ala_live_prepare_select_livetype);
            this.hNs.setChecked(false);
            return;
        }
        this.hNs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckA() {
        if (this.hNo != null && this.hNl != null && this.hNl.size() > 0) {
            String str = this.hNl.get(this.hNo.nextInt(100) % this.hNl.size());
            if (!TextUtils.isEmpty(str)) {
                this.hKK.clearFocus();
                this.hKK.setText(str);
            }
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.n.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a cs = aVar.cs(true);
            View rootLayout = cs.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            cs.setTargetView(this.hKP);
            this.hNB.addView(rootLayout, 0);
            aVar.KR();
        }
    }
}
