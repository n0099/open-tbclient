package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bb extends y.a {
    public View QZ;
    public View aTF;
    public TextView aaZ;
    public Context mContext;

    public bb(View view, Context context) {
        super(view);
        this.QZ = view;
        this.aaZ = (TextView) view.findViewById(w.h.view_frs_read_progress);
        this.aTF = view.findViewById(w.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(bj bjVar) {
        if (bjVar != null) {
            String format = String.format(this.mContext.getResources().getString(w.l.smart_frs_read_progress_tip), com.baidu.tbadk.core.util.au.r(bjVar.ZZ()));
            String string = this.mContext.getResources().getString(w.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)));
            this.aaZ.setText(spannableString);
            wP();
        }
    }

    public void wP() {
        com.baidu.tbadk.core.util.aq.i((View) this.aaZ, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.j(this.QZ, w.g.addresslist_item_bg);
        com.baidu.tbadk.core.util.aq.k(this.aTF, w.e.cp_bg_line_c);
    }
}
