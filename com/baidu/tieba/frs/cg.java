package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class cg extends com.baidu.adp.widget.ListView.am {
    LinearLayout aMH;
    TextView mTitle;

    public cg(View view) {
        super(view);
        this.aMH = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_top_item);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.frs_top_title);
    }
}
