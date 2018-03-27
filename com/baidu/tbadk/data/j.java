package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.widget.vote.a {
    private int aRG;
    private String aUN;
    private long brp;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public j(int i, String str, String str2, long j) {
        this.mId = i;
        this.aUN = str;
        this.mUrl = str2;
        this.brp = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aRG = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KG() {
        return this.aUN;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KH() {
        return this.brp + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KI() {
        return this.aRG + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KJ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KK() {
        return this.aRG;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KL() {
        return this.mUrl;
    }
}
