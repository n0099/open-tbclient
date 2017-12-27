package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener bkE;
    private String labelName = "";
    private int bkA = 0;
    private boolean bkB = false;
    private String labelId = "";
    private int bkC = 0;
    private boolean bkD = false;
    private int bkF = aj.getColor(d.C0108d.cp_cont_i);
    private int bkG = aj.getColor(d.C0108d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ht(int i) {
        this.bkA = i;
    }

    public int IJ() {
        return this.bkA;
    }

    public void bP(boolean z) {
        this.bkB = z;
    }

    public boolean IK() {
        return this.bkB;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String IL() {
        return this.labelId;
    }

    public void bQ(boolean z) {
        this.bkD = z;
    }

    public boolean IM() {
        return this.bkD;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.bkE = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener IN() {
        return this.bkE;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = str + "(" + am.G(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkF), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkF), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkG), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
