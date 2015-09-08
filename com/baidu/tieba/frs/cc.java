package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cc extends x.a {
    View aXT;
    TextView aXU;
    View aXV;
    TextView aXW;

    public cc(View view) {
        super(view);
        this.aXU = (TextView) view.findViewById(i.f.frs_fortune_bag_content);
        this.aXT = view.findViewById(i.f.frs_fortune_bag_item);
        this.aXV = view.findViewById(i.f.frs_my_service_item);
        this.aXW = (TextView) view.findViewById(i.f.frs_my_service_content);
    }
}
