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
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.ak;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.q.a;
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
import com.baidu.live.utils.n;
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
    private HttpMessageListener eZT;
    private HttpMessageListener eZU;
    private f.a fgZ;
    private com.baidu.tieba.ala.liveroom.share.d fhA;
    private List<String> fhB;
    private String fhC;
    private String fhD;
    private Random fhE;
    private View.OnClickListener fhF;
    private View.OnClickListener fhG;
    private HttpMessageListener fhH;
    private LinearLayout fha;
    private ImageView fhb;
    private ImageView fhc;
    private ImageView fhd;
    private View fhe;
    private ImageView fhf;
    private TextView fhg;
    private View fhh;
    private ImageView fhi;
    private TextView fhj;
    private TextView fhk;
    private Space fhl;
    private FrameLayout fhm;
    private Button fhn;
    private LinearLayout fho;
    private LinearLayout fhp;
    private ImageView fhq;
    private RoundRectRelativeLayout fhr;
    private TbImageView fhs;
    private TextView fht;
    private boolean fhu;
    private String fhv;
    private boolean fhw;
    private String fhx;
    private boolean fhy;
    private ImageView fhz;
    private RecorderCallback mRecorderCallback;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fhu = false;
        this.fhw = false;
        this.fhy = false;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.d.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                d.this.bof();
                d.this.fhy = z;
                d.this.bov();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                d.this.bof();
                if (z) {
                    d.this.fhc.setEnabled(false);
                    d.this.fhc.setVisibility(4);
                    d.this.fhy = false;
                    d.this.bov();
                    return;
                }
                d.this.fhc.setEnabled(true);
                d.this.fhc.setVisibility(0);
                if (d.this.ffh.isFlashingLightOpen()) {
                    d.this.fhy = true;
                    d.this.bov();
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
                boolean isBackCamera = d.this.ffh.isBackCamera();
                if (!isBackCamera) {
                    d.this.fhc.setEnabled(false);
                    d.this.fhc.setVisibility(4);
                } else {
                    d.this.fhc.setEnabled(true);
                    d.this.fhc.setVisibility(0);
                }
                if (isBackCamera) {
                    d.this.fhy = d.this.ffh.isFlashingLightOpen();
                    d.this.bov();
                }
                if (d.this.ffh.hasBeauty() >= 0) {
                    d.this.ffh.setBeauty(com.baidu.live.c.oI().getInt("live_beauty_level", 3));
                }
                d.this.bow();
                if (!z && d.this.fgZ != null) {
                    d.this.fgZ.blQ();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (d.this.fhu) {
                    d.this.box();
                    d.this.fhu = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && d.this.fgZ != null) {
                    d.this.fgZ.blR();
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
        this.fhF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ffh != null) {
                    d.this.ffh.switchFlashingLight();
                    d.this.fhy = d.this.ffh.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                d.this.bov();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.fhG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bof();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) {
                            if (d.this.ffr != null) {
                                d.this.ffr.blS();
                                return;
                            }
                            return;
                        }
                        d.this.bod();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    d.this.fhu = true;
                    d.this.ffh.stopRecord();
                    if (TextUtils.isEmpty(d.this.fhx)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (d.this.ffh != null) {
                        d.this.ffh.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    if (d.this.ffr != null) {
                        d.this.ffr.blU();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (d.this.ffr != null) {
                        d.this.ffr.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.goods_imageView || view.getId() == a.g.goods_textView || view.getId() == a.g.goods_num_textView) {
                    if (d.this.ffr != null) {
                        d.this.ffr.blX();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    d.this.boC();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                }
            }
        };
        this.eZT = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.views.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                    if (((HasGoodsAuthResponseMessage) httpResponsedMessage).faS) {
                        ak akVar = com.baidu.live.r.a.wA().asy;
                        if (akVar == null || akVar.aaL == null) {
                            z = false;
                        } else {
                            z = !TextUtils.isEmpty(akVar.aaL.acs);
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        d.this.fhh.setVisibility(0);
                        if (!com.baidu.live.c.oI().getBoolean("has_show_goods_auth_guide", false)) {
                            d.this.boB();
                        }
                        n.g("", 0L);
                        return;
                    }
                    d.this.fhh.setVisibility(8);
                }
            }
        };
        this.eZU = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.views.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.count > 0) {
                        d.this.fhk.setText(getVideoGoodsListHttpResponseMessage.count + "");
                        d.this.fhk.setVisibility(0);
                        return;
                    }
                    d.this.fhk.setVisibility(8);
                }
            }
        };
        this.fhH = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.faW != null && livePrepareListHttpResponseMessage.faW.size() > 0) {
                        d.this.fhB = new ArrayList(livePrepareListHttpResponseMessage.faW);
                        d.this.boC();
                    } else {
                        d.this.fhB = new ArrayList();
                    }
                    d.this.fhC = livePrepareListHttpResponseMessage.faU;
                    d.this.fhD = livePrepareListHttpResponseMessage.faV;
                }
            }
        };
        initViews();
        boA();
        boz();
        MessageManager.getInstance().registerListener(this.eZT);
        MessageManager.getInstance().registerListener(this.eZU);
        MessageManager.getInstance().registerListener(this.fhH);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        this.fhE = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.fhA = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.fhA.ai(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.fhA.bv(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.fhA = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fhA != null) {
            this.fhA.a(iShareCallback);
        }
    }

    private void initViews() {
        this.fhv = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.boe();
                d.this.bof();
                return false;
            }
        });
        bnY();
        this.ffn.setOnClickListener(this.fhG);
        this.fha = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.fhr = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.fhs = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.fht = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.fhs.setIsRound(false);
        this.fhs.setGifIconSupport(false);
        String boc = boc();
        this.fht.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(boc)) {
            this.fhs.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.fhs, boc, true, false);
            this.fht.setText(a.i.ala_live_change_cover);
            this.fhx = boc;
        }
        this.ffn.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.fhb = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.fhb.setOnClickListener(this.fhG);
        this.fhd = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.fhd.setOnClickListener(this.fhG);
        this.fhc = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.fhe = this.mRootView.findViewById(a.g.beauty_layout);
        this.fhf = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.fhg = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.fhf.setOnClickListener(this.fhG);
        this.fhg.setOnClickListener(this.fhG);
        this.fhh = this.mRootView.findViewById(a.g.goods_layout);
        this.fhi = (ImageView) this.mRootView.findViewById(a.g.goods_imageView);
        this.fhj = (TextView) this.mRootView.findViewById(a.g.goods_textView);
        this.fhk = (TextView) this.mRootView.findViewById(a.g.goods_num_textView);
        this.fhi.setOnClickListener(this.fhG);
        this.fhj.setOnClickListener(this.fhG);
        this.fhk.setOnClickListener(this.fhG);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fha.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.fha.setLayoutParams(layoutParams);
        }
        this.fhl = (Space) this.mRootView.findViewById(a.g.anchorSpace);
        this.fhm = (FrameLayout) this.mRootView.findViewById(a.g.goodsAuthGuide_layout);
        this.fhn = (Button) this.mRootView.findViewById(a.g.goodsAuthGuideKnown_button);
        this.fho = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideContent_layout);
        this.fhp = (LinearLayout) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_layout);
        this.fhq = (ImageView) this.mRootView.findViewById(a.g.goodsAuthGuideShopping_imageView);
        this.fhz = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.fhz.setOnClickListener(this.fhG);
        qS();
        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
        alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
    }

    public void yV(String str) {
        com.baidu.live.c.oI().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void qS() {
        this.fhr.setOnClickListener(this.fhG);
        this.fhc.setOnClickListener(this.fhF);
        this.fhn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fhm.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bof() {
        if (this.ffr != null) {
            this.ffr.blV();
        }
    }

    public void bji() {
        bod();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bog() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean boh() {
        return false;
    }

    public boolean bjg() {
        if (this.fhA != null) {
            this.fhA.bnN();
        }
        return this.fhA != null && this.fhA.bjg();
    }

    public void bjh() {
        if (this.fhA != null) {
            this.fhA.s(this.fhx, getLiveTitle(), this.fhC, this.fhD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bov() {
        if (this.fhy) {
            this.fhc.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.fhc.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bow() {
        if (this.ffh.hasBeauty() < 0) {
            this.fhe.setVisibility(8);
        } else {
            this.fhe.setVisibility(0);
        }
    }

    public boolean bjc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void box() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void yw(String str) {
        this.fhw = true;
        this.fhx = str;
        this.fht.setText(a.i.ala_live_change_cover);
        yV(str);
        k.a(this.fhs, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bjf() {
        return boc();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        boy();
        if (this.ffh != null && this.ffh.hasBeauty() >= 0) {
            this.fhe.setVisibility(0);
        } else {
            this.fhe.setVisibility(8);
        }
    }

    public void biZ() {
        this.ffh.setVideoConfig(AlaLiveRecordConfigHelper.biV().k(2, 1, false));
    }

    private void boy() {
        if (this.ffh != null) {
            if (this.ffh.hasBeauty() >= 0) {
                this.fhe.setVisibility(0);
            } else {
                this.fhe.setVisibility(8);
            }
            if (this.ffh.isBackCamera()) {
                this.fhc.setEnabled(true);
                this.fhc.setVisibility(0);
                this.fhy = this.ffh.isFlashingLightOpen();
            } else {
                this.fhc.setEnabled(false);
                this.fhc.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ffh != null) {
                        d.this.ffh.addRecorderCallback(d.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bof();
        if (this.fhA != null && z) {
            this.fhA.bnM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bjk() {
        return 1;
    }

    public void a(f.a aVar) {
        this.fgZ = aVar;
    }

    public void onResume() {
        this.fhu = false;
        if (this.ffh != null) {
            if (this.ffh.isBackCamera()) {
                this.fhc.setEnabled(true);
                this.fhc.setVisibility(0);
                this.fhy = this.ffh.isFlashingLightOpen();
                bov();
            } else {
                this.fhc.setEnabled(false);
                this.fhc.setVisibility(4);
            }
        }
        if (this.ffo != null && this.ffo.boD() && TextUtils.isEmpty(this.ffo.boJ())) {
            this.ffo.boI();
        }
    }

    public void onRefresh() {
        if (this.fhh.getVisibility() == 0) {
            n.g("", 0L);
        }
    }

    public void ja(boolean z) {
        this.ffn.setClickable(z);
    }

    public void release() {
        if (this.ffh != null) {
            this.ffh.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterTask(1021143);
        MessageManager.getInstance().unRegisterListener(this.eZT);
        MessageManager.getInstance().unRegisterListener(this.eZU);
        MessageManager.getInstance().unRegisterListener(this.fhH);
        if (this.fhA != null) {
            this.fhA.release();
        }
    }

    private void boz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void boA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boB() {
        this.fhi.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.8
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                d.this.fhi.getLocationOnScreen(iArr);
                d.this.fho.measure(0, 0);
                int width = (iArr[0] + (d.this.fhi.getWidth() / 2)) - (d.this.fhq.getMeasuredWidth() / 2);
                int height = ((iArr[1] + (d.this.fhi.getHeight() / 2)) + (d.this.fhq.getMeasuredHeight() / 2)) - d.this.fho.getMeasuredHeight();
                int[] iArr2 = new int[2];
                d.this.fhl.getLocationOnScreen(iArr2);
                d.this.fho.setY(height - iArr2[1]);
                d.this.fhp.setX(width);
                int[] iArr3 = new int[2];
                d.this.ffn.getLocationOnScreen(iArr3);
                d.this.fhn.setY(iArr3[1] - iArr2[1]);
                d.this.fhm.setVisibility(0);
                com.baidu.live.c.oI().putBoolean("has_show_goods_auth_guide", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boC() {
        if (this.fhE != null && this.fhB != null && this.fhB.size() > 0) {
            String str = this.fhB.get(this.fhE.nextInt(100) % this.fhB.size());
            if (!TextUtils.isEmpty(str)) {
                this.ffi.setText(str);
            }
        }
    }
}
