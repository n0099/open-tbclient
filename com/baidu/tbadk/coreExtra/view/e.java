package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private String labelName = "";
    private int bkS = 0;
    private boolean bkT = false;
    private String labelId = "";
    private int bkU = 0;
    private boolean bkV = false;
    private int bkW = aj.getColor(d.C0108d.cp_cont_i);
    private int bkX = aj.getColor(d.C0108d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void hp(int i) {
        this.bkS = i;
    }

    public int IE() {
        return this.bkS;
    }

    public void fB(String str) {
        this.labelId = str;
    }

    public SpannableStringBuilder aj(String str, String str2) {
        String str3 = str + "(" + am.H(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkW), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkW), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkX), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
