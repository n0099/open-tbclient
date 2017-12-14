package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends j.a {
    public int apD;
    public TextView cJE;
    public PhotoLiveCardView cJF;
    public View cJG;

    public p(View view) {
        super(view);
        this.apD = 3;
        this.cJE = (TextView) view.findViewById(d.g.more_live_list);
        this.cJF = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.cJG = view.findViewById(d.g.make_headlines);
    }
}
