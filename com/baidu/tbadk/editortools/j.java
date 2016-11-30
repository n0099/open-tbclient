package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private final String auL;
    private PopupWindow auM;
    private final String auN;
    private final int auO;
    private final int auP;

    public j(String str, String str2, int i, int i2) {
        this.auL = str;
        this.auN = str2;
        this.auO = i;
        this.auP = i2;
    }

    public int getToolId() {
        return this.auO;
    }

    public int CT() {
        return this.auP;
    }

    public void d(Context context, View view) {
        int i;
        if (!StringUtils.isNull(this.auL) && !StringUtils.isNull(this.auN) && (i = com.baidu.tbadk.core.sharedPref.b.um().getInt(this.auN, 0)) < 3) {
            com.baidu.tbadk.core.sharedPref.b.um().putInt(this.auN, i + 1);
            e(context, view);
        }
    }

    private void e(Context context, View view) {
        int i;
        int i2 = 0;
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.auL);
            textView.setGravity(17);
            at.j((View) textView, r.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.fontsize28));
            int e = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds266);
            int e2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds76);
            at.k(textView, r.f.bg_tip_blue_right);
            this.auM = new PopupWindow(textView, e, e2);
            if (this.auP == 2) {
                i2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds20);
                i = -com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds152);
            } else {
                i = -com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds124);
            }
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.auM, view, i2, i);
            com.baidu.adp.lib.h.h.eG().postDelayed(new k(this), 3000L);
        }
    }

    public void CU() {
        if (this.auM != null && this.auM.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.auM);
        }
    }
}
