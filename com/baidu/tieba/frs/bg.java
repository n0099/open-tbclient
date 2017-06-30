package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bg extends z.a {
    public int aoa;
    public TextView cew;
    public PhotoLiveCardView cex;
    public View cey;

    public bg(View view) {
        super(view);
        this.aoa = 3;
        this.cew = (TextView) view.findViewById(w.h.more_live_list);
        this.cex = (PhotoLiveCardView) view.findViewById(w.h.photo_live_card);
        this.cey = view.findViewById(w.h.make_headlines);
    }
}
