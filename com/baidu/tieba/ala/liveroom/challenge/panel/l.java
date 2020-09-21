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
    private TextView gwA;
    private boolean gwB;
    private View.OnClickListener gwC;
    private View.OnClickListener gwD;
    private TbImageView gwv;
    private TextView gww;
    private TbImageView gwx;
    private TextView gwy;
    private BubbleLayout gwz;

    public l(Context context, n nVar) {
        super(context, nVar);
        this.gwB = false;
        this.gwC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gwB && l.this.gwz.getVisibility() == 0) {
                    l.this.gwz.setVisibility(8);
                    l.this.gwB = false;
                }
                if (l.this.gvA != null) {
                    l.this.gvA.Cn();
                    l.this.gvA.bRw();
                }
            }
        };
        this.gwD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gvA != null) {
                    l.this.gvA.bRx();
                }
            }
        };
        this.gwv = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.gww = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.gwv.setDefaultResource(a.f.icon_live_vs_enter);
        this.gwv.setDefaultBgResource(0);
        this.gwv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gwv.setOnClickListener(this.gwC);
        this.gww.setOnClickListener(this.gwC);
        this.gwx = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.gwy = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.gwx.setDefaultResource(a.f.icon_live_pk_enter);
        this.gwx.setDefaultBgResource(0);
        this.gwx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gwx.setOnClickListener(this.gwD);
        this.gwy.setOnClickListener(this.gwD);
        if (!StringUtils.isNull(com.baidu.live.x.a.NN().bhy.aHI)) {
            this.gwx.startLoad(com.baidu.live.x.a.NN().bhy.aHI, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.x.a.NN().bhy.aHJ)) {
            this.gwv.startLoad(com.baidu.live.x.a.NN().bhy.aHJ, 10, false);
        }
        this.gwz = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.gwA = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.gwz.setVisibility(0);
            this.gwB = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void MZ() {
        super.MZ();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bRi() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(int i) {
        if (!this.gwB) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.gwz.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.gwz.u(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.gwz.setVisibility(0);
                this.gwA.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.gwz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
