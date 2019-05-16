package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.p;
/* loaded from: classes4.dex */
public class e extends v.a {
    public View bBg;
    public TextView bNl;
    public Context mContext;

    public e(View view, Context context) {
        super(view);
        this.bBg = view;
        this.bNl = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            this.bNl.setText(R.string.read_here);
            ajG();
        }
    }

    public void ajG() {
        al.j(this.bNl, R.color.cp_link_tip_a);
        al.k(this.bBg, R.color.cp_bg_line_e);
    }
}
