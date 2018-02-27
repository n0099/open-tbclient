package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public int bfz;
    public TextView dGE;
    public PhotoLiveCardView dGF;
    public View dGG;

    public q(View view) {
        super(view);
        this.bfz = 3;
        this.dGE = (TextView) view.findViewById(d.g.more_live_list);
        this.dGF = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.dGG = view.findViewById(d.g.make_headlines);
    }
}
