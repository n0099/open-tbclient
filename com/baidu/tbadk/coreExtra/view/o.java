package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class o {
    private ViewTreeObserver.OnGlobalLayoutListener akH;
    private String labelName = "";
    private int akD = 0;
    private boolean akE = false;
    private String labelId = "";
    private int akF = 0;
    private boolean akG = false;

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dD(int i) {
        this.akD = i;
    }

    public int yS() {
        return this.akD;
    }

    public void aQ(boolean z) {
        this.akE = z;
    }

    public boolean yT() {
        return this.akE;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String yU() {
        return this.labelId;
    }

    public void aR(boolean z) {
        this.akG = z;
    }

    public boolean yV() {
        return this.akG;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.akH = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener yW() {
        return this.akH;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ar.s(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(i.c.cp_cont_i)), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(i.c.cp_cont_i)), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(i.c.cp_link_tip_d)), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
