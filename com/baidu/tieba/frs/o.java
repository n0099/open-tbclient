package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int aql;
    public TextView clq;
    public PhotoLiveCardView clr;
    public View cls;

    public o(View view) {
        super(view);
        this.aql = 3;
        this.clq = (TextView) view.findViewById(d.h.more_live_list);
        this.clr = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.cls = view.findViewById(d.h.make_headlines);
    }
}
