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
    private TbImageView hxU;
    private TextView hxV;
    private TbImageView hxW;
    private TextView hxX;
    private BubbleLayout hxY;
    private TextView hxZ;
    private boolean hya;
    private View.OnClickListener hyb;
    private View.OnClickListener hyc;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hya = false;
        this.hyb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hya && l.this.hxY.getVisibility() == 0) {
                    l.this.hxY.setVisibility(8);
                    l.this.hya = false;
                }
                if (l.this.hxb != null) {
                    l.this.hxb.Ea();
                    l.this.hxb.cgw();
                }
            }
        };
        this.hyc = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hxb != null) {
                    l.this.hxb.cgx();
                }
            }
        };
        this.hxU = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hxV = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hxU.setDefaultResource(a.e.icon_live_vs_enter);
        this.hxU.setDefaultBgResource(0);
        this.hxU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hxU.setOnClickListener(this.hyb);
        this.hxV.setOnClickListener(this.hyb);
        this.hxW = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hxX = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hxW.setDefaultResource(a.e.icon_live_pk_enter);
        this.hxW.setDefaultBgResource(0);
        this.hxW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hxW.setOnClickListener(this.hyc);
        this.hxX.setOnClickListener(this.hyc);
        if (!StringUtils.isNull(com.baidu.live.af.a.SE().bwi.aOc)) {
            this.hxW.startLoad(com.baidu.live.af.a.SE().bwi.aOc, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.af.a.SE().bwi.aOd)) {
            this.hxU.startLoad(com.baidu.live.af.a.SE().bwi.aOd, 10, false);
        }
        this.hxY = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hxZ = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hxY.setVisibility(0);
            this.hya = true;
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
    public int cgi() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eb(int i) {
        if (!this.hya) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hxY.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hxY.v(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hxY.setVisibility(0);
                this.hxZ.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hxY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
