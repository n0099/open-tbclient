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
    private int aEi;
    public CustomMessageListener aGM;
    private boolean aNg;
    private int aNh;
    private int aNi;
    public CustomMessageListener aNj;
    private View.OnClickListener aOK;
    private BdPageContext aOf;
    public View fJN;
    public ImageView fJO;
    public FrameLayout fNA;
    public TbImageView fNB;
    public FrameLayout fNC;
    public ImageView fND;
    public FrameLayout fNE;
    public ImageView fNF;
    public FrameLayout fNG;
    public ImageView fNH;
    public FrameLayout fNI;
    public TextView fNJ;
    public FrameLayout fNK;
    public LinearLayout fNL;
    public TextView fNM;
    public View fNN;
    public TextView fNO;
    public ImageView fNP;
    public ImageView fNQ;
    public FrameLayout fNR;
    public FrameLayout fNS;
    public TBLottieAnimationView fNT;
    public FrameLayout fNU;
    public ImageView fNV;
    public ImageView fNW;
    public FrameLayout fNX;
    public TbImageView fNY;
    public View fNZ;
    private com.baidu.tieba.ala.liveroom.operation.b fNx;
    public RelativeLayout fNy;
    public ImageView fNz;
    public ImageView fOa;
    public TurnTableLuckyCountDownView fOb;
    public ImageView fOc;
    public ImageView fOd;
    private boolean fOe;
    private b fOf;
    private int fOg;
    private Set<Long> fOh;
    private a fOi;
    private View fOj;
    private View fOk;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.fOe = false;
        this.handler = new Handler();
        this.fOg = -1;
        this.fOh = new HashSet();
        this.aNi = 0;
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.fNx != null) {
                    if (view == AlaLiveBottomOperationView.this.fNE) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.fNy) {
                        AlaLiveBottomOperationView.this.fOj = view;
                        if (com.baidu.live.v.a.Eo().aQp.atx == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.v.a.Eo().aQp.atw == 1) {
                            if (!AlaLiveBottomOperationView.this.aNg) {
                                AlaLiveBottomOperationView.this.bE(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aNi = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bE(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.fNA) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.fNx.l(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.fNC) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.fNI) {
                        AlaLiveBottomOperationView.this.fOe = AlaLiveBottomOperationView.this.fOe ? false : true;
                        if (AlaLiveBottomOperationView.this.fOe) {
                            AlaLiveBottomOperationView.this.fNH.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.fNx.l(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fNH.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.fNx.l(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.fNK) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.fNG) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.fNP) {
                        AlaLiveBottomOperationView.this.fOk = view;
                        if (com.baidu.live.v.a.Eo().aQp.atw == 1) {
                            if (!AlaLiveBottomOperationView.this.aNg) {
                                AlaLiveBottomOperationView.this.fNx.l(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aNi = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.fNx.l(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.fNR) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.fNS) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.fJN) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.fNU) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.fNX) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.fNZ) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.fOc) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.fOd) {
                        AlaLiveBottomOperationView.this.fNx.l(view, 19);
                    }
                }
            }
        };
        this.aNj = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.aNi == 1 || AlaLiveBottomOperationView.this.aNi == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.aNi == 1) {
                                    AlaLiveBottomOperationView.this.bE(AlaLiveBottomOperationView.this.fOj);
                                } else if (AlaLiveBottomOperationView.this.aNi == 2) {
                                    AlaLiveBottomOperationView.this.fNx.l(AlaLiveBottomOperationView.this.fOk, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.aNi = 0;
                    }
                }
            }
        };
        this.aOf = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kd(boolean z) {
        if (this.fNx != null && z) {
            this.fNx.l(this.fNA, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.fNy = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.fNz = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.fNA = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.fNB = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.fNB.setDefaultResource(a.f.icon_quick_gift_def);
        this.fNC = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.fND = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.fNE = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fNH = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.fNI = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.fNJ = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.fNK = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.fNL = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.fNM = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.fNN = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.fNO = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.fNF = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.fNG = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.fNP = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.fNQ = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.fNR = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.fNS = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.fJN = this.rootView.findViewById(a.g.host_goods_layout);
        this.fJO = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.fNT = (TBLottieAnimationView) this.rootView.findViewById(a.g.host_goods_lottieView);
        this.fNT.setImageAssetsFolder("images/");
        this.fNT.setAnimation("icon_shopping.json");
        this.fNT.setRepeatCount(0);
        this.fNT.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AlaLiveBottomOperationView.this.kO(false);
            }
        });
        this.fOi = new a();
        this.fNU = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.fNV = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.fNW = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.fNX = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.fNY = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.fNZ = this.rootView.findViewById(a.g.turntable);
        this.fOa = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.fOb = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.fOc = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.fOd = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        wD();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.fOg != i) {
            this.fOg = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fNy.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.fNy.setLayoutParams(layoutParams);
        }
    }

    private void wD() {
        this.fNA.setOnClickListener(this.aOK);
        this.fNC.setOnClickListener(this.aOK);
        this.fNE.setOnClickListener(this.aOK);
        this.fNR.setOnClickListener(this.aOK);
        this.fNI.setOnClickListener(this.aOK);
        this.fNK.setOnClickListener(this.aOK);
        this.fNy.setOnClickListener(this.aOK);
        this.fNG.setOnClickListener(this.aOK);
        this.fNP.setOnClickListener(this.aOK);
        this.fNS.setOnClickListener(this.aOK);
        this.fJN.setOnClickListener(this.aOK);
        this.fNU.setOnClickListener(this.aOK);
        this.fNX.setOnClickListener(this.aOK);
        this.fNZ.setOnClickListener(this.aOK);
        this.fOc.setOnClickListener(this.aOK);
        this.fOd.setOnClickListener(this.aOK);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fNx = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.fNx.l(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.fOc;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.aNj);
        MessageManager.getInstance().unRegisterListener(this.aGM);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2 = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.Eo().Er()) {
                z = false;
            }
            u uVar = com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA;
            if (uVar == null) {
                z2 = false;
            } else if (uVar.aqU == 1 || TextUtils.isEmpty(uVar.iconUrl)) {
                z2 = false;
            }
            if (z2) {
                this.fNC.setAlpha(0.0f);
                this.fNU.setVisibility(8);
                this.fNX.setVisibility(0);
                if (uVar != null && !TextUtils.isEmpty(uVar.iconUrl)) {
                    BdLog.d("iconUrl:" + uVar.iconUrl);
                    this.fNY.startLoad(uVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.fNC.setAlpha(0.0f);
                this.fNX.setVisibility(8);
                this.fNU.setVisibility(0);
                bzB();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.fOh.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.fOh.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.fNC.setAlpha(1.0f);
                this.fNU.setVisibility(8);
                this.fNX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(boolean z) {
        if (this.fJN.getVisibility() == 0 && this.fNT != null && this.fJO != null) {
            if (z) {
                if (!this.fNT.isAnimating()) {
                    this.fNT.setVisibility(0);
                    this.fJO.setVisibility(4);
                    this.fNT.playAnimation();
                    return;
                }
                return;
            }
            if (this.fNT.isAnimating()) {
                this.fNT.cancelAnimation();
            }
            this.fNT.setVisibility(4);
            this.fJO.setVisibility(0);
        }
    }

    public void kP(boolean z) {
        if (this.fOi != null) {
            if (z) {
                kO(true);
                this.handler.removeCallbacks(this.fOi);
                this.handler.postDelayed(this.fOi, 7000L);
                return;
            }
            kO(false);
            this.handler.removeCallbacks(this.fOi);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aNg = z;
        this.aNh = i;
        this.aEi = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aNt == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aNu);
            }
            this.mDialog = new BdAlertDialog(this.aOf.getPageActivity());
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
            this.mDialog.create(this.aOf);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aGM = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aGM.setTag(this.aOf.getUniqueId());
        MessageManager.getInstance().registerListener(this.aGM);
        this.aNj.setTag(this.aOf.getUniqueId());
        MessageManager.getInstance().registerListener(this.aNj);
    }

    private void bzB() {
        if (this.fOf == null) {
            this.fOf = new b();
        }
        this.handler.postDelayed(this.fOf, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.kO(true);
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fOi, 12000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.fNV.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.fNV.setVisibility(8);
                AlaLiveBottomOperationView.this.fNW.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.fNV.setVisibility(0);
                AlaLiveBottomOperationView.this.fNW.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fOf, 1000L);
        }
    }
}
