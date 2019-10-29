package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
/* loaded from: classes6.dex */
public class j extends e {
    private TbImageView ebS;
    private TextView ebT;
    private TbImageView ebU;
    private TextView ebV;
    private BubbleLayout ebW;
    private TextView ebX;
    private boolean ebY;
    private View.OnClickListener ebZ;
    private View.OnClickListener eca;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.ebY = false;
        this.ebZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.ebY && j.this.ebW.getVisibility() == 0) {
                    j.this.ebW.setVisibility(8);
                    j.this.ebY = false;
                }
                if (j.this.eaZ != null) {
                    j.this.eaZ.ob();
                    j.this.eaZ.aQI();
                }
            }
        };
        this.eca = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eaZ != null) {
                    j.this.eaZ.aQJ();
                }
            }
        };
        this.ebS = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.ebT = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.ebS.setDefaultResource(a.f.icon_live_vs_enter);
        this.ebS.setDefaultBgResource(0);
        this.ebS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ebS.setOnClickListener(this.ebZ);
        this.ebT.setOnClickListener(this.ebZ);
        this.ebU = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.ebV = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.ebU.setDefaultResource(a.f.icon_live_pk_enter);
        this.ebU.setDefaultBgResource(0);
        this.ebU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ebU.setOnClickListener(this.eca);
        this.ebV.setOnClickListener(this.eca);
        if (!StringUtils.isNull(com.baidu.live.l.a.uA().ajX.RH)) {
            this.ebU.startLoad(com.baidu.live.l.a.uA().ajX.RH, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.l.a.uA().ajX.RI)) {
            this.ebS.startLoad(com.baidu.live.l.a.uA().ajX.RI, 10, false);
        }
        this.ebW = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.ebX = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.ebW.setVisibility(0);
            this.ebY = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void aax() {
        super.aax();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int aQB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(int i) {
        if (!this.ebY) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.ebW.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.ebW.K(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.ebW.setVisibility(0);
                this.ebX.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.ebW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
