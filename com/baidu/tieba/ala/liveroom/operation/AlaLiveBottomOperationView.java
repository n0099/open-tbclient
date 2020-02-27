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
    public View feS;
    public ImageView feT;
    public TextView feU;
    public ImageView fiA;
    public FrameLayout fiB;
    public TbImageView fiC;
    public FrameLayout fiD;
    public ImageView fiE;
    public FrameLayout fiF;
    public ImageView fiG;
    public FrameLayout fiH;
    public ImageView fiI;
    public FrameLayout fiJ;
    public TextView fiK;
    public FrameLayout fiL;
    public LinearLayout fiM;
    public TextView fiN;
    public View fiO;
    public TextView fiP;
    public ImageView fiQ;
    public ImageView fiR;
    public FrameLayout fiS;
    public FrameLayout fiT;
    public FrameLayout fiU;
    public ImageView fiV;
    public ImageView fiW;
    public View fiX;
    public ImageView fiY;
    public TurnTableLuckyCountDownView fiZ;
    private b fiy;
    public RelativeLayout fiz;
    public ImageView fja;
    public ImageView fjb;
    private boolean fjc;
    private a fjd;
    private int fje;
    private Set<Long> fjf;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.fjc = false;
        this.handler = new Handler();
        this.fje = -1;
        this.fjf = new HashSet();
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.fiy != null) {
                    if (view == AlaLiveBottomOperationView.this.fiF) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.fiz) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        AlaLiveBottomOperationView.this.fiy.m(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.fiB) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                            alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                        AlaLiveBottomOperationView.this.fiy.m(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.fiD) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.fiJ) {
                        AlaLiveBottomOperationView.this.fjc = AlaLiveBottomOperationView.this.fjc ? false : true;
                        if (AlaLiveBottomOperationView.this.fjc) {
                            AlaLiveBottomOperationView.this.fiI.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.fiy.m(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.fiI.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.fiy.m(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.fiL) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.fiH) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.fiQ) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.fiS) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.fiT) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.feT) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.fiU) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.fiX) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.fja) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.fjb) {
                        AlaLiveBottomOperationView.this.fiy.m(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ja(boolean z) {
        if (this.fiy != null && z) {
            this.fiy.m(this.fiB, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.fiz = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.fiA = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.fiB = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.fiC = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.fiC.setDefaultResource(a.f.icon_quick_gift_def);
        this.fiD = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.fiE = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.fiF = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.fiI = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.fiJ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.fiK = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.fiL = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.fiM = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.fiN = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.fiO = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.fiP = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.fiG = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.fiH = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.fiQ = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.fiR = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.fiS = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.fiT = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.feS = this.rootView.findViewById(a.g.host_goods_layout);
        this.feT = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.feU = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.fiU = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.fiV = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.fiW = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.fiX = this.rootView.findViewById(a.g.turntable);
        this.fiY = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.fiZ = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.fja = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.fjb = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        sf();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.fje != i) {
            this.fje = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiz.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.fiz.setLayoutParams(layoutParams);
        }
    }

    private void sf() {
        this.fiB.setOnClickListener(this.auX);
        this.fiD.setOnClickListener(this.auX);
        this.fiF.setOnClickListener(this.auX);
        this.fiS.setOnClickListener(this.auX);
        this.fiJ.setOnClickListener(this.auX);
        this.fiL.setOnClickListener(this.auX);
        this.fiz.setOnClickListener(this.auX);
        this.fiH.setOnClickListener(this.auX);
        this.fiQ.setOnClickListener(this.auX);
        this.fiT.setOnClickListener(this.auX);
        this.feT.setOnClickListener(this.auX);
        this.fiU.setOnClickListener(this.auX);
        this.fiX.setOnClickListener(this.auX);
        this.fja.setOnClickListener(this.auX);
        this.fjb.setOnClickListener(this.auX);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.fiy = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.fja;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled())) && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (!com.baidu.live.v.a.zj().zm()) {
                z = false;
            }
            if (z) {
                this.fiD.setAlpha(0.0f);
                this.fiU.setVisibility(0);
                bpY();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.fjf.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.fjf.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.fiD.setAlpha(1.0f);
            this.fiU.setVisibility(8);
        }
    }

    private void bpY() {
        if (this.fjd == null) {
            this.fjd = new a();
        }
        this.handler.postDelayed(this.fjd, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.fiV.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.fiV.setVisibility(8);
                AlaLiveBottomOperationView.this.fiW.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.fiV.setVisibility(0);
                AlaLiveBottomOperationView.this.fiW.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.fjd, 1000L);
        }
    }
}
