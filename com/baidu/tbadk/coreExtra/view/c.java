package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private String labelName = "";
    private int eJl = 0;
    private boolean eJm = false;
    private String labelId = "";
    private int eJn = 0;
    private boolean eJo = false;
    private int eJp = ap.getColor(R.color.cp_cont_a);
    private int eJq = ap.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void qb(int i) {
        this.eJl = i;
    }

    public void BO(String str) {
        this.labelId = str;
    }
}
