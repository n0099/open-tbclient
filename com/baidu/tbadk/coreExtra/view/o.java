package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class o {
    private ViewTreeObserver.OnGlobalLayoutListener amy;
    private String labelName = "";
    private int amu = 0;
    private boolean amv = false;
    private String labelId = "";
    private int amw = 0;
    private boolean amx = false;

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dS(int i) {
        this.amu = i;
    }

    public int zQ() {
        return this.amu;
    }

    public void aV(boolean z) {
        this.amv = z;
    }

    public boolean zR() {
        return this.amv;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String zS() {
        return this.labelId;
    }

    public void aW(boolean z) {
        this.amx = z;
    }

    public boolean zT() {
        return this.amx;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.amy = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener zU() {
        return this.amy;
    }

    public SpannableStringBuilder ah(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ax.w(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(as.getColor(n.c.cp_cont_i)), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(as.getColor(n.c.cp_cont_i)), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
