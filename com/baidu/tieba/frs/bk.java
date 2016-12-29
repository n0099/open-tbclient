package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bk extends y.a {
    public int aib;
    public TextView bAX;
    public PhotoLiveCardView bAY;
    public View bAZ;

    public bk(View view) {
        super(view);
        this.aib = 3;
        this.bAX = (TextView) view.findViewById(r.g.more_live_list);
        this.bAY = (PhotoLiveCardView) view.findViewById(r.g.photo_live_card);
        this.bAZ = view.findViewById(r.g.make_headlines);
    }
}
