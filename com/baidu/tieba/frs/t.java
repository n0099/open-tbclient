package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends j.a {
    public int aql;
    public TbImageView ckY;
    public FrameLayout clE;
    public PhotoLiveCardView clF;

    public t(View view, int i) {
        super(view);
        this.aql = 3;
        this.clE = (FrameLayout) view.findViewById(d.h.live_card_layout);
        this.ckY = (TbImageView) view.findViewById(d.h.frs_single_livecard_theme_card);
        this.clF = (PhotoLiveCardView) view.findViewById(d.h.item_live_card);
        this.clF.setAllowGreyState(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.clF.getLayoutParams();
        layoutParams.topMargin = i;
        this.clF.setLayoutParams(layoutParams);
    }
}
