package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int aoZ;
    public TextView csM;
    public PhotoLiveCardView csN;
    public View csO;

    public o(View view) {
        super(view);
        this.aoZ = 3;
        this.csM = (TextView) view.findViewById(d.h.more_live_list);
        this.csN = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.csO = view.findViewById(d.h.make_headlines);
    }
}
