package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cm extends x.a {
    View aXn;
    TextView aXo;
    View aXp;
    TextView aXq;

    public cm(View view) {
        super(view);
        this.aXo = (TextView) view.findViewById(i.f.frs_fortune_bag_content);
        this.aXn = view.findViewById(i.f.frs_fortune_bag_item);
        this.aXp = view.findViewById(i.f.frs_my_service_item);
        this.aXq = (TextView) view.findViewById(i.f.frs_my_service_content);
    }
}
