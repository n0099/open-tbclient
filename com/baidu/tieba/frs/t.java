package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends j.a {
    public int apQ;
    public TbImageView crX;
    public FrameLayout csD;
    public PhotoLiveCardView csE;

    public t(View view, int i) {
        super(view);
        this.apQ = 3;
        this.csD = (FrameLayout) view.findViewById(d.h.live_card_layout);
        this.crX = (TbImageView) view.findViewById(d.h.frs_single_livecard_theme_card);
        this.csE = (PhotoLiveCardView) view.findViewById(d.h.item_live_card);
        this.csE.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.csE.getLayoutParams();
        layoutParams.topMargin = i;
        this.csE.setLayoutParams(layoutParams);
    }
}
