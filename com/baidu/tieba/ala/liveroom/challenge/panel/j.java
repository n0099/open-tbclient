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
    private TextView fPA;
    private BubbleLayout fPB;
    private TextView fPC;
    private boolean fPD;
    private View.OnClickListener fPE;
    private View.OnClickListener fPF;
    private TbImageView fPx;
    private TextView fPy;
    private TbImageView fPz;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.fPD = false;
        this.fPE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fPD && j.this.fPB.getVisibility() == 0) {
                    j.this.fPB.setVisibility(8);
                    j.this.fPD = false;
                }
                if (j.this.fOC != null) {
                    j.this.fOC.vK();
                    j.this.fOC.bAk();
                }
            }
        };
        this.fPF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fOC != null) {
                    j.this.fOC.bAl();
                }
            }
        };
        this.fPx = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.fPy = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.fPx.setDefaultResource(a.f.icon_live_vs_enter);
        this.fPx.setDefaultBgResource(0);
        this.fPx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fPx.setOnClickListener(this.fPE);
        this.fPy.setOnClickListener(this.fPE);
        this.fPz = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.fPA = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.fPz.setDefaultResource(a.f.icon_live_pk_enter);
        this.fPz.setDefaultBgResource(0);
        this.fPz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fPz.setOnClickListener(this.fPF);
        this.fPA.setOnClickListener(this.fPF);
        if (!StringUtils.isNull(com.baidu.live.v.a.Ge().aWF.axL)) {
            this.fPz.startLoad(com.baidu.live.v.a.Ge().aWF.axL, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.Ge().aWF.axM)) {
            this.fPx.startLoad(com.baidu.live.v.a.Ge().aWF.axM, 10, false);
        }
        this.fPB = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.fPC = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.fPB.setVisibility(0);
            this.fPD = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void Dz() {
        super.Dz();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bAb() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bD(int i) {
        if (!this.fPD) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.fPB.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.fPB.s(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.fPB.setVisibility(0);
                this.fPC.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.fPB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
