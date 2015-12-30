package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class o {
    private ViewTreeObserver.OnGlobalLayoutListener anF;
    private String labelName = "";
    private int anB = 0;
    private boolean anC = false;
    private String labelId = "";
    private int anD = 0;
    private boolean anE = false;
    private int anG = as.getColor(n.d.cp_cont_i);
    private int anH = as.getColor(n.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dM(int i) {
        this.anB = i;
    }

    public int zC() {
        return this.anB;
    }

    public void aS(boolean z) {
        this.anC = z;
    }

    public boolean zD() {
        return this.anC;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String zE() {
        return this.labelId;
    }

    public void aT(boolean z) {
        this.anE = z;
    }

    public boolean zF() {
        return this.anE;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.anF = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener zG() {
        return this.anF;
    }

    public SpannableStringBuilder ag(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ax.x(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.anG), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.anG), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.anH), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
