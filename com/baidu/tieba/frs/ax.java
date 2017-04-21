package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ax extends y.a {
    public TextView alI;
    public TextView alL;
    public int amZ;
    public TextView bQs;
    public TextView bQt;

    public ax(View view) {
        super(view);
        this.amZ = 3;
        this.alI = (TextView) getView().findViewById(w.h.frs_god_lv_reply_time);
        this.alL = (TextView) getView().findViewById(w.h.frs_god_praise_num);
        this.bQt = (TextView) getView().findViewById(w.h.frs_god_reply_num);
        this.bQs = (TextView) getView().findViewById(w.h.frs_god_item_location_address);
    }
}
