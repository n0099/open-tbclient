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
    private View.OnClickListener aBk;
    private int aTd;
    public CustomMessageListener aVN;
    private boolean bdm;
    private int bdn;
    private BdPageContext bdo;
    private int bdp;
    public CustomMessageListener bdu;
    public FrameLayout gDC;
    private b gGM;
    public RelativeLayout gGN;
    public ImageView gGO;
    public FrameLayout gGP;
    public TbImageView gGQ;
    public FrameLayout gGR;
    public ImageView gGS;
    public FrameLayout gGT;
    public ImageView gGU;
    public FrameLayout gGV;
    public ImageView gGW;
    public FrameLayout gGX;
    public TextView gGY;
    public FrameLayout gGZ;
    public LinearLayout gHa;
    public TextView gHb;
    public View gHc;
    public TextView gHd;
    public View gHe;
    public ImageView gHf;
    public ImageView gHg;
    public FrameLayout gHh;
    public FrameLayout gHi;
    public ImageView gHj;
    public ImageView gHk;
    public FrameLayout gHl;
    public TbImageView gHm;
    private ViewGroup gHn;
    public View gHo;
    public ImageView gHp;
    public TurnTableLuckyCountDownView gHq;
    public ImageView gHr;
    public ImageView gHs;
    private boolean gHt;
    private a gHu;
    private int gHv;
    private Set<Long> gHw;
    private View gHx;
    private View gHy;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.gHt = false;
        this.handler = new Handler();
        this.gHv = -1;
        this.gHw = new HashSet();
        this.bdp = 0;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.gGM != null) {
                    if (view == AlaLiveBottomOperationView.this.gGT) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.gGN) {
                        AlaLiveBottomOperationView.this.gHx = view;
                        if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                            if (!AlaLiveBottomOperationView.this.bdm) {
                                AlaLiveBottomOperationView.this.bP(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bdp = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bP(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.gGP) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.gGM.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.gGR) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.gGX) {
                        AlaLiveBottomOperationView.this.gHt = AlaLiveBottomOperationView.this.gHt ? false : true;
                        if (AlaLiveBottomOperationView.this.gHt) {
                            AlaLiveBottomOperationView.this.gGW.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.gGM.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.gGW.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.gGM.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.gGZ) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.gGV) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.gHf) {
                        AlaLiveBottomOperationView.this.gHy = view;
                        if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                            if (!AlaLiveBottomOperationView.this.bdm) {
                                AlaLiveBottomOperationView.this.gGM.m(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bdp = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.gGM.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.gHh) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.gDC) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.gHi) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.gHl) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.gHo) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.gHr) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.gHs) {
                        AlaLiveBottomOperationView.this.gGM.m(view, 19);
                    }
                }
            }
        };
        this.bdu = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bdp == 1 || AlaLiveBottomOperationView.this.bdp == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bdp == 1) {
                                    AlaLiveBottomOperationView.this.bP(AlaLiveBottomOperationView.this.gHx);
                                } else if (AlaLiveBottomOperationView.this.bdp == 2) {
                                    AlaLiveBottomOperationView.this.gGM.m(AlaLiveBottomOperationView.this.gHy, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bdp = 0;
                    }
                }
            }
        };
        this.bdo = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lN(boolean z) {
        if (this.gGM != null && z) {
            this.gGM.m(this.gGP, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.gGP.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.gHf.setVisibility(z ? 0 : 8);
        this.gHe.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.gGN = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.gGO = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.gGP = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.gGQ = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.gGQ.setDefaultResource(a.f.icon_quick_gift_def);
        this.gGR = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.gGS = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.gGT = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.gGW = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.gGX = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.gGY = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.gGZ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.gHa = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.gHb = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.gHc = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.gHd = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.gGU = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.gGV = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.gHe = this.rootView.findViewById(a.g.divider);
        this.gHf = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.gHg = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.gHh = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.gDC = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.gHn = (ViewGroup) this.rootView.findViewById(a.g.host_goods_layout_parent);
        this.gHn.setVisibility(8);
        this.gHi = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.gHj = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.gHk = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.gHl = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.gHm = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.gHm.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.gHo = this.rootView.findViewById(a.g.turntable);
        this.gHp = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.gHq = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.gHr = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.gHs = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        Ey();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.gHv != i) {
            this.gHv = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGN.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.gGN.setLayoutParams(layoutParams);
        }
    }

    private void Ey() {
        this.gGP.setOnClickListener(this.aBk);
        this.gGR.setOnClickListener(this.aBk);
        this.gGT.setOnClickListener(this.aBk);
        this.gHh.setOnClickListener(this.aBk);
        this.gGX.setOnClickListener(this.aBk);
        this.gGZ.setOnClickListener(this.aBk);
        this.gGN.setOnClickListener(this.aBk);
        this.gGV.setOnClickListener(this.aBk);
        this.gHf.setOnClickListener(this.aBk);
        this.gDC.setOnClickListener(this.aBk);
        this.gHi.setOnClickListener(this.aBk);
        this.gHl.setOnClickListener(this.aBk);
        this.gHo.setOnClickListener(this.aBk);
        this.gHr.setOnClickListener(this.aBk);
        this.gHs.setOnClickListener(this.aBk);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void bO(View view) {
        if (this.gHn != null) {
            this.gHn.setVisibility(0);
            this.gHn.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.gGM = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.gGM.m(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.gHr;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bdu);
        MessageManager.getInstance().unRegisterListener(this.aVN);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2 = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.w.a.Nk().Nn()) {
                z = false;
            }
            aa aaVar = com.baidu.tieba.ala.liveroom.w.b.bWx().beS;
            if (aaVar == null) {
                z2 = false;
            } else if (aaVar.aEG == 1 || TextUtils.isEmpty(aaVar.iconUrl)) {
                z2 = false;
            }
            if (z2) {
                this.gGR.setAlpha(0.0f);
                this.gHi.setVisibility(8);
                this.gHl.setVisibility(0);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.iconUrl)) {
                    BdLog.d("iconUrl:" + aaVar.iconUrl);
                    this.gHm.startLoad(aaVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.gGR.setAlpha(0.0f);
                this.gHl.setVisibility(8);
                this.gHi.setVisibility(0);
                bVX();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.gHw.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.gHw.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.gGR.setAlpha(1.0f);
                this.gHi.setVisibility(8);
                this.gHl.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bdm = z;
        this.bdn = i;
        this.aTd = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcw == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcx);
            }
            this.mDialog = new BdAlertDialog(this.bdo.getPageActivity());
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
            this.mDialog.create(this.bdo);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aVN = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aVN.setTag(this.bdo.getUniqueId());
        MessageManager.getInstance().registerListener(this.aVN);
        this.bdu.setTag(this.bdo.getUniqueId());
        MessageManager.getInstance().registerListener(this.bdu);
    }

    private void bVX() {
        if (this.gHu == null) {
            this.gHu = new a();
        }
        this.handler.postDelayed(this.gHu, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.gHj.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.gHj.setVisibility(8);
                AlaLiveBottomOperationView.this.gHk.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.gHj.setVisibility(0);
                AlaLiveBottomOperationView.this.gHk.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.gHu, 1000L);
        }
    }
}
