package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bx extends com.baidu.adp.widget.ListView.am {
    View aMt;
    TextView aMu;
    View aMv;
    TextView aMw;

    public bx(View view) {
        super(view);
        this.aMu = (TextView) view.findViewById(com.baidu.tieba.v.frs_fortune_bag_content);
        this.aMt = view.findViewById(com.baidu.tieba.v.frs_fortune_bag_item);
        this.aMv = view.findViewById(com.baidu.tieba.v.frs_my_service_item);
        this.aMw = (TextView) view.findViewById(com.baidu.tieba.v.frs_my_service_content);
    }
}
