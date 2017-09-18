package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int apQ;
    public TextView csp;
    public PhotoLiveCardView csq;
    public View csr;

    public o(View view) {
        super(view);
        this.apQ = 3;
        this.csp = (TextView) view.findViewById(d.h.more_live_list);
        this.csq = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.csr = view.findViewById(d.h.make_headlines);
    }
}
