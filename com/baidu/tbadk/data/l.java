package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.vote.a {
    private long aBd;
    private String afV;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public l(int i, String str, String str2, long j) {
        this.mId = i;
        this.afV = str;
        this.mUrl = str2;
        this.aBd = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ck(int i) {
        this.mPercent = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return this.afV;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CF() {
        return this.aBd + TbadkCoreApplication.getInst().getString(d.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CG() {
        return this.mPercent + TbadkCoreApplication.getInst().getString(d.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CH() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CI() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return this.mUrl;
    }
}
