package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener avQ;
    private String labelName = "";
    private int avM = 0;
    private boolean avN = false;
    private String labelId = "";
    private int avO = 0;
    private boolean avP = false;
    private int avR = aj.getColor(d.C0080d.cp_cont_i);
    private int avS = aj.getColor(d.C0080d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void eu(int i) {
        this.avM = i;
    }

    public int AW() {
        return this.avM;
    }

    public void bi(boolean z) {
        this.avN = z;
    }

    public boolean AX() {
        return this.avN;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AY() {
        return this.labelId;
    }

    public void bj(boolean z) {
        this.avP = z;
    }

    public boolean AZ() {
        return this.avP;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.avQ = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Ba() {
        return this.avQ;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avR), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avR), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avS), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
