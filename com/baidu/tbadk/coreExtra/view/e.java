package com.baidu.tbadk.coreExtra.view;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private String labelName = "";
    private int bkK = 0;
    private boolean bkL = false;
    private String labelId = "";
    private int bkM = 0;
    private boolean bkN = false;
    private int bkO = aj.getColor(d.C0107d.cp_cont_i);
    private int bkP = aj.getColor(d.C0107d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void hp(int i) {
        this.bkK = i;
    }

    public int IC() {
        return this.bkK;
    }

    public void fu(String str) {
        this.labelId = str;
    }

    public SpannableStringBuilder ak(String str, String str2) {
        String str3 = str + "(" + am.H(com.baidu.adp.lib.g.b.c(str2, 0L)) + ")";
        if (com.baidu.adp.lib.g.b.c(str2, 0L) > 0) {
            str = str3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (com.baidu.adp.lib.g.b.c(str2, 0L) <= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkO), 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf("(");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkO), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bkP), indexOf, str.length(), 33);
        }
        return spannableStringBuilder;
    }
}
