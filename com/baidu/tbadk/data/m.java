package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.widget.vote.a {
    private String aaa;
    private long atD;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public m(int i, String str, String str2, long j) {
        this.mId = i;
        this.aaa = str;
        this.mUrl = str2;
        this.atD = j;
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
    public String Cr() {
        return this.aaa;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cs() {
        return String.valueOf(this.atD) + TbadkCoreApplication.m9getInst().getString(r.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ct() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(r.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cu() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cv() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cw() {
        return this.mUrl;
    }
}
