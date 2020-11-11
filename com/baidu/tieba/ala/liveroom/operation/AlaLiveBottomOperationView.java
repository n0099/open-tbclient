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
    private View.OnClickListener aFV;
    private int bbu;
    public CustomMessageListener bek;
    private boolean bmI;
    private int bmJ;
    private BdPageContext bmK;
    private int bmL;
    public CustomMessageListener bmQ;
    private Handler handler;
    public FrameLayout hnn;
    public ImageView hqA;
    public TBLottieAnimationView hqB;
    public FrameLayout hqC;
    public TbImageView hqD;
    public FrameLayout hqE;
    public ImageView hqF;
    public FrameLayout hqG;
    public ImageView hqH;
    public FrameLayout hqI;
    public ImageView hqJ;
    public FrameLayout hqK;
    public TextView hqL;
    public FrameLayout hqM;
    public LinearLayout hqN;
    public TextView hqO;
    public View hqP;
    public TextView hqQ;
    public ImageView hqR;
    public ImageView hqS;
    public FrameLayout hqT;
    public FrameLayout hqU;
    public ImageView hqV;
    public ImageView hqW;
    public FrameLayout hqX;
    public TbImageView hqY;
    private ViewGroup hqZ;
    private com.baidu.tieba.ala.liveroom.operation.b hqy;
    public RelativeLayout hqz;
    public View hra;
    public ImageView hrb;
    public TurnTableLuckyCountDownView hrc;
    public ImageView hrd;
    public ImageView hre;
    public FrameLayout hrf;
    private boolean hrg;
    private b hrh;
    private int hri;
    private Set<Long> hrj;
    private View hrk;
    private View hrl;
    private boolean hrm;
    private boolean hrn;
    private Handler hro;
    private a hrp;
    private boolean hrq;
    private Animator.AnimatorListener hrr;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hrg = false;
        this.handler = new Handler();
        this.hri = -1;
        this.hrj = new HashSet();
        this.bmL = 0;
        this.hrm = false;
        this.hrn = false;
        this.hro = new Handler();
        this.hrq = true;
        this.hrr = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hqB.setVisibility(8);
                AlaLiveBottomOperationView.this.hqA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hqy != null) {
                    if (view == AlaLiveBottomOperationView.this.hqG) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hqz) {
                        AlaLiveBottomOperationView.this.hrk = view;
                        if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                            if (!AlaLiveBottomOperationView.this.bmI) {
                                AlaLiveBottomOperationView.this.ch(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bmL = 1;
                        } else {
                            AlaLiveBottomOperationView.this.ch(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hqC) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hqy.p(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hqE) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hqK) {
                        AlaLiveBottomOperationView.this.hrg = AlaLiveBottomOperationView.this.hrg ? false : true;
                        if (AlaLiveBottomOperationView.this.hrg) {
                            AlaLiveBottomOperationView.this.hqJ.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hqy.p(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hqJ.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hqy.p(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hqM) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hqI) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hqR) {
                        AlaLiveBottomOperationView.this.hrl = view;
                        if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                            if (!AlaLiveBottomOperationView.this.bmI) {
                                AlaLiveBottomOperationView.this.hqy.p(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bmL = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hqy.p(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hqT) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hnn) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hqU) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hqX) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hra) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hrd) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hre) {
                        AlaLiveBottomOperationView.this.hqy.p(view, 19);
                    }
                }
            }
        };
        this.bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bmL == 1 || AlaLiveBottomOperationView.this.bmL == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bmL == 1) {
                                    AlaLiveBottomOperationView.this.ch(AlaLiveBottomOperationView.this.hrk);
                                } else if (AlaLiveBottomOperationView.this.bmL == 2) {
                                    AlaLiveBottomOperationView.this.hqy.p(AlaLiveBottomOperationView.this.hrl, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bmL = 0;
                    }
                }
            }
        };
        this.bmK = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void SO() {
        this.hrm = false;
        this.hrn = false;
        cgJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mS(boolean z) {
        if (this.hqy != null && z) {
            this.hqy.p(this.hqC, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hqC.setVisibility(z ? 0 : 8);
        if (z && !this.hrm) {
            this.hrm = true;
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "gifticon_show").setContentExt(null, "popup", null));
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hqR.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hrq = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hqz = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hqA = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hqC = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hqD = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hqD.setDefaultResource(a.e.icon_quick_gift_def);
        this.hqE = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hqF = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hqG = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hqJ = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hqK = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hqL = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hqM = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hqN = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hqO = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hqP = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hqQ = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hqH = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hqI = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hqR = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hqS = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hqT = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hnn = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hqZ = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hqZ.setVisibility(8);
        this.hqU = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hqV = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hqW = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hqX = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hqY = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hqY.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hra = this.rootView.findViewById(a.f.turntable);
        this.hrb = (ImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hrc = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hrd = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hre = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hqB = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hrq) {
            this.hqB.setImageAssetsFolder("lottie/testa/giftimages");
            this.hqB.setAnimation("lottie/liveshow_gift_testa.json");
            this.hqA.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testa);
        } else {
            this.hqB.setImageAssetsFolder("lottie/testb/giftimages");
            this.hqB.setAnimation("lottie/liveshow_gift_testb.json");
            this.hqA.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testb);
        }
        this.hqB.setVisibility(8);
        this.hqB.addAnimatorListener(this.hrr);
        this.hrf = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        GB();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hri != i) {
            this.hri = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqz.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hqz.setLayoutParams(layoutParams);
        }
    }

    private void GB() {
        this.hqC.setOnClickListener(this.aFV);
        this.hqE.setOnClickListener(this.aFV);
        this.hqG.setOnClickListener(this.aFV);
        this.hqT.setOnClickListener(this.aFV);
        this.hqK.setOnClickListener(this.aFV);
        this.hqM.setOnClickListener(this.aFV);
        this.hqz.setOnClickListener(this.aFV);
        this.hqI.setOnClickListener(this.aFV);
        this.hqR.setOnClickListener(this.aFV);
        this.hnn.setOnClickListener(this.aFV);
        this.hqU.setOnClickListener(this.aFV);
        this.hqX.setOnClickListener(this.aFV);
        this.hra.setOnClickListener(this.aFV);
        this.hrd.setOnClickListener(this.aFV);
        this.hre.setOnClickListener(this.aFV);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cf(View view) {
        if (this.hqZ != null) {
            this.hqZ.setVisibility(0);
            this.hqZ.addView(view);
        }
    }

    public void cg(View view) {
        if (this.hrf != null) {
            this.hrf.setVisibility(0);
            this.hrf.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hqy = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hqy.p(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hrd;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bmQ);
        MessageManager.getInstance().unRegisterListener(this.bek);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.aa.a.PQ().PU()) {
                z = false;
            }
            aj ajVar = com.baidu.tieba.ala.liveroom.w.b.chn().bom;
            if (ajVar != null) {
                z2 = (ajVar.aKz == 1 || TextUtils.isEmpty(ajVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hqE.setAlpha(0.0f);
                this.hqU.setVisibility(8);
                this.hqX.setVisibility(0);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.iconUrl)) {
                    BdLog.d("iconUrl:" + ajVar.iconUrl);
                    this.hqY.startLoad(ajVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hqE.setAlpha(0.0f);
                this.hqX.setVisibility(8);
                this.hqU.setVisibility(0);
                cgK();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hrj.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hrj.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hqE.setAlpha(1.0f);
                if (!this.hrn) {
                    this.hrn = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quickgift_show").setContentExt(null, "popup", null));
                }
                this.hqU.setVisibility(8);
                this.hqX.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bmI = z;
        this.bmJ = i;
        this.bbu = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blL == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blM);
            }
            this.mDialog = new BdAlertDialog(this.bmK.getPageActivity());
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
            this.mDialog.create(this.bmK);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bek.setTag(this.bmK.getUniqueId());
        MessageManager.getInstance().registerListener(this.bek);
        this.bmQ.setTag(this.bmK.getUniqueId());
        MessageManager.getInstance().registerListener(this.bmQ);
    }

    private void cgJ() {
        if (this.hrp == null) {
            this.hrp = new a();
        }
        this.hro.removeCallbacks(this.hrp);
        this.hro.postDelayed(this.hrp, 5000L);
    }

    private void cgK() {
        if (this.hrh == null) {
            this.hrh = new b();
        }
        this.handler.postDelayed(this.hrh, 1000L);
    }

    public void bZo() {
        if (this.hqB != null) {
            if (this.hqB.isAnimating()) {
                this.hqB.cancelAnimation();
            }
            this.hqB.setVisibility(8);
        }
        if (this.hqA != null) {
            this.hqA.setVisibility(0);
        }
        this.hro.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hqB.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hqB.isAnimating()) {
                AlaLiveBottomOperationView.this.hqB.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hqB.playAnimation();
            AlaLiveBottomOperationView.this.hqA.setVisibility(4);
            AlaLiveBottomOperationView.this.hro.removeCallbacks(AlaLiveBottomOperationView.this.hrp);
            AlaLiveBottomOperationView.this.hro.postDelayed(AlaLiveBottomOperationView.this.hrp, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hqV.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hqV.setVisibility(8);
                AlaLiveBottomOperationView.this.hqW.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hqV.setVisibility(0);
                AlaLiveBottomOperationView.this.hqW.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hrh, 1000L);
        }
    }

    public void biM() {
        if (this.hqB != null) {
            if (this.hqB.isAnimating()) {
                this.hqB.cancelAnimation();
            }
            this.hqB.setVisibility(8);
        }
        if (this.hqA != null) {
            this.hqA.setVisibility(0);
        }
    }
}
