package com.baidu.tieba.frs.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.cu;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends y.a {
    public cu ccA;
    public TextView ccv;
    public LinearLayout ccw;
    public TextView ccx;
    public View ccy;
    public ca ccz;

    public e(View view) {
        super(view);
        this.ccv = (TextView) view.findViewById(r.g.storecard_title);
        this.ccw = (LinearLayout) view.findViewById(r.g.storecard_middle_layout);
        this.ccx = (TextView) view.findViewById(r.g.storecard_all_list);
        this.ccy = view.findViewById(r.g.storecard_close_click);
    }
}
