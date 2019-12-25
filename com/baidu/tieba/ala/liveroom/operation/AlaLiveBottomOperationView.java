package com.baidu.tieba.ala.liveroom.operation;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes2.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aqZ;
    public View eZd;
    public ImageView eZe;
    public TextView eZf;
    public ImageView fcA;
    public ImageView fcB;
    public View fcC;
    public ImageView fcD;
    public TurnTableLuckyCountDownView fcE;
    public ImageView fcF;
    public ImageView fcG;
    private boolean fcH;
    private a fcI;
    private int fcJ;
    private Set<Long> fcK;
    private b fcd;
    public RelativeLayout fce;
    public ImageView fcf;
    public FrameLayout fcg;
    public TbImageView fch;
    public FrameLayout fci;
    public ImageView fcj;
    public FrameLayout fck;
    public ImageView fcl;
    public FrameLayout fcm;
    public ImageView fcn;
    public FrameLayout fco;
    public TextView fcp;
    public FrameLayout fcq;
    public LinearLayout fcr;
    public TextView fcs;
    public View fct;
    public TextView fcu;
    public ImageView fcv;
    public ImageView fcw;
    public FrameLayout fcx;
    public FrameLayout fcy;
    public FrameLayout fcz;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.fcH = false;
        this.handler = new Handler();
        this.fcJ = -1;
        this.fcK = new HashSet();
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.fcd != null) {
                    if (view == AlaLiveBottomOperationView.this.fck) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.fce) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        AlaLiveBottomOperationView.this.fcd.m(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.fcg) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                        alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        AlaLiveBottomOperationView.this.fcd.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.fci) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.fco) {
                        AlaLiveBottomOperationView.this.fcH = AlaLiveBottomOperationView.this.fcH ? false : true;
                        if (AlaLiveBottomOperationView.this.fcH) {
                            AlaLiveBottomOperationView.this.fcn.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.fcd.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fcn.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.fcd.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.fcq) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.fcm) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.fcv) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.fcx) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.fcy) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.eZe) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.fcz) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.fcC) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.fcF) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.fcG) {
                        AlaLiveBottomOperationView.this.fcd.m(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iN(boolean z) {
        if (this.fcd != null && z) {
            this.fcd.m(this.fcg, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.fce = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.fcf = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.fcg = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.fch = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.fci = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.fcj = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.fck = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fcn = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.fco = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.fcp = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.fcq = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.fcr = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.fcs = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.fct = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.fcu = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.fcl = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.fcm = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.fcv = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.fcw = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.fcx = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.fcy = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.eZd = this.rootView.findViewById(a.g.host_goods_layout);
        this.eZe = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.eZf = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.fcz = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.fcA = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.fcB = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.fcC = this.rootView.findViewById(a.g.turntable);
        this.fcD = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.fcE = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.fcF = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.fcG = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        qS();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.fcJ != i) {
            this.fcJ = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fce.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.fce.setLayoutParams(layoutParams);
        }
    }

    private void qS() {
        this.fcg.setOnClickListener(this.aqZ);
        this.fci.setOnClickListener(this.aqZ);
        this.fck.setOnClickListener(this.aqZ);
        this.fcx.setOnClickListener(this.aqZ);
        this.fco.setOnClickListener(this.aqZ);
        this.fcq.setOnClickListener(this.aqZ);
        this.fce.setOnClickListener(this.aqZ);
        this.fcm.setOnClickListener(this.aqZ);
        this.fcv.setOnClickListener(this.aqZ);
        this.fcy.setOnClickListener(this.aqZ);
        this.eZe.setOnClickListener(this.aqZ);
        this.fcz.setOnClickListener(this.aqZ);
        this.fcC.setOnClickListener(this.aqZ);
        this.fcF.setOnClickListener(this.aqZ);
        this.fcG.setOnClickListener(this.aqZ);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.fcd = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.fcF;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.r.a.wA().wD()) {
                z = false;
            }
            if (z) {
                this.fci.setAlpha(0.0f);
                this.fcz.setVisibility(0);
                bnl();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.fcK.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.fcK.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.fci.setAlpha(1.0f);
            this.fcz.setVisibility(8);
        }
    }

    private void bnl() {
        if (this.fcI == null) {
            this.fcI = new a();
        }
        this.handler.postDelayed(this.fcI, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.fcA.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.fcA.setVisibility(8);
                AlaLiveBottomOperationView.this.fcB.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.fcA.setVisibility(0);
                AlaLiveBottomOperationView.this.fcB.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fcI, 1000L);
        }
    }
}
