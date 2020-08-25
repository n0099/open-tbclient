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
    private TbImageView gsV;
    private TextView gsW;
    private TbImageView gsX;
    private TextView gsY;
    private BubbleLayout gsZ;
    private TextView gta;
    private boolean gtb;
    private View.OnClickListener gtc;
    private View.OnClickListener gtd;

    public l(Context context, m mVar) {
        super(context, mVar);
        this.gtb = false;
        this.gtc = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gtb && l.this.gsZ.getVisibility() == 0) {
                    l.this.gsZ.setVisibility(8);
                    l.this.gtb = false;
                }
                if (l.this.gsa != null) {
                    l.this.gsa.BY();
                    l.this.gsa.bQd();
                }
            }
        };
        this.gtd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gsa != null) {
                    l.this.gsa.bQe();
                }
            }
        };
        this.gsV = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.gsW = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.gsV.setDefaultResource(a.f.icon_live_vs_enter);
        this.gsV.setDefaultBgResource(0);
        this.gsV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gsV.setOnClickListener(this.gtc);
        this.gsW.setOnClickListener(this.gtc);
        this.gsX = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.gsY = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.gsX.setDefaultResource(a.f.icon_live_pk_enter);
        this.gsX.setDefaultBgResource(0);
        this.gsX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gsX.setOnClickListener(this.gtd);
        this.gsY.setOnClickListener(this.gtd);
        if (!StringUtils.isNull(com.baidu.live.w.a.Nk().beH.aGr)) {
            this.gsX.startLoad(com.baidu.live.w.a.Nk().beH.aGr, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.w.a.Nk().beH.aGs)) {
            this.gsV.startLoad(com.baidu.live.w.a.Nk().beH.aGs, 10, false);
        }
        this.gsZ = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.gta = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.gsZ.setVisibility(0);
            this.gtb = true;
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
    public int bPP() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dG(int i) {
        if (!this.gtb) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.gsZ.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.gsZ.u(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.gsZ.setVisibility(0);
                this.gta.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.gsZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
