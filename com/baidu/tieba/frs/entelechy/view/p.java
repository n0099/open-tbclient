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
    public View Ry;
    public View aXj;
    public TextView acd;
    public Context mContext;

    public p(View view, Context context) {
        super(view);
        this.Ry = view;
        this.acd = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.aXj = view.findViewById(d.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(com.baidu.tieba.frs.p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.j.smart_frs_read_progress_tip), am.s(pVar.akp()));
            String string = this.mContext.getResources().getString(d.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(aj.getColor(d.C0080d.cp_link_tip_a)));
            this.acd.setText(spannableString);
            wB();
        }
    }

    public void wB() {
        aj.i(this.acd, d.C0080d.cp_cont_c);
        aj.j(this.Ry, d.f.addresslist_item_bg);
        aj.k(this.aXj, d.C0080d.cp_bg_line_c);
    }
}
