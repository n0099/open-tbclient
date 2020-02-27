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
    private TbImageView eWq;
    private TextView eWr;
    private TbImageView eWs;
    private TextView eWt;
    private BubbleLayout eWu;
    private TextView eWv;
    private boolean eWw;
    private View.OnClickListener eWx;
    private View.OnClickListener eWy;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.eWw = false;
        this.eWx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eWw && j.this.eWu.getVisibility() == 0) {
                    j.this.eWu.setVisibility(8);
                    j.this.eWw = false;
                }
                if (j.this.eVu != null) {
                    j.this.eVu.qi();
                    j.this.eVu.bkM();
                }
            }
        };
        this.eWy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eVu != null) {
                    j.this.eVu.bkN();
                }
            }
        };
        this.eWq = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.eWr = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.eWq.setDefaultResource(a.f.icon_live_vs_enter);
        this.eWq.setDefaultBgResource(0);
        this.eWq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eWq.setOnClickListener(this.eWx);
        this.eWr.setOnClickListener(this.eWx);
        this.eWs = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.eWt = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.eWs.setDefaultResource(a.f.icon_live_pk_enter);
        this.eWs.setDefaultBgResource(0);
        this.eWs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eWs.setOnClickListener(this.eWy);
        this.eWt.setOnClickListener(this.eWy);
        if (!StringUtils.isNull(com.baidu.live.v.a.zj().awA.aag)) {
            this.eWs.startLoad(com.baidu.live.v.a.zj().awA.aag, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.zj().awA.aah)) {
            this.eWq.startLoad(com.baidu.live.v.a.zj().awA.aah, 10, false);
        }
        this.eWu = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.eWv = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.eWu.setVisibility(0);
            this.eWw = true;
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
    public int bkD() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bj(int i) {
        if (!this.eWw) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.eWu.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.eWu.L(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.eWu.setVisibility(0);
                this.eWv.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.eWu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
