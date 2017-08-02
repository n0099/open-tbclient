package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends j.a {
    public int aoR;
    public TextView cki;
    public PhotoLiveCardView ckj;
    public View ckk;

    public o(View view) {
        super(view);
        this.aoR = 3;
        this.cki = (TextView) view.findViewById(d.h.more_live_list);
        this.ckj = (PhotoLiveCardView) view.findViewById(d.h.photo_live_card);
        this.ckk = view.findViewById(d.h.make_headlines);
    }
}
