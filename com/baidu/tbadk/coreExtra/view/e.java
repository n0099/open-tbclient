package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private String labelName = "";
    private int bmU = 0;
    private boolean bmV = false;
    private String labelId = "";
    private int bmW = 0;
    private boolean bmX = false;
    private int bmY = aj.getColor(d.C0141d.cp_cont_i);
    private int bmZ = aj.getColor(d.C0141d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ho(int i) {
        this.bmU = i;
    }

    public int Jj() {
        return this.bmU;
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
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bmY), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bmY), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bmZ), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
