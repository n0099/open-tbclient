package com.baidu.tieba.frs.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends y.a {
    public TextView bRj;
    public LinearLayout bRk;
    public TextView bRl;
    public View bRm;
    public ce bRn;
    public cy bRo;

    public e(View view) {
        super(view);
        this.bRj = (TextView) view.findViewById(u.g.storecard_title);
        this.bRk = (LinearLayout) view.findViewById(u.g.storecard_middle_layout);
        this.bRl = (TextView) view.findViewById(u.g.storecard_all_list);
        this.bRm = view.findViewById(u.g.storecard_close_click);
    }
}
