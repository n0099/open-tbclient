package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class u extends j.a {
    public int api;
    public FrameLayout cAq;
    public PhotoLiveCardView cAr;
    public TbImageView czF;

    public u(View view, int i) {
        super(view);
        this.api = 3;
        this.cAq = (FrameLayout) view.findViewById(d.g.live_card_layout);
        this.czF = (TbImageView) view.findViewById(d.g.frs_single_livecard_theme_card);
        this.cAr = (PhotoLiveCardView) view.findViewById(d.g.item_live_card);
        this.cAr.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cAr.getLayoutParams();
        layoutParams.topMargin = i;
        this.cAr.setLayoutParams(layoutParams);
    }
}
