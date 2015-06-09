package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.widget.ListView.am {
    View aOE;
    TextView aOF;
    View aOG;
    TextView aOH;

    public bw(View view) {
        super(view);
        this.aOF = (TextView) view.findViewById(com.baidu.tieba.q.frs_fortune_bag_content);
        this.aOE = view.findViewById(com.baidu.tieba.q.frs_fortune_bag_item);
        this.aOG = view.findViewById(com.baidu.tieba.q.frs_my_service_item);
        this.aOH = (TextView) view.findViewById(com.baidu.tieba.q.frs_my_service_content);
    }
}
