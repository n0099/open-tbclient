package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cu extends y.a {
    public int ahV;
    public TbImageView bSf;
    public FrameLayout bTc;
    public PhotoLiveCardView bTd;

    public cu(View view) {
        super(view);
        this.ahV = 3;
        this.bTc = (FrameLayout) view.findViewById(r.g.live_card_layout);
        this.bSf = (TbImageView) view.findViewById(r.g.frs_single_livecard_theme_card);
        this.bTd = (PhotoLiveCardView) view.findViewById(r.g.item_live_card);
        this.bTd.setAllowGreyState(true);
    }

    public void wH() {
        if (this.bTd != null) {
            this.bTd.wH();
        }
    }
}
