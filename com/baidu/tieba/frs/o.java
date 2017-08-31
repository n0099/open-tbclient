package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int apS;
    public TextView crx;
    public PhotoLiveCardView cry;
    public View crz;

    public o(View view) {
        super(view);
        this.apS = 3;
        this.crx = (TextView) view.findViewById(d.h.more_live_list);
        this.cry = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.crz = view.findViewById(d.h.make_headlines);
    }
}
