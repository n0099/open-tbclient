package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.vote.a {
    private String Zp;
    private long asX;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public l(int i, String str, String str2, long j) {
        this.mId = i;
        this.Zp = str;
        this.mUrl = str2;
        this.asX = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.mPercent = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cg() {
        return this.Zp;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ch() {
        return String.valueOf(this.asX) + TbadkCoreApplication.m9getInst().getString(t.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ci() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(t.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cj() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ck() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cl() {
        return this.mUrl;
    }
}
