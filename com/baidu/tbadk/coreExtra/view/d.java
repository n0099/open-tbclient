package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int coI = 0;
    private boolean coJ = false;
    private String labelId = "";
    private int coK = 0;
    private boolean coL = false;
    private int coM = am.getColor(R.color.cp_cont_a);
    private int coN = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void jY(int i) {
        this.coI = i;
    }

    public void pU(String str) {
        this.labelId = str;
    }
}
