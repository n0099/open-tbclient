package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener aop;
    private String labelName = "";
    private int aol = 0;
    private boolean aom = false;
    private String labelId = "";
    private int aon = 0;
    private boolean aoo = false;
    private int aoq = ap.getColor(r.e.cp_cont_i);
    private int aor = ap.getColor(r.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ej(int i) {
        this.aol = i;
    }

    public int AE() {
        return this.aol;
    }

    public void bl(boolean z) {
        this.aom = z;
    }

    public boolean AF() {
        return this.aom;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AG() {
        return this.labelId;
    }

    public void bm(boolean z) {
        this.aoo = z;
    }

    public boolean AH() {
        return this.aoo;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.aop = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AI() {
        return this.aop;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + at.w(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoq), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoq), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aor), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
