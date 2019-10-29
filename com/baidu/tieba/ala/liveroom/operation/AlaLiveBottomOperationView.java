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
    private View.OnClickListener aju;
    public View ejJ;
    public ImageView ejK;
    public TextView ejL;
    private b emC;
    public LinearLayout emD;
    public ImageView emE;
    public FrameLayout emF;
    public TbImageView emG;
    public FrameLayout emH;
    public ImageView emI;
    public FrameLayout emJ;
    public ImageView emK;
    public FrameLayout emL;
    public ImageView emM;
    public FrameLayout emN;
    public TextView emO;
    public FrameLayout emP;
    public LinearLayout emQ;
    public TextView emR;
    public View emS;
    public TextView emT;
    public ImageView emU;
    public ImageView emV;
    public FrameLayout emW;
    public FrameLayout emX;
    public FrameLayout emY;
    public ImageView emZ;
    public ImageView ena;
    public View enb;
    public ImageView enc;
    public TurnTableLuckyCountDownView ene;
    public ImageView enf;
    public ImageView eng;
    private boolean enh;
    private a eni;
    private int enj;
    private Set<Long> enk;
    private Handler handler;
    private Context mContext;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(Context context) {
        super(context);
        this.enh = false;
        this.handler = new Handler();
        this.enj = -1;
        this.enk = new HashSet();
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.emC != null) {
                    if (view == AlaLiveBottomOperationView.this.emJ) {
                        AlaLiveBottomOperationView.this.emC.n(view, 3);
                    } else if (view == AlaLiveBottomOperationView.this.emD) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHATINPUT);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        AlaLiveBottomOperationView.this.emC.n(view, 1);
                    } else if (view == AlaLiveBottomOperationView.this.emF) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.mContext);
                            return;
                        }
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
                        alaStaticItem2.addParams("feed_id", HKStaticManager.FEED_ID);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        AlaLiveBottomOperationView.this.emC.n(view, 2);
                    } else if (view == AlaLiveBottomOperationView.this.emH) {
                        AlaLiveBottomOperationView.this.emC.n(view, 13);
                    } else if (view == AlaLiveBottomOperationView.this.emN) {
                        AlaLiveBottomOperationView.this.enh = AlaLiveBottomOperationView.this.enh ? false : true;
                        if (AlaLiveBottomOperationView.this.enh) {
                            AlaLiveBottomOperationView.this.emM.setImageResource(a.f.ala_live_room_clear_off_btn);
                            AlaLiveBottomOperationView.this.emC.n(view, 5);
                            return;
                        }
                        AlaLiveBottomOperationView.this.emM.setImageResource(a.f.ala_live_room_clear_on_btn);
                        AlaLiveBottomOperationView.this.emC.n(view, 6);
                    } else if (view == AlaLiveBottomOperationView.this.emP) {
                        AlaLiveBottomOperationView.this.emC.n(view, 7);
                    } else if (view == AlaLiveBottomOperationView.this.emL) {
                        AlaLiveBottomOperationView.this.emC.n(view, 4);
                    } else if (view == AlaLiveBottomOperationView.this.emU) {
                        AlaLiveBottomOperationView.this.emC.n(view, 11);
                    } else if (view == AlaLiveBottomOperationView.this.emW) {
                        AlaLiveBottomOperationView.this.emC.n(view, 12);
                    } else if (view == AlaLiveBottomOperationView.this.emX) {
                        AlaLiveBottomOperationView.this.emC.n(view, 8);
                    } else if (view == AlaLiveBottomOperationView.this.ejK) {
                        AlaLiveBottomOperationView.this.emC.n(view, 15);
                    } else if (view == AlaLiveBottomOperationView.this.emY) {
                        AlaLiveBottomOperationView.this.emC.n(view, 16);
                    } else if (view == AlaLiveBottomOperationView.this.enb) {
                        AlaLiveBottomOperationView.this.emC.n(view, 17);
                    } else if (view == AlaLiveBottomOperationView.this.enf) {
                        AlaLiveBottomOperationView.this.emC.n(view, 18);
                    } else if (view == AlaLiveBottomOperationView.this.eng) {
                        AlaLiveBottomOperationView.this.emC.n(view, 19);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hz(boolean z) {
        if (this.emC != null && z) {
            this.emC.n(this.emF, 2);
        }
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.ala_liveroom_vertical_bottom_operation, this);
        this.emD = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.emE = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.emF = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.emG = (TbImageView) this.rootView.findViewById(a.g.ala_live_room_quick_gift_btn);
        this.emH = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_quick_gift_layout);
        this.emI = (ImageView) this.rootView.findViewById(a.g.ala_live_room_share_btn);
        this.emJ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_share_btn_layout);
        this.emM = (ImageView) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn);
        this.emN = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_clear_screen_btn_layout);
        this.emO = (TextView) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn);
        this.emP = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_level_switch_btn_layout);
        this.emQ = (LinearLayout) this.rootView.findViewById(a.g.ala_live_room_host_detail_layout);
        this.emR = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_id_tv);
        this.emS = this.rootView.findViewById(a.g.ala_live_room_host_info_divider);
        this.emT = (TextView) this.rootView.findViewById(a.g.ala_live_room_host_audience_count_tv);
        this.emK = (ImageView) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn);
        this.emL = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_full_screen_btn_layout);
        this.emU = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.emV = (ImageView) this.rootView.findViewById(a.g.ala_live_room_zan_btn);
        this.emW = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_zan_layout);
        this.emX = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        this.ejJ = this.rootView.findViewById(a.g.host_goods_layout);
        this.ejK = (ImageView) this.rootView.findViewById(a.g.host_goods_imageView);
        this.ejL = (TextView) this.rootView.findViewById(a.g.host_goods_num_textView);
        this.emY = (FrameLayout) this.rootView.findViewById(a.g.firstRecharge_layout);
        this.emZ = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp1);
        this.ena = (ImageView) this.rootView.findViewById(a.g.firstRecharge_lamp2);
        this.enb = this.rootView.findViewById(a.g.turntable);
        this.enc = (ImageView) this.rootView.findViewById(a.g.turntable_icon);
        this.ene = (TurnTableLuckyCountDownView) this.rootView.findViewById(a.g.turntable_countdown);
        this.enf = (ImageView) this.rootView.findViewById(a.g.landscape_barrage_imageView);
        this.eng = (ImageView) this.rootView.findViewById(a.g.landscape_minimize_imageView);
        pv();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.enj != i) {
            this.enj = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.emD.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.emD.setLayoutParams(layoutParams);
        }
    }

    private void pv() {
        this.emF.setOnClickListener(this.aju);
        this.emH.setOnClickListener(this.aju);
        this.emJ.setOnClickListener(this.aju);
        this.emW.setOnClickListener(this.aju);
        this.emN.setOnClickListener(this.aju);
        this.emP.setOnClickListener(this.aju);
        this.emD.setOnClickListener(this.aju);
        this.emL.setOnClickListener(this.aju);
        this.emU.setOnClickListener(this.aju);
        this.emX.setOnClickListener(this.aju);
        this.ejK.setOnClickListener(this.aju);
        this.emY.setOnClickListener(this.aju);
        this.enb.setOnClickListener(this.aju);
        this.enf.setOnClickListener(this.aju);
        this.eng.setOnClickListener(this.aju);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.emC = bVar;
    }

    public ImageView getLandscapeBarrageImageView() {
        return this.enf;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public void a(boolean z, AlaLiveInfoData alaLiveInfoData, String str) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled())) {
            if (!com.baidu.live.l.a.uA().uE()) {
                z = false;
            }
            if (z) {
                this.emH.setAlpha(0.0f);
                this.emY.setVisibility(0);
                aVv();
                if (alaLiveInfoData != null) {
                    long j = alaLiveInfoData.live_id;
                    if (!this.enk.contains(Long.valueOf(j))) {
                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargeQuickLog(j + "", alaLiveInfoData.room_id + "", alaLiveInfoData.feed_id, str);
                        this.enk.add(Long.valueOf(j));
                        return;
                    }
                    return;
                }
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            this.emH.setAlpha(1.0f);
            this.emY.setVisibility(8);
        }
    }

    private void aVv() {
        if (this.eni == null) {
            this.eni = new a();
        }
        this.handler.postDelayed(this.eni, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaLiveBottomOperationView.this.emZ.getVisibility() == 0) {
                AlaLiveBottomOperationView.this.emZ.setVisibility(8);
                AlaLiveBottomOperationView.this.ena.setVisibility(0);
            } else {
                AlaLiveBottomOperationView.this.emZ.setVisibility(0);
                AlaLiveBottomOperationView.this.ena.setVisibility(8);
            }
            AlaLiveBottomOperationView.this.handler.postDelayed(AlaLiveBottomOperationView.this.eni, 1000L);
        }
    }
}
