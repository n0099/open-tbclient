package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dt extends x.a {
    public int aik;
    public TextView bpR;
    public PhotoLiveCardView bpS;
    public View bpT;

    public dt(View view) {
        super(view);
        this.aik = 3;
        this.bpR = (TextView) view.findViewById(t.g.more_live_list);
        this.bpS = (PhotoLiveCardView) view.findViewById(t.g.photo_live_card);
        this.bpT = view.findViewById(t.g.make_headlines);
    }
}
