package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class fi extends x.a {
    TextView aSh;
    LinearLayout bmO;

    public fi(View view) {
        super(view);
        this.bmO = (LinearLayout) view.findViewById(t.g.frs_top_item);
        this.aSh = (TextView) view.findViewById(t.g.frs_top_title);
    }
}
