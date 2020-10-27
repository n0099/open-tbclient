package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends af.a {
    public int ajq;
    public View jKI;
    public TextView jKJ;

    public c(View view) {
        super(view);
        this.ajq = 3;
        this.jKI = null;
        this.jKJ = null;
        cK(view);
    }

    private void cK(View view) {
        if (view != null) {
            this.jKI = view.findViewById(R.id.top_divider_line);
            this.jKJ = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
