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
    private TbImageView eWE;
    private TextView eWF;
    private TbImageView eWG;
    private TextView eWH;
    private BubbleLayout eWI;
    private TextView eWJ;
    private boolean eWK;
    private View.OnClickListener eWL;
    private View.OnClickListener eWM;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.eWK = false;
        this.eWL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eWK && j.this.eWI.getVisibility() == 0) {
                    j.this.eWI.setVisibility(8);
                    j.this.eWK = false;
                }
                if (j.this.eVI != null) {
                    j.this.eVI.qi();
                    j.this.eVI.bkP();
                }
            }
        };
        this.eWM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eVI != null) {
                    j.this.eVI.bkQ();
                }
            }
        };
        this.eWE = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.eWF = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.eWE.setDefaultResource(a.f.icon_live_vs_enter);
        this.eWE.setDefaultBgResource(0);
        this.eWE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eWE.setOnClickListener(this.eWL);
        this.eWF.setOnClickListener(this.eWL);
        this.eWG = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.eWH = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.eWG.setDefaultResource(a.f.icon_live_pk_enter);
        this.eWG.setDefaultBgResource(0);
        this.eWG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eWG.setOnClickListener(this.eWM);
        this.eWH.setOnClickListener(this.eWM);
        if (!StringUtils.isNull(com.baidu.live.v.a.zl().awC.aag)) {
            this.eWG.startLoad(com.baidu.live.v.a.zl().awC.aag, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.zl().awC.aah)) {
            this.eWE.startLoad(com.baidu.live.v.a.zl().awC.aah, 10, false);
        }
        this.eWI = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.eWJ = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.eWI.setVisibility(0);
            this.eWK = true;
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
    public int bkG() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bj(int i) {
        if (!this.eWK) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.eWI.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.eWI.L(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.eWI.setVisibility(0);
                this.eWJ.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.eWI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
