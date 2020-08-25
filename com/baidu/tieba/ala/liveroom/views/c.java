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
import com.baidu.live.data.ac;
import com.baidu.live.data.bc;
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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
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
/* loaded from: classes7.dex */
public class c extends a {
    private int biT;
    private long enterTime;
    private CustomMessageListener gDI;
    private com.baidu.tieba.ala.category.b.a gEJ;
    protected View gMA;
    private CheckedTextView gMB;
    private h gMC;
    private boolean gMD;
    private RelativeLayout gME;
    private TextView gMF;
    private FrameLayout gMG;
    private LinearLayout gMH;
    private View.OnClickListener gMI;
    private View.OnClickListener gMJ;
    private HttpMessageListener gMK;
    private HttpMessageListener gML;
    private CustomMessageListener gMM;
    private e.a gMc;
    private LinearLayout gMd;
    private ImageView gMe;
    private ImageView gMf;
    private ImageView gMg;
    private View gMh;
    private ImageView gMi;
    private TextView gMj;
    private RoundRectRelativeLayout gMk;
    private TbImageView gMl;
    private TextView gMm;
    private boolean gMn;
    private String gMo;
    private boolean gMp;
    private String gMq;
    private boolean gMr;
    private ImageView gMs;
    private com.baidu.tieba.ala.liveroom.share.d gMt;
    private List<String> gMu;
    private String gMv;
    private String gMw;
    private Random gMx;
    private int gMy;
    private boolean gMz;
    private com.baidu.tieba.ala.liveroom.activeview.b gms;
    private Handler handler;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gMn = false;
        this.gMp = false;
        this.gMr = false;
        this.gMy = 0;
        this.gMz = false;
        this.handler = new Handler();
        this.biT = 0;
        this.gMD = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bWT();
                c.this.gMr = z;
                c.this.bXq();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bWT();
                if (z) {
                    c.this.gMf.setEnabled(false);
                    c.this.gMf.setVisibility(4);
                    c.this.gMr = false;
                    c.this.bXq();
                    return;
                }
                c.this.gMf.setEnabled(true);
                c.this.gMf.setVisibility(0);
                if (c.this.bqF.isFlashingLightOpen()) {
                    c.this.gMr = true;
                    c.this.bXq();
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
                boolean isBackCamera = c.this.bqF.isBackCamera();
                if (!isBackCamera) {
                    c.this.gMf.setEnabled(false);
                    c.this.gMf.setVisibility(4);
                } else {
                    c.this.gMf.setEnabled(true);
                    c.this.gMf.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.gMr = c.this.bqF.isFlashingLightOpen();
                    c.this.bXq();
                }
                if (c.this.bqF.hasBeauty() >= 0) {
                    c.this.bqF.setBeauty(com.baidu.live.c.AD().getInt("live_beauty_level", 3));
                }
                c.this.bXs();
                if (!z && c.this.gMc != null) {
                    c.this.gMc.bUs();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.gMn) {
                    c.this.bXt();
                    c.this.gMn = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.gMc != null) {
                    c.this.gMc.bUt();
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
        this.gMI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bqF != null) {
                        c.this.bqF.switchFlashingLight();
                        c.this.gMr = c.this.bqF.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.bXq();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.gMJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.bWT();
                    if (view.getId() == a.g.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.gKi != null) {
                                    c.this.gKi.bUu();
                                    return;
                                }
                                return;
                            }
                            c.this.bWP();
                        }
                    } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.gMn = true;
                        c.this.bqF.stopRecord();
                        if (TextUtils.isEmpty(c.this.gMq)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bqF != null) {
                                c.this.bqF.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                        c.this.gMD = true;
                        com.baidu.live.c.AD().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.gKi != null) {
                            c.this.gKi.bUw();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.gMA != null && c.this.mRootView.indexOfChild(c.this.gMA) >= 0) {
                                    c.this.mRootView.removeView(c.this.gMA);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.g.ala_prepare_close) {
                        if (c.this.gKi != null) {
                            c.this.gKi.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                        c.this.bXy();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                        c.this.bXr();
                    } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.gEJ), com.baidu.tieba.ala.category.b.a.b(c.this.gEJ))));
                    }
                }
            }
        };
        this.gMK = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.gFb != null && livePrepareListHttpResponseMessage.gFb.size() > 0) {
                        c.this.gMu = new ArrayList(livePrepareListHttpResponseMessage.gFb);
                        c.this.bXy();
                    } else {
                        c.this.gMu = new ArrayList();
                    }
                    c.this.gMv = livePrepareListHttpResponseMessage.gEZ;
                    c.this.gMw = livePrepareListHttpResponseMessage.gFa;
                }
            }
        };
        this.gDI = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.azz != null) {
                    if (data.azz.azI == 1) {
                        c.this.w(data.azz.mText, 1500L);
                    }
                    com.baidu.live.c.AD().putInt("beauty_new_bubble", data.azz.azI);
                    com.baidu.live.c.AD().putInt("beauty_subitem_redot", data.azz.azJ);
                    com.baidu.live.c.AD().putInt("beauty_tab_redot", data.azz.azK);
                }
            }
        };
        this.gML = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.gEJ = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).bUY();
                    }
                    c.this.bXx();
                }
            }
        };
        this.gMM = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.gEJ = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.bXx();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.bXx();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bXv();
        bXw();
        MessageManager.getInstance().registerListener(this.gMK);
        MessageManager.getInstance().registerListener(this.gDI);
        MessageManager.getInstance().registerListener(this.gML);
        MessageManager.getInstance().registerListener(this.gMM);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.gMx = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.gMt = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.gMt.o(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.gMt.bQ(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.gMt = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gMt != null) {
            this.gMt.a(iShareCallback);
        }
    }

    private void initViews() {
        this.gMo = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bWS();
                c.this.bWT();
                return false;
            }
        });
        bWK();
        this.gKe.setOnClickListener(this.gMJ);
        this.gMd = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.gMk = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.gMl = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.gMm = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.gMl.setIsRound(false);
        this.gMl.setGifIconSupport(false);
        String bWO = bWO();
        this.gMm.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bWO)) {
            this.gMl.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.gMl, bWO, true, false);
            this.gMm.setText(a.i.ala_live_change_cover);
            this.gMq = bWO;
        }
        this.gKe.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.gMe = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.gMe.setOnClickListener(this.gMJ);
        this.gMg = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.gMg.setOnClickListener(this.gMJ);
        this.gMf = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.gMH = (LinearLayout) this.mRootView.findViewById(a.g.prepare_opt_layout);
        this.gMh = this.mRootView.findViewById(a.g.beauty_layout);
        this.gMi = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.gMj = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.gMi.setOnClickListener(this.gMJ);
        this.gMj.setOnClickListener(this.gMJ);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMd.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.gMd.setLayoutParams(layoutParams);
        }
        this.gME = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.gMF = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.gMG = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.gME.setOnClickListener(this.gMJ);
        this.gMs = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.gMs.setOnClickListener(this.gMJ);
        this.gMB = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.gMB.setOnClickListener(this.gMJ);
        Ey();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.gMz = true;
        bXo();
        bXp();
        this.enterTime = System.currentTimeMillis();
    }

    private l bXn() {
        if (com.baidu.live.w.a.Nk().beH == null || com.baidu.live.w.a.Nk().beH.aHk == null) {
            return null;
        }
        return com.baidu.live.w.a.Nk().beH.aHk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXo() {
        l bXn = bXn();
        if (bXn != null && bXn.aDO != null && bXn.aDO.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.gMC = bXn.aDO.get(this.gMy % bXn.aDO.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.gMC.getText());
            this.gME.setVisibility(0);
            this.gMF.setText(sb);
            this.gMy++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gMz) {
                        c.this.bXo();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.gME.setVisibility(8);
    }

    private void bXp() {
        if (com.baidu.live.c.AD().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.gME != null && this.gME.getVisibility() == 0) {
            com.baidu.live.c.AD().putInt("live_assistant_guide_txt_show_counts", 1);
            this.gMG.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void GA(String str) {
        com.baidu.live.c.AD().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void Ey() {
        this.gMk.setOnClickListener(this.gMJ);
        this.gMf.setOnClickListener(this.gMI);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bWT() {
        if (this.gKi != null) {
            this.gKi.bUx();
        }
    }

    public void bQY() {
        bWP();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bWU() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bWV() {
        return false;
    }

    public boolean bQW() {
        if (this.gMt != null) {
            this.gMt.bWu();
        }
        return this.gMt != null && this.gMt.bQW();
    }

    public void bQX() {
        if (this.gMt != null) {
            this.gMt.w(this.gMq, getLiveTitle(), this.gMv, this.gMw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXq() {
        if (this.gMr) {
            this.gMf.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.gMf.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXr() {
        this.gMG.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.gms == null) {
                this.gms = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.gMC != null && !TextUtils.isEmpty(this.gMC.Cv())) {
                this.gms.FO(this.gMC.Cv());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, long j) {
        if (this.gMA == null) {
            this.gMA = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.gMA.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (!c.this.gMD && c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.gMA != null) {
                            int[] iArr = new int[2];
                            c.this.gMh.getLocationOnScreen(iArr);
                            c.this.gMA.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.gMh.getWidth() / 2)) - (c.this.gMA.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.gMA.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.gMA.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
                            c.this.mRootView.addView(c.this.gMA, layoutParams);
                        }
                    }
                }, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        if (bc.c(com.baidu.live.w.a.Nk().bka)) {
            this.gMh.setVisibility(0);
            if (bc.c(com.baidu.live.w.a.Nk().bka)) {
                this.gMi.setAlpha(0.2f);
                this.gMj.setAlpha(0.2f);
            }
        } else if (this.bqF != null && this.bqF.hasBeauty() < 0) {
            this.gMh.setVisibility(8);
        } else {
            this.gMh.setVisibility(0);
        }
    }

    public boolean bQS() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXt() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void FV(String str) {
        this.gMp = true;
        this.gMq = str;
        this.gMm.setText(a.i.ala_live_change_cover);
        GA(str);
        k.a(this.gMl, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bQV() {
        return bWO();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bXu();
        bXs();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a bWR() {
        return this.gEJ;
    }

    public void bQP() {
        this.bqF.setVideoConfig(LiveRecorderConfigHelper.MC().d(2, 1, false));
    }

    private void bXu() {
        if (this.bqF != null) {
            bXs();
            if (this.bqF.isBackCamera()) {
                this.gMf.setEnabled(true);
                this.gMf.setVisibility(0);
                this.gMr = this.bqF.isFlashingLightOpen();
            } else {
                this.gMf.setEnabled(false);
                this.gMf.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bqF != null) {
                        c.this.bqF.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bWT();
        if (this.gMt != null && z) {
            this.gMt.bWt();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bRa() {
        return 1;
    }

    public void a(e.a aVar) {
        this.gMc = aVar;
    }

    public void onResume() {
        this.gMn = false;
        if (this.bqF != null) {
            if (this.bqF.isBackCamera()) {
                this.gMf.setEnabled(true);
                this.gMf.setVisibility(0);
                this.gMr = this.bqF.isFlashingLightOpen();
                bXq();
            } else {
                this.gMf.setEnabled(false);
                this.gMf.setVisibility(4);
            }
        }
        if (this.gKf != null && this.gKf.bXA() && TextUtils.isEmpty(this.gKf.bXG())) {
            this.gKf.bXF();
        }
    }

    public void onRefresh() {
    }

    public void lY(boolean z) {
        this.gKe.setClickable(z);
    }

    public void release() {
        this.gMz = true;
        if (this.bqF != null) {
            this.bqF.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.gMK);
        MessageManager.getInstance().unRegisterListener(this.gDI);
        MessageManager.getInstance().unRegisterListener(this.gML);
        MessageManager.getInstance().unRegisterListener(this.gMM);
        if (this.gMt != null) {
            this.gMt.release();
        }
        if (this.gms != null) {
            this.gms.release();
            this.gms = null;
        }
    }

    private void bXv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bXw() {
        if (ac.CJ()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "/ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXx() {
        if (ac.CJ()) {
            this.gMB.setVisibility(0);
            if (this.gEJ != null && this.gEJ.bHW() != null && !StringUtils.isNull(this.gEJ.bHW().getName())) {
                this.gMB.setText(this.gEJ.bHW().getName());
                this.gMB.setChecked(true);
                return;
            }
            this.gMB.setText(a.i.ala_live_prepare_select_livetype);
            this.gMB.setChecked(false);
            return;
        }
        this.gMB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXy() {
        if (this.gMx != null && this.gMu != null && this.gMu.size() > 0) {
            String str = this.gMu.get(this.gMx.nextInt(100) % this.gMu.size());
            if (!TextUtils.isEmpty(str)) {
                this.gJZ.clearFocus();
                this.gJZ.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.j.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a bV = aVar.bV(true);
            View rootLayout = bV.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            bV.setTargetView(this.gKe);
            this.gMH.addView(rootLayout, 0);
            aVar.KM();
        }
    }
}
