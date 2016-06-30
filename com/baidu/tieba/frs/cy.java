package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cy extends y.a {
    public int aeK;
    public TbImageView bFR;
    public FrameLayout bGH;
    public PhotoLiveCardView bGI;

    public cy(View view) {
        super(view);
        this.aeK = 3;
        this.bGH = (FrameLayout) view.findViewById(u.g.live_card_layout);
        this.bFR = (TbImageView) view.findViewById(u.g.frs_single_livecard_theme_card);
        this.bGI = (PhotoLiveCardView) view.findViewById(u.g.item_live_card);
        this.bGI.setAllowGreyState(true);
    }

    public void vm() {
        if (this.bGI != null) {
            this.bGI.vm();
        }
    }
}
