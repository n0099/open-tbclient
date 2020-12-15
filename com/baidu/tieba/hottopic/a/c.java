package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends af.a {
    public int aku;
    public View keW;
    public TextView keX;

    public c(View view) {
        super(view);
        this.aku = 3;
        this.keW = null;
        this.keX = null;
        db(view);
    }

    private void db(View view) {
        if (view != null) {
            this.keW = view.findViewById(R.id.top_divider_line);
            this.keX = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
