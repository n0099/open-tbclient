package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class b {
    private String labelName = "";
    private int aIa = 0;
    private boolean aIb = false;
    private String labelId = "";
    private int aIc = 0;
    private boolean aId = false;
    private int aIe = am.getColor(f.d.cp_cont_i);
    private int aIf = am.getColor(f.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void ev(int i) {
        this.aIa = i;
    }

    public void gd(String str) {
        this.labelId = str;
    }
}
