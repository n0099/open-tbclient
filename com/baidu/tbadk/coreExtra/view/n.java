package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener aua;
    private String labelName = "";
    private int atW = 0;
    private boolean atX = false;
    private String labelId = "";
    private int atY = 0;
    private boolean atZ = false;
    private int aub = aq.getColor(w.e.cp_cont_i);
    private int auc = aq.getColor(w.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void eh(int i) {
        this.atW = i;
    }

    public int Bw() {
        return this.atW;
    }

    public void bm(boolean z) {
        this.atX = z;
    }

    public boolean Bx() {
        return this.atX;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String By() {
        return this.labelId;
    }

    public void bn(boolean z) {
        this.atZ = z;
    }

    public boolean Bz() {
        return this.atZ;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.aua = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener BA() {
        return this.aua;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + au.w(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aub), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aub), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.auc), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
