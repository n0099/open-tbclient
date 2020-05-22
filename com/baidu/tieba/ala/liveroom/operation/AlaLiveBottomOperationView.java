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
import com.baidu.live.data.x;
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
    private int aJP;
    public CustomMessageListener aMA;
    private boolean aTs;
    private int aTt;
    private int aTu;
    public CustomMessageListener aTv;
    private View.OnClickListener aUZ;
    private BdPageContext aUs;
    public View fXQ;
    public ImageView fXR;
    private com.baidu.tieba.ala.liveroom.operation.b gbH;
    public RelativeLayout gbI;
    public ImageView gbJ;
    public FrameLayout gbK;
    public TbImageView gbL;
    public FrameLayout gbM;
    public ImageView gbN;
    public FrameLayout gbO;
    public ImageView gbP;
    public FrameLayout gbQ;
    public ImageView gbR;
    public FrameLayout gbS;
    public TextView gbT;
    public FrameLayout gbU;
    public LinearLayout gbV;
    public TextView gbW;
    public View gbX;
    public TextView gbY;
    public ImageView gbZ;
    public ImageView gca;
    public FrameLayout gcb;
    public FrameLayout gcc;
    public TBLottieAnimationView gcd;
    public FrameLayout gce;
    public ImageView gcf;
    public ImageView gcg;
    public FrameLayout gch;
    public TbImageView gci;
    public View gcj;
    public ImageView gck;
    public TurnTableLuckyCountDownView gcl;
    public ImageView gcm;
    public ImageView gcn;
    private boolean gco;
    private b gcp;
    private int gcq;
    private Set<Long> gcr;
    private a gcs;
    private View gct;
    private View gcu;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.gco = false;
        this.handler = new Handler();
        this.gcq = -1;
        this.gcr = new HashSet();
        this.aTu = 0;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.gbH != null) {
                    if (view == AlaLiveBottomOperationView.this.gbO) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.gbI) {
                        AlaLiveBottomOperationView.this.gct = view;
                        if (com.baidu.live.v.a.Ge().aWF.ayB == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.v.a.Ge().aWF.ayA == 1) {
                            if (!AlaLiveBottomOperationView.this.aTs) {
                                AlaLiveBottomOperationView.this.bD(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aTu = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bD(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.gbK) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.gbH.l(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.gbM) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.gbS) {
                        AlaLiveBottomOperationView.this.gco = AlaLiveBottomOperationView.this.gco ? false : true;
                        if (AlaLiveBottomOperationView.this.gco) {
                            AlaLiveBottomOperationView.this.gbR.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.gbH.l(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.gbR.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.gbH.l(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.gbU) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.gbQ) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.gbZ) {
                        AlaLiveBottomOperationView.this.gcu = view;
                        if (com.baidu.live.v.a.Ge().aWF.ayA == 1) {
                            if (!AlaLiveBottomOperationView.this.aTs) {
                                AlaLiveBottomOperationView.this.gbH.l(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aTu = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.gbH.l(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.gcb) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.gcc) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.fXQ) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.gce) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.gch) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.gcj) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.gcm) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.gcn) {
                        AlaLiveBottomOperationView.this.gbH.l(view, 19);
                    }
                }
            }
        };
        this.aTv = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.aTu == 1 || AlaLiveBottomOperationView.this.aTu == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.aTu == 1) {
                                    AlaLiveBottomOperationView.this.bD(AlaLiveBottomOperationView.this.gct);
                                } else if (AlaLiveBottomOperationView.this.aTu == 2) {
                                    AlaLiveBottomOperationView.this.gbH.l(AlaLiveBottomOperationView.this.gcu, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.aTu = 0;
                    }
                }
            }
        };
        this.aUs = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kx(boolean z) {
        if (this.gbH != null && z) {
            this.gbH.l(this.gbK, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.gbI = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.gbJ = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.gbK = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.gbL = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.gbL.setDefaultResource(a.f.icon_quick_gift_def);
        this.gbM = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.gbN = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.gbO = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.gbR = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.gbS = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.gbT = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.gbU = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.gbV = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.gbW = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.gbX = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.gbY = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.gbP = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.gbQ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.gbZ = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.gca = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.gcb = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.gcc = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.fXQ = this.rootView.findViewById(a.g.host_goods_layout);
        this.fXR = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.gcd = (TBLottieAnimationView) this.rootView.findViewById(a.g.host_goods_lottieView);
        this.gcd.setImageAssetsFolder("images/");
        this.gcd.setAnimation("icon_shopping.json");
        this.gcd.setRepeatCount(0);
        this.gcd.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AlaLiveBottomOperationView.this.lj(false);
            }
        });
        this.gcs = new a();
        this.gce = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.gcf = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.gcg = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.gch = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.gci = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.gci.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.gcj = this.rootView.findViewById(a.g.turntable);
        this.gck = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.gcl = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.gcm = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.gcn = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        xT();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.gcq != i) {
            this.gcq = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbI.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.gbI.setLayoutParams(layoutParams);
        }
    }

    private void xT() {
        this.gbK.setOnClickListener(this.aUZ);
        this.gbM.setOnClickListener(this.aUZ);
        this.gbO.setOnClickListener(this.aUZ);
        this.gcb.setOnClickListener(this.aUZ);
        this.gbS.setOnClickListener(this.aUZ);
        this.gbU.setOnClickListener(this.aUZ);
        this.gbI.setOnClickListener(this.aUZ);
        this.gbQ.setOnClickListener(this.aUZ);
        this.gbZ.setOnClickListener(this.aUZ);
        this.gcc.setOnClickListener(this.aUZ);
        this.fXQ.setOnClickListener(this.aUZ);
        this.gce.setOnClickListener(this.aUZ);
        this.gch.setOnClickListener(this.aUZ);
        this.gcj.setOnClickListener(this.aUZ);
        this.gcm.setOnClickListener(this.aUZ);
        this.gcn.setOnClickListener(this.aUZ);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gbH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.gbH.l(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.gcm;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.aTv);
        MessageManager.getInstance().unRegisterListener(this.aMA);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2 = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.Ge().Gh()) {
                z = false;
            }
            x xVar = com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ;
            if (xVar == null) {
                z2 = false;
            } else if (xVar.awa == 1 || TextUtils.isEmpty(xVar.iconUrl)) {
                z2 = false;
            }
            if (z2) {
                this.gbM.setAlpha(0.0f);
                this.gce.setVisibility(8);
                this.gch.setVisibility(0);
                if (xVar != null && !TextUtils.isEmpty(xVar.iconUrl)) {
                    BdLog.d("iconUrl:" + xVar.iconUrl);
                    this.gci.startLoad(xVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.gbM.setAlpha(0.0f);
                this.gch.setVisibility(8);
                this.gce.setVisibility(0);
                bFI();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.gcr.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.gcr.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.gbM.setAlpha(1.0f);
                this.gce.setVisibility(8);
                this.gch.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (this.fXQ.getVisibility() == 0 && this.gcd != null && this.fXR != null) {
            if (z) {
                if (!this.gcd.isAnimating()) {
                    this.gcd.setVisibility(0);
                    this.fXR.setVisibility(4);
                    this.gcd.playAnimation();
                    return;
                }
                return;
            }
            if (this.gcd.isAnimating()) {
                this.gcd.cancelAnimation();
            }
            this.gcd.setVisibility(4);
            this.fXR.setVisibility(0);
        }
    }

    public void lk(boolean z) {
        if (this.gcs != null) {
            if (z) {
                lj(true);
                this.handler.removeCallbacks(this.gcs);
                this.handler.postDelayed(this.gcs, 7000L);
                return;
            }
            lj(false);
            this.handler.removeCallbacks(this.gcs);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aTs = z;
        this.aTt = i;
        this.aJP = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aTF == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aTG);
            }
            this.mDialog = new BdAlertDialog(this.aUs.getPageActivity());
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
            this.mDialog.create(this.aUs);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aMA = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aMA.setTag(this.aUs.getUniqueId());
        MessageManager.getInstance().registerListener(this.aMA);
        this.aTv.setTag(this.aUs.getUniqueId());
        MessageManager.getInstance().registerListener(this.aTv);
    }

    private void bFI() {
        if (this.gcp == null) {
            this.gcp = new b();
        }
        this.handler.postDelayed(this.gcp, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.lj(true);
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.gcs, 12000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.gcf.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.gcf.setVisibility(8);
                AlaLiveBottomOperationView.this.gcg.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.gcf.setVisibility(0);
                AlaLiveBottomOperationView.this.gcg.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.gcp, 1000L);
        }
    }
}
