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
import com.baidu.live.data.aj;
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
    private View.OnClickListener aEk;
    private int aZI;
    public CustomMessageListener bcy;
    private boolean bkX;
    private int bkY;
    private BdPageContext bkZ;
    private int bla;
    public CustomMessageListener blf;
    private Handler handler;
    public FrameLayout hmU;
    public FrameLayout hqA;
    public FrameLayout hqB;
    public ImageView hqC;
    public ImageView hqD;
    public FrameLayout hqE;
    public TbImageView hqF;
    private ViewGroup hqG;
    public View hqH;
    public ImageView hqI;
    public TurnTableLuckyCountDownView hqJ;
    public ImageView hqK;
    public ImageView hqL;
    public FrameLayout hqM;
    private boolean hqN;
    private b hqO;
    private int hqP;
    private Set<Long> hqQ;
    private View hqR;
    private View hqS;
    private boolean hqT;
    private boolean hqU;
    private Handler hqV;
    private a hqW;
    private boolean hqX;
    private Animator.AnimatorListener hqY;
    private com.baidu.tieba.ala.liveroom.operation.b hqf;
    public RelativeLayout hqg;
    public ImageView hqh;
    public TBLottieAnimationView hqi;
    public FrameLayout hqj;
    public TbImageView hqk;
    public FrameLayout hql;
    public ImageView hqm;
    public FrameLayout hqn;
    public ImageView hqo;
    public FrameLayout hqp;
    public ImageView hqq;
    public FrameLayout hqr;
    public TextView hqs;
    public FrameLayout hqt;
    public LinearLayout hqu;
    public TextView hqv;
    public View hqw;
    public TextView hqx;
    public ImageView hqy;
    public ImageView hqz;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hqN = false;
        this.handler = new Handler();
        this.hqP = -1;
        this.hqQ = new HashSet();
        this.bla = 0;
        this.hqT = false;
        this.hqU = false;
        this.hqV = new Handler();
        this.hqX = true;
        this.hqY = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hqi.setVisibility(8);
                AlaLiveBottomOperationView.this.hqh.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hqf != null) {
                    if (view == AlaLiveBottomOperationView.this.hqn) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hqg) {
                        AlaLiveBottomOperationView.this.hqR = view;
                        if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                            if (!AlaLiveBottomOperationView.this.bkX) {
                                AlaLiveBottomOperationView.this.ck(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bla = 1;
                        } else {
                            AlaLiveBottomOperationView.this.ck(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hqj) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hqf.s(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hql) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hqr) {
                        AlaLiveBottomOperationView.this.hqN = AlaLiveBottomOperationView.this.hqN ? false : true;
                        if (AlaLiveBottomOperationView.this.hqN) {
                            AlaLiveBottomOperationView.this.hqq.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hqf.s(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hqq.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hqf.s(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hqt) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hqp) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hqy) {
                        AlaLiveBottomOperationView.this.hqS = view;
                        if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                            if (!AlaLiveBottomOperationView.this.bkX) {
                                AlaLiveBottomOperationView.this.hqf.s(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bla = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hqf.s(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hqA) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hmU) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hqB) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hqE) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hqH) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hqK) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hqL) {
                        AlaLiveBottomOperationView.this.hqf.s(view, 19);
                    }
                }
            }
        };
        this.blf = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bla == 1 || AlaLiveBottomOperationView.this.bla == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bla == 1) {
                                    AlaLiveBottomOperationView.this.ck(AlaLiveBottomOperationView.this.hqR);
                                } else if (AlaLiveBottomOperationView.this.bla == 2) {
                                    AlaLiveBottomOperationView.this.hqf.s(AlaLiveBottomOperationView.this.hqS, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bla = 0;
                    }
                }
            }
        };
        this.bkZ = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void Sf() {
        this.hqT = false;
        this.hqU = false;
        cgc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mT(boolean z) {
        if (this.hqf != null && z) {
            this.hqf.s(this.hqj, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hqj.setVisibility(z ? 0 : 8);
        if (z && !this.hqT) {
            this.hqT = true;
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "gifticon_show").setContentExt(null, "popup", null));
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hqy.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hqX = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hqg = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hqh = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hqj = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hqk = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hqk.setDefaultResource(a.e.icon_quick_gift_def);
        this.hql = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hqm = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hqn = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hqq = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hqr = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hqs = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hqt = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hqu = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hqv = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hqw = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hqx = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hqo = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hqp = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hqy = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hqz = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hqA = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hmU = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hqG = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hqG.setVisibility(8);
        this.hqB = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hqC = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hqD = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hqE = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hqF = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hqF.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hqH = this.rootView.findViewById(a.f.turntable);
        this.hqI = (ImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hqJ = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hqK = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hqL = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hqi = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hqX) {
            this.hqi.setImageAssetsFolder("lottie/testa/giftimages");
            this.hqi.setAnimation("lottie/liveshow_gift_testa.json");
            this.hqh.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testa);
        } else {
            this.hqi.setImageAssetsFolder("lottie/testb/giftimages");
            this.hqi.setAnimation("lottie/liveshow_gift_testb.json");
            this.hqh.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testb);
        }
        this.hqi.setVisibility(8);
        this.hqi.addAnimatorListener(this.hqY);
        this.hqM = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        FS();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hqP != i) {
            this.hqP = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqg.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hqg.setLayoutParams(layoutParams);
        }
    }

    private void FS() {
        this.hqj.setOnClickListener(this.aEk);
        this.hql.setOnClickListener(this.aEk);
        this.hqn.setOnClickListener(this.aEk);
        this.hqA.setOnClickListener(this.aEk);
        this.hqr.setOnClickListener(this.aEk);
        this.hqt.setOnClickListener(this.aEk);
        this.hqg.setOnClickListener(this.aEk);
        this.hqp.setOnClickListener(this.aEk);
        this.hqy.setOnClickListener(this.aEk);
        this.hmU.setOnClickListener(this.aEk);
        this.hqB.setOnClickListener(this.aEk);
        this.hqE.setOnClickListener(this.aEk);
        this.hqH.setOnClickListener(this.aEk);
        this.hqK.setOnClickListener(this.aEk);
        this.hqL.setOnClickListener(this.aEk);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void ci(View view) {
        if (this.hqG != null) {
            this.hqG.setVisibility(0);
            this.hqG.addView(view);
        }
    }

    public void cj(View view) {
        if (this.hqM != null) {
            this.hqM.setVisibility(0);
            this.hqM.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hqf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hqf.s(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hqK;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.blf);
        MessageManager.getInstance().unRegisterListener(this.bcy);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.aa.a.Ph().Pl()) {
                z = false;
            }
            aj ajVar = com.baidu.tieba.ala.liveroom.w.b.cgG().bmB;
            if (ajVar != null) {
                z2 = (ajVar.aIO == 1 || TextUtils.isEmpty(ajVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hql.setAlpha(0.0f);
                this.hqB.setVisibility(8);
                this.hqE.setVisibility(0);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.iconUrl)) {
                    BdLog.d("iconUrl:" + ajVar.iconUrl);
                    this.hqF.startLoad(ajVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hql.setAlpha(0.0f);
                this.hqE.setVisibility(8);
                this.hqB.setVisibility(0);
                cgd();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hqQ.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hqQ.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hql.setAlpha(1.0f);
                if (!this.hqU) {
                    this.hqU = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quickgift_show").setContentExt(null, "popup", null));
                }
                this.hqB.setVisibility(8);
                this.hqE.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bkX = z;
        this.bkY = i;
        this.aZI = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bka == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bkb);
            }
            this.mDialog = new BdAlertDialog(this.bkZ.getPageActivity());
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
            this.mDialog.create(this.bkZ);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bcy.setTag(this.bkZ.getUniqueId());
        MessageManager.getInstance().registerListener(this.bcy);
        this.blf.setTag(this.bkZ.getUniqueId());
        MessageManager.getInstance().registerListener(this.blf);
    }

    private void cgc() {
        if (this.hqW == null) {
            this.hqW = new a();
        }
        this.hqV.removeCallbacks(this.hqW);
        this.hqV.postDelayed(this.hqW, 5000L);
    }

    private void cgd() {
        if (this.hqO == null) {
            this.hqO = new b();
        }
        this.handler.postDelayed(this.hqO, 1000L);
    }

    public void bYH() {
        if (this.hqi != null) {
            if (this.hqi.isAnimating()) {
                this.hqi.cancelAnimation();
            }
            this.hqi.setVisibility(8);
        }
        if (this.hqh != null) {
            this.hqh.setVisibility(0);
        }
        this.hqV.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hqi.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hqi.isAnimating()) {
                AlaLiveBottomOperationView.this.hqi.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hqi.playAnimation();
            AlaLiveBottomOperationView.this.hqh.setVisibility(4);
            AlaLiveBottomOperationView.this.hqV.removeCallbacks(AlaLiveBottomOperationView.this.hqW);
            AlaLiveBottomOperationView.this.hqV.postDelayed(AlaLiveBottomOperationView.this.hqW, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hqC.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hqC.setVisibility(8);
                AlaLiveBottomOperationView.this.hqD.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hqC.setVisibility(0);
                AlaLiveBottomOperationView.this.hqD.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hqO, 1000L);
        }
    }

    public void big() {
        if (this.hqi != null) {
            if (this.hqi.isAnimating()) {
                this.hqi.cancelAnimation();
            }
            this.hqi.setVisibility(8);
        }
        if (this.hqh != null) {
            this.hqh.setVisibility(0);
        }
    }
}
