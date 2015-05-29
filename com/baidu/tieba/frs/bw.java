package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.widget.ListView.am {
    View aOD;
    TextView aOE;
    View aOF;
    TextView aOG;

    public bw(View view) {
        super(view);
        this.aOE = (TextView) view.findViewById(com.baidu.tieba.q.frs_fortune_bag_content);
        this.aOD = view.findViewById(com.baidu.tieba.q.frs_fortune_bag_item);
        this.aOF = view.findViewById(com.baidu.tieba.q.frs_my_service_item);
        this.aOG = (TextView) view.findViewById(com.baidu.tieba.q.frs_my_service_content);
    }
}
