package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.p;
/* loaded from: classes2.dex */
public class j extends q.a {
    public View aaV;
    public TextView alu;
    public View bkE;
    public Context mContext;

    public j(View view, Context context) {
        super(view);
        this.aaV = view;
        this.alu = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.bkE = view.findViewById(d.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.j.smart_frs_read_progress_tip), ap.y(pVar.avF()));
            String string = this.mContext.getResources().getString(d.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_a)));
            this.alu.setText(spannableString);
            AG();
        }
    }

    public void AG() {
        am.h(this.alu, d.C0140d.cp_cont_c);
        am.i(this.aaV, d.f.addresslist_item_bg);
        am.j(this.bkE, d.C0140d.cp_bg_line_c);
    }
}
