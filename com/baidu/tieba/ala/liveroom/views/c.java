package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigHttp;
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
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.data.aa;
import com.baidu.live.data.ba;
import com.baidu.live.data.h;
import com.baidu.live.data.l;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveCategoryActivityConfig;
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
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.messages.AlaGetAnchorCategoryResponseMessagge;
import com.baidu.tieba.ala.liveroom.messages.LivePrepareListHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public class c extends a {
    private int bdq;
    private Random gAa;
    private int gAb;
    private boolean gAc;
    protected View gAd;
    private CheckedTextView gAe;
    private h gAf;
    private boolean gAg;
    private RelativeLayout gAh;
    private TextView gAi;
    private FrameLayout gAj;
    private LinearLayout gAk;
    private View.OnClickListener gAl;
    private View.OnClickListener gAm;
    private HttpMessageListener gAn;
    private HttpMessageListener gAo;
    private CustomMessageListener gAp;
    private com.baidu.tieba.ala.liveroom.activeview.b gaq;
    private CustomMessageListener gqO;
    private com.baidu.tieba.ala.category.b.a grO;
    private e.a gzF;
    private LinearLayout gzG;
    private ImageView gzH;
    private ImageView gzI;
    private ImageView gzJ;
    private View gzK;
    private ImageView gzL;
    private TextView gzM;
    private RoundRectRelativeLayout gzN;
    private TbImageView gzO;
    private TextView gzP;
    private boolean gzQ;
    private String gzR;
    private boolean gzS;
    private String gzT;
    private boolean gzU;
    private ImageView gzV;
    private com.baidu.tieba.ala.liveroom.share.d gzW;
    private List<String> gzX;
    private String gzY;
    private String gzZ;
    private Handler handler;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gzQ = false;
        this.gzS = false;
        this.gzU = false;
        this.gAb = 0;
        this.gAc = false;
        this.handler = new Handler();
        this.bdq = 0;
        this.gAg = false;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bMW();
                c.this.gzU = z;
                c.this.bNq();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bMW();
                if (z) {
                    c.this.gzI.setEnabled(false);
                    c.this.gzI.setVisibility(4);
                    c.this.gzU = false;
                    c.this.bNq();
                    return;
                }
                c.this.gzI.setEnabled(true);
                c.this.gzI.setVisibility(0);
                if (c.this.bkZ.isFlashingLightOpen()) {
                    c.this.gzU = true;
                    c.this.bNq();
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
                boolean isBackCamera = c.this.bkZ.isBackCamera();
                if (!isBackCamera) {
                    c.this.gzI.setEnabled(false);
                    c.this.gzI.setVisibility(4);
                } else {
                    c.this.gzI.setEnabled(true);
                    c.this.gzI.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.gzU = c.this.bkZ.isFlashingLightOpen();
                    c.this.bNq();
                }
                if (c.this.bkZ.hasBeauty() >= 0) {
                    c.this.bkZ.setBeauty(com.baidu.live.c.vf().getInt("live_beauty_level", 3));
                }
                c.this.bNs();
                if (!z && c.this.gzF != null) {
                    c.this.gzF.bKp();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.gzQ) {
                    c.this.bNt();
                    c.this.gzQ = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.gzF != null) {
                    c.this.gzF.bKq();
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
        this.gAl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bkZ != null) {
                    c.this.bkZ.switchFlashingLight();
                    c.this.gzU = c.this.bkZ.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.bNq();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.gAm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bMW();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.gyj != null) {
                                c.this.gyj.bKr();
                                return;
                            }
                            return;
                        }
                        c.this.bMS();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.gzQ = true;
                    c.this.bkZ.stopRecord();
                    if (TextUtils.isEmpty(c.this.gzT)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.bkZ != null) {
                        c.this.bkZ.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    c.this.gAg = true;
                    com.baidu.live.c.vf().putInt("beauty_new_bubble", 0);
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                    if (c.this.gyj != null) {
                        c.this.gyj.bKt();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.gAd != null && c.this.mRootView.indexOfChild(c.this.gAd) >= 0) {
                                c.this.mRootView.removeView(c.this.gAd);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.gyj != null) {
                        c.this.gyj.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.bNy();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                    c.this.bNr();
                } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.grO), com.baidu.tieba.ala.category.b.a.b(c.this.grO))));
                }
            }
        };
        this.gAn = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.gsg != null && livePrepareListHttpResponseMessage.gsg.size() > 0) {
                        c.this.gzX = new ArrayList(livePrepareListHttpResponseMessage.gsg);
                        c.this.bNy();
                    } else {
                        c.this.gzX = new ArrayList();
                    }
                    c.this.gzY = livePrepareListHttpResponseMessage.gse;
                    c.this.gzZ = livePrepareListHttpResponseMessage.gsf;
                }
            }
        };
        this.gqO = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aux != null) {
                    if (data.aux.auG == 1) {
                        c.this.v(data.aux.mText, 1500L);
                    }
                    com.baidu.live.c.vf().putInt("beauty_new_bubble", data.aux.auG);
                    com.baidu.live.c.vf().putInt("beauty_subitem_redot", data.aux.auH);
                    com.baidu.live.c.vf().putInt("beauty_tab_redot", data.aux.auI);
                }
            }
        };
        this.gAo = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.grO = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).bKV();
                    }
                    c.this.bNx();
                }
            }
        };
        this.gAp = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.grO = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.bNx();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.bNx();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bNv();
        bNw();
        MessageManager.getInstance().registerListener(this.gAn);
        MessageManager.getInstance().registerListener(this.gqO);
        MessageManager.getInstance().registerListener(this.gAo);
        MessageManager.getInstance().registerListener(this.gAp);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.gAa = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.gzW = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.gzW.n(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.gzW.bO(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.gzW = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gzW != null) {
            this.gzW.a(iShareCallback);
        }
    }

    private void initViews() {
        this.gzR = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bMV();
                c.this.bMW();
                return false;
            }
        });
        bMN();
        this.gyf.setOnClickListener(this.gAm);
        this.gzG = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.gzN = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.gzO = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.gzP = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.gzO.setIsRound(false);
        this.gzO.setGifIconSupport(false);
        String bMR = bMR();
        this.gzP.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bMR)) {
            this.gzO.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.gzO, bMR, true, false);
            this.gzP.setText(a.i.ala_live_change_cover);
            this.gzT = bMR;
        }
        this.gyf.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.gzH = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.gzH.setOnClickListener(this.gAm);
        this.gzJ = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.gzJ.setOnClickListener(this.gAm);
        this.gzI = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.gAk = (LinearLayout) this.mRootView.findViewById(a.g.prepare_opt_layout);
        this.gzK = this.mRootView.findViewById(a.g.beauty_layout);
        this.gzL = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.gzM = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.gzL.setOnClickListener(this.gAm);
        this.gzM.setOnClickListener(this.gAm);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzG.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.gzG.setLayoutParams(layoutParams);
        }
        this.gAh = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.gAi = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.gAj = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.gAh.setOnClickListener(this.gAm);
        this.gzV = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.gzV.setOnClickListener(this.gAm);
        this.gAe = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.gAe.setOnClickListener(this.gAm);
        yV();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.gAc = true;
        bNo();
        bNp();
    }

    private l bNn() {
        if (com.baidu.live.v.a.Hs().aZn == null || com.baidu.live.v.a.Hs().aZn.aCa == null) {
            return null;
        }
        return com.baidu.live.v.a.Hs().aZn.aCa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNo() {
        l bNn = bNn();
        if (bNn != null && bNn.ayM != null && bNn.ayM.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.gAf = bNn.ayM.get(this.gAb % bNn.ayM.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.gAf.getText());
            this.gAh.setVisibility(0);
            this.gAi.setText(sb);
            this.gAb++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gAc) {
                        c.this.bNo();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.gAh.setVisibility(8);
    }

    private void bNp() {
        if (com.baidu.live.c.vf().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.gAh != null && this.gAh.getVisibility() == 0) {
            com.baidu.live.c.vf().putInt("live_assistant_guide_txt_show_counts", 1);
            this.gAj.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Eb(String str) {
        com.baidu.live.c.vf().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void yV() {
        this.gzN.setOnClickListener(this.gAm);
        this.gzI.setOnClickListener(this.gAl);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bMW() {
        if (this.gyj != null) {
            this.gyj.bKu();
        }
    }

    public void bHu() {
        bMS();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bMX() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bMY() {
        return false;
    }

    public boolean bHs() {
        if (this.gzW != null) {
            this.gzW.bMx();
        }
        return this.gzW != null && this.gzW.bHs();
    }

    public void bHt() {
        if (this.gzW != null) {
            this.gzW.w(this.gzT, getLiveTitle(), this.gzY, this.gzZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNq() {
        if (this.gzU) {
            this.gzI.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.gzI.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNr() {
        this.gAj.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.gaq == null) {
                this.gaq = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.gAf != null && !TextUtils.isEmpty(this.gAf.wX())) {
                this.gaq.Dr(this.gAf.wX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, long j) {
        if (this.gAd == null) {
            this.gAd = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.gAd.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (!c.this.gAg && c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.gAd != null) {
                            int[] iArr = new int[2];
                            c.this.gzK.getLocationOnScreen(iArr);
                            c.this.gAd.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.gzK.getWidth() / 2)) - (c.this.gAd.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.gAd.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.gAd.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
                            c.this.mRootView.addView(c.this.gAd, layoutParams);
                        }
                    }
                }, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNs() {
        if (ba.c(com.baidu.live.v.a.Hs().beo)) {
            this.gzK.setVisibility(0);
            if (ba.c(com.baidu.live.v.a.Hs().beo)) {
                this.gzL.setAlpha(0.2f);
                this.gzM.setAlpha(0.2f);
            }
        } else if (this.bkZ != null && this.bkZ.hasBeauty() < 0) {
            this.gzK.setVisibility(8);
        } else {
            this.gzK.setVisibility(0);
        }
    }

    public boolean bHo() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNt() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Dy(String str) {
        this.gzS = true;
        this.gzT = str;
        this.gzP.setText(a.i.ala_live_change_cover);
        Eb(str);
        k.a(this.gzO, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bHr() {
        return bMR();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bNu();
        bNs();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a bMU() {
        return this.grO;
    }

    public void bHl() {
        this.bkZ.setVideoConfig(LiveRecorderConfigHelper.GN().d(2, 1, false));
    }

    private void bNu() {
        if (this.bkZ != null) {
            bNs();
            if (this.bkZ.isBackCamera()) {
                this.gzI.setEnabled(true);
                this.gzI.setVisibility(0);
                this.gzU = this.bkZ.isFlashingLightOpen();
            } else {
                this.gzI.setEnabled(false);
                this.gzI.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bkZ != null) {
                        c.this.bkZ.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bMW();
        if (this.gzW != null && z) {
            this.gzW.bMw();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bHw() {
        return 1;
    }

    public void a(e.a aVar) {
        this.gzF = aVar;
    }

    public void onResume() {
        this.gzQ = false;
        if (this.bkZ != null) {
            if (this.bkZ.isBackCamera()) {
                this.gzI.setEnabled(true);
                this.gzI.setVisibility(0);
                this.gzU = this.bkZ.isFlashingLightOpen();
                bNq();
            } else {
                this.gzI.setEnabled(false);
                this.gzI.setVisibility(4);
            }
        }
        if (this.gyg != null && this.gyg.bNA() && TextUtils.isEmpty(this.gyg.bNG())) {
            this.gyg.bNF();
        }
    }

    public void onRefresh() {
    }

    public void lx(boolean z) {
        this.gyf.setClickable(z);
    }

    public void release() {
        this.gAc = true;
        if (this.bkZ != null) {
            this.bkZ.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.gAn);
        MessageManager.getInstance().unRegisterListener(this.gqO);
        MessageManager.getInstance().unRegisterListener(this.gAo);
        MessageManager.getInstance().unRegisterListener(this.gAp);
        if (this.gzW != null) {
            this.gzW.release();
        }
        if (this.gaq != null) {
            this.gaq.release();
            this.gaq = null;
        }
    }

    private void bNv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bNw() {
        if (aa.xg()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "/ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNx() {
        if (aa.xg()) {
            this.gAe.setVisibility(0);
            if (this.grO != null && this.grO.byT() != null && !StringUtils.isNull(this.grO.byT().getName())) {
                this.gAe.setText(this.grO.byT().getName());
                this.gAe.setChecked(true);
                return;
            }
            this.gAe.setText(a.i.ala_live_prepare_select_livetype);
            this.gAe.setChecked(false);
            return;
        }
        this.gAe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNy() {
        if (this.gAa != null && this.gzX != null && this.gzX.size() > 0) {
            String str = this.gzX.get(this.gAa.nextInt(100) % this.gzX.size());
            if (!TextUtils.isEmpty(str)) {
                this.gya.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.j.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a bP = aVar.bP(true);
            View rootLayout = bP.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            bP.setTargetView(this.gyf);
            this.gAk.addView(rootLayout, 0);
            aVar.Fg();
        }
    }
}
