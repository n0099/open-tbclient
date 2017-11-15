package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int aph;
    public TextView cAq;
    public PhotoLiveCardView cAr;
    public View cAs;

    public o(View view) {
        super(view);
        this.aph = 3;
        this.cAq = (TextView) view.findViewById(d.g.more_live_list);
        this.cAr = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.cAs = view.findViewById(d.g.make_headlines);
    }
}
