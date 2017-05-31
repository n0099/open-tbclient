package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bh extends z.a {
    public View Qx;
    public View aRT;
    public TextView aaJ;
    public Context mContext;

    public bh(View view, Context context) {
        super(view);
        this.Qx = view;
        this.aaJ = (TextView) view.findViewById(w.h.view_frs_read_progress);
        this.aRT = view.findViewById(w.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(bg bgVar) {
        if (bgVar != null) {
            String format = String.format(this.mContext.getResources().getString(w.l.smart_frs_read_progress_tip), com.baidu.tbadk.core.util.au.r(bgVar.abc()));
            String string = this.mContext.getResources().getString(w.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)));
            this.aaJ.setText(spannableString);
            ws();
        }
    }

    public void ws() {
        com.baidu.tbadk.core.util.aq.i(this.aaJ, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.aq.j(this.Qx, w.g.addresslist_item_bg);
        com.baidu.tbadk.core.util.aq.k(this.aRT, w.e.cp_bg_line_c);
    }
}
