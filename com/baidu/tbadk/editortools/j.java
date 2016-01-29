package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j {
    private final String atk;
    private PopupWindow atl;
    private final String atm;
    private final int atn;
    private final int ato;

    public j(String str, String str2, int i, int i2) {
        this.atk = str;
        this.atm = str2;
        this.atn = i;
        this.ato = i2;
    }

    public int getToolId() {
        return this.atn;
    }

    public int CE() {
        return this.ato;
    }

    public void f(Context context, View view) {
        if (!StringUtils.isNull(this.atk) && !StringUtils.isNull(this.atm) && com.baidu.tbadk.core.sharedPref.b.uO().getBoolean(this.atm, true)) {
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean(this.atm, false);
            g(context, view);
        }
    }

    private void g(Context context, View view) {
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.atk);
            textView.setGravity(17);
            ar.j((View) textView, t.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.fontsize28));
            int c = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds266);
            int c2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds76);
            ar.k(textView, t.f.bg_video_float_l);
            this.atl = new PopupWindow(textView, c, c2);
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.atl, view, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds20), 0);
        }
    }

    public void CF() {
        if (this.atl != null && this.atl.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.atl);
            this.atl = null;
        }
    }
}
