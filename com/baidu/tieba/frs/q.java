package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public int bdS;
    public TextView dDN;
    public PhotoLiveCardView dDO;
    public View dDP;

    public q(View view) {
        super(view);
        this.bdS = 3;
        this.dDN = (TextView) view.findViewById(d.g.more_live_list);
        this.dDO = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.dDP = view.findViewById(d.g.make_headlines);
    }
}
