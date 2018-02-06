package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private String labelName = "";
    private int bnh = 0;
    private boolean bni = false;
    private String labelId = "";
    private int bnj = 0;
    private boolean bnk = false;
    private int bnl = aj.getColor(d.C0140d.cp_cont_i);
    private int bnm = aj.getColor(d.C0140d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void ho(int i) {
        this.bnh = i;
    }

    public int Jk() {
        return this.bnh;
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
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bnl), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bnl), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bnm), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
