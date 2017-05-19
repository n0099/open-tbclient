package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ar extends y.a {
    public TextView alE;
    public TextView alH;
    public int ane;
    public TextView bPs;
    public TextView bPt;

    public ar(View view) {
        super(view);
        this.ane = 3;
        this.alE = (TextView) getView().findViewById(w.h.frs_god_lv_reply_time);
        this.alH = (TextView) getView().findViewById(w.h.frs_god_praise_num);
        this.bPt = (TextView) getView().findViewById(w.h.frs_god_reply_num);
        this.bPs = (TextView) getView().findViewById(w.h.frs_god_item_location_address);
    }
}
