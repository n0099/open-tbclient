package com.baidu.tieba.frs.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends y.a {
    public TextView bRR;
    public LinearLayout bRS;
    public TextView bRT;
    public View bRU;
    public bg bRV;
    public bp bRW;

    public e(View view) {
        super(view);
        this.bRR = (TextView) view.findViewById(r.h.storecard_title);
        this.bRS = (LinearLayout) view.findViewById(r.h.storecard_middle_layout);
        this.bRT = (TextView) view.findViewById(r.h.storecard_all_list);
        this.bRU = view.findViewById(r.h.storecard_close_click);
    }
}
