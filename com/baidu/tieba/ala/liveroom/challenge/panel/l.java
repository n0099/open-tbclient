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
/* loaded from: classes7.dex */
public class l extends g {
    private TbImageView gsZ;
    private TextView gta;
    private TbImageView gtb;
    private TextView gtc;
    private BubbleLayout gtd;
    private TextView gte;
    private boolean gtf;
    private View.OnClickListener gtg;
    private View.OnClickListener gth;

    public l(Context context, m mVar) {
        super(context, mVar);
        this.gtf = false;
        this.gtg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gtf && l.this.gtd.getVisibility() == 0) {
                    l.this.gtd.setVisibility(8);
                    l.this.gtf = false;
                }
                if (l.this.gse != null) {
                    l.this.gse.BY();
                    l.this.gse.bQe();
                }
            }
        };
        this.gth = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gse != null) {
                    l.this.gse.bQf();
                }
            }
        };
        this.gsZ = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.gta = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.gsZ.setDefaultResource(a.f.icon_live_vs_enter);
        this.gsZ.setDefaultBgResource(0);
        this.gsZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gsZ.setOnClickListener(this.gtg);
        this.gta.setOnClickListener(this.gtg);
        this.gtb = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.gtc = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.gtb.setDefaultResource(a.f.icon_live_pk_enter);
        this.gtb.setDefaultBgResource(0);
        this.gtb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gtb.setOnClickListener(this.gth);
        this.gtc.setOnClickListener(this.gth);
        if (!StringUtils.isNull(com.baidu.live.w.a.Nk().beJ.aGt)) {
            this.gtb.startLoad(com.baidu.live.w.a.Nk().beJ.aGt, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.w.a.Nk().beJ.aGu)) {
            this.gsZ.startLoad(com.baidu.live.w.a.Nk().beJ.aGu, 10, false);
        }
        this.gtd = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.gte = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.gtd.setVisibility(0);
            this.gtf = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Mr() {
        super.Mr();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bPQ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dG(int i) {
        if (!this.gtf) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.gtd.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.gtd.u(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.gtd.setVisibility(0);
                this.gte.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.gtd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
