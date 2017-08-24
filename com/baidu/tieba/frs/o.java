package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int aqm;
    public TextView cmc;
    public PhotoLiveCardView cme;
    public View cmf;

    public o(View view) {
        super(view);
        this.aqm = 3;
        this.cmc = (TextView) view.findViewById(d.h.more_live_list);
        this.cme = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.cmf = view.findViewById(d.h.make_headlines);
    }
}
