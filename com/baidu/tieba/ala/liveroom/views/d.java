package com.baidu.tieba.ala.liveroom.views;

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
import android.widget.TextView;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.ala.liveRecorder.RecorderCallback;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.af;
import com.baidu.live.k.a;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
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
import com.baidu.live.utils.j;
import com.baidu.live.utils.m;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.LivePrepareListHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class d extends a {
    private HttpMessageListener ekx;
    private HttpMessageListener eky;
    private ImageView erA;
    private ImageView erB;
    private ImageView erC;
    private View erD;
    private ImageView erE;
    private TextView erF;
    private View erG;
    private ImageView erH;
    private TextView erI;
    private TextView erJ;
    private Space erK;
    private FrameLayout erL;
    private Button erM;
    private LinearLayout erN;
    private LinearLayout erO;
    private ImageView erP;
    private RoundRectRelativeLayout erQ;
    private TbImageView erR;
    private TextView erS;
    private boolean erT;
    private String erU;
    private boolean erV;
    private String erW;
    private boolean erX;
    private ImageView erY;
    private com.baidu.tieba.ala.liveroom.share.d erZ;
    private f.a ery;
    private LinearLayout erz;
    private List<String> esa;
    private String esb;
    private String esc;
    private Random esd;
    private View.OnClickListener ese;
    private View.OnClickListener esf;
    private HttpMessageListener esg;
    private RecorderCallback mRecorderCallback;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.erT = false;
        this.erV = false;
        this.erX = false;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.d.1
            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                d.this.aWt();
                d.this.erX = z;
                d.this.aWJ();
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                d.this.aWt();
                if (z) {
                    d.this.erB.setEnabled(false);
                    d.this.erB.setVisibility(4);
                    d.this.erX = false;
                    d.this.aWJ();
                    return;
                }
                d.this.erB.setEnabled(true);
                d.this.erB.setVisibility(0);
                if (d.this.epE.isFlashingLightOpen()) {
                    d.this.erX = true;
                    d.this.aWJ();
                }
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void streamLostPackageRateReceived(double d) {
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onVideoCollectionStart(boolean z, int i, int i2) {
                boolean isBackCamera = d.this.epE.isBackCamera();
                if (!isBackCamera) {
                    d.this.erB.setEnabled(false);
                    d.this.erB.setVisibility(4);
                } else {
                    d.this.erB.setEnabled(true);
                    d.this.erB.setVisibility(0);
                }
                if (isBackCamera) {
                    d.this.erX = d.this.epE.isFlashingLightOpen();
                    d.this.aWJ();
                }
                if (d.this.epE.hasBeauty() >= 0) {
                    d.this.epE.setBeauty(com.baidu.live.c.np().getInt("live_beauty_level", 3));
                }
                d.this.aWK();
                if (!z && d.this.ery != null) {
                    d.this.ery.aUb();
                }
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (d.this.erT) {
                    d.this.aWL();
                    d.this.erT = false;
                }
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && d.this.ery != null) {
                    d.this.ery.aUc();
                }
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onError(int i, String str) {
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onRtcConnected(int i) {
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onPKPlayerFirstFrame() {
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onFaceUnityEvent(int i, int i2, Object obj) {
            }
        };
        this.ese = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.epE != null) {
                    d.this.epE.switchFlashingLight();
                    d.this.erX = d.this.epE.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                d.this.aWJ();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.esf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aWt();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                            if (d.this.epO != null) {
                                d.this.epO.aUd();
                                return;
                            }
                            return;
                        }
                        d.this.aWr();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    d.this.erT = true;
                    d.this.epE.stopRecord();
                    if (TextUtils.isEmpty(d.this.erW)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (d.this.epE != null) {
                        d.this.epE.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (d.this.epO != null) {
                        d.this.epO.aUf();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (d.this.epO != null) {
                        d.this.epO.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (d.this.epO != null) {
                        d.this.epO.aUi();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    d.this.aWQ();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.ekx = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).els) {
                        af afVar = com.baidu.live.l.a.uA().akM;
                        if (afVar == null || afVar.Ui == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(afVar.Ui.Vr);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        d.this.erG.setVisibility(0);
                        if (!com.baidu.live.c.np().getBoolean("has_show_goods_auth_guide", false)) {
                            d.this.aWP();
                        }
                        m.i("", 0L);
                        return;
                    }
                    d.this.erG.setVisibility(8);
                }
            }
        };
        this.eky = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        d.this.erJ.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        d.this.erJ.setVisibility(0);
                        return;
                    }
                    d.this.erJ.setVisibility(8);
                }
            }
        };
        this.esg = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.elw != null && livePrepareListHttpResponseMessage.elw.size() > 0) {
                        d.this.esa = new ArrayList(livePrepareListHttpResponseMessage.elw);
                        d.this.aWQ();
                    } else {
                        d.this.esa = new ArrayList();
                    }
                    d.this.esb = livePrepareListHttpResponseMessage.elu;
                    d.this.esc = livePrepareListHttpResponseMessage.elv;
                }
            }
        };
        initViews();
        aWO();
        aWN();
        MessageManager.getInstance().registerListener(this.ekx);
        MessageManager.getInstance().registerListener(this.eky);
        MessageManager.getInstance().registerListener(this.esg);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.esd = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.erZ = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.erZ.aj(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.erZ.by(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.erZ = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.erZ != null) {
            this.erZ.a(iShareCallback);
        }
    }

    private void initViews() {
        this.erU = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aWs();
                d.this.aWt();
                return false;
            }
        });
        aWm();
        this.epK.setOnClickListener(this.esf);
        this.erz = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.erQ = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.erR = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.erS = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.erR.setIsRound(false);
        this.erR.setGifIconSupport(false);
        String aWq = aWq();
        this.erS.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(aWq)) {
            this.erR.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            j.a(this.erR, aWq, true, false);
            this.erS.setText(a.i.ala_live_change_cover);
            this.erW = aWq;
        }
        this.epK.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.erA = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.erA.setOnClickListener(this.esf);
        this.erC = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.erC.setOnClickListener(this.esf);
        this.erB = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.erD = this.mRootView.findViewById(a.g.beauty_layout);
        this.erE = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.erF = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.erE.setOnClickListener(this.esf);
        this.erF.setOnClickListener(this.esf);
        this.erG = this.mRootView.findViewById(a.g.goods_layout);
        this.erH = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.erI = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.erJ = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.erH.setOnClickListener(this.esf);
        this.erI.setOnClickListener(this.esf);
        this.erJ.setOnClickListener(this.esf);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erz.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.erz.setLayoutParams(layoutParams);
        }
        this.erK = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.erL = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.erM = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.erN = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.erO = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.erP = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.erY = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.erY.setOnClickListener(this.esf);
        pv();
        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
        alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
    }

    public void ue(String str) {
        com.baidu.live.c.np().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void pv() {
        this.erQ.setOnClickListener(this.esf);
        this.erB.setOnClickListener(this.ese);
        this.erM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.erL.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void aWt() {
        if (this.epO != null) {
            this.epO.aUg();
        }
    }

    public void aRJ() {
        aWr();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int aWu() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean aWv() {
        return false;
    }

    public boolean aRH() {
        if (this.erZ != null) {
            this.erZ.aWa();
        }
        return this.erZ != null && this.erZ.aRH();
    }

    public void aRI() {
        if (this.erZ != null) {
            this.erZ.q(this.erW, getLiveTitle(), this.esb, this.esc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWJ() {
        if (this.erX) {
            this.erB.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.erB.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWK() {
        if (this.epE.hasBeauty() < 0) {
            this.erD.setVisibility(8);
        } else {
            this.erD.setVisibility(0);
        }
    }

    public boolean aRD() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWL() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void tH(String str) {
        this.erV = true;
        this.erW = str;
        this.erS.setText(a.i.ala_live_change_cover);
        ue(str);
        j.a(this.erR, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String aRG() {
        return aWq();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        aWM();
        if (this.epE != null && this.epE.hasBeauty() >= 0) {
            this.erD.setVisibility(0);
        } else {
            this.erD.setVisibility(8);
        }
    }

    public void aRA() {
        this.epE.setVideoConfig(AlaLiveRecordConfigHelper.aRw().i(2, 1, false));
    }

    private void aWM() {
        if (this.epE != null) {
            if (this.epE.hasBeauty() >= 0) {
                this.erD.setVisibility(0);
            } else {
                this.erD.setVisibility(8);
            }
            if (this.epE.isBackCamera()) {
                this.erB.setEnabled(true);
                this.erB.setVisibility(0);
                this.erX = this.epE.isFlashingLightOpen();
            } else {
                this.erB.setEnabled(false);
                this.erB.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.epE != null) {
                        d.this.epE.addRecorderCallback(d.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        aWt();
        if (this.erZ != null && z) {
            this.erZ.aVZ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int aRL() {
        return 1;
    }

    public void a(f.a aVar) {
        this.ery = aVar;
    }

    public void onResume() {
        this.erT = false;
        if (this.epE != null) {
            if (this.epE.isBackCamera()) {
                this.erB.setEnabled(true);
                this.erB.setVisibility(0);
                this.erX = this.epE.isFlashingLightOpen();
                aWJ();
            } else {
                this.erB.setEnabled(false);
                this.erB.setVisibility(4);
            }
        }
        if (this.epL != null && this.epL.aWR() && TextUtils.isEmpty(this.epL.aWX())) {
            this.epL.aWW();
        }
    }

    public void onRefresh() {
        if (this.erG.getVisibility() == 0) {
            m.i("", 0L);
        }
    }

    public void hL(boolean z) {
        this.epK.setClickable(z);
    }

    public void release() {
        if (this.epE != null) {
            this.epE.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.ekx);
        MessageManager.getInstance().unRegisterListener(this.eky);
        MessageManager.getInstance().unRegisterListener(this.esg);
        if (this.erZ != null) {
            this.erZ.release();
        }
    }

    private void aWN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aWO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWP() {
        this.erH.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.8
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                d.this.erH.getLocationOnScreen(iArr);
                d.this.erN.measure(0, 0);
                int width = (iArr[0] + (d.this.erH.getWidth() / 2)) - (d.this.erP.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (d.this.erH.getHeight() / 2)) + (d.this.erP.getMeasuredHeight() / 2)) - d.this.erN.getMeasuredHeight();
                int[] iArr2 = new int[2];
                d.this.erK.getLocationOnScreen(iArr2);
                d.this.erN.setY(height - iArr2[1]);
                d.this.erO.setX(width);
                int[] iArr3 = new int[2];
                d.this.epK.getLocationOnScreen(iArr3);
                d.this.erM.setY(iArr3[1] - iArr2[1]);
                d.this.erL.setVisibility(0);
                com.baidu.live.c.np().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWQ() {
        if (this.esd != null && this.esa != null && this.esa.size() > 0) {
            String str = this.esa.get(this.esd.nextInt(100) % this.esa.size());
            if (!TextUtils.isEmpty(str)) {
                this.epF.setText(str);
            }
        }
    }
}
