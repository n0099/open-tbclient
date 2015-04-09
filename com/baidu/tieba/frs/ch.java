package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.widget.ListView.am {
    LinearLayout aKA;
    TextView mTitle;

    public ch(View view) {
        super(view);
        this.aKA = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_top_item);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.frs_top_title);
    }
}
