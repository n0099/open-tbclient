package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends j.a {
    public View Rh;
    public View aVm;
    public TextView abP;
    public Context mContext;

    public p(View view, Context context) {
        super(view);
        this.Rh = view;
        this.abP = (TextView) view.findViewById(d.h.view_frs_read_progress);
        this.aVm = view.findViewById(d.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(com.baidu.tieba.frs.p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.l.smart_frs_read_progress_tip), am.s(pVar.ahR()));
            String string = this.mContext.getResources().getString(d.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)));
            this.abP.setText(spannableString);
            xc();
        }
    }

    public void xc() {
        aj.i(this.abP, d.e.cp_cont_c);
        aj.j(this.Rh, d.g.addresslist_item_bg);
        aj.k(this.aVm, d.e.cp_bg_line_c);
    }
}
