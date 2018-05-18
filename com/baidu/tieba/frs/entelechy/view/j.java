package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.n;
/* loaded from: classes2.dex */
public class j extends q.a {
    public View Th;
    public TextView adw;
    public View ban;
    public Context mContext;

    public j(View view2, Context context) {
        super(view2);
        this.Th = view2;
        this.adw = (TextView) view2.findViewById(d.g.view_frs_read_progress);
        this.ban = view2.findViewById(d.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(n nVar) {
        if (nVar != null) {
            String format = String.format(this.mContext.getResources().getString(d.k.smart_frs_read_progress_tip), an.t(nVar.getReadTime()));
            String string = this.mContext.getResources().getString(d.k.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_a)));
            this.adw.setText(spannableString);
            wX();
        }
    }

    public void wX() {
        ak.h(this.adw, d.C0126d.cp_cont_c);
        ak.i(this.Th, d.f.addresslist_item_bg);
        ak.j(this.ban, d.C0126d.cp_bg_line_c);
    }
}
