package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cf extends x.a {
    public View aXY;
    public PhotoLiveCardView aXZ;
    public View aYa;

    public cf(View view) {
        super(view);
        this.aXY = view.findViewById(i.f.more_live_list);
        this.aXZ = (PhotoLiveCardView) view.findViewById(i.f.photo_live_card);
        this.aYa = view.findViewById(i.f.make_headlines);
    }
}
