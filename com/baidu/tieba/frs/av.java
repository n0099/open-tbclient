package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class av extends y.a {
    public TextView alu;
    public TextView alx;
    public int amL;
    public TextView bOm;
    public TextView bOn;

    public av(View view) {
        super(view);
        this.amL = 3;
        this.alu = (TextView) getView().findViewById(w.h.frs_god_lv_reply_time);
        this.alx = (TextView) getView().findViewById(w.h.frs_god_praise_num);
        this.bOn = (TextView) getView().findViewById(w.h.frs_god_reply_num);
        this.bOm = (TextView) getView().findViewById(w.h.frs_god_item_location_address);
    }
}
