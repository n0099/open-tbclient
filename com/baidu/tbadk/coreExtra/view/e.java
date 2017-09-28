package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener avw;
    private String labelName = "";
    private int avs = 0;
    private boolean avt = false;
    private String labelId = "";
    private int avu = 0;
    private boolean avv = false;
    private int avx = aj.getColor(d.e.cp_cont_i);
    private int avy = aj.getColor(d.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ev(int i) {
        this.avs = i;
    }

    public int AH() {
        return this.avs;
    }

    public void bk(boolean z) {
        this.avt = z;
    }

    public boolean AI() {
        return this.avt;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AJ() {
        return this.labelId;
    }

    public void bl(boolean z) {
        this.avv = z;
    }

    public boolean AK() {
        return this.avv;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.avw = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AL() {
        return this.avw;
    }

    public SpannableStringBuilder am(String str, String str2) {
        String str3 = str + "(" + am.x(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avx), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avx), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avy), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
