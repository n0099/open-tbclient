package com.baidu.tieba.ala.liveroom.operation;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.aq;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyCountDownView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aEh;
    private int bdk;
    public CustomMessageListener bgy;
    public CustomMessageListener boE;
    private boolean bqD;
    private int bqF;
    private BdPageContext bqG;
    private int bqH;
    public FrameLayout hIe;
    private com.baidu.tieba.ala.liveroom.operation.b hLB;
    public RelativeLayout hLC;
    public ImageView hLD;
    public TBLottieAnimationView hLE;
    public FrameLayout hLF;
    public TbImageView hLG;
    public FrameLayout hLH;
    public ImageView hLI;
    public FrameLayout hLJ;
    public ImageView hLK;
    public FrameLayout hLL;
    public ImageView hLM;
    public FrameLayout hLN;
    public TextView hLO;
    public FrameLayout hLP;
    public LinearLayout hLQ;
    public TextView hLR;
    public View hLS;
    public TextView hLT;
    public ImageView hLU;
    public ImageView hLV;
    public FrameLayout hLW;
    public FrameLayout hLX;
    public ImageView hLY;
    public FrameLayout hLZ;
    public ImageView hMa;
    public ImageView hMb;
    public FrameLayout hMc;
    public TbImageView hMd;
    public ViewGroup hMe;
    public View hMf;
    public TbImageView hMg;
    public TurnTableLuckyCountDownView hMh;
    public ImageView hMi;
    public ImageView hMj;
    public FrameLayout hMk;
    private boolean hMl;
    private b hMm;
    private int hMn;
    private Set<Long> hMo;
    private View hMp;
    private View hMq;
    private boolean hMr;
    private boolean hMs;
    private Handler hMt;
    private a hMu;
    private boolean hMv;
    private Animator.AnimatorListener hMw;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hMl = false;
        this.handler = new Handler();
        this.hMn = -1;
        this.hMo = new HashSet();
        this.bqH = 0;
        this.hMr = false;
        this.hMs = false;
        this.hMt = new Handler();
        this.hMv = true;
        this.hMw = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hLE.setVisibility(8);
                AlaLiveBottomOperationView.this.hLD.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hLB != null) {
                    if (view == AlaLiveBottomOperationView.this.hLJ) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hLC) {
                        AlaLiveBottomOperationView.this.hMp = view;
                        if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                            if (!AlaLiveBottomOperationView.this.bqD) {
                                AlaLiveBottomOperationView.this.cw(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqH = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cw(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hLF) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hLB.v(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hLH) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hLN) {
                        AlaLiveBottomOperationView.this.hMl = AlaLiveBottomOperationView.this.hMl ? false : true;
                        if (AlaLiveBottomOperationView.this.hMl) {
                            AlaLiveBottomOperationView.this.hLM.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hLB.v(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hLM.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hLB.v(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hLP) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hLL) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hLU) {
                        AlaLiveBottomOperationView.this.hMq = view;
                        if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                            if (!AlaLiveBottomOperationView.this.bqD) {
                                AlaLiveBottomOperationView.this.hLB.v(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqH = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hLB.v(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hLW) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hIe) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hLZ) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hMc) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hMf) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hMi) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hMj) {
                        AlaLiveBottomOperationView.this.hLB.v(view, 19);
                    }
                }
            }
        };
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bqH == 1 || AlaLiveBottomOperationView.this.bqH == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bqH == 1) {
                                    AlaLiveBottomOperationView.this.cw(AlaLiveBottomOperationView.this.hMp);
                                } else if (AlaLiveBottomOperationView.this.bqH == 2) {
                                    AlaLiveBottomOperationView.this.hLB.v(AlaLiveBottomOperationView.this.hMq, 11);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        AlaLiveBottomOperationView.this.bqH = 0;
                    }
                }
            }
        };
        this.bqG = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void Tw() {
        this.hMr = false;
        this.hMs = false;
        cjU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nV(boolean z) {
        if (this.hLB != null && z) {
            this.hLB.v(this.hLF, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hLF.setVisibility(z ? 0 : 8);
        if (z && !this.hMr) {
            this.hMr = true;
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hLU.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hMv = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hLC = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hLD = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hLF = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hLG = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hLG.setDefaultResource(a.e.icon_quick_gift_def);
        this.hLH = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hLI = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hLJ = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hLM = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hLN = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hLO = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hLP = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hLQ = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hLR = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hLS = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hLT = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hLK = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hLL = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hLU = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hLV = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hLW = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hIe = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hMe = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hMe.setVisibility(8);
        this.hLZ = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hMa = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hMb = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hMc = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hMd = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hMd.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hLX = (FrameLayout) this.rootView.findViewById(a.f.daily_tasks_layout);
        this.hLY = (ImageView) this.rootView.findViewById(a.f.daily_tasks_red_dot);
        this.hMf = this.rootView.findViewById(a.f.turntable);
        this.hMg = (TbImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hMh = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hMg.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hMi = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hMj = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hLE = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hMv) {
            this.hLE.setImageAssetsFolder("lottie/gift/images");
            this.hLE.setAnimation("lottie/gift/anim_liveshow_gift.json");
        } else {
            this.hLE.setImageAssetsFolder("lottie/gift/images");
            this.hLE.setAnimation("lottie/gift/anim_liveshow_gift.json");
        }
        this.hLE.setVisibility(8);
        this.hLE.addAnimatorListener(this.hMw);
        this.hMk = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        ED();
    }

    private void ED() {
        this.hLF.setOnClickListener(this.aEh);
        this.hLH.setOnClickListener(this.aEh);
        this.hLJ.setOnClickListener(this.aEh);
        this.hLW.setOnClickListener(this.aEh);
        this.hLN.setOnClickListener(this.aEh);
        this.hLP.setOnClickListener(this.aEh);
        this.hLC.setOnClickListener(this.aEh);
        this.hLL.setOnClickListener(this.aEh);
        this.hLU.setOnClickListener(this.aEh);
        this.hIe.setOnClickListener(this.aEh);
        this.hLZ.setOnClickListener(this.aEh);
        this.hMc.setOnClickListener(this.aEh);
        this.hMf.setOnClickListener(this.aEh);
        this.hMi.setOnClickListener(this.aEh);
        this.hMj.setOnClickListener(this.aEh);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cu(View view) {
        if (this.hMe != null) {
            this.hMe.setVisibility(0);
            this.hMe.addView(view);
        }
    }

    public void cv(View view) {
        if (this.hMk != null) {
            this.hMk.setVisibility(0);
            this.hMk.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hLB = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hLB.v(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hMi;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.boE);
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.ae.a.Qj().Qo()) {
                z = false;
            }
            aq aqVar = com.baidu.tieba.ala.liveroom.u.b.ckx().bvg;
            if (aqVar != null) {
                z2 = (aqVar.aKc == 1 || TextUtils.isEmpty(aqVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hLH.setAlpha(0.0f);
                this.hLZ.setVisibility(8);
                this.hMc.setVisibility(0);
                if (aqVar != null && !TextUtils.isEmpty(aqVar.iconUrl)) {
                    BdLog.d("iconUrl:" + aqVar.iconUrl);
                    this.hMd.startLoad(aqVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hLH.setAlpha(0.0f);
                this.hMc.setVisibility(8);
                this.hLZ.setVisibility(0);
                cjV();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hMo.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hMo.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hLH.setAlpha(1.0f);
                if (!this.hMs) {
                    this.hMs = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, null));
                }
                this.hLZ.setVisibility(8);
                this.hMc.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bqD = z;
        this.bqF = i;
        this.bdk = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpt == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpu);
            }
            this.mDialog = new BdAlertDialog(this.bqG.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.3
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                        BrowserHelper.startInternalWebActivity(AlaLiveBottomOperationView.this.getContext(), "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                    } else {
                        BrowserHelper.startInternalWebActivity(AlaLiveBottomOperationView.this.getContext(), "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                    }
                    bdAlertDialog.dismiss();
                }
            });
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.bqG);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        if (this.bgy == null) {
            this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        AlaLiveBottomOperationView.this.mDialog.dismiss();
                    }
                }
            };
        }
        this.bgy.setTag(this.bqG.getUniqueId());
        MessageManager.getInstance().registerListener(this.bgy);
        this.boE.setTag(this.bqG.getUniqueId());
        MessageManager.getInstance().registerListener(this.boE);
    }

    private void cjU() {
        if (this.hMu == null) {
            this.hMu = new a();
        }
        this.hMt.removeCallbacks(this.hMu);
        this.hMt.postDelayed(this.hMu, 5000L);
    }

    private void cjV() {
        if (this.hMm == null) {
            this.hMm = new b();
        }
        this.handler.postDelayed(this.hMm, 1000L);
    }

    public void ccx() {
        if (this.hLE != null) {
            if (this.hLE.isAnimating()) {
                this.hLE.cancelAnimation();
            }
            this.hLE.setVisibility(8);
        }
        if (this.hLD != null) {
            this.hLD.setVisibility(0);
        }
        this.hMt.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hLE.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hLE.isAnimating()) {
                AlaLiveBottomOperationView.this.hLE.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hLE.playAnimation();
            AlaLiveBottomOperationView.this.hLD.setVisibility(4);
            AlaLiveBottomOperationView.this.hMt.removeCallbacks(AlaLiveBottomOperationView.this.hMu);
            AlaLiveBottomOperationView.this.hMt.postDelayed(AlaLiveBottomOperationView.this.hMu, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hMa.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hMa.setVisibility(8);
                AlaLiveBottomOperationView.this.hMb.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hMa.setVisibility(0);
                AlaLiveBottomOperationView.this.hMb.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hMm, 1000L);
        }
    }

    public void bkp() {
        if (this.hLE != null) {
            if (this.hLE.isAnimating()) {
                this.hLE.cancelAnimation();
            }
            this.hLE.setVisibility(8);
        }
        if (this.hLD != null) {
            this.hLD.setVisibility(0);
        }
    }
}
