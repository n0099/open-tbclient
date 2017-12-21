package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends j.a {
    public int apG;
    public TextView cJI;
    public PhotoLiveCardView cJJ;
    public View cJK;

    public p(View view) {
        super(view);
        this.apG = 3;
        this.cJI = (TextView) view.findViewById(d.g.more_live_list);
        this.cJJ = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.cJK = view.findViewById(d.g.make_headlines);
    }
}
