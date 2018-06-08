package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    LinearLayout dqc;
    TextView mTitle;

    public c(View view) {
        super(view);
        this.dqc = (LinearLayout) view.findViewById(d.g.frs_top_item);
        this.mTitle = (TextView) view.findViewById(d.g.frs_top_title);
    }
}
