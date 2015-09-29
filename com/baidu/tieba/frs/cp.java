package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cp extends x.a {
    public View aXs;
    public PhotoLiveCardView aXt;
    public View aXu;

    public cp(View view) {
        super(view);
        this.aXs = view.findViewById(i.f.more_live_list);
        this.aXt = (PhotoLiveCardView) view.findViewById(i.f.photo_live_card);
        this.aXu = view.findViewById(i.f.make_headlines);
    }
}
