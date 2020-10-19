package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends af.a {
    public int ajp;
    public View jyj;
    public TextView jyk;

    public c(View view) {
        super(view);
        this.ajp = 3;
        this.jyj = null;
        this.jyk = null;
        cG(view);
    }

    private void cG(View view) {
        if (view != null) {
            this.jyj = view.findViewById(R.id.top_divider_line);
            this.jyk = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
