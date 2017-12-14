package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends j.a {
    public TextView anj;
    public TextView ank;
    public int apD;
    public TextView cIu;
    public TextView cIv;

    public h(View view) {
        super(view);
        this.apD = 3;
        this.anj = (TextView) getView().findViewById(d.g.frs_god_lv_reply_time);
        this.ank = (TextView) getView().findViewById(d.g.frs_god_praise_num);
        this.cIv = (TextView) getView().findViewById(d.g.frs_god_reply_num);
        this.cIu = (TextView) getView().findViewById(d.g.frs_god_item_location_address);
    }
}
