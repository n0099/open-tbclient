package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dy extends x.a {
    public int ahf;
    public ViewGroup bit;
    public PhotoLiveCardView biu;

    public dy(View view) {
        super(view);
        this.ahf = 3;
        this.bit = (ViewGroup) view.findViewById(n.g.live_card_layout);
        this.biu = (PhotoLiveCardView) view.findViewById(n.g.item_live_card);
        this.biu.setAllowGreyState(true);
    }
}
