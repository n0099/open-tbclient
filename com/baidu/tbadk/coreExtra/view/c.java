package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private String labelName = "";
    private int ewA = 0;
    private boolean ewB = false;
    private String labelId = "";
    private int ewC = 0;
    private boolean ewD = false;
    private int ewE = ao.getColor(R.color.cp_cont_a);
    private int ewF = ao.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void nD(int i) {
        this.ewA = i;
    }

    public void zb(String str) {
        this.labelId = str;
    }
}
