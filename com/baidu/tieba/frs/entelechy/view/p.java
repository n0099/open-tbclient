package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends j.a {
    public View QE;
    public View aUp;
    public TextView abj;
    public Context mContext;

    public p(View view, Context context) {
        super(view);
        this.QE = view;
        this.abj = (TextView) view.findViewById(d.h.view_frs_read_progress);
        this.aUp = view.findViewById(d.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(com.baidu.tieba.frs.p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.l.smart_frs_read_progress_tip), al.s(pVar.afX()));
            String string = this.mContext.getResources().getString(d.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)));
            this.abj.setText(spannableString);
            wV();
        }
    }

    public void wV() {
        ai.i(this.abj, d.e.cp_cont_c);
        ai.j(this.QE, d.g.addresslist_item_bg);
        ai.k(this.aUp, d.e.cp_bg_line_c);
    }
}
