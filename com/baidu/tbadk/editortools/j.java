package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j {
    private final String aqr;
    private PopupWindow aqs;
    private final String aqt;
    private final int aqu;
    private final int aqv;

    public j(String str, String str2, int i, int i2) {
        this.aqr = str;
        this.aqt = str2;
        this.aqu = i;
        this.aqv = i2;
    }

    public int getToolId() {
        return this.aqu;
    }

    public int Bq() {
        return this.aqv;
    }

    public void c(Context context, View view) {
        int i;
        if (!StringUtils.isNull(this.aqr) && !StringUtils.isNull(this.aqt) && (i = com.baidu.tbadk.core.sharedPref.b.sO().getInt(this.aqt, 0)) < 3) {
            com.baidu.tbadk.core.sharedPref.b.sO().putInt(this.aqt, i + 1);
            d(context, view);
        }
    }

    private void d(Context context, View view) {
        int i;
        int i2 = 0;
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.aqr);
            textView.setGravity(17);
            av.j((View) textView, u.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.fontsize28));
            int c = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds266);
            int c2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds76);
            av.k(textView, u.f.bg_tip_blue_right);
            this.aqs = new PopupWindow(textView, c, c2);
            if (this.aqv == 2) {
                i2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds20);
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds152);
            } else {
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds124);
            }
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.aqs, view, i2, i);
            com.baidu.adp.lib.h.h.dM().postDelayed(new k(this), 3000L);
        }
    }

    public void Br() {
        if (this.aqs != null && this.aqs.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.aqs);
        }
    }
}
