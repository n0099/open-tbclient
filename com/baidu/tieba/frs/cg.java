package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cg extends x.a {
    View aXY;
    TextView aXZ;
    View aYa;
    TextView aYb;

    public cg(View view) {
        super(view);
        this.aXZ = (TextView) view.findViewById(i.f.frs_fortune_bag_content);
        this.aXY = view.findViewById(i.f.frs_fortune_bag_item);
        this.aYa = view.findViewById(i.f.frs_my_service_item);
        this.aYb = (TextView) view.findViewById(i.f.frs_my_service_content);
    }
}
