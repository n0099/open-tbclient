package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends af.a {
    public int aku;
    public View keU;
    public TextView keV;

    public c(View view) {
        super(view);
        this.aku = 3;
        this.keU = null;
        this.keV = null;
        db(view);
    }

    private void db(View view) {
        if (view != null) {
            this.keU = view.findViewById(R.id.top_divider_line);
            this.keV = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
