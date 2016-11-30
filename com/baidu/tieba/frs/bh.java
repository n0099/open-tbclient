package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bh extends y.a {
    public int aiA;
    public TextView bUL;
    public PhotoLiveCardView bUM;
    public View bUN;

    public bh(View view) {
        super(view);
        this.aiA = 3;
        this.bUL = (TextView) view.findViewById(r.g.more_live_list);
        this.bUM = (PhotoLiveCardView) view.findViewById(r.g.photo_live_card);
        this.bUN = view.findViewById(r.g.make_headlines);
    }
}
