package com.baidu.tieba.ala.liveroom.operation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
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
import com.baidu.live.data.u;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyCountDownView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private int aEo;
    public CustomMessageListener aGS;
    private boolean aNm;
    private int aNn;
    private int aNo;
    public CustomMessageListener aNp;
    private View.OnClickListener aOQ;
    private BdPageContext aOl;
    public View fJS;
    public ImageView fJT;
    private com.baidu.tieba.ala.liveroom.operation.b fNC;
    public RelativeLayout fND;
    public ImageView fNE;
    public FrameLayout fNF;
    public TbImageView fNG;
    public FrameLayout fNH;
    public ImageView fNI;
    public FrameLayout fNJ;
    public ImageView fNK;
    public FrameLayout fNL;
    public ImageView fNM;
    public FrameLayout fNN;
    public TextView fNO;
    public FrameLayout fNP;
    public LinearLayout fNQ;
    public TextView fNR;
    public View fNS;
    public TextView fNT;
    public ImageView fNU;
    public ImageView fNV;
    public FrameLayout fNW;
    public FrameLayout fNX;
    public TBLottieAnimationView fNY;
    public FrameLayout fNZ;
    public ImageView fOa;
    public ImageView fOb;
    public FrameLayout fOc;
    public TbImageView fOd;
    public View fOe;
    public ImageView fOf;
    public TurnTableLuckyCountDownView fOg;
    public ImageView fOh;
    public ImageView fOi;
    private boolean fOj;
    private b fOk;
    private int fOl;
    private Set<Long> fOm;
    private a fOn;
    private View fOo;
    private View fOp;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.fOj = false;
        this.handler = new Handler();
        this.fOl = -1;
        this.fOm = new HashSet();
        this.aNo = 0;
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.fNC != null) {
                    if (view == AlaLiveBottomOperationView.this.fNJ) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.fND) {
                        AlaLiveBottomOperationView.this.fOo = view;
                        if (com.baidu.live.v.a.En().aQu.atD == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.v.a.En().aQu.atC == 1) {
                            if (!AlaLiveBottomOperationView.this.aNm) {
                                AlaLiveBottomOperationView.this.bE(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aNo = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bE(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.fNF) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.fNC.l(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.fNH) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.fNN) {
                        AlaLiveBottomOperationView.this.fOj = AlaLiveBottomOperationView.this.fOj ? false : true;
                        if (AlaLiveBottomOperationView.this.fOj) {
                            AlaLiveBottomOperationView.this.fNM.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.fNC.l(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fNM.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.fNC.l(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.fNP) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.fNL) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.fNU) {
                        AlaLiveBottomOperationView.this.fOp = view;
                        if (com.baidu.live.v.a.En().aQu.atC == 1) {
                            if (!AlaLiveBottomOperationView.this.aNm) {
                                AlaLiveBottomOperationView.this.fNC.l(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aNo = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.fNC.l(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.fNW) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.fNX) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.fJS) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.fNZ) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.fOc) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.fOe) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.fOh) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.fOi) {
                        AlaLiveBottomOperationView.this.fNC.l(view, 19);
                    }
                }
            }
        };
        this.aNp = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.aNo == 1 || AlaLiveBottomOperationView.this.aNo == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.aNo == 1) {
                                    AlaLiveBottomOperationView.this.bE(AlaLiveBottomOperationView.this.fOo);
                                } else if (AlaLiveBottomOperationView.this.aNo == 2) {
                                    AlaLiveBottomOperationView.this.fNC.l(AlaLiveBottomOperationView.this.fOp, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.aNo = 0;
                    }
                }
            }
        };
        this.aOl = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kd(boolean z) {
        if (this.fNC != null && z) {
            this.fNC.l(this.fNF, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.fND = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.fNE = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.fNF = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.fNG = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.fNG.setDefaultResource(a.f.icon_quick_gift_def);
        this.fNH = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.fNI = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.fNJ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fNM = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.fNN = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.fNO = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.fNP = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.fNQ = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.fNR = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.fNS = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.fNT = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.fNK = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.fNL = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.fNU = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.fNV = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.fNW = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.fNX = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.fJS = this.rootView.findViewById(a.g.host_goods_layout);
        this.fJT = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.fNY = (TBLottieAnimationView) this.rootView.findViewById(a.g.host_goods_lottieView);
        this.fNY.setImageAssetsFolder("images/");
        this.fNY.setAnimation("icon_shopping.json");
        this.fNY.setRepeatCount(0);
        this.fNY.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AlaLiveBottomOperationView.this.kO(false);
            }
        });
        this.fOn = new a();
        this.fNZ = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.fOa = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.fOb = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.fOc = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.fOd = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.fOe = this.rootView.findViewById(a.g.turntable);
        this.fOf = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.fOg = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.fOh = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.fOi = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        wC();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.fOl != i) {
            this.fOl = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fND.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.fND.setLayoutParams(layoutParams);
        }
    }

    private void wC() {
        this.fNF.setOnClickListener(this.aOQ);
        this.fNH.setOnClickListener(this.aOQ);
        this.fNJ.setOnClickListener(this.aOQ);
        this.fNW.setOnClickListener(this.aOQ);
        this.fNN.setOnClickListener(this.aOQ);
        this.fNP.setOnClickListener(this.aOQ);
        this.fND.setOnClickListener(this.aOQ);
        this.fNL.setOnClickListener(this.aOQ);
        this.fNU.setOnClickListener(this.aOQ);
        this.fNX.setOnClickListener(this.aOQ);
        this.fJS.setOnClickListener(this.aOQ);
        this.fNZ.setOnClickListener(this.aOQ);
        this.fOc.setOnClickListener(this.aOQ);
        this.fOe.setOnClickListener(this.aOQ);
        this.fOh.setOnClickListener(this.aOQ);
        this.fOi.setOnClickListener(this.aOQ);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fNC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.fNC.l(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.fOh;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.aNp);
        MessageManager.getInstance().unRegisterListener(this.aGS);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2 = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.En().Eq()) {
                z = false;
            }
            u uVar = com.baidu.tieba.ala.liveroom.t.a.bzX().aQF;
            if (uVar == null) {
                z2 = false;
            } else if (uVar.ara == 1 || TextUtils.isEmpty(uVar.iconUrl)) {
                z2 = false;
            }
            if (z2) {
                this.fNH.setAlpha(0.0f);
                this.fNZ.setVisibility(8);
                this.fOc.setVisibility(0);
                if (uVar != null && !TextUtils.isEmpty(uVar.iconUrl)) {
                    BdLog.d("iconUrl:" + uVar.iconUrl);
                    this.fOd.startLoad(uVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.fNH.setAlpha(0.0f);
                this.fOc.setVisibility(8);
                this.fNZ.setVisibility(0);
                bzz();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.fOm.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.fOm.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.fNH.setAlpha(1.0f);
                this.fNZ.setVisibility(8);
                this.fOc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(boolean z) {
        if (this.fJS.getVisibility() == 0 && this.fNY != null && this.fJT != null) {
            if (z) {
                if (!this.fNY.isAnimating()) {
                    this.fNY.setVisibility(0);
                    this.fJT.setVisibility(4);
                    this.fNY.playAnimation();
                    return;
                }
                return;
            }
            if (this.fNY.isAnimating()) {
                this.fNY.cancelAnimation();
            }
            this.fNY.setVisibility(4);
            this.fJT.setVisibility(0);
        }
    }

    public void kP(boolean z) {
        if (this.fOn != null) {
            if (z) {
                kO(true);
                this.handler.removeCallbacks(this.fOn);
                this.handler.postDelayed(this.fOn, 7000L);
                return;
            }
            kO(false);
            this.handler.removeCallbacks(this.fOn);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aNm = z;
        this.aNn = i;
        this.aEo = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aNz == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aNA);
            }
            this.mDialog = new BdAlertDialog(this.aOl.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.3
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.aOl);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aGS = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aGS.setTag(this.aOl.getUniqueId());
        MessageManager.getInstance().registerListener(this.aGS);
        this.aNp.setTag(this.aOl.getUniqueId());
        MessageManager.getInstance().registerListener(this.aNp);
    }

    private void bzz() {
        if (this.fOk == null) {
            this.fOk = new b();
        }
        this.handler.postDelayed(this.fOk, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.kO(true);
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fOn, 12000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.fOa.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.fOa.setVisibility(8);
                AlaLiveBottomOperationView.this.fOb.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.fOa.setVisibility(0);
                AlaLiveBottomOperationView.this.fOb.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fOk, 1000L);
        }
    }
}
