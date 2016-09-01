package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bk extends y.a {
    public TextView ahn;
    public TextView ahq;
    public int ait;
    public TextView bRi;
    public TextView bRj;

    public bk(View view) {
        super(view);
        this.ait = 3;
        this.ahn = (TextView) getView().findViewById(t.g.frs_god_lv_reply_time);
        this.ahq = (TextView) getView().findViewById(t.g.frs_god_praise_num);
        this.bRj = (TextView) getView().findViewById(t.g.frs_god_reply_num);
        this.bRi = (TextView) getView().findViewById(t.g.frs_god_item_location_address);
    }
}
