package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class df extends x.a {
    public int afY;
    public View bdL;
    public PhotoLiveCardView bdM;
    public View bdN;

    public df(View view) {
        super(view);
        this.afY = 3;
        this.bdL = view.findViewById(n.f.more_live_list);
        this.bdM = (PhotoLiveCardView) view.findViewById(n.f.photo_live_card);
        this.bdN = view.findViewById(n.f.make_headlines);
    }
}
