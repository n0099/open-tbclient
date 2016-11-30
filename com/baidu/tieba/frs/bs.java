package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bs extends y.a {
    public int aiA;
    public TbImageView bUs;
    public FrameLayout bVi;
    public PhotoLiveCardView bVj;

    public bs(View view) {
        super(view);
        this.aiA = 3;
        this.bVi = (FrameLayout) view.findViewById(r.g.live_card_layout);
        this.bUs = (TbImageView) view.findViewById(r.g.frs_single_livecard_theme_card);
        this.bVj = (PhotoLiveCardView) view.findViewById(r.g.item_live_card);
        this.bVj.setAllowGreyState(true);
    }

    public void wM() {
        if (this.bVj != null) {
            this.bVj.wM();
        }
    }
}
