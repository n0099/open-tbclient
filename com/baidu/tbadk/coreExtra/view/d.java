package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int cBD = 0;
    private boolean cBE = false;
    private String labelId = "";
    private int cBF = 0;
    private boolean cBG = false;
    private int cBH = am.getColor(R.color.cp_cont_a);
    private int cBI = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void jv(int i) {
        this.cBD = i;
    }

    public void pe(String str) {
        this.labelId = str;
    }
}
