package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int dsN = 0;
    private boolean dsO = false;
    private String labelId = "";
    private int dsP = 0;
    private boolean dsQ = false;
    private int dsR = am.getColor(R.color.cp_cont_a);
    private int dsS = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void lZ(int i) {
        this.dsN = i;
    }

    public void uE(String str) {
        this.labelId = str;
    }
}
