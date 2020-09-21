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
import com.baidu.live.data.ah;
import com.baidu.live.data.bh;
import com.baidu.live.data.j;
import com.baidu.live.data.o;
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
import com.baidu.live.utils.l;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.messages.AlaGetAnchorCategoryResponseMessagge;
import com.baidu.tieba.ala.liveroom.messages.LivePrepareListHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public class c extends a {
    private int blQ;
    private long enterTime;
    private CustomMessageListener gHl;
    private com.baidu.tieba.ala.category.b.a gIl;
    private ImageView gPA;
    private View gPB;
    private ImageView gPC;
    private TextView gPD;
    private RoundRectRelativeLayout gPE;
    private TbImageView gPF;
    private TextView gPG;
    private boolean gPH;
    private String gPI;
    private boolean gPJ;
    private String gPK;
    private boolean gPL;
    private ImageView gPM;
    private com.baidu.tieba.ala.liveroom.share.d gPN;
    private List<String> gPO;
    private String gPP;
    private String gPQ;
    private Random gPR;
    private int gPS;
    private boolean gPT;
    protected View gPU;
    private CheckedTextView gPV;
    private j gPW;
    private boolean gPX;
    private RelativeLayout gPY;
    private TextView gPZ;
    private e.a gPw;
    private LinearLayout gPx;
    private ImageView gPy;
    private ImageView gPz;
    private FrameLayout gQa;
    private LinearLayout gQb;
    private View.OnClickListener gQc;
    private View.OnClickListener gQd;
    private HttpMessageListener gQe;
    private HttpMessageListener gQf;
    private CustomMessageListener gQg;
    private com.baidu.tieba.ala.liveroom.activeview.b gpD;
    private Handler handler;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gPH = false;
        this.gPJ = false;
        this.gPL = false;
        this.gPS = 0;
        this.gPT = false;
        this.handler = new Handler();
        this.blQ = 0;
        this.gPX = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.bYB();
                c.this.gPL = z;
                c.this.bYY();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.bYB();
                if (z) {
                    c.this.gPz.setEnabled(false);
                    c.this.gPz.setVisibility(4);
                    c.this.gPL = false;
                    c.this.bYY();
                    return;
                }
                c.this.gPz.setEnabled(true);
                c.this.gPz.setVisibility(0);
                if (c.this.btW.isFlashingLightOpen()) {
                    c.this.gPL = true;
                    c.this.bYY();
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
                boolean isBackCamera = c.this.btW.isBackCamera();
                if (!isBackCamera) {
                    c.this.gPz.setEnabled(false);
                    c.this.gPz.setVisibility(4);
                } else {
                    c.this.gPz.setEnabled(true);
                    c.this.gPz.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.gPL = c.this.btW.isFlashingLightOpen();
                    c.this.bYY();
                }
                if (c.this.btW.hasBeauty() >= 0) {
                    c.this.btW.setBeauty(com.baidu.live.c.AR().getInt("live_beauty_level", 3));
                }
                c.this.bZa();
                if (!z && c.this.gPw != null) {
                    c.this.gPw.bWd();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.gPH) {
                    c.this.bZb();
                    c.this.gPH = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.gPw != null) {
                    c.this.gPw.bWe();
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
        this.gQc = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.btW != null) {
                        c.this.btW.switchFlashingLight();
                        c.this.gPL = c.this.btW.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.bYY();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.gQd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.bYB();
                    if (view.getId() == a.g.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.gNC != null) {
                                    c.this.gNC.bWf();
                                    return;
                                }
                                return;
                            }
                            c.this.bYx();
                        }
                    } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.gPH = true;
                        c.this.btW.stopRecord();
                        if (TextUtils.isEmpty(c.this.gPK)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.btW != null) {
                                c.this.btW.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                        c.this.gPX = true;
                        com.baidu.live.c.AR().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.gNC != null) {
                            c.this.gNC.bWh();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.gPU != null && c.this.mRootView.indexOfChild(c.this.gPU) >= 0) {
                                    c.this.mRootView.removeView(c.this.gPU);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.g.ala_prepare_close) {
                        if (c.this.gNC != null) {
                            c.this.gNC.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                        c.this.bZg();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                        c.this.bYZ();
                    } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.gIl), com.baidu.tieba.ala.category.b.a.b(c.this.gIl))));
                    }
                }
            }
        };
        this.gQe = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.gID != null && livePrepareListHttpResponseMessage.gID.size() > 0) {
                        c.this.gPO = new ArrayList(livePrepareListHttpResponseMessage.gID);
                        c.this.bZg();
                    } else {
                        c.this.gPO = new ArrayList();
                    }
                    c.this.gPP = livePrepareListHttpResponseMessage.gIB;
                    c.this.gPQ = livePrepareListHttpResponseMessage.gIC;
                }
            }
        };
        this.gHl = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aAh != null) {
                    if (data.aAh.aAq == 1) {
                        c.this.w(data.aAh.mText, 1500L);
                    }
                    com.baidu.live.c.AR().putInt("beauty_new_bubble", data.aAh.aAq);
                    com.baidu.live.c.AR().putInt("beauty_subitem_redot", data.aAh.aAr);
                    com.baidu.live.c.AR().putInt("beauty_tab_redot", data.aAh.aAs);
                }
            }
        };
        this.gQf = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.gIl = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).bWJ();
                    }
                    c.this.bZf();
                }
            }
        };
        this.gQg = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.gIl = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.bZf();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.bZf();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        bZd();
        bZe();
        MessageManager.getInstance().registerListener(this.gQe);
        MessageManager.getInstance().registerListener(this.gHl);
        MessageManager.getInstance().registerListener(this.gQf);
        MessageManager.getInstance().registerListener(this.gQg);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.gPR = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.gPN = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.gPN.p(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.gPN.bV(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.gPN = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gPN != null) {
            this.gPN.a(iShareCallback);
        }
    }

    private void initViews() {
        this.gPI = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.bYA();
                c.this.bYB();
                return false;
            }
        });
        bYs();
        this.gNy.setOnClickListener(this.gQd);
        this.gPx = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.gPE = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.gPF = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.gPG = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.gPF.setIsRound(false);
        this.gPF.setGifIconSupport(false);
        String bYw = bYw();
        this.gPG.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(bYw)) {
            this.gPF.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            l.a(this.gPF, bYw, true, false);
            this.gPG.setText(a.i.ala_live_change_cover);
            this.gPK = bYw;
        }
        this.gNy.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.gPy = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.gPy.setOnClickListener(this.gQd);
        this.gPA = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.gPA.setOnClickListener(this.gQd);
        this.gPz = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.gQb = (LinearLayout) this.mRootView.findViewById(a.g.prepare_opt_layout);
        this.gPB = this.mRootView.findViewById(a.g.beauty_layout);
        this.gPC = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.gPD = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.gPC.setOnClickListener(this.gQd);
        this.gPD.setOnClickListener(this.gQd);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gPx.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.gPx.setLayoutParams(layoutParams);
        }
        this.gPY = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.gPZ = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.gQa = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.gPY.setOnClickListener(this.gQd);
        this.gPM = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.gPM.setOnClickListener(this.gQd);
        this.gPV = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.gPV.setOnClickListener(this.gQd);
        EP();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.gPT = true;
        bYW();
        bYX();
        this.enterTime = System.currentTimeMillis();
    }

    private o bYV() {
        if (com.baidu.live.x.a.NN().bhy == null || com.baidu.live.x.a.NN().bhy.aID == null) {
            return null;
        }
        return com.baidu.live.x.a.NN().bhy.aID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYW() {
        o bYV = bYV();
        if (bYV != null && bYV.aEM != null && bYV.aEM.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.gPW = bYV.aEM.get(this.gPS % bYV.aEM.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.gPW.getText());
            this.gPY.setVisibility(0);
            this.gPZ.setText(sb);
            this.gPS++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gPT) {
                        c.this.bYW();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.gPY.setVisibility(8);
    }

    private void bYX() {
        if (com.baidu.live.c.AR().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.gPY != null && this.gPY.getVisibility() == 0) {
            com.baidu.live.c.AR().putInt("live_assistant_guide_txt_show_counts", 1);
            this.gQa.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void GU(String str) {
        com.baidu.live.c.AR().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void EP() {
        this.gPE.setOnClickListener(this.gQd);
        this.gPz.setOnClickListener(this.gQc);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void bYB() {
        if (this.gNC != null) {
            this.gNC.bWi();
        }
    }

    public void bSv() {
        bYx();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bYC() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean bYD() {
        return false;
    }

    public boolean bSt() {
        if (this.gPN != null) {
            this.gPN.bYd();
        }
        return this.gPN != null && this.gPN.bSt();
    }

    public void bSu() {
        if (this.gPN != null) {
            this.gPN.w(this.gPK, getLiveTitle(), this.gPP, this.gPQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYY() {
        if (this.gPL) {
            this.gPz.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.gPz.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYZ() {
        this.gQa.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.gpD == null) {
                this.gpD = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.gPW != null && !TextUtils.isEmpty(this.gPW.CK())) {
                this.gpD.Gm(this.gPW.CK());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, long j) {
        if (this.gPU == null) {
            this.gPU = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.gPU.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (!c.this.gPX && c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.gPU != null) {
                            int[] iArr = new int[2];
                            c.this.gPB.getLocationOnScreen(iArr);
                            c.this.gPU.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.gPB.getWidth() / 2)) - (c.this.gPU.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.gPU.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.gPU.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
                            c.this.mRootView.addView(c.this.gPU, layoutParams);
                        }
                    }
                }, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZa() {
        if (bh.c(com.baidu.live.x.a.NN().bmW)) {
            this.gPB.setVisibility(0);
            if (bh.c(com.baidu.live.x.a.NN().bmW)) {
                this.gPC.setAlpha(0.2f);
                this.gPD.setAlpha(0.2f);
            }
        } else if (this.btW != null && this.btW.hasBeauty() < 0) {
            this.gPB.setVisibility(8);
        } else {
            this.gPB.setVisibility(0);
        }
    }

    public boolean bSp() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZb() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Gu(String str) {
        this.gPJ = true;
        this.gPK = str;
        this.gPG.setText(a.i.ala_live_change_cover);
        GU(str);
        l.a(this.gPF, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bSs() {
        return bYw();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        super.a(alaLiveRecorder);
        bZc();
        bZa();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a bYz() {
        return this.gIl;
    }

    public void bSm() {
        this.btW.setVideoConfig(LiveRecorderConfigHelper.Nk().d(2, 1, false));
    }

    private void bZc() {
        if (this.btW != null) {
            bZa();
            if (this.btW.isBackCamera()) {
                this.gPz.setEnabled(true);
                this.gPz.setVisibility(0);
                this.gPL = this.btW.isFlashingLightOpen();
            } else {
                this.gPz.setEnabled(false);
                this.gPz.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.btW != null) {
                        c.this.btW.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        bYB();
        if (this.gPN != null && z) {
            this.gPN.bYc();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bSx() {
        return 1;
    }

    public void a(e.a aVar) {
        this.gPw = aVar;
    }

    public void onResume() {
        this.gPH = false;
        if (this.btW != null) {
            if (this.btW.isBackCamera()) {
                this.gPz.setEnabled(true);
                this.gPz.setVisibility(0);
                this.gPL = this.btW.isFlashingLightOpen();
                bYY();
            } else {
                this.gPz.setEnabled(false);
                this.gPz.setVisibility(4);
            }
        }
        if (this.gNz != null && this.gNz.bZi() && TextUtils.isEmpty(this.gNz.bZo())) {
            this.gNz.bZn();
        }
    }

    public void onRefresh() {
    }

    public void md(boolean z) {
        this.gNy.setClickable(z);
    }

    public void release() {
        this.gPT = true;
        if (this.btW != null) {
            this.btW.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.gQe);
        MessageManager.getInstance().unRegisterListener(this.gHl);
        MessageManager.getInstance().unRegisterListener(this.gQf);
        MessageManager.getInstance().unRegisterListener(this.gQg);
        if (this.gPN != null) {
            this.gPN.release();
        }
        if (this.gpD != null) {
            this.gpD.release();
            this.gpD = null;
        }
    }

    private void bZd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bZe() {
        if (ah.CZ()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "/ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZf() {
        if (ah.CZ()) {
            this.gPV.setVisibility(0);
            if (this.gIl != null && this.gIl.bJf() != null && !StringUtils.isNull(this.gIl.bJf().getName())) {
                this.gPV.setText(this.gIl.bJf().getName());
                this.gPV.setChecked(true);
                return;
            }
            this.gPV.setText(a.i.ala_live_prepare_select_livetype);
            this.gPV.setChecked(false);
            return;
        }
        this.gPV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZg() {
        if (this.gPR != null && this.gPO != null && this.gPO.size() > 0) {
            String str = this.gPO.get(this.gPR.nextInt(100) % this.gPO.size());
            if (!TextUtils.isEmpty(str)) {
                this.gNt.clearFocus();
                this.gNt.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.j.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a bX = aVar.bX(true);
            View rootLayout = bX.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            bX.setTargetView(this.gNy);
            this.gQb.addView(rootLayout, 0);
            aVar.Lt();
        }
    }
}
