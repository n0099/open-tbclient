package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class as extends y.a {
    public TextView ahw;
    public TextView ahz;
    public int aiA;
    public TextView bTt;
    public TextView bTu;

    public as(View view) {
        super(view);
        this.aiA = 3;
        this.ahw = (TextView) getView().findViewById(r.g.frs_god_lv_reply_time);
        this.ahz = (TextView) getView().findViewById(r.g.frs_god_praise_num);
        this.bTu = (TextView) getView().findViewById(r.g.frs_god_reply_num);
        this.bTt = (TextView) getView().findViewById(r.g.frs_god_item_location_address);
    }
}
