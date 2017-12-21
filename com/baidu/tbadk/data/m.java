package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.widget.vote.a {
    private long aAX;
    private int aAY;
    private String aff;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public m(int i, String str, String str2, long j) {
        this.mId = i;
        this.aff = str;
        this.mUrl = str2;
        this.aAX = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aAY = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CI() {
        return this.aff;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return this.aAX + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CK() {
        return this.aAY + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CL() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CM() {
        return this.aAY;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CN() {
        return this.mUrl;
    }
}
