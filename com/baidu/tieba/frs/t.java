package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends j.a {
    public int aoR;
    public TbImageView cjQ;
    public FrameLayout ckw;
    public PhotoLiveCardView ckx;

    public t(View view, int i) {
        super(view);
        this.aoR = 3;
        this.ckw = (FrameLayout) view.findViewById(d.h.live_card_layout);
        this.cjQ = (TbImageView) view.findViewById(d.h.frs_single_livecard_theme_card);
        this.ckx = (PhotoLiveCardView) view.findViewById(d.h.item_live_card);
        this.ckx.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ckx.getLayoutParams();
        layoutParams.topMargin = i;
        this.ckx.setLayoutParams(layoutParams);
    }
}
