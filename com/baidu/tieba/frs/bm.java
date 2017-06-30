package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bm extends z.a {
    public int aoa;
    public FrameLayout ceK;
    public PhotoLiveCardView ceL;
    public TbImageView cee;

    public bm(View view) {
        super(view);
        this.aoa = 3;
        this.ceK = (FrameLayout) view.findViewById(w.h.live_card_layout);
        this.cee = (TbImageView) view.findViewById(w.h.frs_single_livecard_theme_card);
        this.ceL = (PhotoLiveCardView) view.findViewById(w.h.item_live_card);
        this.ceL.setAllowGreyState(true);
    }
}
