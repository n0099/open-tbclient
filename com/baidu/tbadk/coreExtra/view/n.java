package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener aoy;
    private String labelName = "";
    private int aou = 0;
    private boolean aov = false;
    private String labelId = "";
    private int aow = 0;
    private boolean aox = false;
    private int aoz = ar.getColor(t.d.cp_cont_i);
    private int aoA = ar.getColor(t.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void eh(int i) {
        this.aou = i;
    }

    public int AU() {
        return this.aou;
    }

    public void aU(boolean z) {
        this.aov = z;
    }

    public boolean AV() {
        return this.aov;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AW() {
        return this.labelId;
    }

    public void aV(boolean z) {
        this.aox = z;
    }

    public boolean AX() {
        return this.aox;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.aoy = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AY() {
        return this.aoy;
    }

    public SpannableStringBuilder ag(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + aw.y(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoz), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoz), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoA), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
