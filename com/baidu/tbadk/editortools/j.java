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
    private final String atJ;
    private PopupWindow atK;
    private final String atL;
    private final int atM;
    private final int atN;

    public j(String str, String str2, int i, int i2) {
        this.atJ = str;
        this.atL = str2;
        this.atM = i;
        this.atN = i2;
    }

    public int getToolId() {
        return this.atM;
    }

    public int Dm() {
        return this.atN;
    }

    public void e(Context context, View view) {
        int i;
        if (!StringUtils.isNull(this.atJ) && !StringUtils.isNull(this.atL) && (i = com.baidu.tbadk.core.sharedPref.b.vk().getInt(this.atL, 0)) < 3) {
            com.baidu.tbadk.core.sharedPref.b.vk().putInt(this.atL, i + 1);
            f(context, view);
        }
    }

    private void f(Context context, View view) {
        int i;
        int i2 = 0;
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.atJ);
            textView.setGravity(17);
            at.j((View) textView, t.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.fontsize28));
            int c = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds266);
            int c2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds76);
            at.k(textView, t.f.bg_tip_blue_right);
            this.atK = new PopupWindow(textView, c, c2);
            if (this.atN == 2) {
                i2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds20);
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds152);
            } else {
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds124);
            }
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.atK, view, i2, i);
            com.baidu.adp.lib.h.h.hx().postDelayed(new k(this), 3000L);
        }
    }

    public void Dn() {
        if (this.atK != null && this.atK.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.atK);
        }
    }
}
