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
/* loaded from: classes3.dex */
public class l extends g {
    private TbImageView gbE;
    private TextView gbF;
    private TbImageView gbG;
    private TextView gbH;
    private BubbleLayout gbI;
    private TextView gbJ;
    private boolean gbK;
    private View.OnClickListener gbL;
    private View.OnClickListener gbM;

    public l(Context context, m mVar) {
        super(context, mVar);
        this.gbK = false;
        this.gbL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gbK && l.this.gbI.getVisibility() == 0) {
                    l.this.gbI.setVisibility(8);
                    l.this.gbK = false;
                }
                if (l.this.gaK != null) {
                    l.this.gaK.we();
                    l.this.gaK.bDn();
                }
            }
        };
        this.gbM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gaK != null) {
                    l.this.gaK.bDo();
                }
            }
        };
        this.gbE = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.gbF = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.gbE.setDefaultResource(a.f.icon_live_vs_enter);
        this.gbE.setDefaultBgResource(0);
        this.gbE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gbE.setOnClickListener(this.gbL);
        this.gbF.setOnClickListener(this.gbL);
        this.gbG = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.gbH = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.gbG.setDefaultResource(a.f.icon_live_pk_enter);
        this.gbG.setDefaultBgResource(0);
        this.gbG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gbG.setOnClickListener(this.gbM);
        this.gbH.setOnClickListener(this.gbM);
        if (!StringUtils.isNull(com.baidu.live.v.a.Hm().aZp.azU)) {
            this.gbG.startLoad(com.baidu.live.v.a.Hm().aZp.azU, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.Hm().aZp.azV)) {
            this.gbE.startLoad(com.baidu.live.v.a.Hm().aZp.azV, 10, false);
        }
        this.gbI = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.gbJ = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.gbI.setVisibility(0);
            this.gbK = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Eb() {
        super.Eb();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bCZ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bO(int i) {
        if (!this.gbK) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.gbI.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.gbI.u(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.gbI.setVisibility(0);
                this.gbJ.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.gbI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
