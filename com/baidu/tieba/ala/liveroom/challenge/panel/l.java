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
/* loaded from: classes4.dex */
public class l extends g {
    private TbImageView hlZ;
    private TextView hma;
    private TbImageView hmb;
    private TextView hmc;
    private BubbleLayout hmd;
    private TextView hme;
    private boolean hmf;
    private View.OnClickListener hmg;
    private View.OnClickListener hmh;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hmf = false;
        this.hmg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hmf && l.this.hmd.getVisibility() == 0) {
                    l.this.hmd.setVisibility(8);
                    l.this.hmf = false;
                }
                if (l.this.hlg != null) {
                    l.this.hlg.EL();
                    l.this.hlg.cdG();
                }
            }
        };
        this.hmh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hlg != null) {
                    l.this.hlg.cdH();
                }
            }
        };
        this.hlZ = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hma = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hlZ.setDefaultResource(a.e.icon_live_vs_enter);
        this.hlZ.setDefaultBgResource(0);
        this.hlZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hlZ.setOnClickListener(this.hmg);
        this.hma.setOnClickListener(this.hmg);
        this.hmb = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hmc = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hmb.setDefaultResource(a.e.icon_live_pk_enter);
        this.hmb.setDefaultBgResource(0);
        this.hmb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hmb.setOnClickListener(this.hmh);
        this.hmc.setOnClickListener(this.hmh);
        if (!StringUtils.isNull(com.baidu.live.ae.a.RB().brA.aNy)) {
            this.hmb.startLoad(com.baidu.live.ae.a.RB().brA.aNy, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.ae.a.RB().brA.aNz)) {
            this.hlZ.startLoad(com.baidu.live.ae.a.RB().brA.aNz, 10, false);
        }
        this.hmd = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hme = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hmd.setVisibility(0);
            this.hmf = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void QM() {
        super.QM();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cds() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ee(int i) {
        if (!this.hmf) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hmd.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hmd.v(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hmd.setVisibility(0);
                this.hme.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hmd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
