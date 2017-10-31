package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int api;
    public TextView czX;
    public PhotoLiveCardView czY;
    public View czZ;

    public o(View view) {
        super(view);
        this.api = 3;
        this.czX = (TextView) view.findViewById(d.g.more_live_list);
        this.czY = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.czZ = view.findViewById(d.g.make_headlines);
    }
}
