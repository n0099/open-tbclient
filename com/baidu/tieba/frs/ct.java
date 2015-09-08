package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ct extends x.a {
    public ViewGroup aYE;
    public PhotoLiveCardView aYF;

    public ct(View view) {
        super(view);
        this.aYE = (ViewGroup) view.findViewById(i.f.live_card_layout);
        this.aYF = (PhotoLiveCardView) view.findViewById(i.f.item_live_card);
        this.aYF.setAllowGreyState(true);
    }
}
