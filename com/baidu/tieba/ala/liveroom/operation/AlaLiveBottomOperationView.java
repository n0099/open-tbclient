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
/* loaded from: classes10.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aFH;
    private int beM;
    public CustomMessageListener bhY;
    public CustomMessageListener bqe;
    private boolean bsd;
    private int bsf;
    private BdPageContext bsg;
    private int bsh;
    public FrameLayout hKb;
    public ImageView hNA;
    public TBLottieAnimationView hNB;
    public FrameLayout hNC;
    public TbImageView hND;
    public FrameLayout hNE;
    public ImageView hNF;
    public FrameLayout hNG;
    public ImageView hNH;
    public FrameLayout hNI;
    public ImageView hNJ;
    public FrameLayout hNK;
    public TextView hNL;
    public FrameLayout hNM;
    public LinearLayout hNN;
    public TextView hNO;
    public View hNP;
    public TextView hNQ;
    public ImageView hNR;
    public ImageView hNS;
    public FrameLayout hNT;
    public FrameLayout hNU;
    public ImageView hNV;
    public FrameLayout hNW;
    public ImageView hNX;
    public ImageView hNY;
    public FrameLayout hNZ;
    private com.baidu.tieba.ala.liveroom.operation.b hNy;
    public RelativeLayout hNz;
    public TbImageView hOa;
    public ViewGroup hOb;
    public View hOc;
    public TbImageView hOd;
    public TurnTableLuckyCountDownView hOe;
    public ImageView hOf;
    public ImageView hOg;
    public FrameLayout hOh;
    private boolean hOi;
    private b hOj;
    private int hOk;
    private Set<Long> hOl;
    private View hOm;
    private View hOn;
    private boolean hOo;
    private boolean hOp;
    private Handler hOq;
    private a hOr;
    private boolean hOs;
    private Animator.AnimatorListener hOt;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hOi = false;
        this.handler = new Handler();
        this.hOk = -1;
        this.hOl = new HashSet();
        this.bsh = 0;
        this.hOo = false;
        this.hOp = false;
        this.hOq = new Handler();
        this.hOs = true;
        this.hOt = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hNB.setVisibility(8);
                AlaLiveBottomOperationView.this.hNA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hNy != null) {
                    if (view == AlaLiveBottomOperationView.this.hNG) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hNz) {
                        AlaLiveBottomOperationView.this.hOm = view;
                        if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                            if (!AlaLiveBottomOperationView.this.bsd) {
                                AlaLiveBottomOperationView.this.cw(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bsh = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cw(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hNC) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hNy.v(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hNE) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hNK) {
                        AlaLiveBottomOperationView.this.hOi = AlaLiveBottomOperationView.this.hOi ? false : true;
                        if (AlaLiveBottomOperationView.this.hOi) {
                            AlaLiveBottomOperationView.this.hNJ.setImageResource(a.e.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hNy.v(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hNJ.setImageResource(a.e.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hNy.v(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hNM) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hNI) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hNR) {
                        AlaLiveBottomOperationView.this.hOn = view;
                        if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                            if (!AlaLiveBottomOperationView.this.bsd) {
                                AlaLiveBottomOperationView.this.hNy.v(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bsh = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hNy.v(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hNT) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hKb) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hNW) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hNZ) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hOc) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    } else if (view == AlaLiveBottomOperationView.this.hOf) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hOg) {
                        AlaLiveBottomOperationView.this.hNy.v(view, 19);
                    }
                }
            }
        };
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bsh == 1 || AlaLiveBottomOperationView.this.bsh == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bsh == 1) {
                                    AlaLiveBottomOperationView.this.cw(AlaLiveBottomOperationView.this.hOm);
                                } else if (AlaLiveBottomOperationView.this.bsh == 2) {
                                    AlaLiveBottomOperationView.this.hNy.v(AlaLiveBottomOperationView.this.hOn, 11);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        AlaLiveBottomOperationView.this.bsh = 0;
                    }
                }
            }
        };
        this.bsg = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void Tz() {
        this.hOo = false;
        this.hOp = false;
        ckh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nV(boolean z) {
        if (this.hNy != null && z) {
            this.hNy.v(this.hNC, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hNC.setVisibility(z ? 0 : 8);
        if (z && !this.hOo) {
            this.hOo = true;
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hNR.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.ala_liveroom_vertical_bottom_operation, this);
        this.hOs = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        this.hNz = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hNA = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hNC = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.hND = (TbImageView) this.rootView.findViewById(a.f.ala_live_room_quick_gift_btn);
        this.hND.setDefaultResource(a.e.icon_quick_gift_def);
        this.hNE = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_quick_gift_layout);
        this.hNF = (ImageView) this.rootView.findViewById(a.f.ala_live_room_share_btn);
        this.hNG = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_share_btn_layout);
        this.hNJ = (ImageView) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn);
        this.hNK = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_clear_screen_btn_layout);
        this.hNL = (TextView) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn);
        this.hNM = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_level_switch_btn_layout);
        this.hNN = (LinearLayout) this.rootView.findViewById(a.f.ala_live_room_host_detail_layout);
        this.hNO = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_id_tv);
        this.hNP = this.rootView.findViewById(a.f.ala_live_room_host_info_divider);
        this.hNQ = (TextView) this.rootView.findViewById(a.f.ala_live_room_host_audience_count_tv);
        this.hNH = (ImageView) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn);
        this.hNI = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_full_screen_btn_layout);
        this.hNR = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hNS = (ImageView) this.rootView.findViewById(a.f.ala_live_room_zan_btn);
        this.hNT = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_zan_layout);
        this.hKb = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hOb = (ViewGroup) this.rootView.findViewById(a.f.host_goods_layout_parent);
        this.hOb.setVisibility(8);
        this.hNW = (FrameLayout) this.rootView.findViewById(a.f.firstRecharge_layout);
        this.hNX = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp1);
        this.hNY = (ImageView) this.rootView.findViewById(a.f.firstRecharge_lamp2);
        this.hNZ = (FrameLayout) this.rootView.findViewById(a.f.superCustomer_layout);
        this.hOa = (TbImageView) this.rootView.findViewById(a.f.superCustomer_imageView);
        this.hOa.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hNU = (FrameLayout) this.rootView.findViewById(a.f.daily_tasks_layout);
        this.hNV = (ImageView) this.rootView.findViewById(a.f.daily_tasks_red_dot);
        this.hOc = this.rootView.findViewById(a.f.turntable);
        this.hOd = (TbImageView) this.rootView.findViewById(a.f.turntable_icon);
        this.hOe = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.f.turntable_countdown);
        this.hOd.setDefaultBgResource(a.e.sdk_shape_transparent);
        this.hOf = (ImageView) this.rootView.findViewById(a.f.landscape_barrage_imageView);
        this.hOg = (ImageView) this.rootView.findViewById(a.f.landscape_minimize_imageView);
        this.hNB = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        if (this.hOs) {
            this.hNB.setImageAssetsFolder("lottie/gift/images");
            this.hNB.setAnimation("lottie/gift/anim_liveshow_gift.json");
        } else {
            this.hNB.setImageAssetsFolder("lottie/gift/images");
            this.hNB.setAnimation("lottie/gift/anim_liveshow_gift.json");
        }
        this.hNB.setVisibility(8);
        this.hNB.addAnimatorListener(this.hOt);
        this.hOh = (FrameLayout) this.rootView.findViewById(a.f.ala_video_bc_container);
        EG();
    }

    private void EG() {
        this.hNC.setOnClickListener(this.aFH);
        this.hNE.setOnClickListener(this.aFH);
        this.hNG.setOnClickListener(this.aFH);
        this.hNT.setOnClickListener(this.aFH);
        this.hNK.setOnClickListener(this.aFH);
        this.hNM.setOnClickListener(this.aFH);
        this.hNz.setOnClickListener(this.aFH);
        this.hNI.setOnClickListener(this.aFH);
        this.hNR.setOnClickListener(this.aFH);
        this.hKb.setOnClickListener(this.aFH);
        this.hNW.setOnClickListener(this.aFH);
        this.hNZ.setOnClickListener(this.aFH);
        this.hOc.setOnClickListener(this.aFH);
        this.hOf.setOnClickListener(this.aFH);
        this.hOg.setOnClickListener(this.aFH);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cu(View view) {
        if (this.hOb != null) {
            this.hOb.setVisibility(0);
            this.hOb.addView(view);
        }
    }

    public void cv(View view) {
        if (this.hOh != null) {
            this.hOh.setVisibility(0);
            this.hOh.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hNy = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hNy.v(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hOf;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bqe);
        MessageManager.getInstance().unRegisterListener(this.bhY);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.ae.a.Qm().Qr()) {
                z = false;
            }
            aq aqVar = com.baidu.tieba.ala.liveroom.u.b.ckK().bwG;
            if (aqVar != null) {
                z2 = (aqVar.aLC == 1 || TextUtils.isEmpty(aqVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hNE.setAlpha(0.0f);
                this.hNW.setVisibility(8);
                this.hNZ.setVisibility(0);
                if (aqVar != null && !TextUtils.isEmpty(aqVar.iconUrl)) {
                    BdLog.d("iconUrl:" + aqVar.iconUrl);
                    this.hOa.startLoad(aqVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hNE.setAlpha(0.0f);
                this.hNZ.setVisibility(8);
                this.hNW.setVisibility(0);
                cki();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hOl.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hOl.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hNE.setAlpha(1.0f);
                if (!this.hOp) {
                    this.hOp = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, null));
                }
                this.hNW.setVisibility(8);
                this.hNZ.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bsd = z;
        this.bsf = i;
        this.beM = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqT == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqU);
            }
            this.mDialog = new BdAlertDialog(this.bsg.getPageActivity());
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
            this.mDialog.create(this.bsg);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        if (this.bhY == null) {
            this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        AlaLiveBottomOperationView.this.mDialog.dismiss();
                    }
                }
            };
        }
        this.bhY.setTag(this.bsg.getUniqueId());
        MessageManager.getInstance().registerListener(this.bhY);
        this.bqe.setTag(this.bsg.getUniqueId());
        MessageManager.getInstance().registerListener(this.bqe);
    }

    private void ckh() {
        if (this.hOr == null) {
            this.hOr = new a();
        }
        this.hOq.removeCallbacks(this.hOr);
        this.hOq.postDelayed(this.hOr, 5000L);
    }

    private void cki() {
        if (this.hOj == null) {
            this.hOj = new b();
        }
        this.handler.postDelayed(this.hOj, 1000L);
    }

    public void ccK() {
        if (this.hNB != null) {
            if (this.hNB.isAnimating()) {
                this.hNB.cancelAnimation();
            }
            this.hNB.setVisibility(8);
        }
        if (this.hNA != null) {
            this.hNA.setVisibility(0);
        }
        this.hOq.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hNB.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hNB.isAnimating()) {
                AlaLiveBottomOperationView.this.hNB.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hNB.playAnimation();
            AlaLiveBottomOperationView.this.hNA.setVisibility(4);
            AlaLiveBottomOperationView.this.hOq.removeCallbacks(AlaLiveBottomOperationView.this.hOr);
            AlaLiveBottomOperationView.this.hOq.postDelayed(AlaLiveBottomOperationView.this.hOr, 32000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hNX.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hNX.setVisibility(8);
                AlaLiveBottomOperationView.this.hNY.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hNX.setVisibility(0);
                AlaLiveBottomOperationView.this.hNY.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hOj, 1000L);
        }
    }

    public void bkr() {
        if (this.hNB != null) {
            if (this.hNB.isAnimating()) {
                this.hNB.cancelAnimation();
            }
            this.hNB.setVisibility(8);
        }
        if (this.hNA != null) {
            this.hNA.setVisibility(0);
        }
    }
}
