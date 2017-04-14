package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bb extends y.a {
    public View Rr;
    public View aTU;
    public TextView abo;
    public Context mContext;

    public bb(View view, Context context) {
        super(view);
        this.Rr = view;
        this.abo = (TextView) view.findViewById(w.h.view_frs_read_progress);
        this.aTU = view.findViewById(w.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(bl blVar) {
        if (blVar != null) {
            String format = String.format(this.mContext.getResources().getString(w.l.smart_frs_read_progress_tip), com.baidu.tbadk.core.util.au.r(blVar.aax()));
            String string = this.mContext.getResources().getString(w.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)));
            this.abo.setText(spannableString);
            xl();
        }
    }

    public void xl() {
        com.baidu.tbadk.core.util.aq.i(this.abo, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.j(this.Rr, w.g.addresslist_item_bg);
        com.baidu.tbadk.core.util.aq.k(this.aTU, w.e.cp_bg_line_c);
    }
}
