package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bx extends com.baidu.adp.widget.ListView.am {
    View aMi;
    TextView aMj;
    View aMk;
    TextView aMl;

    public bx(View view) {
        super(view);
        this.aMj = (TextView) view.findViewById(com.baidu.tieba.v.frs_fortune_bag_content);
        this.aMi = view.findViewById(com.baidu.tieba.v.frs_fortune_bag_item);
        this.aMk = view.findViewById(com.baidu.tieba.v.frs_my_service_item);
        this.aMl = (TextView) view.findViewById(com.baidu.tieba.v.frs_my_service_content);
    }
}
