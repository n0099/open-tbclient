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
    private TbImageView hco;
    private TextView hcp;
    private TbImageView hcq;
    private TextView hcr;
    private BubbleLayout hcs;
    private TextView hct;
    private boolean hcu;
    private View.OnClickListener hcv;
    private View.OnClickListener hcw;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hcu = false;
        this.hcv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hcu && l.this.hcs.getVisibility() == 0) {
                    l.this.hcs.setVisibility(8);
                    l.this.hcu = false;
                }
                if (l.this.hbv != null) {
                    l.this.hbv.Db();
                    l.this.hbv.bZK();
                }
            }
        };
        this.hcw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hbv != null) {
                    l.this.hbv.bZL();
                }
            }
        };
        this.hco = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hcp = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hco.setDefaultResource(a.e.icon_live_vs_enter);
        this.hco.setDefaultBgResource(0);
        this.hco.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hco.setOnClickListener(this.hcv);
        this.hcp.setOnClickListener(this.hcv);
        this.hcq = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hcr = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hcq.setDefaultResource(a.e.icon_live_pk_enter);
        this.hcq.setDefaultBgResource(0);
        this.hcq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hcq.setOnClickListener(this.hcw);
        this.hcr.setOnClickListener(this.hcw);
        if (!StringUtils.isNull(com.baidu.live.aa.a.Ph().bms.aKD)) {
            this.hcq.startLoad(com.baidu.live.aa.a.Ph().bms.aKD, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.aa.a.Ph().bms.aKE)) {
            this.hco.startLoad(com.baidu.live.aa.a.Ph().bms.aKE, 10, false);
        }
        this.hcs = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hct = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hcs.setVisibility(0);
            this.hcu = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Ot() {
        super.Ot();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bZw() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dL(int i) {
        if (!this.hcu) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hcs.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hcs.A(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hcs.setVisibility(0);
                this.hct.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hcs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
