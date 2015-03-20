package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.widget.ListView.am {
    LinearLayout aKq;
    TextView mTitle;

    public ch(View view) {
        super(view);
        this.aKq = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_top_item);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.frs_top_title);
    }
}
