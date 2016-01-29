package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dk extends x.a {
    TextView bkA;
    View bkx;
    TextView bky;
    View bkz;

    public dk(View view) {
        super(view);
        this.bky = (TextView) view.findViewById(t.g.frs_fortune_bag_content);
        this.bkx = view.findViewById(t.g.frs_fortune_bag_item);
        this.bkz = view.findViewById(t.g.frs_my_service_item);
        this.bkA = (TextView) view.findViewById(t.g.frs_my_service_content);
    }
}
