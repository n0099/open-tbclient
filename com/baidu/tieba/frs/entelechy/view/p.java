package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class p extends r.a {
    public View aGH;
    public TextView aQH;
    public View bOk;
    public Context mContext;

    public p(View view, Context context) {
        super(view);
        this.aGH = view;
        this.aQH = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.bOk = view.findViewById(d.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(com.baidu.tieba.frs.r rVar) {
        if (rVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.j.smart_frs_read_progress_tip), am.A(rVar.avf()));
            String string = this.mContext.getResources().getString(d.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(aj.getColor(d.C0107d.cp_link_tip_a)));
            this.aQH.setText(spannableString);
            DR();
        }
    }

    public void DR() {
        aj.r(this.aQH, d.C0107d.cp_cont_c);
        aj.s(this.aGH, d.f.addresslist_item_bg);
        aj.t(this.bOk, d.C0107d.cp_bg_line_c);
    }
}
