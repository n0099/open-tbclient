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
    public TbImageView clK;
    public FrameLayout cmr;
    public PhotoLiveCardView cms;

    public t(View view, int i) {
        super(view);
        this.aqm = 3;
        this.cmr = (FrameLayout) view.findViewById(d.h.live_card_layout);
        this.clK = (TbImageView) view.findViewById(d.h.frs_single_livecard_theme_card);
        this.cms = (PhotoLiveCardView) view.findViewById(d.h.item_live_card);
        this.cms.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cms.getLayoutParams();
        layoutParams.topMargin = i;
        this.cms.setLayoutParams(layoutParams);
    }
}
