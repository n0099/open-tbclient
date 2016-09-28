package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bk extends y.a {
    public TextView agW;
    public TextView agZ;
    public int ahV;
    public TextView bRb;
    public TextView bRc;

    public bk(View view) {
        super(view);
        this.ahV = 3;
        this.agW = (TextView) getView().findViewById(r.g.frs_god_lv_reply_time);
        this.agZ = (TextView) getView().findViewById(r.g.frs_god_praise_num);
        this.bRc = (TextView) getView().findViewById(r.g.frs_god_reply_num);
        this.bRb = (TextView) getView().findViewById(r.g.frs_god_item_location_address);
    }
}
