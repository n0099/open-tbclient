package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class eo extends x.a {
    TextView aUB;
    LinearLayout bbx;

    public eo(View view) {
        super(view);
        this.bbx = (LinearLayout) view.findViewById(n.f.frs_top_item);
        this.aUB = (TextView) view.findViewById(n.f.frs_top_title);
    }
}
