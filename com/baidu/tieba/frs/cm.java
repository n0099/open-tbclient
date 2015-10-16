package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cm extends x.a {
    View aXA;
    TextView aXB;
    View aXy;
    TextView aXz;

    public cm(View view) {
        super(view);
        this.aXz = (TextView) view.findViewById(i.f.frs_fortune_bag_content);
        this.aXy = view.findViewById(i.f.frs_fortune_bag_item);
        this.aXA = view.findViewById(i.f.frs_my_service_item);
        this.aXB = (TextView) view.findViewById(i.f.frs_my_service_content);
    }
}
