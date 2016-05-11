package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* renamed from: com.baidu.tieba.frs.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends y.a {
    public int aej;
    public TextView blh;
    public PhotoLiveCardView bli;
    public View blj;

    public Cdo(View view) {
        super(view);
        this.aej = 3;
        this.blh = (TextView) view.findViewById(t.g.more_live_list);
        this.bli = (PhotoLiveCardView) view.findViewById(t.g.photo_live_card);
        this.blj = view.findViewById(t.g.make_headlines);
    }
}
