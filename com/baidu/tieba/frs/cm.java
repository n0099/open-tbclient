package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cm extends x.a {
    View aXH;
    TextView aXI;
    View aXJ;
    TextView aXK;

    public cm(View view) {
        super(view);
        this.aXI = (TextView) view.findViewById(i.f.frs_fortune_bag_content);
        this.aXH = view.findViewById(i.f.frs_fortune_bag_item);
        this.aXJ = view.findViewById(i.f.frs_my_service_item);
        this.aXK = (TextView) view.findViewById(i.f.frs_my_service_content);
    }
}
