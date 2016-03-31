package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dq extends x.a {
    View bpM;
    TextView bpN;
    View bpO;
    TextView bpP;

    public dq(View view) {
        super(view);
        this.bpN = (TextView) view.findViewById(t.g.frs_fortune_bag_content);
        this.bpM = view.findViewById(t.g.frs_fortune_bag_item);
        this.bpO = view.findViewById(t.g.frs_my_service_item);
        this.bpP = (TextView) view.findViewById(t.g.frs_my_service_content);
    }
}
