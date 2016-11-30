package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bb extends y.a {
    public View MM;
    public TextView Xc;
    public View aPy;
    public Context mContext;

    public bb(View view, Context context) {
        super(view);
        this.MM = view;
        this.Xc = (TextView) view.findViewById(r.g.view_frs_read_progress);
        this.aPy = view.findViewById(r.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(bi biVar) {
        if (biVar != null) {
            String format = String.format(this.mContext.getResources().getString(r.j.smart_frs_read_progress_tip), ax.t(biVar.adA()));
            String string = this.mContext.getResources().getString(r.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_a)));
            this.Xc.setText(spannableString);
            wM();
        }
    }

    public void wM() {
        com.baidu.tbadk.core.util.at.j((View) this.Xc, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.k(this.MM, r.f.addresslist_item_bg);
        com.baidu.tbadk.core.util.at.l(this.aPy, r.d.cp_bg_line_c);
    }
}
