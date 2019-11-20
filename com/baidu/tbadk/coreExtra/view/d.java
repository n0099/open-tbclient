package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int cAM = 0;
    private boolean cAN = false;
    private String labelId = "";
    private int cAO = 0;
    private boolean cAP = false;
    private int cAQ = am.getColor(R.color.cp_cont_a);
    private int cAR = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void ju(int i) {
        this.cAM = i;
    }

    public void pe(String str) {
        this.labelId = str;
    }
}
