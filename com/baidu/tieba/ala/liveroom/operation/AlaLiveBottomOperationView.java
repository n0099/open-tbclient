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
    public FrameLayout hIs;
    private com.baidu.tieba.ala.liveroom.operation.b hLP;
    public RelativeLayout hLQ;
    public ImageView hLR;
    public TBLottieAnimationView hLS;
    public FrameLayout hLT;
    public TbImageView hLU;
    public FrameLayout hLV;
    public ImageView hLW;
    public FrameLayout hLX;
    public ImageView hLY;
    public FrameLayout hLZ;
    private b hMA;
    private int hMB;
    private Set<Long> hMC;
    private View hMD;
    private View hME;
    private boolean hMF;
    private boolean hMG;
    private Handler hMH;
    private a hMI;
    private boolean hMJ;
    private Animator.AnimatorListener hMK;
    public ImageView hMa;
    public FrameLayout hMb;
    public TextView hMc;
    public FrameLayout hMd;
    public LinearLayout hMe;
    public TextView hMf;
    public View hMg;
    public TextView hMh;
    public ImageView hMi;
    public ImageView hMj;
    public FrameLayout hMk;
    public FrameLayout hMl;
    public ImageView hMm;
    public FrameLayout hMn;
    public ImageView hMo;
    public ImageView hMp;
    public FrameLayout hMq;
    public TbImageView hMr;
    public ViewGroup hMs;
    public View hMt;
    public TbImageView hMu;
    public TurnTableLuckyCountDownView hMv;
    public ImageView hMw;
    public ImageView hMx;
    public FrameLayout hMy;
    private boolean hMz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hMz = false;
        this.handler = new Handler();
        this.hMB = -1;
        this.hMC = new HashSet();
        this.bqH = 0;
        this.hMF = false;
        this.hMG = false;
        this.hMH = new Handler();
        this.hMJ = true;
        this.hMK = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hLS.setVisibility(8);
                AlaLiveBottomOperationView.this.hLR.setVisibility(0);
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
                if (AlaLiveBottomOperationView.this.hLP != null) {
                    if (view == AlaLiveBottomOperationView.this.hLX) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hLQ) {
                        AlaLiveBottomOperationView.this.hMD = view;
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
                    } else if (view == AlaLiveBottomOperationView.this.hLT) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hLP.v(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hLV) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hMb) {
                        AlaLiveBottomOperationView.this.hMz = AlaLiveBottomOperationView.this.hMz ? false : true;
                        if (AlaLiveBottomOperationView.this.hMz) {
                            AlaLiveBottomOperationView.this.hMa.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hLP.v(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hMa.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hLP.v(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hMd) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hLZ) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hMi) {
                        AlaLiveBottomOperationView.this.hME = view;
                        if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                            if (!AlaLiveBottomOperationView.this.bqD) {
                                AlaLiveBottomOperationView.this.hLP.v(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqH = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hLP.v(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hMk) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hIs) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hMn) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hMq) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hMt) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hMw) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hMx) {
                        AlaLiveBottomOperationView.this.hLP.v(view, 19);
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
                                    AlaLiveBottomOperationView.this.cw(AlaLiveBottomOperationView.this.hMD);
                                } else if (AlaLiveBottomOperationView.this.bqH == 2) {
                                    AlaLiveBottomOperationView.this.hLP.v(AlaLiveBottomOperationView.this.hME, 11);
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
        this.hMF = false;
        this.hMG = false;
        ckb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nV(boolean z) {
        if (this.hLP != null && z) {
            this.hLP.v(this.hLT, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hLT.setVisibility(z ? 0 : 8);
        if (z && !this.hMF) {
            this.hMF = true;
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hMi.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hMJ = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hLQ = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hLR = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hLT = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hLU = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hLU.setDefaultResource(a.e.icon_quick_gift_def);
        this.hLV = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hLW = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hLX = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hMa = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hMb = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hMc = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hMd = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hMe = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hMf = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hMg = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hMh = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hLY = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hLZ = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hMi = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hMj = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hMk = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hIs = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hMs = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hMs.setVisibility(8);
        this.hMn = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hMo = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hMp = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hMq = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hMr = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hMr.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hMl = (FrameLayout) this.rootView.findViewById(a.f.daily_tasks_layout);
        this.hMm = (ImageView) this.rootView.findViewById(a.f.daily_tasks_red_dot);
        this.hMt = this.rootView.findViewById(a.f.turntable);
        this.hMu = (TbImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hMv = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hMu.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hMw = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hMx = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hLS = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hMJ) {
            this.hLS.setImageAssetsFolder("lottie/gift/images");
            this.hLS.setAnimation("lottie/gift/anim_liveshow_gift.json");
        } else {
            this.hLS.setImageAssetsFolder("lottie/gift/images");
            this.hLS.setAnimation("lottie/gift/anim_liveshow_gift.json");
        }
        this.hLS.setVisibility(8);
        this.hLS.addAnimatorListener(this.hMK);
        this.hMy = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        ED();
    }

    private void ED() {
        this.hLT.setOnClickListener(this.aEh);
        this.hLV.setOnClickListener(this.aEh);
        this.hLX.setOnClickListener(this.aEh);
        this.hMk.setOnClickListener(this.aEh);
        this.hMb.setOnClickListener(this.aEh);
        this.hMd.setOnClickListener(this.aEh);
        this.hLQ.setOnClickListener(this.aEh);
        this.hLZ.setOnClickListener(this.aEh);
        this.hMi.setOnClickListener(this.aEh);
        this.hIs.setOnClickListener(this.aEh);
        this.hMn.setOnClickListener(this.aEh);
        this.hMq.setOnClickListener(this.aEh);
        this.hMt.setOnClickListener(this.aEh);
        this.hMw.setOnClickListener(this.aEh);
        this.hMx.setOnClickListener(this.aEh);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cu(View view) {
        if (this.hMs != null) {
            this.hMs.setVisibility(0);
            this.hMs.addView(view);
        }
    }

    public void cv(View view) {
        if (this.hMy != null) {
            this.hMy.setVisibility(0);
            this.hMy.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hLP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hLP.v(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hMw;
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
            aq aqVar = com.baidu.tieba.ala.liveroom.u.b.ckE().bvg;
            if (aqVar != null) {
                z2 = (aqVar.aKc == 1 || TextUtils.isEmpty(aqVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hLV.setAlpha(0.0f);
                this.hMn.setVisibility(8);
                this.hMq.setVisibility(0);
                if (aqVar != null && !TextUtils.isEmpty(aqVar.iconUrl)) {
                    BdLog.d("iconUrl:" + aqVar.iconUrl);
                    this.hMr.startLoad(aqVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hLV.setAlpha(0.0f);
                this.hMq.setVisibility(8);
                this.hMn.setVisibility(0);
                ckc();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hMC.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hMC.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hLV.setAlpha(1.0f);
                if (!this.hMG) {
                    this.hMG = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, null));
                }
                this.hMn.setVisibility(8);
                this.hMq.setVisibility(8);
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

    private void ckb() {
        if (this.hMI == null) {
            this.hMI = new a();
        }
        this.hMH.removeCallbacks(this.hMI);
        this.hMH.postDelayed(this.hMI, 5000L);
    }

    private void ckc() {
        if (this.hMA == null) {
            this.hMA = new b();
        }
        this.handler.postDelayed(this.hMA, 1000L);
    }

    public void ccE() {
        if (this.hLS != null) {
            if (this.hLS.isAnimating()) {
                this.hLS.cancelAnimation();
            }
            this.hLS.setVisibility(8);
        }
        if (this.hLR != null) {
            this.hLR.setVisibility(0);
        }
        this.hMH.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hLS.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hLS.isAnimating()) {
                AlaLiveBottomOperationView.this.hLS.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hLS.playAnimation();
            AlaLiveBottomOperationView.this.hLR.setVisibility(4);
            AlaLiveBottomOperationView.this.hMH.removeCallbacks(AlaLiveBottomOperationView.this.hMI);
            AlaLiveBottomOperationView.this.hMH.postDelayed(AlaLiveBottomOperationView.this.hMI, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hMo.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hMo.setVisibility(8);
                AlaLiveBottomOperationView.this.hMp.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hMo.setVisibility(0);
                AlaLiveBottomOperationView.this.hMp.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hMA, 1000L);
        }
    }

    public void bkp() {
        if (this.hLS != null) {
            if (this.hLS.isAnimating()) {
                this.hLS.cancelAnimation();
            }
            this.hLS.setVisibility(8);
        }
        if (this.hLR != null) {
            this.hLR.setVisibility(0);
        }
    }
}
