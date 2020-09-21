package com.baidu.tieba.ala.liveroom.operation;

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
import com.baidu.live.data.af;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyCountDownView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aBS;
    private int aVt;
    public CustomMessageListener aYi;
    private boolean bgd;
    private int bge;
    private BdPageContext bgf;
    private int bgg;
    public CustomMessageListener bgl;
    public FrameLayout gHf;
    public FrameLayout gKA;
    public TextView gKB;
    public FrameLayout gKC;
    public LinearLayout gKD;
    public TextView gKE;
    public View gKF;
    public TextView gKG;
    public View gKH;
    public ImageView gKI;
    public ImageView gKJ;
    public FrameLayout gKK;
    public FrameLayout gKL;
    public ImageView gKM;
    public ImageView gKN;
    public FrameLayout gKO;
    public TbImageView gKP;
    private ViewGroup gKQ;
    public View gKR;
    public ImageView gKS;
    public TurnTableLuckyCountDownView gKT;
    public ImageView gKU;
    public ImageView gKV;
    private boolean gKW;
    private a gKX;
    private int gKY;
    private Set<Long> gKZ;
    private b gKp;
    public RelativeLayout gKq;
    public ImageView gKr;
    public FrameLayout gKs;
    public TbImageView gKt;
    public FrameLayout gKu;
    public ImageView gKv;
    public FrameLayout gKw;
    public ImageView gKx;
    public FrameLayout gKy;
    public ImageView gKz;
    private View gLa;
    private View gLb;
    private boolean gLc;
    private boolean gLd;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.gKW = false;
        this.handler = new Handler();
        this.gKY = -1;
        this.gKZ = new HashSet();
        this.bgg = 0;
        this.gLc = false;
        this.gLd = false;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.gKp != null) {
                    if (view == AlaLiveBottomOperationView.this.gKw) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gKq) {
                        AlaLiveBottomOperationView.this.gLa = view;
                        if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                            if (!AlaLiveBottomOperationView.this.bgd) {
                                AlaLiveBottomOperationView.this.bU(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bgg = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bU(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.gKs) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.gKp.n(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gKu) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gKA) {
                        AlaLiveBottomOperationView.this.gKW = AlaLiveBottomOperationView.this.gKW ? false : true;
                        if (AlaLiveBottomOperationView.this.gKW) {
                            AlaLiveBottomOperationView.this.gKz.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.gKp.n(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.gKz.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.gKp.n(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.gKC) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.gKy) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.gKI) {
                        AlaLiveBottomOperationView.this.gLb = view;
                        if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                            if (!AlaLiveBottomOperationView.this.bgd) {
                                AlaLiveBottomOperationView.this.gKp.n(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bgg = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.gKp.n(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.gKK) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.gHf) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.gKL) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.gKO) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.gKR) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gKU) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.gKV) {
                        AlaLiveBottomOperationView.this.gKp.n(view, 19);
                    }
                }
            }
        };
        this.bgl = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bgg == 1 || AlaLiveBottomOperationView.this.bgg == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bgg == 1) {
                                    AlaLiveBottomOperationView.this.bU(AlaLiveBottomOperationView.this.gLa);
                                } else if (AlaLiveBottomOperationView.this.bgg == 2) {
                                    AlaLiveBottomOperationView.this.gKp.n(AlaLiveBottomOperationView.this.gLb, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bgg = 0;
                    }
                }
            }
        };
        this.bgf = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void Og() {
        this.gLc = false;
        this.gLd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lR(boolean z) {
        if (this.gKp != null && z) {
            this.gKp.n(this.gKs, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.gKs.setVisibility(z ? 0 : 8);
        if (z && !this.gLc) {
            this.gLc = true;
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "gifticon_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.gKI.setVisibility(z ? 0 : 8);
        this.gKH.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.gKq = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.gKr = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.gKs = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.gKt = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.gKt.setDefaultResource(a.f.icon_quick_gift_def);
        this.gKu = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.gKv = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.gKw = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.gKz = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.gKA = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.gKB = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.gKC = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.gKD = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.gKE = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.gKF = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.gKG = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.gKx = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.gKy = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.gKH = this.rootView.findViewById(a.g.divider);
        this.gKI = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.gKJ = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.gKK = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.gHf = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.gKQ = (ViewGroup) this.rootView.findViewById(a.g.host_goods_layout_parent);
        this.gKQ.setVisibility(8);
        this.gKL = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.gKM = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.gKN = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.gKO = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.gKP = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.gKP.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.gKR = this.rootView.findViewById(a.g.turntable);
        this.gKS = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.gKT = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.gKU = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.gKV = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        EP();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.gKY != i) {
            this.gKY = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKq.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.gKq.setLayoutParams(layoutParams);
        }
    }

    private void EP() {
        this.gKs.setOnClickListener(this.aBS);
        this.gKu.setOnClickListener(this.aBS);
        this.gKw.setOnClickListener(this.aBS);
        this.gKK.setOnClickListener(this.aBS);
        this.gKA.setOnClickListener(this.aBS);
        this.gKC.setOnClickListener(this.aBS);
        this.gKq.setOnClickListener(this.aBS);
        this.gKy.setOnClickListener(this.aBS);
        this.gKI.setOnClickListener(this.aBS);
        this.gHf.setOnClickListener(this.aBS);
        this.gKL.setOnClickListener(this.aBS);
        this.gKO.setOnClickListener(this.aBS);
        this.gKR.setOnClickListener(this.aBS);
        this.gKU.setOnClickListener(this.aBS);
        this.gKV.setOnClickListener(this.aBS);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void bT(View view) {
        if (this.gKQ != null) {
            this.gKQ.setVisibility(0);
            this.gKQ.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.gKp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.gKp.n(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.gKU;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bgl);
        MessageManager.getInstance().unRegisterListener(this.aYi);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.x.a.NN().NQ()) {
                z = false;
            }
            af afVar = com.baidu.tieba.ala.liveroom.w.b.bYg().bhH;
            if (afVar != null) {
                z2 = (afVar.aFT == 1 || TextUtils.isEmpty(afVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.gKu.setAlpha(0.0f);
                this.gKL.setVisibility(8);
                this.gKO.setVisibility(0);
                if (afVar != null && !TextUtils.isEmpty(afVar.iconUrl)) {
                    BdLog.d("iconUrl:" + afVar.iconUrl);
                    this.gKP.startLoad(afVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.gKu.setAlpha(0.0f);
                this.gKO.setVisibility(8);
                this.gKL.setVisibility(0);
                bXI();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.gKZ.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.gKZ.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.gKu.setAlpha(1.0f);
                if (!this.gLd) {
                    this.gLd = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quickgift_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                }
                this.gKL.setVisibility(8);
                this.gKO.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bgd = z;
        this.bge = i;
        this.aVt = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bfk == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bfl);
            }
            this.mDialog = new BdAlertDialog(this.bgf.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.2
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.3
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
            this.mDialog.create(this.bgf);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aYi.setTag(this.bgf.getUniqueId());
        MessageManager.getInstance().registerListener(this.aYi);
        this.bgl.setTag(this.bgf.getUniqueId());
        MessageManager.getInstance().registerListener(this.bgl);
    }

    private void bXI() {
        if (this.gKX == null) {
            this.gKX = new a();
        }
        this.handler.postDelayed(this.gKX, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.gKM.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.gKM.setVisibility(8);
                AlaLiveBottomOperationView.this.gKN.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.gKM.setVisibility(0);
                AlaLiveBottomOperationView.this.gKN.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.gKX, 1000L);
        }
    }
}
