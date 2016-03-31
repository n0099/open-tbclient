package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener aoP;
    private String labelName = "";
    private int aoL = 0;
    private boolean aoM = false;
    private String labelId = "";
    private int aoN = 0;
    private boolean aoO = false;
    private int aoQ = at.getColor(t.d.cp_cont_i);
    private int aoR = at.getColor(t.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ek(int i) {
        this.aoL = i;
    }

    public int Bx() {
        return this.aoL;
    }

    public void ba(boolean z) {
        this.aoM = z;
    }

    public boolean By() {
        return this.aoM;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bz() {
        return this.labelId;
    }

    public void bb(boolean z) {
        this.aoO = z;
    }

    public boolean BA() {
        return this.aoO;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.aoP = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener BB() {
        return this.aoP;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ay.A(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoQ), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoQ), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aoR), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
