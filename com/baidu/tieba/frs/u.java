package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class u extends j.a {
    public int aoZ;
    public TbImageView csu;
    public FrameLayout ctf;
    public PhotoLiveCardView ctg;

    public u(View view, int i) {
        super(view);
        this.aoZ = 3;
        this.ctf = (FrameLayout) view.findViewById(d.h.live_card_layout);
        this.csu = (TbImageView) view.findViewById(d.h.frs_single_livecard_theme_card);
        this.ctg = (PhotoLiveCardView) view.findViewById(d.h.item_live_card);
        this.ctg.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ctg.getLayoutParams();
        layoutParams.topMargin = i;
        this.ctg.setLayoutParams(layoutParams);
    }
}
