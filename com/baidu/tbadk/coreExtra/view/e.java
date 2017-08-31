package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener awp;
    private String labelName = "";
    private int awl = 0;
    private boolean awm = false;
    private String labelId = "";
    private int awn = 0;
    private boolean awo = false;
    private int awq = aj.getColor(d.e.cp_cont_i);
    private int awr = aj.getColor(d.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void el(int i) {
        this.awl = i;
    }

    public int Bj() {
        return this.awl;
    }

    public void bl(boolean z) {
        this.awm = z;
    }

    public boolean Bk() {
        return this.awm;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bl() {
        return this.labelId;
    }

    public void bm(boolean z) {
        this.awo = z;
    }

    public boolean Bm() {
        return this.awo;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.awp = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bn() {
        return this.awp;
    }

    public SpannableStringBuilder al(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awq), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awq), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awr), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
