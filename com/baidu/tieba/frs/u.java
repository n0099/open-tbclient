package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class u extends j.a {
    public int aph;
    public FrameLayout cAJ;
    public PhotoLiveCardView cAK;
    public TbImageView czY;

    public u(View view, int i) {
        super(view);
        this.aph = 3;
        this.cAJ = (FrameLayout) view.findViewById(d.g.live_card_layout);
        this.czY = (TbImageView) view.findViewById(d.g.frs_single_livecard_theme_card);
        this.cAK = (PhotoLiveCardView) view.findViewById(d.g.item_live_card);
        this.cAK.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cAK.getLayoutParams();
        layoutParams.topMargin = i;
        this.cAK.setLayoutParams(layoutParams);
    }
}
