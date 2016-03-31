package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cl extends x.a {
    public TextView ahr;
    public TextView ahs;
    public int aik;
    public TextView bjK;
    public TextView bnF;

    public cl(View view) {
        super(view);
        this.aik = 3;
        this.ahr = (TextView) getView().findViewById(t.g.frs_god_lv_reply_time);
        this.ahs = (TextView) getView().findViewById(t.g.frs_god_praise_num);
        this.bjK = (TextView) getView().findViewById(t.g.frs_god_reply_num);
        this.bnF = (TextView) getView().findViewById(t.g.frs_god_item_location_address);
    }
}
