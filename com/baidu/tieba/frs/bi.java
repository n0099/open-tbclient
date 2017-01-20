package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bi extends y.a {
    public int ahp;
    public TextView bIr;
    public PhotoLiveCardView bIs;
    public View bIt;

    public bi(View view) {
        super(view);
        this.ahp = 3;
        this.bIr = (TextView) view.findViewById(r.h.more_live_list);
        this.bIs = (PhotoLiveCardView) view.findViewById(r.h.photo_live_card);
        this.bIt = view.findViewById(r.h.make_headlines);
    }
}
