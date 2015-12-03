package com.baidu.tieba.frs.live;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends x.a {
    public TextView bhs;
    public LinearLayout bht;
    public TextView bhu;
    public View bhv;
    public db bhw;
    public dy bhx;

    public e(View view) {
        super(view);
        this.bhs = (TextView) view.findViewById(n.f.storecard_title);
        this.bht = (LinearLayout) view.findViewById(n.f.storecard_middle_layout);
        this.bhu = (TextView) view.findViewById(n.f.storecard_all_list);
        this.bhv = view.findViewById(n.f.storecard_close_click);
    }
}
