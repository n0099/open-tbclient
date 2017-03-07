package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bi extends y.a {
    public int amL;
    public TextView bPA;
    public PhotoLiveCardView bPB;
    public View bPC;

    public bi(View view) {
        super(view);
        this.amL = 3;
        this.bPA = (TextView) view.findViewById(w.h.more_live_list);
        this.bPB = (PhotoLiveCardView) view.findViewById(w.h.photo_live_card);
        this.bPC = view.findViewById(w.h.make_headlines);
    }
}
