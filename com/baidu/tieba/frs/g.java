package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView amM;
    public TextView amP;
    public int aoR;
    public TextView cjc;
    public TextView cjd;

    public g(View view) {
        super(view);
        this.aoR = 3;
        this.amM = (TextView) getView().findViewById(d.h.frs_god_lv_reply_time);
        this.amP = (TextView) getView().findViewById(d.h.frs_god_praise_num);
        this.cjd = (TextView) getView().findViewById(d.h.frs_god_reply_num);
        this.cjc = (TextView) getView().findViewById(d.h.frs_god_item_location_address);
    }
}
