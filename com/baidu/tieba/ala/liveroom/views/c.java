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
    private CustomMessageListener ffR;
    private HttpMessageListener fgc;
    private HttpMessageListener fgd;
    private TextView fnA;
    private View fnB;
    private ImageView fnC;
    private TextView fnD;
    private TextView fnE;
    private Space fnF;
    private FrameLayout fnG;
    private Button fnH;
    private LinearLayout fnI;
    private LinearLayout fnJ;
    private ImageView fnK;
    private RoundRectRelativeLayout fnL;
    private TbImageView fnM;
    private TextView fnN;
    private boolean fnO;
    private String fnP;
    private boolean fnQ;
    private String fnR;
    private boolean fnS;
    private ImageView fnT;
    private com.baidu.tieba.ala.liveroom.share.d fnU;
    private List<String> fnV;
    private String fnW;
    private String fnX;
    private Random fnY;
    protected View fnZ;
    private e.a fnt;
    private LinearLayout fnu;
    private ImageView fnv;
    private ImageView fnw;
    private ImageView fnx;
    private View fny;
    private ImageView fnz;
    private View.OnClickListener foa;
    private View.OnClickListener fob;
    private HttpMessageListener foc;
    private Handler handler;
    private RecorderCallback mRecorderCallback;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fnO = false;
        this.fnQ = false;
        this.fnS = false;
        this.handler = new Handler();
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bqP();
                c.this.fnS = z;
                c.this.bre();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bqP();
                if (z) {
                    c.this.fnw.setEnabled(false);
                    c.this.fnw.setVisibility(4);
                    c.this.fnS = false;
                    c.this.bre();
                    return;
                }
                c.this.fnw.setEnabled(true);
                c.this.fnw.setVisibility(0);
                if (c.this.flJ.isFlashingLightOpen()) {
                    c.this.fnS = true;
                    c.this.bre();
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
                boolean isBackCamera = c.this.flJ.isBackCamera();
                if (!isBackCamera) {
                    c.this.fnw.setEnabled(false);
                    c.this.fnw.setVisibility(4);
                } else {
                    c.this.fnw.setEnabled(true);
                    c.this.fnw.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.fnS = c.this.flJ.isFlashingLightOpen();
                    c.this.bre();
                }
                if (c.this.flJ.hasBeauty() >= 0) {
                    c.this.flJ.setBeauty(com.baidu.live.c.pr().getInt("live_beauty_level", 3));
                }
                c.this.brf();
                if (!z && c.this.fnt != null) {
                    c.this.fnt.boB();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.fnO) {
                    c.this.brg();
                    c.this.fnO = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.fnt != null) {
                    c.this.fnt.boC();
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
        this.foa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.flJ != null) {
                    c.this.flJ.switchFlashingLight();
                    c.this.fnS = c.this.flJ.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.bre();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.fob = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bqP();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.flT != null) {
                                c.this.flT.boD();
                                return;
                            }
                            return;
                        }
                        c.this.bqN();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.fnO = true;
                    c.this.flJ.stopRecord();
                    if (TextUtils.isEmpty(c.this.fnR)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.flJ != null) {
                        c.this.flJ.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (c.this.flT != null) {
                        c.this.flT.boF();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.fnZ != null && c.this.mRootView.indexOfChild(c.this.fnZ) >= 0) {
                                c.this.mRootView.removeView(c.this.fnZ);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.flT != null) {
                        c.this.flT.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.flT != null) {
                        c.this.flT.boI();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.brl();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.fgc = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fhe) {
                        ap apVar = com.baidu.live.v.a.zl().axD;
                        if (apVar == null || apVar.acW == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(apVar.acW.aeH);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        c.this.fnB.setVisibility(0);
                        if (!com.baidu.live.c.pr().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.brk();
                        }
                        o.g("", 0L);
                        return;
                    }
                    c.this.fnB.setVisibility(8);
                }
            }
        };
        this.fgd = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.fnE.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.fnE.setVisibility(0);
                        return;
                    }
                    c.this.fnE.setVisibility(8);
                }
            }
        };
        this.foc = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fhi != null && livePrepareListHttpResponseMessage.fhi.size() > 0) {
                        c.this.fnV = new ArrayList(livePrepareListHttpResponseMessage.fhi);
                        c.this.brl();
                    } else {
                        c.this.fnV = new ArrayList();
                    }
                    c.this.fnW = livePrepareListHttpResponseMessage.fhg;
                    c.this.fnX = livePrepareListHttpResponseMessage.fhh;
                }
            }
        };
        this.ffR = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
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
        brj();
        bri();
        MessageManager.getInstance().registerListener(this.fgc);
        MessageManager.getInstance().registerListener(this.fgd);
        MessageManager.getInstance().registerListener(this.foc);
        MessageManager.getInstance().registerListener(this.ffR);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fnY = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fnU = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fnU.g(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fnU.bA(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fnU = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fnU != null) {
            this.fnU.a(iShareCallback);
        }
    }

    private void initViews() {
        this.fnP = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bqO();
                c.this.bqP();
                return false;
            }
        });
        bqI();
        this.flP.setOnClickListener(this.fob);
        this.fnu = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fnL = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fnM = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fnN = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fnM.setIsRound(false);
        this.fnM.setGifIconSupport(false);
        String bqM = bqM();
        this.fnN.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bqM)) {
            this.fnM.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fnM, bqM, true, false);
            this.fnN.setText(a.i.ala_live_change_cover);
            this.fnR = bqM;
        }
        this.flP.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fnv = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fnv.setOnClickListener(this.fob);
        this.fnx = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fnx.setOnClickListener(this.fob);
        this.fnw = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fny = this.mRootView.findViewById(a.g.beauty_layout);
        this.fnz = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fnA = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fnz.setOnClickListener(this.fob);
        this.fnA.setOnClickListener(this.fob);
        this.fnB = this.mRootView.findViewById(a.g.goods_layout);
        this.fnC = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.fnD = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fnE = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fnC.setOnClickListener(this.fob);
        this.fnD.setOnClickListener(this.fob);
        this.fnE.setOnClickListener(this.fob);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fnu.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fnu.setLayoutParams(layoutParams);
        }
        this.fnF = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fnG = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fnH = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.fnI = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.fnJ = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.fnK = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fnT = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fnT.setOnClickListener(this.fob);
        sf();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
    }

    public void zx(String str) {
        com.baidu.live.c.pr().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void sf() {
        this.fnL.setOnClickListener(this.fob);
        this.fnw.setOnClickListener(this.foa);
        this.fnH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fnG.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bqP() {
        if (this.flT != null) {
            this.flT.boG();
        }
    }

    public void blL() {
        bqN();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bqQ() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bqR() {
        return false;
    }

    public boolean blJ() {
        if (this.fnU != null) {
            this.fnU.bqw();
        }
        return this.fnU != null && this.fnU.blJ();
    }

    public void blK() {
        if (this.fnU != null) {
            this.fnU.v(this.fnR, getLiveTitle(), this.fnW, this.fnX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bre() {
        if (this.fnS) {
            this.fnw.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fnw.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.fnZ == null) {
            this.fnZ = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.fnZ.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.fnZ != null) {
                            int[] iArr = new int[2];
                            c.this.fny.getLocationOnScreen(iArr);
                            c.this.fnZ.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int measuredHeight = iArr[1] - c.this.fnZ.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = (i - c.this.fnZ.getMeasuredWidth()) / 2;
                            layoutParams.rightMargin = (i - c.this.fnZ.getMeasuredWidth()) / 2;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.fnZ, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.fnZ != null && c.this.mRootView.indexOfChild(c.this.fnZ) >= 0) {
                            c.this.mRootView.removeView(c.this.fnZ);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brf() {
        if (an.c(com.baidu.live.v.a.zl().axD)) {
            this.fny.setVisibility(0);
            if (an.c(com.baidu.live.v.a.zl().axD)) {
                this.fnz.setAlpha(0.2f);
                this.fnA.setAlpha(0.2f);
            }
        } else if (this.flJ != null && this.flJ.hasBeauty() < 0) {
            this.fny.setVisibility(8);
        } else {
            this.fny.setVisibility(0);
        }
    }

    public boolean blF() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brg() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void yV(String str) {
        this.fnQ = true;
        this.fnR = str;
        this.fnN.setText(a.i.ala_live_change_cover);
        zx(str);
        k.a(this.fnM, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String blI() {
        return bqM();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        brh();
        brf();
    }

    public void blC() {
        this.flJ.setVideoConfig(LiveRecorderConfigHelper.zg().d(2, 1, false));
    }

    private void brh() {
        if (this.flJ != null) {
            brf();
            if (this.flJ.isBackCamera()) {
                this.fnw.setEnabled(true);
                this.fnw.setVisibility(0);
                this.fnS = this.flJ.isFlashingLightOpen();
            } else {
                this.fnw.setEnabled(false);
                this.fnw.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.flJ != null) {
                        c.this.flJ.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bqP();
        if (this.fnU != null && z) {
            this.fnU.bqv();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int blN() {
        return 1;
    }

    public void a(e.a aVar) {
        this.fnt = aVar;
    }

    public void onResume() {
        this.fnO = false;
        if (this.flJ != null) {
            if (this.flJ.isBackCamera()) {
                this.fnw.setEnabled(true);
                this.fnw.setVisibility(0);
                this.fnS = this.flJ.isFlashingLightOpen();
                bre();
            } else {
                this.fnw.setEnabled(false);
                this.fnw.setVisibility(4);
            }
        }
        if (this.flQ != null && this.flQ.brn() && TextUtils.isEmpty(this.flQ.brt())) {
            this.flQ.brs();
        }
    }

    public void onRefresh() {
        if (this.fnB.getVisibility() == 0) {
            o.g("", 0L);
        }
    }

    public void jm(boolean z) {
        this.flP.setClickable(z);
    }

    public void release() {
        if (this.flJ != null) {
            this.flJ.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.fgc);
        MessageManager.getInstance().unRegisterListener(this.fgd);
        MessageManager.getInstance().unRegisterListener(this.foc);
        MessageManager.getInstance().unRegisterListener(this.ffR);
        if (this.fnU != null) {
            this.fnU.release();
        }
    }

    private void bri() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void brj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brk() {
        this.fnC.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.fnC.getLocationOnScreen(iArr);
                c.this.fnI.measure(0, 0);
                int width = (iArr[0] + (c.this.fnC.getWidth() / 2)) - (c.this.fnK.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.fnC.getHeight() / 2)) + (c.this.fnK.getMeasuredHeight() / 2)) - c.this.fnI.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.fnF.getLocationOnScreen(iArr2);
                c.this.fnI.setY(height - iArr2[1]);
                c.this.fnJ.setX(width);
                int[] iArr3 = new int[2];
                c.this.flP.getLocationOnScreen(iArr3);
                c.this.fnH.setY(iArr3[1] - iArr2[1]);
                c.this.fnG.setVisibility(0);
                com.baidu.live.c.pr().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brl() {
        if (this.fnY != null && this.fnV != null && this.fnV.size() > 0) {
            String str = this.fnV.get(this.fnY.nextInt(100) % this.fnV.size());
            if (!TextUtils.isEmpty(str)) {
                this.flK.setText(str);
            }
        }
    }
}
