package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int dTj = 0;
    private boolean dTk = false;
    private String labelId = "";
    private int dTl = 0;
    private boolean dTm = false;
    private int dTn = am.getColor(R.color.cp_cont_a);
    private int dTo = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void mn(int i) {
        this.dTj = i;
    }

    public void vT(String str) {
        this.labelId = str;
    }
}
