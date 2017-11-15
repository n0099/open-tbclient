package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView amQ;
    public TextView amT;
    public int aph;
    public TextView czg;
    public TextView czh;

    public g(View view) {
        super(view);
        this.aph = 3;
        this.amQ = (TextView) getView().findViewById(d.g.frs_god_lv_reply_time);
        this.amT = (TextView) getView().findViewById(d.g.frs_god_praise_num);
        this.czh = (TextView) getView().findViewById(d.g.frs_god_reply_num);
        this.czg = (TextView) getView().findViewById(d.g.frs_god_item_location_address);
    }
}
