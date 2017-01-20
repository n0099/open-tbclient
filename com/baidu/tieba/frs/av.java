package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class av extends y.a {
    public TextView agb;
    public TextView agf;
    public int ahp;
    public TextView bHd;
    public TextView bHe;

    public av(View view) {
        super(view);
        this.ahp = 3;
        this.agb = (TextView) getView().findViewById(r.h.frs_god_lv_reply_time);
        this.agf = (TextView) getView().findViewById(r.h.frs_god_praise_num);
        this.bHe = (TextView) getView().findViewById(r.h.frs_god_reply_num);
        this.bHd = (TextView) getView().findViewById(r.h.frs_god_item_location_address);
    }
}
