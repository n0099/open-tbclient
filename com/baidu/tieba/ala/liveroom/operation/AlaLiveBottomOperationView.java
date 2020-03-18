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
    private View.OnClickListener avi;
    public View ffF;
    public ImageView ffG;
    public TextView ffH;
    public TextView fjA;
    public View fjB;
    public TextView fjC;
    public ImageView fjD;
    public ImageView fjE;
    public FrameLayout fjF;
    public FrameLayout fjG;
    public FrameLayout fjH;
    public ImageView fjI;
    public ImageView fjJ;
    public View fjK;
    public ImageView fjL;
    public TurnTableLuckyCountDownView fjM;
    public ImageView fjN;
    public ImageView fjO;
    private boolean fjP;
    private a fjQ;
    private int fjR;
    private Set<Long> fjS;
    private b fjl;
    public RelativeLayout fjm;
    public ImageView fjn;
    public FrameLayout fjo;
    public TbImageView fjp;
    public FrameLayout fjq;
    public ImageView fjr;
    public FrameLayout fjs;
    public ImageView fjt;
    public FrameLayout fju;
    public ImageView fjv;
    public FrameLayout fjw;
    public TextView fjx;
    public FrameLayout fjy;
    public LinearLayout fjz;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.fjP = false;
        this.handler = new Handler();
        this.fjR = -1;
        this.fjS = new HashSet();
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.fjl != null) {
                    if (view == AlaLiveBottomOperationView.this.fjs) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.fjm) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.fjl.m(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.fjo) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                        AlaLiveBottomOperationView.this.fjl.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.fjq) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.fjw) {
                        AlaLiveBottomOperationView.this.fjP = AlaLiveBottomOperationView.this.fjP ? false : true;
                        if (AlaLiveBottomOperationView.this.fjP) {
                            AlaLiveBottomOperationView.this.fjv.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.fjl.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fjv.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.fjl.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.fjy) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.fju) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.fjD) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.fjF) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.fjG) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.ffG) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.fjH) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.fjK) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.fjN) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.fjO) {
                        AlaLiveBottomOperationView.this.fjl.m(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jc(boolean z) {
        if (this.fjl != null && z) {
            this.fjl.m(this.fjo, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.fjm = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.fjn = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.fjo = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.fjp = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.fjp.setDefaultResource(a.f.icon_quick_gift_def);
        this.fjq = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.fjr = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.fjs = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fjv = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.fjw = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.fjx = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.fjy = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.fjz = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.fjA = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.fjB = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.fjC = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.fjt = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.fju = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.fjD = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.fjE = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.fjF = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.fjG = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.ffF = this.rootView.findViewById(a.g.host_goods_layout);
        this.ffG = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.ffH = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.fjH = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.fjI = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.fjJ = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.fjK = this.rootView.findViewById(a.g.turntable);
        this.fjL = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.fjM = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.fjN = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.fjO = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        sk();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.fjR != i) {
            this.fjR = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjm.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.fjm.setLayoutParams(layoutParams);
        }
    }

    private void sk() {
        this.fjo.setOnClickListener(this.avi);
        this.fjq.setOnClickListener(this.avi);
        this.fjs.setOnClickListener(this.avi);
        this.fjF.setOnClickListener(this.avi);
        this.fjw.setOnClickListener(this.avi);
        this.fjy.setOnClickListener(this.avi);
        this.fjm.setOnClickListener(this.avi);
        this.fju.setOnClickListener(this.avi);
        this.fjD.setOnClickListener(this.avi);
        this.fjG.setOnClickListener(this.avi);
        this.ffG.setOnClickListener(this.avi);
        this.fjH.setOnClickListener(this.avi);
        this.fjK.setOnClickListener(this.avi);
        this.fjN.setOnClickListener(this.avi);
        this.fjO.setOnClickListener(this.avi);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.fjl = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.fjN;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.zs().zv()) {
                z = false;
            }
            if (z) {
                this.fjq.setAlpha(0.0f);
                this.fjH.setVisibility(0);
                bqg();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.fjS.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.fjS.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.fjq.setAlpha(1.0f);
            this.fjH.setVisibility(8);
        }
    }

    private void bqg() {
        if (this.fjQ == null) {
            this.fjQ = new a();
        }
        this.handler.postDelayed(this.fjQ, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.fjI.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.fjI.setVisibility(8);
                AlaLiveBottomOperationView.this.fjJ.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.fjI.setVisibility(0);
                AlaLiveBottomOperationView.this.fjJ.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fjQ, 1000L);
        }
    }
}
