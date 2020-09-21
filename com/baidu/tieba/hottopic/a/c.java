package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class c extends af.a {
    public int aiX;
    public View jjl;
    public TextView jjm;

    public c(View view) {
        super(view);
        this.aiX = 3;
        this.jjl = null;
        this.jjm = null;
        cC(view);
    }

    private void cC(View view) {
        if (view != null) {
            this.jjl = view.findViewById(R.id.top_divider_line);
            this.jjm = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
