package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class as extends z.a {
    public TextView alu;
    public TextView alx;
    public int ana;
    public TextView bVi;
    public TextView bVj;

    public as(View view) {
        super(view);
        this.ana = 3;
        this.alu = (TextView) getView().findViewById(w.h.frs_god_lv_reply_time);
        this.alx = (TextView) getView().findViewById(w.h.frs_god_praise_num);
        this.bVj = (TextView) getView().findViewById(w.h.frs_god_reply_num);
        this.bVi = (TextView) getView().findViewById(w.h.frs_god_item_location_address);
    }
}
