package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends x.a {
    public int ahU;
    public View bMi;
    public TextView bMj;

    public e(View view) {
        super(view);
        this.ahU = 3;
        this.bMi = null;
        this.bMj = null;
        ai(view);
    }

    private void ai(View view) {
        if (view != null) {
            this.bMi = view.findViewById(t.g.top_divider_line);
            this.bMj = (TextView) view.findViewById(t.g.item_theme_title);
        }
    }
}
