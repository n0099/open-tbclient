package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class eo extends x.a {
    TextView aOn;
    LinearLayout bfw;

    public eo(View view) {
        super(view);
        this.bfw = (LinearLayout) view.findViewById(n.g.frs_top_item);
        this.aOn = (TextView) view.findViewById(n.g.frs_top_title);
    }
}
