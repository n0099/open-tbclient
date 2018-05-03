package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    LinearLayout dfG;
    TextView mTitle;

    public c(View view2) {
        super(view2);
        this.dfG = (LinearLayout) view2.findViewById(d.g.frs_top_item);
        this.mTitle = (TextView) view2.findViewById(d.g.frs_top_title);
    }
}
