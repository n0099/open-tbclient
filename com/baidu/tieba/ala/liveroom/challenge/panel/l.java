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
    private TbImageView hlX;
    private TextView hlY;
    private TbImageView hlZ;
    private TextView hma;
    private BubbleLayout hmb;
    private TextView hmc;
    private boolean hmd;
    private View.OnClickListener hme;
    private View.OnClickListener hmf;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hmd = false;
        this.hme = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hmd && l.this.hmb.getVisibility() == 0) {
                    l.this.hmb.setVisibility(8);
                    l.this.hmd = false;
                }
                if (l.this.hle != null) {
                    l.this.hle.EL();
                    l.this.hle.cdF();
                }
            }
        };
        this.hmf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hle != null) {
                    l.this.hle.cdG();
                }
            }
        };
        this.hlX = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hlY = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hlX.setDefaultResource(a.e.icon_live_vs_enter);
        this.hlX.setDefaultBgResource(0);
        this.hlX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hlX.setOnClickListener(this.hme);
        this.hlY.setOnClickListener(this.hme);
        this.hlZ = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hma = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hlZ.setDefaultResource(a.e.icon_live_pk_enter);
        this.hlZ.setDefaultBgResource(0);
        this.hlZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hlZ.setOnClickListener(this.hmf);
        this.hma.setOnClickListener(this.hmf);
        if (!StringUtils.isNull(com.baidu.live.ae.a.RB().brA.aNy)) {
            this.hlZ.startLoad(com.baidu.live.ae.a.RB().brA.aNy, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.ae.a.RB().brA.aNz)) {
            this.hlX.startLoad(com.baidu.live.ae.a.RB().brA.aNz, 10, false);
        }
        this.hmb = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hmc = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hmb.setVisibility(0);
            this.hmd = true;
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
    public int cdr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ee(int i) {
        if (!this.hmd) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hmb.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hmb.v(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hmb.setVisibility(0);
                this.hmc.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hmb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
