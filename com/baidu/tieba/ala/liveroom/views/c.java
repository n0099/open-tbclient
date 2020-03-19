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
    private HttpMessageListener fgB;
    private HttpMessageListener fgC;
    private CustomMessageListener fgq;
    private e.a fnS;
    private LinearLayout fnT;
    private ImageView fnU;
    private ImageView fnV;
    private ImageView fnW;
    private View fnX;
    private ImageView fnY;
    private TextView fnZ;
    private View.OnClickListener foA;
    private HttpMessageListener foB;
    private View foa;
    private ImageView fob;
    private TextView foc;
    private TextView fod;
    private Space foe;
    private FrameLayout fof;
    private Button fog;
    private LinearLayout foh;
    private LinearLayout foi;
    private ImageView foj;
    private RoundRectRelativeLayout fok;
    private TbImageView fol;
    private TextView fom;
    private boolean fon;
    private String foo;
    private boolean fop;
    private String foq;

    /* renamed from: for  reason: not valid java name */
    private boolean f2for;
    private ImageView fos;
    private com.baidu.tieba.ala.liveroom.share.d fot;
    private List<String> fou;
    private String fov;
    private String fow;
    private Random fox;
    protected View foy;
    private View.OnClickListener foz;
    private Handler handler;
    private RecorderCallback mRecorderCallback;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fon = false;
        this.fop = false;
        this.f2for = false;
        this.handler = new Handler();
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bqU();
                c.this.f2for = z;
                c.this.brj();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bqU();
                if (z) {
                    c.this.fnV.setEnabled(false);
                    c.this.fnV.setVisibility(4);
                    c.this.f2for = false;
                    c.this.brj();
                    return;
                }
                c.this.fnV.setEnabled(true);
                c.this.fnV.setVisibility(0);
                if (c.this.fmi.isFlashingLightOpen()) {
                    c.this.f2for = true;
                    c.this.brj();
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
                boolean isBackCamera = c.this.fmi.isBackCamera();
                if (!isBackCamera) {
                    c.this.fnV.setEnabled(false);
                    c.this.fnV.setVisibility(4);
                } else {
                    c.this.fnV.setEnabled(true);
                    c.this.fnV.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.f2for = c.this.fmi.isFlashingLightOpen();
                    c.this.brj();
                }
                if (c.this.fmi.hasBeauty() >= 0) {
                    c.this.fmi.setBeauty(com.baidu.live.c.pw().getInt("live_beauty_level", 3));
                }
                c.this.brk();
                if (!z && c.this.fnS != null) {
                    c.this.fnS.boG();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.fon) {
                    c.this.brl();
                    c.this.fon = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.fnS != null) {
                    c.this.fnS.boH();
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
        this.foz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fmi != null) {
                    c.this.fmi.switchFlashingLight();
                    c.this.f2for = c.this.fmi.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.brj();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.foA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bqU();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.fms != null) {
                                c.this.fms.boI();
                                return;
                            }
                            return;
                        }
                        c.this.bqS();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.fon = true;
                    c.this.fmi.stopRecord();
                    if (TextUtils.isEmpty(c.this.foq)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.fmi != null) {
                        c.this.fmi.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (c.this.fms != null) {
                        c.this.fms.boK();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.foy != null && c.this.mRootView.indexOfChild(c.this.foy) >= 0) {
                                c.this.mRootView.removeView(c.this.foy);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.fms != null) {
                        c.this.fms.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (c.this.fms != null) {
                        c.this.fms.boN();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.brq();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.fgB = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).fhD) {
                        ap apVar = com.baidu.live.v.a.zs().axR;
                        if (apVar == null || apVar.adh == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(apVar.adh.aeR);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        c.this.foa.setVisibility(0);
                        if (!com.baidu.live.c.pw().getBoolean("has_show_goods_auth_guide", false)) {
                            c.this.brp();
                        }
                        o.g("", 0L);
                        return;
                    }
                    c.this.foa.setVisibility(8);
                }
            }
        };
        this.fgC = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        c.this.fod.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        c.this.fod.setVisibility(0);
                        return;
                    }
                    c.this.fod.setVisibility(8);
                }
            }
        };
        this.foB = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.fhH != null && livePrepareListHttpResponseMessage.fhH.size() > 0) {
                        c.this.fou = new ArrayList(livePrepareListHttpResponseMessage.fhH);
                        c.this.brq();
                    } else {
                        c.this.fou = new ArrayList();
                    }
                    c.this.fov = livePrepareListHttpResponseMessage.fhF;
                    c.this.fow = livePrepareListHttpResponseMessage.fhG;
                }
            }
        };
        this.fgq = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.VS != null && data.VS.VX == 1) {
                    c.this.y(data.VS.mText, 1000L);
                }
            }
        };
        initViews();
        bro();
        brn();
        MessageManager.getInstance().registerListener(this.fgB);
        MessageManager.getInstance().registerListener(this.fgC);
        MessageManager.getInstance().registerListener(this.foB);
        MessageManager.getInstance().registerListener(this.fgq);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fox = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fot = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fot.g(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fot.bA(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fot = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fot != null) {
            this.fot.a(iShareCallback);
        }
    }

    private void initViews() {
        this.foo = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bqT();
                c.this.bqU();
                return false;
            }
        });
        bqN();
        this.fmo.setOnClickListener(this.foA);
        this.fnT = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fok = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fol = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fom = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fol.setIsRound(false);
        this.fol.setGifIconSupport(false);
        String bqR = bqR();
        this.fom.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bqR)) {
            this.fol.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fol, bqR, true, false);
            this.fom.setText(a.i.ala_live_change_cover);
            this.foq = bqR;
        }
        this.fmo.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fnU = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fnU.setOnClickListener(this.foA);
        this.fnW = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fnW.setOnClickListener(this.foA);
        this.fnV = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fnX = this.mRootView.findViewById(a.g.beauty_layout);
        this.fnY = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fnZ = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fnY.setOnClickListener(this.foA);
        this.fnZ.setOnClickListener(this.foA);
        this.foa = this.mRootView.findViewById(a.g.goods_layout);
        this.fob = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.foc = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fod = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fob.setOnClickListener(this.foA);
        this.foc.setOnClickListener(this.foA);
        this.fod.setOnClickListener(this.foA);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fnT.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fnT.setLayoutParams(layoutParams);
        }
        this.foe = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fof = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fog = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.foh = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.foi = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.foj = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fos = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fos.setOnClickListener(this.foA);
        sk();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
    }

    public void zy(String str) {
        com.baidu.live.c.pw().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void sk() {
        this.fok.setOnClickListener(this.foA);
        this.fnV.setOnClickListener(this.foz);
        this.fog.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fof.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bqU() {
        if (this.fms != null) {
            this.fms.boL();
        }
    }

    public void blQ() {
        bqS();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bqV() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bqW() {
        return false;
    }

    public boolean blO() {
        if (this.fot != null) {
            this.fot.bqB();
        }
        return this.fot != null && this.fot.blO();
    }

    public void blP() {
        if (this.fot != null) {
            this.fot.v(this.foq, getLiveTitle(), this.fov, this.fow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brj() {
        if (this.f2for) {
            this.fnV.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fnV.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, long j) {
        if (this.foy == null) {
            this.foy = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.foy.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.foy != null) {
                            int[] iArr = new int[2];
                            c.this.fnX.getLocationOnScreen(iArr);
                            c.this.foy.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int measuredHeight = iArr[1] - c.this.foy.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = (i - c.this.foy.getMeasuredWidth()) / 2;
                            layoutParams.rightMargin = (i - c.this.foy.getMeasuredWidth()) / 2;
                            layoutParams.topMargin = measuredHeight;
                            c.this.mRootView.addView(c.this.foy, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mRootView != null && c.this.foy != null && c.this.mRootView.indexOfChild(c.this.foy) >= 0) {
                            c.this.mRootView.removeView(c.this.foy);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brk() {
        if (an.c(com.baidu.live.v.a.zs().axR)) {
            this.fnX.setVisibility(0);
            if (an.c(com.baidu.live.v.a.zs().axR)) {
                this.fnY.setAlpha(0.2f);
                this.fnZ.setAlpha(0.2f);
            }
        } else if (this.fmi != null && this.fmi.hasBeauty() < 0) {
            this.fnX.setVisibility(8);
        } else {
            this.fnX.setVisibility(0);
        }
    }

    public boolean blK() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brl() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void yW(String str) {
        this.fop = true;
        this.foq = str;
        this.fom.setText(a.i.ala_live_change_cover);
        zy(str);
        k.a(this.fol, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String blN() {
        return bqR();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        brm();
        brk();
    }

    public void blH() {
        this.fmi.setVideoConfig(LiveRecorderConfigHelper.zn().d(2, 1, false));
    }

    private void brm() {
        if (this.fmi != null) {
            brk();
            if (this.fmi.isBackCamera()) {
                this.fnV.setEnabled(true);
                this.fnV.setVisibility(0);
                this.f2for = this.fmi.isFlashingLightOpen();
            } else {
                this.fnV.setEnabled(false);
                this.fnV.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fmi != null) {
                        c.this.fmi.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bqU();
        if (this.fot != null && z) {
            this.fot.bqA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int blS() {
        return 1;
    }

    public void a(e.a aVar) {
        this.fnS = aVar;
    }

    public void onResume() {
        this.fon = false;
        if (this.fmi != null) {
            if (this.fmi.isBackCamera()) {
                this.fnV.setEnabled(true);
                this.fnV.setVisibility(0);
                this.f2for = this.fmi.isFlashingLightOpen();
                brj();
            } else {
                this.fnV.setEnabled(false);
                this.fnV.setVisibility(4);
            }
        }
        if (this.fmp != null && this.fmp.brs() && TextUtils.isEmpty(this.fmp.bry())) {
            this.fmp.brx();
        }
    }

    public void onRefresh() {
        if (this.foa.getVisibility() == 0) {
            o.g("", 0L);
        }
    }

    public void jo(boolean z) {
        this.fmo.setClickable(z);
    }

    public void release() {
        if (this.fmi != null) {
            this.fmi.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.fgB);
        MessageManager.getInstance().unRegisterListener(this.fgC);
        MessageManager.getInstance().unRegisterListener(this.foB);
        MessageManager.getInstance().unRegisterListener(this.fgq);
        if (this.fot != null) {
            this.fot.release();
        }
    }

    private void brn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bro() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brp() {
        this.fob.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                c.this.fob.getLocationOnScreen(iArr);
                c.this.foh.measure(0, 0);
                int width = (iArr[0] + (c.this.fob.getWidth() / 2)) - (c.this.foj.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (c.this.fob.getHeight() / 2)) + (c.this.foj.getMeasuredHeight() / 2)) - c.this.foh.getMeasuredHeight();
                int[] iArr2 = new int[2];
                c.this.foe.getLocationOnScreen(iArr2);
                c.this.foh.setY(height - iArr2[1]);
                c.this.foi.setX(width);
                int[] iArr3 = new int[2];
                c.this.fmo.getLocationOnScreen(iArr3);
                c.this.fog.setY(iArr3[1] - iArr2[1]);
                c.this.fof.setVisibility(0);
                com.baidu.live.c.pw().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brq() {
        if (this.fox != null && this.fou != null && this.fou.size() > 0) {
            String str = this.fou.get(this.fox.nextInt(100) % this.fou.size());
            if (!TextUtils.isEmpty(str)) {
                this.fmj.setText(str);
            }
        }
    }
}
