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
    private TbImageView eWr;
    private TextView eWs;
    private TbImageView eWt;
    private TextView eWu;
    private BubbleLayout eWv;
    private TextView eWw;
    private boolean eWx;
    private View.OnClickListener eWy;
    private View.OnClickListener eWz;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.eWx = false;
        this.eWy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eWx && j.this.eWv.getVisibility() == 0) {
                    j.this.eWv.setVisibility(8);
                    j.this.eWx = false;
                }
                if (j.this.eVv != null) {
                    j.this.eVv.qi();
                    j.this.eVv.bkO();
                }
            }
        };
        this.eWz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eVv != null) {
                    j.this.eVv.bkP();
                }
            }
        };
        this.eWr = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.eWs = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.eWr.setDefaultResource(a.f.icon_live_vs_enter);
        this.eWr.setDefaultBgResource(0);
        this.eWr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eWr.setOnClickListener(this.eWy);
        this.eWs.setOnClickListener(this.eWy);
        this.eWt = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.eWu = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.eWt.setDefaultResource(a.f.icon_live_pk_enter);
        this.eWt.setDefaultBgResource(0);
        this.eWt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eWt.setOnClickListener(this.eWz);
        this.eWu.setOnClickListener(this.eWz);
        if (!StringUtils.isNull(com.baidu.live.v.a.zl().awB.aag)) {
            this.eWt.startLoad(com.baidu.live.v.a.zl().awB.aag, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.zl().awB.aah)) {
            this.eWr.startLoad(com.baidu.live.v.a.zl().awB.aah, 10, false);
        }
        this.eWv = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.eWw = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.eWv.setVisibility(0);
            this.eWx = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void xm() {
        super.xm();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkF() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bj(int i) {
        if (!this.eWx) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.eWv.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.eWv.L(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.eWv.setVisibility(0);
                this.eWw.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.eWv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
