package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ed extends x.a {
    public int ahU;
    public ViewGroup blj;
    public PhotoLiveCardView blk;

    public ed(View view) {
        super(view);
        this.ahU = 3;
        this.blj = (ViewGroup) view.findViewById(t.g.live_card_layout);
        this.blk = (PhotoLiveCardView) view.findViewById(t.g.item_live_card);
        this.blk.setAllowGreyState(true);
    }

    public void xf() {
        if (this.blk != null) {
            this.blk.xf();
        }
    }
}
