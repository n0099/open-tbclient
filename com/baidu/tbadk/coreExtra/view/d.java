package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int dtb = 0;
    private boolean dtc = false;
    private String labelId = "";
    private int dtd = 0;
    private boolean dte = false;
    private int dtf = am.getColor(R.color.cp_cont_a);
    private int dtg = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void lZ(int i) {
        this.dtb = i;
    }

    public void uF(String str) {
        this.labelId = str;
    }
}
