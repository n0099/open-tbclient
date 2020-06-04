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
    private TbImageView fPI;
    private TextView fPJ;
    private TbImageView fPK;
    private TextView fPL;
    private BubbleLayout fPM;
    private TextView fPN;
    private boolean fPO;
    private View.OnClickListener fPP;
    private View.OnClickListener fPQ;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.fPO = false;
        this.fPP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fPO && j.this.fPM.getVisibility() == 0) {
                    j.this.fPM.setVisibility(8);
                    j.this.fPO = false;
                }
                if (j.this.fON != null) {
                    j.this.fON.vK();
                    j.this.fON.bAm();
                }
            }
        };
        this.fPQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.fON != null) {
                    j.this.fON.bAn();
                }
            }
        };
        this.fPI = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.fPJ = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.fPI.setDefaultResource(a.f.icon_live_vs_enter);
        this.fPI.setDefaultBgResource(0);
        this.fPI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fPI.setOnClickListener(this.fPP);
        this.fPJ.setOnClickListener(this.fPP);
        this.fPK = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.fPL = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.fPK.setDefaultResource(a.f.icon_live_pk_enter);
        this.fPK.setDefaultBgResource(0);
        this.fPK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fPK.setOnClickListener(this.fPQ);
        this.fPL.setOnClickListener(this.fPQ);
        if (!StringUtils.isNull(com.baidu.live.v.a.Ge().aWF.axL)) {
            this.fPK.startLoad(com.baidu.live.v.a.Ge().aWF.axL, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.Ge().aWF.axM)) {
            this.fPI.startLoad(com.baidu.live.v.a.Ge().aWF.axM, 10, false);
        }
        this.fPM = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.fPN = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.fPM.setVisibility(0);
            this.fPO = true;
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
    public int bAd() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bF(int i) {
        if (!this.fPO) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.fPM.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.fPM.s(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.fPM.setVisibility(0);
                this.fPN.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.fPM.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
