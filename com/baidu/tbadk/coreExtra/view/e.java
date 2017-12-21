package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener awz;
    private String labelName = "";
    private int awv = 0;
    private boolean aww = false;
    private String labelId = "";
    private int awx = 0;
    private boolean awy = false;
    private int awA = aj.getColor(d.C0095d.cp_cont_i);
    private int awB = aj.getColor(d.C0095d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ev(int i) {
        this.awv = i;
    }

    public int Bh() {
        return this.awv;
    }

    public void bj(boolean z) {
        this.aww = z;
    }

    public boolean Bi() {
        return this.aww;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bj() {
        return this.labelId;
    }

    public void bk(boolean z) {
        this.awy = z;
    }

    public boolean Bk() {
        return this.awy;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.awz = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bl() {
        return this.awz;
    }

    public SpannableStringBuilder al(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awA), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awA), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awB), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
