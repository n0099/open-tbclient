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
    private View.OnClickListener auX;
    public View feT;
    public ImageView feU;
    public TextView feV;
    public RelativeLayout fiA;
    public ImageView fiB;
    public FrameLayout fiC;
    public TbImageView fiD;
    public FrameLayout fiE;
    public ImageView fiF;
    public FrameLayout fiG;
    public ImageView fiH;
    public FrameLayout fiI;
    public ImageView fiJ;
    public FrameLayout fiK;
    public TextView fiL;
    public FrameLayout fiM;
    public LinearLayout fiN;
    public TextView fiO;
    public View fiP;
    public TextView fiQ;
    public ImageView fiR;
    public ImageView fiS;
    public FrameLayout fiT;
    public FrameLayout fiU;
    public FrameLayout fiV;
    public ImageView fiW;
    public ImageView fiX;
    public View fiY;
    public ImageView fiZ;
    private b fiz;
    public TurnTableLuckyCountDownView fja;
    public ImageView fjb;
    public ImageView fjc;
    private boolean fjd;
    private a fje;
    private int fjf;
    private Set<Long> fjg;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.fjd = false;
        this.handler = new Handler();
        this.fjf = -1;
        this.fjg = new HashSet();
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.fiz != null) {
                    if (view == AlaLiveBottomOperationView.this.fiG) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.fiA) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.fiz.m(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.fiC) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                        AlaLiveBottomOperationView.this.fiz.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.fiE) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.fiK) {
                        AlaLiveBottomOperationView.this.fjd = AlaLiveBottomOperationView.this.fjd ? false : true;
                        if (AlaLiveBottomOperationView.this.fjd) {
                            AlaLiveBottomOperationView.this.fiJ.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.fiz.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fiJ.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.fiz.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.fiM) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.fiI) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.fiR) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.fiT) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.fiU) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.feU) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.fiV) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.fiY) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.fjb) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.fjc) {
                        AlaLiveBottomOperationView.this.fiz.m(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ja(boolean z) {
        if (this.fiz != null && z) {
            this.fiz.m(this.fiC, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.fiA = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.fiB = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.fiC = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.fiD = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.fiD.setDefaultResource(a.f.icon_quick_gift_def);
        this.fiE = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.fiF = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.fiG = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fiJ = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.fiK = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.fiL = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.fiM = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.fiN = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.fiO = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.fiP = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.fiQ = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.fiH = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.fiI = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.fiR = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.fiS = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.fiT = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.fiU = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.feT = this.rootView.findViewById(a.g.host_goods_layout);
        this.feU = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.feV = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.fiV = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.fiW = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.fiX = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.fiY = this.rootView.findViewById(a.g.turntable);
        this.fiZ = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.fja = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.fjb = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.fjc = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        sf();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.fjf != i) {
            this.fjf = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiA.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.fiA.setLayoutParams(layoutParams);
        }
    }

    private void sf() {
        this.fiC.setOnClickListener(this.auX);
        this.fiE.setOnClickListener(this.auX);
        this.fiG.setOnClickListener(this.auX);
        this.fiT.setOnClickListener(this.auX);
        this.fiK.setOnClickListener(this.auX);
        this.fiM.setOnClickListener(this.auX);
        this.fiA.setOnClickListener(this.auX);
        this.fiI.setOnClickListener(this.auX);
        this.fiR.setOnClickListener(this.auX);
        this.fiU.setOnClickListener(this.auX);
        this.feU.setOnClickListener(this.auX);
        this.fiV.setOnClickListener(this.auX);
        this.fiY.setOnClickListener(this.auX);
        this.fjb.setOnClickListener(this.auX);
        this.fjc.setOnClickListener(this.auX);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.fiz = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.fjb;
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
                this.fiE.setAlpha(0.0f);
                this.fiV.setVisibility(0);
                bqa();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.fjg.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.fjg.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.fiE.setAlpha(1.0f);
            this.fiV.setVisibility(8);
        }
    }

    private void bqa() {
        if (this.fje == null) {
            this.fje = new a();
        }
        this.handler.postDelayed(this.fje, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.fiW.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.fiW.setVisibility(8);
                AlaLiveBottomOperationView.this.fiX.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.fiW.setVisibility(0);
                AlaLiveBottomOperationView.this.fiX.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fje, 1000L);
        }
    }
}
