package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener aug;
    private String labelName = "";
    private int auc = 0;
    private boolean aud = false;
    private String labelId = "";
    private int aue = 0;
    private boolean auf = false;
    private int auh = aq.getColor(w.e.cp_cont_i);
    private int aui = aq.getColor(w.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ef(int i) {
        this.auc = i;
    }

    public int AH() {
        return this.auc;
    }

    public void bm(boolean z) {
        this.aud = z;
    }

    public boolean AI() {
        return this.aud;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AJ() {
        return this.labelId;
    }

    public void bn(boolean z) {
        this.auf = z;
    }

    public boolean AK() {
        return this.auf;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.aug = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AL() {
        return this.aug;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + au.x(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.auh), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.auh), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aui), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
