package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int dTo = 0;
    private boolean dTp = false;
    private String labelId = "";
    private int dTq = 0;
    private boolean dTr = false;
    private int dTs = am.getColor(R.color.cp_cont_a);
    private int dTt = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void mn(int i) {
        this.dTo = i;
    }

    public void vW(String str) {
        this.labelId = str;
    }
}
