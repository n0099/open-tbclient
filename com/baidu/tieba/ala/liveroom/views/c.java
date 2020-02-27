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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.data.an;
import com.baidu.live.data.ap;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.utils.o;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.LivePrepareListHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes3.dex */
public class c extends a {
    private CustomMessageListener ffD;
    private HttpMessageListener ffO;
    private HttpMessageListener ffP;
    private boolean fnA;
    private String fnB;
    private boolean fnC;
    private String fnD;
    private boolean fnE;
    private ImageView fnF;
    private com.baidu.tieba.ala.liveroom.share.d fnG;
    private List<String> fnH;
    private String fnI;
    private String fnJ;
    private Random fnK;
    protected View fnL;
    private View.OnClickListener fnM;
    private View.OnClickListener fnN;
    private HttpMessageListener fnO;
    private e.a fnf;
    private LinearLayout fng;
    private ImageView fnh;
    private ImageView fni;
    private ImageView fnj;
    private View fnk;
    private ImageView fnl;
    private TextView fnm;
    private View fnn;
    private ImageView fno;
    private TextView fnp;
    private TextView fnq;
    private Space fnr;
    private FrameLayout fns;
    private Button fnt;
    private LinearLayout fnu;
    private LinearLayout fnv;
    private ImageView fnw;
    private RoundRectRelativeLayout fnx;
    private TbImageView fny;
    private TextView fnz;
    private Handler handler;
    private RecorderCallback mRecorderCallback;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fnA = false;
        this.fnC = false;
        this.fnE = false;
        this.handler = new Handler();
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bqM();
                c.this.fnE = z;
                c.this.brb();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bqM();
                if (z) {
                    c.this.fni.setEnabled(false);
                    c.this.fni.setVisibility(4);
                    c.this.fnE = false;
                    c.this.brb();
                    return;
                }
                c.this.fni.setEnabled(true);
                c.this.fni.setVisibility(0);
                if (c.this.flv.isFlashingLightOpen()) {
                    c.this.fnE = true;
                    c.this.brb();
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
                boolean isBackCamera = c.this.flv.isBackCamera();
                if (!isBackCamera) {
                    c.this.fni.setEnabled(false);
                    c.this.fni.setVisibility(4);
                } else {
                    c.this.fni.setEnabled(true);
                    c.this.fni.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.fnE = c.this.flv.isFlashingLightOpen();
                    c.this.brb();
                }
                if (c.this.flv.hasBeauty() >= 0) {
                    c.this.flv.setBeauty(com.baidu.live.c.pr().getInt("live_beauty_level", 3));
                }
                c.this.brc();
                if (!z && c.this.fnf != null) {
                    c.this.fnf.boy();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.fnA) {
                    c.this.brd();
                    c.this.fnA = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.fnf != null) {
                    c.this.fnf.boz();
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
        this.fnM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.flv != null) {
                    c.this.flv.switchFlashingLight();
                    c.this.fnE = c.this.flv.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.brb();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.fnN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bqM();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.flF != null) {
                                c.this.flF.boA();
                                return;
                            }
                            return;
                        }
                        c.this.bqK();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.fnA = true;
                    c.this.flv.stopRecord();
                    if (TextUtils.isEmpty(c.this.fnD)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.flv != null) {
                        c.this.flv.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (c.this.flF != null) {
                        c.this.flF.boC();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.fnL != null && c.this.mRootView.indexOfChild(c.this.fnL) >= 0) {
                                c.this.mRootView.removeView(c.this.fnL);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.flF != null) {
                        c.this.flF.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.flF != null) {
                        c.this.flF.boF();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.bri();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.ffO = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fgQ) {
                        ap apVar = com.baidu.live.v.a.zj().axB;
                        if (apVar == null || apVar.acW == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(apVar.acW.aeH);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        c.this.fnn.setVisibility(0);
                        if (!com.baidu.live.c.pr().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.brh();
                        }
                        o.g("", 0L);
                        return;
                    }
                    c.this.fnn.setVisibility(8);
                }
            }
        };
        this.ffP = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.fnq.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.fnq.setVisibility(0);
                        return;
                    }
                    c.this.fnq.setVisibility(8);
                }
            }
        };
        this.fnO = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fgU != null && livePrepareListHttpResponseMessage.fgU.size() > 0) {
                        c.this.fnH = new ArrayList(livePrepareListHttpResponseMessage.fgU);
                        c.this.bri();
                    } else {
                        c.this.fnH = new ArrayList();
                    }
                    c.this.fnI = livePrepareListHttpResponseMessage.fgS;
                    c.this.fnJ = livePrepareListHttpResponseMessage.fgT;
                }
            }
        };
        this.ffD = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.VI != null && data.VI.VN == 1) {
                    c.this.y(data.VI.mText, 1000L);
                }
            }
        };
        initViews();
        brg();
        brf();
        MessageManager.getInstance().registerListener(this.ffO);
        MessageManager.getInstance().registerListener(this.ffP);
        MessageManager.getInstance().registerListener(this.fnO);
        MessageManager.getInstance().registerListener(this.ffD);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fnK = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fnG = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fnG.g(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fnG.bA(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fnG = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fnG != null) {
            this.fnG.a(iShareCallback);
        }
    }

    private void initViews() {
        this.fnB = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bqL();
                c.this.bqM();
                return false;
            }
        });
        bqF();
        this.flB.setOnClickListener(this.fnN);
        this.fng = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fnx = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fny = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fnz = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fny.setIsRound(false);
        this.fny.setGifIconSupport(false);
        String bqJ = bqJ();
        this.fnz.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bqJ)) {
            this.fny.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fny, bqJ, true, false);
            this.fnz.setText(a.i.ala_live_change_cover);
            this.fnD = bqJ;
        }
        this.flB.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fnh = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fnh.setOnClickListener(this.fnN);
        this.fnj = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fnj.setOnClickListener(this.fnN);
        this.fni = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fnk = this.mRootView.findViewById(a.g.beauty_layout);
        this.fnl = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fnm = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fnl.setOnClickListener(this.fnN);
        this.fnm.setOnClickListener(this.fnN);
        this.fnn = this.mRootView.findViewById(a.g.goods_layout);
        this.fno = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.fnp = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fnq = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fno.setOnClickListener(this.fnN);
        this.fnp.setOnClickListener(this.fnN);
        this.fnq.setOnClickListener(this.fnN);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fng.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fng.setLayoutParams(layoutParams);
        }
        this.fnr = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fns = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fnt = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.fnu = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.fnv = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.fnw = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fnF = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fnF.setOnClickListener(this.fnN);
        sf();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
    }

    public void zw(String str) {
        com.baidu.live.c.pr().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void sf() {
        this.fnx.setOnClickListener(this.fnN);
        this.fni.setOnClickListener(this.fnM);
        this.fnt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fns.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bqM() {
        if (this.flF != null) {
            this.flF.boD();
        }
    }

    public void blI() {
        bqK();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bqN() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bqO() {
        return false;
    }

    public boolean blG() {
        if (this.fnG != null) {
            this.fnG.bqt();
        }
        return this.fnG != null && this.fnG.blG();
    }

    public void blH() {
        if (this.fnG != null) {
            this.fnG.v(this.fnD, getLiveTitle(), this.fnI, this.fnJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brb() {
        if (this.fnE) {
            this.fni.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fni.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.fnL == null) {
            this.fnL = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.fnL.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.fnL != null) {
                            int[] iArr = new int[2];
                            c.this.fnk.getLocationOnScreen(iArr);
                            c.this.fnL.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int measuredHeight = iArr[1] - c.this.fnL.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = (i - c.this.fnL.getMeasuredWidth()) / 2;
                            layoutParams.rightMargin = (i - c.this.fnL.getMeasuredWidth()) / 2;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.fnL, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.fnL != null && c.this.mRootView.indexOfChild(c.this.fnL) >= 0) {
                            c.this.mRootView.removeView(c.this.fnL);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brc() {
        if (an.c(com.baidu.live.v.a.zj().axB)) {
            this.fnk.setVisibility(0);
            if (an.c(com.baidu.live.v.a.zj().axB)) {
                this.fnl.setAlpha(0.2f);
                this.fnm.setAlpha(0.2f);
            }
        } else if (this.flv != null && this.flv.hasBeauty() < 0) {
            this.fnk.setVisibility(8);
        } else {
            this.fnk.setVisibility(0);
        }
    }

    public boolean blC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brd() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void yU(String str) {
        this.fnC = true;
        this.fnD = str;
        this.fnz.setText(a.i.ala_live_change_cover);
        zw(str);
        k.a(this.fny, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String blF() {
        return bqJ();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bre();
        brc();
    }

    public void blz() {
        this.flv.setVideoConfig(LiveRecorderConfigHelper.ze().d(2, 1, false));
    }

    private void bre() {
        if (this.flv != null) {
            brc();
            if (this.flv.isBackCamera()) {
                this.fni.setEnabled(true);
                this.fni.setVisibility(0);
                this.fnE = this.flv.isFlashingLightOpen();
            } else {
                this.fni.setEnabled(false);
                this.fni.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.flv != null) {
                        c.this.flv.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bqM();
        if (this.fnG != null && z) {
            this.fnG.bqs();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int blK() {
        return 1;
    }

    public void a(e.a aVar) {
        this.fnf = aVar;
    }

    public void onResume() {
        this.fnA = false;
        if (this.flv != null) {
            if (this.flv.isBackCamera()) {
                this.fni.setEnabled(true);
                this.fni.setVisibility(0);
                this.fnE = this.flv.isFlashingLightOpen();
                brb();
            } else {
                this.fni.setEnabled(false);
                this.fni.setVisibility(4);
            }
        }
        if (this.flC != null && this.flC.brk() && TextUtils.isEmpty(this.flC.brq())) {
            this.flC.brp();
        }
    }

    public void onRefresh() {
        if (this.fnn.getVisibility() == 0) {
            o.g("", 0L);
        }
    }

    public void jm(boolean z) {
        this.flB.setClickable(z);
    }

    public void release() {
        if (this.flv != null) {
            this.flv.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.ffO);
        MessageManager.getInstance().unRegisterListener(this.ffP);
        MessageManager.getInstance().unRegisterListener(this.fnO);
        MessageManager.getInstance().unRegisterListener(this.ffD);
        if (this.fnG != null) {
            this.fnG.release();
        }
    }

    private void brf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void brg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brh() {
        this.fno.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.fno.getLocationOnScreen(iArr);
                c.this.fnu.measure(0, 0);
                int width = (iArr[0] + (c.this.fno.getWidth() / 2)) - (c.this.fnw.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.fno.getHeight() / 2)) + (c.this.fnw.getMeasuredHeight() / 2)) - c.this.fnu.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.fnr.getLocationOnScreen(iArr2);
                c.this.fnu.setY(height - iArr2[1]);
                c.this.fnv.setX(width);
                int[] iArr3 = new int[2];
                c.this.flB.getLocationOnScreen(iArr3);
                c.this.fnt.setY(iArr3[1] - iArr2[1]);
                c.this.fns.setVisibility(0);
                com.baidu.live.c.pr().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bri() {
        if (this.fnK != null && this.fnH != null && this.fnH.size() > 0) {
            String str = this.fnH.get(this.fnK.nextInt(100) % this.fnH.size());
            if (!TextUtils.isEmpty(str)) {
                this.flw.setText(str);
            }
        }
    }
}
