package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class br extends y.a {
    public int aib;
    public TbImageView bAE;
    public FrameLayout bBq;
    public PhotoLiveCardView bBr;

    public br(View view) {
        super(view);
        this.aib = 3;
        this.bBq = (FrameLayout) view.findViewById(r.g.live_card_layout);
        this.bAE = (TbImageView) view.findViewById(r.g.frs_single_livecard_theme_card);
        this.bBr = (PhotoLiveCardView) view.findViewById(r.g.item_live_card);
        this.bBr.setAllowGreyState(true);
    }

    public void wx() {
        if (this.bBr != null) {
            this.bBr.wx();
        }
    }
}
