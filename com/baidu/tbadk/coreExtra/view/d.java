package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int dsO = 0;
    private boolean dsP = false;
    private String labelId = "";
    private int dsQ = 0;
    private boolean dsR = false;
    private int dsS = am.getColor(R.color.cp_cont_a);
    private int dsT = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void lZ(int i) {
        this.dsO = i;
    }

    public void uE(String str) {
        this.labelId = str;
    }
}
