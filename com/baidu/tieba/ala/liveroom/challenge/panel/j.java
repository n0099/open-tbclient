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
    private boolean fBA;
    private View.OnClickListener fBB;
    private View.OnClickListener fBC;
    private TbImageView fBu;
    private TextView fBv;
    private TbImageView fBw;
    private TextView fBx;
    private BubbleLayout fBy;
    private TextView fBz;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.fBA = false;
        this.fBB = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fBA && j.this.fBy.getVisibility() == 0) {
                    j.this.fBy.setVisibility(8);
                    j.this.fBA = false;
                }
                if (j.this.fAz != null) {
                    j.this.fAz.uD();
                    j.this.fAz.bul();
                }
            }
        };
        this.fBC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fAz != null) {
                    j.this.fAz.bum();
                }
            }
        };
        this.fBu = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.fBv = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.fBu.setDefaultResource(a.f.icon_live_vs_enter);
        this.fBu.setDefaultBgResource(0);
        this.fBu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fBu.setOnClickListener(this.fBB);
        this.fBv.setOnClickListener(this.fBB);
        this.fBw = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.fBx = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.fBw.setDefaultResource(a.f.icon_live_pk_enter);
        this.fBw.setDefaultBgResource(0);
        this.fBw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fBw.setOnClickListener(this.fBC);
        this.fBx.setOnClickListener(this.fBC);
        if (!StringUtils.isNull(com.baidu.live.v.a.En().aQu.asL)) {
            this.fBw.startLoad(com.baidu.live.v.a.En().aQu.asL, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.En().aQu.asM)) {
            this.fBu.startLoad(com.baidu.live.v.a.En().aQu.asM, 10, false);
        }
        this.fBy = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.fBz = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.fBy.setVisibility(0);
            this.fBA = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void Cc() {
        super.Cc();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int buc() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bw(int i) {
        if (!this.fBA) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.fBy.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.fBy.s(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.fBy.setVisibility(0);
                this.fBz.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.fBy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
