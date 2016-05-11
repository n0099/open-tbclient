package com.baidu.tieba.frs.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.frs.dk;
import com.baidu.tieba.frs.eg;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends y.a {
    public TextView brT;
    public LinearLayout brU;
    public TextView brV;
    public View brW;
    public dk brX;
    public eg brY;

    public e(View view) {
        super(view);
        this.brT = (TextView) view.findViewById(t.g.storecard_title);
        this.brU = (LinearLayout) view.findViewById(t.g.storecard_middle_layout);
        this.brV = (TextView) view.findViewById(t.g.storecard_all_list);
        this.brW = view.findViewById(t.g.storecard_close_click);
    }
}
