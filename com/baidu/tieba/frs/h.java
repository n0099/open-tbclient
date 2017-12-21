package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends j.a {
    public TextView anm;
    public TextView ann;
    public int apG;
    public TextView cIy;
    public TextView cIz;

    public h(View view) {
        super(view);
        this.apG = 3;
        this.anm = (TextView) getView().findViewById(d.g.frs_god_lv_reply_time);
        this.ann = (TextView) getView().findViewById(d.g.frs_god_praise_num);
        this.cIz = (TextView) getView().findViewById(d.g.frs_god_reply_num);
        this.cIy = (TextView) getView().findViewById(d.g.frs_god_item_location_address);
    }
}
