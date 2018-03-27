package com.baidu.tieba.frs.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends r.a {
    LinearLayout dNc;
    TextView mTitle;

    public c(View view) {
        super(view);
        this.dNc = (LinearLayout) view.findViewById(d.g.frs_top_item);
        this.mTitle = (TextView) view.findViewById(d.g.frs_top_title);
    }
}
