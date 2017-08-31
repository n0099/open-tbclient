package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView anA;
    public TextView anD;
    public int apS;
    public TextView cqp;
    public TextView cqq;

    public g(View view) {
        super(view);
        this.apS = 3;
        this.anA = (TextView) getView().findViewById(d.h.frs_god_lv_reply_time);
        this.anD = (TextView) getView().findViewById(d.h.frs_god_praise_num);
        this.cqq = (TextView) getView().findViewById(d.h.frs_god_reply_num);
        this.cqp = (TextView) getView().findViewById(d.h.frs_god_item_location_address);
    }
}
