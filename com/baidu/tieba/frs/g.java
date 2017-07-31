package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends j.a {
    public TextView aof;
    public TextView aoi;
    public int aql;
    public TextView ckj;
    public TextView ckk;

    public g(View view) {
        super(view);
        this.aql = 3;
        this.aof = (TextView) getView().findViewById(d.h.frs_god_lv_reply_time);
        this.aoi = (TextView) getView().findViewById(d.h.frs_god_praise_num);
        this.ckk = (TextView) getView().findViewById(d.h.frs_god_reply_num);
        this.ckj = (TextView) getView().findViewById(d.h.frs_god_item_location_address);
    }
}
