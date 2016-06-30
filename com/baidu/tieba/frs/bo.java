package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bo extends y.a {
    public TextView adE;
    public TextView adH;
    public int aeK;
    public TextView bBW;
    public TextView bEN;

    public bo(View view) {
        super(view);
        this.aeK = 3;
        this.adE = (TextView) getView().findViewById(u.g.frs_god_lv_reply_time);
        this.adH = (TextView) getView().findViewById(u.g.frs_god_praise_num);
        this.bBW = (TextView) getView().findViewById(u.g.frs_god_reply_num);
        this.bEN = (TextView) getView().findViewById(u.g.frs_god_item_location_address);
    }
}
