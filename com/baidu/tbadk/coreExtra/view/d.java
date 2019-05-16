package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private String labelName = "";
    private int cms = 0;
    private boolean cmt = false;
    private String labelId = "";
    private int cmu = 0;
    private boolean cmv = false;
    private int cmw = al.getColor(R.color.cp_btn_a);
    private int cmx = al.getColor(R.color.cp_link_tip_d);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void jO(int i) {
        this.cms = i;
    }

    public void pt(String str) {
        this.labelId = str;
    }
}
