package com.baidu.tieba.frs.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends y.a {
    public TextView bYZ;
    public LinearLayout bZa;
    public TextView bZb;
    public View bZc;
    public bg bZd;
    public bp bZe;

    public e(View view) {
        super(view);
        this.bYZ = (TextView) view.findViewById(w.h.storecard_title);
        this.bZa = (LinearLayout) view.findViewById(w.h.storecard_middle_layout);
        this.bZb = (TextView) view.findViewById(w.h.storecard_all_list);
        this.bZc = view.findViewById(w.h.storecard_close_click);
    }
}
