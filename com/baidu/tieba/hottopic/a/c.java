package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class c extends af.a {
    public int aiB;
    public TextView jaA;
    public View jaz;

    public c(View view) {
        super(view);
        this.aiB = 3;
        this.jaz = null;
        this.jaA = null;
        ct(view);
    }

    private void ct(View view) {
        if (view != null) {
            this.jaz = view.findViewById(R.id.top_divider_line);
            this.jaA = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
