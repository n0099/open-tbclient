package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener apj;
    private String labelName = "";
    private int apf = 0;
    private boolean apg = false;
    private String labelId = "";
    private int aph = 0;
    private boolean api = false;
    private int apk = ar.getColor(r.d.cp_cont_i);
    private int apl = ar.getColor(r.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ei(int i) {
        this.apf = i;
    }

    public int AJ() {
        return this.apf;
    }

    public void bl(boolean z) {
        this.apg = z;
    }

    public boolean AK() {
        return this.apg;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AL() {
        return this.labelId;
    }

    public void bm(boolean z) {
        this.api = z;
    }

    public boolean AM() {
        return this.api;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.apj = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AN() {
        return this.apj;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + av.y(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apk), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apk), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apl), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
