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
    private View.OnClickListener aHh;
    private int beT;
    public CustomMessageListener bih;
    public CustomMessageListener bpW;
    private boolean brO;
    private int brQ;
    private BdPageContext brR;
    private int brS;
    public FrameLayout hIy;
    private com.baidu.tieba.ala.liveroom.operation.b hLJ;
    public RelativeLayout hLK;
    public ImageView hLL;
    public TBLottieAnimationView hLM;
    public FrameLayout hLN;
    public TbImageView hLO;
    public FrameLayout hLP;
    public ImageView hLQ;
    public FrameLayout hLR;
    public ImageView hLS;
    public FrameLayout hLT;
    public ImageView hLU;
    public FrameLayout hLV;
    public TextView hLW;
    public FrameLayout hLX;
    public LinearLayout hLY;
    public TextView hLZ;
    private boolean hMA;
    private Handler hMB;
    private a hMC;
    private boolean hMD;
    private Animator.AnimatorListener hME;
    public View hMa;
    public TextView hMb;
    public ImageView hMc;
    public ImageView hMd;
    public FrameLayout hMe;
    public FrameLayout hMf;
    public ImageView hMg;
    public FrameLayout hMh;
    public ImageView hMi;
    public ImageView hMj;
    public FrameLayout hMk;
    public TbImageView hMl;
    public ViewGroup hMm;
    public View hMn;
    public TbImageView hMo;
    public TurnTableLuckyCountDownView hMp;
    public ImageView hMq;
    public ImageView hMr;
    public FrameLayout hMs;
    private boolean hMt;
    private b hMu;
    private int hMv;
    private Set<Long> hMw;
    private View hMx;
    private View hMy;
    private boolean hMz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hMt = false;
        this.handler = new Handler();
        this.hMv = -1;
        this.hMw = new HashSet();
        this.brS = 0;
        this.hMz = false;
        this.hMA = false;
        this.hMB = new Handler();
        this.hMD = true;
        this.hME = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hLM.setVisibility(8);
                AlaLiveBottomOperationView.this.hLL.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hLJ != null) {
                    if (view == AlaLiveBottomOperationView.this.hLR) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hLK) {
                        AlaLiveBottomOperationView.this.hMx = view;
                        if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                            if (!AlaLiveBottomOperationView.this.brO) {
                                AlaLiveBottomOperationView.this.cA(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.brS = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cA(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hLN) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hLJ.v(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hLP) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hLV) {
                        AlaLiveBottomOperationView.this.hMt = AlaLiveBottomOperationView.this.hMt ? false : true;
                        if (AlaLiveBottomOperationView.this.hMt) {
                            AlaLiveBottomOperationView.this.hLU.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hLJ.v(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hLU.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hLJ.v(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hLX) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hLT) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hMc) {
                        AlaLiveBottomOperationView.this.hMy = view;
                        if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                            if (!AlaLiveBottomOperationView.this.brO) {
                                AlaLiveBottomOperationView.this.hLJ.v(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.brS = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hLJ.v(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hMe) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hIy) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hMh) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hMk) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hMn) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, "popup", null));
                    } else if (view == AlaLiveBottomOperationView.this.hMq) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hMr) {
                        AlaLiveBottomOperationView.this.hLJ.v(view, 19);
                    }
                }
            }
        };
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.brS == 1 || AlaLiveBottomOperationView.this.brS == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.brS == 1) {
                                    AlaLiveBottomOperationView.this.cA(AlaLiveBottomOperationView.this.hMx);
                                } else if (AlaLiveBottomOperationView.this.brS == 2) {
                                    AlaLiveBottomOperationView.this.hLJ.v(AlaLiveBottomOperationView.this.hMy, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.brS = 0;
                    }
                }
            }
        };
        this.brR = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void VI() {
        this.hMz = false;
        this.hMA = false;
        cmM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nO(boolean z) {
        if (this.hLJ != null && z) {
            this.hLJ.v(this.hLN, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hLN.setVisibility(z ? 0 : 8);
        if (z && !this.hMz) {
            this.hMz = true;
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hMc.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hMD = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hLK = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hLL = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hLN = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hLO = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hLO.setDefaultResource(a.e.icon_quick_gift_def);
        this.hLP = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hLQ = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hLR = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hLU = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hLV = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hLW = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hLX = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hLY = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hLZ = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hMa = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hMb = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hLS = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hLT = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hMc = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hMd = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hMe = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hIy = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hMm = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hMm.setVisibility(8);
        this.hMh = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hMi = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hMj = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hMk = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hMl = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hMl.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hMf = (FrameLayout) this.rootView.findViewById(a.f.daily_tasks_layout);
        this.hMg = (ImageView) this.rootView.findViewById(a.f.daily_tasks_red_dot);
        this.hMn = this.rootView.findViewById(a.f.turntable);
        this.hMo = (TbImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hMp = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hMo.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hMq = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hMr = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hLM = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hMD) {
            this.hLM.setImageAssetsFolder("lottie/testa/giftimages");
            this.hLM.setAnimation("lottie/liveshow_gift_testa.json");
            this.hLL.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testa);
        } else {
            this.hLM.setImageAssetsFolder("lottie/testb/giftimages");
            this.hLM.setAnimation("lottie/liveshow_gift_testb.json");
            this.hLL.setImageResource(a.e.ala_live_icon_bottom_bar_gift_testb);
        }
        this.hLM.setVisibility(8);
        this.hLM.addAnimatorListener(this.hME);
        this.hMs = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        Hi();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hMv != i) {
            this.hMv = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLK.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hLK.setLayoutParams(layoutParams);
        }
    }

    private void Hi() {
        this.hLN.setOnClickListener(this.aHh);
        this.hLP.setOnClickListener(this.aHh);
        this.hLR.setOnClickListener(this.aHh);
        this.hMe.setOnClickListener(this.aHh);
        this.hLV.setOnClickListener(this.aHh);
        this.hLX.setOnClickListener(this.aHh);
        this.hLK.setOnClickListener(this.aHh);
        this.hLT.setOnClickListener(this.aHh);
        this.hMc.setOnClickListener(this.aHh);
        this.hIy.setOnClickListener(this.aHh);
        this.hMh.setOnClickListener(this.aHh);
        this.hMk.setOnClickListener(this.aHh);
        this.hMn.setOnClickListener(this.aHh);
        this.hMq.setOnClickListener(this.aHh);
        this.hMr.setOnClickListener(this.aHh);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cy(View view) {
        if (this.hMm != null) {
            this.hMm.setVisibility(0);
            this.hMm.addView(view);
        }
    }

    public void cz(View view) {
        if (this.hMs != null) {
            this.hMs.setVisibility(0);
            this.hMs.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hLJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hLJ.v(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hMq;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bpW);
        MessageManager.getInstance().unRegisterListener(this.bih);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.af.a.SE().SI()) {
                z = false;
            }
            am amVar = com.baidu.tieba.ala.liveroom.v.b.cnp().bwr;
            if (amVar != null) {
                z2 = (amVar.aMl == 1 || TextUtils.isEmpty(amVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hLP.setAlpha(0.0f);
                this.hMh.setVisibility(8);
                this.hMk.setVisibility(0);
                if (amVar != null && !TextUtils.isEmpty(amVar.iconUrl)) {
                    BdLog.d("iconUrl:" + amVar.iconUrl);
                    this.hMl.startLoad(amVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hLP.setAlpha(0.0f);
                this.hMk.setVisibility(8);
                this.hMh.setVisibility(0);
                cmN();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hMw.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hMw.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hLP.setAlpha(1.0f);
                if (!this.hMA) {
                    this.hMA = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, null));
                }
                this.hMh.setVisibility(8);
                this.hMk.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.brO = z;
        this.brQ = i;
        this.beT = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqL == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqM);
            }
            this.mDialog = new BdAlertDialog(this.brR.getPageActivity());
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
            this.mDialog.create(this.brR);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bih.setTag(this.brR.getUniqueId());
        MessageManager.getInstance().registerListener(this.bih);
        this.bpW.setTag(this.brR.getUniqueId());
        MessageManager.getInstance().registerListener(this.bpW);
    }

    private void cmM() {
        if (this.hMC == null) {
            this.hMC = new a();
        }
        this.hMB.removeCallbacks(this.hMC);
        this.hMB.postDelayed(this.hMC, 5000L);
    }

    private void cmN() {
        if (this.hMu == null) {
            this.hMu = new b();
        }
        this.handler.postDelayed(this.hMu, 1000L);
    }

    public void cft() {
        if (this.hLM != null) {
            if (this.hLM.isAnimating()) {
                this.hLM.cancelAnimation();
            }
            this.hLM.setVisibility(8);
        }
        if (this.hLL != null) {
            this.hLL.setVisibility(0);
        }
        this.hMB.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hLM.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hLM.isAnimating()) {
                AlaLiveBottomOperationView.this.hLM.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hLM.playAnimation();
            AlaLiveBottomOperationView.this.hLL.setVisibility(4);
            AlaLiveBottomOperationView.this.hMB.removeCallbacks(AlaLiveBottomOperationView.this.hMC);
            AlaLiveBottomOperationView.this.hMB.postDelayed(AlaLiveBottomOperationView.this.hMC, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hMi.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hMi.setVisibility(8);
                AlaLiveBottomOperationView.this.hMj.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hMi.setVisibility(0);
                AlaLiveBottomOperationView.this.hMj.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hMu, 1000L);
        }
    }

    public void bnO() {
        if (this.hLM != null) {
            if (this.hLM.isAnimating()) {
                this.hLM.cancelAnimation();
            }
            this.hLM.setVisibility(8);
        }
        if (this.hLL != null) {
            this.hLL.setVisibility(0);
        }
    }
}
