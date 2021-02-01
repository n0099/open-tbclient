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
/* loaded from: classes11.dex */
public class l extends g {
    private TbImageView hxA;
    private TextView hxB;
    private BubbleLayout hxC;
    private TextView hxD;
    private boolean hxE;
    private View.OnClickListener hxF;
    private View.OnClickListener hxG;
    private TbImageView hxy;
    private TextView hxz;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hxE = false;
        this.hxF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hxE && l.this.hxC.getVisibility() == 0) {
                    l.this.hxC.setVisibility(8);
                    l.this.hxE = false;
                }
                if (l.this.hwF != null) {
                    l.this.hwF.AP();
                    l.this.hwF.cdA();
                }
            }
        };
        this.hxG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hwF != null) {
                    l.this.hwF.cdB();
                }
            }
        };
        this.hxy = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hxz = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hxy.setDefaultResource(a.e.icon_live_vs_enter);
        this.hxy.setDefaultBgResource(0);
        this.hxy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hxy.setOnClickListener(this.hxF);
        this.hxz.setOnClickListener(this.hxF);
        this.hxA = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hxB = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hxA.setDefaultResource(a.e.icon_live_pk_enter);
        this.hxA.setDefaultBgResource(0);
        this.hxA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hxA.setOnClickListener(this.hxG);
        this.hxB.setOnClickListener(this.hxG);
        if (!StringUtils.isNull(com.baidu.live.ae.a.Qj().buX.aLZ)) {
            this.hxA.startLoad(com.baidu.live.ae.a.Qj().buX.aLZ, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.ae.a.Qj().buX.aMa)) {
            this.hxy.startLoad(com.baidu.live.ae.a.Qj().buX.aMa, 10, false);
        }
        this.hxC = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hxD = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hxC.setVisibility(0);
            this.hxE = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdm() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cy(int i) {
        if (!this.hxE) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hxC.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hxC.v(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hxC.setVisibility(0);
                this.hxD.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hxC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
