package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener avk;
    private String labelName = "";
    private int avg = 0;
    private boolean avh = false;
    private String labelId = "";
    private int avi = 0;
    private boolean avj = false;
    private int avl = aj.getColor(d.e.cp_cont_i);
    private int avm = aj.getColor(d.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void eu(int i) {
        this.avg = i;
    }

    public int AB() {
        return this.avg;
    }

    public void bj(boolean z) {
        this.avh = z;
    }

    public boolean AC() {
        return this.avh;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String AD() {
        return this.labelId;
    }

    public void bk(boolean z) {
        this.avj = z;
    }

    public boolean AE() {
        return this.avj;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.avk = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener AF() {
        return this.avk;
    }

    public SpannableStringBuilder al(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avl), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avl), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.avm), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
