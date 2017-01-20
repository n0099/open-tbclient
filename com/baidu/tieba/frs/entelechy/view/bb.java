package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bb extends y.a {
    public View LW;
    public TextView VM;
    public View aNS;
    public Context mContext;

    public bb(View view, Context context) {
        super(view);
        this.LW = view;
        this.VM = (TextView) view.findViewById(r.h.view_frs_read_progress);
        this.aNS = view.findViewById(r.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(bj bjVar) {
        if (bjVar != null) {
            String format = String.format(this.mContext.getResources().getString(r.l.smart_frs_read_progress_tip), com.baidu.tbadk.core.util.at.s(bjVar.Za()));
            String string = this.mContext.getResources().getString(r.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_a)));
            this.VM.setText(spannableString);
            ws();
        }
    }

    public void ws() {
        com.baidu.tbadk.core.util.ap.i((View) this.VM, r.e.cp_cont_c);
        com.baidu.tbadk.core.util.ap.j(this.LW, r.g.addresslist_item_bg);
        com.baidu.tbadk.core.util.ap.k(this.aNS, r.e.cp_bg_line_c);
    }
}
