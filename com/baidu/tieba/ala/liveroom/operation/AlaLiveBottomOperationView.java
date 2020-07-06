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
/* loaded from: classes3.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private int aMv;
    public CustomMessageListener aPg;
    private boolean aVY;
    private int aVZ;
    private BdPageContext aWZ;
    private int aWa;
    public CustomMessageListener aWc;
    private View.OnClickListener aXG;
    private b goM;
    public RelativeLayout goN;
    public ImageView goO;
    public FrameLayout goP;
    public TbImageView goQ;
    public FrameLayout goR;
    public ImageView goS;
    public FrameLayout goT;
    public ImageView goU;
    public FrameLayout goV;
    public ImageView goW;
    public FrameLayout goX;
    public TextView goY;
    public FrameLayout goZ;
    public LinearLayout gpa;
    public TextView gpb;
    public View gpc;
    public TextView gpd;
    public View gpe;
    public ImageView gpf;
    public ImageView gpg;
    public FrameLayout gph;
    public FrameLayout gpi;
    public FrameLayout gpj;
    public ImageView gpk;
    public ImageView gpl;
    public FrameLayout gpm;
    public TbImageView gpn;
    private ViewGroup gpo;
    public View gpp;
    public ImageView gpq;
    public TurnTableLuckyCountDownView gpr;
    public ImageView gps;
    public ImageView gpt;
    private boolean gpu;
    private a gpv;
    private int gpw;
    private Set<Long> gpx;
    private View gpy;
    private View gpz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mUserName;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.gpu = false;
        this.handler = new Handler();
        this.gpw = -1;
        this.gpx = new HashSet();
        this.aWa = 0;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.goM != null) {
                    if (view == AlaLiveBottomOperationView.this.goT) {
                        AlaLiveBottomOperationView.this.goM.l(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.goN) {
                        AlaLiveBottomOperationView.this.gpy = view;
                        if (com.baidu.live.v.a.Hm().aZp.aAQ == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.v.a.Hm().aZp.aAP == 1) {
                            if (!AlaLiveBottomOperationView.this.aVY) {
                                AlaLiveBottomOperationView.this.bH(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aWa = 1;
                        } else {
                            AlaLiveBottomOperationView.this.bH(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.goP) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.goM.l(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.goR) {
                        AlaLiveBottomOperationView.this.goM.l(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.goX) {
                        AlaLiveBottomOperationView.this.gpu = AlaLiveBottomOperationView.this.gpu ? false : true;
                        if (AlaLiveBottomOperationView.this.gpu) {
                            AlaLiveBottomOperationView.this.goW.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.goM.l(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.goW.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.goM.l(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.goZ) {
                        AlaLiveBottomOperationView.this.goM.l(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.goV) {
                        AlaLiveBottomOperationView.this.goM.l(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.gpf) {
                        AlaLiveBottomOperationView.this.gpz = view;
                        if (com.baidu.live.v.a.Hm().aZp.aAP == 1) {
                            if (!AlaLiveBottomOperationView.this.aVY) {
                                AlaLiveBottomOperationView.this.goM.l(view, 11);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.aWa = 2;
                            return;
                        }
                        AlaLiveBottomOperationView.this.goM.l(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.gph) {
                        AlaLiveBottomOperationView.this.goM.l(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.gpi) {
                        AlaLiveBottomOperationView.this.goM.l(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.gpj) {
                        AlaLiveBottomOperationView.this.goM.l(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.gpm) {
                        AlaLiveBottomOperationView.this.goM.l(view, 20);
                    } else if (view == AlaLiveBottomOperationView.this.gpp) {
                        AlaLiveBottomOperationView.this.goM.l(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.gps) {
                        AlaLiveBottomOperationView.this.goM.l(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.gpt) {
                        AlaLiveBottomOperationView.this.goM.l(view, 19);
                    }
                }
            }
        };
        this.aWc = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.aWa == 1 || AlaLiveBottomOperationView.this.aWa == 2) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.aWa == 1) {
                                    AlaLiveBottomOperationView.this.bH(AlaLiveBottomOperationView.this.gpy);
                                } else if (AlaLiveBottomOperationView.this.aWa == 2) {
                                    AlaLiveBottomOperationView.this.goM.l(AlaLiveBottomOperationView.this.gpz, 11);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(imForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.aWa = 0;
                    }
                }
            }
        };
        this.aWZ = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kJ(boolean z) {
        if (this.goM != null && z) {
            this.goM.l(this.goP, 2);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.goP.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.gpf.setVisibility(z ? 0 : 8);
        this.gpe.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.goN = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.goO = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.goP = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.goQ = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.goQ.setDefaultResource(a.f.icon_quick_gift_def);
        this.goR = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.goS = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.goT = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.goW = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.goX = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.goY = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.goZ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.gpa = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.gpb = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.gpc = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.gpd = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.goU = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.goV = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.gpe = this.rootView.findViewById(a.g.divider);
        this.gpf = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.gpg = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.gph = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.gpi = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.gpo = (ViewGroup) this.rootView.findViewById(a.g.host_goods_layout_parent);
        this.gpo.setVisibility(8);
        this.gpj = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.gpk = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.gpl = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.gpm = (FrameLayout) this.rootView.findViewById(a.g.superCustomer_layout);
        this.gpn = (TbImageView) this.rootView.findViewById(a.g.superCustomer_imageView);
        this.gpn.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.gpp = this.rootView.findViewById(a.g.turntable);
        this.gpq = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.gpr = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.gps = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.gpt = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        yt();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.gpw != i) {
            this.gpw = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.goN.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.goN.setLayoutParams(layoutParams);
        }
    }

    private void yt() {
        this.goP.setOnClickListener(this.aXG);
        this.goR.setOnClickListener(this.aXG);
        this.goT.setOnClickListener(this.aXG);
        this.gph.setOnClickListener(this.aXG);
        this.goX.setOnClickListener(this.aXG);
        this.goZ.setOnClickListener(this.aXG);
        this.goN.setOnClickListener(this.aXG);
        this.goV.setOnClickListener(this.aXG);
        this.gpf.setOnClickListener(this.aXG);
        this.gpi.setOnClickListener(this.aXG);
        this.gpj.setOnClickListener(this.aXG);
        this.gpm.setOnClickListener(this.aXG);
        this.gpp.setOnClickListener(this.aXG);
        this.gps.setOnClickListener(this.aXG);
        this.gpt.setOnClickListener(this.aXG);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void bG(View view) {
        if (this.gpo != null) {
            this.gpo.setVisibility(0);
            this.gpo.addView(view);
        }
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.goM = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.goM.l(view, 1);
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.gps;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.aWc);
        MessageManager.getInstance().unRegisterListener(this.aPg);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        boolean z2 = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isEntrySuperCustomerUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.Hm().Hp()) {
                z = false;
            }
            y yVar = com.baidu.tieba.ala.liveroom.u.a.bJu().aZA;
            if (yVar == null) {
                z2 = false;
            } else if (yVar.ayi == 1 || TextUtils.isEmpty(yVar.iconUrl)) {
                z2 = false;
            }
            if (z2) {
                this.goR.setAlpha(0.0f);
                this.gpj.setVisibility(8);
                this.gpm.setVisibility(0);
                if (yVar != null && !TextUtils.isEmpty(yVar.iconUrl)) {
                    BdLog.d("iconUrl:" + yVar.iconUrl);
                    this.gpn.startLoad(yVar.iconUrl, 10, false);
                }
            } else if (z) {
                this.goR.setAlpha(0.0f);
                this.gpm.setVisibility(8);
                this.gpj.setVisibility(0);
                bIQ();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.gpx.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.gpx.add(Long.valueOf(j));
                    }
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.goR.setAlpha(1.0f);
                this.gpj.setVisibility(8);
                this.gpm.setVisibility(8);
            }
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aVY = z;
        this.aVZ = i;
        this.aMv = i2;
        this.mUserName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aWm == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aWn);
            }
            this.mDialog = new BdAlertDialog(this.aWZ.getPageActivity());
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
            this.mDialog.create(this.aWZ);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.aPg.setTag(this.aWZ.getUniqueId());
        MessageManager.getInstance().registerListener(this.aPg);
        this.aWc.setTag(this.aWZ.getUniqueId());
        MessageManager.getInstance().registerListener(this.aWc);
    }

    private void bIQ() {
        if (this.gpv == null) {
            this.gpv = new a();
        }
        this.handler.postDelayed(this.gpv, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.gpk.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.gpk.setVisibility(8);
                AlaLiveBottomOperationView.this.gpl.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.gpk.setVisibility(0);
                AlaLiveBottomOperationView.this.gpl.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.gpv, 1000L);
        }
    }
}
