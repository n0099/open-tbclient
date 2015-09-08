package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dc extends x.a {
    TextView aQj;
    LinearLayout aWp;

    public dc(View view) {
        super(view);
        this.aWp = (LinearLayout) view.findViewById(i.f.frs_top_item);
        this.aQj = (TextView) view.findViewById(i.f.frs_top_title);
    }
}
