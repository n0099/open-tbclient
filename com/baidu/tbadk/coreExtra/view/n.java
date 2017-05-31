package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener atQ;
    private String labelName = "";
    private int atM = 0;
    private boolean atN = false;
    private String labelId = "";
    private int atO = 0;
    private boolean atP = false;
    private int atR = aq.getColor(w.e.cp_cont_i);
    private int atS = aq.getColor(w.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void eg(int i) {
        this.atM = i;
    }

    public int AA() {
        return this.atM;
    }

    public void bj(boolean z) {
        this.atN = z;
    }

    public boolean AB() {
        return this.atN;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AC() {
        return this.labelId;
    }

    public void bk(boolean z) {
        this.atP = z;
    }

    public boolean AD() {
        return this.atP;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.atQ = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AE() {
        return this.atQ;
    }

    public SpannableStringBuilder ai(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + au.x(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.atR), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.atR), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.atS), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
