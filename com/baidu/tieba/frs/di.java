package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class di extends x.a {
    public int ahf;
    public TextView bhK;
    public PhotoLiveCardView bhL;
    public View bhM;

    public di(View view) {
        super(view);
        this.ahf = 3;
        this.bhK = (TextView) view.findViewById(n.g.more_live_list);
        this.bhL = (PhotoLiveCardView) view.findViewById(n.g.photo_live_card);
        this.bhM = view.findViewById(n.g.make_headlines);
    }
}
