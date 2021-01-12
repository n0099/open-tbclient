package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private String labelName = "";
    private int fvm = 0;
    private boolean fvn = false;
    private String labelId = "";
    private int fvo = 0;
    private boolean fvp = false;
    private int fvq = ao.getColor(R.color.CAM_X0101);
    private int fvr = ao.getColor(R.color.CAM_X0305);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void qz(int i) {
        this.fvm = i;
    }

    public void Ca(String str) {
        this.labelId = str;
    }
}
