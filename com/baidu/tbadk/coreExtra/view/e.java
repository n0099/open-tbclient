package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener awm;
    private String labelName = "";
    private int awi = 0;
    private boolean awj = false;
    private String labelId = "";
    private int awk = 0;
    private boolean awl = false;
    private int awn = aj.getColor(d.e.cp_cont_i);
    private int awo = aj.getColor(d.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void el(int i) {
        this.awi = i;
    }

    public int Bj() {
        return this.awi;
    }

    public void bl(boolean z) {
        this.awj = z;
    }

    public boolean Bk() {
        return this.awj;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bl() {
        return this.labelId;
    }

    public void bm(boolean z) {
        this.awl = z;
    }

    public boolean Bm() {
        return this.awl;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.awm = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bn() {
        return this.awm;
    }

    public SpannableStringBuilder al(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awn), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awn), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awo), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
