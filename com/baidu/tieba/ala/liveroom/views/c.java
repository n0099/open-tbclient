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
    private CustomMessageListener ffE;
    private HttpMessageListener ffP;
    private HttpMessageListener ffQ;
    private TextView fnA;
    private boolean fnB;
    private String fnC;
    private boolean fnD;
    private String fnE;
    private boolean fnF;
    private ImageView fnG;
    private com.baidu.tieba.ala.liveroom.share.d fnH;
    private List<String> fnI;
    private String fnJ;
    private String fnK;
    private Random fnL;
    protected View fnM;
    private View.OnClickListener fnN;
    private View.OnClickListener fnO;
    private HttpMessageListener fnP;
    private e.a fng;
    private LinearLayout fnh;
    private ImageView fni;
    private ImageView fnj;
    private ImageView fnk;
    private View fnl;
    private ImageView fnm;
    private TextView fnn;
    private View fno;
    private ImageView fnp;
    private TextView fnq;
    private TextView fnr;
    private Space fns;
    private FrameLayout fnt;
    private Button fnu;
    private LinearLayout fnv;
    private LinearLayout fnw;
    private ImageView fnx;
    private RoundRectRelativeLayout fny;
    private TbImageView fnz;
    private Handler handler;
    private RecorderCallback mRecorderCallback;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fnB = false;
        this.fnD = false;
        this.fnF = false;
        this.handler = new Handler();
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bqO();
                c.this.fnF = z;
                c.this.brd();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bqO();
                if (z) {
                    c.this.fnj.setEnabled(false);
                    c.this.fnj.setVisibility(4);
                    c.this.fnF = false;
                    c.this.brd();
                    return;
                }
                c.this.fnj.setEnabled(true);
                c.this.fnj.setVisibility(0);
                if (c.this.flw.isFlashingLightOpen()) {
                    c.this.fnF = true;
                    c.this.brd();
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
                boolean isBackCamera = c.this.flw.isBackCamera();
                if (!isBackCamera) {
                    c.this.fnj.setEnabled(false);
                    c.this.fnj.setVisibility(4);
                } else {
                    c.this.fnj.setEnabled(true);
                    c.this.fnj.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.fnF = c.this.flw.isFlashingLightOpen();
                    c.this.brd();
                }
                if (c.this.flw.hasBeauty() >= 0) {
                    c.this.flw.setBeauty(com.baidu.live.c.pr().getInt("live_beauty_level", 3));
                }
                c.this.bre();
                if (!z && c.this.fng != null) {
                    c.this.fng.boA();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.fnB) {
                    c.this.brf();
                    c.this.fnB = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.fng != null) {
                    c.this.fng.boB();
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
        this.fnN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.flw != null) {
                    c.this.flw.switchFlashingLight();
                    c.this.fnF = c.this.flw.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.brd();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.fnO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bqO();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.flG != null) {
                                c.this.flG.boC();
                                return;
                            }
                            return;
                        }
                        c.this.bqM();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.fnB = true;
                    c.this.flw.stopRecord();
                    if (TextUtils.isEmpty(c.this.fnE)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.flw != null) {
                        c.this.flw.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (c.this.flG != null) {
                        c.this.flG.boE();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.fnM != null && c.this.mRootView.indexOfChild(c.this.fnM) >= 0) {
                                c.this.mRootView.removeView(c.this.fnM);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.flG != null) {
                        c.this.flG.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.flG != null) {
                        c.this.flG.boH();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.brk();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.ffP = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fgR) {
                        ap apVar = com.baidu.live.v.a.zl().axC;
                        if (apVar == null || apVar.acW == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(apVar.acW.aeH);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        c.this.fno.setVisibility(0);
                        if (!com.baidu.live.c.pr().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.brj();
                        }
                        o.g("", 0L);
                        return;
                    }
                    c.this.fno.setVisibility(8);
                }
            }
        };
        this.ffQ = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.fnr.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.fnr.setVisibility(0);
                        return;
                    }
                    c.this.fnr.setVisibility(8);
                }
            }
        };
        this.fnP = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fgV != null && livePrepareListHttpResponseMessage.fgV.size() > 0) {
                        c.this.fnI = new ArrayList(livePrepareListHttpResponseMessage.fgV);
                        c.this.brk();
                    } else {
                        c.this.fnI = new ArrayList();
                    }
                    c.this.fnJ = livePrepareListHttpResponseMessage.fgT;
                    c.this.fnK = livePrepareListHttpResponseMessage.fgU;
                }
            }
        };
        this.ffE = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
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
        bri();
        brh();
        MessageManager.getInstance().registerListener(this.ffP);
        MessageManager.getInstance().registerListener(this.ffQ);
        MessageManager.getInstance().registerListener(this.fnP);
        MessageManager.getInstance().registerListener(this.ffE);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fnL = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fnH = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fnH.g(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fnH.bA(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fnH = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fnH != null) {
            this.fnH.a(iShareCallback);
        }
    }

    private void initViews() {
        this.fnC = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bqN();
                c.this.bqO();
                return false;
            }
        });
        bqH();
        this.flC.setOnClickListener(this.fnO);
        this.fnh = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fny = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fnz = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fnA = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fnz.setIsRound(false);
        this.fnz.setGifIconSupport(false);
        String bqL = bqL();
        this.fnA.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bqL)) {
            this.fnz.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fnz, bqL, true, false);
            this.fnA.setText(a.i.ala_live_change_cover);
            this.fnE = bqL;
        }
        this.flC.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fni = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fni.setOnClickListener(this.fnO);
        this.fnk = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fnk.setOnClickListener(this.fnO);
        this.fnj = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fnl = this.mRootView.findViewById(a.g.beauty_layout);
        this.fnm = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fnn = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fnm.setOnClickListener(this.fnO);
        this.fnn.setOnClickListener(this.fnO);
        this.fno = this.mRootView.findViewById(a.g.goods_layout);
        this.fnp = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.fnq = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fnr = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fnp.setOnClickListener(this.fnO);
        this.fnq.setOnClickListener(this.fnO);
        this.fnr.setOnClickListener(this.fnO);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fnh.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fnh.setLayoutParams(layoutParams);
        }
        this.fns = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fnt = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fnu = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.fnv = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.fnw = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.fnx = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fnG = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fnG.setOnClickListener(this.fnO);
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
        this.fny.setOnClickListener(this.fnO);
        this.fnj.setOnClickListener(this.fnN);
        this.fnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fnt.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bqO() {
        if (this.flG != null) {
            this.flG.boF();
        }
    }

    public void blK() {
        bqM();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bqP() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bqQ() {
        return false;
    }

    public boolean blI() {
        if (this.fnH != null) {
            this.fnH.bqv();
        }
        return this.fnH != null && this.fnH.blI();
    }

    public void blJ() {
        if (this.fnH != null) {
            this.fnH.v(this.fnE, getLiveTitle(), this.fnJ, this.fnK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brd() {
        if (this.fnF) {
            this.fnj.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fnj.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.fnM == null) {
            this.fnM = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.fnM.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.fnM != null) {
                            int[] iArr = new int[2];
                            c.this.fnl.getLocationOnScreen(iArr);
                            c.this.fnM.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int measuredHeight = iArr[1] - c.this.fnM.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = (i - c.this.fnM.getMeasuredWidth()) / 2;
                            layoutParams.rightMargin = (i - c.this.fnM.getMeasuredWidth()) / 2;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.fnM, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.fnM != null && c.this.mRootView.indexOfChild(c.this.fnM) >= 0) {
                            c.this.mRootView.removeView(c.this.fnM);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bre() {
        if (an.c(com.baidu.live.v.a.zl().axC)) {
            this.fnl.setVisibility(0);
            if (an.c(com.baidu.live.v.a.zl().axC)) {
                this.fnm.setAlpha(0.2f);
                this.fnn.setAlpha(0.2f);
            }
        } else if (this.flw != null && this.flw.hasBeauty() < 0) {
            this.fnl.setVisibility(8);
        } else {
            this.fnl.setVisibility(0);
        }
    }

    public boolean blE() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brf() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void yU(String str) {
        this.fnD = true;
        this.fnE = str;
        this.fnA.setText(a.i.ala_live_change_cover);
        zw(str);
        k.a(this.fnz, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String blH() {
        return bqL();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        brg();
        bre();
    }

    public void blB() {
        this.flw.setVideoConfig(LiveRecorderConfigHelper.zg().d(2, 1, false));
    }

    private void brg() {
        if (this.flw != null) {
            bre();
            if (this.flw.isBackCamera()) {
                this.fnj.setEnabled(true);
                this.fnj.setVisibility(0);
                this.fnF = this.flw.isFlashingLightOpen();
            } else {
                this.fnj.setEnabled(false);
                this.fnj.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.flw != null) {
                        c.this.flw.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bqO();
        if (this.fnH != null && z) {
            this.fnH.bqu();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int blM() {
        return 1;
    }

    public void a(e.a aVar) {
        this.fng = aVar;
    }

    public void onResume() {
        this.fnB = false;
        if (this.flw != null) {
            if (this.flw.isBackCamera()) {
                this.fnj.setEnabled(true);
                this.fnj.setVisibility(0);
                this.fnF = this.flw.isFlashingLightOpen();
                brd();
            } else {
                this.fnj.setEnabled(false);
                this.fnj.setVisibility(4);
            }
        }
        if (this.flD != null && this.flD.brm() && TextUtils.isEmpty(this.flD.brs())) {
            this.flD.brr();
        }
    }

    public void onRefresh() {
        if (this.fno.getVisibility() == 0) {
            o.g("", 0L);
        }
    }

    public void jm(boolean z) {
        this.flC.setClickable(z);
    }

    public void release() {
        if (this.flw != null) {
            this.flw.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.ffP);
        MessageManager.getInstance().unRegisterListener(this.ffQ);
        MessageManager.getInstance().unRegisterListener(this.fnP);
        MessageManager.getInstance().unRegisterListener(this.ffE);
        if (this.fnH != null) {
            this.fnH.release();
        }
    }

    private void brh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bri() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brj() {
        this.fnp.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.fnp.getLocationOnScreen(iArr);
                c.this.fnv.measure(0, 0);
                int width = (iArr[0] + (c.this.fnp.getWidth() / 2)) - (c.this.fnx.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.fnp.getHeight() / 2)) + (c.this.fnx.getMeasuredHeight() / 2)) - c.this.fnv.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.fns.getLocationOnScreen(iArr2);
                c.this.fnv.setY(height - iArr2[1]);
                c.this.fnw.setX(width);
                int[] iArr3 = new int[2];
                c.this.flC.getLocationOnScreen(iArr3);
                c.this.fnu.setY(iArr3[1] - iArr2[1]);
                c.this.fnt.setVisibility(0);
                com.baidu.live.c.pr().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brk() {
        if (this.fnL != null && this.fnI != null && this.fnI.size() > 0) {
            String str = this.fnI.get(this.fnL.nextInt(100) % this.fnI.size());
            if (!TextUtils.isEmpty(str)) {
                this.flx.setText(str);
            }
        }
    }
}
