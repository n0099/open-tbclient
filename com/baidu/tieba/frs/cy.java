package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cy extends y.a {
    public int afy;
    public TbImageView bHg;
    public FrameLayout bId;
    public PhotoLiveCardView bIe;

    public cy(View view) {
        super(view);
        this.afy = 3;
        this.bId = (FrameLayout) view.findViewById(u.g.live_card_layout);
        this.bHg = (TbImageView) view.findViewById(u.g.frs_single_livecard_theme_card);
        this.bIe = (PhotoLiveCardView) view.findViewById(u.g.item_live_card);
        this.bIe.setAllowGreyState(true);
    }

    public void vm() {
        if (this.bIe != null) {
            this.bIe.vm();
        }
    }
}
