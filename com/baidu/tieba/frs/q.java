package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public int bfL;
    public TextView dGQ;
    public PhotoLiveCardView dGR;
    public View dGS;

    public q(View view) {
        super(view);
        this.bfL = 3;
        this.dGQ = (TextView) view.findViewById(d.g.more_live_list);
        this.dGR = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.dGS = view.findViewById(d.g.make_headlines);
    }
}
