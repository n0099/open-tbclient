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
import com.baidu.live.data.y;
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
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyCountDownView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private int aNQ;
    public CustomMessageListener aQz;
    private boolean aXW;
    private int aXX;
    private BdPageContext aXY;
    private int aXZ;
    public CustomMessageListener aYd;
    private View.OnClickListener awi;
    private b gtN;
    public RelativeLayout gtO;
    public ImageView gtP;
    public FrameLayout gtQ;
    public TbImageView gtR;
    public FrameLayout gtS;
    public ImageView gtT;
    public FrameLayout gtU;
    public ImageView gtV;
    public FrameLayout gtW;
    public ImageView gtX;
    public FrameLayout gtY;
    public TextView gtZ;
    private View guA;
    public FrameLayout gua;
    public LinearLayout gub;
    public TextView guc;
    public View gud;
    public TextView gue;
    public View guf;
    public ImageView gug;
    public ImageView guh;
    public FrameLayout gui;
    public FrameLayout guj;
    public FrameLayout guk;
    public ImageView gul;
    public ImageView gum;
    public FrameLayout gun;
    public TbImageView guo;
    private ViewGroup gup;
    public View guq;
    public ImageView gur;
    public TurnTableLuckyCountDownView gus;
    public ImageView gut;
    public ImageView guu;
    private boolean guv;
    private a guw;
    private int gux;
    private Set<Long> guy;
    private View guz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.guv = false;
        this.handler = new Handler();
        this.gux = -1;
        this.guy = new HashSet();
        this.aXZ = 0;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.gtN != null) {
                    if (view == AlaLiveBottomOperationView.this.gtU) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.gtO) {
                        AlaLiveBottomOperationView.this.guz = view;
                        if (com.baidu.live.v.a.Hs().aZn.aCd == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.v.a.Hs().aZn.aCc == 1) {
                            if (!AlaLiveBottomOperationView.this.aXW) {
                                AlaLiveBottomOperationView.this.bN(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aXZ = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bN(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.gtQ) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.gtN.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.gtS) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.gtY) {
                        AlaLiveBottomOperationView.this.guv = AlaLiveBottomOperationView.this.guv ? false : true;
                        if (AlaLiveBottomOperationView.this.guv) {
                            AlaLiveBottomOperationView.this.gtX.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.gtN.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.gtX.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.gtN.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.gua) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.gtW) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.gug) {
                        AlaLiveBottomOperationView.this.guA = view;
                        if (com.baidu.live.v.a.Hs().aZn.aCc == 1) {
                            if (!AlaLiveBottomOperationView.this.aXW) {
                                AlaLiveBottomOperationView.this.gtN.m(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aXZ = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.gtN.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.gui) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.guj) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.guk) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.gun) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.guq) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.gut) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.guu) {
                        AlaLiveBottomOperationView.this.gtN.m(view, 19);
                    }
                }
            }
        };
        this.aYd = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.aXZ == 1 || AlaLiveBottomOperationView.this.aXZ == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.aXZ == 1) {
                                    AlaLiveBottomOperationView.this.bN(AlaLiveBottomOperationView.this.guz);
                                } else if (AlaLiveBottomOperationView.this.aXZ == 2) {
                                    AlaLiveBottomOperationView.this.gtN.m(AlaLiveBottomOperationView.this.guA, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.aXZ = 0;
                    }
                }
            }
        };
        this.aXY = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lm(boolean z) {
        if (this.gtN != null && z) {
            this.gtN.m(this.gtQ, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.gtQ.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.gug.setVisibility(z ? 0 : 8);
        this.guf.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.gtO = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.gtP = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.gtQ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.gtR = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.gtR.setDefaultResource(a.f.icon_quick_gift_def);
        this.gtS = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.gtT = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.gtU = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.gtX = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.gtY = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.gtZ = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.gua = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.gub = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.guc = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.gud = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.gue = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.gtV = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.gtW = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.guf = this.rootView.findViewById(a.g.divider);
        this.gug = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.guh = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.gui = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.guj = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.gup = (ViewGroup) this.rootView.findViewById(a.g.host_goods_layout_parent);
        this.gup.setVisibility(8);
        this.guk = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.gul = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.gum = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.gun = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.guo = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.guo.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.guq = this.rootView.findViewById(a.g.turntable);
        this.gur = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.gus = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.gut = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.guu = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        yV();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.gux != i) {
            this.gux = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtO.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.gtO.setLayoutParams(layoutParams);
        }
    }

    private void yV() {
        this.gtQ.setOnClickListener(this.awi);
        this.gtS.setOnClickListener(this.awi);
        this.gtU.setOnClickListener(this.awi);
        this.gui.setOnClickListener(this.awi);
        this.gtY.setOnClickListener(this.awi);
        this.gua.setOnClickListener(this.awi);
        this.gtO.setOnClickListener(this.awi);
        this.gtW.setOnClickListener(this.awi);
        this.gug.setOnClickListener(this.awi);
        this.guj.setOnClickListener(this.awi);
        this.guk.setOnClickListener(this.awi);
        this.gun.setOnClickListener(this.awi);
        this.guq.setOnClickListener(this.awi);
        this.gut.setOnClickListener(this.awi);
        this.guu.setOnClickListener(this.awi);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void bM(View view) {
        if (this.gup != null) {
            this.gup.setVisibility(0);
            this.gup.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.gtN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.gtN.m(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.gut;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.aYd);
        MessageManager.getInstance().unRegisterListener(this.aQz);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2 = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.Hs().Hv()) {
                z = false;
            }
            y yVar = com.baidu.tieba.ala.liveroom.v.b.bMA().aZy;
            if (yVar == null) {
                z2 = false;
            } else if (yVar.azv == 1 || TextUtils.isEmpty(yVar.iconUrl)) {
                z2 = false;
            }
            if (z2) {
                this.gtS.setAlpha(0.0f);
                this.guk.setVisibility(8);
                this.gun.setVisibility(0);
                if (yVar != null && !TextUtils.isEmpty(yVar.iconUrl)) {
                    BdLog.d("iconUrl:" + yVar.iconUrl);
                    this.guo.startLoad(yVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.gtS.setAlpha(0.0f);
                this.gun.setVisibility(8);
                this.guk.setVisibility(0);
                bLV();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.guy.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.guy.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.gtS.setAlpha(1.0f);
                this.guk.setVisibility(8);
                this.gun.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aXW = z;
        this.aXX = i;
        this.aNQ = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aXg == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aXh);
            }
            this.mDialog = new BdAlertDialog(this.aXY.getPageActivity());
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
            this.mDialog.create(this.aXY);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aQz.setTag(this.aXY.getUniqueId());
        MessageManager.getInstance().registerListener(this.aQz);
        this.aYd.setTag(this.aXY.getUniqueId());
        MessageManager.getInstance().registerListener(this.aYd);
    }

    private void bLV() {
        if (this.guw == null) {
            this.guw = new a();
        }
        this.handler.postDelayed(this.guw, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.gul.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.gul.setVisibility(8);
                AlaLiveBottomOperationView.this.gum.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.gul.setVisibility(0);
                AlaLiveBottomOperationView.this.gum.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.guw, 1000L);
        }
    }
}
