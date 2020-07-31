package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class c extends ad.a {
    public int aho;
    public TextView iLA;
    public View iLz;

    public c(View view) {
        super(view);
        this.aho = 3;
        this.iLz = null;
        this.iLA = null;
        cq(view);
    }

    private void cq(View view) {
        if (view != null) {
            this.iLz = view.findViewById(R.id.top_divider_line);
            this.iLA = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
