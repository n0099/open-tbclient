package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class at extends z.a {
    public TextView ami;
    public TextView aml;
    public int aoa;
    public TextView cdr;
    public TextView cds;

    public at(View view) {
        super(view);
        this.aoa = 3;
        this.ami = (TextView) getView().findViewById(w.h.frs_god_lv_reply_time);
        this.aml = (TextView) getView().findViewById(w.h.frs_god_praise_num);
        this.cds = (TextView) getView().findViewById(w.h.frs_god_reply_num);
        this.cdr = (TextView) getView().findViewById(w.h.frs_god_item_location_address);
    }
}
