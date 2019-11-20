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
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener ajc;
    public View eiS;
    public ImageView eiT;
    public TextView eiU;
    private b elL;
    public LinearLayout elM;
    public ImageView elN;
    public FrameLayout elO;
    public TbImageView elP;
    public FrameLayout elQ;
    public ImageView elR;
    public FrameLayout elS;
    public ImageView elT;
    public FrameLayout elU;
    public ImageView elV;
    public FrameLayout elW;
    public TextView elX;
    public FrameLayout elY;
    public LinearLayout elZ;
    public TextView ema;
    public View emb;
    public TextView emc;
    public ImageView emd;
    public ImageView eme;
    public FrameLayout emf;
    public FrameLayout emg;
    public FrameLayout emh;
    public ImageView emi;
    public ImageView emj;
    public View emk;
    public ImageView eml;
    public TurnTableLuckyCountDownView emm;
    public ImageView emn;
    public ImageView emo;
    private boolean emp;
    private a emq;
    private int emr;
    private Set<Long> ems;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.emp = false;
        this.handler = new Handler();
        this.emr = -1;
        this.ems = new HashSet();
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.elL != null) {
                    if (view == AlaLiveBottomOperationView.this.elS) {
                        AlaLiveBottomOperationView.this.elL.n(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.elM) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        AlaLiveBottomOperationView.this.elL.n(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.elO) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                        alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        AlaLiveBottomOperationView.this.elL.n(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.elQ) {
                        AlaLiveBottomOperationView.this.elL.n(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.elW) {
                        AlaLiveBottomOperationView.this.emp = AlaLiveBottomOperationView.this.emp ? false : true;
                        if (AlaLiveBottomOperationView.this.emp) {
                            AlaLiveBottomOperationView.this.elV.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.elL.n(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.elV.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.elL.n(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.elY) {
                        AlaLiveBottomOperationView.this.elL.n(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.elU) {
                        AlaLiveBottomOperationView.this.elL.n(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.emd) {
                        AlaLiveBottomOperationView.this.elL.n(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.emf) {
                        AlaLiveBottomOperationView.this.elL.n(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.emg) {
                        AlaLiveBottomOperationView.this.elL.n(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.eiT) {
                        AlaLiveBottomOperationView.this.elL.n(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.emh) {
                        AlaLiveBottomOperationView.this.elL.n(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.emk) {
                        AlaLiveBottomOperationView.this.elL.n(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.emn) {
                        AlaLiveBottomOperationView.this.elL.n(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.emo) {
                        AlaLiveBottomOperationView.this.elL.n(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hz(boolean z) {
        if (this.elL != null && z) {
            this.elL.n(this.elO, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.elM = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.elN = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.elO = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.elP = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.elQ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.elR = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.elS = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.elV = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.elW = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.elX = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.elY = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.elZ = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.ema = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.emb = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.emc = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.elT = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.elU = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.emd = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.eme = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.emf = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.emg = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.eiS = this.rootView.findViewById(a.g.host_goods_layout);
        this.eiT = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.eiU = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.emh = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.emi = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.emj = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.emk = this.rootView.findViewById(a.g.turntable);
        this.eml = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.emm = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.emn = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.emo = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        pv();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.emr != i) {
            this.emr = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.elM.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.elM.setLayoutParams(layoutParams);
        }
    }

    private void pv() {
        this.elO.setOnClickListener(this.ajc);
        this.elQ.setOnClickListener(this.ajc);
        this.elS.setOnClickListener(this.ajc);
        this.emf.setOnClickListener(this.ajc);
        this.elW.setOnClickListener(this.ajc);
        this.elY.setOnClickListener(this.ajc);
        this.elM.setOnClickListener(this.ajc);
        this.elU.setOnClickListener(this.ajc);
        this.emd.setOnClickListener(this.ajc);
        this.emg.setOnClickListener(this.ajc);
        this.eiT.setOnClickListener(this.ajc);
        this.emh.setOnClickListener(this.ajc);
        this.emk.setOnClickListener(this.ajc);
        this.emn.setOnClickListener(this.ajc);
        this.emo.setOnClickListener(this.ajc);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.elL = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.emn;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled())) {
            if (!com.baidu.live.l.a.uB().uF()) {
                z = false;
            }
            if (z) {
                this.elQ.setAlpha(0.0f);
                this.emh.setVisibility(0);
                aVt();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.ems.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.ems.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.elQ.setAlpha(1.0f);
            this.emh.setVisibility(8);
        }
    }

    private void aVt() {
        if (this.emq == null) {
            this.emq = new a();
        }
        this.handler.postDelayed(this.emq, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.emi.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.emi.setVisibility(8);
                AlaLiveBottomOperationView.this.emj.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.emi.setVisibility(0);
                AlaLiveBottomOperationView.this.emj.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.emq, 1000L);
        }
    }
}
