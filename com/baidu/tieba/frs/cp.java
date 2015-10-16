package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cp extends x.a {
    public View aXD;
    public PhotoLiveCardView aXE;
    public View aXF;

    public cp(View view) {
        super(view);
        this.aXD = view.findViewById(i.f.more_live_list);
        this.aXE = (PhotoLiveCardView) view.findViewById(i.f.photo_live_card);
        this.aXF = view.findViewById(i.f.make_headlines);
    }
}
