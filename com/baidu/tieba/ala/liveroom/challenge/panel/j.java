package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class j extends e {
    private TbImageView eXc;
    private TextView eXd;
    private TbImageView eXe;
    private TextView eXf;
    private BubbleLayout eXg;
    private TextView eXh;
    private boolean eXi;
    private View.OnClickListener eXj;
    private View.OnClickListener eXk;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.eXi = false;
        this.eXj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eXi && j.this.eXg.getVisibility() == 0) {
                    j.this.eXg.setVisibility(8);
                    j.this.eXi = false;
                }
                if (j.this.eWg != null) {
                    j.this.eWg.qn();
                    j.this.eWg.bkU();
                }
            }
        };
        this.eXk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eWg != null) {
                    j.this.eWg.bkV();
                }
            }
        };
        this.eXc = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.eXd = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.eXc.setDefaultResource(a.f.icon_live_vs_enter);
        this.eXc.setDefaultBgResource(0);
        this.eXc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eXc.setOnClickListener(this.eXj);
        this.eXd.setOnClickListener(this.eXj);
        this.eXe = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.eXf = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.eXe.setDefaultResource(a.f.icon_live_pk_enter);
        this.eXe.setDefaultBgResource(0);
        this.eXe.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eXe.setOnClickListener(this.eXk);
        this.eXf.setOnClickListener(this.eXk);
        if (!StringUtils.isNull(com.baidu.live.v.a.zs().awM.aaq)) {
            this.eXe.startLoad(com.baidu.live.v.a.zs().awM.aaq, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.zs().awM.aar)) {
            this.eXc.startLoad(com.baidu.live.v.a.zs().awM.aar, 10, false);
        }
        this.eXg = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.eXh = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.eXg.setVisibility(0);
            this.eXi = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void xr() {
        super.xr();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkL() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bj(int i) {
        if (!this.eXi) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.eXg.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.eXg.L(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.eXg.setVisibility(0);
                this.eXh.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.eXg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
