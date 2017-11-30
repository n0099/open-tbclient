package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView anm;
    public TextView ann;
    public int apA;
    public TextView cIl;
    public TextView cIm;

    public g(View view) {
        super(view);
        this.apA = 3;
        this.anm = (TextView) getView().findViewById(d.g.frs_god_lv_reply_time);
        this.ann = (TextView) getView().findViewById(d.g.frs_god_praise_num);
        this.cIm = (TextView) getView().findViewById(d.g.frs_god_reply_num);
        this.cIl = (TextView) getView().findViewById(d.g.frs_god_item_location_address);
    }
}
