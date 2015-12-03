package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dy extends x.a {
    public int afY;
    public PhotoLiveCardView beA;
    public ViewGroup bez;

    public dy(View view) {
        super(view);
        this.afY = 3;
        this.bez = (ViewGroup) view.findViewById(n.f.live_card_layout);
        this.beA = (PhotoLiveCardView) view.findViewById(n.f.item_live_card);
        this.beA.setAllowGreyState(true);
    }
}
