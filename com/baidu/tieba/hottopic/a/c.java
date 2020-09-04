package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class c extends af.a {
    public int aiD;
    public View jaF;
    public TextView jaG;

    public c(View view) {
        super(view);
        this.aiD = 3;
        this.jaF = null;
        this.jaG = null;
        ct(view);
    }

    private void ct(View view) {
        if (view != null) {
            this.jaF = view.findViewById(R.id.top_divider_line);
            this.jaG = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
