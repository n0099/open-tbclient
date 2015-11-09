package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cp extends x.a {
    public View aXM;
    public PhotoLiveCardView aXN;
    public View aXO;

    public cp(View view) {
        super(view);
        this.aXM = view.findViewById(i.f.more_live_list);
        this.aXN = (PhotoLiveCardView) view.findViewById(i.f.photo_live_card);
        this.aXO = view.findViewById(i.f.make_headlines);
    }
}
