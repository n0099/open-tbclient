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
    public View amM;
    public TextView axe;
    public View byS;
    public Context mContext;

    public j(View view, Context context) {
        super(view);
        this.amM = view;
        this.axe = (TextView) view.findViewById(e.g.view_frs_read_progress);
        this.byS = view.findViewById(e.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(e.j.smart_frs_read_progress_tip), ao.O(pVar.aCQ()));
            String string = this.mContext.getResources().getString(e.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)));
            this.axe.setText(spannableString);
            Fj();
        }
    }

    public void Fj() {
        al.h(this.axe, e.d.cp_cont_c);
        al.i(this.amM, e.f.addresslist_item_bg);
        al.j(this.byS, e.d.cp_bg_line_c);
    }
}
