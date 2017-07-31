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
    public View Sd;
    public View aVB;
    public TextView acG;
    public Context mContext;

    public p(View view, Context context) {
        super(view);
        this.Sd = view;
        this.acG = (TextView) view.findViewById(d.h.view_frs_read_progress);
        this.aVB = view.findViewById(d.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(com.baidu.tieba.frs.p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.l.smart_frs_read_progress_tip), al.s(pVar.age()));
            String string = this.mContext.getResources().getString(d.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)));
            this.acG.setText(spannableString);
            xd();
        }
    }

    public void xd() {
        ai.i(this.acG, d.e.cp_cont_c);
        ai.j(this.Sd, d.g.addresslist_item_bg);
        ai.k(this.aVB, d.e.cp_bg_line_c);
    }
}
