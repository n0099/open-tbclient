package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bo extends y.a {
    public TextView aes;
    public TextView aev;
    public int afy;
    public TextView bGa;
    public TextView bGb;

    public bo(View view) {
        super(view);
        this.afy = 3;
        this.aes = (TextView) getView().findViewById(u.g.frs_god_lv_reply_time);
        this.aev = (TextView) getView().findViewById(u.g.frs_god_praise_num);
        this.bGb = (TextView) getView().findViewById(u.g.frs_god_reply_num);
        this.bGa = (TextView) getView().findViewById(u.g.frs_god_item_location_address);
    }
}
