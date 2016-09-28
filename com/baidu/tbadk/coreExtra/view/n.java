package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener aoN;
    private String labelName = "";
    private int aoJ = 0;
    private boolean aoK = false;
    private String labelId = "";
    private int aoL = 0;
    private boolean aoM = false;
    private int aoO = av.getColor(r.d.cp_cont_i);
    private int aoP = av.getColor(r.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ef(int i) {
        this.aoJ = i;
    }

    public int AP() {
        return this.aoJ;
    }

    public void bh(boolean z) {
        this.aoK = z;
    }

    public boolean AQ() {
        return this.aoK;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AR() {
        return this.labelId;
    }

    public void bi(boolean z) {
        this.aoM = z;
    }

    public boolean AS() {
        return this.aoM;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.aoN = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AT() {
        return this.aoN;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + az.z(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoO), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoO), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoP), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
