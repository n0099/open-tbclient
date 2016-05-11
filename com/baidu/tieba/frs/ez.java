package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ez extends y.a {
    TextView aOG;
    LinearLayout bin;

    public ez(View view) {
        super(view);
        this.bin = (LinearLayout) view.findViewById(t.g.frs_top_item);
        this.aOG = (TextView) view.findViewById(t.g.frs_top_title);
    }
}
