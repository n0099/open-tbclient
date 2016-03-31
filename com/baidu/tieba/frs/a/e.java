package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.frs.dp;
import com.baidu.tieba.frs.el;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends x.a {
    public TextView btd;
    public LinearLayout bte;
    public TextView btf;
    public View btg;
    public dp bth;
    public el bti;

    public e(View view) {
        super(view);
        this.btd = (TextView) view.findViewById(t.g.storecard_title);
        this.bte = (LinearLayout) view.findViewById(t.g.storecard_middle_layout);
        this.btf = (TextView) view.findViewById(t.g.storecard_all_list);
        this.btg = view.findViewById(t.g.storecard_close_click);
    }
}
