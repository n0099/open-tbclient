package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bp extends y.a {
    public int amL;
    public FrameLayout bPT;
    public PhotoLiveCardView bPU;
    public TbImageView bPi;

    public bp(View view) {
        super(view);
        this.amL = 3;
        this.bPT = (FrameLayout) view.findViewById(w.h.live_card_layout);
        this.bPi = (TbImageView) view.findViewById(w.h.frs_single_livecard_theme_card);
        this.bPU = (PhotoLiveCardView) view.findViewById(w.h.item_live_card);
        this.bPU.setAllowGreyState(true);
    }

    public void wP() {
        if (this.bPU != null) {
            this.bPU.wP();
        }
    }
}
