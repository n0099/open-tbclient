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
    private TbImageView ebb;
    private TextView ebc;
    private TbImageView ebd;
    private TextView ebe;
    private BubbleLayout ebf;
    private TextView ebg;
    private boolean ebh;
    private View.OnClickListener ebi;
    private View.OnClickListener ebj;

    public j(Context context, k kVar) {
        super(context, kVar);
        this.ebh = false;
        this.ebi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.ebh && j.this.ebf.getVisibility() == 0) {
                    j.this.ebf.setVisibility(8);
                    j.this.ebh = false;
                }
                if (j.this.eai != null) {
                    j.this.eai.ob();
                    j.this.eai.aQG();
                }
            }
        };
        this.ebj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.eai != null) {
                    j.this.eai.aQH();
                }
            }
        };
        this.ebb = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.ebc = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.ebb.setDefaultResource(a.f.icon_live_vs_enter);
        this.ebb.setDefaultBgResource(0);
        this.ebb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ebb.setOnClickListener(this.ebi);
        this.ebc.setOnClickListener(this.ebi);
        this.ebd = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.ebe = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.ebd.setDefaultResource(a.f.icon_live_pk_enter);
        this.ebd.setDefaultBgResource(0);
        this.ebd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ebd.setOnClickListener(this.ebj);
        this.ebe.setOnClickListener(this.ebj);
        if (!StringUtils.isNull(com.baidu.live.l.a.uB().ajF.Rh)) {
            this.ebd.startLoad(com.baidu.live.l.a.uB().ajF.Rh, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.l.a.uB().ajF.Ri)) {
            this.ebb.startLoad(com.baidu.live.l.a.uB().ajF.Ri, 10, false);
        }
        this.ebf = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.ebg = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.ebf.setVisibility(0);
            this.ebh = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void aav() {
        super.aav();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int aQz() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(int i) {
        if (!this.ebh) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.ebf.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.ebf.K(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.ebf.setVisibility(0);
                this.ebg.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.ebf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
    }
}
