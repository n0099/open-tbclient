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
    private final String arg;
    private PopupWindow arh;
    private final String ari;
    private final int arj;
    private final int ark;

    public j(String str, String str2, int i, int i2) {
        this.arg = str;
        this.ari = str2;
        this.arj = i;
        this.ark = i2;
    }

    public int getToolId() {
        return this.arj;
    }

    public int Bq() {
        return this.ark;
    }

    public void d(Context context, View view) {
        int i;
        if (!StringUtils.isNull(this.arg) && !StringUtils.isNull(this.ari) && (i = com.baidu.tbadk.core.sharedPref.b.sN().getInt(this.ari, 0)) < 3) {
            com.baidu.tbadk.core.sharedPref.b.sN().putInt(this.ari, i + 1);
            e(context, view);
        }
    }

    private void e(Context context, View view) {
        int i;
        int i2 = 0;
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.arg);
            textView.setGravity(17);
            av.j((View) textView, u.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.fontsize28));
            int c = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds266);
            int c2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds76);
            av.k(textView, u.f.bg_tip_blue_right);
            this.arh = new PopupWindow(textView, c, c2);
            if (this.ark == 2) {
                i2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds20);
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds152);
            } else {
                i = -com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds124);
            }
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.arh, view, i2, i);
            com.baidu.adp.lib.h.h.dL().postDelayed(new k(this), 3000L);
        }
    }

    public void Br() {
        if (this.arh != null && this.arh.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.arh);
        }
    }
}
