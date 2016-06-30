package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cg extends y.a {
    public int aeK;
    public TextView bGd;
    public PhotoLiveCardView bGe;
    public View bGf;

    public cg(View view) {
        super(view);
        this.aeK = 3;
        this.bGd = (TextView) view.findViewById(u.g.more_live_list);
        this.bGe = (PhotoLiveCardView) view.findViewById(u.g.photo_live_card);
        this.bGf = view.findViewById(u.g.make_headlines);
    }
}
