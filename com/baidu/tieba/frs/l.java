package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.ala.e {
    @Override // com.baidu.tbadk.ala.e
    public View aq(Context context) {
        TextView ap = com.baidu.tbadk.ala.c.ap(context);
        if (ap != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            com.baidu.tbadk.core.util.as.i(ap, w.e.cp_cont_f);
            layoutParams.setMargins(com.baidu.adp.lib.util.k.g(context, w.f.ds16), 0, 0, 0);
            layoutParams.gravity = 16;
            ap.setLayoutParams(layoutParams);
        }
        return ap;
    }
}
