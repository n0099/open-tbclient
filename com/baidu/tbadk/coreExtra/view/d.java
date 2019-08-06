package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int cnN = 0;
    private boolean cnO = false;
    private String labelId = "";
    private int cnP = 0;
    private boolean cnQ = false;
    private int cnR = am.getColor(R.color.cp_btn_a);
    private int cnS = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void jV(int i) {
        this.cnN = i;
    }

    public void pJ(String str) {
        this.labelId = str;
    }
}
