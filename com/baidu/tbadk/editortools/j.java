package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j {
    private final String aqN;
    private PopupWindow aqO;
    private final String aqP;
    private final int aqQ;
    private final int aqR;

    public j(String str, String str2, int i, int i2) {
        this.aqN = str;
        this.aqP = str2;
        this.aqQ = i;
        this.aqR = i2;
    }

    public int getToolId() {
        return this.aqQ;
    }

    public int Bz() {
        return this.aqR;
    }

    public void f(Context context, View view) {
        if (!StringUtils.isNull(this.aqN) && !StringUtils.isNull(this.aqP) && com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean(this.aqP, true)) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean(this.aqP, false);
            g(context, view);
        }
    }

    private void g(Context context, View view) {
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.aqN);
            textView.setGravity(17);
            as.h((View) textView, n.c.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.d.fontsize28));
            int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.d.ds266);
            int d2 = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.d.ds76);
            as.i((View) textView, n.e.bg_video_float_l);
            this.aqO = new PopupWindow(textView, d, d2);
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.aqO, view, com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.d.ds20), 0);
        }
    }

    public void BA() {
        if (this.aqO != null && this.aqO.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.aqO);
            this.aqO = null;
        }
    }
}
