package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int apA;
    public TextView cJu;
    public PhotoLiveCardView cJv;
    public View cJw;

    public o(View view) {
        super(view);
        this.apA = 3;
        this.cJu = (TextView) view.findViewById(d.g.more_live_list);
        this.cJv = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.cJw = view.findViewById(d.g.make_headlines);
    }
}
