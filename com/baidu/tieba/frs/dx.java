package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dx extends x.a {
    TextView aPy;
    LinearLayout aWh;

    public dx(View view) {
        super(view);
        this.aWh = (LinearLayout) view.findViewById(i.f.frs_top_item);
        this.aPy = (TextView) view.findViewById(i.f.frs_top_title);
    }
}
