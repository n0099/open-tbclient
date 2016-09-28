package com.baidu.tbadk.editortools;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private final String atR;
    private PopupWindow atS;
    private final String atT;
    private final int atU;
    private final int atV;

    public j(String str, String str2, int i, int i2) {
        this.atR = str;
        this.atT = str2;
        this.atU = i;
        this.atV = i2;
    }

    public int getToolId() {
        return this.atU;
    }

    public int CL() {
        return this.atV;
    }

    public void d(Context context, View view) {
        int i;
        if (!StringUtils.isNull(this.atR) && !StringUtils.isNull(this.atT) && (i = com.baidu.tbadk.core.sharedPref.b.uh().getInt(this.atT, 0)) < 3) {
            com.baidu.tbadk.core.sharedPref.b.uh().putInt(this.atT, i + 1);
            e(context, view);
        }
    }

    private void e(Context context, View view) {
        int i;
        int i2 = 0;
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.atR);
            textView.setGravity(17);
            av.j((View) textView, r.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.fontsize28));
            int e = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds266);
            int e2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds76);
            av.k(textView, r.f.bg_tip_blue_right);
            this.atS = new PopupWindow(textView, e, e2);
            if (this.atV == 2) {
                i2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds20);
                i = -com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds152);
            } else {
                i = -com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds124);
            }
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.atS, view, i2, i);
            com.baidu.adp.lib.h.h.eG().postDelayed(new k(this), 3000L);
        }
    }

    public void CM() {
        if (this.atS != null && this.atS.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.atS);
        }
    }
}
