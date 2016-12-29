package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bc extends y.a {
    public View MJ;
    public TextView Ww;
    public View aOP;
    public Context mContext;

    public bc(View view, Context context) {
        super(view);
        this.MJ = view;
        this.Ww = (TextView) view.findViewById(r.g.view_frs_read_progress);
        this.aOP = view.findViewById(r.g.line_under_frs_progress);
        this.mContext = context;
    }

    public void a(bl blVar) {
        if (blVar != null) {
            String format = String.format(this.mContext.getResources().getString(r.j.smart_frs_read_progress_tip), com.baidu.tbadk.core.util.av.t(blVar.XT()));
            String string = this.mContext.getResources().getString(r.j.click_to_refresh);
            SpannableString spannableString = new SpannableString(format);
            UtilHelper.setSpan(spannableString, format, string, new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_a)));
            this.Ww.setText(spannableString);
            wx();
        }
    }

    public void wx() {
        com.baidu.tbadk.core.util.ar.j((View) this.Ww, r.d.cp_cont_c);
        com.baidu.tbadk.core.util.ar.k(this.MJ, r.f.addresslist_item_bg);
        com.baidu.tbadk.core.util.ar.l(this.aOP, r.d.cp_bg_line_c);
    }
}
