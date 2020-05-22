package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.Space;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.data.av;
import com.baidu.live.data.ax;
import com.baidu.live.data.h;
import com.baidu.live.data.l;
import com.baidu.live.data.z;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.utils.o;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.messages.AlaGetAnchorCategoryResponseMessagge;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.LivePrepareListHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.e;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    private com.baidu.tieba.ala.liveroom.activeview.b fKc;
    private CustomMessageListener fYE;
    private HttpMessageListener fYR;
    private HttpMessageListener fYS;
    private com.baidu.tieba.ala.category.b.a fZH;
    private ImageView ghA;
    private com.baidu.tieba.ala.liveroom.share.d ghB;
    private List<String> ghC;
    private String ghD;
    private String ghE;
    private Random ghF;
    private int ghG;
    private boolean ghH;
    protected View ghI;
    private CheckedTextView ghJ;
    private h ghK;
    private int ghL;
    private RelativeLayout ghM;
    private TextView ghN;
    private FrameLayout ghO;
    private View.OnClickListener ghP;
    private View.OnClickListener ghQ;
    private HttpMessageListener ghR;
    private HttpMessageListener ghS;
    private CustomMessageListener ghT;
    private e.a gha;
    private LinearLayout ghb;
    private ImageView ghc;
    private ImageView ghd;
    private ImageView ghe;
    private View ghf;
    private ImageView ghg;
    private TextView ghh;
    private View ghi;
    private ImageView ghj;
    private TextView ghk;
    private TextView ghl;
    private Space ghm;
    private FrameLayout ghn;
    private Button gho;
    private LinearLayout ghp;
    private LinearLayout ghq;
    private ImageView ghr;
    private RoundRectRelativeLayout ghs;
    private TbImageView ght;
    private TextView ghu;
    private boolean ghv;
    private String ghw;
    private boolean ghx;
    private String ghy;
    private boolean ghz;
    private Handler handler;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    static /* synthetic */ int x(c cVar) {
        int i = cVar.ghL;
        cVar.ghL = i + 1;
        return i;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ghv = false;
        this.ghx = false;
        this.ghz = false;
        this.ghG = 0;
        this.ghH = false;
        this.handler = new Handler();
        this.ghL = 0;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bGG();
                c.this.ghz = z;
                c.this.bHa();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bGG();
                if (z) {
                    c.this.ghd.setEnabled(false);
                    c.this.ghd.setVisibility(4);
                    c.this.ghz = false;
                    c.this.bHa();
                    return;
                }
                c.this.ghd.setEnabled(true);
                c.this.ghd.setVisibility(0);
                if (c.this.bfx.isFlashingLightOpen()) {
                    c.this.ghz = true;
                    c.this.bHa();
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
                boolean isBackCamera = c.this.bfx.isBackCamera();
                if (!isBackCamera) {
                    c.this.ghd.setEnabled(false);
                    c.this.ghd.setVisibility(4);
                } else {
                    c.this.ghd.setEnabled(true);
                    c.this.ghd.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.ghz = c.this.bfx.isFlashingLightOpen();
                    c.this.bHa();
                }
                if (c.this.bfx.hasBeauty() >= 0) {
                    c.this.bfx.setBeauty(com.baidu.live.c.uN().getInt("live_beauty_level", 3));
                }
                c.this.bHc();
                if (!z && c.this.gha != null) {
                    c.this.gha.bDZ();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.ghv) {
                    c.this.bHd();
                    c.this.ghv = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.gha != null) {
                    c.this.gha.bEa();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onError(int i, String str) {
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onRtcConnected(int i) {
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onPKPlayerFirstFrame() {
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onFaceUnityEvent(int i, int i2, Object obj) {
            }
        };
        this.ghP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bfx != null) {
                    c.this.bfx.switchFlashingLight();
                    c.this.ghz = c.this.bfx.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.bHa();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.ghQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bGG();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.gfE != null) {
                                c.this.gfE.bEb();
                                return;
                            }
                            return;
                        }
                        c.this.bGC();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.ghv = true;
                    c.this.bfx.stopRecord();
                    if (TextUtils.isEmpty(c.this.ghy)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.bfx != null) {
                        c.this.bfx.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                    if (c.this.gfE != null) {
                        c.this.gfE.bEd();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.ghI != null && c.this.mRootView.indexOfChild(c.this.ghI) >= 0) {
                                c.this.mRootView.removeView(c.this.ghI);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.gfE != null) {
                        c.this.gfE.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.gfE != null) {
                        c.this.gfE.bEg();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.bHk();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                    c.this.bHb();
                } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.fZH), com.baidu.tieba.ala.category.b.a.b(c.this.fZH))));
                }
            }
        };
        this.fYR = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    c.this.b(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
                } else if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    c.this.ghL = 0;
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fZU) {
                        ax axVar = com.baidu.live.v.a.Ge().aYP;
                        if (axVar == null || axVar.aAM == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(axVar.aAM.aCD);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        c.this.ghi.setVisibility(0);
                        if (!com.baidu.live.c.uN().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.bHi();
                        }
                        o.a("", 0L, true, false);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
                    } else {
                        c.this.ghi.setVisibility(8);
                    }
                    c.this.b(httpResponsedMessage, null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH_SUCC);
                } else {
                    c.x(c.this);
                    if (c.this.ghL < 3) {
                        c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bHl();
                            }
                        }, 2000L);
                    }
                    c.this.b(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
                }
            }
        };
        this.fYS = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.ghl.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.ghl.setVisibility(0);
                        return;
                    }
                    c.this.ghl.setVisibility(8);
                }
            }
        };
        this.ghR = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fZY != null && livePrepareListHttpResponseMessage.fZY.size() > 0) {
                        c.this.ghC = new ArrayList(livePrepareListHttpResponseMessage.fZY);
                        c.this.bHk();
                    } else {
                        c.this.ghC = new ArrayList();
                    }
                    c.this.ghD = livePrepareListHttpResponseMessage.fZW;
                    c.this.ghE = livePrepareListHttpResponseMessage.fZX;
                }
            }
        };
        this.fYE = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.asI != null && data.asI.asQ == 1) {
                    c.this.x(data.asI.mText, 1000L);
                }
            }
        };
        this.ghS = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.fZH = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).bEG();
                    }
                    c.this.bHj();
                }
            }
        };
        this.ghT = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.fZH = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.bHj();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.bHj();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bHh();
        bHf();
        bHg();
        MessageManager.getInstance().registerListener(this.fYR);
        MessageManager.getInstance().registerListener(this.fYS);
        MessageManager.getInstance().registerListener(this.ghR);
        MessageManager.getInstance().registerListener(this.fYE);
        MessageManager.getInstance().registerListener(this.ghS);
        MessageManager.getInstance().registerListener(this.ghT);
        MessageManager.getInstance().registerListener(this.syncListener);
        bHl();
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.ghF = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.ghB = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.ghB.l(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.ghB.bE(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.ghB = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.ghB != null) {
            this.ghB.a(iShareCallback);
        }
    }

    private void initViews() {
        this.ghw = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bGF();
                c.this.bGG();
                return false;
            }
        });
        bGx();
        this.gfA.setOnClickListener(this.ghQ);
        this.ghb = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.ghs = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.ght = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.ghu = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.ght.setIsRound(false);
        this.ght.setGifIconSupport(false);
        String bGB = bGB();
        this.ghu.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bGB)) {
            this.ght.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.ght, bGB, true, false);
            this.ghu.setText(a.i.ala_live_change_cover);
            this.ghy = bGB;
        }
        this.gfA.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.ghc = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.ghc.setOnClickListener(this.ghQ);
        this.ghe = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.ghe.setOnClickListener(this.ghQ);
        this.ghd = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.ghf = this.mRootView.findViewById(a.g.beauty_layout);
        this.ghg = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.ghh = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.ghg.setOnClickListener(this.ghQ);
        this.ghh.setOnClickListener(this.ghQ);
        this.ghi = this.mRootView.findViewById(a.g.goods_layout);
        this.ghj = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.ghk = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.ghl = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.ghj.setOnClickListener(this.ghQ);
        this.ghk.setOnClickListener(this.ghQ);
        this.ghl.setOnClickListener(this.ghQ);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghb.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.ghb.setLayoutParams(layoutParams);
        }
        this.ghm = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.ghn = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.gho = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.ghp = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.ghq = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.ghr = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.ghM = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.ghN = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.ghO = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.ghM.setOnClickListener(this.ghQ);
        this.ghA = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.ghA.setOnClickListener(this.ghQ);
        this.ghJ = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.ghJ.setOnClickListener(this.ghQ);
        xT();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.ghH = true;
        bGY();
        bGZ();
    }

    private l bGX() {
        if (com.baidu.live.v.a.Ge().aWF == null || com.baidu.live.v.a.Ge().aWF.ayy == null) {
            return null;
        }
        return com.baidu.live.v.a.Ge().aWF.ayy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGY() {
        l bGX = bGX();
        if (bGX != null && bGX.avt != null && bGX.avt.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.ghK = bGX.avt.get(this.ghG % bGX.avt.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.ghK.getText());
            this.ghM.setVisibility(0);
            this.ghN.setText(sb);
            this.ghG++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ghH) {
                        c.this.bGY();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.ghM.setVisibility(8);
    }

    private void bGZ() {
        if (com.baidu.live.c.uN().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.ghM != null && this.ghM.getVisibility() == 0) {
            com.baidu.live.c.uN().putInt("live_assistant_guide_txt_show_counts", 1);
            this.ghO.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void CO(String str) {
        com.baidu.live.c.uN().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void xT() {
        this.ghs.setOnClickListener(this.ghQ);
        this.ghd.setOnClickListener(this.ghP);
        this.gho.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ghn.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bGG() {
        if (this.gfE != null) {
            this.gfE.bEe();
        }
    }

    public void bBe() {
        bGC();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bGH() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bGI() {
        return false;
    }

    public boolean bBc() {
        if (this.ghB != null) {
            this.ghB.bGj();
        }
        return this.ghB != null && this.ghB.bBc();
    }

    public void bBd() {
        if (this.ghB != null) {
            this.ghB.w(this.ghy, getLiveTitle(), this.ghD, this.ghE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHa() {
        if (this.ghz) {
            this.ghd.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.ghd.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHb() {
        this.ghO.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.fKc == null) {
                this.fKc = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.ghK != null && !TextUtils.isEmpty(this.ghK.vX())) {
                this.fKc.Cg(this.ghK.vX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (this.ghI == null) {
            this.ghI = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.ghI.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.15
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.ghI != null) {
                            int[] iArr = new int[2];
                            c.this.ghf.getLocationOnScreen(iArr);
                            c.this.ghI.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.ghf.getWidth() / 2)) - (c.this.ghI.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.ghI.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.ghI.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.ghI, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.ghI != null && c.this.mRootView.indexOfChild(c.this.ghI) >= 0) {
                            c.this.mRootView.removeView(c.this.ghI);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHc() {
        if (av.c(com.baidu.live.v.a.Ge().aYP)) {
            this.ghf.setVisibility(0);
            if (av.c(com.baidu.live.v.a.Ge().aYP)) {
                this.ghg.setAlpha(0.2f);
                this.ghh.setAlpha(0.2f);
            }
        } else if (this.bfx != null && this.bfx.hasBeauty() < 0) {
            this.ghf.setVisibility(8);
        } else {
            this.ghf.setVisibility(0);
        }
    }

    public boolean bAY() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHd() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Co(String str) {
        this.ghx = true;
        this.ghy = str;
        this.ghu.setText(a.i.ala_live_change_cover);
        CO(str);
        k.a(this.ght, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bBb() {
        return bGB();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bHe();
        bHc();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a bGE() {
        return this.fZH;
    }

    public void bAV() {
        this.bfx.setVideoConfig(LiveRecorderConfigHelper.FX().d(2, 1, false));
    }

    private void bHe() {
        if (this.bfx != null) {
            bHc();
            if (this.bfx.isBackCamera()) {
                this.ghd.setEnabled(true);
                this.ghd.setVisibility(0);
                this.ghz = this.bfx.isFlashingLightOpen();
            } else {
                this.ghd.setEnabled(false);
                this.ghd.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.17
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bfx != null) {
                        c.this.bfx.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bGG();
        if (this.ghB != null && z) {
            this.ghB.bGi();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bBg() {
        return 1;
    }

    public void a(e.a aVar) {
        this.gha = aVar;
    }

    public void onResume() {
        this.ghv = false;
        if (this.bfx != null) {
            if (this.bfx.isBackCamera()) {
                this.ghd.setEnabled(true);
                this.ghd.setVisibility(0);
                this.ghz = this.bfx.isFlashingLightOpen();
                bHa();
            } else {
                this.ghd.setEnabled(false);
                this.ghd.setVisibility(4);
            }
        }
        if (this.gfB != null && this.gfB.bHn() && TextUtils.isEmpty(this.gfB.bHt())) {
            this.gfB.bHs();
        }
    }

    public void onRefresh() {
        if (this.ghi.getVisibility() == 0) {
            o.a("", 0L, true, false);
        }
    }

    public void kJ(boolean z) {
        this.gfA.setClickable(z);
    }

    public void release() {
        this.ghH = true;
        if (this.bfx != null) {
            this.bfx.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.fYR);
        MessageManager.getInstance().unRegisterListener(this.fYS);
        MessageManager.getInstance().unRegisterListener(this.ghR);
        MessageManager.getInstance().unRegisterListener(this.fYE);
        MessageManager.getInstance().unRegisterListener(this.ghS);
        MessageManager.getInstance().unRegisterListener(this.ghT);
        if (this.ghB != null) {
            this.ghB.release();
        }
        if (this.fKc != null) {
            this.fKc.release();
            this.fKc = null;
        }
    }

    private void bHf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bHg() {
        if (z.wg()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "/ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    private static void bHh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHi() {
        this.ghj.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.ghj.getLocationOnScreen(iArr);
                c.this.ghp.measure(0, 0);
                int width = (iArr[0] + (c.this.ghj.getWidth() / 2)) - (c.this.ghr.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.ghj.getHeight() / 2)) + (c.this.ghr.getMeasuredHeight() / 2)) - c.this.ghp.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.ghm.getLocationOnScreen(iArr2);
                c.this.ghp.setY(height - iArr2[1]);
                c.this.ghq.setX(width);
                int[] iArr3 = new int[2];
                c.this.gfA.getLocationOnScreen(iArr3);
                c.this.gho.setY(iArr3[1] - iArr2[1]);
                c.this.ghn.setVisibility(0);
                com.baidu.live.c.uN().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHj() {
        if (z.wg()) {
            this.ghJ.setVisibility(0);
            if (this.fZH != null && this.fZH.bsM() != null && !StringUtils.isNull(this.fZH.bsM().getName())) {
                this.ghJ.setText(this.fZH.bsM().getName());
                this.ghJ.setChecked(true);
                return;
            }
            this.ghJ.setText(a.i.ala_live_prepare_select_livetype);
            this.ghJ.setChecked(false);
            return;
        }
        this.ghJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HttpResponsedMessage httpResponsedMessage, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject2.put(PushMessageHelper.ERROR_TYPE, str);
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHk() {
        if (this.ghF != null && this.ghC != null && this.ghC.size() > 0) {
            String str = this.ghC.get(this.ghF.nextInt(100) % this.ghC.size());
            if (!TextUtils.isEmpty(str)) {
                this.gfv.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHl() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
    }
}
