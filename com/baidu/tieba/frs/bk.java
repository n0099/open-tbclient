package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bk extends y.a {
    public int amZ;
    public TextView bPp;
    public PhotoLiveCardView bPq;
    public View bPr;

    public bk(View view) {
        super(view);
        this.amZ = 3;
        this.bPp = (TextView) view.findViewById(w.h.more_live_list);
        this.bPq = (PhotoLiveCardView) view.findViewById(w.h.photo_live_card);
        this.bPr = view.findViewById(w.h.make_headlines);
    }
}
