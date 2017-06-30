package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener auT;
    private String labelName = "";
    private int auP = 0;
    private boolean auQ = false;
    private String labelId = "";
    private int auR = 0;
    private boolean auS = false;
    private int auU = as.getColor(w.e.cp_cont_i);
    private int auV = as.getColor(w.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ei(int i) {
        this.auP = i;
    }

    public int AV() {
        return this.auP;
    }

    public void bk(boolean z) {
        this.auQ = z;
    }

    public boolean AW() {
        return this.auQ;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AX() {
        return this.labelId;
    }

    public void bl(boolean z) {
        this.auS = z;
    }

    public boolean AY() {
        return this.auS;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.auT = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AZ() {
        return this.auT;
    }

    public SpannableStringBuilder ai(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + aw.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.auU), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.auU), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.auV), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
