package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView amI;
    public TextView amL;
    public int aoZ;
    public TextView crE;
    public TextView crF;

    public g(View view) {
        super(view);
        this.aoZ = 3;
        this.amI = (TextView) getView().findViewById(d.h.frs_god_lv_reply_time);
        this.amL = (TextView) getView().findViewById(d.h.frs_god_praise_num);
        this.crF = (TextView) getView().findViewById(d.h.frs_god_reply_num);
        this.crE = (TextView) getView().findViewById(d.h.frs_god_item_location_address);
    }
}
