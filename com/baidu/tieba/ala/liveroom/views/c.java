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
import com.baidu.live.data.aq;
import com.baidu.live.data.as;
import com.baidu.live.data.i;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
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
    private CustomMessageListener fKG;
    private HttpMessageListener fKT;
    private HttpMessageListener fKU;
    private Space fSA;
    private FrameLayout fSB;
    private Button fSC;
    private LinearLayout fSD;
    private LinearLayout fSE;
    private ImageView fSF;
    private RoundRectRelativeLayout fSG;
    private TbImageView fSH;
    private TextView fSI;
    private boolean fSJ;
    private String fSK;
    private boolean fSL;
    private String fSM;
    private boolean fSN;
    private ImageView fSO;
    private com.baidu.tieba.ala.liveroom.share.d fSP;
    private List<String> fSQ;
    private String fSR;
    private String fSS;
    private Random fST;
    private int fSU;
    private boolean fSV;
    protected View fSW;
    private RelativeLayout fSX;
    private TextView fSY;
    private FrameLayout fSZ;
    private e.a fSo;
    private LinearLayout fSp;
    private ImageView fSq;
    private ImageView fSr;
    private ImageView fSs;
    private View fSt;
    private ImageView fSu;
    private TextView fSv;
    private View fSw;
    private ImageView fSx;
    private TextView fSy;
    private TextView fSz;
    private View.OnClickListener fTa;
    private View.OnClickListener fTb;
    private HttpMessageListener fTc;
    private com.baidu.tieba.ala.liveroom.activeview.b fwg;
    private Handler handler;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fSJ = false;
        this.fSL = false;
        this.fSN = false;
        this.fSU = 0;
        this.fSV = false;
        this.handler = new Handler();
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bAr();
                c.this.fSN = z;
                c.this.bAK();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bAr();
                if (z) {
                    c.this.fSr.setEnabled(false);
                    c.this.fSr.setVisibility(4);
                    c.this.fSN = false;
                    c.this.bAK();
                    return;
                }
                c.this.fSr.setEnabled(true);
                c.this.fSr.setVisibility(0);
                if (c.this.aYb.isFlashingLightOpen()) {
                    c.this.fSN = true;
                    c.this.bAK();
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
                boolean isBackCamera = c.this.aYb.isBackCamera();
                if (!isBackCamera) {
                    c.this.fSr.setEnabled(false);
                    c.this.fSr.setVisibility(4);
                } else {
                    c.this.fSr.setEnabled(true);
                    c.this.fSr.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.fSN = c.this.aYb.isFlashingLightOpen();
                    c.this.bAK();
                }
                if (c.this.aYb.hasBeauty() >= 0) {
                    c.this.aYb.setBeauty(com.baidu.live.c.tG().getInt("live_beauty_level", 3));
                }
                c.this.bAL();
                if (!z && c.this.fSo != null) {
                    c.this.fSo.bxW();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.fSJ) {
                    c.this.bAM();
                    c.this.fSJ = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.fSo != null) {
                    c.this.fSo.bxX();
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
        this.fTa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aYb != null) {
                    c.this.aYb.switchFlashingLight();
                    c.this.fSN = c.this.aYb.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.bAK();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.fTb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAr();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.fQT != null) {
                                c.this.fQT.bxY();
                                return;
                            }
                            return;
                        }
                        c.this.bAp();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.fSJ = true;
                    c.this.aYb.stopRecord();
                    if (TextUtils.isEmpty(c.this.fSM)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.aYb != null) {
                        c.this.aYb.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                    if (c.this.fQT != null) {
                        c.this.fQT.bya();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.fSW != null && c.this.mRootView.indexOfChild(c.this.fSW) >= 0) {
                                c.this.mRootView.removeView(c.this.fSW);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.fQT != null) {
                        c.this.fQT.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.fQT != null) {
                        c.this.fQT.byd();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.bAR();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                    c.this.fSZ.setVisibility(8);
                    if (c.this.mTbPageContext != null) {
                        if (c.this.fwg == null) {
                            c.this.fwg = new com.baidu.tieba.ala.liveroom.activeview.b(c.this.mTbPageContext);
                        }
                        i bAH = c.this.bAH();
                        if (bAH != null && !TextUtils.isEmpty(bAH.aqs)) {
                            c.this.fwg.Ay(bAH.aqs);
                        }
                    }
                }
            }
        };
        this.fKT = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fLU) {
                        as asVar = com.baidu.live.v.a.En().aRB;
                        if (asVar == null || asVar.avE == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(asVar.avE.axn);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        c.this.fSw.setVisibility(0);
                        if (!com.baidu.live.c.tG().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.bAQ();
                        }
                        o.g("", 0L);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
                        return;
                    }
                    c.this.fSw.setVisibility(8);
                }
            }
        };
        this.fKU = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.fSz.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.fSz.setVisibility(0);
                        return;
                    }
                    c.this.fSz.setVisibility(8);
                }
            }
        };
        this.fTc = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fLY != null && livePrepareListHttpResponseMessage.fLY.size() > 0) {
                        c.this.fSQ = new ArrayList(livePrepareListHttpResponseMessage.fLY);
                        c.this.bAR();
                    } else {
                        c.this.fSQ = new ArrayList();
                    }
                    c.this.fSR = livePrepareListHttpResponseMessage.fLW;
                    c.this.fSS = livePrepareListHttpResponseMessage.fLX;
                }
            }
        };
        this.fKG = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.anO != null && data.anO.anW == 1) {
                    c.this.y(data.anO.mText, 1000L);
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bAP();
        bAO();
        MessageManager.getInstance().registerListener(this.fKT);
        MessageManager.getInstance().registerListener(this.fKU);
        MessageManager.getInstance().registerListener(this.fTc);
        MessageManager.getInstance().registerListener(this.fKG);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fST = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fSP = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fSP.h(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fSP.bF(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fSP = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fSP != null) {
            this.fSP.a(iShareCallback);
        }
    }

    private void initViews() {
        this.fSK = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bAq();
                c.this.bAr();
                return false;
            }
        });
        bAk();
        this.fQP.setOnClickListener(this.fTb);
        this.fSp = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fSG = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fSH = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fSI = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fSH.setIsRound(false);
        this.fSH.setGifIconSupport(false);
        String bAo = bAo();
        this.fSI.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bAo)) {
            this.fSH.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fSH, bAo, true, false);
            this.fSI.setText(a.i.ala_live_change_cover);
            this.fSM = bAo;
        }
        this.fQP.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fSq = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fSq.setOnClickListener(this.fTb);
        this.fSs = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fSs.setOnClickListener(this.fTb);
        this.fSr = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fSt = this.mRootView.findViewById(a.g.beauty_layout);
        this.fSu = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fSv = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fSu.setOnClickListener(this.fTb);
        this.fSv.setOnClickListener(this.fTb);
        this.fSw = this.mRootView.findViewById(a.g.goods_layout);
        this.fSx = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.fSy = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fSz = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fSx.setOnClickListener(this.fTb);
        this.fSy.setOnClickListener(this.fTb);
        this.fSz.setOnClickListener(this.fTb);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fSp.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fSp.setLayoutParams(layoutParams);
        }
        this.fSA = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fSB = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fSC = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.fSD = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.fSE = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.fSF = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fSX = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.fSY = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.fSZ = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.fSX.setOnClickListener(this.fTb);
        this.fSO = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fSO.setOnClickListener(this.fTb);
        wC();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.fSV = true;
        bAI();
        bAJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i bAH() {
        if (com.baidu.live.v.a.En().aQu == null || com.baidu.live.v.a.En().aQu.atA == null) {
            return null;
        }
        return com.baidu.live.v.a.En().aQu.atA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAI() {
        i bAH = bAH();
        if (bAH != null && bAH.aqu != null && bAH.aqu.length > 0) {
            String[] strArr = bAH.aqu;
            this.fSX.setVisibility(0);
            this.fSY.setText("     " + this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant) + strArr[this.fSU % strArr.length]);
            this.fSU++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fSV) {
                        c.this.bAI();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.fSX.setVisibility(8);
    }

    private void bAJ() {
        if (com.baidu.live.c.tG().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.fSX != null && this.fSX.getVisibility() == 0) {
            com.baidu.live.c.tG().putInt("live_assistant_guide_txt_show_counts", 1);
            this.fSZ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Bg(String str) {
        com.baidu.live.c.tG().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void wC() {
        this.fSG.setOnClickListener(this.fTb);
        this.fSr.setOnClickListener(this.fTa);
        this.fSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fSB.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bAr() {
        if (this.fQT != null) {
            this.fQT.byb();
        }
    }

    public void bvf() {
        bAp();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bAs() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bAt() {
        return false;
    }

    public boolean bvd() {
        if (this.fSP != null) {
            this.fSP.bzW();
        }
        return this.fSP != null && this.fSP.bvd();
    }

    public void bve() {
        if (this.fSP != null) {
            this.fSP.v(this.fSM, getLiveTitle(), this.fSR, this.fSS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAK() {
        if (this.fSN) {
            this.fSr.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fSr.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.fSW == null) {
            this.fSW = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.fSW.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.fSW != null) {
                            int[] iArr = new int[2];
                            c.this.fSt.getLocationOnScreen(iArr);
                            c.this.fSW.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.fSt.getWidth() / 2)) - (c.this.fSW.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.fSW.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.fSW.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.fSW, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.fSW != null && c.this.mRootView.indexOfChild(c.this.fSW) >= 0) {
                            c.this.mRootView.removeView(c.this.fSW);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAL() {
        if (aq.c(com.baidu.live.v.a.En().aRB)) {
            this.fSt.setVisibility(0);
            if (aq.c(com.baidu.live.v.a.En().aRB)) {
                this.fSu.setAlpha(0.2f);
                this.fSv.setAlpha(0.2f);
            }
        } else if (this.aYb != null && this.aYb.hasBeauty() < 0) {
            this.fSt.setVisibility(8);
        } else {
            this.fSt.setVisibility(0);
        }
    }

    public boolean buZ() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAM() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void AG(String str) {
        this.fSL = true;
        this.fSM = str;
        this.fSI.setText(a.i.ala_live_change_cover);
        Bg(str);
        k.a(this.fSH, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bvc() {
        return bAo();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bAN();
        bAL();
    }

    public void buW() {
        this.aYb.setVideoConfig(LiveRecorderConfigHelper.Eh().d(2, 1, false));
    }

    private void bAN() {
        if (this.aYb != null) {
            bAL();
            if (this.aYb.isBackCamera()) {
                this.fSr.setEnabled(true);
                this.fSr.setVisibility(0);
                this.fSN = this.aYb.isFlashingLightOpen();
            } else {
                this.fSr.setEnabled(false);
                this.fSr.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.14
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.aYb != null) {
                        c.this.aYb.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bAr();
        if (this.fSP != null && z) {
            this.fSP.bzV();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bvh() {
        return 1;
    }

    public void a(e.a aVar) {
        this.fSo = aVar;
    }

    public void onResume() {
        this.fSJ = false;
        if (this.aYb != null) {
            if (this.aYb.isBackCamera()) {
                this.fSr.setEnabled(true);
                this.fSr.setVisibility(0);
                this.fSN = this.aYb.isFlashingLightOpen();
                bAK();
            } else {
                this.fSr.setEnabled(false);
                this.fSr.setVisibility(4);
            }
        }
        if (this.fQQ != null && this.fQQ.bAT() && TextUtils.isEmpty(this.fQQ.bAZ())) {
            this.fQQ.bAY();
        }
    }

    public void onRefresh() {
        if (this.fSw.getVisibility() == 0) {
            o.g("", 0L);
        }
    }

    public void kp(boolean z) {
        this.fQP.setClickable(z);
    }

    public void release() {
        this.fSV = true;
        if (this.aYb != null) {
            this.aYb.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.fKT);
        MessageManager.getInstance().unRegisterListener(this.fKU);
        MessageManager.getInstance().unRegisterListener(this.fTc);
        MessageManager.getInstance().unRegisterListener(this.fKG);
        if (this.fSP != null) {
            this.fSP.release();
        }
        if (this.fwg != null) {
            this.fwg.release();
            this.fwg = null;
        }
    }

    private void bAO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bAP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAQ() {
        this.fSx.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.fSx.getLocationOnScreen(iArr);
                c.this.fSD.measure(0, 0);
                int width = (iArr[0] + (c.this.fSx.getWidth() / 2)) - (c.this.fSF.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.fSx.getHeight() / 2)) + (c.this.fSF.getMeasuredHeight() / 2)) - c.this.fSD.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.fSA.getLocationOnScreen(iArr2);
                c.this.fSD.setY(height - iArr2[1]);
                c.this.fSE.setX(width);
                int[] iArr3 = new int[2];
                c.this.fQP.getLocationOnScreen(iArr3);
                c.this.fSC.setY(iArr3[1] - iArr2[1]);
                c.this.fSB.setVisibility(0);
                com.baidu.live.c.tG().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAR() {
        if (this.fST != null && this.fSQ != null && this.fSQ.size() > 0) {
            String str = this.fSQ.get(this.fST.nextInt(100) % this.fSQ.size());
            if (!TextUtils.isEmpty(str)) {
                this.fQK.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
