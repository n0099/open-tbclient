package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class o {
    private ViewTreeObserver.OnGlobalLayoutListener akI;
    private String labelName = "";
    private int akE = 0;
    private boolean akF = false;
    private String labelId = "";
    private int akG = 0;
    private boolean akH = false;

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dD(int i) {
        this.akE = i;
    }

    public int yS() {
        return this.akE;
    }

    public void aQ(boolean z) {
        this.akF = z;
    }

    public boolean yT() {
        return this.akF;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String yU() {
        return this.labelId;
    }

    public void aR(boolean z) {
        this.akH = z;
    }

    public boolean yV() {
        return this.akH;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.akI = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener yW() {
        return this.akI;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + as.s(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(i.c.cp_cont_i)), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(i.c.cp_cont_i)), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(i.c.cp_link_tip_d)), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
