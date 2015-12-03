package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bz extends x.a {
    public TextView aYC;
    public TextView aYI;
    public TextView aYK;
    public int afY;
    public TextView bck;
    public View bcl;

    public bz(View view) {
        super(view);
        this.afY = 3;
        this.aYC = (TextView) getView().findViewById(n.f.frs_god_lv_reply_time);
        this.aYI = (TextView) getView().findViewById(n.f.frs_god_praise_num);
        this.aYK = (TextView) getView().findViewById(n.f.frs_god_reply_num);
        this.bck = (TextView) getView().findViewById(n.f.frs_god_item_location_address);
        this.bcl = getView().findViewById(n.f.frs_god_item_location_sep);
    }
}
