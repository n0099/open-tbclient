package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dl extends y.a {
    View biH;
    View blc;
    TextView bld;
    View ble;
    TextView blf;

    public dl(View view) {
        super(view);
        this.bld = (TextView) view.findViewById(t.g.frs_fortune_bag_content);
        this.blc = view.findViewById(t.g.frs_fortune_bag_item);
        this.ble = view.findViewById(t.g.frs_my_service_item);
        this.blf = (TextView) view.findViewById(t.g.frs_my_service_content);
        this.biH = view.findViewById(t.g.frs_list_item_official_buttom_line);
    }
}
