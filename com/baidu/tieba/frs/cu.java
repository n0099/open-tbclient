package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cu extends y.a {
    public int ait;
    public TbImageView bSm;
    public FrameLayout bTj;
    public PhotoLiveCardView bTk;

    public cu(View view) {
        super(view);
        this.ait = 3;
        this.bTj = (FrameLayout) view.findViewById(t.g.live_card_layout);
        this.bSm = (TbImageView) view.findViewById(t.g.frs_single_livecard_theme_card);
        this.bTk = (PhotoLiveCardView) view.findViewById(t.g.item_live_card);
        this.bTk.setAllowGreyState(true);
    }

    public void wq() {
        if (this.bTk != null) {
            this.bTk.wq();
        }
    }
}
