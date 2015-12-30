package com.baidu.tieba.frs.live;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends x.a {
    public TextView blj;
    public LinearLayout blk;
    public TextView bll;
    public View blm;
    public de bln;
    public dy blo;

    public e(View view) {
        super(view);
        this.blj = (TextView) view.findViewById(n.g.storecard_title);
        this.blk = (LinearLayout) view.findViewById(n.g.storecard_middle_layout);
        this.bll = (TextView) view.findViewById(n.g.storecard_all_list);
        this.blm = view.findViewById(n.g.storecard_close_click);
    }
}
