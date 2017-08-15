package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener axd;
    private String labelName = "";
    private int awZ = 0;
    private boolean axa = false;
    private String labelId = "";
    private int axb = 0;
    private boolean axc = false;
    private int axe = ai.getColor(d.e.cp_cont_i);
    private int axf = ai.getColor(d.e.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void em(int i) {
        this.awZ = i;
    }

    public int Bo() {
        return this.awZ;
    }

    public void bm(boolean z) {
        this.axa = z;
    }

    public boolean Bp() {
        return this.axa;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bq() {
        return this.labelId;
    }

    public void bn(boolean z) {
        this.axc = z;
    }

    public boolean Br() {
        return this.axc;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.axd = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bs() {
        return this.axd;
    }

    public SpannableStringBuilder ai(String str, String str2) {
        String str3 = str + "(" + al.z(com.baidu.adp.lib.g.b.d(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.d(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.d(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.axe), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.axe), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.axf), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
