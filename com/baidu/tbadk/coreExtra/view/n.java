package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener alj;
    private String labelName = "";
    private int alf = 0;
    private boolean alg = false;
    private String labelId = "";
    private int alh = 0;
    private boolean ali = false;
    private int alk = av.getColor(u.d.cp_cont_i);
    private int alm = av.getColor(u.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dR(int i) {
        this.alf = i;
    }

    public int zx() {
        return this.alf;
    }

    public void bd(boolean z) {
        this.alg = z;
    }

    public boolean zy() {
        return this.alg;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String zz() {
        return this.labelId;
    }

    public void be(boolean z) {
        this.ali = z;
    }

    public boolean zA() {
        return this.ali;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.alj = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener zB() {
        return this.alj;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ba.D(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.alk), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.alk), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.alm), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
