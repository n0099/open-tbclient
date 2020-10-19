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
    private View.OnClickListener aEX;
    private int aYE;
    public CustomMessageListener bbC;
    private boolean bjT;
    private int bjU;
    private BdPageContext bjV;
    private int bjW;
    public CustomMessageListener bkb;
    public FrameLayout gVF;
    private b gYQ;
    public RelativeLayout gYR;
    public ImageView gYS;
    public FrameLayout gYT;
    public TbImageView gYU;
    public FrameLayout gYV;
    public ImageView gYW;
    public FrameLayout gYX;
    public ImageView gYY;
    public FrameLayout gYZ;
    private View gZA;
    private View gZB;
    private boolean gZC;
    private boolean gZD;
    public ImageView gZa;
    public FrameLayout gZb;
    public TextView gZc;
    public FrameLayout gZd;
    public LinearLayout gZe;
    public TextView gZf;
    public View gZg;
    public TextView gZh;
    public ImageView gZi;
    public ImageView gZj;
    public FrameLayout gZk;
    public FrameLayout gZl;
    public ImageView gZm;
    public ImageView gZn;
    public FrameLayout gZo;
    public TbImageView gZp;
    private ViewGroup gZq;
    public View gZr;
    public ImageView gZs;
    public TurnTableLuckyCountDownView gZt;
    public ImageView gZu;
    public ImageView gZv;
    private boolean gZw;
    private a gZx;
    private int gZy;
    private Set<Long> gZz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.gZw = false;
        this.handler = new Handler();
        this.gZy = -1;
        this.gZz = new HashSet();
        this.bjW = 0;
        this.gZC = false;
        this.gZD = false;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.gYQ != null) {
                    if (view == AlaLiveBottomOperationView.this.gYX) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gYR) {
                        AlaLiveBottomOperationView.this.gZA = view;
                        if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                            if (!AlaLiveBottomOperationView.this.bjT) {
                                AlaLiveBottomOperationView.this.bY(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bjW = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bY(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.gYT) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.gYQ.o(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gYV) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gZb) {
                        AlaLiveBottomOperationView.this.gZw = AlaLiveBottomOperationView.this.gZw ? false : true;
                        if (AlaLiveBottomOperationView.this.gZw) {
                            AlaLiveBottomOperationView.this.gZa.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.gYQ.o(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.gZa.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.gYQ.o(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.gZd) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.gYZ) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.gZi) {
                        AlaLiveBottomOperationView.this.gZB = view;
                        if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                            if (!AlaLiveBottomOperationView.this.bjT) {
                                AlaLiveBottomOperationView.this.gYQ.o(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bjW = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.gYQ.o(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.gZk) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.gVF) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.gZl) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.gZo) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.gZr) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.gZu) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.gZv) {
                        AlaLiveBottomOperationView.this.gYQ.o(view, 19);
                    }
                }
            }
        };
        this.bkb = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bjW == 1 || AlaLiveBottomOperationView.this.bjW == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bjW == 1) {
                                    AlaLiveBottomOperationView.this.bY(AlaLiveBottomOperationView.this.gZA);
                                } else if (AlaLiveBottomOperationView.this.bjW == 2) {
                                    AlaLiveBottomOperationView.this.gYQ.o(AlaLiveBottomOperationView.this.gZB, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bjW = 0;
                    }
                }
            }
        };
        this.bjV = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void Pl() {
        this.gZC = false;
        this.gZD = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mt(boolean z) {
        if (this.gYQ != null && z) {
            this.gYQ.o(this.gYT, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.gYT.setVisibility(z ? 0 : 8);
        if (z && !this.gZC) {
            this.gZC = true;
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "gifticon_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.gZi.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.gYR = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.gYS = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.gYT = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.gYU = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.gYU.setDefaultResource(a.f.icon_quick_gift_def);
        this.gYV = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.gYW = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.gYX = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.gZa = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.gZb = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.gZc = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.gZd = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.gZe = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.gZf = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.gZg = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.gZh = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.gYY = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.gYZ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.gZi = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.gZj = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.gZk = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.gVF = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.gZq = (ViewGroup) this.rootView.findViewById(a.g.host_goods_layout_parent);
        this.gZq.setVisibility(8);
        this.gZl = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.gZm = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.gZn = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.gZo = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.gZp = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.gZp.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.gZr = this.rootView.findViewById(a.g.turntable);
        this.gZs = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.gZt = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.gZu = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.gZv = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        FL();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.gZy != i) {
            this.gZy = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYR.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.gYR.setLayoutParams(layoutParams);
        }
    }

    private void FL() {
        this.gYT.setOnClickListener(this.aEX);
        this.gYV.setOnClickListener(this.aEX);
        this.gYX.setOnClickListener(this.aEX);
        this.gZk.setOnClickListener(this.aEX);
        this.gZb.setOnClickListener(this.aEX);
        this.gZd.setOnClickListener(this.aEX);
        this.gYR.setOnClickListener(this.aEX);
        this.gYZ.setOnClickListener(this.aEX);
        this.gZi.setOnClickListener(this.aEX);
        this.gVF.setOnClickListener(this.aEX);
        this.gZl.setOnClickListener(this.aEX);
        this.gZo.setOnClickListener(this.aEX);
        this.gZr.setOnClickListener(this.aEX);
        this.gZu.setOnClickListener(this.aEX);
        this.gZv.setOnClickListener(this.aEX);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void bX(View view) {
        if (this.gZq != null) {
            this.gZq.setVisibility(0);
            this.gZq.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.gYQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.gYQ.o(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.gZu;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bkb);
        MessageManager.getInstance().unRegisterListener(this.bbC);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.x.a.OS().OV()) {
                z = false;
            }
            af afVar = com.baidu.tieba.ala.liveroom.w.b.cbG().blx;
            if (afVar != null) {
                z2 = (afVar.aIX == 1 || TextUtils.isEmpty(afVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.gYV.setAlpha(0.0f);
                this.gZl.setVisibility(8);
                this.gZo.setVisibility(0);
                if (afVar != null && !TextUtils.isEmpty(afVar.iconUrl)) {
                    BdLog.d("iconUrl:" + afVar.iconUrl);
                    this.gZp.startLoad(afVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.gYV.setAlpha(0.0f);
                this.gZo.setVisibility(8);
                this.gZl.setVisibility(0);
                cbd();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.gZz.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.gZz.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.gYV.setAlpha(1.0f);
                if (!this.gZD) {
                    this.gZD = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quickgift_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                }
                this.gZl.setVisibility(8);
                this.gZo.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bjT = z;
        this.bjU = i;
        this.aYE = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.biW == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.biX);
            }
            this.mDialog = new BdAlertDialog(this.bjV.getPageActivity());
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
            this.mDialog.create(this.bjV);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bbC.setTag(this.bjV.getUniqueId());
        MessageManager.getInstance().registerListener(this.bbC);
        this.bkb.setTag(this.bjV.getUniqueId());
        MessageManager.getInstance().registerListener(this.bkb);
    }

    private void cbd() {
        if (this.gZx == null) {
            this.gZx = new a();
        }
        this.handler.postDelayed(this.gZx, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.gZm.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.gZm.setVisibility(8);
                AlaLiveBottomOperationView.this.gZn.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.gZm.setVisibility(0);
                AlaLiveBottomOperationView.this.gZn.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.gZx, 1000L);
        }
    }
}
