package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends x.a {
    public TextView bog;
    public LinearLayout boh;
    public TextView boi;
    public View boj;
    public dj bok;
    public ed bol;

    public e(View view) {
        super(view);
        this.bog = (TextView) view.findViewById(t.g.storecard_title);
        this.boh = (LinearLayout) view.findViewById(t.g.storecard_middle_layout);
        this.boi = (TextView) view.findViewById(t.g.storecard_all_list);
        this.boj = view.findViewById(t.g.storecard_close_click);
    }
}
