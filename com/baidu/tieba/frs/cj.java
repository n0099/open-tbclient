package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cj extends x.a {
    public int ahU;
    public TextView ahm;
    public TextView ahn;
    public TextView beY;
    public TextView biV;

    public cj(View view) {
        super(view);
        this.ahU = 3;
        this.ahm = (TextView) getView().findViewById(t.g.frs_god_lv_reply_time);
        this.ahn = (TextView) getView().findViewById(t.g.frs_god_praise_num);
        this.beY = (TextView) getView().findViewById(t.g.frs_god_reply_num);
        this.biV = (TextView) getView().findViewById(t.g.frs_god_item_location_address);
    }
}
