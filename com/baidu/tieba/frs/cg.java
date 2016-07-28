package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cg extends y.a {
    public int afy;
    public PhotoLiveCardView bHA;
    public View bHB;
    public TextView bHz;

    public cg(View view) {
        super(view);
        this.afy = 3;
        this.bHz = (TextView) view.findViewById(u.g.more_live_list);
        this.bHA = (PhotoLiveCardView) view.findViewById(u.g.photo_live_card);
        this.bHB = view.findViewById(u.g.make_headlines);
    }
}
