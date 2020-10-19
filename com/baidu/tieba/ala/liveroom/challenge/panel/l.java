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
    private TbImageView gKO;
    private TextView gKP;
    private TbImageView gKQ;
    private TextView gKR;
    private BubbleLayout gKS;
    private TextView gKT;
    private boolean gKU;
    private View.OnClickListener gKV;
    private View.OnClickListener gKW;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.gKU = false;
        this.gKV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gKU && l.this.gKS.getVisibility() == 0) {
                    l.this.gKS.setVisibility(8);
                    l.this.gKU = false;
                }
                if (l.this.gJV != null) {
                    l.this.gJV.Dk();
                    l.this.gJV.bUQ();
                }
            }
        };
        this.gKW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gJV != null) {
                    l.this.gJV.bUR();
                }
            }
        };
        this.gKO = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.gKP = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.gKO.setDefaultResource(a.f.icon_live_vs_enter);
        this.gKO.setDefaultBgResource(0);
        this.gKO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gKO.setOnClickListener(this.gKV);
        this.gKP.setOnClickListener(this.gKV);
        this.gKQ = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.gKR = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.gKQ.setDefaultResource(a.f.icon_live_pk_enter);
        this.gKQ.setDefaultBgResource(0);
        this.gKQ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gKQ.setOnClickListener(this.gKW);
        this.gKR.setOnClickListener(this.gKW);
        if (!StringUtils.isNull(com.baidu.live.x.a.OS().blo.aKM)) {
            this.gKQ.startLoad(com.baidu.live.x.a.OS().blo.aKM, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.x.a.OS().blo.aKN)) {
            this.gKO.startLoad(com.baidu.live.x.a.OS().blo.aKN, 10, false);
        }
        this.gKS = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.gKT = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.gKS.setVisibility(0);
            this.gKU = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Oe() {
        super.Oe();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bUC() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(int i) {
        if (!this.gKU) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.gKS.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.gKS.A(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.gKS.setVisibility(0);
                this.gKT.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.gKS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
