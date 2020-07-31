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
    private TbImageView ggM;
    private TextView ggN;
    private TbImageView ggO;
    private TextView ggP;
    private BubbleLayout ggQ;
    private TextView ggR;
    private boolean ggS;
    private View.OnClickListener ggT;
    private View.OnClickListener ggU;

    public l(Context context, m mVar) {
        super(context, mVar);
        this.ggS = false;
        this.ggT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ggS && l.this.ggQ.getVisibility() == 0) {
                    l.this.ggQ.setVisibility(8);
                    l.this.ggS = false;
                }
                if (l.this.gfS != null) {
                    l.this.gfS.wA();
                    l.this.gfS.bGy();
                }
            }
        };
        this.ggU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gfS != null) {
                    l.this.gfS.bGz();
                }
            }
        };
        this.ggM = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_entry);
        this.ggN = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_challenge_title);
        this.ggM.setDefaultResource(a.f.icon_live_vs_enter);
        this.ggM.setDefaultBgResource(0);
        this.ggM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ggM.setOnClickListener(this.ggT);
        this.ggN.setOnClickListener(this.ggT);
        this.ggO = (TbImageView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_entry);
        this.ggP = (TextView) this.mRootView.findViewById(a.g.ala_challenge_index_pk_title);
        this.ggO.setDefaultResource(a.f.icon_live_pk_enter);
        this.ggO.setDefaultBgResource(0);
        this.ggO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ggO.setOnClickListener(this.ggU);
        this.ggP.setOnClickListener(this.ggU);
        if (!StringUtils.isNull(com.baidu.live.v.a.Hs().aZn.aBh)) {
            this.ggO.startLoad(com.baidu.live.v.a.Hs().aZn.aBh, 10, false);
        }
        if (!StringUtils.isNull(com.baidu.live.v.a.Hs().aZn.aBi)) {
            this.ggM.startLoad(com.baidu.live.v.a.Hs().aZn.aBi, 10, false);
        }
        this.ggQ = (BubbleLayout) this.mRootView.findViewById(a.g.ala_challenger_entry_tips_layout);
        this.ggR = (TextView) this.mRootView.findViewById(a.g.ala_challenger_entry_tip_txt);
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, false)) {
            this.ggQ.setVisibility(0);
            this.ggS = true;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SHOW_CHALLENGE_ENTRY_TIP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void GF() {
        super.GF();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_index_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bGk() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds440) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bU(int i) {
        if (!this.ggS) {
            if (i > 0) {
                ((FrameLayout.LayoutParams) this.ggQ.getLayoutParams()).width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds348);
                this.ggQ.u(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds162));
                this.ggQ.setVisibility(0);
                this.ggR.setText(this.mContext.getString(a.i.ala_challenge_count_bubble_tip, Integer.valueOf(i)));
                return;
            }
            this.ggQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }
}
