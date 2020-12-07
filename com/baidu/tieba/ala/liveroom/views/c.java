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
import com.baidu.live.data.AlaLivePerfBaseData;
import com.baidu.live.data.am;
import com.baidu.live.data.bm;
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
    private CustomMessageListener bAT;
    private int bwl;
    private TextView bzU;
    private long enterTime;
    private ImageView hFA;
    private ImageView hFB;
    private ImageView hFC;
    private View hFD;
    private ImageView hFE;
    private RoundRectRelativeLayout hFF;
    private TbImageView hFG;
    private TextView hFH;
    private boolean hFI;
    private String hFJ;
    private boolean hFK;
    private String hFL;
    private boolean hFM;
    private ImageView hFN;
    private com.baidu.tieba.ala.liveroom.share.d hFO;
    private List<String> hFP;
    private String hFQ;
    private String hFR;
    private Random hFS;
    private int hFT;
    private boolean hFU;
    protected View hFV;
    private CheckedTextView hFW;
    private k hFX;
    private boolean hFY;
    private Boolean hFZ;
    private e.a hFy;
    private LinearLayout hFz;
    private boolean hGa;
    AlaLivePerfBaseData hGb;
    private RelativeLayout hGc;
    private TextView hGd;
    private FrameLayout hGe;
    private LinearLayout hGf;
    private View.OnClickListener hGg;
    private View.OnClickListener hGh;
    private HttpMessageListener hGi;
    private CustomMessageListener hGj;
    private HttpMessageListener hGk;
    private CustomMessageListener hGl;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.activeview.b heP;
    private com.baidu.tieba.ala.category.b.a hxD;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hFI = false;
        this.hFK = false;
        this.hFM = false;
        this.hFT = 0;
        this.hFU = false;
        this.handler = new Handler();
        this.bwl = 0;
        this.hFY = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.ckV();
                c.this.hFM = z;
                c.this.clr();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.ckV();
                if (z) {
                    c.this.hFB.setEnabled(false);
                    c.this.hFB.setVisibility(4);
                    c.this.hFM = false;
                    c.this.clr();
                    return;
                }
                c.this.hFB.setEnabled(true);
                c.this.hFB.setVisibility(0);
                if (c.this.bya.isFlashingLightOpen()) {
                    c.this.hFM = true;
                    c.this.clr();
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
                    c.this.hFB.setEnabled(false);
                    c.this.hFB.setVisibility(4);
                } else {
                    c.this.hFB.setEnabled(true);
                    c.this.hFB.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hFM = c.this.bya.isFlashingLightOpen();
                    c.this.clr();
                }
                if (c.this.bya.hasBeauty() >= 0) {
                    c.this.bya.setBeauty(com.baidu.live.d.BM().getInt("live_beauty_level", 3));
                }
                c.this.Tm();
                if (!z && c.this.hFy != null) {
                    c.this.hFy.cir();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hFI) {
                    c.this.clt();
                    c.this.hFI = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hFy != null) {
                    c.this.hFy.cis();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
                c.this.hGb.sampleMemAndCPU();
                c.this.hGb.getCpuMemJsonFormat();
            }
        };
        this.hGb = new AlaLivePerfBaseData();
        this.hGg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bya != null) {
                        c.this.bya.switchFlashingLight();
                        c.this.hFM = c.this.bya.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.clr();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hGh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.ckV();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hDx != null) {
                                    c.this.hDx.cit();
                                    return;
                                }
                                return;
                            }
                            c.this.ckR();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hFI = true;
                        c.this.bya.stopRecord();
                        if (TextUtils.isEmpty(c.this.hFL)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bya != null) {
                                c.this.bya.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.f.ala_prepare_beauty || view.getId() == a.f.beauty_textView) {
                        c.this.hFY = true;
                        com.baidu.live.d.BM().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hDx != null) {
                            c.this.hDx.civ();
                        }
                        if (c.this.hGa) {
                            c.this.ol(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hFV != null && c.this.mRootView.indexOfChild(c.this.hFV) >= 0) {
                                    c.this.mRootView.removeView(c.this.hFV);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hDx != null) {
                            c.this.hDx.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.clz();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.cls();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hxD), com.baidu.tieba.ala.category.b.a.b(c.this.hxD))));
                    }
                }
            }
        };
        this.hGi = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hxV != null && livePrepareListHttpResponseMessage.hxV.size() > 0) {
                        c.this.hFP = new ArrayList(livePrepareListHttpResponseMessage.hxV);
                        c.this.clz();
                    } else {
                        c.this.hFP = new ArrayList();
                    }
                    c.this.hFQ = livePrepareListHttpResponseMessage.hxT;
                    c.this.hFR = livePrepareListHttpResponseMessage.hxU;
                }
            }
        };
        this.bAT = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aES != null) {
                    if (data.aES.aFb == 1) {
                        if (!c.this.hFY) {
                            c.this.z(data.aES.mText, 1500L);
                        } else {
                            return;
                        }
                    }
                    com.baidu.live.d.BM().putInt("beauty_new_bubble", data.aES.aFb);
                    com.baidu.live.d.BM().putInt("beauty_subitem_redot", data.aES.aFc);
                    com.baidu.live.d.BM().putInt("beauty_tab_redot", data.aES.aFd);
                }
            }
        };
        this.hGj = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
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
                if (fVar == null || !fVar.Dt()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage not show");
                    }
                } else if (c.this.hGa || c.this.clv()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hGa + ", tiped=" + c.this.clv());
                    }
                } else {
                    c.this.hGa = true;
                    c.this.z(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hGk = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hxD = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).ciW();
                    }
                    c.this.cly();
                }
            }
        };
        this.hGl = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hxD = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.cly();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.cly();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        clw();
        clx();
        MessageManager.getInstance().registerListener(this.hGi);
        MessageManager.getInstance().registerListener(this.bAT);
        MessageManager.getInstance().registerListener(this.hGj);
        MessageManager.getInstance().registerListener(this.hGk);
        MessageManager.getInstance().registerListener(this.hGl);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.hFS = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hFO = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hFO.l(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hFO.cs(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hFO = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hFO != null) {
            this.hFO.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hFJ = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.ckU();
                c.this.ckV();
                return false;
            }
        });
        ckM();
        this.hDt.setOnClickListener(this.hGh);
        this.hFz = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hFF = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hFG = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hFH = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hFG.setIsRound(false);
        this.hFG.setGifIconSupport(false);
        String ckQ = ckQ();
        this.hFH.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(ckQ)) {
            this.hFG.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            l.a(this.hFG, ckQ, true, false);
            this.hFH.setText(a.h.ala_live_change_cover);
            this.hFL = ckQ;
        }
        this.hDt.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hFA = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hFA.setOnClickListener(this.hGh);
        this.hFC = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hFC.setOnClickListener(this.hGh);
        this.hFB = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hGf = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hFD = this.mRootView.findViewById(a.f.beauty_layout);
        this.hFE = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bzU = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hFE.setOnClickListener(this.hGh);
        this.bzU.setOnClickListener(this.hGh);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hFz.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hFz.setLayoutParams(layoutParams);
        }
        this.hGc = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hGd = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hGe = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hGc.setOnClickListener(this.hGh);
        this.hFN = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hFN.setOnClickListener(this.hGh);
        this.hFW = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hFW.setOnClickListener(this.hGh);
        HH();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hFU = true;
        clp();
        clq();
        this.enterTime = System.currentTimeMillis();
    }

    private r clo() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOv == null) {
            return null;
        }
        return com.baidu.live.ae.a.RB().brA.aOv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clp() {
        r clo = clo();
        if (clo != null && clo.aKi != null && clo.aKi.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hFX = clo.aKi.get(this.hFT % clo.aKi.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hFX.getText());
            this.hGc.setVisibility(0);
            this.hGd.setText(sb);
            this.hFT++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hFU) {
                        c.this.clp();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hGc.setVisibility(8);
    }

    private void clq() {
        if (com.baidu.live.d.BM().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hGc != null && this.hGc.getVisibility() == 0) {
            com.baidu.live.d.BM().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hGe.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        super.destroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void IO(String str) {
        com.baidu.live.d.BM().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void HH() {
        this.hFF.setOnClickListener(this.hGh);
        this.hFB.setOnClickListener(this.hGg);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void ckV() {
        if (this.hDx != null) {
            this.hDx.ciw();
        }
    }

    public void ceD() {
        ckR();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int ckW() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean ckX() {
        return false;
    }

    public boolean ceB() {
        if (this.hFO != null) {
            this.hFO.ckx();
        }
        return this.hFO != null && this.hFO.ceB();
    }

    public void ceC() {
        if (this.hFO != null) {
            this.hFO.y(this.hFL, getLiveTitle(), this.hFQ, this.hFR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clr() {
        if (this.hFM) {
            this.hFB.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hFB.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        this.hGe.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.heP == null) {
                this.heP = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hFX != null && !TextUtils.isEmpty(this.hFX.Fk())) {
                this.heP.Id(this.hFX.Fk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.hFV != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hFV = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hFV.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hFV != null) {
                        int[] iArr = new int[2];
                        c.this.hFD.getLocationOnScreen(iArr);
                        c.this.hFV.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hFD.getWidth() / 2)) - (c.this.hFV.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hFV.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hFV.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hFV, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tm() {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            this.hFD.setVisibility(0);
            if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
                this.hFE.setAlpha(0.2f);
                this.bzU.setAlpha(0.2f);
            }
        } else if (this.bya != null && this.bya.hasBeauty() < 0) {
            this.hFD.setVisibility(8);
        } else {
            this.hFD.setVisibility(0);
        }
    }

    public boolean cex() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clt() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void In(String str) {
        this.hFK = true;
        this.hFL = str;
        this.hFH.setText(a.h.ala_live_change_cover);
        IO(str);
        l.a(this.hFG, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String ceA() {
        return ckQ();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        clu();
        Tm();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a ckT() {
        return this.hxD;
    }

    public void ceu() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.QY().d(2, 1, false));
    }

    private void clu() {
        if (this.bya != null) {
            Tm();
            if (this.bya.isBackCamera()) {
                this.hFB.setEnabled(true);
                this.hFB.setVisibility(0);
                this.hFM = this.bya.isFlashingLightOpen();
            } else {
                this.hFB.setEnabled(false);
                this.hFB.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
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
        ckV();
        if (this.hFO != null && z) {
            this.hFO.ckw();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int ceF() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hFy = aVar;
    }

    public void onResume() {
        this.hFI = false;
        if (this.bya != null) {
            if (this.bya.isBackCamera()) {
                this.hFB.setEnabled(true);
                this.hFB.setVisibility(0);
                this.hFM = this.bya.isFlashingLightOpen();
                clr();
            } else {
                this.hFB.setEnabled(false);
                this.hFB.setVisibility(4);
            }
        }
        if (this.hDu != null && this.hDu.clC() && TextUtils.isEmpty(this.hDu.clI())) {
            this.hDu.clH();
        }
        if (!clv()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clv() {
        if (this.hFZ == null) {
            this.hFZ = Boolean.valueOf(com.baidu.live.d.BM().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + clv());
            }
        }
        return this.hFZ.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(boolean z) {
        if (clv() != z) {
            this.hFZ = Boolean.valueOf(z);
            com.baidu.live.d.BM().putBoolean("makeup_new_bubble_tiped", this.hFZ.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hFZ);
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

    public void nA(boolean z) {
        this.hDt.setClickable(z);
    }

    public void release() {
        this.hFU = true;
        if (this.bya != null) {
            this.bya.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hGi);
        MessageManager.getInstance().unRegisterListener(this.bAT);
        MessageManager.getInstance().unRegisterListener(this.hGj);
        MessageManager.getInstance().unRegisterListener(this.hGk);
        MessageManager.getInstance().unRegisterListener(this.hGl);
        if (this.hFO != null) {
            this.hFO.release();
        }
        if (this.heP != null) {
            this.heP.release();
            this.heP = null;
        }
    }

    private void clw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void clx() {
        if (am.FD()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        if (am.FD()) {
            this.hFW.setVisibility(0);
            if (this.hxD != null && this.hxD.bTU() != null && !StringUtils.isNull(this.hxD.bTU().getName())) {
                this.hFW.setText(this.hxD.bTU().getName());
                this.hFW.setChecked(true);
                return;
            }
            this.hFW.setText(a.h.ala_live_prepare_select_livetype);
            this.hFW.setChecked(false);
            return;
        }
        this.hFW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clz() {
        if (this.hFS != null && this.hFP != null && this.hFP.size() > 0) {
            String str = this.hFP.get(this.hFS.nextInt(100) % this.hFP.size());
            if (!TextUtils.isEmpty(str)) {
                this.hDo.clearFocus();
                this.hDo.setText(str);
            }
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.m.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a ct = aVar.ct(true);
            View rootLayout = ct.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            ct.setTargetView(this.hDt);
            this.hGf.addView(rootLayout, 0);
            aVar.Pb();
        }
    }
}
