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
    public ce bPA;
    public cy bPB;
    public TextView bPw;
    public LinearLayout bPx;
    public TextView bPy;
    public View bPz;

    public e(View view) {
        super(view);
        this.bPw = (TextView) view.findViewById(u.g.storecard_title);
        this.bPx = (LinearLayout) view.findViewById(u.g.storecard_middle_layout);
        this.bPy = (TextView) view.findViewById(u.g.storecard_all_list);
        this.bPz = view.findViewById(u.g.storecard_close_click);
    }
}
