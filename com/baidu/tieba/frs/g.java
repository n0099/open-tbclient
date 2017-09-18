package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView anB;
    public TextView any;
    public int apQ;
    public TextView cri;
    public TextView crj;

    public g(View view) {
        super(view);
        this.apQ = 3;
        this.any = (TextView) getView().findViewById(d.h.frs_god_lv_reply_time);
        this.anB = (TextView) getView().findViewById(d.h.frs_god_praise_num);
        this.crj = (TextView) getView().findViewById(d.h.frs_god_reply_num);
        this.cri = (TextView) getView().findViewById(d.h.frs_god_item_location_address);
    }
}
