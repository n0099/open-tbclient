package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cw extends x.a {
    TextView aPV;
    LinearLayout aVY;

    public cw(View view) {
        super(view);
        this.aVY = (LinearLayout) view.findViewById(i.f.frs_top_item);
        this.aPV = (TextView) view.findViewById(i.f.frs_top_title);
    }
}
