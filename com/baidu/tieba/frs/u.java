package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class u extends j.a {
    public int apA;
    public FrameLayout cJN;
    public PhotoLiveCardView cJO;
    public TbImageView ccC;

    public u(View view, int i) {
        super(view);
        this.apA = 3;
        this.cJN = (FrameLayout) view.findViewById(d.g.live_card_layout);
        this.ccC = (TbImageView) view.findViewById(d.g.frs_single_livecard_theme_card);
        this.cJO = (PhotoLiveCardView) view.findViewById(d.g.item_live_card);
        this.cJO.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cJO.getLayoutParams();
        layoutParams.topMargin = i;
        this.cJO.setLayoutParams(layoutParams);
    }
}
