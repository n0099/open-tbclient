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
    private CustomMessageListener fKB;
    private HttpMessageListener fKO;
    private HttpMessageListener fKP;
    private ImageView fSA;
    private RoundRectRelativeLayout fSB;
    private TbImageView fSC;
    private TextView fSD;
    private boolean fSE;
    private String fSF;
    private boolean fSG;
    private String fSH;
    private boolean fSI;
    private ImageView fSJ;
    private com.baidu.tieba.ala.liveroom.share.d fSK;
    private List<String> fSL;
    private String fSM;
    private String fSN;
    private Random fSO;
    private int fSP;
    private boolean fSQ;
    protected View fSR;
    private RelativeLayout fSS;
    private TextView fST;
    private FrameLayout fSU;
    private View.OnClickListener fSV;
    private View.OnClickListener fSW;
    private HttpMessageListener fSX;
    private e.a fSj;
    private LinearLayout fSk;
    private ImageView fSl;
    private ImageView fSm;
    private ImageView fSn;
    private View fSo;
    private ImageView fSp;
    private TextView fSq;
    private View fSr;
    private ImageView fSs;
    private TextView fSt;
    private TextView fSu;
    private Space fSv;
    private FrameLayout fSw;
    private Button fSx;
    private LinearLayout fSy;
    private LinearLayout fSz;
    private com.baidu.tieba.ala.liveroom.activeview.b fwb;
    private Handler handler;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fSE = false;
        this.fSG = false;
        this.fSI = false;
        this.fSP = 0;
        this.fSQ = false;
        this.handler = new Handler();
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bAt();
                c.this.fSI = z;
                c.this.bAM();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bAt();
                if (z) {
                    c.this.fSm.setEnabled(false);
                    c.this.fSm.setVisibility(4);
                    c.this.fSI = false;
                    c.this.bAM();
                    return;
                }
                c.this.fSm.setEnabled(true);
                c.this.fSm.setVisibility(0);
                if (c.this.aXW.isFlashingLightOpen()) {
                    c.this.fSI = true;
                    c.this.bAM();
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
                boolean isBackCamera = c.this.aXW.isBackCamera();
                if (!isBackCamera) {
                    c.this.fSm.setEnabled(false);
                    c.this.fSm.setVisibility(4);
                } else {
                    c.this.fSm.setEnabled(true);
                    c.this.fSm.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.fSI = c.this.aXW.isFlashingLightOpen();
                    c.this.bAM();
                }
                if (c.this.aXW.hasBeauty() >= 0) {
                    c.this.aXW.setBeauty(com.baidu.live.c.tH().getInt("live_beauty_level", 3));
                }
                c.this.bAN();
                if (!z && c.this.fSj != null) {
                    c.this.fSj.bxY();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.fSE) {
                    c.this.bAO();
                    c.this.fSE = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.fSj != null) {
                    c.this.fSj.bxZ();
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
        this.fSV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXW != null) {
                    c.this.aXW.switchFlashingLight();
                    c.this.fSI = c.this.aXW.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.bAM();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.fSW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAt();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.fQO != null) {
                                c.this.fQO.bya();
                                return;
                            }
                            return;
                        }
                        c.this.bAr();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.fSE = true;
                    c.this.aXW.stopRecord();
                    if (TextUtils.isEmpty(c.this.fSH)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.aXW != null) {
                        c.this.aXW.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                    if (c.this.fQO != null) {
                        c.this.fQO.byc();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.fSR != null && c.this.mRootView.indexOfChild(c.this.fSR) >= 0) {
                                c.this.mRootView.removeView(c.this.fSR);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.fQO != null) {
                        c.this.fQO.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.fQO != null) {
                        c.this.fQO.byf();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.bAT();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                    c.this.fSU.setVisibility(8);
                    if (c.this.mTbPageContext != null) {
                        if (c.this.fwb == null) {
                            c.this.fwb = new com.baidu.tieba.ala.liveroom.activeview.b(c.this.mTbPageContext);
                        }
                        i bAJ = c.this.bAJ();
                        if (bAJ != null && !TextUtils.isEmpty(bAJ.aqm)) {
                            c.this.fwb.Av(bAJ.aqm);
                        }
                    }
                }
            }
        };
        this.fKO = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fLP) {
                        as asVar = com.baidu.live.v.a.Eo().aRw;
                        if (asVar == null || asVar.avy == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(asVar.avy.axh);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        c.this.fSr.setVisibility(0);
                        if (!com.baidu.live.c.tH().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.bAS();
                        }
                        o.g("", 0L);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", UbcStatConstant.Page.LIVE_ACTION, "shopcart_show"));
                        return;
                    }
                    c.this.fSr.setVisibility(8);
                }
            }
        };
        this.fKP = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.fSu.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.fSu.setVisibility(0);
                        return;
                    }
                    c.this.fSu.setVisibility(8);
                }
            }
        };
        this.fSX = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fLT != null && livePrepareListHttpResponseMessage.fLT.size() > 0) {
                        c.this.fSL = new ArrayList(livePrepareListHttpResponseMessage.fLT);
                        c.this.bAT();
                    } else {
                        c.this.fSL = new ArrayList();
                    }
                    c.this.fSM = livePrepareListHttpResponseMessage.fLR;
                    c.this.fSN = livePrepareListHttpResponseMessage.fLS;
                }
            }
        };
        this.fKB = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.anI != null && data.anI.anQ == 1) {
                    c.this.y(data.anI.mText, 1000L);
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bAR();
        bAQ();
        MessageManager.getInstance().registerListener(this.fKO);
        MessageManager.getInstance().registerListener(this.fKP);
        MessageManager.getInstance().registerListener(this.fSX);
        MessageManager.getInstance().registerListener(this.fKB);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fSO = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fSK = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fSK.h(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fSK.bF(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fSK = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fSK != null) {
            this.fSK.a(iShareCallback);
        }
    }

    private void initViews() {
        this.fSF = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bAs();
                c.this.bAt();
                return false;
            }
        });
        bAm();
        this.fQK.setOnClickListener(this.fSW);
        this.fSk = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fSB = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fSC = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fSD = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fSC.setIsRound(false);
        this.fSC.setGifIconSupport(false);
        String bAq = bAq();
        this.fSD.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bAq)) {
            this.fSC.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fSC, bAq, true, false);
            this.fSD.setText(a.i.ala_live_change_cover);
            this.fSH = bAq;
        }
        this.fQK.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fSl = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fSl.setOnClickListener(this.fSW);
        this.fSn = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fSn.setOnClickListener(this.fSW);
        this.fSm = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fSo = this.mRootView.findViewById(a.g.beauty_layout);
        this.fSp = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fSq = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fSp.setOnClickListener(this.fSW);
        this.fSq.setOnClickListener(this.fSW);
        this.fSr = this.mRootView.findViewById(a.g.goods_layout);
        this.fSs = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.fSt = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fSu = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fSs.setOnClickListener(this.fSW);
        this.fSt.setOnClickListener(this.fSW);
        this.fSu.setOnClickListener(this.fSW);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fSk.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fSk.setLayoutParams(layoutParams);
        }
        this.fSv = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fSw = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fSx = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.fSy = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.fSz = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.fSA = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fSS = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.fST = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.fSU = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.fSS.setOnClickListener(this.fSW);
        this.fSJ = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fSJ.setOnClickListener(this.fSW);
        wD();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.fSQ = true;
        bAK();
        bAL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i bAJ() {
        if (com.baidu.live.v.a.Eo().aQp == null || com.baidu.live.v.a.Eo().aQp.atu == null) {
            return null;
        }
        return com.baidu.live.v.a.Eo().aQp.atu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAK() {
        i bAJ = bAJ();
        if (bAJ != null && bAJ.aqo != null && bAJ.aqo.length > 0) {
            String[] strArr = bAJ.aqo;
            this.fSS.setVisibility(0);
            this.fST.setText("     " + this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant) + strArr[this.fSP % strArr.length]);
            this.fSP++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fSQ) {
                        c.this.bAK();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.fSS.setVisibility(8);
    }

    private void bAL() {
        if (com.baidu.live.c.tH().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.fSS != null && this.fSS.getVisibility() == 0) {
            com.baidu.live.c.tH().putInt("live_assistant_guide_txt_show_counts", 1);
            this.fSU.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Bd(String str) {
        com.baidu.live.c.tH().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void wD() {
        this.fSB.setOnClickListener(this.fSW);
        this.fSm.setOnClickListener(this.fSV);
        this.fSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fSw.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bAt() {
        if (this.fQO != null) {
            this.fQO.byd();
        }
    }

    public void bvh() {
        bAr();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bAu() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bAv() {
        return false;
    }

    public boolean bvf() {
        if (this.fSK != null) {
            this.fSK.bzY();
        }
        return this.fSK != null && this.fSK.bvf();
    }

    public void bvg() {
        if (this.fSK != null) {
            this.fSK.v(this.fSH, getLiveTitle(), this.fSM, this.fSN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAM() {
        if (this.fSI) {
            this.fSm.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fSm.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.fSR == null) {
            this.fSR = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.fSR.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.fSR != null) {
                            int[] iArr = new int[2];
                            c.this.fSo.getLocationOnScreen(iArr);
                            c.this.fSR.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.fSo.getWidth() / 2)) - (c.this.fSR.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.fSR.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.fSR.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.fSR, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.fSR != null && c.this.mRootView.indexOfChild(c.this.fSR) >= 0) {
                            c.this.mRootView.removeView(c.this.fSR);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAN() {
        if (aq.c(com.baidu.live.v.a.Eo().aRw)) {
            this.fSo.setVisibility(0);
            if (aq.c(com.baidu.live.v.a.Eo().aRw)) {
                this.fSp.setAlpha(0.2f);
                this.fSq.setAlpha(0.2f);
            }
        } else if (this.aXW != null && this.aXW.hasBeauty() < 0) {
            this.fSo.setVisibility(8);
        } else {
            this.fSo.setVisibility(0);
        }
    }

    public boolean bvb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAO() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void AD(String str) {
        this.fSG = true;
        this.fSH = str;
        this.fSD.setText(a.i.ala_live_change_cover);
        Bd(str);
        k.a(this.fSC, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bve() {
        return bAq();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bAP();
        bAN();
    }

    public void buY() {
        this.aXW.setVideoConfig(LiveRecorderConfigHelper.Ei().d(2, 1, false));
    }

    private void bAP() {
        if (this.aXW != null) {
            bAN();
            if (this.aXW.isBackCamera()) {
                this.fSm.setEnabled(true);
                this.fSm.setVisibility(0);
                this.fSI = this.aXW.isFlashingLightOpen();
            } else {
                this.fSm.setEnabled(false);
                this.fSm.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.14
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.aXW != null) {
                        c.this.aXW.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bAt();
        if (this.fSK != null && z) {
            this.fSK.bzX();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bvj() {
        return 1;
    }

    public void a(e.a aVar) {
        this.fSj = aVar;
    }

    public void onResume() {
        this.fSE = false;
        if (this.aXW != null) {
            if (this.aXW.isBackCamera()) {
                this.fSm.setEnabled(true);
                this.fSm.setVisibility(0);
                this.fSI = this.aXW.isFlashingLightOpen();
                bAM();
            } else {
                this.fSm.setEnabled(false);
                this.fSm.setVisibility(4);
            }
        }
        if (this.fQL != null && this.fQL.bAV() && TextUtils.isEmpty(this.fQL.bBb())) {
            this.fQL.bBa();
        }
    }

    public void onRefresh() {
        if (this.fSr.getVisibility() == 0) {
            o.g("", 0L);
        }
    }

    public void kp(boolean z) {
        this.fQK.setClickable(z);
    }

    public void release() {
        this.fSQ = true;
        if (this.aXW != null) {
            this.aXW.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.fKO);
        MessageManager.getInstance().unRegisterListener(this.fKP);
        MessageManager.getInstance().unRegisterListener(this.fSX);
        MessageManager.getInstance().unRegisterListener(this.fKB);
        if (this.fSK != null) {
            this.fSK.release();
        }
        if (this.fwb != null) {
            this.fwb.release();
            this.fwb = null;
        }
    }

    private void bAQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bAR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAS() {
        this.fSs.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.fSs.getLocationOnScreen(iArr);
                c.this.fSy.measure(0, 0);
                int width = (iArr[0] + (c.this.fSs.getWidth() / 2)) - (c.this.fSA.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.fSs.getHeight() / 2)) + (c.this.fSA.getMeasuredHeight() / 2)) - c.this.fSy.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.fSv.getLocationOnScreen(iArr2);
                c.this.fSy.setY(height - iArr2[1]);
                c.this.fSz.setX(width);
                int[] iArr3 = new int[2];
                c.this.fQK.getLocationOnScreen(iArr3);
                c.this.fSx.setY(iArr3[1] - iArr2[1]);
                c.this.fSw.setVisibility(0);
                com.baidu.live.c.tH().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAT() {
        if (this.fSO != null && this.fSL != null && this.fSL.size() > 0) {
            String str = this.fSL.get(this.fSO.nextInt(100) % this.fSL.size());
            if (!TextUtils.isEmpty(str)) {
                this.fQF.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
