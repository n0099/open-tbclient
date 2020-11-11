package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends af.a {
    public int ajq;
    public View jQG;
    public TextView jQH;

    public c(View view) {
        super(view);
        this.ajq = 3;
        this.jQG = null;
        this.jQH = null;
        cP(view);
    }

    private void cP(View view) {
        if (view != null) {
            this.jQG = view.findViewById(R.id.top_divider_line);
            this.jQH = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
