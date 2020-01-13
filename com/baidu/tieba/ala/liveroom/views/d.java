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
import com.baidu.live.data.am;
import com.baidu.live.data.ao;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.r.a;
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
import com.baidu.live.utils.k;
import com.baidu.live.utils.o;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.LivePrepareListHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class d extends a {
    private HttpMessageListener fcH;
    private HttpMessageListener fcI;
    private CustomMessageListener fcv;
    private LinearLayout fkA;
    private LinearLayout fkB;
    private ImageView fkC;
    private RoundRectRelativeLayout fkD;
    private TbImageView fkE;
    private TextView fkF;
    private boolean fkG;
    private String fkH;
    private boolean fkI;
    private String fkJ;
    private boolean fkK;
    private ImageView fkL;
    private com.baidu.tieba.ala.liveroom.share.d fkM;
    private List<String> fkN;
    private String fkO;
    private String fkP;
    private Random fkQ;
    protected View fkR;
    private View.OnClickListener fkS;
    private View.OnClickListener fkT;
    private HttpMessageListener fkU;
    private f.a fkl;
    private LinearLayout fkm;
    private ImageView fkn;
    private ImageView fko;
    private ImageView fkp;
    private View fkq;
    private ImageView fkr;
    private TextView fks;
    private View fkt;
    private ImageView fku;
    private TextView fkv;
    private TextView fkw;
    private Space fkx;
    private FrameLayout fky;
    private Button fkz;
    private Handler handler;
    private RecorderCallback mRecorderCallback;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fkG = false;
        this.fkI = false;
        this.fkK = false;
        this.handler = new Handler();
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.d.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                d.this.bpg();
                d.this.fkK = z;
                d.this.bpv();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                d.this.bpg();
                if (z) {
                    d.this.fko.setEnabled(false);
                    d.this.fko.setVisibility(4);
                    d.this.fkK = false;
                    d.this.bpv();
                    return;
                }
                d.this.fko.setEnabled(true);
                d.this.fko.setVisibility(0);
                if (d.this.fiq.isFlashingLightOpen()) {
                    d.this.fkK = true;
                    d.this.bpv();
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
                boolean isBackCamera = d.this.fiq.isBackCamera();
                if (!isBackCamera) {
                    d.this.fko.setEnabled(false);
                    d.this.fko.setVisibility(4);
                } else {
                    d.this.fko.setEnabled(true);
                    d.this.fko.setVisibility(0);
                }
                if (isBackCamera) {
                    d.this.fkK = d.this.fiq.isFlashingLightOpen();
                    d.this.bpv();
                }
                if (d.this.fiq.hasBeauty() >= 0) {
                    d.this.fiq.setBeauty(com.baidu.live.c.oJ().getInt("live_beauty_level", 3));
                }
                d.this.bpw();
                if (!z && d.this.fkl != null) {
                    d.this.fkl.bmO();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (d.this.fkG) {
                    d.this.bpx();
                    d.this.fkG = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && d.this.fkl != null) {
                    d.this.fkl.bmP();
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
        this.fkS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fiq != null) {
                    d.this.fiq.switchFlashingLight();
                    d.this.fkK = d.this.fiq.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                d.this.bpv();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.fkT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bpg();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) {
                            if (d.this.fiC != null) {
                                d.this.fiC.bmQ();
                                return;
                            }
                            return;
                        }
                        d.this.bpe();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    d.this.fkG = true;
                    d.this.fiq.stopRecord();
                    if (TextUtils.isEmpty(d.this.fkJ)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (d.this.fiq != null) {
                        d.this.fiq.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (d.this.fiC != null) {
                        d.this.fiC.bmS();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    d.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.this.mRootView != null && d.this.fkR != null && d.this.mRootView.indexOfChild(d.this.fkR) >= 0) {
                                d.this.mRootView.removeView(d.this.fkR);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (d.this.fiC != null) {
                        d.this.fiC.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (d.this.fiC != null) {
                        d.this.fiC.bmV();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    d.this.bpC();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.fcH = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fdG) {
                        ao aoVar = com.baidu.live.s.a.wR().atk;
                        if (aoVar == null || aoVar.aaY == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(aoVar.aaY.acF);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        d.this.fkt.setVisibility(0);
                        if (!com.baidu.live.c.oJ().getBoolean("has_show_goods_auth_guide", false)) {
                            d.this.bpB();
                        }
                        o.g("", 0L);
                        return;
                    }
                    d.this.fkt.setVisibility(8);
                }
            }
        };
        this.fcI = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        d.this.fkw.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        d.this.fkw.setVisibility(0);
                        return;
                    }
                    d.this.fkw.setVisibility(8);
                }
            }
        };
        this.fkU = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fdK != null && livePrepareListHttpResponseMessage.fdK.size() > 0) {
                        d.this.fkN = new ArrayList(livePrepareListHttpResponseMessage.fdK);
                        d.this.bpC();
                    } else {
                        d.this.fkN = new ArrayList();
                    }
                    d.this.fkO = livePrepareListHttpResponseMessage.fdI;
                    d.this.fkP = livePrepareListHttpResponseMessage.fdJ;
                }
            }
        };
        this.fcv = new CustomMessageListener(2913145) { // from class: com.baidu.tieba.ala.liveroom.views.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.TY != null && data.TY.Ue == 1) {
                    d.this.y(data.TY.mText, 1000L);
                }
            }
        };
        initViews();
        bpA();
        bpz();
        MessageManager.getInstance().registerListener(this.fcH);
        MessageManager.getInstance().registerListener(this.fcI);
        MessageManager.getInstance().registerListener(this.fkU);
        MessageManager.getInstance().registerListener(this.fcv);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fkQ = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fkM = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fkM.am(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fkM.bA(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fkM = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fkM != null) {
            this.fkM.a(iShareCallback);
        }
    }

    private void initViews() {
        this.fkH = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.bpf();
                d.this.bpg();
                return false;
            }
        });
        boZ();
        this.fiy.setOnClickListener(this.fkT);
        this.fkm = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fkD = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fkE = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fkF = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fkE.setIsRound(false);
        this.fkE.setGifIconSupport(false);
        String bpd = bpd();
        this.fkF.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bpd)) {
            this.fkE.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fkE, bpd, true, false);
            this.fkF.setText(a.i.ala_live_change_cover);
            this.fkJ = bpd;
        }
        this.fiy.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fkn = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fkn.setOnClickListener(this.fkT);
        this.fkp = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fkp.setOnClickListener(this.fkT);
        this.fko = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fkq = this.mRootView.findViewById(a.g.beauty_layout);
        this.fkr = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fks = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fkr.setOnClickListener(this.fkT);
        this.fks.setOnClickListener(this.fkT);
        this.fkt = this.mRootView.findViewById(a.g.goods_layout);
        this.fku = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.fkv = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fkw = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fku.setOnClickListener(this.fkT);
        this.fkv.setOnClickListener(this.fkT);
        this.fkw.setOnClickListener(this.fkT);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkm.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fkm.setLayoutParams(layoutParams);
        }
        this.fkx = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fky = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fkz = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.fkA = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.fkB = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.fkC = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fkL = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fkL.setOnClickListener(this.fkT);
        re();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
    }

    public void ze(String str) {
        com.baidu.live.c.oJ().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void re() {
        this.fkD.setOnClickListener(this.fkT);
        this.fko.setOnClickListener(this.fkS);
        this.fkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fky.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bpg() {
        if (this.fiC != null) {
            this.fiC.bmT();
        }
    }

    public void bjU() {
        bpe();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bph() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bpi() {
        return false;
    }

    public boolean bjS() {
        if (this.fkM != null) {
            this.fkM.boN();
        }
        return this.fkM != null && this.fkM.bjS();
    }

    public void bjT() {
        if (this.fkM != null) {
            this.fkM.s(this.fkJ, getLiveTitle(), this.fkO, this.fkP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpv() {
        if (this.fkK) {
            this.fko.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fko.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.fkR == null) {
            this.fkR = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.fkR.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (d.this.mRootView != null && (pageActivity = d.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && d.this.fkR != null) {
                            int[] iArr = new int[2];
                            d.this.fkq.getLocationOnScreen(iArr);
                            d.this.fkR.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int measuredHeight = iArr[1] - d.this.fkR.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = (i - d.this.fkR.getMeasuredWidth()) / 2;
                            layoutParams.rightMargin = (i - d.this.fkR.getMeasuredWidth()) / 2;
                            layoutParams.topMargin = measuredHeight;
                            d.this.mRootView.addView(d.this.fkR, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.mRootView != null && d.this.fkR != null && d.this.mRootView.indexOfChild(d.this.fkR) >= 0) {
                            d.this.mRootView.removeView(d.this.fkR);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpw() {
        if (am.c(com.baidu.live.s.a.wR().atk)) {
            this.fkq.setVisibility(0);
            if (am.c(com.baidu.live.s.a.wR().atk)) {
                this.fkr.setAlpha(0.2f);
                this.fks.setAlpha(0.2f);
            }
        } else if (this.fiq != null && this.fiq.hasBeauty() < 0) {
            this.fkq.setVisibility(8);
        } else {
            this.fkq.setVisibility(0);
        }
    }

    public boolean bjO() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpx() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void yA(String str) {
        this.fkI = true;
        this.fkJ = str;
        this.fkF.setText(a.i.ala_live_change_cover);
        ze(str);
        k.a(this.fkE, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bjR() {
        return bpd();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bpy();
        bpw();
    }

    public void bjL() {
        this.fiq.setVideoConfig(AlaLiveRecordConfigHelper.bjH().k(2, 1, false));
    }

    private void bpy() {
        if (this.fiq != null) {
            bpw();
            if (this.fiq.isBackCamera()) {
                this.fko.setEnabled(true);
                this.fko.setVisibility(0);
                this.fkK = this.fiq.isFlashingLightOpen();
            } else {
                this.fko.setEnabled(false);
                this.fko.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.12
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fiq != null) {
                        d.this.fiq.addRecorderCallback(d.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bpg();
        if (this.fkM != null && z) {
            this.fkM.boM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bjW() {
        return 1;
    }

    public void a(f.a aVar) {
        this.fkl = aVar;
    }

    public void onResume() {
        this.fkG = false;
        if (this.fiq != null) {
            if (this.fiq.isBackCamera()) {
                this.fko.setEnabled(true);
                this.fko.setVisibility(0);
                this.fkK = this.fiq.isFlashingLightOpen();
                bpv();
            } else {
                this.fko.setEnabled(false);
                this.fko.setVisibility(4);
            }
        }
        if (this.fiz != null && this.fiz.bpD() && TextUtils.isEmpty(this.fiz.bpJ())) {
            this.fiz.bpI();
        }
    }

    public void onRefresh() {
        if (this.fkt.getVisibility() == 0) {
            o.g("", 0L);
        }
    }

    public void jj(boolean z) {
        this.fiy.setClickable(z);
    }

    public void release() {
        if (this.fiq != null) {
            this.fiq.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.fcH);
        MessageManager.getInstance().unRegisterListener(this.fcI);
        MessageManager.getInstance().unRegisterListener(this.fkU);
        MessageManager.getInstance().unRegisterListener(this.fcv);
        if (this.fkM != null) {
            this.fkM.release();
        }
    }

    private void bpz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bpA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpB() {
        this.fku.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.13
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                d.this.fku.getLocationOnScreen(iArr);
                d.this.fkA.measure(0, 0);
                int width = (iArr[0] + (d.this.fku.getWidth() / 2)) - (d.this.fkC.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (d.this.fku.getHeight() / 2)) + (d.this.fkC.getMeasuredHeight() / 2)) - d.this.fkA.getMeasuredHeight();
                int[] iArr2 = new int[2];
                d.this.fkx.getLocationOnScreen(iArr2);
                d.this.fkA.setY(height - iArr2[1]);
                d.this.fkB.setX(width);
                int[] iArr3 = new int[2];
                d.this.fiy.getLocationOnScreen(iArr3);
                d.this.fkz.setY(iArr3[1] - iArr2[1]);
                d.this.fky.setVisibility(0);
                com.baidu.live.c.oJ().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpC() {
        if (this.fkQ != null && this.fkN != null && this.fkN.size() > 0) {
            String str = this.fkN.get(this.fkQ.nextInt(100) % this.fkN.size());
            if (!TextUtils.isEmpty(str)) {
                this.fir.setText(str);
            }
        }
    }
}
