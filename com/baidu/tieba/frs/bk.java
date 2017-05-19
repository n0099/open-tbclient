package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bk extends y.a {
    public int ane;
    public FrameLayout bQL;
    public PhotoLiveCardView bQM;
    public TbImageView bQf;

    public bk(View view) {
        super(view);
        this.ane = 3;
        this.bQL = (FrameLayout) view.findViewById(w.h.live_card_layout);
        this.bQf = (TbImageView) view.findViewById(w.h.frs_single_livecard_theme_card);
        this.bQM = (PhotoLiveCardView) view.findViewById(w.h.item_live_card);
        this.bQM.setAllowGreyState(true);
    }
}
