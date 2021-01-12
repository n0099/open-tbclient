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
import com.baidu.live.data.am;
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
/* loaded from: classes10.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aCu;
    private int bad;
    public CustomMessageListener bdo;
    public CustomMessageListener blj;
    private boolean bnc;
    private int bne;
    private BdPageContext bnf;
    private int bng;
    public FrameLayout hDS;
    public ImageView hHA;
    public FrameLayout hHB;
    public ImageView hHC;
    public ImageView hHD;
    public FrameLayout hHE;
    public TbImageView hHF;
    public ViewGroup hHG;
    public View hHH;
    public TbImageView hHI;
    public TurnTableLuckyCountDownView hHJ;
    public ImageView hHK;
    public ImageView hHL;
    public FrameLayout hHM;
    private boolean hHN;
    private b hHO;
    private int hHP;
    private Set<Long> hHQ;
    private View hHR;
    private View hHS;
    private boolean hHT;
    private boolean hHU;
    private Handler hHV;
    private a hHW;
    private boolean hHX;
    private Animator.AnimatorListener hHY;
    private com.baidu.tieba.ala.liveroom.operation.b hHd;
    public RelativeLayout hHe;
    public ImageView hHf;
    public TBLottieAnimationView hHg;
    public FrameLayout hHh;
    public TbImageView hHi;
    public FrameLayout hHj;
    public ImageView hHk;
    public FrameLayout hHl;
    public ImageView hHm;
    public FrameLayout hHn;
    public ImageView hHo;
    public FrameLayout hHp;
    public TextView hHq;
    public FrameLayout hHr;
    public LinearLayout hHs;
    public TextView hHt;
    public View hHu;
    public TextView hHv;
    public ImageView hHw;
    public ImageView hHx;
    public FrameLayout hHy;
    public FrameLayout hHz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hHN = false;
        this.handler = new Handler();
        this.hHP = -1;
        this.hHQ = new HashSet();
        this.bng = 0;
        this.hHT = false;
        this.hHU = false;
        this.hHV = new Handler();
        this.hHX = true;
        this.hHY = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hHg.setVisibility(8);
                AlaLiveBottomOperationView.this.hHf.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hHd != null) {
                    if (view == AlaLiveBottomOperationView.this.hHl) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hHe) {
                        AlaLiveBottomOperationView.this.hHR = view;
                        if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                            if (!AlaLiveBottomOperationView.this.bnc) {
                                AlaLiveBottomOperationView.this.cA(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bng = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cA(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hHh) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hHd.v(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hHj) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hHp) {
                        AlaLiveBottomOperationView.this.hHN = AlaLiveBottomOperationView.this.hHN ? false : true;
                        if (AlaLiveBottomOperationView.this.hHN) {
                            AlaLiveBottomOperationView.this.hHo.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hHd.v(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hHo.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hHd.v(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hHr) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hHn) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hHw) {
                        AlaLiveBottomOperationView.this.hHS = view;
                        if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                            if (!AlaLiveBottomOperationView.this.bnc) {
                                AlaLiveBottomOperationView.this.hHd.v(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bng = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hHd.v(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hHy) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hDS) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hHB) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hHE) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hHH) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hHK) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hHL) {
                        AlaLiveBottomOperationView.this.hHd.v(view, 19);
                    }
                }
            }
        };
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bng == 1 || AlaLiveBottomOperationView.this.bng == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bng == 1) {
                                    AlaLiveBottomOperationView.this.cA(AlaLiveBottomOperationView.this.hHR);
                                } else if (AlaLiveBottomOperationView.this.bng == 2) {
                                    AlaLiveBottomOperationView.this.hHd.v(AlaLiveBottomOperationView.this.hHS, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bng = 0;
                    }
                }
            }
        };
        this.bnf = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void RP() {
        this.hHT = false;
        this.hHU = false;
        ciV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nK(boolean z) {
        if (this.hHd != null && z) {
            this.hHd.v(this.hHh, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hHh.setVisibility(z ? 0 : 8);
        if (z && !this.hHT) {
            this.hHT = true;
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hHw.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hHX = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hHe = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hHf = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hHh = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hHi = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hHi.setDefaultResource(a.e.icon_quick_gift_def);
        this.hHj = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hHk = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hHl = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hHo = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hHp = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hHq = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hHr = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hHs = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hHt = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hHu = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hHv = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hHm = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hHn = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hHw = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hHx = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hHy = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hDS = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hHG = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hHG.setVisibility(8);
        this.hHB = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hHC = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hHD = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hHE = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hHF = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hHF.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hHz = (FrameLayout) this.rootView.findViewById(a.f.daily_tasks_layout);
        this.hHA = (ImageView) this.rootView.findViewById(a.f.daily_tasks_red_dot);
        this.hHH = this.rootView.findViewById(a.f.turntable);
        this.hHI = (TbImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hHJ = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hHI.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hHK = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hHL = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hHg = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hHX) {
            this.hHg.setImageAssetsFolder("lottie/testa/giftimages");
            this.hHg.setAnimation("lottie/liveshow_gift_testa.json");
            this.hHf.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testa);
        } else {
            this.hHg.setImageAssetsFolder("lottie/testb/giftimages");
            this.hHg.setAnimation("lottie/liveshow_gift_testb.json");
            this.hHf.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testb);
        }
        this.hHg.setVisibility(8);
        this.hHg.addAnimatorListener(this.hHY);
        this.hHM = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        Dn();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hHP != i) {
            this.hHP = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHe.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hHe.setLayoutParams(layoutParams);
        }
    }

    private void Dn() {
        this.hHh.setOnClickListener(this.aCu);
        this.hHj.setOnClickListener(this.aCu);
        this.hHl.setOnClickListener(this.aCu);
        this.hHy.setOnClickListener(this.aCu);
        this.hHp.setOnClickListener(this.aCu);
        this.hHr.setOnClickListener(this.aCu);
        this.hHe.setOnClickListener(this.aCu);
        this.hHn.setOnClickListener(this.aCu);
        this.hHw.setOnClickListener(this.aCu);
        this.hDS.setOnClickListener(this.aCu);
        this.hHB.setOnClickListener(this.aCu);
        this.hHE.setOnClickListener(this.aCu);
        this.hHH.setOnClickListener(this.aCu);
        this.hHK.setOnClickListener(this.aCu);
        this.hHL.setOnClickListener(this.aCu);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cy(View view) {
        if (this.hHG != null) {
            this.hHG.setVisibility(0);
            this.hHG.addView(view);
        }
    }

    public void cz(View view) {
        if (this.hHM != null) {
            this.hHM.setVisibility(0);
            this.hHM.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hHd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hHd.v(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hHK;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.blj);
        MessageManager.getInstance().unRegisterListener(this.bdo);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.af.a.OJ().ON()) {
                z = false;
            }
            am amVar = com.baidu.tieba.ala.liveroom.v.b.cjy().brD;
            if (amVar != null) {
                z2 = (amVar.aHy == 1 || TextUtils.isEmpty(amVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hHj.setAlpha(0.0f);
                this.hHB.setVisibility(8);
                this.hHE.setVisibility(0);
                if (amVar != null && !TextUtils.isEmpty(amVar.iconUrl)) {
                    BdLog.d("iconUrl:" + amVar.iconUrl);
                    this.hHF.startLoad(amVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hHj.setAlpha(0.0f);
                this.hHE.setVisibility(8);
                this.hHB.setVisibility(0);
                ciW();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hHQ.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hHQ.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hHj.setAlpha(1.0f);
                if (!this.hHU) {
                    this.hHU = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, null));
                }
                this.hHB.setVisibility(8);
                this.hHE.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bnc = z;
        this.bne = i;
        this.bad = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blY == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blZ);
            }
            this.mDialog = new BdAlertDialog(this.bnf.getPageActivity());
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
            this.mDialog.create(this.bnf);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bdo.setTag(this.bnf.getUniqueId());
        MessageManager.getInstance().registerListener(this.bdo);
        this.blj.setTag(this.bnf.getUniqueId());
        MessageManager.getInstance().registerListener(this.blj);
    }

    private void ciV() {
        if (this.hHW == null) {
            this.hHW = new a();
        }
        this.hHV.removeCallbacks(this.hHW);
        this.hHV.postDelayed(this.hHW, 5000L);
    }

    private void ciW() {
        if (this.hHO == null) {
            this.hHO = new b();
        }
        this.handler.postDelayed(this.hHO, 1000L);
    }

    public void cbC() {
        if (this.hHg != null) {
            if (this.hHg.isAnimating()) {
                this.hHg.cancelAnimation();
            }
            this.hHg.setVisibility(8);
        }
        if (this.hHf != null) {
            this.hHf.setVisibility(0);
        }
        this.hHV.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hHg.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hHg.isAnimating()) {
                AlaLiveBottomOperationView.this.hHg.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hHg.playAnimation();
            AlaLiveBottomOperationView.this.hHf.setVisibility(4);
            AlaLiveBottomOperationView.this.hHV.removeCallbacks(AlaLiveBottomOperationView.this.hHW);
            AlaLiveBottomOperationView.this.hHV.postDelayed(AlaLiveBottomOperationView.this.hHW, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hHC.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hHC.setVisibility(8);
                AlaLiveBottomOperationView.this.hHD.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hHC.setVisibility(0);
                AlaLiveBottomOperationView.this.hHD.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hHO, 1000L);
        }
    }

    public void bjV() {
        if (this.hHg != null) {
            if (this.hHg.isAnimating()) {
                this.hHg.cancelAnimation();
            }
            this.hHg.setVisibility(8);
        }
        if (this.hHf != null) {
            this.hHf.setVisibility(0);
        }
    }
}
