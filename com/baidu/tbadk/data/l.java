package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.vote.a {
    private long aAq;
    private int aAr;
    private String afh;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public l(int i, String str, String str2, long j) {
        this.mId = i;
        this.afh = str;
        this.mUrl = str2;
        this.aAq = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ck(int i) {
        this.aAr = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cz() {
        return this.afh;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CA() {
        return this.aAq + TbadkCoreApplication.getInst().getString(d.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CB() {
        return this.aAr + TbadkCoreApplication.getInst().getString(d.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CC() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CD() {
        return this.aAr;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return this.mUrl;
    }
}
