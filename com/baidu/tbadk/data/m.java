package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.widget.vote.a {
    private long aAP;
    private int aAQ;
    private String afi;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public m(int i, String str, String str2, long j) {
        this.mId = i;
        this.afi = str;
        this.mUrl = str2;
        this.aAP = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aAQ = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CH() {
        return this.afi;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CI() {
        return this.aAP + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return this.aAQ + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CK() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CL() {
        return this.aAQ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CM() {
        return this.mUrl;
    }
}
