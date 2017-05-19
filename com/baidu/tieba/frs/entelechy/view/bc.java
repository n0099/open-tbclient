package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bc extends y.a {
    public View QK;
    public View aUr;
    public TextView aaK;
    public Context mContext;

    public bc(View view, Context context) {
        super(view);
        this.QK = view;
        this.aaK = (TextView) view.findViewById(w.h.view_frs_read_progress);
        this.aUr = view.findViewById(w.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(bf bfVar) {
        if (bfVar != null) {
            String format = String.format(this.mContext.getResources().getString(w.l.smart_frs_read_progress_tip), com.baidu.tbadk.core.util.au.r(bfVar.aaa()));
            String string = this.mContext.getResources().getString(w.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)));
            this.aaK.setText(spannableString);
            ww();
        }
    }

    public void ww() {
        com.baidu.tbadk.core.util.aq.i(this.aaK, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.j(this.QK, w.g.addresslist_item_bg);
        com.baidu.tbadk.core.util.aq.k(this.aUr, w.e.cp_bg_line_c);
    }
}
