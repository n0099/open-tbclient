package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends ad.a {
    public int ahx;
    public View iFv;
    public TextView iFw;

    public c(View view) {
        super(view);
        this.ahx = 3;
        this.iFv = null;
        this.iFw = null;
        ck(view);
    }

    private void ck(View view) {
        if (view != null) {
            this.iFv = view.findViewById(R.id.top_divider_line);
            this.iFw = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
