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
    private int biW;
    private long enterTime;
    private CustomMessageListener gDM;
    private com.baidu.tieba.ala.category.b.a gEN;
    private String gMA;
    private Random gMB;
    private int gMC;
    private boolean gMD;
    protected View gME;
    private CheckedTextView gMF;
    private h gMG;
    private boolean gMH;
    private RelativeLayout gMI;
    private TextView gMJ;
    private FrameLayout gMK;
    private LinearLayout gML;
    private View.OnClickListener gMM;
    private View.OnClickListener gMN;
    private HttpMessageListener gMO;
    private HttpMessageListener gMP;
    private CustomMessageListener gMQ;
    private e.a gMg;
    private LinearLayout gMh;
    private ImageView gMi;
    private ImageView gMj;
    private ImageView gMk;
    private View gMl;
    private ImageView gMm;
    private TextView gMn;
    private RoundRectRelativeLayout gMo;
    private TbImageView gMp;
    private TextView gMq;
    private boolean gMr;
    private String gMs;
    private boolean gMt;
    private String gMu;
    private boolean gMv;
    private ImageView gMw;
    private com.baidu.tieba.ala.liveroom.share.d gMx;
    private List<String> gMy;
    private String gMz;
    private com.baidu.tieba.ala.liveroom.activeview.b gmw;
    private Handler handler;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gMr = false;
        this.gMt = false;
        this.gMv = false;
        this.gMC = 0;
        this.gMD = false;
        this.handler = new Handler();
        this.biW = 0;
        this.gMH = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bWU();
                c.this.gMv = z;
                c.this.bXr();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bWU();
                if (z) {
                    c.this.gMj.setEnabled(false);
                    c.this.gMj.setVisibility(4);
                    c.this.gMv = false;
                    c.this.bXr();
                    return;
                }
                c.this.gMj.setEnabled(true);
                c.this.gMj.setVisibility(0);
                if (c.this.bqI.isFlashingLightOpen()) {
                    c.this.gMv = true;
                    c.this.bXr();
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
                boolean isBackCamera = c.this.bqI.isBackCamera();
                if (!isBackCamera) {
                    c.this.gMj.setEnabled(false);
                    c.this.gMj.setVisibility(4);
                } else {
                    c.this.gMj.setEnabled(true);
                    c.this.gMj.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.gMv = c.this.bqI.isFlashingLightOpen();
                    c.this.bXr();
                }
                if (c.this.bqI.hasBeauty() >= 0) {
                    c.this.bqI.setBeauty(com.baidu.live.c.AD().getInt("live_beauty_level", 3));
                }
                c.this.bXt();
                if (!z && c.this.gMg != null) {
                    c.this.gMg.bUt();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.gMr) {
                    c.this.bXu();
                    c.this.gMr = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.gMg != null) {
                    c.this.gMg.bUu();
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
        this.gMM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bqI != null) {
                        c.this.bqI.switchFlashingLight();
                        c.this.gMv = c.this.bqI.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.bXr();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.gMN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.bWU();
                    if (view.getId() == a.g.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.gKm != null) {
                                    c.this.gKm.bUv();
                                    return;
                                }
                                return;
                            }
                            c.this.bWQ();
                        }
                    } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.gMr = true;
                        c.this.bqI.stopRecord();
                        if (TextUtils.isEmpty(c.this.gMu)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bqI != null) {
                                c.this.bqI.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                        c.this.gMH = true;
                        com.baidu.live.c.AD().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.gKm != null) {
                            c.this.gKm.bUx();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.gME != null && c.this.mRootView.indexOfChild(c.this.gME) >= 0) {
                                    c.this.mRootView.removeView(c.this.gME);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.g.ala_prepare_close) {
                        if (c.this.gKm != null) {
                            c.this.gKm.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                        c.this.bXz();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                        c.this.bXs();
                    } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.gEN), com.baidu.tieba.ala.category.b.a.b(c.this.gEN))));
                    }
                }
            }
        };
        this.gMO = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.gFf != null && livePrepareListHttpResponseMessage.gFf.size() > 0) {
                        c.this.gMy = new ArrayList(livePrepareListHttpResponseMessage.gFf);
                        c.this.bXz();
                    } else {
                        c.this.gMy = new ArrayList();
                    }
                    c.this.gMz = livePrepareListHttpResponseMessage.gFd;
                    c.this.gMA = livePrepareListHttpResponseMessage.gFe;
                }
            }
        };
        this.gDM = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.azB != null) {
                    if (data.azB.azK == 1) {
                        c.this.w(data.azB.mText, 1500L);
                    }
                    com.baidu.live.c.AD().putInt("beauty_new_bubble", data.azB.azK);
                    com.baidu.live.c.AD().putInt("beauty_subitem_redot", data.azB.azL);
                    com.baidu.live.c.AD().putInt("beauty_tab_redot", data.azB.azM);
                }
            }
        };
        this.gMP = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.gEN = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).bUZ();
                    }
                    c.this.bXy();
                }
            }
        };
        this.gMQ = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.gEN = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.bXy();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.bXy();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bXw();
        bXx();
        MessageManager.getInstance().registerListener(this.gMO);
        MessageManager.getInstance().registerListener(this.gDM);
        MessageManager.getInstance().registerListener(this.gMP);
        MessageManager.getInstance().registerListener(this.gMQ);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.gMB = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.gMx = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.gMx.o(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.gMx.bQ(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.gMx = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gMx != null) {
            this.gMx.a(iShareCallback);
        }
    }

    private void initViews() {
        this.gMs = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bWT();
                c.this.bWU();
                return false;
            }
        });
        bWL();
        this.gKi.setOnClickListener(this.gMN);
        this.gMh = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.gMo = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.gMp = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.gMq = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.gMp.setIsRound(false);
        this.gMp.setGifIconSupport(false);
        String bWP = bWP();
        this.gMq.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bWP)) {
            this.gMp.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            k.a(this.gMp, bWP, true, false);
            this.gMq.setText(a.i.ala_live_change_cover);
            this.gMu = bWP;
        }
        this.gKi.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.gMi = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.gMi.setOnClickListener(this.gMN);
        this.gMk = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.gMk.setOnClickListener(this.gMN);
        this.gMj = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.gML = (LinearLayout) this.mRootView.findViewById(a.g.prepare_opt_layout);
        this.gMl = this.mRootView.findViewById(a.g.beauty_layout);
        this.gMm = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.gMn = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.gMm.setOnClickListener(this.gMN);
        this.gMn.setOnClickListener(this.gMN);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMh.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.gMh.setLayoutParams(layoutParams);
        }
        this.gMI = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.gMJ = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.gMK = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.gMI.setOnClickListener(this.gMN);
        this.gMw = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.gMw.setOnClickListener(this.gMN);
        this.gMF = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.gMF.setOnClickListener(this.gMN);
        Ey();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.gMD = true;
        bXp();
        bXq();
        this.enterTime = System.currentTimeMillis();
    }

    private l bXo() {
        if (com.baidu.live.w.a.Nk().beJ == null || com.baidu.live.w.a.Nk().beJ.aHm == null) {
            return null;
        }
        return com.baidu.live.w.a.Nk().beJ.aHm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXp() {
        l bXo = bXo();
        if (bXo != null && bXo.aDQ != null && bXo.aDQ.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.gMG = bXo.aDQ.get(this.gMC % bXo.aDQ.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.gMG.getText());
            this.gMI.setVisibility(0);
            this.gMJ.setText(sb);
            this.gMC++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gMD) {
                        c.this.bXp();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.gMI.setVisibility(8);
    }

    private void bXq() {
        if (com.baidu.live.c.AD().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.gMI != null && this.gMI.getVisibility() == 0) {
            com.baidu.live.c.AD().putInt("live_assistant_guide_txt_show_counts", 1);
            this.gMK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void GB(String str) {
        com.baidu.live.c.AD().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void Ey() {
        this.gMo.setOnClickListener(this.gMN);
        this.gMj.setOnClickListener(this.gMM);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bWU() {
        if (this.gKm != null) {
            this.gKm.bUy();
        }
    }

    public void bQZ() {
        bWQ();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bWV() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bWW() {
        return false;
    }

    public boolean bQX() {
        if (this.gMx != null) {
            this.gMx.bWv();
        }
        return this.gMx != null && this.gMx.bQX();
    }

    public void bQY() {
        if (this.gMx != null) {
            this.gMx.w(this.gMu, getLiveTitle(), this.gMz, this.gMA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXr() {
        if (this.gMv) {
            this.gMj.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.gMj.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        this.gMK.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.gmw == null) {
                this.gmw = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.gMG != null && !TextUtils.isEmpty(this.gMG.Cv())) {
                this.gmw.FP(this.gMG.Cv());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, long j) {
        if (this.gME == null) {
            this.gME = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.gME.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (!c.this.gMH && c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.gME != null) {
                            int[] iArr = new int[2];
                            c.this.gMl.getLocationOnScreen(iArr);
                            c.this.gME.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.gMl.getWidth() / 2)) - (c.this.gME.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.gME.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.gME.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
                            c.this.mRootView.addView(c.this.gME, layoutParams);
                        }
                    }
                }, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXt() {
        if (bc.c(com.baidu.live.w.a.Nk().bkd)) {
            this.gMl.setVisibility(0);
            if (bc.c(com.baidu.live.w.a.Nk().bkd)) {
                this.gMm.setAlpha(0.2f);
                this.gMn.setAlpha(0.2f);
            }
        } else if (this.bqI != null && this.bqI.hasBeauty() < 0) {
            this.gMl.setVisibility(8);
        } else {
            this.gMl.setVisibility(0);
        }
    }

    public boolean bQT() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXu() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void FW(String str) {
        this.gMt = true;
        this.gMu = str;
        this.gMq.setText(a.i.ala_live_change_cover);
        GB(str);
        k.a(this.gMp, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bQW() {
        return bWP();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bXv();
        bXt();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a bWS() {
        return this.gEN;
    }

    public void bQQ() {
        this.bqI.setVideoConfig(LiveRecorderConfigHelper.MC().d(2, 1, false));
    }

    private void bXv() {
        if (this.bqI != null) {
            bXt();
            if (this.bqI.isBackCamera()) {
                this.gMj.setEnabled(true);
                this.gMj.setVisibility(0);
                this.gMv = this.bqI.isFlashingLightOpen();
            } else {
                this.gMj.setEnabled(false);
                this.gMj.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bqI != null) {
                        c.this.bqI.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bWU();
        if (this.gMx != null && z) {
            this.gMx.bWu();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bRb() {
        return 1;
    }

    public void a(e.a aVar) {
        this.gMg = aVar;
    }

    public void onResume() {
        this.gMr = false;
        if (this.bqI != null) {
            if (this.bqI.isBackCamera()) {
                this.gMj.setEnabled(true);
                this.gMj.setVisibility(0);
                this.gMv = this.bqI.isFlashingLightOpen();
                bXr();
            } else {
                this.gMj.setEnabled(false);
                this.gMj.setVisibility(4);
            }
        }
        if (this.gKj != null && this.gKj.bXB() && TextUtils.isEmpty(this.gKj.bXH())) {
            this.gKj.bXG();
        }
    }

    public void onRefresh() {
    }

    public void ma(boolean z) {
        this.gKi.setClickable(z);
    }

    public void release() {
        this.gMD = true;
        if (this.bqI != null) {
            this.bqI.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.gMO);
        MessageManager.getInstance().unRegisterListener(this.gDM);
        MessageManager.getInstance().unRegisterListener(this.gMP);
        MessageManager.getInstance().unRegisterListener(this.gMQ);
        if (this.gMx != null) {
            this.gMx.release();
        }
        if (this.gmw != null) {
            this.gmw.release();
            this.gmw = null;
        }
    }

    private void bXw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bXx() {
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
    public void bXy() {
        if (ac.CJ()) {
            this.gMF.setVisibility(0);
            if (this.gEN != null && this.gEN.bHX() != null && !StringUtils.isNull(this.gEN.bHX().getName())) {
                this.gMF.setText(this.gEN.bHX().getName());
                this.gMF.setChecked(true);
                return;
            }
            this.gMF.setText(a.i.ala_live_prepare_select_livetype);
            this.gMF.setChecked(false);
            return;
        }
        this.gMF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXz() {
        if (this.gMB != null && this.gMy != null && this.gMy.size() > 0) {
            String str = this.gMy.get(this.gMB.nextInt(100) % this.gMy.size());
            if (!TextUtils.isEmpty(str)) {
                this.gKd.clearFocus();
                this.gKd.setText(str);
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
            bV.setTargetView(this.gKi);
            this.gML.addView(rootLayout, 0);
            aVar.KM();
        }
    }
}
