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
import com.baidu.live.data.ak;
import com.baidu.live.data.bk;
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
    private int brs;
    private long enterTime;
    private com.baidu.tieba.ala.liveroom.activeview.b gPK;
    private Handler handler;
    private CustomMessageListener hhA;
    private com.baidu.tieba.ala.category.b.a hiB;
    private boolean hqA;
    private String hqB;
    private boolean hqC;
    private String hqD;
    private boolean hqE;
    private ImageView hqF;
    private com.baidu.tieba.ala.liveroom.share.d hqG;
    private List<String> hqH;
    private String hqI;
    private String hqJ;
    private Random hqK;
    private int hqL;
    private boolean hqM;
    protected View hqN;
    private CheckedTextView hqO;
    private k hqP;
    private boolean hqQ;
    private Boolean hqR;
    private boolean hqS;
    private RelativeLayout hqT;
    private TextView hqU;
    private FrameLayout hqV;
    private LinearLayout hqW;
    private View.OnClickListener hqX;
    private View.OnClickListener hqY;
    private HttpMessageListener hqZ;
    private e.a hqp;
    private LinearLayout hqq;
    private ImageView hqr;
    private ImageView hqs;
    private ImageView hqt;
    private View hqu;
    private ImageView hqv;
    private TextView hqw;
    private RoundRectRelativeLayout hqx;
    private TbImageView hqy;
    private TextView hqz;
    private CustomMessageListener hra;
    private HttpMessageListener hrb;
    private CustomMessageListener hrc;
    private long lastClickTime;
    private Handler mHandler;
    private RecorderCallback mRecorderCallback;
    private TbPageContext mTbPageContext;
    private HttpMessageListener syncListener;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hqA = false;
        this.hqC = false;
        this.hqE = false;
        this.hqL = 0;
        this.hqM = false;
        this.handler = new Handler();
        this.brs = 0;
        this.hqQ = false;
        this.lastClickTime = 0L;
        this.enterTime = 0L;
        this.mRecorderCallback = new RecorderCallback() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                c.this.cff();
                c.this.hqE = z;
                c.this.cfA();
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                c.this.cff();
                if (z) {
                    c.this.hqs.setEnabled(false);
                    c.this.hqs.setVisibility(4);
                    c.this.hqE = false;
                    c.this.cfA();
                    return;
                }
                c.this.hqs.setEnabled(true);
                c.this.hqs.setVisibility(0);
                if (c.this.bAW.isFlashingLightOpen()) {
                    c.this.hqE = true;
                    c.this.cfA();
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
                boolean isBackCamera = c.this.bAW.isBackCamera();
                if (!isBackCamera) {
                    c.this.hqs.setEnabled(false);
                    c.this.hqs.setVisibility(4);
                } else {
                    c.this.hqs.setEnabled(true);
                    c.this.hqs.setVisibility(0);
                }
                if (isBackCamera) {
                    c.this.hqE = c.this.bAW.isFlashingLightOpen();
                    c.this.cfA();
                }
                if (c.this.bAW.hasBeauty() >= 0) {
                    c.this.bAW.setBeauty(com.baidu.live.d.AZ().getInt("live_beauty_level", 3));
                }
                c.this.cfC();
                if (!z && c.this.hqp != null) {
                    c.this.hqp.ccC();
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (c.this.hqA) {
                    c.this.cfD();
                    c.this.hqA = false;
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!z && c.this.hqp != null) {
                    c.this.hqp.ccD();
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
        this.hqX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    if (c.this.bAW != null) {
                        c.this.bAW.switchFlashingLight();
                        c.this.hqE = c.this.bAW.isFlashingLightOpen();
                    }
                    TiebaInitialize.log(new StatisticItem("c11879").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    c.this.cfA();
                    LogManager.getLiveRecordLogger().doClickLiveSplashButtonLog("");
                }
            }
        };
        this.hqY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.lastClickTime >= 300) {
                    c.this.lastClickTime = currentTimeMillis;
                    c.this.cff();
                    if (view.getId() == a.g.ala_live_prepare_start) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_START_LIVE_BTN));
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "livestart_clk").setContentExt(new JSONObject()));
                        LogManager.getLiveRecordLogger().doClickLiveRecordStartButtonLog("");
                        if (!UtilHelper.isFastDoubleClick()) {
                            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                                if (c.this.hop != null) {
                                    c.this.hop.ccE();
                                    return;
                                }
                                return;
                            }
                            c.this.cfb();
                        }
                    } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                        TiebaInitialize.log(new StatisticItem("c11867").param("uid", TbadkCoreApplication.getCurrentAccount()));
                        c.this.hqA = true;
                        c.this.bAW.stopRecord();
                        if (TextUtils.isEmpty(c.this.hqD)) {
                            LogManager.getLiveRecordLogger().doClickLiveAddCoverButtonLog("");
                        } else {
                            LogManager.getLiveRecordLogger().doClickLiveChangeCoverButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_exchange_camera) {
                        if (currentTimeMillis - c.this.enterTime >= 900) {
                            if (c.this.bAW != null) {
                                c.this.bAW.switchCamera();
                                TiebaInitialize.log(new StatisticItem("c11878").param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            LogManager.getLiveRecordLogger().doClickLiveCameraFlipButtonLog("");
                        }
                    } else if (view.getId() == a.g.ala_prepare_beauty || view.getId() == a.g.beauty_textView) {
                        c.this.hqQ = true;
                        com.baidu.live.d.AZ().putInt("beauty_new_bubble", 0);
                        TiebaInitialize.log(new StatisticItem("c11983"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "beauty"));
                        if (c.this.hop != null) {
                            c.this.hop.ccG();
                        }
                        if (c.this.hqS) {
                            c.this.nG(true);
                        }
                        LogManager.getLiveRecordLogger().doClickLiveBeautyButtonLog("");
                        c.this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.mRootView != null && c.this.hqN != null && c.this.mRootView.indexOfChild(c.this.hqN) >= 0) {
                                    c.this.mRootView.removeView(c.this.hqN);
                                }
                            }
                        }, 300L);
                    } else if (view.getId() == a.g.ala_prepare_close) {
                        if (c.this.hop != null) {
                            c.this.hop.onCloseClicked();
                        }
                        LogManager.getLiveRecordLogger().doClickLiveRecordCloseButtonLog("");
                    } else if (view.getId() == a.g.ala_prepare_exchange_title) {
                        c.this.cfJ();
                        LogManager.getLiveRecordLogger().doClickLiveChangeTitleButtonLog("");
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "title_random"));
                    } else if (view.getId() == a.g.ala_live_assistant_txt_layout) {
                        c.this.cfB();
                    } else if (view.getId() == a.g.ala_live_prepare_live_category_txt) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveCategoryActivityConfig(c.this.mPageContext.getPageActivity(), com.baidu.tieba.ala.category.b.a.a(c.this.hiB), com.baidu.tieba.ala.category.b.a.b(c.this.hiB))));
                    }
                }
            }
        };
        this.hqZ = new HttpMessageListener(1021147) { // from class: com.baidu.tieba.ala.liveroom.views.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LivePrepareListHttpResponseMessage) {
                    LivePrepareListHttpResponseMessage livePrepareListHttpResponseMessage = (LivePrepareListHttpResponseMessage) httpResponsedMessage;
                    if (livePrepareListHttpResponseMessage.hiT != null && livePrepareListHttpResponseMessage.hiT.size() > 0) {
                        c.this.hqH = new ArrayList(livePrepareListHttpResponseMessage.hiT);
                        c.this.cfJ();
                    } else {
                        c.this.hqH = new ArrayList();
                    }
                    c.this.hqI = livePrepareListHttpResponseMessage.hiR;
                    c.this.hqJ = livePrepareListHttpResponseMessage.hiS;
                }
            }
        };
        this.hhA = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.views.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaFilterAndBeautyData data;
                if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage) && (data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData()) != null && data.aDq != null) {
                    if (data.aDq.aDz == 1) {
                        if (!c.this.hqQ) {
                            c.this.z(data.aDq.mText, 1500L);
                        } else {
                            return;
                        }
                    }
                    com.baidu.live.d.AZ().putInt("beauty_new_bubble", data.aDq.aDz);
                    com.baidu.live.d.AZ().putInt("beauty_subitem_redot", data.aDq.aDA);
                    com.baidu.live.d.AZ().putInt("beauty_tab_redot", data.aDq.aDB);
                }
            }
        };
        this.hra = new CustomMessageListener(2913246) { // from class: com.baidu.tieba.ala.liveroom.views.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.isDebug()) {
                    c.this.d("onMessage ..." + customResponsedMessage);
                }
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ar.e)) {
                    if (c.isDebug()) {
                        c.this.d("onMessage null");
                        return;
                    }
                    return;
                }
                com.baidu.live.ar.e eVar = (com.baidu.live.ar.e) customResponsedMessage.getData();
                if (eVar == null || !eVar.Ca()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage not show");
                    }
                } else if (c.this.hqS || c.this.cfF()) {
                    if (c.isDebug()) {
                        c.this.d("onMessage isShowing=" + c.this.hqS + ", tiped=" + c.this.cfF());
                    }
                } else {
                    c.this.hqS = true;
                    c.this.z(c.this.mPageContext.getPageActivity().getResources().getString(a.i.ala_makeup_new_bubble_tip), 1500L);
                }
            }
        };
        this.hrb = new HttpMessageListener(1021188) { // from class: com.baidu.tieba.ala.liveroom.views.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetAnchorCategoryResponseMessagge) {
                    if (httpResponsedMessage.isSuccess()) {
                        c.this.hiB = ((AlaGetAnchorCategoryResponseMessagge) httpResponsedMessage).cdi();
                    }
                    c.this.cfI();
                }
            }
        };
        this.hrc = new CustomMessageListener(2913202) { // from class: com.baidu.tieba.ala.liveroom.views.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.a) {
                    c.this.hiB = (com.baidu.tieba.ala.category.b.a) customResponsedMessage.getData();
                    c.this.cfI();
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.ala.liveroom.views.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    c.this.cfI();
                }
            }
        };
        this.mHandler = new Handler();
        initViews();
        cfG();
        cfH();
        MessageManager.getInstance().registerListener(this.hqZ);
        MessageManager.getInstance().registerListener(this.hhA);
        MessageManager.getInstance().registerListener(this.hra);
        MessageManager.getInstance().registerListener(this.hrb);
        MessageManager.getInstance().registerListener(this.hrc);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().sendMessage(new HttpMessage(1021147));
        MessageManager.getInstance().sendMessage(new HttpMessage(1021188));
        this.hqK = new Random();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            this.hqG = new com.baidu.tieba.ala.liveroom.share.d(this.mPageContext);
            this.hqG.p(this.mRootView);
            this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(0);
            this.hqG.cd(this.mRootView.findViewById(a.g.ala_prepare_share_layout));
            return;
        }
        this.hqG = null;
        this.mRootView.findViewById(a.g.ala_prepare_share_layout).setVisibility(8);
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hqG != null) {
            this.hqG.a(iShareCallback);
        }
    }

    private void initViews() {
        this.hqB = TbadkCoreApplication.getCurrentPortrait();
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.cfe();
                c.this.cff();
                return false;
            }
        });
        ceW();
        this.hol.setOnClickListener(this.hqY);
        this.hqq = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_top_opt_layout);
        this.hqx = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.hqy = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.hqz = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.hqy.setIsRound(false);
        this.hqy.setGifIconSupport(false);
        String cfa = cfa();
        this.hqz.setText(a.i.hk_live_change_cover);
        if (TextUtils.isEmpty(cfa)) {
            this.hqy.setDefaultResource(a.f.hk_icon_default_cover);
        } else {
            l.a(this.hqy, cfa, true, false);
            this.hqz.setText(a.i.ala_live_change_cover);
            this.hqD = cfa;
        }
        this.hol.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hqr = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.hqr.setOnClickListener(this.hqY);
        this.hqt = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_camera);
        this.hqt.setOnClickListener(this.hqY);
        this.hqs = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_light_switch);
        this.hqW = (LinearLayout) this.mRootView.findViewById(a.g.prepare_opt_layout);
        this.hqu = this.mRootView.findViewById(a.g.beauty_layout);
        this.hqv = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_beauty);
        this.hqw = (TextView) this.mRootView.findViewById(a.g.beauty_textView);
        this.hqv.setOnClickListener(this.hqY);
        this.hqw.setOnClickListener(this.hqY);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqq.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.hqq.setLayoutParams(layoutParams);
        }
        this.hqT = (RelativeLayout) this.mRootView.findViewById(a.g.ala_live_assistant_txt_layout);
        this.hqU = (TextView) this.mRootView.findViewById(a.g.ala_live_assistant_txt);
        this.hqV = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_guide_remind_layout);
        this.hqT.setOnClickListener(this.hqY);
        this.hqF = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_exchange_title);
        this.hqF.setOnClickListener(this.hqY);
        this.hqO = (CheckedTextView) this.mRootView.findViewById(a.g.ala_live_prepare_live_category_txt);
        this.hqO.setOnClickListener(this.hqY);
        Ga();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_OPEN_STARTLIVE_PAGE));
        }
        this.hqM = true;
        cfy();
        cfz();
        this.enterTime = System.currentTimeMillis();
    }

    private r cfx() {
        if (com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aMl == null) {
            return null;
        }
        return com.baidu.live.z.a.Pq().bmJ.aMl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfy() {
        r cfx = cfx();
        if (cfx != null && cfx.aIr != null && cfx.aIr.size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.hqP = cfx.aIr.get(this.hqL % cfx.aIr.size());
            sb.append("     ");
            sb.append(this.mPageContext.getPageActivity().getResources().getString(a.i.ala_live_assistant));
            sb.append(this.hqP.getText());
            this.hqT.setVisibility(0);
            this.hqU.setText(sb);
            this.hqL++;
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hqM) {
                        c.this.cfy();
                    } else {
                        c.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }, 5000L);
            return;
        }
        this.hqT.setVisibility(8);
    }

    private void cfz() {
        if (com.baidu.live.d.AZ().getInt("live_assistant_guide_txt_show_counts", 0) == 0 && this.hqT != null && this.hqT.getVisibility() == 0) {
            com.baidu.live.d.AZ().putInt("live_assistant_guide_txt_show_counts", 1);
            this.hqV.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Ih(String str) {
        com.baidu.live.d.AZ().putString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), str);
    }

    private void Ga() {
        this.hqx.setOnClickListener(this.hqY);
        this.hqs.setOnClickListener(this.hqX);
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected void cff() {
        if (this.hop != null) {
            this.hop.ccH();
        }
    }

    public void bYN() {
        cfb();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int cfg() {
        return 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected boolean cfh() {
        return false;
    }

    public boolean bYL() {
        if (this.hqG != null) {
            this.hqG.ceH();
        }
        return this.hqG != null && this.hqG.bYL();
    }

    public void bYM() {
        if (this.hqG != null) {
            this.hqG.y(this.hqD, getLiveTitle(), this.hqI, this.hqJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfA() {
        if (this.hqE) {
            this.hqs.setImageResource(a.f.btn_live_anchor_light_switch_on);
        } else {
            this.hqs.setImageResource(a.f.btn_live_anchor_light_switch_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfB() {
        this.hqV.setVisibility(8);
        if (this.mTbPageContext != null) {
            if (this.gPK == null) {
                this.gPK = new com.baidu.tieba.ala.liveroom.activeview.b(this.mTbPageContext);
            }
            if (this.hqP != null && !TextUtils.isEmpty(this.hqP.DP())) {
                this.gPK.Hw(this.hqP.DP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.hqN != null) {
            if (isDebug()) {
                d("showBeautyUpdateToast mBeautyUpdateView null");
                return;
            }
            return;
        }
        this.hqN = this.mPageContext.getPageActivity().getLayoutInflater().inflate(a.h.toast_beauty_update_guide, (ViewGroup) null);
        ((TextView) this.hqN.findViewById(a.g.textView)).setText(str);
        if (this.mRootView != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.10
                @Override // java.lang.Runnable
                public void run() {
                    Activity pageActivity;
                    if (c.this.mRootView != null && (pageActivity = c.this.mPageContext.getPageActivity()) != null && !pageActivity.isFinishing() && c.this.hqN != null) {
                        int[] iArr = new int[2];
                        c.this.hqu.getLocationOnScreen(iArr);
                        c.this.hqN.measure(0, 0);
                        int i = BdUtilHelper.getScreenSize(pageActivity).widthPixels;
                        int width = (iArr[0] + (c.this.hqu.getWidth() / 2)) - (c.this.hqN.getMeasuredWidth() / 2);
                        int measuredWidth = (i - width) - c.this.hqN.getMeasuredWidth();
                        int measuredHeight = iArr[1] - c.this.hqN.getMeasuredHeight();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        layoutParams.leftMargin = width;
                        layoutParams.rightMargin = measuredWidth;
                        layoutParams.topMargin = measuredHeight - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
                        c.this.mRootView.addView(c.this.hqN, layoutParams);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfC() {
        if (bk.c(com.baidu.live.z.a.Pq().bsy)) {
            this.hqu.setVisibility(0);
            if (bk.c(com.baidu.live.z.a.Pq().bsy)) {
                this.hqv.setAlpha(0.2f);
                this.hqw.setAlpha(0.2f);
            }
        } else if (this.bAW != null && this.bAW.hasBeauty() < 0) {
            this.hqu.setVisibility(8);
        } else {
            this.hqu.setVisibility(0);
        }
    }

    public boolean bYH() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfD() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HF(String str) {
        this.hqC = true;
        this.hqD = str;
        this.hqz.setText(a.i.ala_live_change_cover);
        Ih(str);
        l.a(this.hqy, str, true, false);
        TiebaInitialize.log(new StatisticItem("c11868").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public String bYK() {
        return cfa();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void b(AlaLiveRecorder alaLiveRecorder) {
        super.b(alaLiveRecorder);
        cfE();
        cfC();
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected com.baidu.tieba.ala.category.b.a cfd() {
        return this.hiB;
    }

    public void bYE() {
        this.bAW.setVideoConfig(LiveRecorderConfigHelper.ON().d(2, 1, false));
    }

    private void cfE() {
        if (this.bAW != null) {
            cfC();
            if (this.bAW.isBackCamera()) {
                this.hqs.setEnabled(true);
                this.hqs.setVisibility(0);
                this.hqE = this.bAW.isFlashingLightOpen();
            } else {
                this.hqs.setEnabled(false);
                this.hqs.setVisibility(4);
            }
            new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.11
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bAW != null) {
                        c.this.bAW.addRecorderCallback(c.this.mRecorderCallback);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        cff();
        if (this.hqG != null && z) {
            this.hqG.ceG();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.views.a
    protected int bYP() {
        return 1;
    }

    public void a(e.a aVar) {
        this.hqp = aVar;
    }

    public void onResume() {
        this.hqA = false;
        if (this.bAW != null) {
            if (this.bAW.isBackCamera()) {
                this.hqs.setEnabled(true);
                this.hqs.setVisibility(0);
                this.hqE = this.bAW.isFlashingLightOpen();
                cfA();
            } else {
                this.hqs.setEnabled(false);
                this.hqs.setVisibility(4);
            }
        }
        if (this.hom != null && this.hom.cfM() && TextUtils.isEmpty(this.hom.cfS())) {
            this.hom.cfR();
        }
        if (!cfF()) {
            f(BdUniqueId.gen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfF() {
        if (this.hqR == null) {
            this.hqR = Boolean.valueOf(com.baidu.live.d.AZ().getBoolean("makeup_new_bubble_tiped", false));
            if (isDebug()) {
                d("get SP " + cfF());
            }
        }
        return this.hqR.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG(boolean z) {
        if (cfF() != z) {
            this.hqR = Boolean.valueOf(z);
            com.baidu.live.d.AZ().putBoolean("makeup_new_bubble_tiped", this.hqR.booleanValue());
            if (isDebug()) {
                d("save SP " + this.hqR);
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

    public void mV(boolean z) {
        this.hol.setClickable(z);
    }

    public void release() {
        this.hqM = true;
        if (this.bAW != null) {
            this.bAW.removeRecorderCallback(this.mRecorderCallback);
        }
        MessageManager.getInstance().unRegisterListener(this.hqZ);
        MessageManager.getInstance().unRegisterListener(this.hhA);
        MessageManager.getInstance().unRegisterListener(this.hra);
        MessageManager.getInstance().unRegisterListener(this.hrb);
        MessageManager.getInstance().unRegisterListener(this.hrc);
        if (this.hqG != null) {
            this.hqG.release();
        }
        if (this.gPK != null) {
            this.gPK.release();
            this.gPK = null;
        }
    }

    private void cfG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021147, TbConfig.SERVER_HOST + "liveserver/sys/openlivedoc");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LivePrepareListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cfH() {
        if (ak.Ef()) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021188, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorCategory");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaGetAnchorCategoryResponseMessagge.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfI() {
        if (ak.Ef()) {
            this.hqO.setVisibility(0);
            if (this.hiB != null && this.hiB.bOr() != null && !StringUtils.isNull(this.hiB.bOr().getName())) {
                this.hqO.setText(this.hiB.bOr().getName());
                this.hqO.setChecked(true);
                return;
            }
            this.hqO.setText(a.i.ala_live_prepare_select_livetype);
            this.hqO.setChecked(false);
            return;
        }
        this.hqO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfJ() {
        if (this.hqK != null && this.hqH != null && this.hqH.size() > 0) {
            String str = this.hqH.get(this.hqK.nextInt(100) % this.hqH.size());
            if (!TextUtils.isEmpty(str)) {
                this.hog.clearFocus();
                this.hog.setText(str);
            }
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.live.k.a aVar) {
        if (aVar != null) {
            com.baidu.live.core.a.a cc = aVar.cc(true);
            View rootLayout = cc.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            cc.setTargetView(this.hol);
            this.hqW.addView(rootLayout, 0);
            aVar.MS();
        }
    }
}
