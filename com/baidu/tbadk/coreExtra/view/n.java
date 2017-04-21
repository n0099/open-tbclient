package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    private ViewTreeObserver.OnGlobalLayoutListener auc;
    private String labelName = "";
    private int atY = 0;
    private boolean atZ = false;
    private String labelId = "";
    private int aua = 0;
    private boolean aub = false;
    private int aud = aq.getColor(w.e.cp_cont_i);
    private int aue = aq.getColor(w.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void eh(int i) {
        this.atY = i;
    }

    public int Bw() {
        return this.atY;
    }

    public void bm(boolean z) {
        this.atZ = z;
    }

    public boolean Bx() {
        return this.atZ;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String By() {
        return this.labelId;
    }

    public void bn(boolean z) {
        this.aub = z;
    }

    public boolean Bz() {
        return this.aub;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.auc = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener BA() {
        return this.auc;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = String.valueOf(str) + "(" + au.w(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aud), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aud), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aue), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
