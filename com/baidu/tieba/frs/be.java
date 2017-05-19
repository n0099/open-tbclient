package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class be extends y.a {
    public int ane;
    public TextView bQx;
    public PhotoLiveCardView bQy;
    public View bQz;

    public be(View view) {
        super(view);
        this.ane = 3;
        this.bQx = (TextView) view.findViewById(w.h.more_live_list);
        this.bQy = (PhotoLiveCardView) view.findViewById(w.h.photo_live_card);
        this.bQz = view.findViewById(w.h.make_headlines);
    }
}
