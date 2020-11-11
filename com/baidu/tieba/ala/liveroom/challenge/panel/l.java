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
    private TbImageView hcH;
    private TextView hcI;
    private TbImageView hcJ;
    private TextView hcK;
    private BubbleLayout hcL;
    private TextView hcM;
    private boolean hcN;
    private View.OnClickListener hcO;
    private View.OnClickListener hcP;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hcN = false;
        this.hcO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hcN && l.this.hcL.getVisibility() == 0) {
                    l.this.hcL.setVisibility(8);
                    l.this.hcN = false;
                }
                if (l.this.hbO != null) {
                    l.this.hbO.DK();
                    l.this.hbO.car();
                }
            }
        };
        this.hcP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hbO != null) {
                    l.this.hbO.cas();
                }
            }
        };
        this.hcH = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hcI = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hcH.setDefaultResource(a.e.icon_live_vs_enter);
        this.hcH.setDefaultBgResource(0);
        this.hcH.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hcH.setOnClickListener(this.hcO);
        this.hcI.setOnClickListener(this.hcO);
        this.hcJ = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hcK = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hcJ.setDefaultResource(a.e.icon_live_pk_enter);
        this.hcJ.setDefaultBgResource(0);
        this.hcJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hcJ.setOnClickListener(this.hcP);
        this.hcK.setOnClickListener(this.hcP);
        if (!StringUtils.isNull(com.baidu.live.aa.a.PQ().bod.aMo)) {
            this.hcJ.startLoad(com.baidu.live.aa.a.PQ().bod.aMo, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.aa.a.PQ().bod.aMp)) {
            this.hcH.startLoad(com.baidu.live.aa.a.PQ().bod.aMp, 10, false);
        }
        this.hcL = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hcM = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hcL.setVisibility(0);
            this.hcN = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Pc() {
        super.Pc();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cad() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(int i) {
        if (!this.hcN) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hcL.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hcL.B(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hcL.setVisibility(0);
                this.hcM.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hcL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
