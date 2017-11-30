package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private ViewTreeObserver.OnGlobalLayoutListener awr;
    private String labelName = "";
    private int awn = 0;
    private boolean awo = false;
    private String labelId = "";
    private int awp = 0;
    private boolean awq = false;
    private int aws = aj.getColor(d.C0082d.cp_cont_i);
    private int awt = aj.getColor(d.C0082d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ev(int i) {
        this.awn = i;
    }

    public int Bg() {
        return this.awn;
    }

    public void bi(boolean z) {
        this.awo = z;
    }

    public boolean Bh() {
        return this.awo;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public String Bi() {
        return this.labelId;
    }

    public void bj(boolean z) {
        this.awq = z;
    }

    public boolean Bj() {
        return this.awq;
    }

    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.awr = onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnGlobalLayoutListener Bk() {
        return this.awr;
    }

    public SpannableStringBuilder al(String str, String str2) {
        String str3 = str + "(" + am.y(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aws), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aws), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.awt), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
