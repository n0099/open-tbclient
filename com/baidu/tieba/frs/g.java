package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView amw;
    public TextView amz;
    public int aoN;
    public TextView crs;
    public TextView crt;

    public g(View view) {
        super(view);
        this.aoN = 3;
        this.amw = (TextView) getView().findViewById(d.h.frs_god_lv_reply_time);
        this.amz = (TextView) getView().findViewById(d.h.frs_god_praise_num);
        this.crt = (TextView) getView().findViewById(d.h.frs_god_reply_num);
        this.crs = (TextView) getView().findViewById(d.h.frs_god_item_location_address);
    }
}
