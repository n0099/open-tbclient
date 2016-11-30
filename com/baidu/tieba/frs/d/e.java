package com.baidu.tieba.frs.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends y.a {
    public TextView cfS;
    public LinearLayout cfT;
    public TextView cfU;
    public View cfV;
    public bf cfW;
    public bs cfX;

    public e(View view) {
        super(view);
        this.cfS = (TextView) view.findViewById(r.g.storecard_title);
        this.cfT = (LinearLayout) view.findViewById(r.g.storecard_middle_layout);
        this.cfU = (TextView) view.findViewById(r.g.storecard_all_list);
        this.cfV = view.findViewById(r.g.storecard_close_click);
    }
}
