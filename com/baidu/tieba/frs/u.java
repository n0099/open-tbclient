package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class u extends j.a {
    public int aoN;
    public FrameLayout csT;
    public PhotoLiveCardView csU;
    public TbImageView csi;

    public u(View view, int i) {
        super(view);
        this.aoN = 3;
        this.csT = (FrameLayout) view.findViewById(d.h.live_card_layout);
        this.csi = (TbImageView) view.findViewById(d.h.frs_single_livecard_theme_card);
        this.csU = (PhotoLiveCardView) view.findViewById(d.h.item_live_card);
        this.csU.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.csU.getLayoutParams();
        layoutParams.topMargin = i;
        this.csU.setLayoutParams(layoutParams);
    }
}
