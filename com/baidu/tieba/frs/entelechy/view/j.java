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
    public View abt;
    public TextView alU;
    public View bjZ;
    public Context mContext;

    public j(View view, Context context) {
        super(view);
        this.abt = view;
        this.alU = (TextView) view.findViewById(d.g.view_frs_read_progress);
        this.bjZ = view.findViewById(d.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(p pVar) {
        if (pVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.k.smart_frs_read_progress_tip), ap.x(pVar.getReadTime()));
            String string = this.mContext.getResources().getString(d.k.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_a)));
            this.alU.setText(spannableString);
            AP();
        }
    }

    public void AP() {
        am.h(this.alU, d.C0142d.cp_cont_c);
        am.i(this.abt, d.f.addresslist_item_bg);
        am.j(this.bjZ, d.C0142d.cp_bg_line_c);
    }
}
