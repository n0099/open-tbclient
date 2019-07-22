package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int cnG = 0;
    private boolean cnH = false;
    private String labelId = "";
    private int cnI = 0;
    private boolean cnJ = false;
    private int cnK = am.getColor(R.color.cp_btn_a);
    private int cnL = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void jU(int i) {
        this.cnG = i;
    }

    public void pJ(String str) {
        this.labelId = str;
    }
}
