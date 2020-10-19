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
    private int bpD;
    private long enterTime;
    private com.baidu.tieba.ala.liveroom.activeview.b gDW;
    private CustomMessageListener gVL;
    private com.baidu.tieba.ala.category.b.a gWL;
    private Handler handler;
    private TextView heA;
    private RoundRectRelativeLayout heB;
    private TbImageView heC;
    private TextView heD;
    private boolean heE;
    private String heF;
    private boolean heG;
    private String heH;
    private boolean heI;
    private ImageView heJ;
    private com.baidu.tieba.ala.liveroom.share.d heK;
    private List<String> heL;
    private String heM;
    private String heN;
    private Random heO;
    private int heP;
    private boolean heQ;
    protected View heR;
    private CheckedTextView heS;
    private j heT;
    private boolean heU;
    private RelativeLayout heV;
    private TextView heW;
    private FrameLayout heX;
    private LinearLayout heY;
    private View.OnClickListener heZ;
    private e.a het;
    private LinearLayout heu;
    private ImageView hev;
    private ImageView hew;
    private ImageView hex;
    private View hey;
    private ImageView hez;
    private View.OnClickListener hfa;
    private HttpMessageListener hfb;
    private HttpMessageListener hfc;
    private CustomMessageListener hfd;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.heE = false;
        this.heG = false;
        this.heI = false;
        this.heP = 0;
        this.heQ = false;
        this.handler = new Handler();
        this.bpD = 0;
        this.heU = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.ccb();
                c.this.heI = z;
                c.this.ccw();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.ccb();
                if (z) {
                    c.this.hew.setEnabled(false);
                    c.this.hew.setVisibility(4);
                    c.this.heI = false;
                    c.this.ccw();
                    return;
                }
                c.this.hew.setEnabled(true);
                c.this.hew.setVisibility(0);
                if (c.this.bya.isFlashingLightOpen()) {
                    c.this.heI = true;
                    c.this.ccw();
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
                boolean isBackCamera = c.this.bya.isBackCamera();
                if (!isBackCamera) {
                    c.this.hew.setEnabled(false);
                    c.this.hew.setVisibility(4);
                } else {
                    c.this.hew.setEnabled(true);
                    c.this.hew.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.heI = c.this.bya.isFlashingLightOpen();
                    c.this.ccw();
                }
                if (c.this.bya.hasBeauty() >= 0) {
                    c.this.bya.setBeauty(com.baidu.live.c.AZ().getInt("live_beauty_level", 3));
                }
                c.this.ccy();
                if (!z && c.this.het != null) {
                    c.this.het.bZy();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.heE) {
                    c.this.ccz();
                    c.this.heE = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.het != null) {
                    c.this.het.bZz();
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
        this.heZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bya != null) {
                        c.this.bya.switchFlashingLight();
                        c.this.heI = c.this.bya.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.ccw();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hfa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.ccb();
                    if (view.getId() == a.g.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hcz != null) {
                                    c.this.hcz.bZA();
                                    return;
                                }
                                return;
                            }
                            c.this.cbX();
                        }
                    } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.heE = true;
                        c.this.bya.stopRecord();
                        if (TextUtils.isEmpty(c.this.heH)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bya != null) {
                                c.this.bya.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                        c.this.heU = true;
                        com.baidu.live.c.AZ().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hcz != null) {
                            c.this.hcz.bZC();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.heR != null && c.this.mRootView.indexOfChild(c.this.heR) >= 0) {
                                    c.this.mRootView.removeView(c.this.heR);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.g.ala_prepare_close) {
                        if (c.this.hcz != null) {
                            c.this.hcz.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                        c.this.ccE();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                        c.this.ccx();
                    } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.gWL), com.baidu.tieba.ala.category.b.a.b(c.this.gWL))));
                    }
                }
            }
        };
        this.hfb = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.gXd != null && livePrepareListHttpResponseMessage.gXd.size() > 0) {
                        c.this.heL = new ArrayList(livePrepareListHttpResponseMessage.gXd);
                        c.this.ccE();
                    } else {
                        c.this.heL = new ArrayList();
                    }
                    c.this.heM = livePrepareListHttpResponseMessage.gXb;
                    c.this.heN = livePrepareListHttpResponseMessage.gXc;
                }
            }
        };
        this.gVL = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aDm != null) {
                    if (data.aDm.aDv == 1) {
                        c.this.w(data.aDm.mText, 1500L);
                    }
                    com.baidu.live.c.AZ().putInt("beauty_new_bubble", data.aDm.aDv);
                    com.baidu.live.c.AZ().putInt("beauty_subitem_redot", data.aDm.aDw);
                    com.baidu.live.c.AZ().putInt("beauty_tab_redot", data.aDm.aDx);
                }
            }
        };
        this.hfc = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.gWL = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).cae();
                    }
                    c.this.ccD();
                }
            }
        };
        this.hfd = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.gWL = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.ccD();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.ccD();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        ccB();
        ccC();
        MessageManager.getInstance().registerListener(this.hfb);
        MessageManager.getInstance().registerListener(this.gVL);
        MessageManager.getInstance().registerListener(this.hfc);
        MessageManager.getInstance().registerListener(this.hfd);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.heO = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.heK = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.heK.p(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.heK.bZ(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.heK = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.heK != null) {
            this.heK.a(iShareCallback);
        }
    }

    private void initViews() {
        this.heF = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.cca();
                c.this.ccb();
                return false;
            }
        });
        cbS();
        this.hcv.setOnClickListener(this.hfa);
        this.heu = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.heB = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.heC = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.heD = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.heC.setIsRound(false);
        this.heC.setGifIconSupport(false);
        String cbW = cbW();
        this.heD.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(cbW)) {
            this.heC.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            l.a(this.heC, cbW, true, false);
            this.heD.setText(a.i.ala_live_change_cover);
            this.heH = cbW;
        }
        this.hcv.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hev = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.hev.setOnClickListener(this.hfa);
        this.hex = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.hex.setOnClickListener(this.hfa);
        this.hew = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.heY = (LinearLayout) this.mRootView.findViewById(a.g.prepare_opt_layout);
        this.hey = this.mRootView.findViewById(a.g.beauty_layout);
        this.hez = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.heA = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.hez.setOnClickListener(this.hfa);
        this.heA.setOnClickListener(this.hfa);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.heu.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.heu.setLayoutParams(layoutParams);
        }
        this.heV = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.heW = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.heX = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.heV.setOnClickListener(this.hfa);
        this.heJ = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.heJ.setOnClickListener(this.hfa);
        this.heS = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.heS.setOnClickListener(this.hfa);
        FL();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.heQ = true;
        ccu();
        ccv();
        this.enterTime = System.currentTimeMillis();
    }

    private o cct() {
        if (com.baidu.live.x.a.OS().blo == null || com.baidu.live.x.a.OS().blo.aLH == null) {
            return null;
        }
        return com.baidu.live.x.a.OS().blo.aLH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccu() {
        o cct = cct();
        if (cct != null && cct.aHQ != null && cct.aHQ.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.heT = cct.aHQ.get(this.heP % cct.aHQ.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.heT.getText());
            this.heV.setVisibility(0);
            this.heW.setText(sb);
            this.heP++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.heQ) {
                        c.this.ccu();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.heV.setVisibility(8);
    }

    private void ccv() {
        if (com.baidu.live.c.AZ().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.heV != null && this.heV.getVisibility() == 0) {
            com.baidu.live.c.AZ().putInt("live_assistant_guide_txt_show_counts", 1);
            this.heX.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void HI(String str) {
        com.baidu.live.c.AZ().putString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void FL() {
        this.heB.setOnClickListener(this.hfa);
        this.hew.setOnClickListener(this.heZ);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void ccb() {
        if (this.hcz != null) {
            this.hcz.bZD();
        }
    }

    public void bVO() {
        cbX();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int ccc() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean ccd() {
        return false;
    }

    public boolean bVM() {
        if (this.heK != null) {
            this.heK.cbD();
        }
        return this.heK != null && this.heK.bVM();
    }

    public void bVN() {
        if (this.heK != null) {
            this.heK.x(this.heH, getLiveTitle(), this.heM, this.heN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccw() {
        if (this.heI) {
            this.hew.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.hew.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccx() {
        this.heX.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.gDW == null) {
                this.gDW = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.heT != null && !TextUtils.isEmpty(this.heT.DH())) {
                this.gDW.GY(this.heT.DH());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, long j) {
        if (this.heR == null) {
            this.heR = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
            ((TextView) this.heR.findViewById(a.g.textView)).setText(str);
            if (this.mRootView != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (!c.this.heU && c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.heR != null) {
                            int[] iArr = new int[2];
                            c.this.hey.getLocationOnScreen(iArr);
                            c.this.heR.measure(0, 0);
                            int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                            int width = (iArr[0] + (c.this.hey.getWidth() / 2)) - (c.this.heR.getMeasuredWidth() / 2);
                            int measuredWidth = (i - width) - c.this.heR.getMeasuredWidth();
                            int measuredHeight = iArr[1] - c.this.heR.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = width;
                            layoutParams.rightMargin = measuredWidth;
                            layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
                            c.this.mRootView.addView(c.this.heR, layoutParams);
                        }
                    }
                }, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccy() {
        if (bh.c(com.baidu.live.x.a.OS().bqJ)) {
            this.hey.setVisibility(0);
            if (bh.c(com.baidu.live.x.a.OS().bqJ)) {
                this.hez.setAlpha(0.2f);
                this.heA.setAlpha(0.2f);
            }
        } else if (this.bya != null && this.bya.hasBeauty() < 0) {
            this.hey.setVisibility(8);
        } else {
            this.hey.setVisibility(0);
        }
    }

    public boolean bVI() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccz() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Hg(String str) {
        this.heG = true;
        this.heH = str;
        this.heD.setText(a.i.ala_live_change_cover);
        HI(str);
        l.a(this.heC, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bVL() {
        return cbW();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void b(AlaLiveRecorder alaLiveRecorder) {
        super.b(alaLiveRecorder);
        ccA();
        ccy();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a cbZ() {
        return this.gWL;
    }

    public void bVF() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.Op().d(2, 1, false));
    }

    private void ccA() {
        if (this.bya != null) {
            ccy();
            if (this.bya.isBackCamera()) {
                this.hew.setEnabled(true);
                this.hew.setVisibility(0);
                this.heI = this.bya.isFlashingLightOpen();
            } else {
                this.hew.setEnabled(false);
                this.hew.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bya != null) {
                        c.this.bya.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        ccb();
        if (this.heK != null && z) {
            this.heK.cbC();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bVQ() {
        return 1;
    }

    public void a(e.a aVar) {
        this.het = aVar;
    }

    public void onResume() {
        this.heE = false;
        if (this.bya != null) {
            if (this.bya.isBackCamera()) {
                this.hew.setEnabled(true);
                this.hew.setVisibility(0);
                this.heI = this.bya.isFlashingLightOpen();
                ccw();
            } else {
                this.hew.setEnabled(false);
                this.hew.setVisibility(4);
            }
        }
        if (this.hcw != null && this.hcw.ccG() && TextUtils.isEmpty(this.hcw.ccM())) {
            this.hcw.ccL();
        }
    }

    public void onRefresh() {
    }

    public void mF(boolean z) {
        this.hcv.setClickable(z);
    }

    public void release() {
        this.heQ = true;
        if (this.bya != null) {
            this.bya.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hfb);
        MessageManager.getInstance().unRegisterListener(this.gVL);
        MessageManager.getInstance().unRegisterListener(this.hfc);
        MessageManager.getInstance().unRegisterListener(this.hfd);
        if (this.heK != null) {
            this.heK.release();
        }
        if (this.gDW != null) {
            this.gDW.release();
            this.gDW = null;
        }
    }

    private void ccB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void ccC() {
        if (ah.DW()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccD() {
        if (ah.DW()) {
            this.heS.setVisibility(0);
            if (this.gWL != null && this.gWL.bLP() != null && !StringUtils.isNull(this.gWL.bLP().getName())) {
                this.heS.setText(this.gWL.bLP().getName());
                this.heS.setChecked(true);
                return;
            }
            this.heS.setText(a.i.ala_live_prepare_select_livetype);
            this.heS.setChecked(false);
            return;
        }
        this.heS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccE() {
        if (this.heO != null && this.heL != null && this.heL.size() > 0) {
            String str = this.heL.get(this.heO.nextInt(100) % this.heL.size());
            if (!TextUtils.isEmpty(str)) {
                this.hcq.clearFocus();
                this.hcq.setText(str);
            }
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.j.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a ca = aVar.ca(true);
            View rootLayout = ca.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            ca.setTargetView(this.hcv);
            this.heY.addView(rootLayout, 0);
            aVar.My();
        }
    }
}
