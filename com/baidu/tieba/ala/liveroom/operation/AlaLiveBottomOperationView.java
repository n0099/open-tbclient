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
    private boolean hAA;
    private Handler hAB;
    private a hAC;
    private boolean hAD;
    private Animator.AnimatorListener hAE;
    public LinearLayout hAa;
    public TextView hAb;
    public View hAc;
    public TextView hAd;
    public ImageView hAe;
    public ImageView hAf;
    public FrameLayout hAg;
    public FrameLayout hAh;
    public ImageView hAi;
    public ImageView hAj;
    public FrameLayout hAk;
    public TbImageView hAl;
    private ViewGroup hAm;
    public View hAn;
    public ImageView hAo;
    public TurnTableLuckyCountDownView hAp;
    public ImageView hAq;
    public ImageView hAr;
    public FrameLayout hAs;
    private boolean hAt;
    private b hAu;
    private int hAv;
    private Set<Long> hAw;
    private View hAx;
    private View hAy;
    private boolean hAz;
    private Handler handler;
    public FrameLayout hwB;
    private com.baidu.tieba.ala.liveroom.operation.b hzL;
    public RelativeLayout hzM;
    public ImageView hzN;
    public TBLottieAnimationView hzO;
    public FrameLayout hzP;
    public TbImageView hzQ;
    public FrameLayout hzR;
    public ImageView hzS;
    public FrameLayout hzT;
    public ImageView hzU;
    public FrameLayout hzV;
    public ImageView hzW;
    public FrameLayout hzX;
    public TextView hzY;
    public FrameLayout hzZ;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hAt = false;
        this.handler = new Handler();
        this.hAv = -1;
        this.hAw = new HashSet();
        this.bqj = 0;
        this.hAz = false;
        this.hAA = false;
        this.hAB = new Handler();
        this.hAD = true;
        this.hAE = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hzO.setVisibility(8);
                AlaLiveBottomOperationView.this.hzN.setVisibility(0);
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
                if (AlaLiveBottomOperationView.this.hzL != null) {
                    if (view == AlaLiveBottomOperationView.this.hzT) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hzM) {
                        AlaLiveBottomOperationView.this.hAx = view;
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
                    } else if (view == AlaLiveBottomOperationView.this.hzP) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hzL.s(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hzR) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hzX) {
                        AlaLiveBottomOperationView.this.hAt = AlaLiveBottomOperationView.this.hAt ? false : true;
                        if (AlaLiveBottomOperationView.this.hAt) {
                            AlaLiveBottomOperationView.this.hzW.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hzL.s(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hzW.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hzL.s(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hzZ) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hzV) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hAe) {
                        AlaLiveBottomOperationView.this.hAy = view;
                        if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                            if (!AlaLiveBottomOperationView.this.bqg) {
                                AlaLiveBottomOperationView.this.hzL.s(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqj = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hzL.s(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hAg) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hwB) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hAh) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hAk) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hAn) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hAq) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hAr) {
                        AlaLiveBottomOperationView.this.hzL.s(view, 19);
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
                                    AlaLiveBottomOperationView.this.cr(AlaLiveBottomOperationView.this.hAx);
                                } else if (AlaLiveBottomOperationView.this.bqj == 2) {
                                    AlaLiveBottomOperationView.this.hzL.s(AlaLiveBottomOperationView.this.hAy, 11);
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
        this.hAz = false;
        this.hAA = false;
        cjX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void no(boolean z) {
        if (this.hzL != null && z) {
            this.hzL.s(this.hzP, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hzP.setVisibility(z ? 0 : 8);
        if (z && !this.hAz) {
            this.hAz = true;
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hAe.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hAD = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hzM = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hzN = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hzP = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hzQ = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hzQ.setDefaultResource(a.e.icon_quick_gift_def);
        this.hzR = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hzS = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hzT = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hzW = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hzX = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hzY = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hzZ = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hAa = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hAb = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hAc = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hAd = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hzU = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hzV = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hAe = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hAf = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hAg = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hwB = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hAm = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hAm.setVisibility(8);
        this.hAh = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hAi = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hAj = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hAk = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hAl = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hAl.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hAn = this.rootView.findViewById(a.f.turntable);
        this.hAo = (ImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hAp = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hAq = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hAr = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hzO = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hAD) {
            this.hzO.setImageAssetsFolder("lottie/testa/giftimages");
            this.hzO.setAnimation("lottie/liveshow_gift_testa.json");
            this.hzN.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testa);
        } else {
            this.hzO.setImageAssetsFolder("lottie/testb/giftimages");
            this.hzO.setAnimation("lottie/liveshow_gift_testb.json");
            this.hzN.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testb);
        }
        this.hzO.setVisibility(8);
        this.hzO.addAnimatorListener(this.hAE);
        this.hAs = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        HH();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hAv != i) {
            this.hAv = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hzM.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hzM.setLayoutParams(layoutParams);
        }
    }

    private void HH() {
        this.hzP.setOnClickListener(this.aGQ);
        this.hzR.setOnClickListener(this.aGQ);
        this.hzT.setOnClickListener(this.aGQ);
        this.hAg.setOnClickListener(this.aGQ);
        this.hzX.setOnClickListener(this.aGQ);
        this.hzZ.setOnClickListener(this.aGQ);
        this.hzM.setOnClickListener(this.aGQ);
        this.hzV.setOnClickListener(this.aGQ);
        this.hAe.setOnClickListener(this.aGQ);
        this.hwB.setOnClickListener(this.aGQ);
        this.hAh.setOnClickListener(this.aGQ);
        this.hAk.setOnClickListener(this.aGQ);
        this.hAn.setOnClickListener(this.aGQ);
        this.hAq.setOnClickListener(this.aGQ);
        this.hAr.setOnClickListener(this.aGQ);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cp(View view) {
        if (this.hAm != null) {
            this.hAm.setVisibility(0);
            this.hAm.addView(view);
        }
    }

    public void cq(View view) {
        if (this.hAs != null) {
            this.hAs.setVisibility(0);
            this.hAs.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hzL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hzL.s(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hAq;
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
            ak akVar = com.baidu.tieba.ala.liveroom.v.b.ckB().brJ;
            if (akVar != null) {
                z2 = (akVar.aLH == 1 || TextUtils.isEmpty(akVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hzR.setAlpha(0.0f);
                this.hAh.setVisibility(8);
                this.hAk.setVisibility(0);
                if (akVar != null && !TextUtils.isEmpty(akVar.iconUrl)) {
                    BdLog.d("iconUrl:" + akVar.iconUrl);
                    this.hAl.startLoad(akVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hzR.setAlpha(0.0f);
                this.hAk.setVisibility(8);
                this.hAh.setVisibility(0);
                cjY();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hAw.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hAw.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hzR.setAlpha(1.0f);
                if (!this.hAA) {
                    this.hAA = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, null));
                }
                this.hAh.setVisibility(8);
                this.hAk.setVisibility(8);
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

    private void cjX() {
        if (this.hAC == null) {
            this.hAC = new a();
        }
        this.hAB.removeCallbacks(this.hAC);
        this.hAB.postDelayed(this.hAC, 5000L);
    }

    private void cjY() {
        if (this.hAu == null) {
            this.hAu = new b();
        }
        this.handler.postDelayed(this.hAu, 1000L);
    }

    public void ccD() {
        if (this.hzO != null) {
            if (this.hzO.isAnimating()) {
                this.hzO.cancelAnimation();
            }
            this.hzO.setVisibility(8);
        }
        if (this.hzN != null) {
            this.hzN.setVisibility(0);
        }
        this.hAB.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hzO.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hzO.isAnimating()) {
                AlaLiveBottomOperationView.this.hzO.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hzO.playAnimation();
            AlaLiveBottomOperationView.this.hzN.setVisibility(4);
            AlaLiveBottomOperationView.this.hAB.removeCallbacks(AlaLiveBottomOperationView.this.hAC);
            AlaLiveBottomOperationView.this.hAB.postDelayed(AlaLiveBottomOperationView.this.hAC, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hAi.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hAi.setVisibility(8);
                AlaLiveBottomOperationView.this.hAj.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hAi.setVisibility(0);
                AlaLiveBottomOperationView.this.hAj.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hAu, 1000L);
        }
    }

    public void blq() {
        if (this.hzO != null) {
            if (this.hzO.isAnimating()) {
                this.hzO.cancelAnimation();
            }
            this.hzO.setVisibility(8);
        }
        if (this.hzN != null) {
            this.hzN.setVisibility(0);
        }
    }
}
