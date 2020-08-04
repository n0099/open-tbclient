package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class c extends ad.a {
    public int aho;
    public View iLB;
    public TextView iLC;

    public c(View view) {
        super(view);
        this.aho = 3;
        this.iLB = null;
        this.iLC = null;
        cq(view);
    }

    private void cq(View view) {
        if (view != null) {
            this.iLB = view.findViewById(R.id.top_divider_line);
            this.iLC = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
