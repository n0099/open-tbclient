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
import com.baidu.live.data.aa;
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
/* loaded from: classes7.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aBm;
    private int aTf;
    public CustomMessageListener aVP;
    private boolean bdo;
    private int bdp;
    private BdPageContext bdq;
    private int bdr;
    public CustomMessageListener bdw;
    public FrameLayout gDG;
    private b gGQ;
    public RelativeLayout gGR;
    public ImageView gGS;
    public FrameLayout gGT;
    public TbImageView gGU;
    public FrameLayout gGV;
    public ImageView gGW;
    public FrameLayout gGX;
    public ImageView gGY;
    public FrameLayout gGZ;
    private Set<Long> gHA;
    private View gHB;
    private View gHC;
    public ImageView gHa;
    public FrameLayout gHb;
    public TextView gHc;
    public FrameLayout gHd;
    public LinearLayout gHe;
    public TextView gHf;
    public View gHg;
    public TextView gHh;
    public View gHi;
    public ImageView gHj;
    public ImageView gHk;
    public FrameLayout gHl;
    public FrameLayout gHm;
    public ImageView gHn;
    public ImageView gHo;
    public FrameLayout gHp;
    public TbImageView gHq;
    private ViewGroup gHr;
    public View gHs;
    public ImageView gHt;
    public TurnTableLuckyCountDownView gHu;
    public ImageView gHv;
    public ImageView gHw;
    private boolean gHx;
    private a gHy;
    private int gHz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.gHx = false;
        this.handler = new Handler();
        this.gHz = -1;
        this.gHA = new HashSet();
        this.bdr = 0;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.gGQ != null) {
                    if (view == AlaLiveBottomOperationView.this.gGX) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.gGR) {
                        AlaLiveBottomOperationView.this.gHB = view;
                        if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                            if (!AlaLiveBottomOperationView.this.bdo) {
                                AlaLiveBottomOperationView.this.bP(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bdr = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bP(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.gGT) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.gGQ.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.gGV) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.gHb) {
                        AlaLiveBottomOperationView.this.gHx = AlaLiveBottomOperationView.this.gHx ? false : true;
                        if (AlaLiveBottomOperationView.this.gHx) {
                            AlaLiveBottomOperationView.this.gHa.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.gGQ.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.gHa.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.gGQ.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.gHd) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.gGZ) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.gHj) {
                        AlaLiveBottomOperationView.this.gHC = view;
                        if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                            if (!AlaLiveBottomOperationView.this.bdo) {
                                AlaLiveBottomOperationView.this.gGQ.m(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bdr = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.gGQ.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.gHl) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.gDG) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.gHm) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.gHp) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.gHs) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.gHv) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.gHw) {
                        AlaLiveBottomOperationView.this.gGQ.m(view, 19);
                    }
                }
            }
        };
        this.bdw = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bdr == 1 || AlaLiveBottomOperationView.this.bdr == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bdr == 1) {
                                    AlaLiveBottomOperationView.this.bP(AlaLiveBottomOperationView.this.gHB);
                                } else if (AlaLiveBottomOperationView.this.bdr == 2) {
                                    AlaLiveBottomOperationView.this.gGQ.m(AlaLiveBottomOperationView.this.gHC, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bdr = 0;
                    }
                }
            }
        };
        this.bdq = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lP(boolean z) {
        if (this.gGQ != null && z) {
            this.gGQ.m(this.gGT, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.gGT.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.gHj.setVisibility(z ? 0 : 8);
        this.gHi.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.gGR = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.gGS = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.gGT = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.gGU = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.gGU.setDefaultResource(a.f.icon_quick_gift_def);
        this.gGV = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.gGW = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.gGX = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.gHa = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.gHb = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.gHc = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.gHd = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.gHe = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.gHf = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.gHg = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.gHh = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.gGY = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.gGZ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.gHi = this.rootView.findViewById(a.g.divider);
        this.gHj = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.gHk = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.gHl = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.gDG = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.gHr = (ViewGroup) this.rootView.findViewById(a.g.host_goods_layout_parent);
        this.gHr.setVisibility(8);
        this.gHm = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.gHn = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.gHo = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.gHp = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.gHq = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.gHq.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.gHs = this.rootView.findViewById(a.g.turntable);
        this.gHt = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.gHu = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.gHv = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.gHw = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        Ey();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.gHz != i) {
            this.gHz = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGR.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.gGR.setLayoutParams(layoutParams);
        }
    }

    private void Ey() {
        this.gGT.setOnClickListener(this.aBm);
        this.gGV.setOnClickListener(this.aBm);
        this.gGX.setOnClickListener(this.aBm);
        this.gHl.setOnClickListener(this.aBm);
        this.gHb.setOnClickListener(this.aBm);
        this.gHd.setOnClickListener(this.aBm);
        this.gGR.setOnClickListener(this.aBm);
        this.gGZ.setOnClickListener(this.aBm);
        this.gHj.setOnClickListener(this.aBm);
        this.gDG.setOnClickListener(this.aBm);
        this.gHm.setOnClickListener(this.aBm);
        this.gHp.setOnClickListener(this.aBm);
        this.gHs.setOnClickListener(this.aBm);
        this.gHv.setOnClickListener(this.aBm);
        this.gHw.setOnClickListener(this.aBm);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void bO(View view) {
        if (this.gHr != null) {
            this.gHr.setVisibility(0);
            this.gHr.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.gGQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.gGQ.m(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.gHv;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bdw);
        MessageManager.getInstance().unRegisterListener(this.aVP);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2 = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.w.a.Nk().Nn()) {
                z = false;
            }
            aa aaVar = com.baidu.tieba.ala.liveroom.w.b.bWy().beU;
            if (aaVar == null) {
                z2 = false;
            } else if (aaVar.aEI == 1 || TextUtils.isEmpty(aaVar.iconUrl)) {
                z2 = false;
            }
            if (z2) {
                this.gGV.setAlpha(0.0f);
                this.gHm.setVisibility(8);
                this.gHp.setVisibility(0);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.iconUrl)) {
                    BdLog.d("iconUrl:" + aaVar.iconUrl);
                    this.gHq.startLoad(aaVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.gGV.setAlpha(0.0f);
                this.gHp.setVisibility(8);
                this.gHm.setVisibility(0);
                bVY();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.gHA.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.gHA.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.gGV.setAlpha(1.0f);
                this.gHm.setVisibility(8);
                this.gHp.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bdo = z;
        this.bdp = i;
        this.aTf = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcy == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcz);
            }
            this.mDialog = new BdAlertDialog(this.bdq.getPageActivity());
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
            this.mDialog.create(this.bdq);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aVP.setTag(this.bdq.getUniqueId());
        MessageManager.getInstance().registerListener(this.aVP);
        this.bdw.setTag(this.bdq.getUniqueId());
        MessageManager.getInstance().registerListener(this.bdw);
    }

    private void bVY() {
        if (this.gHy == null) {
            this.gHy = new a();
        }
        this.handler.postDelayed(this.gHy, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.gHn.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.gHn.setVisibility(8);
                AlaLiveBottomOperationView.this.gHo.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.gHn.setVisibility(0);
                AlaLiveBottomOperationView.this.gHo.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.gHy, 1000L);
        }
    }
}
