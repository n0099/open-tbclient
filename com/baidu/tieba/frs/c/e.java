package com.baidu.tieba.frs.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends y.a {
    public TextView bLB;
    public LinearLayout bLC;
    public TextView bLD;
    public View bLE;
    public bi bLF;
    public br bLG;

    public e(View view) {
        super(view);
        this.bLB = (TextView) view.findViewById(r.g.storecard_title);
        this.bLC = (LinearLayout) view.findViewById(r.g.storecard_middle_layout);
        this.bLD = (TextView) view.findViewById(r.g.storecard_all_list);
        this.bLE = view.findViewById(r.g.storecard_close_click);
    }
}
