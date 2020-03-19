package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int dto = 0;
    private boolean dtp = false;
    private String labelId = "";
    private int dtq = 0;
    private boolean dtr = false;
    private int dts = am.getColor(R.color.cp_cont_a);
    private int dtt = am.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void mb(int i) {
        this.dto = i;
    }

    public void uF(String str) {
        this.labelId = str;
    }
}
