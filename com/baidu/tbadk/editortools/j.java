package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j {
    private final String apB;
    private PopupWindow apC;
    private final String apD;
    private final int apE;
    private final int apF;

    public j(String str, String str2, int i, int i2) {
        this.apB = str;
        this.apD = str2;
        this.apE = i;
        this.apF = i2;
    }

    public int getToolId() {
        return this.apE;
    }

    public int Bh() {
        return this.apF;
    }

    public void c(Context context, View view) {
        int i;
        if (!StringUtils.isNull(this.apB) && !StringUtils.isNull(this.apD) && (i = com.baidu.tbadk.core.sharedPref.b.sR().getInt(this.apD, 0)) < 3) {
            com.baidu.tbadk.core.sharedPref.b.sR().putInt(this.apD, i + 1);
            d(context, view);
        }
    }

    private void d(Context context, View view) {
        int i;
        int i2 = 0;
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.apB);
            textView.setGravity(17);
            at.j((View) textView, t.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.fontsize28));
            int c = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds266);
            int c2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds76);
            at.k(textView, t.f.bg_tip_blue_right);
            this.apC = new PopupWindow(textView, c, c2);
            if (this.apF == 2) {
                i2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds20);
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds152);
            } else {
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds124);
            }
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.apC, view, i2, i);
            com.baidu.adp.lib.h.h.dL().postDelayed(new k(this), 3000L);
        }
    }

    public void Bi() {
        if (this.apC != null && this.apC.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.apC);
        }
    }
}
