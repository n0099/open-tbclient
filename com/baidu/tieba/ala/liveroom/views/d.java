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
    private HttpMessageListener ejG;
    private HttpMessageListener ejH;
    private f.a eqG;
    private LinearLayout eqH;
    private ImageView eqI;
    private ImageView eqJ;
    private ImageView eqK;
    private View eqL;
    private ImageView eqM;
    private TextView eqN;
    private View eqO;
    private ImageView eqP;
    private TextView eqQ;
    private TextView eqR;
    private Space eqS;
    private FrameLayout eqT;
    private Button eqU;
    private LinearLayout eqV;
    private LinearLayout eqW;
    private ImageView eqX;
    private RoundRectRelativeLayout eqY;
    private TbImageView eqZ;
    private TextView era;
    private boolean erb;
    private String erc;
    private boolean erd;
    private String ere;
    private boolean erf;
    private ImageView erg;
    private com.baidu.tieba.ala.liveroom.share.d erh;
    private List<String> eri;
    private String erj;
    private String erk;
    private Random erl;
    private View.OnClickListener erm;
    private View.OnClickListener ern;
    private HttpMessageListener ero;
    private RecorderCallback mRecorderCallback;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.erb = false;
        this.erd = false;
        this.erf = false;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.d.1
            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                d.this.aWr();
                d.this.erf = z;
                d.this.aWH();
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                d.this.aWr();
                if (z) {
                    d.this.eqJ.setEnabled(false);
                    d.this.eqJ.setVisibility(4);
                    d.this.erf = false;
                    d.this.aWH();
                    return;
                }
                d.this.eqJ.setEnabled(true);
                d.this.eqJ.setVisibility(0);
                if (d.this.eoN.isFlashingLightOpen()) {
                    d.this.erf = true;
                    d.this.aWH();
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
                boolean isBackCamera = d.this.eoN.isBackCamera();
                if (!isBackCamera) {
                    d.this.eqJ.setEnabled(false);
                    d.this.eqJ.setVisibility(4);
                } else {
                    d.this.eqJ.setEnabled(true);
                    d.this.eqJ.setVisibility(0);
                }
                if (isBackCamera) {
                    d.this.erf = d.this.eoN.isFlashingLightOpen();
                    d.this.aWH();
                }
                if (d.this.eoN.hasBeauty() >= 0) {
                    d.this.eoN.setBeauty(com.baidu.live.c.np().getInt("live_beauty_level", 3));
                }
                d.this.aWI();
                if (!z && d.this.eqG != null) {
                    d.this.eqG.aTZ();
                }
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (d.this.erb) {
                    d.this.aWJ();
                    d.this.erb = false;
                }
            }

            @Override // com.baidu.ala.liveRecorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && d.this.eqG != null) {
                    d.this.eqG.aUa();
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
        this.erm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eoN != null) {
                    d.this.eoN.switchFlashingLight();
                    d.this.erf = d.this.eoN.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                d.this.aWH();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.ern = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aWr();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                            if (d.this.eoX != null) {
                                d.this.eoX.aUb();
                                return;
                            }
                            return;
                        }
                        d.this.aWp();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    d.this.erb = true;
                    d.this.eoN.stopRecord();
                    if (TextUtils.isEmpty(d.this.ere)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (d.this.eoN != null) {
                        d.this.eoN.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (d.this.eoX != null) {
                        d.this.eoX.aUd();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (d.this.eoX != null) {
                        d.this.eoX.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (d.this.eoX != null) {
                        d.this.eoX.aUg();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    d.this.aWO();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.ejG = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).ekB) {
                        af afVar = com.baidu.live.l.a.uB().aku;
                        if (afVar == null || afVar.TP == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(afVar.TP.UY);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        d.this.eqO.setVisibility(0);
                        if (!com.baidu.live.c.np().getBoolean("has_show_goods_auth_guide", false)) {
                            d.this.aWN();
                        }
                        m.i("", 0L);
                        return;
                    }
                    d.this.eqO.setVisibility(8);
                }
            }
        };
        this.ejH = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        d.this.eqR.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        d.this.eqR.setVisibility(0);
                        return;
                    }
                    d.this.eqR.setVisibility(8);
                }
            }
        };
        this.ero = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.ekF != null && livePrepareListHttpResponseMessage.ekF.size() > 0) {
                        d.this.eri = new ArrayList(livePrepareListHttpResponseMessage.ekF);
                        d.this.aWO();
                    } else {
                        d.this.eri = new ArrayList();
                    }
                    d.this.erj = livePrepareListHttpResponseMessage.ekD;
                    d.this.erk = livePrepareListHttpResponseMessage.ekE;
                }
            }
        };
        initViews();
        aWM();
        aWL();
        MessageManager.getInstance().registerListener(this.ejG);
        MessageManager.getInstance().registerListener(this.ejH);
        MessageManager.getInstance().registerListener(this.ero);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.erl = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.erh = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.erh.aj(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.erh.by(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.erh = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.erh != null) {
            this.erh.a(iShareCallback);
        }
    }

    private void initViews() {
        this.erc = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aWq();
                d.this.aWr();
                return false;
            }
        });
        aWk();
        this.eoT.setOnClickListener(this.ern);
        this.eqH = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.eqY = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.eqZ = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.era = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.eqZ.setIsRound(false);
        this.eqZ.setGifIconSupport(false);
        String aWo = aWo();
        this.era.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(aWo)) {
            this.eqZ.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            j.a(this.eqZ, aWo, true, false);
            this.era.setText(a.i.ala_live_change_cover);
            this.ere = aWo;
        }
        this.eoT.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.eqI = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.eqI.setOnClickListener(this.ern);
        this.eqK = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.eqK.setOnClickListener(this.ern);
        this.eqJ = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.eqL = this.mRootView.findViewById(a.g.beauty_layout);
        this.eqM = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.eqN = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.eqM.setOnClickListener(this.ern);
        this.eqN.setOnClickListener(this.ern);
        this.eqO = this.mRootView.findViewById(a.g.goods_layout);
        this.eqP = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.eqQ = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.eqR = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.eqP.setOnClickListener(this.ern);
        this.eqQ.setOnClickListener(this.ern);
        this.eqR.setOnClickListener(this.ern);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqH.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.eqH.setLayoutParams(layoutParams);
        }
        this.eqS = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.eqT = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.eqU = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.eqV = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.eqW = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.eqX = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.erg = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.erg.setOnClickListener(this.ern);
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
        this.eqY.setOnClickListener(this.ern);
        this.eqJ.setOnClickListener(this.erm);
        this.eqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eqT.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void aWr() {
        if (this.eoX != null) {
            this.eoX.aUe();
        }
    }

    public void aRH() {
        aWp();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int aWs() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean aWt() {
        return false;
    }

    public boolean aRF() {
        if (this.erh != null) {
            this.erh.aVY();
        }
        return this.erh != null && this.erh.aRF();
    }

    public void aRG() {
        if (this.erh != null) {
            this.erh.q(this.ere, getLiveTitle(), this.erj, this.erk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWH() {
        if (this.erf) {
            this.eqJ.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.eqJ.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWI() {
        if (this.eoN.hasBeauty() < 0) {
            this.eqL.setVisibility(8);
        } else {
            this.eqL.setVisibility(0);
        }
    }

    public boolean aRB() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWJ() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void tH(String str) {
        this.erd = true;
        this.ere = str;
        this.era.setText(a.i.ala_live_change_cover);
        ue(str);
        j.a(this.eqZ, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String aRE() {
        return aWo();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        aWK();
        if (this.eoN != null && this.eoN.hasBeauty() >= 0) {
            this.eqL.setVisibility(0);
        } else {
            this.eqL.setVisibility(8);
        }
    }

    public void aRy() {
        this.eoN.setVideoConfig(AlaLiveRecordConfigHelper.aRu().i(2, 1, false));
    }

    private void aWK() {
        if (this.eoN != null) {
            if (this.eoN.hasBeauty() >= 0) {
                this.eqL.setVisibility(0);
            } else {
                this.eqL.setVisibility(8);
            }
            if (this.eoN.isBackCamera()) {
                this.eqJ.setEnabled(true);
                this.eqJ.setVisibility(0);
                this.erf = this.eoN.isFlashingLightOpen();
            } else {
                this.eqJ.setEnabled(false);
                this.eqJ.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eoN != null) {
                        d.this.eoN.addRecorderCallback(d.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        aWr();
        if (this.erh != null && z) {
            this.erh.aVX();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int aRJ() {
        return 1;
    }

    public void a(f.a aVar) {
        this.eqG = aVar;
    }

    public void onResume() {
        this.erb = false;
        if (this.eoN != null) {
            if (this.eoN.isBackCamera()) {
                this.eqJ.setEnabled(true);
                this.eqJ.setVisibility(0);
                this.erf = this.eoN.isFlashingLightOpen();
                aWH();
            } else {
                this.eqJ.setEnabled(false);
                this.eqJ.setVisibility(4);
            }
        }
        if (this.eoU != null && this.eoU.aWP() && TextUtils.isEmpty(this.eoU.aWV())) {
            this.eoU.aWU();
        }
    }

    public void onRefresh() {
        if (this.eqO.getVisibility() == 0) {
            m.i("", 0L);
        }
    }

    public void hL(boolean z) {
        this.eoT.setClickable(z);
    }

    public void release() {
        if (this.eoN != null) {
            this.eoN.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.ejG);
        MessageManager.getInstance().unRegisterListener(this.ejH);
        MessageManager.getInstance().unRegisterListener(this.ero);
        if (this.erh != null) {
            this.erh.release();
        }
    }

    private void aWL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aWM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWN() {
        this.eqP.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.8
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                d.this.eqP.getLocationOnScreen(iArr);
                d.this.eqV.measure(0, 0);
                int width = (iArr[0] + (d.this.eqP.getWidth() / 2)) - (d.this.eqX.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (d.this.eqP.getHeight() / 2)) + (d.this.eqX.getMeasuredHeight() / 2)) - d.this.eqV.getMeasuredHeight();
                int[] iArr2 = new int[2];
                d.this.eqS.getLocationOnScreen(iArr2);
                d.this.eqV.setY(height - iArr2[1]);
                d.this.eqW.setX(width);
                int[] iArr3 = new int[2];
                d.this.eoT.getLocationOnScreen(iArr3);
                d.this.eqU.setY(iArr3[1] - iArr2[1]);
                d.this.eqT.setVisibility(0);
                com.baidu.live.c.np().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWO() {
        if (this.erl != null && this.eri != null && this.eri.size() > 0) {
            String str = this.eri.get(this.erl.nextInt(100) % this.eri.size());
            if (!TextUtils.isEmpty(str)) {
                this.eoO.setText(str);
            }
        }
    }
}
