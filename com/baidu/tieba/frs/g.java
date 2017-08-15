package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView aog;
    public TextView aoj;
    public int aqm;
    public TextView ckV;
    public TextView ckW;

    public g(View view) {
        super(view);
        this.aqm = 3;
        this.aog = (TextView) getView().findViewById(d.h.frs_god_lv_reply_time);
        this.aoj = (TextView) getView().findViewById(d.h.frs_god_praise_num);
        this.ckW = (TextView) getView().findViewById(d.h.frs_god_reply_num);
        this.ckV = (TextView) getView().findViewById(d.h.frs_god_item_location_address);
    }
}
