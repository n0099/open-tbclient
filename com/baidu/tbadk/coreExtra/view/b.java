package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class b {
    private String labelName = "";
    private int aUk = 0;
    private boolean aUl = false;
    private String labelId = "";
    private int aUm = 0;
    private boolean aUn = false;
    private int aUo = al.getColor(e.d.cp_cont_i);
    private int aUp = al.getColor(e.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void ft(int i) {
        this.aUk = i;
    }

    public void hi(String str) {
        this.labelId = str;
    }
}
