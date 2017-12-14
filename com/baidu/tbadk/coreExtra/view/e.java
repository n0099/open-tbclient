package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener aww;
    private String labelName = "";
    private int aws = 0;
    private boolean awt = false;
    private String labelId = "";
    private int awu = 0;
    private boolean awv = false;
    private int awx = aj.getColor(d.C0096d.cp_cont_i);
    private int awy = aj.getColor(d.C0096d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ev(int i) {
        this.aws = i;
    }

    public int Bh() {
        return this.aws;
    }

    public void bj(boolean z) {
        this.awt = z;
    }

    public boolean Bi() {
        return this.awt;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bj() {
        return this.labelId;
    }

    public void bk(boolean z) {
        this.awv = z;
    }

    public boolean Bk() {
        return this.awv;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.aww = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bl() {
        return this.aww;
    }

    public SpannableStringBuilder al(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awx), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awx), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awy), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
