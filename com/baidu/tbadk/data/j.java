package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.widget.vote.a {
    private int aRE;
    private String aUL;
    private long brm;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public j(int i, String str, String str2, long j) {
        this.mId = i;
        this.aUL = str;
        this.mUrl = str2;
        this.brm = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.aRE = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KF() {
        return this.aUL;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KG() {
        return this.brm + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KH() {
        return this.aRE + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KI() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KJ() {
        return this.aRE;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KK() {
        return this.mUrl;
    }
}
