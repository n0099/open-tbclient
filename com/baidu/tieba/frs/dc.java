package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dc extends x.a {
    View bdG;
    TextView bdH;
    View bdI;
    TextView bdJ;

    public dc(View view) {
        super(view);
        this.bdH = (TextView) view.findViewById(n.f.frs_fortune_bag_content);
        this.bdG = view.findViewById(n.f.frs_fortune_bag_item);
        this.bdI = view.findViewById(n.f.frs_my_service_item);
        this.bdJ = (TextView) view.findViewById(n.f.frs_my_service_content);
    }
}
