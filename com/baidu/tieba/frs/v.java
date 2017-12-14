package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class v extends j.a {
    public int apD;
    public FrameLayout cJX;
    public PhotoLiveCardView cJY;
    public TbImageView ccH;

    public v(View view, int i) {
        super(view);
        this.apD = 3;
        this.cJX = (FrameLayout) view.findViewById(d.g.live_card_layout);
        this.ccH = (TbImageView) view.findViewById(d.g.frs_single_livecard_theme_card);
        this.cJY = (PhotoLiveCardView) view.findViewById(d.g.item_live_card);
        this.cJY.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cJY.getLayoutParams();
        layoutParams.topMargin = i;
        this.cJY.setLayoutParams(layoutParams);
    }
}
