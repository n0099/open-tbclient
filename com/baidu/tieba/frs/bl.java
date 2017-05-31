package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bl extends z.a {
    public int ana;
    public TbImageView bVW;
    public FrameLayout bWC;
    public PhotoLiveCardView bWD;

    public bl(View view) {
        super(view);
        this.ana = 3;
        this.bWC = (FrameLayout) view.findViewById(w.h.live_card_layout);
        this.bVW = (TbImageView) view.findViewById(w.h.frs_single_livecard_theme_card);
        this.bWD = (PhotoLiveCardView) view.findViewById(w.h.item_live_card);
        this.bWD.setAllowGreyState(true);
    }
}
