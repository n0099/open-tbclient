package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private String labelName = "";
    private int fzU = 0;
    private boolean fzV = false;
    private String labelId = "";
    private int fzW = 0;
    private boolean fzX = false;
    private int fzY = ao.getColor(R.color.CAM_X0101);
    private int fzZ = ao.getColor(R.color.CAM_X0305);

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void sf(int i) {
        this.fzU = i;
    }

    public void Dl(String str) {
        this.labelId = str;
    }
}
