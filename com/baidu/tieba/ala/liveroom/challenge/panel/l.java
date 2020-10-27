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
    private TbImageView gWD;
    private TextView gWE;
    private TbImageView gWF;
    private TextView gWG;
    private BubbleLayout gWH;
    private TextView gWI;
    private boolean gWJ;
    private View.OnClickListener gWK;
    private View.OnClickListener gWL;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.gWJ = false;
        this.gWK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gWJ && l.this.gWH.getVisibility() == 0) {
                    l.this.gWH.setVisibility(8);
                    l.this.gWJ = false;
                }
                if (l.this.gVK != null) {
                    l.this.gVK.Dr();
                    l.this.gVK.bXP();
                }
            }
        };
        this.gWL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gVK != null) {
                    l.this.gVK.bXQ();
                }
            }
        };
        this.gWD = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.gWE = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.gWD.setDefaultResource(a.f.icon_live_vs_enter);
        this.gWD.setDefaultBgResource(0);
        this.gWD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gWD.setOnClickListener(this.gWK);
        this.gWE.setOnClickListener(this.gWK);
        this.gWF = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.gWG = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.gWF.setDefaultResource(a.f.icon_live_pk_enter);
        this.gWF.setDefaultBgResource(0);
        this.gWF.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gWF.setOnClickListener(this.gWL);
        this.gWG.setOnClickListener(this.gWL);
        if (!StringUtils.isNull(com.baidu.live.z.a.Pq().bmJ.aLo)) {
            this.gWF.startLoad(com.baidu.live.z.a.Pq().bmJ.aLo, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.z.a.Pq().bmJ.aLp)) {
            this.gWD.startLoad(com.baidu.live.z.a.Pq().bmJ.aLp, 10, false);
        }
        this.gWH = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.gWI = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.gWH.setVisibility(0);
            this.gWJ = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void OC() {
        super.OC();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(int i) {
        if (!this.gWJ) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.gWH.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.gWH.A(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.gWH.setVisibility(0);
                this.gWI.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.gWH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
