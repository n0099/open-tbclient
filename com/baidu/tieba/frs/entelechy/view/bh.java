package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bh extends z.a {
    public View Qr;
    public View aTm;
    public TextView aaK;
    public Context mContext;

    public bh(View view, Context context) {
        super(view);
        this.Qr = view;
        this.aaK = (TextView) view.findViewById(w.h.view_frs_read_progress);
        this.aTm = view.findViewById(w.h.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(com.baidu.tieba.frs.bh bhVar) {
        if (bhVar != null) {
            String format = String.format(this.mContext.getResources().getString(w.l.smart_frs_read_progress_tip), com.baidu.tbadk.core.util.aw.r(bhVar.aeT()));
            String string = this.mContext.getResources().getString(w.l.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_a)));
            this.aaK.setText(spannableString);
            wK();
        }
    }

    public void wK() {
        com.baidu.tbadk.core.util.as.i(this.aaK, w.e.cp_cont_c);
        com.baidu.tbadk.core.util.as.j(this.Qr, w.g.addresslist_item_bg);
        com.baidu.tbadk.core.util.as.k(this.aTm, w.e.cp_bg_line_c);
    }
}
