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
    private TbImageView fBp;
    private TextView fBq;
    private TbImageView fBr;
    private TextView fBs;
    private BubbleLayout fBt;
    private TextView fBu;
    private boolean fBv;
    private View.OnClickListener fBw;
    private View.OnClickListener fBx;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.fBv = false;
        this.fBw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fBv && j.this.fBt.getVisibility() == 0) {
                    j.this.fBt.setVisibility(8);
                    j.this.fBv = false;
                }
                if (j.this.fAu != null) {
                    j.this.fAu.uE();
                    j.this.fAu.bun();
                }
            }
        };
        this.fBx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fAu != null) {
                    j.this.fAu.buo();
                }
            }
        };
        this.fBp = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.fBq = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.fBp.setDefaultResource(a.f.icon_live_vs_enter);
        this.fBp.setDefaultBgResource(0);
        this.fBp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fBp.setOnClickListener(this.fBw);
        this.fBq.setOnClickListener(this.fBw);
        this.fBr = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.fBs = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.fBr.setDefaultResource(a.f.icon_live_pk_enter);
        this.fBr.setDefaultBgResource(0);
        this.fBr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fBr.setOnClickListener(this.fBx);
        this.fBs.setOnClickListener(this.fBx);
        if (!StringUtils.isNull(com.baidu.live.v.a.Eo().aQp.asF)) {
            this.fBr.startLoad(com.baidu.live.v.a.Eo().aQp.asF, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.Eo().aQp.asG)) {
            this.fBp.startLoad(com.baidu.live.v.a.Eo().aQp.asG, 10, false);
        }
        this.fBt = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.fBu = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.fBt.setVisibility(0);
            this.fBv = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void Cd() {
        super.Cd();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bue() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bw(int i) {
        if (!this.fBv) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.fBt.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.fBt.s(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.fBt.setVisibility(0);
                this.fBu.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.fBt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
