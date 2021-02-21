package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
/* loaded from: classes11.dex */
public class l extends g {
    private TbImageView hxM;
    private TextView hxN;
    private TbImageView hxO;
    private TextView hxP;
    private BubbleLayout hxQ;
    private TextView hxR;
    private boolean hxS;
    private View.OnClickListener hxT;
    private View.OnClickListener hxU;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hxS = false;
        this.hxT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hxS && l.this.hxQ.getVisibility() == 0) {
                    l.this.hxQ.setVisibility(8);
                    l.this.hxS = false;
                }
                if (l.this.hwT != null) {
                    l.this.hwT.AP();
                    l.this.hwT.cdH();
                }
            }
        };
        this.hxU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hwT != null) {
                    l.this.hwT.cdI();
                }
            }
        };
        this.hxM = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hxN = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hxM.setDefaultResource(a.e.icon_live_vs_enter);
        this.hxM.setDefaultBgResource(0);
        this.hxM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hxM.setOnClickListener(this.hxT);
        this.hxN.setOnClickListener(this.hxT);
        this.hxO = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hxP = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hxO.setDefaultResource(a.e.icon_live_pk_enter);
        this.hxO.setDefaultBgResource(0);
        this.hxO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hxO.setOnClickListener(this.hxU);
        this.hxP.setOnClickListener(this.hxU);
        if (!StringUtils.isNull(com.baidu.live.ae.a.Qj().buX.aLZ)) {
            this.hxO.startLoad(com.baidu.live.ae.a.Qj().buX.aLZ, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.ae.a.Qj().buX.aMa)) {
            this.hxM.startLoad(com.baidu.live.ae.a.Qj().buX.aMa, 10, false);
        }
        this.hxQ = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hxR = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hxQ.setVisibility(0);
            this.hxS = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdt() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cy(int i) {
        if (!this.hxS) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hxQ.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hxQ.v(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hxQ.setVisibility(0);
                this.hxR.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hxQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
