package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.live.adp.BdUniqueId;
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
import com.baidu.live.ar.f;
import com.baidu.live.data.al;
import com.baidu.live.data.bl;
import com.baidu.live.data.k;
import com.baidu.live.data.r;
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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends a {
    private int bsL;
    private TextView bwv;
    private CustomMessageListener bxu;
    private long enterTime;
    private com.baidu.tieba.ala.liveroom.activeview.b gVO;
    private Handler handler;
    private com.baidu.tieba.ala.category.b.a hos;
    private String hwA;
    private boolean hwB;
    private ImageView hwC;
    private com.baidu.tieba.ala.liveroom.share.d hwD;
    private List<String> hwE;
    private String hwF;
    private String hwG;
    private Random hwH;
    private int hwI;
    private boolean hwJ;
    protected View hwK;
    private CheckedTextView hwL;
    private k hwM;
    private boolean hwN;
    private Boolean hwO;
    private boolean hwP;
    private RelativeLayout hwQ;
    private TextView hwR;
    private FrameLayout hwS;
    private LinearLayout hwT;
    private View.OnClickListener hwU;
    private View.OnClickListener hwV;
    private HttpMessageListener hwW;
    private CustomMessageListener hwX;
    private HttpMessageListener hwY;
    private CustomMessageListener hwZ;
    private e.a hwn;
    private LinearLayout hwo;
    private ImageView hwp;
    private ImageView hwq;
    private ImageView hwr;
    private View hws;
    private ImageView hwt;
    private RoundRectRelativeLayout hwu;
    private TbImageView hwv;
    private TextView hww;
    private boolean hwx;
    private String hwy;
    private boolean hwz;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hwx = false;
        this.hwz = false;
        this.hwB = false;
        this.hwI = 0;
        this.hwJ = false;
        this.handler = new Handler();
        this.bsL = 0;
        this.hwN = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.chI();
                c.this.hwB = z;
                c.this.cid();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.chI();
                if (z) {
                    c.this.hwq.setEnabled(false);
                    c.this.hwq.setVisibility(4);
                    c.this.hwB = false;
                    c.this.cid();
                    return;
                }
                c.this.hwq.setEnabled(true);
                c.this.hwq.setVisibility(0);
                if (c.this.buC.isFlashingLightOpen()) {
                    c.this.hwB = true;
                    c.this.cid();
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
                boolean isBackCamera = c.this.buC.isBackCamera();
                if (!isBackCamera) {
                    c.this.hwq.setEnabled(false);
                    c.this.hwq.setVisibility(4);
                } else {
                    c.this.hwq.setEnabled(true);
                    c.this.hwq.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hwB = c.this.buC.isFlashingLightOpen();
                    c.this.cid();
                }
                if (c.this.buC.hasBeauty() >= 0) {
                    c.this.buC.setBeauty(com.baidu.live.d.AZ().getInt("live_beauty_level", 3));
                }
                c.this.Rx();
                if (!z && c.this.hwn != null) {
                    c.this.hwn.cfd();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hwx) {
                    c.this.cif();
                    c.this.hwx = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hwn != null) {
                    c.this.hwn.cfe();
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
        this.hwU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.buC != null) {
                        c.this.buC.switchFlashingLight();
                        c.this.hwB = c.this.buC.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.cid();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hwV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.chI();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hun != null) {
                                    c.this.hun.cff();
                                    return;
                                }
                                return;
                            }
                            c.this.chE();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hwx = true;
                        c.this.buC.stopRecord();
                        if (TextUtils.isEmpty(c.this.hwA)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.buC != null) {
                                c.this.buC.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_beauty || view.getId() == a.f.beauty_textView) {
                        c.this.hwN = true;
                        com.baidu.live.d.AZ().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hun != null) {
                            c.this.hun.cfh();
                        }
                        if (c.this.hwP) {
                            c.this.nP(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hwK != null && c.this.mRootView.indexOfChild(c.this.hwK) >= 0) {
                                    c.this.mRootView.removeView(c.this.hwK);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hun != null) {
                            c.this.hun.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.cil();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.cie();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hos), com.baidu.tieba.ala.category.b.a.b(c.this.hos))));
                    }
                }
            }
        };
        this.hwW = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hoK != null && livePrepareListHttpResponseMessage.hoK.size() > 0) {
                        c.this.hwE = new ArrayList(livePrepareListHttpResponseMessage.hoK);
                        c.this.cil();
                    } else {
                        c.this.hwE = new ArrayList();
                    }
                    c.this.hwF = livePrepareListHttpResponseMessage.hoI;
                    c.this.hwG = livePrepareListHttpResponseMessage.hoJ;
                }
            }
        };
        this.bxu = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aDX != null) {
                    if (data.aDX.aEg == 1) {
                        if (!c.this.hwN) {
                            c.this.z(data.aDX.mText, 1500L);
                        } else {
                            return;
                        }
                    }
                    com.baidu.live.d.AZ().putInt("beauty_new_bubble", data.aDX.aEg);
                    com.baidu.live.d.AZ().putInt("beauty_subitem_redot", data.aDX.aEh);
                    com.baidu.live.d.AZ().putInt("beauty_tab_redot", data.aDX.aEi);
                }
            }
        };
        this.hwX = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.isDebug()) {
                    c.this.d("onMessage ..." + customResponsedMessage);
                }
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f)) {
                    if (c.isDebug()) {
                        c.this.d("onMessage null");
                        return;
                    }
                    return;
                }
                f fVar = (f) customResponsedMessage.getData();
                if (fVar == null || !fVar.Cs()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage not show");
                    }
                } else if (c.this.hwP || c.this.cih()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hwP + ", tiped=" + c.this.cih());
                    }
                } else {
                    c.this.hwP = true;
                    c.this.z(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hwY = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hos = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).cfJ();
                    }
                    c.this.cik();
                }
            }
        };
        this.hwZ = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hos = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.cik();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.cik();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        cii();
        cij();
        MessageManager.getInstance().registerListener(this.hwW);
        MessageManager.getInstance().registerListener(this.bxu);
        MessageManager.getInstance().registerListener(this.hwX);
        MessageManager.getInstance().registerListener(this.hwY);
        MessageManager.getInstance().registerListener(this.hwZ);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.hwH = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hwD = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hwD.p(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hwD.ci(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hwD = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hwD != null) {
            this.hwD.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hwy = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.chH();
                c.this.chI();
                return false;
            }
        });
        chz();
        this.huj.setOnClickListener(this.hwV);
        this.hwo = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hwu = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hwv = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hww = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hwv.setIsRound(false);
        this.hwv.setGifIconSupport(false);
        String chD = chD();
        this.hww.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(chD)) {
            this.hwv.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            l.a(this.hwv, chD, true, false);
            this.hww.setText(a.h.ala_live_change_cover);
            this.hwA = chD;
        }
        this.huj.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hwp = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hwp.setOnClickListener(this.hwV);
        this.hwr = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hwr.setOnClickListener(this.hwV);
        this.hwq = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hwT = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hws = this.mRootView.findViewById(a.f.beauty_layout);
        this.hwt = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bwv = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hwt.setOnClickListener(this.hwV);
        this.bwv.setOnClickListener(this.hwV);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hwo.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hwo.setLayoutParams(layoutParams);
        }
        this.hwQ = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hwR = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hwS = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hwQ.setOnClickListener(this.hwV);
        this.hwC = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hwC.setOnClickListener(this.hwV);
        this.hwL = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hwL.setOnClickListener(this.hwV);
        GB();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hwJ = true;
        cib();
        cic();
        this.enterTime = System.currentTimeMillis();
    }

    private r cia() {
        if (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNl == null) {
            return null;
        }
        return com.baidu.live.aa.a.PQ().bod.aNl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cib() {
        r cia = cia();
        if (cia != null && cia.aJi != null && cia.aJi.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hwM = cia.aJi.get(this.hwI % cia.aJi.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hwM.getText());
            this.hwQ.setVisibility(0);
            this.hwR.setText(sb);
            this.hwI++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hwJ) {
                        c.this.cib();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hwQ.setVisibility(8);
    }

    private void cic() {
        if (com.baidu.live.d.AZ().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hwQ != null && this.hwQ.getVisibility() == 0) {
            com.baidu.live.d.AZ().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hwS.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Iy(String str) {
        com.baidu.live.d.AZ().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void GB() {
        this.hwu.setOnClickListener(this.hwV);
        this.hwq.setOnClickListener(this.hwU);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void chI() {
        if (this.hun != null) {
            this.hun.cfi();
        }
    }

    public void cbp() {
        chE();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int chJ() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean chK() {
        return false;
    }

    public boolean cbn() {
        if (this.hwD != null) {
            this.hwD.chk();
        }
        return this.hwD != null && this.hwD.cbn();
    }

    public void cbo() {
        if (this.hwD != null) {
            this.hwD.y(this.hwA, getLiveTitle(), this.hwF, this.hwG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cid() {
        if (this.hwB) {
            this.hwq.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hwq.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cie() {
        this.hwS.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.gVO == null) {
                this.gVO = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hwM != null && !TextUtils.isEmpty(this.hwM.Ei())) {
                this.gVO.HO(this.hwM.Ei());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.hwK != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hwK = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hwK.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hwK != null) {
                        int[] iArr = new int[2];
                        c.this.hws.getLocationOnScreen(iArr);
                        c.this.hwK.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hws.getWidth() / 2)) - (c.this.hwK.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hwK.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hwK.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hwK, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rx() {
        if (bl.c(com.baidu.live.aa.a.PQ().btT)) {
            this.hws.setVisibility(0);
            if (bl.c(com.baidu.live.aa.a.PQ().btT)) {
                this.hwt.setAlpha(0.2f);
                this.bwv.setAlpha(0.2f);
            }
        } else if (this.buC != null && this.buC.hasBeauty() < 0) {
            this.hws.setVisibility(8);
        } else {
            this.hws.setVisibility(0);
        }
    }

    public boolean cbj() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cif() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HX(String str) {
        this.hwz = true;
        this.hwA = str;
        this.hww.setText(a.h.ala_live_change_cover);
        Iy(str);
        l.a(this.hwv, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String cbm() {
        return chD();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        cig();
        Rx();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a chG() {
        return this.hos;
    }

    public void cbg() {
        this.buC.setVideoConfig(LiveRecorderConfigHelper.Pn().d(2, 1, false));
    }

    private void cig() {
        if (this.buC != null) {
            Rx();
            if (this.buC.isBackCamera()) {
                this.hwq.setEnabled(true);
                this.hwq.setVisibility(0);
                this.hwB = this.buC.isFlashingLightOpen();
            } else {
                this.hwq.setEnabled(false);
                this.hwq.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.buC != null) {
                        c.this.buC.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        chI();
        if (this.hwD != null && z) {
            this.hwD.chj();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int cbr() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hwn = aVar;
    }

    public void onResume() {
        this.hwx = false;
        if (this.buC != null) {
            if (this.buC.isBackCamera()) {
                this.hwq.setEnabled(true);
                this.hwq.setVisibility(0);
                this.hwB = this.buC.isFlashingLightOpen();
                cid();
            } else {
                this.hwq.setEnabled(false);
                this.hwq.setVisibility(4);
            }
        }
        if (this.huk != null && this.huk.cio() && TextUtils.isEmpty(this.huk.ciu())) {
            this.huk.cit();
        }
        if (!cih()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cih() {
        if (this.hwO == null) {
            this.hwO = Boolean.valueOf(com.baidu.live.d.AZ().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + cih());
            }
        }
        return this.hwO.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(boolean z) {
        if (cih() != z) {
            this.hwO = Boolean.valueOf(z);
            com.baidu.live.d.AZ().putBoolean("makeup_new_bubble_tiped", this.hwO.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hwO);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        CustomMessage customMessage = new CustomMessage(2913246);
        customMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(customMessage);
        if (isDebug()) {
            d("requestMakeupData sendMessage ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Log.d("getMakeupData_ComView", str);
    }

    public void onRefresh() {
    }

    public void ne(boolean z) {
        this.huj.setClickable(z);
    }

    public void release() {
        this.hwJ = true;
        if (this.buC != null) {
            this.buC.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hwW);
        MessageManager.getInstance().unRegisterListener(this.bxu);
        MessageManager.getInstance().unRegisterListener(this.hwX);
        MessageManager.getInstance().unRegisterListener(this.hwY);
        MessageManager.getInstance().unRegisterListener(this.hwZ);
        if (this.hwD != null) {
            this.hwD.release();
        }
        if (this.gVO != null) {
            this.gVO.release();
            this.gVO = null;
        }
    }

    private void cii() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cij() {
        if (al.EB()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cik() {
        if (al.EB()) {
            this.hwL.setVisibility(0);
            if (this.hos != null && this.hos.bQR() != null && !StringUtils.isNull(this.hos.bQR().getName())) {
                this.hwL.setText(this.hos.bQR().getName());
                this.hwL.setChecked(true);
                return;
            }
            this.hwL.setText(a.h.ala_live_prepare_select_livetype);
            this.hwL.setChecked(false);
            return;
        }
        this.hwL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cil() {
        if (this.hwH != null && this.hwE != null && this.hwE.size() > 0) {
            String str = this.hwE.get(this.hwH.nextInt(100) % this.hwE.size());
            if (!TextUtils.isEmpty(str)) {
                this.hue.clearFocus();
                this.hue.setText(str);
            }
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.k.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a cd = aVar.cd(true);
            View rootLayout = cd.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            cd.setTargetView(this.huj);
            this.hwT.addView(rootLayout, 0);
            aVar.Ns();
        }
    }
}
