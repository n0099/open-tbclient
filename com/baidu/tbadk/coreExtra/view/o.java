package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class o {
    private ViewTreeObserver.OnGlobalLayoutListener akN;
    private String labelName = "";
    private int akJ = 0;
    private boolean akK = false;
    private String labelId = "";
    private int akL = 0;
    private boolean akM = false;

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dD(int i) {
        this.akJ = i;
    }

    public int yU() {
        return this.akJ;
    }

    public void aQ(boolean z) {
        this.akK = z;
    }

    public boolean yV() {
        return this.akK;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String yW() {
        return this.labelId;
    }

    public void aR(boolean z) {
        this.akM = z;
    }

    public boolean yX() {
        return this.akM;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.akN = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener yY() {
        return this.akN;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + as.q(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
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
