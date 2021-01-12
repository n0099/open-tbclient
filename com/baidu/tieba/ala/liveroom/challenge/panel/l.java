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
/* loaded from: classes10.dex */
public class l extends g {
    private TbImageView hto;
    private TextView htp;
    private TbImageView htq;
    private TextView htr;
    private BubbleLayout hts;
    private TextView htt;
    private boolean htu;
    private View.OnClickListener htv;
    private View.OnClickListener htw;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.htu = false;
        this.htv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.htu && l.this.hts.getVisibility() == 0) {
                    l.this.hts.setVisibility(8);
                    l.this.htu = false;
                }
                if (l.this.hsv != null) {
                    l.this.hsv.Af();
                    l.this.hsv.ccF();
                }
            }
        };
        this.htw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hsv != null) {
                    l.this.hsv.ccG();
                }
            }
        };
        this.hto = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.htp = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hto.setDefaultResource(a.e.icon_live_vs_enter);
        this.hto.setDefaultBgResource(0);
        this.hto.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hto.setOnClickListener(this.htv);
        this.htp.setOnClickListener(this.htv);
        this.htq = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.htr = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.htq.setDefaultResource(a.e.icon_live_pk_enter);
        this.htq.setDefaultBgResource(0);
        this.htq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.htq.setOnClickListener(this.htw);
        this.htr.setOnClickListener(this.htw);
        if (!StringUtils.isNull(com.baidu.live.af.a.OJ().bru.aJp)) {
            this.htq.startLoad(com.baidu.live.af.a.OJ().bru.aJp, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.af.a.OJ().bru.aJq)) {
            this.hto.startLoad(com.baidu.live.af.a.OJ().bru.aJq, 10, false);
        }
        this.hts = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.htt = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hts.setVisibility(0);
            this.htu = true;
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
    public int ccr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cv(int i) {
        if (!this.htu) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hts.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hts.v(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hts.setVisibility(0);
                this.htt.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hts.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
