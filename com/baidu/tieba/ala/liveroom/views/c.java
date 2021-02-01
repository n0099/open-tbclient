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
    private com.baidu.tieba.ala.category.b.a hJj;
    private boolean hRA;
    private String hRB;
    private boolean hRC;
    private ImageView hRD;
    private com.baidu.tieba.ala.liveroom.share.d hRE;
    private List<String> hRF;
    private String hRG;
    private String hRH;
    private Random hRI;
    private int hRJ;
    private boolean hRK;
    protected View hRL;
    private String hRM;
    private boolean hRN;
    private CheckedTextView hRO;
    private p hRP;
    private boolean hRQ;
    private Boolean hRR;
    private boolean hRS;
    AlaLivePerfBaseData hRT;
    private RelativeLayout hRU;
    private TextView hRV;
    private FrameLayout hRW;
    private LinearLayout hRX;
    private View.OnClickListener hRY;
    private View.OnClickListener hRZ;
    private e.a hRo;
    private LinearLayout hRp;
    private ImageView hRq;
    private ImageView hRr;
    private ImageView hRs;
    private View hRt;
    private ImageView hRu;
    private RoundRectRelativeLayout hRv;
    private TbImageView hRw;
    private TextView hRx;
    private boolean hRy;
    private String hRz;
    private HttpMessageListener hSa;
    private CustomMessageListener hSb;
    private HttpMessageListener hSc;
    private CustomMessageListener hSd;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.activeview.b hql;
    private long lastClickTime;
    private Handler mHandler;
    private boolean mIsKeyboardOpen;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hRy = false;
        this.hRA = false;
        this.hRC = false;
        this.hRJ = 0;
        this.hRK = false;
        this.handler = new Handler();
        this.mIsKeyboardOpen = false;
        this.hRN = false;
        this.bzM = 0;
        this.hRQ = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.ckU();
                c.this.hRC = z;
                c.this.clq();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.ckU();
                if (z) {
                    c.this.hRr.setEnabled(false);
                    c.this.hRr.setVisibility(4);
                    c.this.hRC = false;
                    c.this.clq();
                    return;
                }
                c.this.hRr.setEnabled(true);
                c.this.hRr.setVisibility(0);
                if (c.this.bBG.isFlashingLightOpen()) {
                    c.this.hRC = true;
                    c.this.clq();
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
                    c.this.hRr.setEnabled(false);
                    c.this.hRr.setVisibility(4);
                } else {
                    c.this.hRr.setEnabled(true);
                    c.this.hRr.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hRC = c.this.bBG.isFlashingLightOpen();
                    c.this.clq();
                }
                if (c.this.bBG.hasBeauty() >= 0) {
                    c.this.bBG.setBeauty(com.baidu.live.d.xc().getInt("live_beauty_level", 3));
                }
                c.this.Sg();
                if (!z && c.this.hRo != null) {
                    c.this.hRo.cih();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hRy) {
                    c.this.cls();
                    c.this.hRy = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hRo != null) {
                    c.this.hRo.cii();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
                c.this.hRT.sampleMemAndCPU();
                c.this.hRT.getCpuMemJsonFormat();
            }
        };
        this.hRT = new AlaLivePerfBaseData();
        this.hRY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bBG != null) {
                        c.this.bBG.switchFlashingLight();
                        c.this.hRC = c.this.bBG.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.clq();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hRZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.ckU();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hPn != null) {
                                    c.this.hPn.cij();
                                    return;
                                }
                                return;
                            }
                            c.this.ckQ();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hRy = true;
                        c.this.bBG.stopRecord();
                        if (TextUtils.isEmpty(c.this.hRB)) {
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
                        c.this.hRQ = true;
                        com.baidu.live.d.xc().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hPn != null) {
                            c.this.hPn.cil();
                        }
                        if (c.this.hRS) {
                            c.this.oQ(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hRL != null && c.this.mRootView.indexOfChild(c.this.hRL) >= 0) {
                                    c.this.mRootView.removeView(c.this.hRL);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hPn != null) {
                            c.this.hPn.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.hRN = false;
                        c.this.cly();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.clr();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hJj), com.baidu.tieba.ala.category.b.a.b(c.this.hJj))));
                    }
                }
            }
        };
        this.hSa = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hJB != null && livePrepareListHttpResponseMessage.hJB.size() > 0) {
                        c.this.hRF = new ArrayList(livePrepareListHttpResponseMessage.hJB);
                        c.this.cly();
                    } else {
                        c.this.hRF = new ArrayList();
                    }
                    c.this.hRG = livePrepareListHttpResponseMessage.hJz;
                    c.this.hRH = livePrepareListHttpResponseMessage.hJA;
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
                        if (!c.this.hRQ) {
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
        this.hSb = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
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
                } else if (c.this.hRS || c.this.clu()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hRS + ", tiped=" + c.this.clu());
                    }
                } else {
                    c.this.hRS = true;
                    c.this.y(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hSc = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hJj = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).ciL();
                        HttpMessage httpMessage = new HttpMessage(1021147);
                        httpMessage.addParam("category_id", com.baidu.tieba.ala.category.b.a.b(c.this.hJj));
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    c.this.clx();
                }
            }
        };
        this.hSd = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hJj = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.clx();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.clx();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        initListener();
        clv();
        clw();
        MessageManager.getInstance().registerListener(this.hSa);
        MessageManager.getInstance().registerListener(this.bEA);
        MessageManager.getInstance().registerListener(this.hSb);
        MessageManager.getInstance().registerListener(this.hSc);
        MessageManager.getInstance().registerListener(this.hSd);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.mPageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
        this.hRI = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hRE = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hRE.o(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hRE.cx(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hRE = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hRE != null) {
            this.hRE.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hRz = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.ckT();
                c.this.ckU();
                return false;
            }
        });
        ckL();
        this.hPj.setOnClickListener(this.hRZ);
        this.hRp = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hRv = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hRw = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hRx = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hRw.setIsRound(false);
        this.hRw.setGifIconSupport(false);
        String ckP = ckP();
        this.hRx.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(ckP)) {
            this.hRw.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            m.a(this.hRw, ckP, true, false);
            this.hRx.setText(a.h.ala_live_change_cover);
            this.hRB = ckP;
        }
        this.hPj.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hRq = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hRq.setOnClickListener(this.hRZ);
        this.hRs = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hRs.setOnClickListener(this.hRZ);
        this.hRr = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hRX = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hRt = this.mRootView.findViewById(a.f.beauty_layout);
        this.hRu = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bDB = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hRu.setOnClickListener(this.hRZ);
        this.bDB.setOnClickListener(this.hRZ);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hRp.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hRp.setLayoutParams(layoutParams);
        }
        this.hRU = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hRV = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hRW = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hRU.setOnClickListener(this.hRZ);
        this.hRD = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hRD.setOnClickListener(this.hRZ);
        this.hRO = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hRO.setOnClickListener(this.hRZ);
        ED();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hRK = true;
        clo();
        clp();
        this.enterTime = System.currentTimeMillis();
    }

    private w cln() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNc == null) {
            return null;
        }
        return com.baidu.live.ae.a.Qj().buX.aNc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clo() {
        w cln = cln();
        if (cln != null && cln.aIq != null && cln.aIq.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hRP = cln.aIq.get(this.hRJ % cln.aIq.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hRP.getText());
            this.hRU.setVisibility(0);
            this.hRV.setText(sb);
            this.hRJ++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hRK) {
                        c.this.clo();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hRU.setVisibility(8);
    }

    private void clp() {
        if (com.baidu.live.d.xc().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hRU != null && this.hRU.getVisibility() == 0) {
            com.baidu.live.d.xc().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hRW.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        super.destroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Ic(String str) {
        com.baidu.live.d.xc().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void ED() {
        this.hRv.setOnClickListener(this.hRZ);
        this.hRr.setOnClickListener(this.hRY);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void ckU() {
        if (this.hPn != null) {
            this.hPn.cim();
        }
    }

    public void cey() {
        ckQ();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int ckV() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean ckW() {
        return false;
    }

    public boolean cew() {
        if (this.hRE != null) {
            this.hRE.cku();
        }
        return this.hRE != null && this.hRE.cew();
    }

    public void cex() {
        if (this.hRE != null) {
            this.hRE.x(this.hRB, getLiveTitle(), this.hRG, this.hRH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clq() {
        if (this.hRC) {
            this.hRr.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hRr.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clr() {
        this.hRW.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.hql == null) {
                this.hql = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hRP != null && !TextUtils.isEmpty(this.hRP.BS())) {
                this.hql.Hv(this.hRP.BS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.hRL != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hRL = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hRL.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hRL != null) {
                        int[] iArr = new int[2];
                        c.this.hRt.getLocationOnScreen(iArr);
                        c.this.hRL.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hRt.getWidth() / 2)) - (c.this.hRL.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hRL.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hRL.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hRL, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sg() {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            this.hRt.setVisibility(0);
            if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
                this.hRu.setAlpha(0.2f);
                this.bDB.setAlpha(0.2f);
            }
        } else if (this.bBG != null && this.bBG.hasBeauty() < 0) {
            this.hRt.setVisibility(8);
        } else {
            this.hRt.setVisibility(0);
        }
    }

    public boolean ces() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HH(String str) {
        this.hRA = true;
        this.hRB = str;
        this.hRx.setText(a.h.ala_live_change_cover);
        Ic(str);
        m.a(this.hRw, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String cev() {
        return ckP();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        clt();
        Sg();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a ckS() {
        return this.hJj;
    }

    public void cep() {
        this.bBG.setVideoConfig(com.baidu.live.z.a.b.PF().d(2, 1, false));
    }

    private void clt() {
        if (this.bBG != null) {
            Sg();
            if (this.bBG.isBackCamera()) {
                this.hRr.setEnabled(true);
                this.hRr.setVisibility(0);
                this.hRC = this.bBG.isFlashingLightOpen();
            } else {
                this.hRr.setEnabled(false);
                this.hRr.setVisibility(4);
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
        ckU();
        if (this.hRE != null && z) {
            this.hRE.ckt();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bQY() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hRo = aVar;
    }

    public void onResume() {
        this.hRy = false;
        if (this.bBG != null) {
            if (this.bBG.isBackCamera()) {
                this.hRr.setEnabled(true);
                this.hRr.setVisibility(0);
                this.hRC = this.bBG.isFlashingLightOpen();
                clq();
            } else {
                this.hRr.setEnabled(false);
                this.hRr.setVisibility(4);
            }
        }
        if (this.hPk != null && this.hPk.clB() && TextUtils.isEmpty(this.hPk.clH())) {
            this.hPk.clG();
        }
        if (!clu()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clu() {
        if (this.hRR == null) {
            this.hRR = Boolean.valueOf(com.baidu.live.d.xc().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + clu());
            }
        }
        return this.hRR.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(boolean z) {
        if (clu() != z) {
            this.hRR = Boolean.valueOf(z);
            com.baidu.live.d.xc().putBoolean("makeup_new_bubble_tiped", this.hRR.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hRR);
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
        this.hPj.setClickable(z);
    }

    public void release() {
        this.hRK = true;
        if (this.bBG != null) {
            this.bBG.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hSa);
        MessageManager.getInstance().unRegisterListener(this.bEA);
        MessageManager.getInstance().unRegisterListener(this.hSb);
        MessageManager.getInstance().unRegisterListener(this.hSc);
        MessageManager.getInstance().unRegisterListener(this.hSd);
        MessageManager.getInstance().unRegisterListener(this.syncListener);
        this.mPageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hRE != null) {
            this.hRE.release();
        }
        if (this.hql != null) {
            this.hql.release();
            this.hql = null;
        }
    }

    private void clv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void clw() {
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
    public void clx() {
        if (as.Cl()) {
            this.hRO.setVisibility(0);
            if (this.hJj != null && this.hJj.bTm() != null && !StringUtils.isNull(this.hJj.bTm().getName())) {
                this.hRO.setText(this.hJj.bTm().getName());
                this.hRO.setChecked(true);
                return;
            }
            this.hRO.setText(a.h.ala_live_prepare_select_livetype);
            this.hRO.setChecked(false);
            return;
        }
        this.hRO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        if (this.hRI != null && this.hRF != null && this.hRF.size() > 0) {
            String str = this.hRF.get(this.hRI.nextInt(100) % this.hRF.size());
            if (!TextUtils.isEmpty(str)) {
                this.hPe.clearFocus();
                if (!this.hRN) {
                    this.hPe.setText(str);
                }
                if (this.hRN && this.hPe.getText().toString().equals("")) {
                    this.hPe.setText(str);
                    this.hRN = false;
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
            cB.setTargetView(this.hPj);
            this.hRX.addView(rootLayout, 0);
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
                    c.this.hRM = c.this.hPe.getText().toString();
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && c.this.mIsKeyboardOpen) {
                    c.this.mIsKeyboardOpen = false;
                    if (c.this.hRF != null && c.this.hRF.size() > 0) {
                        for (int i = 0; i < c.this.hRF.size(); i++) {
                            if (c.this.hPe.getText().toString().equals(c.this.hRF.get(i))) {
                                c.this.hRN = false;
                                return;
                            } else if (i == c.this.hRF.size() - 1) {
                                c.this.hRN = true;
                                return;
                            }
                        }
                    }
                }
            }
        };
    }
}
