package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cc extends y.a {
    public int ait;
    public TextView bSF;
    public PhotoLiveCardView bSG;
    public View bSH;

    public cc(View view) {
        super(view);
        this.ait = 3;
        this.bSF = (TextView) view.findViewById(t.g.more_live_list);
        this.bSG = (PhotoLiveCardView) view.findViewById(t.g.photo_live_card);
        this.bSH = view.findViewById(t.g.make_headlines);
    }
}
