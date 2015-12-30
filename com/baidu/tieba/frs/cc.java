package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cc extends x.a {
    public TextView agy;
    public TextView agz;
    public int ahf;
    public TextView bcG;
    public TextView bgj;
    public View bgk;

    public cc(View view) {
        super(view);
        this.ahf = 3;
        this.agy = (TextView) getView().findViewById(n.g.frs_god_lv_reply_time);
        this.agz = (TextView) getView().findViewById(n.g.frs_god_praise_num);
        this.bcG = (TextView) getView().findViewById(n.g.frs_god_reply_num);
        this.bgj = (TextView) getView().findViewById(n.g.frs_god_item_location_address);
        this.bgk = getView().findViewById(n.g.frs_god_item_location_sep);
    }
}
