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
    private com.baidu.tieba.ala.liveroom.activeview.b fKn;
    private CustomMessageListener fYP;
    private com.baidu.tieba.ala.category.b.a fZS;
    private HttpMessageListener fZc;
    private HttpMessageListener fZd;
    private LinearLayout ghA;
    private LinearLayout ghB;
    private ImageView ghC;
    private RoundRectRelativeLayout ghD;
    private TbImageView ghE;
    private TextView ghF;
    private boolean ghG;
    private String ghH;
    private boolean ghI;
    private String ghJ;
    private boolean ghK;
    private ImageView ghL;
    private com.baidu.tieba.ala.liveroom.share.d ghM;
    private List<String> ghN;
    private String ghO;
    private String ghP;
    private Random ghQ;
    private int ghR;
    private boolean ghS;
    protected View ghT;
    private CheckedTextView ghU;
    private h ghV;
    private int ghW;
    private RelativeLayout ghX;
    private TextView ghY;
    private FrameLayout ghZ;
    private e.a ghl;
    private LinearLayout ghm;
    private ImageView ghn;
    private ImageView gho;
    private ImageView ghp;
    private View ghq;
    private ImageView ghr;
    private TextView ghs;
    private View ght;
    private ImageView ghu;
    private TextView ghv;
    private TextView ghw;
    private Space ghx;
    private FrameLayout ghy;
    private Button ghz;
    private View.OnClickListener gia;
    private View.OnClickListener gib;
    private HttpMessageListener gic;
    private HttpMessageListener gie;
    private CustomMessageListener gif;
    private Handler handler;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    static /* synthetic */ int x(c cVar) {
        int i = cVar.ghW;
        cVar.ghW = i + 1;
        return i;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ghG = false;
        this.ghI = false;
        this.ghK = false;
        this.ghR = 0;
        this.ghS = false;
        this.handler = new Handler();
        this.ghW = 0;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bGI();
                c.this.ghK = z;
                c.this.bHc();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bGI();
                if (z) {
                    c.this.gho.setEnabled(false);
                    c.this.gho.setVisibility(4);
                    c.this.ghK = false;
                    c.this.bHc();
                    return;
                }
                c.this.gho.setEnabled(true);
                c.this.gho.setVisibility(0);
                if (c.this.bfx.isFlashingLightOpen()) {
                    c.this.ghK = true;
                    c.this.bHc();
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
                    c.this.gho.setEnabled(false);
                    c.this.gho.setVisibility(4);
                } else {
                    c.this.gho.setEnabled(true);
                    c.this.gho.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.ghK = c.this.bfx.isFlashingLightOpen();
                    c.this.bHc();
                }
                if (c.this.bfx.hasBeauty() >= 0) {
                    c.this.bfx.setBeauty(com.baidu.live.c.uN().getInt("live_beauty_level", 3));
                }
                c.this.bHe();
                if (!z && c.this.ghl != null) {
                    c.this.ghl.bEb();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.ghG) {
                    c.this.bHf();
                    c.this.ghG = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.ghl != null) {
                    c.this.ghl.bEc();
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
        this.gia = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bfx != null) {
                    c.this.bfx.switchFlashingLight();
                    c.this.ghK = c.this.bfx.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.bHc();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.gib = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bGI();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.gfP != null) {
                                c.this.gfP.bEd();
                                return;
                            }
                            return;
                        }
                        c.this.bGE();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.ghG = true;
                    c.this.bfx.stopRecord();
                    if (TextUtils.isEmpty(c.this.ghJ)) {
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
                    if (c.this.gfP != null) {
                        c.this.gfP.bEf();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.ghT != null && c.this.mRootView.indexOfChild(c.this.ghT) >= 0) {
                                c.this.mRootView.removeView(c.this.ghT);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.gfP != null) {
                        c.this.gfP.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.gfP != null) {
                        c.this.gfP.bEi();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.bHm();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                    c.this.bHd();
                } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.fZS), com.baidu.tieba.ala.category.b.a.b(c.this.fZS))));
                }
            }
        };
        this.fZc = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    c.this.b(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
                } else if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    c.this.ghW = 0;
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).gaf) {
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
                        c.this.ght.setVisibility(0);
                        if (!com.baidu.live.c.uN().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.bHk();
                        }
                        o.a("", 0L, true, false);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
                    } else {
                        c.this.ght.setVisibility(8);
                    }
                    c.this.b(httpResponsedMessage, null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH_SUCC);
                } else {
                    c.x(c.this);
                    if (c.this.ghW < 3) {
                        c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bHn();
                            }
                        }, 2000L);
                    }
                    c.this.b(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
                }
            }
        };
        this.fZd = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.ghw.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.ghw.setVisibility(0);
                        return;
                    }
                    c.this.ghw.setVisibility(8);
                }
            }
        };
        this.gic = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.gaj != null && livePrepareListHttpResponseMessage.gaj.size() > 0) {
                        c.this.ghN = new ArrayList(livePrepareListHttpResponseMessage.gaj);
                        c.this.bHm();
                    } else {
                        c.this.ghN = new ArrayList();
                    }
                    c.this.ghO = livePrepareListHttpResponseMessage.gah;
                    c.this.ghP = livePrepareListHttpResponseMessage.gai;
                }
            }
        };
        this.fYP = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.asI != null && data.asI.asQ == 1) {
                    c.this.x(data.asI.mText, 1000L);
                }
            }
        };
        this.gie = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.fZS = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).bEI();
                    }
                    c.this.bHl();
                }
            }
        };
        this.gif = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.fZS = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.bHl();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.bHl();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bHj();
        bHh();
        bHi();
        MessageManager.getInstance().registerListener(this.fZc);
        MessageManager.getInstance().registerListener(this.fZd);
        MessageManager.getInstance().registerListener(this.gic);
        MessageManager.getInstance().registerListener(this.fYP);
        MessageManager.getInstance().registerListener(this.gie);
        MessageManager.getInstance().registerListener(this.gif);
        MessageManager.getInstance().registerListener(this.syncListener);
        bHn();
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.ghQ = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.ghM = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.ghM.l(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.ghM.bE(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.ghM = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.ghM != null) {
            this.ghM.a(iShareCallback);
        }
    }

    private void initViews() {
        this.ghH = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bGH();
                c.this.bGI();
                return false;
            }
        });
        bGz();
        this.gfL.setOnClickListener(this.gib);
        this.ghm = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.ghD = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.ghE = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.ghF = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.ghE.setIsRound(false);
        this.ghE.setGifIconSupport(false);
        String bGD = bGD();
        this.ghF.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bGD)) {
            this.ghE.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.ghE, bGD, true, false);
            this.ghF.setText(a.i.ala_live_change_cover);
            this.ghJ = bGD;
        }
        this.gfL.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.ghn = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.ghn.setOnClickListener(this.gib);
        this.ghp = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.ghp.setOnClickListener(this.gib);
        this.gho = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.ghq = this.mRootView.findViewById(a.g.beauty_layout);
        this.ghr = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.ghs = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.ghr.setOnClickListener(this.gib);
        this.ghs.setOnClickListener(this.gib);
        this.ght = this.mRootView.findViewById(a.g.goods_layout);
        this.ghu = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.ghv = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.ghw = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.ghu.setOnClickListener(this.gib);
        this.ghv.setOnClickListener(this.gib);
        this.ghw.setOnClickListener(this.gib);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghm.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.ghm.setLayoutParams(layoutParams);
        }
        this.ghx = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.ghy = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.ghz = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.ghA = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.ghB = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.ghC = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.ghX = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.ghY = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.ghZ = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.ghX.setOnClickListener(this.gib);
        this.ghL = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.ghL.setOnClickListener(this.gib);
        this.ghU = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.ghU.setOnClickListener(this.gib);
        xT();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.ghS = true;
        bHa();
        bHb();
    }

    private l bGZ() {
        if (com.baidu.live.v.a.Ge().aWF == null || com.baidu.live.v.a.Ge().aWF.ayy == null) {
            return null;
        }
        return com.baidu.live.v.a.Ge().aWF.ayy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHa() {
        l bGZ = bGZ();
        if (bGZ != null && bGZ.avt != null && bGZ.avt.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.ghV = bGZ.avt.get(this.ghR % bGZ.avt.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.ghV.getText());
            this.ghX.setVisibility(0);
            this.ghY.setText(sb);
            this.ghR++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ghS) {
                        c.this.bHa();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.ghX.setVisibility(8);
    }

    private void bHb() {
        if (com.baidu.live.c.uN().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.ghX != null && this.ghX.getVisibility() == 0) {
            com.baidu.live.c.uN().putInt("live_assistant_guide_txt_show_counts", 1);
            this.ghZ.setVisibility(0);
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
        this.ghD.setOnClickListener(this.gib);
        this.gho.setOnClickListener(this.gia);
        this.ghz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ghy.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bGI() {
        if (this.gfP != null) {
            this.gfP.bEg();
        }
    }

    public void bBg() {
        bGE();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bGJ() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bGK() {
        return false;
    }

    public boolean bBe() {
        if (this.ghM != null) {
            this.ghM.bGl();
        }
        return this.ghM != null && this.ghM.bBe();
    }

    public void bBf() {
        if (this.ghM != null) {
            this.ghM.w(this.ghJ, getLiveTitle(), this.ghO, this.ghP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHc() {
        if (this.ghK) {
            this.gho.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.gho.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHd() {
        this.ghZ.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.fKn == null) {
                this.fKn = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.ghV != null && !TextUtils.isEmpty(this.ghV.vX())) {
                this.fKn.Cg(this.ghV.vX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (this.ghT == null) {
            this.ghT = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.ghT.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.15
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.ghT != null) {
                            int[] iArr = new int[2];
                            c.this.ghq.getLocationOnScreen(iArr);
                            c.this.ghT.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.ghq.getWidth() / 2)) - (c.this.ghT.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.ghT.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.ghT.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.ghT, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.ghT != null && c.this.mRootView.indexOfChild(c.this.ghT) >= 0) {
                            c.this.mRootView.removeView(c.this.ghT);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHe() {
        if (av.c(com.baidu.live.v.a.Ge().aYP)) {
            this.ghq.setVisibility(0);
            if (av.c(com.baidu.live.v.a.Ge().aYP)) {
                this.ghr.setAlpha(0.2f);
                this.ghs.setAlpha(0.2f);
            }
        } else if (this.bfx != null && this.bfx.hasBeauty() < 0) {
            this.ghq.setVisibility(8);
        } else {
            this.ghq.setVisibility(0);
        }
    }

    public boolean bBa() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHf() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Co(String str) {
        this.ghI = true;
        this.ghJ = str;
        this.ghF.setText(a.i.ala_live_change_cover);
        CO(str);
        k.a(this.ghE, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bBd() {
        return bGD();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bHg();
        bHe();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a bGG() {
        return this.fZS;
    }

    public void bAX() {
        this.bfx.setVideoConfig(LiveRecorderConfigHelper.FX().d(2, 1, false));
    }

    private void bHg() {
        if (this.bfx != null) {
            bHe();
            if (this.bfx.isBackCamera()) {
                this.gho.setEnabled(true);
                this.gho.setVisibility(0);
                this.ghK = this.bfx.isFlashingLightOpen();
            } else {
                this.gho.setEnabled(false);
                this.gho.setVisibility(4);
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
        bGI();
        if (this.ghM != null && z) {
            this.ghM.bGk();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bBi() {
        return 1;
    }

    public void a(e.a aVar) {
        this.ghl = aVar;
    }

    public void onResume() {
        this.ghG = false;
        if (this.bfx != null) {
            if (this.bfx.isBackCamera()) {
                this.gho.setEnabled(true);
                this.gho.setVisibility(0);
                this.ghK = this.bfx.isFlashingLightOpen();
                bHc();
            } else {
                this.gho.setEnabled(false);
                this.gho.setVisibility(4);
            }
        }
        if (this.gfM != null && this.gfM.bHp() && TextUtils.isEmpty(this.gfM.bHv())) {
            this.gfM.bHu();
        }
    }

    public void onRefresh() {
        if (this.ght.getVisibility() == 0) {
            o.a("", 0L, true, false);
        }
    }

    public void kJ(boolean z) {
        this.gfL.setClickable(z);
    }

    public void release() {
        this.ghS = true;
        if (this.bfx != null) {
            this.bfx.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.fZc);
        MessageManager.getInstance().unRegisterListener(this.fZd);
        MessageManager.getInstance().unRegisterListener(this.gic);
        MessageManager.getInstance().unRegisterListener(this.fYP);
        MessageManager.getInstance().unRegisterListener(this.gie);
        MessageManager.getInstance().unRegisterListener(this.gif);
        if (this.ghM != null) {
            this.ghM.release();
        }
        if (this.fKn != null) {
            this.fKn.release();
            this.fKn = null;
        }
    }

    private void bHh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bHi() {
        if (z.wg()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "/ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    private static void bHj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHk() {
        this.ghu.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.ghu.getLocationOnScreen(iArr);
                c.this.ghA.measure(0, 0);
                int width = (iArr[0] + (c.this.ghu.getWidth() / 2)) - (c.this.ghC.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.ghu.getHeight() / 2)) + (c.this.ghC.getMeasuredHeight() / 2)) - c.this.ghA.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.ghx.getLocationOnScreen(iArr2);
                c.this.ghA.setY(height - iArr2[1]);
                c.this.ghB.setX(width);
                int[] iArr3 = new int[2];
                c.this.gfL.getLocationOnScreen(iArr3);
                c.this.ghz.setY(iArr3[1] - iArr2[1]);
                c.this.ghy.setVisibility(0);
                com.baidu.live.c.uN().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHl() {
        if (z.wg()) {
            this.ghU.setVisibility(0);
            if (this.fZS != null && this.fZS.bsO() != null && !StringUtils.isNull(this.fZS.bsO().getName())) {
                this.ghU.setText(this.fZS.bsO().getName());
                this.ghU.setChecked(true);
                return;
            }
            this.ghU.setText(a.i.ala_live_prepare_select_livetype);
            this.ghU.setChecked(false);
            return;
        }
        this.ghU.setVisibility(8);
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
    public void bHm() {
        if (this.ghQ != null && this.ghN != null && this.ghN.size() > 0) {
            String str = this.ghN.get(this.ghQ.nextInt(100) % this.ghN.size());
            if (!TextUtils.isEmpty(str)) {
                this.gfG.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
    }
}
