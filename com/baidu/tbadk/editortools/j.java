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
    private final String asr;
    private PopupWindow ass;
    private final String ast;
    private final int asu;
    private final int asv;

    public j(String str, String str2, int i, int i2) {
        this.asr = str;
        this.ast = str2;
        this.asu = i;
        this.asv = i2;
    }

    public int getToolId() {
        return this.asu;
    }

    public int Bo() {
        return this.asv;
    }

    public void f(Context context, View view) {
        if (!StringUtils.isNull(this.asr) && !StringUtils.isNull(this.ast) && com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean(this.ast, true)) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean(this.ast, false);
            g(context, view);
        }
    }

    private void g(Context context, View view) {
        if (context != null && view != null) {
            TextView textView = new TextView(context);
            textView.setText(this.asr);
            textView.setGravity(17);
            as.h((View) textView, n.d.cp_cont_i);
            textView.setTextSize(0, com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.e.fontsize28));
            int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.e.ds266);
            int d2 = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.e.ds76);
            as.i((View) textView, n.f.bg_video_float_l);
            this.ass = new PopupWindow(textView, d, d2);
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.ass, view, com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), n.e.ds20), 0);
        }
    }

    public void Bp() {
        if (this.ass != null && this.ass.isShowing()) {
            com.baidu.adp.lib.h.j.a(this.ass);
            this.ass = null;
        }
    }
}
