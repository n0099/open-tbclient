package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cc extends y.a {
    public int ahV;
    public View bSA;
    public TextView bSy;
    public PhotoLiveCardView bSz;

    public cc(View view) {
        super(view);
        this.ahV = 3;
        this.bSy = (TextView) view.findViewById(r.g.more_live_list);
        this.bSz = (PhotoLiveCardView) view.findViewById(r.g.photo_live_card);
        this.bSA = view.findViewById(r.g.make_headlines);
    }
}
