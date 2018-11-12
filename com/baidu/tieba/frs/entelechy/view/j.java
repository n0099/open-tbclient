package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.p;
/* loaded from: classes6.dex */
public class j extends q.a {
    public View ajk;
    public TextView atD;
    public View bvs;
    public Context mContext;

    public j(View view, Context context) {
        super(view);
        this.ajk = view;
        this.atD = (TextView) view.findViewById(e.g.view_frs_read_progress);
        this.bvs = view.findViewById(e.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(e.j.smart_frs_read_progress_tip), ao.G(pVar.aAr()));
            String string = this.mContext.getResources().getString(e.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)));
            this.atD.setText(spannableString);
            Ef();
        }
    }

    public void Ef() {
        al.h(this.atD, e.d.cp_cont_c);
        al.i(this.ajk, e.f.addresslist_item_bg);
        al.j(this.bvs, e.d.cp_bg_line_c);
    }
}
