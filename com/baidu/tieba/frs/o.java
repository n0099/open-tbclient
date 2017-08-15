package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int aqm;
    public TextView cmb;
    public PhotoLiveCardView cmc;
    public View cme;

    public o(View view) {
        super(view);
        this.aqm = 3;
        this.cmb = (TextView) view.findViewById(d.h.more_live_list);
        this.cmc = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.cme = view.findViewById(d.h.make_headlines);
    }
}
