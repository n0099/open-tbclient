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
import com.baidu.live.data.az;
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
/* loaded from: classes3.dex */
public class c extends a {
    private int bcY;
    private com.baidu.tieba.ala.liveroom.activeview.b fVl;
    private CustomMessageListener glQ;
    private com.baidu.tieba.ala.category.b.a gmQ;
    private List<String> guA;
    private String guB;
    private String guC;
    private Random guD;
    private int guE;
    private boolean guF;
    protected View guG;
    private CheckedTextView guH;
    private h guI;
    private boolean guJ;
    private RelativeLayout guK;
    private TextView guL;
    private FrameLayout guM;
    private LinearLayout guN;
    private View.OnClickListener guO;
    private View.OnClickListener guP;
    private HttpMessageListener guQ;
    private HttpMessageListener guR;
    private CustomMessageListener guS;
    private e.a gui;
    private LinearLayout guj;
    private ImageView guk;
    private ImageView gul;
    private ImageView gum;
    private View gun;
    private ImageView guo;
    private TextView gup;
    private RoundRectRelativeLayout guq;
    private TbImageView gur;
    private TextView gus;
    private boolean gut;
    private String guu;
    private boolean guv;
    private String guw;
    private boolean gux;
    private ImageView guy;
    private com.baidu.tieba.ala.liveroom.share.d guz;
    private Handler handler;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gut = false;
        this.guv = false;
        this.gux = false;
        this.guE = 0;
        this.guF = false;
        this.handler = new Handler();
        this.bcY = 0;
        this.guJ = false;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bJP();
                c.this.gux = z;
                c.this.bKj();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bJP();
                if (z) {
                    c.this.gul.setEnabled(false);
                    c.this.gul.setVisibility(4);
                    c.this.gux = false;
                    c.this.bKj();
                    return;
                }
                c.this.gul.setEnabled(true);
                c.this.gul.setVisibility(0);
                if (c.this.bkF.isFlashingLightOpen()) {
                    c.this.gux = true;
                    c.this.bKj();
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
                boolean isBackCamera = c.this.bkF.isBackCamera();
                if (!isBackCamera) {
                    c.this.gul.setEnabled(false);
                    c.this.gul.setVisibility(4);
                } else {
                    c.this.gul.setEnabled(true);
                    c.this.gul.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.gux = c.this.bkF.isFlashingLightOpen();
                    c.this.bKj();
                }
                if (c.this.bkF.hasBeauty() >= 0) {
                    c.this.bkF.setBeauty(com.baidu.live.c.vf().getInt("live_beauty_level", 3));
                }
                c.this.bKl();
                if (!z && c.this.gui != null) {
                    c.this.gui.bHi();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.gut) {
                    c.this.bKm();
                    c.this.gut = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.gui != null) {
                    c.this.gui.bHj();
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
        this.guO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bkF != null) {
                    c.this.bkF.switchFlashingLight();
                    c.this.gux = c.this.bkF.isFlashingLightOpen();
                }
                TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                c.this.bKj();
                LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
            }
        };
        this.guP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bJP();
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (c.this.gsM != null) {
                                c.this.gsM.bHk();
                                return;
                            }
                            return;
                        }
                        c.this.bJL();
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.gut = true;
                    c.this.bkF.stopRecord();
                    if (TextUtils.isEmpty(c.this.guw)) {
                        LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                    } else {
                        LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                    }
                } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                    if (c.this.bkF != null) {
                        c.this.bkF.switchCamera();
                        TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                    c.this.guJ = true;
                    com.baidu.live.c.vf().putInt("beauty_new_bubble", 0);
                    TiebaInitialize.log(new StatisticItem("c11983"));
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                    if (c.this.gsM != null) {
                        c.this.gsM.bHm();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                    c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mRootView != null && c.this.guG != null && c.this.mRootView.indexOfChild(c.this.guG) >= 0) {
                                c.this.mRootView.removeView(c.this.guG);
                            }
                        }
                    }, 300L);
                } else if (view.getId() == a.g.ala_prepare_close) {
                    if (c.this.gsM != null) {
                        c.this.gsM.onCloseClicked();
                    }
                    LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                    c.this.bKr();
                    LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                    c.this.bKk();
                } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.gmQ), com.baidu.tieba.ala.category.b.a.b(c.this.gmQ))));
                }
            }
        };
        this.guQ = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.gng != null && livePrepareListHttpResponseMessage.gng.size() > 0) {
                        c.this.guA = new ArrayList(livePrepareListHttpResponseMessage.gng);
                        c.this.bKr();
                    } else {
                        c.this.guA = new ArrayList();
                    }
                    c.this.guB = livePrepareListHttpResponseMessage.gne;
                    c.this.guC = livePrepareListHttpResponseMessage.gnf;
                }
            }
        };
        this.glQ = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.auB != null) {
                    if (data.auB.auK == 1) {
                        c.this.x(data.auB.mText, 1500L);
                    }
                    com.baidu.live.c.vf().putInt("beauty_new_bubble", data.auB.auK);
                    com.baidu.live.c.vf().putInt("beauty_subitem_redot", data.auB.auL);
                    com.baidu.live.c.vf().putInt("beauty_tab_redot", data.auB.auM);
                }
            }
        };
        this.guR = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.gmQ = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).bHO();
                    }
                    c.this.bKq();
                }
            }
        };
        this.guS = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.gmQ = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.bKq();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.bKq();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bKo();
        bKp();
        MessageManager.getInstance().registerListener(this.guQ);
        MessageManager.getInstance().registerListener(this.glQ);
        MessageManager.getInstance().registerListener(this.guR);
        MessageManager.getInstance().registerListener(this.guS);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.guD = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.guz = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.guz.m(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.guz.bI(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.guz = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.guz != null) {
            this.guz.a(iShareCallback);
        }
    }

    private void initViews() {
        this.guu = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bJO();
                c.this.bJP();
                return false;
            }
        });
        bJG();
        this.gsI.setOnClickListener(this.guP);
        this.guj = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.guq = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.gur = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.gus = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.gur.setIsRound(false);
        this.gur.setGifIconSupport(false);
        String bJK = bJK();
        this.gus.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bJK)) {
            this.gur.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.gur, bJK, true, false);
            this.gus.setText(a.i.ala_live_change_cover);
            this.guw = bJK;
        }
        this.gsI.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.guk = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.guk.setOnClickListener(this.guP);
        this.gum = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.gum.setOnClickListener(this.guP);
        this.gul = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.guN = (LinearLayout) this.mRootView.findViewById(a.g.prepare_opt_layout);
        this.gun = this.mRootView.findViewById(a.g.beauty_layout);
        this.guo = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.gup = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.guo.setOnClickListener(this.guP);
        this.gup.setOnClickListener(this.guP);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.guj.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.guj.setLayoutParams(layoutParams);
        }
        this.guK = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.guL = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.guM = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.guK.setOnClickListener(this.guP);
        this.guy = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.guy.setOnClickListener(this.guP);
        this.guH = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.guH.setOnClickListener(this.guP);
        yt();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.guF = true;
        bKh();
        bKi();
    }

    private l bKg() {
        if (com.baidu.live.v.a.Hm().aZp == null || com.baidu.live.v.a.Hm().aZp.aAN == null) {
            return null;
        }
        return com.baidu.live.v.a.Hm().aZp.aAN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKh() {
        l bKg = bKg();
        if (bKg != null && bKg.axz != null && bKg.axz.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.guI = bKg.axz.get(this.guE % bKg.axz.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.guI.getText());
            this.guK.setVisibility(0);
            this.guL.setText(sb);
            this.guE++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.guF) {
                        c.this.bKh();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.guK.setVisibility(8);
    }

    private void bKi() {
        if (com.baidu.live.c.vf().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.guK != null && this.guK.getVisibility() == 0) {
            com.baidu.live.c.vf().putInt("live_assistant_guide_txt_show_counts", 1);
            this.guM.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Dp(String str) {
        com.baidu.live.c.vf().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void yt() {
        this.guq.setOnClickListener(this.guP);
        this.gul.setOnClickListener(this.guO);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bJP() {
        if (this.gsM != null) {
            this.gsM.bHn();
        }
    }

    public void bEi() {
        bJL();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bJQ() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bJR() {
        return false;
    }

    public boolean bEg() {
        if (this.guz != null) {
            this.guz.bJq();
        }
        return this.guz != null && this.guz.bEg();
    }

    public void bEh() {
        if (this.guz != null) {
            this.guz.w(this.guw, getLiveTitle(), this.guB, this.guC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKj() {
        if (this.gux) {
            this.gul.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.gul.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKk() {
        this.guM.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.fVl == null) {
                this.fVl = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.guI != null && !TextUtils.isEmpty(this.guI.wv())) {
                this.fVl.CF(this.guI.wv());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (this.guG == null) {
            this.guG = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.guG.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (!c.this.guJ && c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.guG != null) {
                            int[] iArr = new int[2];
                            c.this.gun.getLocationOnScreen(iArr);
                            c.this.guG.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.gun.getWidth() / 2)) - (c.this.guG.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.guG.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.guG.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
                            c.this.mRootView.addView(c.this.guG, layoutParams);
                        }
                    }
                }, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKl() {
        if (az.c(com.baidu.live.v.a.Hm().bdV)) {
            this.gun.setVisibility(0);
            if (az.c(com.baidu.live.v.a.Hm().bdV)) {
                this.guo.setAlpha(0.2f);
                this.gup.setAlpha(0.2f);
            }
        } else if (this.bkF != null && this.bkF.hasBeauty() < 0) {
            this.gun.setVisibility(8);
        } else {
            this.gun.setVisibility(0);
        }
    }

    public boolean bEc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKm() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void CM(String str) {
        this.guv = true;
        this.guw = str;
        this.gus.setText(a.i.ala_live_change_cover);
        Dp(str);
        k.a(this.gur, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bEf() {
        return bJK();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bKn();
        bKl();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a bJN() {
        return this.gmQ;
    }

    public void bDZ() {
        this.bkF.setVideoConfig(LiveRecorderConfigHelper.GG().d(2, 1, false));
    }

    private void bKn() {
        if (this.bkF != null) {
            bKl();
            if (this.bkF.isBackCamera()) {
                this.gul.setEnabled(true);
                this.gul.setVisibility(0);
                this.gux = this.bkF.isFlashingLightOpen();
            } else {
                this.gul.setEnabled(false);
                this.gul.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bkF != null) {
                        c.this.bkF.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bJP();
        if (this.guz != null && z) {
            this.guz.bJp();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bEk() {
        return 1;
    }

    public void a(e.a aVar) {
        this.gui = aVar;
    }

    public void onResume() {
        this.gut = false;
        if (this.bkF != null) {
            if (this.bkF.isBackCamera()) {
                this.gul.setEnabled(true);
                this.gul.setVisibility(0);
                this.gux = this.bkF.isFlashingLightOpen();
                bKj();
            } else {
                this.gul.setEnabled(false);
                this.gul.setVisibility(4);
            }
        }
        if (this.gsJ != null && this.gsJ.bKt() && TextUtils.isEmpty(this.gsJ.bKz())) {
            this.gsJ.bKy();
        }
    }

    public void onRefresh() {
    }

    public void kU(boolean z) {
        this.gsI.setClickable(z);
    }

    public void release() {
        this.guF = true;
        if (this.bkF != null) {
            this.bkF.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.guQ);
        MessageManager.getInstance().unRegisterListener(this.glQ);
        MessageManager.getInstance().unRegisterListener(this.guR);
        MessageManager.getInstance().unRegisterListener(this.guS);
        if (this.guz != null) {
            this.guz.release();
        }
        if (this.fVl != null) {
            this.fVl.release();
            this.fVl = null;
        }
    }

    private void bKo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bKp() {
        if (aa.wE()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "/ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKq() {
        if (aa.wE()) {
            this.guH.setVisibility(0);
            if (this.gmQ != null && this.gmQ.bvJ() != null && !StringUtils.isNull(this.gmQ.bvJ().getName())) {
                this.guH.setText(this.gmQ.bvJ().getName());
                this.guH.setChecked(true);
                return;
            }
            this.guH.setText(a.i.ala_live_prepare_select_livetype);
            this.guH.setChecked(false);
            return;
        }
        this.guH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        if (this.guD != null && this.guA != null && this.guA.size() > 0) {
            String str = this.guA.get(this.guD.nextInt(100) % this.guA.size());
            if (!TextUtils.isEmpty(str)) {
                this.gsD.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.j.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a bO = aVar.bO(true);
            View rootLayout = bO.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            bO.setTargetView(this.gsI);
            this.guN.addView(rootLayout, 0);
            aVar.Fm();
        }
    }
}
