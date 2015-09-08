package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class p {
    private ViewTreeObserver.OnGlobalLayoutListener ame;
    private String labelName = "";
    private int ama = 0;
    private boolean amb = false;
    private String labelId = "";
    private int amc = 0;
    private boolean amd = false;

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dC(int i) {
        this.ama = i;
    }

    public int zj() {
        return this.ama;
    }

    public void aU(boolean z) {
        this.amb = z;
    }

    public boolean zk() {
        return this.amb;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String zl() {
        return this.labelId;
    }

    public void aV(boolean z) {
        this.amd = z;
    }

    public boolean zm() {
        return this.amd;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.ame = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener zn() {
        return this.ame;
    }

    public SpannableStringBuilder al(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + aq.r(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(i.c.cp_cont_i)), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(i.c.cp_cont_i)), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(i.c.cp_link_tip_d)), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
