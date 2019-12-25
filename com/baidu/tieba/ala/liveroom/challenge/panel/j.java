package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
/* loaded from: classes2.dex */
public class j extends e {
    private TbImageView eQW;
    private TextView eQX;
    private TbImageView eQY;
    private TextView eQZ;
    private BubbleLayout eRa;
    private TextView eRb;
    private boolean eRc;
    private View.OnClickListener eRd;
    private View.OnClickListener eRe;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.eRc = false;
        this.eRd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eRc && j.this.eRa.getVisibility() == 0) {
                    j.this.eRa.setVisibility(8);
                    j.this.eRc = false;
                }
                if (j.this.eQe != null) {
                    j.this.eQe.pt();
                    j.this.eQe.bik();
                }
            }
        };
        this.eRe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eQe != null) {
                    j.this.eQe.bil();
                }
            }
        };
        this.eQW = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.eQX = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.eQW.setDefaultResource(a.f.icon_live_vs_enter);
        this.eQW.setDefaultBgResource(0);
        this.eQW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eQW.setOnClickListener(this.eRd);
        this.eQX.setOnClickListener(this.eRd);
        this.eQY = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.eQZ = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.eQY.setDefaultResource(a.f.icon_live_pk_enter);
        this.eQY.setDefaultBgResource(0);
        this.eQY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eQY.setOnClickListener(this.eRe);
        this.eQZ.setOnClickListener(this.eRe);
        if (!StringUtils.isNull(com.baidu.live.r.a.wA().arE.XV)) {
            this.eQY.startLoad(com.baidu.live.r.a.wA().arE.XV, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.r.a.wA().arE.XW)) {
            this.eQW.startLoad(com.baidu.live.r.a.wA().arE.XW, 10, false);
        }
        this.eRa = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.eRb = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.eRa.setVisibility(0);
            this.eRc = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bid() {
        super.bid();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bic() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bc(int i) {
        if (!this.eRc) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.eRa.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.eRa.L(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.eRa.setVisibility(0);
                this.eRb.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.eRa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
