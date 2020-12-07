package com.baidu.tieba.ala.liveroom.operation;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ak;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyCountDownView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aGQ;
    private int bdi;
    public CustomMessageListener bgy;
    public CustomMessageListener bon;
    private boolean bqg;
    private int bqh;
    private BdPageContext bqi;
    private int bqj;
    private a hAA;
    private boolean hAB;
    private Animator.AnimatorListener hAC;
    public View hAa;
    public TextView hAb;
    public ImageView hAc;
    public ImageView hAd;
    public FrameLayout hAe;
    public FrameLayout hAf;
    public ImageView hAg;
    public ImageView hAh;
    public FrameLayout hAi;
    public TbImageView hAj;
    private ViewGroup hAk;
    public View hAl;
    public ImageView hAm;
    public TurnTableLuckyCountDownView hAn;
    public ImageView hAo;
    public ImageView hAp;
    public FrameLayout hAq;
    private boolean hAr;
    private b hAs;
    private int hAt;
    private Set<Long> hAu;
    private View hAv;
    private View hAw;
    private boolean hAx;
    private boolean hAy;
    private Handler hAz;
    private Handler handler;
    public FrameLayout hwz;
    private com.baidu.tieba.ala.liveroom.operation.b hzJ;
    public RelativeLayout hzK;
    public ImageView hzL;
    public TBLottieAnimationView hzM;
    public FrameLayout hzN;
    public TbImageView hzO;
    public FrameLayout hzP;
    public ImageView hzQ;
    public FrameLayout hzR;
    public ImageView hzS;
    public FrameLayout hzT;
    public ImageView hzU;
    public FrameLayout hzV;
    public TextView hzW;
    public FrameLayout hzX;
    public LinearLayout hzY;
    public TextView hzZ;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hAr = false;
        this.handler = new Handler();
        this.hAt = -1;
        this.hAu = new HashSet();
        this.bqj = 0;
        this.hAx = false;
        this.hAy = false;
        this.hAz = new Handler();
        this.hAB = true;
        this.hAC = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hzM.setVisibility(8);
                AlaLiveBottomOperationView.this.hzL.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hzJ != null) {
                    if (view == AlaLiveBottomOperationView.this.hzR) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hzK) {
                        AlaLiveBottomOperationView.this.hAv = view;
                        if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                            if (!AlaLiveBottomOperationView.this.bqg) {
                                AlaLiveBottomOperationView.this.cr(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqj = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cr(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hzN) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hzJ.s(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hzP) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hzV) {
                        AlaLiveBottomOperationView.this.hAr = AlaLiveBottomOperationView.this.hAr ? false : true;
                        if (AlaLiveBottomOperationView.this.hAr) {
                            AlaLiveBottomOperationView.this.hzU.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hzJ.s(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hzU.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hzJ.s(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hzX) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hzT) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hAc) {
                        AlaLiveBottomOperationView.this.hAw = view;
                        if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                            if (!AlaLiveBottomOperationView.this.bqg) {
                                AlaLiveBottomOperationView.this.hzJ.s(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqj = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hzJ.s(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hAe) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hwz) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hAf) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hAi) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hAl) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hAo) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hAp) {
                        AlaLiveBottomOperationView.this.hzJ.s(view, 19);
                    }
                }
            }
        };
        this.bon = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bqj == 1 || AlaLiveBottomOperationView.this.bqj == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bqj == 1) {
                                    AlaLiveBottomOperationView.this.cr(AlaLiveBottomOperationView.this.hAv);
                                } else if (AlaLiveBottomOperationView.this.bqj == 2) {
                                    AlaLiveBottomOperationView.this.hzJ.s(AlaLiveBottomOperationView.this.hAw, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bqj = 0;
                    }
                }
            }
        };
        this.bqi = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void UD() {
        this.hAx = false;
        this.hAy = false;
        cjW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void no(boolean z) {
        if (this.hzJ != null && z) {
            this.hzJ.s(this.hzN, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hzN.setVisibility(z ? 0 : 8);
        if (z && !this.hAx) {
            this.hAx = true;
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hAc.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hAB = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hzK = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hzL = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hzN = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hzO = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hzO.setDefaultResource(a.e.icon_quick_gift_def);
        this.hzP = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hzQ = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hzR = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hzU = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hzV = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hzW = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hzX = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hzY = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hzZ = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hAa = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hAb = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hzS = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hzT = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hAc = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hAd = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hAe = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hwz = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hAk = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hAk.setVisibility(8);
        this.hAf = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hAg = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hAh = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hAi = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hAj = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hAj.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hAl = this.rootView.findViewById(a.f.turntable);
        this.hAm = (ImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hAn = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hAo = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hAp = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hzM = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hAB) {
            this.hzM.setImageAssetsFolder("lottie/testa/giftimages");
            this.hzM.setAnimation("lottie/liveshow_gift_testa.json");
            this.hzL.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testa);
        } else {
            this.hzM.setImageAssetsFolder("lottie/testb/giftimages");
            this.hzM.setAnimation("lottie/liveshow_gift_testb.json");
            this.hzL.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testb);
        }
        this.hzM.setVisibility(8);
        this.hzM.addAnimatorListener(this.hAC);
        this.hAq = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        HH();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hAt != i) {
            this.hAt = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hzK.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hzK.setLayoutParams(layoutParams);
        }
    }

    private void HH() {
        this.hzN.setOnClickListener(this.aGQ);
        this.hzP.setOnClickListener(this.aGQ);
        this.hzR.setOnClickListener(this.aGQ);
        this.hAe.setOnClickListener(this.aGQ);
        this.hzV.setOnClickListener(this.aGQ);
        this.hzX.setOnClickListener(this.aGQ);
        this.hzK.setOnClickListener(this.aGQ);
        this.hzT.setOnClickListener(this.aGQ);
        this.hAc.setOnClickListener(this.aGQ);
        this.hwz.setOnClickListener(this.aGQ);
        this.hAf.setOnClickListener(this.aGQ);
        this.hAi.setOnClickListener(this.aGQ);
        this.hAl.setOnClickListener(this.aGQ);
        this.hAo.setOnClickListener(this.aGQ);
        this.hAp.setOnClickListener(this.aGQ);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cp(View view) {
        if (this.hAk != null) {
            this.hAk.setVisibility(0);
            this.hAk.addView(view);
        }
    }

    public void cq(View view) {
        if (this.hAq != null) {
            this.hAq.setVisibility(0);
            this.hAq.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hzJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hzJ.s(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hAo;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bon);
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.ae.a.RB().RF()) {
                z = false;
            }
            ak akVar = com.baidu.tieba.ala.liveroom.v.b.ckA().brJ;
            if (akVar != null) {
                z2 = (akVar.aLH == 1 || TextUtils.isEmpty(akVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hzP.setAlpha(0.0f);
                this.hAf.setVisibility(8);
                this.hAi.setVisibility(0);
                if (akVar != null && !TextUtils.isEmpty(akVar.iconUrl)) {
                    BdLog.d("iconUrl:" + akVar.iconUrl);
                    this.hAj.startLoad(akVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hzP.setAlpha(0.0f);
                this.hAi.setVisibility(8);
                this.hAf.setVisibility(0);
                cjX();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hAu.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hAu.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hzP.setAlpha(1.0f);
                if (!this.hAy) {
                    this.hAy = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, null));
                }
                this.hAf.setVisibility(8);
                this.hAi.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bqg = z;
        this.bqh = i;
        this.bdi = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpe == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpf);
            }
            this.mDialog = new BdAlertDialog(this.bqi.getPageActivity());
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
            this.mDialog.create(this.bqi);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bgy.setTag(this.bqi.getUniqueId());
        MessageManager.getInstance().registerListener(this.bgy);
        this.bon.setTag(this.bqi.getUniqueId());
        MessageManager.getInstance().registerListener(this.bon);
    }

    private void cjW() {
        if (this.hAA == null) {
            this.hAA = new a();
        }
        this.hAz.removeCallbacks(this.hAA);
        this.hAz.postDelayed(this.hAA, 5000L);
    }

    private void cjX() {
        if (this.hAs == null) {
            this.hAs = new b();
        }
        this.handler.postDelayed(this.hAs, 1000L);
    }

    public void ccC() {
        if (this.hzM != null) {
            if (this.hzM.isAnimating()) {
                this.hzM.cancelAnimation();
            }
            this.hzM.setVisibility(8);
        }
        if (this.hzL != null) {
            this.hzL.setVisibility(0);
        }
        this.hAz.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hzM.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hzM.isAnimating()) {
                AlaLiveBottomOperationView.this.hzM.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hzM.playAnimation();
            AlaLiveBottomOperationView.this.hzL.setVisibility(4);
            AlaLiveBottomOperationView.this.hAz.removeCallbacks(AlaLiveBottomOperationView.this.hAA);
            AlaLiveBottomOperationView.this.hAz.postDelayed(AlaLiveBottomOperationView.this.hAA, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hAg.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hAg.setVisibility(8);
                AlaLiveBottomOperationView.this.hAh.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hAg.setVisibility(0);
                AlaLiveBottomOperationView.this.hAh.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hAs, 1000L);
        }
    }

    public void blq() {
        if (this.hzM != null) {
            if (this.hzM.isAnimating()) {
                this.hzM.cancelAnimation();
            }
            this.hzM.setVisibility(8);
        }
        if (this.hzL != null) {
            this.hzL.setVisibility(0);
        }
    }
}
