package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j {
    private final String aun;
    private PopupWindow auo;
    private final String aup;
    private final int auq;
    private final int aur;

    public j(String str, String str2, int i, int i2) {
        this.aun = str;
        this.aup = str2;
        this.auq = i;
        this.aur = i2;
    }

    public int getToolId() {
        return this.auq;
    }

    public int CL() {
        return this.aur;
    }

    public void d(Context context, View view) {
        int i;
        if (!StringUtils.isNull(this.aun) && !StringUtils.isNull(this.aup) && (i = com.baidu.tbadk.core.sharedPref.b.tS().getInt(this.aup, 0)) < 3) {
            com.baidu.tbadk.core.sharedPref.b.tS().putInt(this.aup, i + 1);
            e(context, view);
        }
    }

    private void e(Context context, View view) {
        int i;
        int i2 = 0;
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.aun);
            textView.setGravity(17);
            av.j((View) textView, t.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.fontsize28));
            int e = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds266);
            int e2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds76);
            av.k(textView, t.f.bg_tip_blue_right);
            this.auo = new PopupWindow(textView, e, e2);
            if (this.aur == 2) {
                i2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds20);
                i = -com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds152);
            } else {
                i = -com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds124);
            }
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.auo, view, i2, i);
            com.baidu.adp.lib.h.h.eG().postDelayed(new k(this), 3000L);
        }
    }

    public void CM() {
        if (this.auo != null && this.auo.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.auo);
        }
    }
}
