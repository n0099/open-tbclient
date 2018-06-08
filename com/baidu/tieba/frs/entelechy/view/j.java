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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.n;
/* loaded from: classes2.dex */
public class j extends q.a {
    public View abp;
    public TextView alu;
    public View biz;
    public Context mContext;

    public j(View view, Context context) {
        super(view);
        this.abp = view;
        this.alu = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.biz = view.findViewById(d.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(n nVar) {
        if (nVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.k.smart_frs_read_progress_tip), ao.w(nVar.getReadTime()));
            String string = this.mContext.getResources().getString(d.k.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_a)));
            this.alu.setText(spannableString);
            Ay();
        }
    }

    public void Ay() {
        al.h(this.alu, d.C0141d.cp_cont_c);
        al.i(this.abp, d.f.addresslist_item_bg);
        al.j(this.biz, d.C0141d.cp_bg_line_c);
    }
}
