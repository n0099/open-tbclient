package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class el extends x.a {
    public int aik;
    public TbImageView bpB;
    public FrameLayout bqB;
    public PhotoLiveCardView bqC;

    public el(View view) {
        super(view);
        this.aik = 3;
        this.bqB = (FrameLayout) view.findViewById(t.g.live_card_layout);
        this.bpB = (TbImageView) view.findViewById(t.g.frs_single_livecard_theme_card);
        this.bqC = (PhotoLiveCardView) view.findViewById(t.g.item_live_card);
        this.bqC.setAllowGreyState(true);
    }

    public void xy() {
        if (this.bqC != null) {
            this.bqC.xy();
        }
    }
}
