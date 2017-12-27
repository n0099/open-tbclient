package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public int bdE;
    public TextView dyR;
    public PhotoLiveCardView dyS;
    public View dyT;

    public q(View view) {
        super(view);
        this.bdE = 3;
        this.dyR = (TextView) view.findViewById(d.g.more_live_list);
        this.dyS = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.dyT = view.findViewById(d.g.make_headlines);
    }
}
