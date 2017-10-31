package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView amR;
    public TextView amU;
    public int api;
    public TextView cyN;
    public TextView cyO;

    public g(View view) {
        super(view);
        this.api = 3;
        this.amR = (TextView) getView().findViewById(d.g.frs_god_lv_reply_time);
        this.amU = (TextView) getView().findViewById(d.g.frs_god_praise_num);
        this.cyO = (TextView) getView().findViewById(d.g.frs_god_reply_num);
        this.cyN = (TextView) getView().findViewById(d.g.frs_god_item_location_address);
    }
}
