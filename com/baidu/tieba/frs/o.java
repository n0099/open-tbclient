package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int aoN;
    public TextView csA;
    public PhotoLiveCardView csB;
    public View csC;

    public o(View view) {
        super(view);
        this.aoN = 3;
        this.csA = (TextView) view.findViewById(d.h.more_live_list);
        this.csB = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.csC = view.findViewById(d.h.make_headlines);
    }
}
