package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class aw extends y.a {
    public TextView agP;
    public TextView agS;
    public int aib;
    public TextView bzE;
    public TextView bzF;

    public aw(View view) {
        super(view);
        this.aib = 3;
        this.agP = (TextView) getView().findViewById(r.g.frs_god_lv_reply_time);
        this.agS = (TextView) getView().findViewById(r.g.frs_god_praise_num);
        this.bzF = (TextView) getView().findViewById(r.g.frs_god_reply_num);
        this.bzE = (TextView) getView().findViewById(r.g.frs_god_item_location_address);
    }
}
