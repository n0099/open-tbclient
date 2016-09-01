package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener apf;
    private String labelName = "";
    private int apb = 0;
    private boolean apc = false;
    private String labelId = "";
    private int apd = 0;
    private boolean ape = false;
    private int apg = av.getColor(t.d.cp_cont_i);
    private int aph = av.getColor(t.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ef(int i) {
        this.apb = i;
    }

    public int AM() {
        return this.apb;
    }

    public void bi(boolean z) {
        this.apc = z;
    }

    public boolean AN() {
        return this.apc;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AO() {
        return this.labelId;
    }

    public void bj(boolean z) {
        this.ape = z;
    }

    public boolean AP() {
        return this.ape;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.apf = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AQ() {
        return this.apf;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ba.y(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apg), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apg), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aph), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
