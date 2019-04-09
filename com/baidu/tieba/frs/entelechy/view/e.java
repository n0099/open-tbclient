package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.p;
/* loaded from: classes4.dex */
public class e extends v.a {
    public TextView bFL;
    public View buc;
    public Context mContext;

    public e(View view, Context context) {
        super(view);
        this.buc = view;
        this.bFL = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            this.bFL.setText(d.j.read_here);
            aeH();
        }
    }

    public void aeH() {
        al.j(this.bFL, d.C0277d.cp_link_tip_a);
        al.k(this.buc, d.C0277d.cp_bg_line_e);
    }
}
