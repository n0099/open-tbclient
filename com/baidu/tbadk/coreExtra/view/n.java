package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener akD;
    private String labelName = "";
    private int akz = 0;
    private boolean akA = false;
    private String labelId = "";
    private int akB = 0;
    private boolean akC = false;
    private int akE = at.getColor(t.d.cp_cont_i);
    private int akF = at.getColor(t.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dQ(int i) {
        this.akz = i;
    }

    public int zr() {
        return this.akz;
    }

    public void bg(boolean z) {
        this.akA = z;
    }

    public boolean zs() {
        return this.akA;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String zt() {
        return this.labelId;
    }

    public void bh(boolean z) {
        this.akC = z;
    }

    public boolean zu() {
        return this.akC;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.akD = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener zv() {
        return this.akD;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ay.B(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.akE), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.akE), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.akF), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
