package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.vote.a {
    private String ZC;
    private long asI;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public l(int i, String str, String str2, long j) {
        this.mId = i;
        this.ZC = str;
        this.mUrl = str2;
        this.asI = j;
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
    public String Cj() {
        return this.ZC;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ck() {
        return String.valueOf(this.asI) + TbadkCoreApplication.m9getInst().getString(r.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cl() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(r.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cm() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cn() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Co() {
        return this.mUrl;
    }
}
