package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class b {
    private String labelName = "";
    private int aLq = 0;
    private boolean aLr = false;
    private String labelId = "";
    private int aLs = 0;
    private boolean aLt = false;
    private int aLu = al.getColor(e.d.cp_cont_i);
    private int aLv = al.getColor(e.d.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void eH(int i) {
        this.aLq = i;
    }

    public void gA(String str) {
        this.labelId = str;
    }
}
