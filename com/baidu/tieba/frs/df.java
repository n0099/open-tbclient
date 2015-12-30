package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class df extends x.a {
    View bhF;
    TextView bhG;
    View bhH;
    TextView bhI;

    public df(View view) {
        super(view);
        this.bhG = (TextView) view.findViewById(n.g.frs_fortune_bag_content);
        this.bhF = view.findViewById(n.g.frs_fortune_bag_item);
        this.bhH = view.findViewById(n.g.frs_my_service_item);
        this.bhI = (TextView) view.findViewById(n.g.frs_my_service_content);
    }
}
