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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.p;
/* loaded from: classes2.dex */
public class j extends q.a {
    public View aaW;
    public TextView alt;
    public View bkJ;
    public Context mContext;

    public j(View view, Context context) {
        super(view);
        this.aaW = view;
        this.alt = (TextView) view.findViewById(f.g.view_frs_read_progress);
        this.bkJ = view.findViewById(f.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(f.j.smart_frs_read_progress_tip), ap.y(pVar.avE()));
            String string = this.mContext.getResources().getString(f.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_a)));
            this.alt.setText(spannableString);
            AD();
        }
    }

    public void AD() {
        am.h(this.alt, f.d.cp_cont_c);
        am.i(this.aaW, f.C0146f.addresslist_item_bg);
        am.j(this.bkJ, f.d.cp_bg_line_c);
    }
}
