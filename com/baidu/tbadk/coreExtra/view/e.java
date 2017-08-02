package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener avL;
    private String labelName = "";
    private int avH = 0;
    private boolean avI = false;
    private String labelId = "";
    private int avJ = 0;
    private boolean avK = false;
    private int avM = ai.getColor(d.e.cp_cont_i);
    private int avN = ai.getColor(d.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ek(int i) {
        this.avH = i;
    }

    public int Bg() {
        return this.avH;
    }

    public void bm(boolean z) {
        this.avI = z;
    }

    public boolean Bh() {
        return this.avI;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bi() {
        return this.labelId;
    }

    public void bn(boolean z) {
        this.avK = z;
    }

    public boolean Bj() {
        return this.avK;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.avL = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bk() {
        return this.avL;
    }

    public SpannableStringBuilder ai(String str, String str2) {
        String str3 = str + "(" + al.z(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avM), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avM), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avN), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
