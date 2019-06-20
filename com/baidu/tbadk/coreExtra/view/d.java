package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int cmt = 0;
    private boolean cmu = false;
    private String labelId = "";
    private int cmv = 0;
    private boolean cmw = false;
    private int cmx = al.getColor(R.color.cp_btn_a);
    private int cmy = al.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void jO(int i) {
        this.cmt = i;
    }

    public void ps(String str) {
        this.labelId = str;
    }
}
