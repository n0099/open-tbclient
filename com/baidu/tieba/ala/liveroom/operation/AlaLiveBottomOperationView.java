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
import com.baidu.live.data.ai;
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
    private View.OnClickListener aFf;
    private int bab;
    public CustomMessageListener bcQ;
    private boolean blo;
    private int blp;
    private BdPageContext blq;
    private int blr;
    public CustomMessageListener blw;
    private Handler handler;
    public FrameLayout hht;
    private b hkG;
    public RelativeLayout hkH;
    public ImageView hkI;
    public FrameLayout hkJ;
    public TbImageView hkK;
    public FrameLayout hkL;
    public ImageView hkM;
    public FrameLayout hkN;
    public ImageView hkO;
    public FrameLayout hkP;
    public ImageView hkQ;
    public FrameLayout hkR;
    public TextView hkS;
    public FrameLayout hkT;
    public LinearLayout hkU;
    public TextView hkV;
    public View hkW;
    public TextView hkX;
    public ImageView hkY;
    public ImageView hkZ;
    public FrameLayout hla;
    public FrameLayout hlb;
    public ImageView hlc;
    public ImageView hld;
    public FrameLayout hle;
    public TbImageView hlf;
    private ViewGroup hlg;
    public View hlh;
    public ImageView hli;
    public TurnTableLuckyCountDownView hlj;
    public ImageView hlk;
    public ImageView hll;
    private boolean hlm;
    private a hln;
    private int hlo;
    private Set<Long> hlp;
    private View hlq;
    private View hlr;
    private boolean hls;
    private boolean hlt;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hlm = false;
        this.handler = new Handler();
        this.hlo = -1;
        this.hlp = new HashSet();
        this.blr = 0;
        this.hls = false;
        this.hlt = false;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.hkG != null) {
                    if (view == AlaLiveBottomOperationView.this.hkN) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 3);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.hkH) {
                        AlaLiveBottomOperationView.this.hlq = view;
                        if (com.baidu.live.z.a.Pq().bmJ.aMo == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                            if (!AlaLiveBottomOperationView.this.blo) {
                                AlaLiveBottomOperationView.this.cc(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.blr = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cc(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hkJ) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.hkG.p(view, 2);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.hkL) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 13);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.hkR) {
                        AlaLiveBottomOperationView.this.hlm = AlaLiveBottomOperationView.this.hlm ? false : true;
                        if (AlaLiveBottomOperationView.this.hlm) {
                            AlaLiveBottomOperationView.this.hkQ.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.hkG.p(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.hkQ.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.hkG.p(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.hkT) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.hkP) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.hkY) {
                        AlaLiveBottomOperationView.this.hlr = view;
                        if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                            if (!AlaLiveBottomOperationView.this.blo) {
                                AlaLiveBottomOperationView.this.hkG.p(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.blr = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.hkG.p(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.hla) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.hht) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.hlb) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.hle) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.hlh) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 17);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    } else if (view == AlaLiveBottomOperationView.this.hlk) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.hll) {
                        AlaLiveBottomOperationView.this.hkG.p(view, 19);
                    }
                }
            }
        };
        this.blw = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.blr == 1 || AlaLiveBottomOperationView.this.blr == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.blr == 1) {
                                    AlaLiveBottomOperationView.this.cc(AlaLiveBottomOperationView.this.hlq);
                                } else if (AlaLiveBottomOperationView.this.blr == 2) {
                                    AlaLiveBottomOperationView.this.hkG.p(AlaLiveBottomOperationView.this.hlr, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.blr = 0;
                    }
                }
            }
        };
        this.blq = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void Qe() {
        this.hls = false;
        this.hlt = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mJ(boolean z) {
        if (this.hkG != null && z) {
            this.hkG.p(this.hkJ, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hkJ.setVisibility(z ? 0 : 8);
        if (z && !this.hls) {
            this.hls = true;
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "gifticon_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    public void setQuickImInputVisible(boolean z) {
        this.hkY.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.hkH = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.hkI = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.hkJ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.hkK = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.hkK.setDefaultResource(a.f.icon_quick_gift_def);
        this.hkL = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.hkM = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.hkN = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.hkQ = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.hkR = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.hkS = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.hkT = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.hkU = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.hkV = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.hkW = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.hkX = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.hkO = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.hkP = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.hkY = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.hkZ = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.hla = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.hht = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.hlg = (ViewGroup) this.rootView.findViewById(a.g.host_goods_layout_parent);
        this.hlg.setVisibility(8);
        this.hlb = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.hlc = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.hld = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.hle = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.hlf = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.hlf.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.hlh = this.rootView.findViewById(a.g.turntable);
        this.hli = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.hlj = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.hlk = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.hll = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        Ga();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hlo != i) {
            this.hlo = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hkH.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.hkH.setLayoutParams(layoutParams);
        }
    }

    private void Ga() {
        this.hkJ.setOnClickListener(this.aFf);
        this.hkL.setOnClickListener(this.aFf);
        this.hkN.setOnClickListener(this.aFf);
        this.hla.setOnClickListener(this.aFf);
        this.hkR.setOnClickListener(this.aFf);
        this.hkT.setOnClickListener(this.aFf);
        this.hkH.setOnClickListener(this.aFf);
        this.hkP.setOnClickListener(this.aFf);
        this.hkY.setOnClickListener(this.aFf);
        this.hht.setOnClickListener(this.aFf);
        this.hlb.setOnClickListener(this.aFf);
        this.hle.setOnClickListener(this.aFf);
        this.hlh.setOnClickListener(this.aFf);
        this.hlk.setOnClickListener(this.aFf);
        this.hll.setOnClickListener(this.aFf);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void cb(View view) {
        if (this.hlg != null) {
            this.hlg.setVisibility(0);
            this.hlg.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.hkG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.hkG.p(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.hlk;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.blw);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.z.a.Pq().Pt()) {
                z = false;
            }
            ai aiVar = com.baidu.tieba.ala.liveroom.w.b.ceK().bmT;
            if (aiVar != null) {
                z2 = (aiVar.aJz == 1 || TextUtils.isEmpty(aiVar.iconUrl)) ? false : true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.hkL.setAlpha(0.0f);
                this.hlb.setVisibility(8);
                this.hle.setVisibility(0);
                if (aiVar != null && !TextUtils.isEmpty(aiVar.iconUrl)) {
                    BdLog.d("iconUrl:" + aiVar.iconUrl);
                    this.hlf.startLoad(aiVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.hkL.setAlpha(0.0f);
                this.hle.setVisibility(8);
                this.hlb.setVisibility(0);
                ceh();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.hlp.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.hlp.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.hkL.setAlpha(1.0f);
                if (!this.hlt) {
                    this.hlt = true;
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quickgift_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                }
                this.hlb.setVisibility(8);
                this.hle.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.blo = z;
        this.blp = i;
        this.bab = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bkr == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bks);
            }
            this.mDialog = new BdAlertDialog(this.blq.getPageActivity());
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
            this.mDialog.create(this.blq);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bcQ.setTag(this.blq.getUniqueId());
        MessageManager.getInstance().registerListener(this.bcQ);
        this.blw.setTag(this.blq.getUniqueId());
        MessageManager.getInstance().registerListener(this.blw);
    }

    private void ceh() {
        if (this.hln == null) {
            this.hln = new a();
        }
        this.handler.postDelayed(this.hln, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.hlc.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.hlc.setVisibility(8);
                AlaLiveBottomOperationView.this.hld.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.hlc.setVisibility(0);
                AlaLiveBottomOperationView.this.hld.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.hln, 1000L);
        }
    }
}
