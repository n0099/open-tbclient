package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dv extends x.a {
    TextView aPf;
    LinearLayout aVO;

    public dv(View view) {
        super(view);
        this.aVO = (LinearLayout) view.findViewById(i.f.frs_top_item);
        this.aPf = (TextView) view.findViewById(i.f.frs_top_title);
    }
}
