package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener atK;
    private String labelName = "";
    private int atG = 0;
    private boolean atH = false;
    private String labelId = "";
    private int atI = 0;
    private boolean atJ = false;
    private int atL = aq.getColor(w.e.cp_cont_i);
    private int atM = aq.getColor(w.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ee(int i) {
        this.atG = i;
    }

    public int AX() {
        return this.atG;
    }

    public void bk(boolean z) {
        this.atH = z;
    }

    public boolean AY() {
        return this.atH;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AZ() {
        return this.labelId;
    }

    public void bl(boolean z) {
        this.atJ = z;
    }

    public boolean Ba() {
        return this.atJ;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.atK = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bb() {
        return this.atK;
    }

    public SpannableStringBuilder ai(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + au.w(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.atL), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.atL), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.atM), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
