package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.vote.a {
    private String adX;
    private long axJ;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public l(int i, String str, String str2, long j) {
        this.mId = i;
        this.adX = str;
        this.mUrl = str2;
        this.axJ = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ce(int i) {
        this.mPercent = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ct() {
        return this.adX;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cu() {
        return String.valueOf(this.axJ) + TbadkCoreApplication.m9getInst().getString(w.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cv() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(w.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cw() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cx() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cy() {
        return this.mUrl;
    }
}
