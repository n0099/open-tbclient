package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class c extends af.a {
    public int ajv;
    public View jRq;
    public TextView jRr;

    public c(View view) {
        super(view);
        this.ajv = 3;
        this.jRq = null;
        this.jRr = null;
        cU(view);
    }

    private void cU(View view) {
        if (view != null) {
            this.jRq = view.findViewById(R.id.top_divider_line);
            this.jRr = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
