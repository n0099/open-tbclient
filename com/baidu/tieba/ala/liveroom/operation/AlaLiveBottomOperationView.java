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
import com.baidu.live.r.a;
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
    private View.OnClickListener arL;
    public View fbI;
    public ImageView fbJ;
    public TextView fbK;
    public TextView ffA;
    public ImageView ffB;
    public ImageView ffC;
    public FrameLayout ffD;
    public FrameLayout ffE;
    public FrameLayout ffF;
    public ImageView ffG;
    public ImageView ffH;
    public View ffI;
    public ImageView ffJ;
    public TurnTableLuckyCountDownView ffK;
    public ImageView ffL;
    public ImageView ffM;
    private boolean ffN;
    private a ffO;
    private int ffP;
    private Set<Long> ffQ;
    private b ffj;
    public RelativeLayout ffk;
    public ImageView ffl;
    public FrameLayout ffm;
    public TbImageView ffn;
    public FrameLayout ffo;
    public ImageView ffp;
    public FrameLayout ffq;
    public ImageView ffr;
    public FrameLayout ffs;
    public ImageView fft;
    public FrameLayout ffu;
    public TextView ffv;
    public FrameLayout ffw;
    public LinearLayout ffx;
    public TextView ffy;
    public View ffz;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.ffN = false;
        this.handler = new Handler();
        this.ffP = -1;
        this.ffQ = new HashSet();
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.ffj != null) {
                    if (view == AlaLiveBottomOperationView.this.ffq) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.ffk) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.ffj.m(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.ffm) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                        AlaLiveBottomOperationView.this.ffj.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.ffo) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.ffu) {
                        AlaLiveBottomOperationView.this.ffN = AlaLiveBottomOperationView.this.ffN ? false : true;
                        if (AlaLiveBottomOperationView.this.ffN) {
                            AlaLiveBottomOperationView.this.fft.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.ffj.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fft.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.ffj.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.ffw) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.ffs) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.ffB) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.ffD) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.ffE) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.fbJ) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.ffF) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.ffI) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.ffL) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.ffM) {
                        AlaLiveBottomOperationView.this.ffj.m(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iU(boolean z) {
        if (this.ffj != null && z) {
            this.ffj.m(this.ffm, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.ffk = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.ffl = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.ffm = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.ffn = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.ffo = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.ffp = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.ffq = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fft = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.ffu = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.ffv = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.ffw = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.ffx = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.ffy = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.ffz = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.ffA = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.ffr = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.ffs = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.ffB = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.ffC = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.ffD = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.ffE = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.fbI = this.rootView.findViewById(a.g.host_goods_layout);
        this.fbJ = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.fbK = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.ffF = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.ffG = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.ffH = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.ffI = this.rootView.findViewById(a.g.turntable);
        this.ffJ = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.ffK = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.ffL = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.ffM = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        re();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.ffP != i) {
            this.ffP = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffk.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.ffk.setLayoutParams(layoutParams);
        }
    }

    private void re() {
        this.ffm.setOnClickListener(this.arL);
        this.ffo.setOnClickListener(this.arL);
        this.ffq.setOnClickListener(this.arL);
        this.ffD.setOnClickListener(this.arL);
        this.ffu.setOnClickListener(this.arL);
        this.ffw.setOnClickListener(this.arL);
        this.ffk.setOnClickListener(this.arL);
        this.ffs.setOnClickListener(this.arL);
        this.ffB.setOnClickListener(this.arL);
        this.ffE.setOnClickListener(this.arL);
        this.fbJ.setOnClickListener(this.arL);
        this.ffF.setOnClickListener(this.arL);
        this.ffI.setOnClickListener(this.arL);
        this.ffL.setOnClickListener(this.arL);
        this.ffM.setOnClickListener(this.arL);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.ffj = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.ffL;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.s.a.wR().wU()) {
                z = false;
            }
            if (z) {
                this.ffo.setAlpha(0.0f);
                this.ffF.setVisibility(0);
                bol();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.ffQ.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.ffQ.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.ffo.setAlpha(1.0f);
            this.ffF.setVisibility(8);
        }
    }

    private void bol() {
        if (this.ffO == null) {
            this.ffO = new a();
        }
        this.handler.postDelayed(this.ffO, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.ffG.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.ffG.setVisibility(8);
                AlaLiveBottomOperationView.this.ffH.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.ffG.setVisibility(0);
                AlaLiveBottomOperationView.this.ffH.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.ffO, 1000L);
        }
    }
}
