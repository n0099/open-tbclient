package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dn extends x.a {
    public int ahU;
    public TextView bkC;
    public PhotoLiveCardView bkD;
    public View bkE;

    public dn(View view) {
        super(view);
        this.ahU = 3;
        this.bkC = (TextView) view.findViewById(t.g.more_live_list);
        this.bkD = (PhotoLiveCardView) view.findViewById(t.g.photo_live_card);
        this.bkE = view.findViewById(t.g.make_headlines);
    }
}
