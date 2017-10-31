package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener avI;
    private String labelName = "";
    private int avE = 0;
    private boolean avF = false;
    private String labelId = "";
    private int avG = 0;
    private boolean avH = false;
    private int avJ = aj.getColor(d.C0080d.cp_cont_i);
    private int avK = aj.getColor(d.C0080d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ev(int i) {
        this.avE = i;
    }

    public int AK() {
        return this.avE;
    }

    public void bh(boolean z) {
        this.avF = z;
    }

    public boolean AL() {
        return this.avF;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AM() {
        return this.labelId;
    }

    public void bi(boolean z) {
        this.avH = z;
    }

    public boolean AN() {
        return this.avH;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.avI = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AO() {
        return this.avI;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avJ), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avJ), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avK), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
