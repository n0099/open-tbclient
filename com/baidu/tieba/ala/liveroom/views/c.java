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
/* loaded from: classes10.dex */
public class c extends a {
    private int bBm;
    private TextView bFb;
    private CustomMessageListener bGa;
    private long enterTime;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private com.baidu.tieba.ala.category.b.a hLg;
    private ImageView hTA;
    private com.baidu.tieba.ala.liveroom.share.d hTB;
    private List<String> hTC;
    private String hTD;
    private String hTE;
    private Random hTF;
    private int hTG;
    private boolean hTH;
    protected View hTI;
    private String hTJ;
    private boolean hTK;
    private CheckedTextView hTL;
    private p hTM;
    private boolean hTN;
    private Boolean hTO;
    private boolean hTP;
    AlaLivePerfBaseData hTQ;
    private RelativeLayout hTR;
    private TextView hTS;
    private FrameLayout hTT;
    private LinearLayout hTU;
    private View.OnClickListener hTV;
    private View.OnClickListener hTW;
    private HttpMessageListener hTX;
    private CustomMessageListener hTY;
    private HttpMessageListener hTZ;
    private e.a hTl;
    private LinearLayout hTm;
    private ImageView hTn;
    private ImageView hTo;
    private ImageView hTp;
    private View hTq;
    private ImageView hTr;
    private RoundRectRelativeLayout hTs;
    private TbImageView hTt;
    private TextView hTu;
    private boolean hTv;
    private String hTw;
    private boolean hTx;
    private String hTy;
    private boolean hTz;
    private CustomMessageListener hUa;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.activeview.b hsi;
    private long lastClickTime;
    private Handler mHandler;
    private boolean mIsKeyboardOpen;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hTv = false;
        this.hTx = false;
        this.hTz = false;
        this.hTG = 0;
        this.hTH = false;
        this.handler = new Handler();
        this.mIsKeyboardOpen = false;
        this.hTK = false;
        this.bBm = 0;
        this.hTN = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.clh();
                c.this.hTz = z;
                c.this.clD();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.clh();
                if (z) {
                    c.this.hTo.setEnabled(false);
                    c.this.hTo.setVisibility(4);
                    c.this.hTz = false;
                    c.this.clD();
                    return;
                }
                c.this.hTo.setEnabled(true);
                c.this.hTo.setVisibility(0);
                if (c.this.bDg.isFlashingLightOpen()) {
                    c.this.hTz = true;
                    c.this.clD();
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
                boolean isBackCamera = c.this.bDg.isBackCamera();
                if (!isBackCamera) {
                    c.this.hTo.setEnabled(false);
                    c.this.hTo.setVisibility(4);
                } else {
                    c.this.hTo.setEnabled(true);
                    c.this.hTo.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hTz = c.this.bDg.isFlashingLightOpen();
                    c.this.clD();
                }
                if (c.this.bDg.hasBeauty() >= 0) {
                    c.this.bDg.setBeauty(com.baidu.live.d.xf().getInt("live_beauty_level", 3));
                }
                c.this.Sj();
                if (!z && c.this.hTl != null) {
                    c.this.hTl.ciu();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hTv) {
                    c.this.clF();
                    c.this.hTv = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hTl != null) {
                    c.this.hTl.civ();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
                c.this.hTQ.sampleMemAndCPU();
                c.this.hTQ.getCpuMemJsonFormat();
            }
        };
        this.hTQ = new AlaLivePerfBaseData();
        this.hTV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bDg != null) {
                        c.this.bDg.switchFlashingLight();
                        c.this.hTz = c.this.bDg.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.clD();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hTW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.clh();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hRk != null) {
                                    c.this.hRk.ciw();
                                    return;
                                }
                                return;
                            }
                            c.this.cld();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hTv = true;
                        c.this.bDg.stopRecord();
                        if (TextUtils.isEmpty(c.this.hTy)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bDg != null) {
                                c.this.bDg.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_beauty || view.getId() == a.f.beauty_textView) {
                        c.this.hTN = true;
                        com.baidu.live.d.xf().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hRk != null) {
                            c.this.hRk.ciy();
                        }
                        if (c.this.hTP) {
                            c.this.oQ(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hTI != null && c.this.mRootView.indexOfChild(c.this.hTI) >= 0) {
                                    c.this.mRootView.removeView(c.this.hTI);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hRk != null) {
                            c.this.hRk.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.hTK = false;
                        c.this.clL();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.clE();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hLg), com.baidu.tieba.ala.category.b.a.b(c.this.hLg))));
                    }
                }
            }
        };
        this.hTX = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hLy != null && livePrepareListHttpResponseMessage.hLy.size() > 0) {
                        c.this.hTC = new ArrayList(livePrepareListHttpResponseMessage.hLy);
                        c.this.clL();
                    } else {
                        c.this.hTC = new ArrayList();
                    }
                    c.this.hTD = livePrepareListHttpResponseMessage.hLw;
                    c.this.hTE = livePrepareListHttpResponseMessage.hLx;
                }
            }
        };
        this.bGa = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aDC != null) {
                    if (data.aDC.aDL == 1) {
                        if (!c.this.hTN) {
                            c.this.y(data.aDC.mText, 1500L);
                        } else {
                            return;
                        }
                    }
                    com.baidu.live.d.xf().putInt("beauty_new_bubble", data.aDC.aDL);
                    com.baidu.live.d.xf().putInt("beauty_subitem_redot", data.aDC.aDM);
                    com.baidu.live.d.xf().putInt("beauty_tab_redot", data.aDC.aDN);
                }
            }
        };
        this.hTY = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
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
                if (gVar == null || !gVar.zy()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage not show");
                    }
                } else if (c.this.hTP || c.this.clH()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hTP + ", tiped=" + c.this.clH());
                    }
                } else {
                    c.this.hTP = true;
                    c.this.y(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hTZ = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hLg = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).ciY();
                        HttpMessage httpMessage = new HttpMessage(1021147);
                        httpMessage.addParam("category_id", com.baidu.tieba.ala.category.b.a.b(c.this.hLg));
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    c.this.clK();
                }
            }
        };
        this.hUa = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hLg = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.clK();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.clK();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        initListener();
        clI();
        clJ();
        MessageManager.getInstance().registerListener(this.hTX);
        MessageManager.getInstance().registerListener(this.bGa);
        MessageManager.getInstance().registerListener(this.hTY);
        MessageManager.getInstance().registerListener(this.hTZ);
        MessageManager.getInstance().registerListener(this.hUa);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.mPageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
        this.hTF = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hTB = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hTB.o(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hTB.cx(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hTB = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hTB != null) {
            this.hTB.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hTw = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.clg();
                c.this.clh();
                return false;
            }
        });
        ckY();
        this.hRg.setOnClickListener(this.hTW);
        this.hTm = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hTs = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hTt = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hTu = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hTt.setIsRound(false);
        this.hTt.setGifIconSupport(false);
        String clc = clc();
        this.hTu.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(clc)) {
            this.hTt.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            m.a(this.hTt, clc, true, false);
            this.hTu.setText(a.h.ala_live_change_cover);
            this.hTy = clc;
        }
        this.hRg.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hTn = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hTn.setOnClickListener(this.hTW);
        this.hTp = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hTp.setOnClickListener(this.hTW);
        this.hTo = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hTU = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hTq = this.mRootView.findViewById(a.f.beauty_layout);
        this.hTr = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bFb = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hTr.setOnClickListener(this.hTW);
        this.bFb.setOnClickListener(this.hTW);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hTm.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hTm.setLayoutParams(layoutParams);
        }
        this.hTR = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hTS = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hTT = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hTR.setOnClickListener(this.hTW);
        this.hTA = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hTA.setOnClickListener(this.hTW);
        this.hTL = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hTL.setOnClickListener(this.hTW);
        EG();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hTH = true;
        clB();
        clC();
        this.enterTime = System.currentTimeMillis();
    }

    private w clA() {
        if (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOC == null) {
            return null;
        }
        return com.baidu.live.ae.a.Qm().bwx.aOC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clB() {
        w clA = clA();
        if (clA != null && clA.aJQ != null && clA.aJQ.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hTM = clA.aJQ.get(this.hTG % clA.aJQ.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hTM.getText());
            this.hTR.setVisibility(0);
            this.hTS.setText(sb);
            this.hTG++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hTH) {
                        c.this.clB();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hTR.setVisibility(8);
    }

    private void clC() {
        if (com.baidu.live.d.xf().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hTR != null && this.hTR.getVisibility() == 0) {
            com.baidu.live.d.xf().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hTT.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        super.destroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Im(String str) {
        com.baidu.live.d.xf().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void EG() {
        this.hTs.setOnClickListener(this.hTW);
        this.hTo.setOnClickListener(this.hTV);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void clh() {
        if (this.hRk != null) {
            this.hRk.ciz();
        }
    }

    public void ceL() {
        cld();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int cli() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean clj() {
        return false;
    }

    public boolean ceJ() {
        if (this.hTB != null) {
            this.hTB.ckH();
        }
        return this.hTB != null && this.hTB.ceJ();
    }

    public void ceK() {
        if (this.hTB != null) {
            this.hTB.x(this.hTy, getLiveTitle(), this.hTD, this.hTE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clD() {
        if (this.hTz) {
            this.hTo.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hTo.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clE() {
        this.hTT.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.hsi == null) {
                this.hsi = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hTM != null && !TextUtils.isEmpty(this.hTM.BV())) {
                this.hsi.HF(this.hTM.BV());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.hTI != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hTI = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hTI.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hTI != null) {
                        int[] iArr = new int[2];
                        c.this.hTq.getLocationOnScreen(iArr);
                        c.this.hTI.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hTq.getWidth() / 2)) - (c.this.hTI.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hTI.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hTI.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hTI, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj() {
        if (bt.c(com.baidu.live.ae.a.Qm().bCs)) {
            this.hTq.setVisibility(0);
            if (bt.c(com.baidu.live.ae.a.Qm().bCs)) {
                this.hTr.setAlpha(0.2f);
                this.bFb.setAlpha(0.2f);
            }
        } else if (this.bDg != null && this.bDg.hasBeauty() < 0) {
            this.hTq.setVisibility(8);
        } else {
            this.hTq.setVisibility(0);
        }
    }

    public boolean ceF() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clF() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HR(String str) {
        this.hTx = true;
        this.hTy = str;
        this.hTu.setText(a.h.ala_live_change_cover);
        Im(str);
        m.a(this.hTt, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String ceI() {
        return clc();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        clG();
        Sj();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a clf() {
        return this.hLg;
    }

    public void ceC() {
        this.bDg.setVideoConfig(com.baidu.live.z.a.b.PI().d(2, 1, false));
    }

    private void clG() {
        if (this.bDg != null) {
            Sj();
            if (this.bDg.isBackCamera()) {
                this.hTo.setEnabled(true);
                this.hTo.setVisibility(0);
                this.hTz = this.bDg.isFlashingLightOpen();
            } else {
                this.hTo.setEnabled(false);
                this.hTo.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bDg != null) {
                        c.this.bDg.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        clh();
        if (this.hTB != null && z) {
            this.hTB.ckG();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bRl() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hTl = aVar;
    }

    public void onResume() {
        this.hTv = false;
        if (this.bDg != null) {
            if (this.bDg.isBackCamera()) {
                this.hTo.setEnabled(true);
                this.hTo.setVisibility(0);
                this.hTz = this.bDg.isFlashingLightOpen();
                clD();
            } else {
                this.hTo.setEnabled(false);
                this.hTo.setVisibility(4);
            }
        }
        if (this.hRh != null && this.hRh.clO() && TextUtils.isEmpty(this.hRh.clU())) {
            this.hRh.clT();
        }
        if (!clH()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clH() {
        if (this.hTO == null) {
            this.hTO = Boolean.valueOf(com.baidu.live.d.xf().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + clH());
            }
        }
        return this.hTO.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(boolean z) {
        if (clH() != z) {
            this.hTO = Boolean.valueOf(z);
            com.baidu.live.d.xf().putBoolean("makeup_new_bubble_tiped", this.hTO.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hTO);
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
        this.hRg.setClickable(z);
    }

    public void release() {
        this.hTH = true;
        if (this.bDg != null) {
            this.bDg.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hTX);
        MessageManager.getInstance().unRegisterListener(this.bGa);
        MessageManager.getInstance().unRegisterListener(this.hTY);
        MessageManager.getInstance().unRegisterListener(this.hTZ);
        MessageManager.getInstance().unRegisterListener(this.hUa);
        MessageManager.getInstance().unRegisterListener(this.syncListener);
        this.mPageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hTB != null) {
            this.hTB.release();
        }
        if (this.hsi != null) {
            this.hsi.release();
            this.hsi = null;
        }
    }

    private void clI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void clJ() {
        if (as.Co()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clK() {
        if (as.Co()) {
            this.hTL.setVisibility(0);
            if (this.hLg != null && this.hLg.bTz() != null && !StringUtils.isNull(this.hLg.bTz().getName())) {
                this.hTL.setText(this.hLg.bTz().getName());
                this.hTL.setChecked(true);
                return;
            }
            this.hTL.setText(a.h.ala_live_prepare_select_livetype);
            this.hTL.setChecked(false);
            return;
        }
        this.hTL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clL() {
        if (this.hTF != null && this.hTC != null && this.hTC.size() > 0) {
            String str = this.hTC.get(this.hTF.nextInt(100) % this.hTC.size());
            if (!TextUtils.isEmpty(str)) {
                this.hRb.clearFocus();
                if (!this.hTK) {
                    this.hRb.setText(str);
                }
                if (this.hTK && this.hRb.getText().toString().equals("")) {
                    this.hRb.setText(str);
                    this.hTK = false;
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
            cB.setTargetView(this.hRg);
            this.hTU.addView(rootLayout, 0);
            aVar.Ms();
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
                    c.this.hTJ = c.this.hRb.getText().toString();
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && c.this.mIsKeyboardOpen) {
                    c.this.mIsKeyboardOpen = false;
                    if (c.this.hTC != null && c.this.hTC.size() > 0) {
                        for (int i = 0; i < c.this.hTC.size(); i++) {
                            if (c.this.hRb.getText().toString().equals(c.this.hTC.get(i))) {
                                c.this.hTK = false;
                                return;
                            } else if (i == c.this.hTC.size() - 1) {
                                c.this.hTK = true;
                                return;
                            }
                        }
                    }
                }
            }
        };
    }
}
