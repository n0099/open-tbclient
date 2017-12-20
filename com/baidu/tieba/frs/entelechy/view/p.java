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
import com.baidu.tieba.frs.q;
/* loaded from: classes.dex */
public class p extends j.a {
    public View Se;
    public TextView acs;
    public View ban;
    public Context mContext;

    public p(View view, Context context) {
        super(view);
        this.Se = view;
        this.acs = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.ban = view.findViewById(d.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(q qVar) {
        if (qVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.j.smart_frs_read_progress_tip), am.s(qVar.amt()));
            String string = this.mContext.getResources().getString(d.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(aj.getColor(d.C0096d.cp_link_tip_a)));
            this.acs.setText(spannableString);
            wC();
        }
    }

    public void wC() {
        aj.i(this.acs, d.C0096d.cp_cont_c);
        aj.j(this.Se, d.f.addresslist_item_bg);
        aj.k(this.ban, d.C0096d.cp_bg_line_c);
    }
}
