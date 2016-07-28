package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener alZ;
    private String labelName = "";
    private int alV = 0;
    private boolean alW = false;
    private String labelId = "";
    private int alX = 0;
    private boolean alY = false;
    private int ama = av.getColor(u.d.cp_cont_i);
    private int amb = av.getColor(u.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void dR(int i) {
        this.alV = i;
    }

    public int zx() {
        return this.alV;
    }

    public void bg(boolean z) {
        this.alW = z;
    }

    public boolean zy() {
        return this.alW;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String zz() {
        return this.labelId;
    }

    public void bh(boolean z) {
        this.alY = z;
    }

    public boolean zA() {
        return this.alY;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.alZ = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener zB() {
        return this.alZ;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + ba.y(com.baidu.adp.lib.h.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.h.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.h.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ama), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ama), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.amb), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
