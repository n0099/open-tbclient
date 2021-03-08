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
    private TextView hzA;
    private boolean hzB;
    private View.OnClickListener hzC;
    private View.OnClickListener hzD;
    private TbImageView hzv;
    private TextView hzw;
    private TbImageView hzx;
    private TextView hzy;
    private BubbleLayout hzz;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.hzB = false;
        this.hzC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hzB && l.this.hzz.getVisibility() == 0) {
                    l.this.hzz.setVisibility(8);
                    l.this.hzB = false;
                }
                if (l.this.hyC != null) {
                    l.this.hyC.AS();
                    l.this.hyC.cdN();
                }
            }
        };
        this.hzD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hyC != null) {
                    l.this.hyC.cdO();
                }
            }
        };
        this.hzv = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_entry);
        this.hzw = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_challenge_title);
        this.hzv.setDefaultResource(a.e.icon_live_vs_enter);
        this.hzv.setDefaultBgResource(0);
        this.hzv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hzv.setOnClickListener(this.hzC);
        this.hzw.setOnClickListener(this.hzC);
        this.hzx = (TbImageView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_entry);
        this.hzy = (TextView) this.mRootView.findViewById(a.f.ala_challenge_index_pk_title);
        this.hzx.setDefaultResource(a.e.icon_live_pk_enter);
        this.hzx.setDefaultBgResource(0);
        this.hzx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hzx.setOnClickListener(this.hzD);
        this.hzy.setOnClickListener(this.hzD);
        if (!StringUtils.isNull(com.baidu.live.ae.a.Qm().bwx.aNz)) {
            this.hzx.startLoad(com.baidu.live.ae.a.Qm().bwx.aNz, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.ae.a.Qm().bwx.aNA)) {
            this.hzv.startLoad(com.baidu.live.ae.a.Qm().bwx.aNA, 10, false);
        }
        this.hzz = (BubbleLayout) this.mRootView.findViewById(a.f.ala_challenger_entry_tips_layout);
        this.hzA = (TextView) this.mRootView.findViewById(a.f.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.hzz.setVisibility(0);
            this.hzB = true;
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
    public int cdz() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cz(int i) {
        if (!this.hzB) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.hzz.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds348);
                this.hzz.D(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds162));
                this.hzz.setVisibility(0);
                this.hzA.setText(this.mContext.getString(a.h.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.hzz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
