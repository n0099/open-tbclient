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
    public TextView bFI;
    public View btY;
    public Context mContext;

    public e(View view, Context context) {
        super(view);
        this.btY = view;
        this.bFI = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            this.bFI.setText(d.j.read_here);
            aeK();
        }
    }

    public void aeK() {
        al.j(this.bFI, d.C0277d.cp_link_tip_a);
        al.k(this.btY, d.C0277d.cp_bg_line_e);
    }
}
