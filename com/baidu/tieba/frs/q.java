package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public int bdK;
    public TextView dDs;
    public PhotoLiveCardView dDt;
    public View dDu;

    public q(View view) {
        super(view);
        this.bdK = 3;
        this.dDs = (TextView) view.findViewById(d.g.more_live_list);
        this.dDt = (PhotoLiveCardView) view.findViewById(d.g.photo_live_card);
        this.dDu = view.findViewById(d.g.make_headlines);
    }
}
