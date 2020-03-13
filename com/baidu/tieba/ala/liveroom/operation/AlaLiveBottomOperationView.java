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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyCountDownView;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener auY;
    public View ffg;
    public ImageView ffh;
    public TextView ffi;
    private b fiM;
    public RelativeLayout fiN;
    public ImageView fiO;
    public FrameLayout fiP;
    public TbImageView fiQ;
    public FrameLayout fiR;
    public ImageView fiS;
    public FrameLayout fiT;
    public ImageView fiU;
    public FrameLayout fiV;
    public ImageView fiW;
    public FrameLayout fiX;
    public TextView fiY;
    public FrameLayout fiZ;
    public LinearLayout fja;
    public TextView fjb;
    public View fjc;
    public TextView fjd;
    public ImageView fje;
    public ImageView fjf;
    public FrameLayout fjg;
    public FrameLayout fjh;
    public FrameLayout fji;
    public ImageView fjj;
    public ImageView fjk;
    public View fjl;
    public ImageView fjm;
    public TurnTableLuckyCountDownView fjn;
    public ImageView fjo;
    public ImageView fjp;
    private boolean fjq;
    private a fjr;
    private int fjs;
    private Set<Long> fjt;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.fjq = false;
        this.handler = new Handler();
        this.fjs = -1;
        this.fjt = new HashSet();
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.fiM != null) {
                    if (view == AlaLiveBottomOperationView.this.fiT) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.fiN) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.fiM.m(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.fiP) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                        AlaLiveBottomOperationView.this.fiM.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.fiR) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.fiX) {
                        AlaLiveBottomOperationView.this.fjq = AlaLiveBottomOperationView.this.fjq ? false : true;
                        if (AlaLiveBottomOperationView.this.fjq) {
                            AlaLiveBottomOperationView.this.fiW.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.fiM.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fiW.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.fiM.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.fiZ) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.fiV) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.fje) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.fjg) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.fjh) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.ffh) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.fji) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.fjl) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.fjo) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.fjp) {
                        AlaLiveBottomOperationView.this.fiM.m(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ja(boolean z) {
        if (this.fiM != null && z) {
            this.fiM.m(this.fiP, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.fiN = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.fiO = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.fiP = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.fiQ = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.fiQ.setDefaultResource(a.f.icon_quick_gift_def);
        this.fiR = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.fiS = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.fiT = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fiW = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.fiX = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.fiY = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.fiZ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.fja = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.fjb = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.fjc = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.fjd = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.fiU = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.fiV = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.fje = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.fjf = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.fjg = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.fjh = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.ffg = this.rootView.findViewById(a.g.host_goods_layout);
        this.ffh = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.ffi = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.fji = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.fjj = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.fjk = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.fjl = this.rootView.findViewById(a.g.turntable);
        this.fjm = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.fjn = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.fjo = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.fjp = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        sf();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.fjs != i) {
            this.fjs = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiN.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.fiN.setLayoutParams(layoutParams);
        }
    }

    private void sf() {
        this.fiP.setOnClickListener(this.auY);
        this.fiR.setOnClickListener(this.auY);
        this.fiT.setOnClickListener(this.auY);
        this.fjg.setOnClickListener(this.auY);
        this.fiX.setOnClickListener(this.auY);
        this.fiZ.setOnClickListener(this.auY);
        this.fiN.setOnClickListener(this.auY);
        this.fiV.setOnClickListener(this.auY);
        this.fje.setOnClickListener(this.auY);
        this.fjh.setOnClickListener(this.auY);
        this.ffh.setOnClickListener(this.auY);
        this.fji.setOnClickListener(this.auY);
        this.fjl.setOnClickListener(this.auY);
        this.fjo.setOnClickListener(this.auY);
        this.fjp.setOnClickListener(this.auY);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.fiM = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.fjo;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.zl().zo()) {
                z = false;
            }
            if (z) {
                this.fiR.setAlpha(0.0f);
                this.fji.setVisibility(0);
                bqb();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.fjt.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.fjt.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.fiR.setAlpha(1.0f);
            this.fji.setVisibility(8);
        }
    }

    private void bqb() {
        if (this.fjr == null) {
            this.fjr = new a();
        }
        this.handler.postDelayed(this.fjr, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.fjj.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.fjj.setVisibility(8);
                AlaLiveBottomOperationView.this.fjk.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.fjj.setVisibility(0);
                AlaLiveBottomOperationView.this.fjk.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fjr, 1000L);
        }
    }
}
