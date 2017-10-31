package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.widget.vote.a {
    private long aAg;
    private int aAh;
    private String aeM;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public m(int i, String str, String str2, long j) {
        this.mId = i;
        this.aeM = str;
        this.mUrl = str2;
        this.aAg = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aAh = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cm() {
        return this.aeM;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cn() {
        return this.aAg + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Co() {
        return this.aAh + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cp() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cq() {
        return this.aAh;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cr() {
        return this.mUrl;
    }
}
