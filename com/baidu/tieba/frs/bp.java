package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bp extends y.a {
    public int ahp;
    public TbImageView bHZ;
    public FrameLayout bIK;
    public PhotoLiveCardView bIL;

    public bp(View view) {
        super(view);
        this.ahp = 3;
        this.bIK = (FrameLayout) view.findViewById(r.h.live_card_layout);
        this.bHZ = (TbImageView) view.findViewById(r.h.frs_single_livecard_theme_card);
        this.bIL = (PhotoLiveCardView) view.findViewById(r.h.item_live_card);
        this.bIL.setAllowGreyState(true);
    }

    public void ws() {
        if (this.bIL != null) {
            this.bIL.ws();
        }
    }
}
