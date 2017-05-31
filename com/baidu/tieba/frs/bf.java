package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bf extends z.a {
    public int ana;
    public TextView bWo;
    public PhotoLiveCardView bWp;
    public View bWq;

    public bf(View view) {
        super(view);
        this.ana = 3;
        this.bWo = (TextView) view.findViewById(w.h.more_live_list);
        this.bWp = (PhotoLiveCardView) view.findViewById(w.h.photo_live_card);
        this.bWq = view.findViewById(w.h.make_headlines);
    }
}
