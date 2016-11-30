package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener apI;
    private String labelName = "";
    private int apE = 0;
    private boolean apF = false;
    private String labelId = "";
    private int apG = 0;
    private boolean apH = false;
    private int apJ = at.getColor(r.d.cp_cont_i);
    private int apK = at.getColor(r.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void eh(int i) {
        this.apE = i;
    }

    public int AW() {
        return this.apE;
    }

    public void bl(boolean z) {
        this.apF = z;
    }

    public boolean AX() {
        return this.apF;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AY() {
        return this.labelId;
    }

    public void bm(boolean z) {
        this.apH = z;
    }

    public boolean AZ() {
        return this.apH;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.apI = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Ba() {
        return this.apI;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ax.y(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apJ), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apJ), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.apK), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
