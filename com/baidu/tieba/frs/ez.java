package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ez extends x.a {
    TextView aPr;
    LinearLayout bib;

    public ez(View view) {
        super(view);
        this.bib = (LinearLayout) view.findViewById(t.g.frs_top_item);
        this.aPr = (TextView) view.findViewById(t.g.frs_top_title);
    }
}
