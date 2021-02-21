package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import com.baidu.live.data.as;
import com.baidu.live.data.bt;
import com.baidu.live.data.p;
import com.baidu.live.data.w;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
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
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
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
    private TextView bDB;
    private CustomMessageListener bEA;
    private int bzM;
    private long enterTime;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private com.baidu.tieba.ala.category.b.a hJx;
    private e.a hRC;
    private LinearLayout hRD;
    private ImageView hRE;
    private ImageView hRF;
    private ImageView hRG;
    private View hRH;
    private ImageView hRI;
    private RoundRectRelativeLayout hRJ;
    private TbImageView hRK;
    private TextView hRL;
    private boolean hRM;
    private String hRN;
    private boolean hRO;
    private String hRP;
    private boolean hRQ;
    private ImageView hRR;
    private com.baidu.tieba.ala.liveroom.share.d hRS;
    private List<String> hRT;
    private String hRU;
    private String hRV;
    private Random hRW;
    private int hRX;
    private boolean hRY;
    protected View hRZ;
    private String hSa;
    private boolean hSb;
    private CheckedTextView hSc;
    private p hSd;
    private boolean hSe;
    private Boolean hSf;
    private boolean hSg;
    AlaLivePerfBaseData hSh;
    private RelativeLayout hSi;
    private TextView hSj;
    private FrameLayout hSk;
    private LinearLayout hSl;
    private View.OnClickListener hSm;
    private View.OnClickListener hSn;
    private HttpMessageListener hSo;
    private CustomMessageListener hSp;
    private HttpMessageListener hSq;
    private CustomMessageListener hSr;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.activeview.b hqz;
    private long lastClickTime;
    private Handler mHandler;
    private boolean mIsKeyboardOpen;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hRM = false;
        this.hRO = false;
        this.hRQ = false;
        this.hRX = 0;
        this.hRY = false;
        this.handler = new Handler();
        this.mIsKeyboardOpen = false;
        this.hSb = false;
        this.bzM = 0;
        this.hSe = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.clb();
                c.this.hRQ = z;
                c.this.clx();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.clb();
                if (z) {
                    c.this.hRF.setEnabled(false);
                    c.this.hRF.setVisibility(4);
                    c.this.hRQ = false;
                    c.this.clx();
                    return;
                }
                c.this.hRF.setEnabled(true);
                c.this.hRF.setVisibility(0);
                if (c.this.bBG.isFlashingLightOpen()) {
                    c.this.hRQ = true;
                    c.this.clx();
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
                boolean isBackCamera = c.this.bBG.isBackCamera();
                if (!isBackCamera) {
                    c.this.hRF.setEnabled(false);
                    c.this.hRF.setVisibility(4);
                } else {
                    c.this.hRF.setEnabled(true);
                    c.this.hRF.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hRQ = c.this.bBG.isFlashingLightOpen();
                    c.this.clx();
                }
                if (c.this.bBG.hasBeauty() >= 0) {
                    c.this.bBG.setBeauty(com.baidu.live.d.xc().getInt("live_beauty_level", 3));
                }
                c.this.Sg();
                if (!z && c.this.hRC != null) {
                    c.this.hRC.cio();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hRM) {
                    c.this.clz();
                    c.this.hRM = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hRC != null) {
                    c.this.hRC.cip();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
                c.this.hSh.sampleMemAndCPU();
                c.this.hSh.getCpuMemJsonFormat();
            }
        };
        this.hSh = new AlaLivePerfBaseData();
        this.hSm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bBG != null) {
                        c.this.bBG.switchFlashingLight();
                        c.this.hRQ = c.this.bBG.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.clx();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hSn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.clb();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hPB != null) {
                                    c.this.hPB.ciq();
                                    return;
                                }
                                return;
                            }
                            c.this.ckX();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hRM = true;
                        c.this.bBG.stopRecord();
                        if (TextUtils.isEmpty(c.this.hRP)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bBG != null) {
                                c.this.bBG.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_beauty || view.getId() == a.f.beauty_textView) {
                        c.this.hSe = true;
                        com.baidu.live.d.xc().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hPB != null) {
                            c.this.hPB.cis();
                        }
                        if (c.this.hSg) {
                            c.this.oQ(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hRZ != null && c.this.mRootView.indexOfChild(c.this.hRZ) >= 0) {
                                    c.this.mRootView.removeView(c.this.hRZ);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hPB != null) {
                            c.this.hPB.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.hSb = false;
                        c.this.clF();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.cly();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hJx), com.baidu.tieba.ala.category.b.a.b(c.this.hJx))));
                    }
                }
            }
        };
        this.hSo = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hJP != null && livePrepareListHttpResponseMessage.hJP.size() > 0) {
                        c.this.hRT = new ArrayList(livePrepareListHttpResponseMessage.hJP);
                        c.this.clF();
                    } else {
                        c.this.hRT = new ArrayList();
                    }
                    c.this.hRU = livePrepareListHttpResponseMessage.hJN;
                    c.this.hRV = livePrepareListHttpResponseMessage.hJO;
                }
            }
        };
        this.bEA = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aCc != null) {
                    if (data.aCc.aCl == 1) {
                        if (!c.this.hSe) {
                            c.this.y(data.aCc.mText, 1500L);
                        } else {
                            return;
                        }
                    }
                    com.baidu.live.d.xc().putInt("beauty_new_bubble", data.aCc.aCl);
                    com.baidu.live.d.xc().putInt("beauty_subitem_redot", data.aCc.aCm);
                    com.baidu.live.d.xc().putInt("beauty_tab_redot", data.aCc.aCn);
                }
            }
        };
        this.hSp = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
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
                if (gVar == null || !gVar.zv()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage not show");
                    }
                } else if (c.this.hSg || c.this.clB()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hSg + ", tiped=" + c.this.clB());
                    }
                } else {
                    c.this.hSg = true;
                    c.this.y(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hSq = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hJx = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).ciS();
                        HttpMessage httpMessage = new HttpMessage(1021147);
                        httpMessage.addParam("category_id", com.baidu.tieba.ala.category.b.a.b(c.this.hJx));
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    c.this.clE();
                }
            }
        };
        this.hSr = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hJx = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.clE();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.clE();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        initListener();
        clC();
        clD();
        MessageManager.getInstance().registerListener(this.hSo);
        MessageManager.getInstance().registerListener(this.bEA);
        MessageManager.getInstance().registerListener(this.hSp);
        MessageManager.getInstance().registerListener(this.hSq);
        MessageManager.getInstance().registerListener(this.hSr);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.mPageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
        this.hRW = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hRS = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hRS.o(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hRS.cx(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hRS = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hRS != null) {
            this.hRS.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hRN = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.cla();
                c.this.clb();
                return false;
            }
        });
        ckS();
        this.hPx.setOnClickListener(this.hSn);
        this.hRD = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hRJ = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hRK = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hRL = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hRK.setIsRound(false);
        this.hRK.setGifIconSupport(false);
        String ckW = ckW();
        this.hRL.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(ckW)) {
            this.hRK.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            m.a(this.hRK, ckW, true, false);
            this.hRL.setText(a.h.ala_live_change_cover);
            this.hRP = ckW;
        }
        this.hPx.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hRE = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hRE.setOnClickListener(this.hSn);
        this.hRG = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hRG.setOnClickListener(this.hSn);
        this.hRF = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hSl = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hRH = this.mRootView.findViewById(a.f.beauty_layout);
        this.hRI = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bDB = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hRI.setOnClickListener(this.hSn);
        this.bDB.setOnClickListener(this.hSn);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hRD.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hRD.setLayoutParams(layoutParams);
        }
        this.hSi = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hSj = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hSk = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hSi.setOnClickListener(this.hSn);
        this.hRR = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hRR.setOnClickListener(this.hSn);
        this.hSc = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hSc.setOnClickListener(this.hSn);
        ED();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hRY = true;
        clv();
        clw();
        this.enterTime = System.currentTimeMillis();
    }

    private w clu() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNc == null) {
            return null;
        }
        return com.baidu.live.ae.a.Qj().buX.aNc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clv() {
        w clu = clu();
        if (clu != null && clu.aIq != null && clu.aIq.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hSd = clu.aIq.get(this.hRX % clu.aIq.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hSd.getText());
            this.hSi.setVisibility(0);
            this.hSj.setText(sb);
            this.hRX++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hRY) {
                        c.this.clv();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hSi.setVisibility(8);
    }

    private void clw() {
        if (com.baidu.live.d.xc().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hSi != null && this.hSi.getVisibility() == 0) {
            com.baidu.live.d.xc().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hSk.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        super.destroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Id(String str) {
        com.baidu.live.d.xc().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void ED() {
        this.hRJ.setOnClickListener(this.hSn);
        this.hRF.setOnClickListener(this.hSm);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void clb() {
        if (this.hPB != null) {
            this.hPB.cit();
        }
    }

    public void ceF() {
        ckX();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int clc() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean cld() {
        return false;
    }

    public boolean ceD() {
        if (this.hRS != null) {
            this.hRS.ckB();
        }
        return this.hRS != null && this.hRS.ceD();
    }

    public void ceE() {
        if (this.hRS != null) {
            this.hRS.x(this.hRP, getLiveTitle(), this.hRU, this.hRV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        if (this.hRQ) {
            this.hRF.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hRF.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        this.hSk.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.hqz == null) {
                this.hqz = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hSd != null && !TextUtils.isEmpty(this.hSd.BS())) {
                this.hqz.Hw(this.hSd.BS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.hRZ != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hRZ = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hRZ.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hRZ != null) {
                        int[] iArr = new int[2];
                        c.this.hRH.getLocationOnScreen(iArr);
                        c.this.hRZ.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hRH.getWidth() / 2)) - (c.this.hRZ.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hRZ.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hRZ.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hRZ, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sg() {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            this.hRH.setVisibility(0);
            if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
                this.hRI.setAlpha(0.2f);
                this.bDB.setAlpha(0.2f);
            }
        } else if (this.bBG != null && this.bBG.hasBeauty() < 0) {
            this.hRH.setVisibility(8);
        } else {
            this.hRH.setVisibility(0);
        }
    }

    public boolean cez() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clz() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HI(String str) {
        this.hRO = true;
        this.hRP = str;
        this.hRL.setText(a.h.ala_live_change_cover);
        Id(str);
        m.a(this.hRK, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String ceC() {
        return ckW();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        clA();
        Sg();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a ckZ() {
        return this.hJx;
    }

    public void cew() {
        this.bBG.setVideoConfig(com.baidu.live.z.a.b.PF().d(2, 1, false));
    }

    private void clA() {
        if (this.bBG != null) {
            Sg();
            if (this.bBG.isBackCamera()) {
                this.hRF.setEnabled(true);
                this.hRF.setVisibility(0);
                this.hRQ = this.bBG.isFlashingLightOpen();
            } else {
                this.hRF.setEnabled(false);
                this.hRF.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bBG != null) {
                        c.this.bBG.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        clb();
        if (this.hRS != null && z) {
            this.hRS.ckA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bRf() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hRC = aVar;
    }

    public void onResume() {
        this.hRM = false;
        if (this.bBG != null) {
            if (this.bBG.isBackCamera()) {
                this.hRF.setEnabled(true);
                this.hRF.setVisibility(0);
                this.hRQ = this.bBG.isFlashingLightOpen();
                clx();
            } else {
                this.hRF.setEnabled(false);
                this.hRF.setVisibility(4);
            }
        }
        if (this.hPy != null && this.hPy.clI() && TextUtils.isEmpty(this.hPy.clO())) {
            this.hPy.clN();
        }
        if (!clB()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clB() {
        if (this.hSf == null) {
            this.hSf = Boolean.valueOf(com.baidu.live.d.xc().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + clB());
            }
        }
        return this.hSf.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(boolean z) {
        if (clB() != z) {
            this.hSf = Boolean.valueOf(z);
            com.baidu.live.d.xc().putBoolean("makeup_new_bubble_tiped", this.hSf.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hSf);
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

    public void oh(boolean z) {
        this.hPx.setClickable(z);
    }

    public void release() {
        this.hRY = true;
        if (this.bBG != null) {
            this.bBG.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hSo);
        MessageManager.getInstance().unRegisterListener(this.bEA);
        MessageManager.getInstance().unRegisterListener(this.hSp);
        MessageManager.getInstance().unRegisterListener(this.hSq);
        MessageManager.getInstance().unRegisterListener(this.hSr);
        MessageManager.getInstance().unRegisterListener(this.syncListener);
        this.mPageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hRS != null) {
            this.hRS.release();
        }
        if (this.hqz != null) {
            this.hqz.release();
            this.hqz = null;
        }
    }

    private void clC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void clD() {
        if (as.Cl()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clE() {
        if (as.Cl()) {
            this.hSc.setVisibility(0);
            if (this.hJx != null && this.hJx.bTt() != null && !StringUtils.isNull(this.hJx.bTt().getName())) {
                this.hSc.setText(this.hJx.bTt().getName());
                this.hSc.setChecked(true);
                return;
            }
            this.hSc.setText(a.h.ala_live_prepare_select_livetype);
            this.hSc.setChecked(false);
            return;
        }
        this.hSc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clF() {
        if (this.hRW != null && this.hRT != null && this.hRT.size() > 0) {
            String str = this.hRT.get(this.hRW.nextInt(100) % this.hRT.size());
            if (!TextUtils.isEmpty(str)) {
                this.hPs.clearFocus();
                if (!this.hSb) {
                    this.hPs.setText(str);
                }
                if (this.hSb && this.hPs.getText().toString().equals("")) {
                    this.hPs.setText(str);
                    this.hSb = false;
                }
            }
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.m.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a cB = aVar.cB(true);
            View rootLayout = cB.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            cB.setTargetView(this.hPx);
            this.hSl.addView(rootLayout, 0);
            aVar.Mp();
        }
    }

    public void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                c.this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(c.this.mPageContext.getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(c.this.mPageContext.getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !c.this.mIsKeyboardOpen) {
                    c.this.mIsKeyboardOpen = true;
                    c.this.hSa = c.this.hPs.getText().toString();
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && c.this.mIsKeyboardOpen) {
                    c.this.mIsKeyboardOpen = false;
                    if (c.this.hRT != null && c.this.hRT.size() > 0) {
                        for (int i = 0; i < c.this.hRT.size(); i++) {
                            if (c.this.hPs.getText().toString().equals(c.this.hRT.get(i))) {
                                c.this.hSb = false;
                                return;
                            } else if (i == c.this.hRT.size() - 1) {
                                c.this.hSb = true;
                                return;
                            }
                        }
                    }
                }
            }
        };
    }
}
