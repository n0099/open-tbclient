package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ck extends y.a {
    public TextView adg;
    public TextView adj;
    public int aej;
    public TextView bfK;
    public TextView bji;

    public ck(View view) {
        super(view);
        this.aej = 3;
        this.adg = (TextView) getView().findViewById(t.g.frs_god_lv_reply_time);
        this.adj = (TextView) getView().findViewById(t.g.frs_god_praise_num);
        this.bfK = (TextView) getView().findViewById(t.g.frs_god_reply_num);
        this.bji = (TextView) getView().findViewById(t.g.frs_god_item_location_address);
    }
}
