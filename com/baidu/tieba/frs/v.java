package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class v extends j.a {
    public int apG;
    public FrameLayout cKb;
    public PhotoLiveCardView cKc;
    public TbImageView ccL;

    public v(View view, int i) {
        super(view);
        this.apG = 3;
        this.cKb = (FrameLayout) view.findViewById(d.g.live_card_layout);
        this.ccL = (TbImageView) view.findViewById(d.g.frs_single_livecard_theme_card);
        this.cKc = (PhotoLiveCardView) view.findViewById(d.g.item_live_card);
        this.cKc.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cKc.getLayoutParams();
        layoutParams.topMargin = i;
        this.cKc.setLayoutParams(layoutParams);
    }
}
