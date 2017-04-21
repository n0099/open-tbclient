package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bk extends y.a {
    public int amZ;
    public TextView bRG;
    public PhotoLiveCardView bRH;
    public View bRI;

    public bk(View view) {
        super(view);
        this.amZ = 3;
        this.bRG = (TextView) view.findViewById(w.h.more_live_list);
        this.bRH = (PhotoLiveCardView) view.findViewById(w.h.photo_live_card);
        this.bRI = view.findViewById(w.h.make_headlines);
    }
}
