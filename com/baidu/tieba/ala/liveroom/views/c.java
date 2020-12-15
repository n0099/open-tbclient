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
    private e.a hFA;
    private LinearLayout hFB;
    private ImageView hFC;
    private ImageView hFD;
    private ImageView hFE;
    private View hFF;
    private ImageView hFG;
    private RoundRectRelativeLayout hFH;
    private TbImageView hFI;
    private TextView hFJ;
    private boolean hFK;
    private String hFL;
    private boolean hFM;
    private String hFN;
    private boolean hFO;
    private ImageView hFP;
    private com.baidu.tieba.ala.liveroom.share.d hFQ;
    private List<String> hFR;
    private String hFS;
    private String hFT;
    private Random hFU;
    private int hFV;
    private boolean hFW;
    protected View hFX;
    private CheckedTextView hFY;
    private k hFZ;
    private boolean hGa;
    private Boolean hGb;
    private boolean hGc;
    AlaLivePerfBaseData hGd;
    private RelativeLayout hGe;
    private TextView hGf;
    private FrameLayout hGg;
    private LinearLayout hGh;
    private View.OnClickListener hGi;
    private View.OnClickListener hGj;
    private HttpMessageListener hGk;
    private CustomMessageListener hGl;
    private HttpMessageListener hGm;
    private CustomMessageListener hGn;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.activeview.b heR;
    private com.baidu.tieba.ala.category.b.a hxF;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hFK = false;
        this.hFM = false;
        this.hFO = false;
        this.hFV = 0;
        this.hFW = false;
        this.handler = new Handler();
        this.bwl = 0;
        this.hGa = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.ckW();
                c.this.hFO = z;
                c.this.cls();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.ckW();
                if (z) {
                    c.this.hFD.setEnabled(false);
                    c.this.hFD.setVisibility(4);
                    c.this.hFO = false;
                    c.this.cls();
                    return;
                }
                c.this.hFD.setEnabled(true);
                c.this.hFD.setVisibility(0);
                if (c.this.bya.isFlashingLightOpen()) {
                    c.this.hFO = true;
                    c.this.cls();
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
                    c.this.hFD.setEnabled(false);
                    c.this.hFD.setVisibility(4);
                } else {
                    c.this.hFD.setEnabled(true);
                    c.this.hFD.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hFO = c.this.bya.isFlashingLightOpen();
                    c.this.cls();
                }
                if (c.this.bya.hasBeauty() >= 0) {
                    c.this.bya.setBeauty(com.baidu.live.d.BM().getInt("live_beauty_level", 3));
                }
                c.this.Tm();
                if (!z && c.this.hFA != null) {
                    c.this.hFA.cis();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hFK) {
                    c.this.clu();
                    c.this.hFK = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hFA != null) {
                    c.this.hFA.cit();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
                c.this.hGd.sampleMemAndCPU();
                c.this.hGd.getCpuMemJsonFormat();
            }
        };
        this.hGd = new AlaLivePerfBaseData();
        this.hGi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bya != null) {
                        c.this.bya.switchFlashingLight();
                        c.this.hFO = c.this.bya.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.cls();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hGj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.ckW();
                    if (view.getId() == a.f.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hDz != null) {
                                    c.this.hDz.ciu();
                                    return;
                                }
                                return;
                            }
                            c.this.ckS();
                        }
                    } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hFK = true;
                        c.this.bya.stopRecord();
                        if (TextUtils.isEmpty(c.this.hFN)) {
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
                        c.this.hGa = true;
                        com.baidu.live.d.BM().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hDz != null) {
                            c.this.hDz.ciw();
                        }
                        if (c.this.hGc) {
                            c.this.ol(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hFX != null && c.this.mRootView.indexOfChild(c.this.hFX) >= 0) {
                                    c.this.mRootView.removeView(c.this.hFX);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.f.ala_prepare_close) {
                        if (c.this.hDz != null) {
                            c.this.hDz.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.f.ala_prepare_exchange_title) {
                        c.this.clA();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.f.ala_live_assistant_txt_layout) {
                        c.this.clt();
                    } else if (view.getId() == a.f.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hxF), com.baidu.tieba.ala.category.b.a.b(c.this.hxF))));
                    }
                }
            }
        };
        this.hGk = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hxX != null && livePrepareListHttpResponseMessage.hxX.size() > 0) {
                        c.this.hFR = new ArrayList(livePrepareListHttpResponseMessage.hxX);
                        c.this.clA();
                    } else {
                        c.this.hFR = new ArrayList();
                    }
                    c.this.hFS = livePrepareListHttpResponseMessage.hxV;
                    c.this.hFT = livePrepareListHttpResponseMessage.hxW;
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
                        if (!c.this.hGa) {
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
        this.hGl = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
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
                } else if (c.this.hGc || c.this.clw()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hGc + ", tiped=" + c.this.clw());
                    }
                } else {
                    c.this.hGc = true;
                    c.this.z(c.this.mPageContext.getPageActivity().getResources().getString(a.h.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hGm = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hxF = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).ciX();
                    }
                    c.this.clz();
                }
            }
        };
        this.hGn = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hxF = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.clz();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.clz();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        clx();
        cly();
        MessageManager.getInstance().registerListener(this.hGk);
        MessageManager.getInstance().registerListener(this.bAT);
        MessageManager.getInstance().registerListener(this.hGl);
        MessageManager.getInstance().registerListener(this.hGm);
        MessageManager.getInstance().registerListener(this.hGn);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.hFU = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            this.hFQ = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hFQ.l(this.mRootView);
            this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(0);
            this.hFQ.cs(this.mRootView.findViewById(a.f.ala_prepare_share_layout));
            return;
        }
        this.hFQ = null;
        this.mRootView.findViewById(a.f.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hFQ != null) {
            this.hFQ.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hFL = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.ckV();
                c.this.ckW();
                return false;
            }
        });
        ckN();
        this.hDv.setOnClickListener(this.hGj);
        this.hFB = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_top_opt_layout);
        this.hFH = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hFI = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hFJ = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hFI.setIsRound(false);
        this.hFI.setGifIconSupport(false);
        String ckR = ckR();
        this.hFJ.setText(a.h.hk_live_change_cover);
        if (TextUtils.isEmpty(ckR)) {
            this.hFI.setDefaultResource(a.e.hk_icon_default_cover);
        } else {
            l.a(this.hFI, ckR, true, false);
            this.hFJ.setText(a.h.ala_live_change_cover);
            this.hFN = ckR;
        }
        this.hDv.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hFC = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hFC.setOnClickListener(this.hGj);
        this.hFE = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_camera);
        this.hFE.setOnClickListener(this.hGj);
        this.hFD = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_light_switch);
        this.hGh = (LinearLayout) this.mRootView.findViewById(a.f.prepare_opt_layout);
        this.hFF = this.mRootView.findViewById(a.f.beauty_layout);
        this.hFG = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_beauty);
        this.bzU = (TextView) this.mRootView.findViewById(a.f.beauty_textView);
        this.hFG.setOnClickListener(this.hGj);
        this.bzU.setOnClickListener(this.hGj);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hFB.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hFB.setLayoutParams(layoutParams);
        }
        this.hGe = (RelativeLayout) this.mRootView.findViewById(a.f.ala_live_assistant_txt_layout);
        this.hGf = (TextView) this.mRootView.findViewById(a.f.ala_live_assistant_txt);
        this.hGg = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_guide_remind_layout);
        this.hGe.setOnClickListener(this.hGj);
        this.hFP = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_exchange_title);
        this.hFP.setOnClickListener(this.hGj);
        this.hFY = (CheckedTextView) this.mRootView.findViewById(a.f.ala_live_prepare_live_category_txt);
        this.hFY.setOnClickListener(this.hGj);
        HH();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hFW = true;
        clq();
        clr();
        this.enterTime = System.currentTimeMillis();
    }

    private r clp() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOv == null) {
            return null;
        }
        return com.baidu.live.ae.a.RB().brA.aOv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clq() {
        r clp = clp();
        if (clp != null && clp.aKi != null && clp.aKi.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hFZ = clp.aKi.get(this.hFV % clp.aKi.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.h.ala_live_assistant));
            sb.append(this.hFZ.getText());
            this.hGe.setVisibility(0);
            this.hGf.setText(sb);
            this.hFV++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hFW) {
                        c.this.clq();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hGe.setVisibility(8);
    }

    private void clr() {
        if (com.baidu.live.d.BM().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hGe != null && this.hGe.getVisibility() == 0) {
            com.baidu.live.d.BM().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hGg.setVisibility(0);
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
        this.hFH.setOnClickListener(this.hGj);
        this.hFD.setOnClickListener(this.hGi);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void ckW() {
        if (this.hDz != null) {
            this.hDz.cix();
        }
    }

    public void ceE() {
        ckS();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int ckX() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean ckY() {
        return false;
    }

    public boolean ceC() {
        if (this.hFQ != null) {
            this.hFQ.cky();
        }
        return this.hFQ != null && this.hFQ.ceC();
    }

    public void ceD() {
        if (this.hFQ != null) {
            this.hFQ.y(this.hFN, getLiveTitle(), this.hFS, this.hFT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        if (this.hFO) {
            this.hFD.setImageResource(a.e.btn_live_anchor_light_switch_on);
        } else {
            this.hFD.setImageResource(a.e.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clt() {
        this.hGg.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.heR == null) {
                this.heR = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hFZ != null && !TextUtils.isEmpty(this.hFZ.Fk())) {
                this.heR.Id(this.hFZ.Fk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.hFX != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hFX = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hFX.findViewById(a.f.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hFX != null) {
                        int[] iArr = new int[2];
                        c.this.hFF.getLocationOnScreen(iArr);
                        c.this.hFX.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hFF.getWidth() / 2)) - (c.this.hFX.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hFX.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hFX.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                        c.this.mRootView.addView(c.this.hFX, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tm() {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            this.hFF.setVisibility(0);
            if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
                this.hFG.setAlpha(0.2f);
                this.bzU.setAlpha(0.2f);
            }
        } else if (this.bya != null && this.bya.hasBeauty() < 0) {
            this.hFF.setVisibility(8);
        } else {
            this.hFF.setVisibility(0);
        }
    }

    public boolean cey() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clu() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void In(String str) {
        this.hFM = true;
        this.hFN = str;
        this.hFJ.setText(a.h.ala_live_change_cover);
        IO(str);
        l.a(this.hFI, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String ceB() {
        return ckR();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void c(AlaLiveRecorder alaLiveRecorder) {
        super.c(alaLiveRecorder);
        clv();
        Tm();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a ckU() {
        return this.hxF;
    }

    public void cev() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.QY().d(2, 1, false));
    }

    private void clv() {
        if (this.bya != null) {
            Tm();
            if (this.bya.isBackCamera()) {
                this.hFD.setEnabled(true);
                this.hFD.setVisibility(0);
                this.hFO = this.bya.isFlashingLightOpen();
            } else {
                this.hFD.setEnabled(false);
                this.hFD.setVisibility(4);
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
        ckW();
        if (this.hFQ != null && z) {
            this.hFQ.ckx();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int ceG() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hFA = aVar;
    }

    public void onResume() {
        this.hFK = false;
        if (this.bya != null) {
            if (this.bya.isBackCamera()) {
                this.hFD.setEnabled(true);
                this.hFD.setVisibility(0);
                this.hFO = this.bya.isFlashingLightOpen();
                cls();
            } else {
                this.hFD.setEnabled(false);
                this.hFD.setVisibility(4);
            }
        }
        if (this.hDw != null && this.hDw.clD() && TextUtils.isEmpty(this.hDw.clJ())) {
            this.hDw.clI();
        }
        if (!clw()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clw() {
        if (this.hGb == null) {
            this.hGb = Boolean.valueOf(com.baidu.live.d.BM().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + clw());
            }
        }
        return this.hGb.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(boolean z) {
        if (clw() != z) {
            this.hGb = Boolean.valueOf(z);
            com.baidu.live.d.BM().putBoolean("makeup_new_bubble_tiped", this.hGb.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hGb);
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
        this.hDv.setClickable(z);
    }

    public void release() {
        this.hFW = true;
        if (this.bya != null) {
            this.bya.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hGk);
        MessageManager.getInstance().unRegisterListener(this.bAT);
        MessageManager.getInstance().unRegisterListener(this.hGl);
        MessageManager.getInstance().unRegisterListener(this.hGm);
        MessageManager.getInstance().unRegisterListener(this.hGn);
        if (this.hFQ != null) {
            this.hFQ.release();
        }
        if (this.heR != null) {
            this.heR.release();
            this.heR = null;
        }
    }

    private void clx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cly() {
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
    public void clz() {
        if (am.FD()) {
            this.hFY.setVisibility(0);
            if (this.hxF != null && this.hxF.bTV() != null && !StringUtils.isNull(this.hxF.bTV().getName())) {
                this.hFY.setText(this.hxF.bTV().getName());
                this.hFY.setChecked(true);
                return;
            }
            this.hFY.setText(a.h.ala_live_prepare_select_livetype);
            this.hFY.setChecked(false);
            return;
        }
        this.hFY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clA() {
        if (this.hFU != null && this.hFR != null && this.hFR.size() > 0) {
            String str = this.hFR.get(this.hFU.nextInt(100) % this.hFR.size());
            if (!TextUtils.isEmpty(str)) {
                this.hDq.clearFocus();
                this.hDq.setText(str);
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
            ct.setTargetView(this.hDv);
            this.hGh.addView(rootLayout, 0);
            aVar.Pb();
        }
    }
}
