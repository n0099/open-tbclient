package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class di extends x.a {
    public ViewGroup aYg;
    public PhotoLiveCardView aYh;

    public di(View view) {
        super(view);
        this.aYg = (ViewGroup) view.findViewById(i.f.live_card_layout);
        this.aYh = (PhotoLiveCardView) view.findViewById(i.f.item_live_card);
        this.aYh.setAllowGreyState(true);
    }
}
