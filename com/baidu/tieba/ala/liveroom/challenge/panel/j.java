package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
/* loaded from: classes2.dex */
public class j extends e {
    private TextView eSA;
    private TbImageView eSB;
    private TextView eSC;
    private BubbleLayout eSD;
    private TextView eSE;
    private boolean eSF;
    private View.OnClickListener eSG;
    private View.OnClickListener eSH;
    private TbImageView eSz;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.eSF = false;
        this.eSG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eSF && j.this.eSD.getVisibility() == 0) {
                    j.this.eSD.setVisibility(8);
                    j.this.eSF = false;
                }
                if (j.this.eRD != null) {
                    j.this.eRD.px();
                    j.this.eRD.biX();
                }
            }
        };
        this.eSH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eRD != null) {
                    j.this.eRD.biY();
                }
            }
        };
        this.eSz = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.eSA = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.eSz.setDefaultResource(a.f.icon_live_vs_enter);
        this.eSz.setDefaultBgResource(0);
        this.eSz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eSz.setOnClickListener(this.eSG);
        this.eSA.setOnClickListener(this.eSG);
        this.eSB = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.eSC = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.eSB.setDefaultResource(a.f.icon_live_pk_enter);
        this.eSB.setDefaultBgResource(0);
        this.eSB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eSB.setOnClickListener(this.eSH);
        this.eSC.setOnClickListener(this.eSH);
        if (!StringUtils.isNull(com.baidu.live.s.a.wR().asq.Yo)) {
            this.eSB.startLoad(com.baidu.live.s.a.wR().asq.Yo, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.s.a.wR().asq.Yp)) {
            this.eSz.startLoad(com.baidu.live.s.a.wR().asq.Yp, 10, false);
        }
        this.eSD = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.eSE = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.eSD.setVisibility(0);
            this.eSF = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void biO() {
        super.biO();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int biN() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bc(int i) {
        if (!this.eSF) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.eSD.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.eSD.L(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.eSD.setVisibility(0);
                this.eSE.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.eSD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
