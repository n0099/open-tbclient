package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private String labelName = "";
    private int bmX = 0;
    private boolean bmY = false;
    private String labelId = "";
    private int bmZ = 0;
    private boolean bna = false;
    private int bnb = aj.getColor(d.C0141d.cp_cont_i);
    private int bnc = aj.getColor(d.C0141d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ho(int i) {
        this.bmX = i;
    }

    public int Jk() {
        return this.bmX;
    }

    public void fL(String str) {
        this.labelId = str;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = str + "(" + am.H(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bnb), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bnb), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bnc), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
