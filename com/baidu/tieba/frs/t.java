package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends j.a {
    public int aqm;
    public TbImageView clJ;
    public FrameLayout cmq;
    public PhotoLiveCardView cmr;

    public t(View view, int i) {
        super(view);
        this.aqm = 3;
        this.cmq = (FrameLayout) view.findViewById(d.h.live_card_layout);
        this.clJ = (TbImageView) view.findViewById(d.h.frs_single_livecard_theme_card);
        this.cmr = (PhotoLiveCardView) view.findViewById(d.h.item_live_card);
        this.cmr.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cmr.getLayoutParams();
        layoutParams.topMargin = i;
        this.cmr.setLayoutParams(layoutParams);
    }
}
