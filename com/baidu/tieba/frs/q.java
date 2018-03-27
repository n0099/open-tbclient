package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public int bfC;
    public TextView dGJ;
    public PhotoLiveCardView dGK;
    public View dGL;

    public q(View view) {
        super(view);
        this.bfC = 3;
        this.dGJ = (TextView) view.findViewById(d.g.more_live_list);
        this.dGK = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.dGL = view.findViewById(d.g.make_headlines);
    }
}
