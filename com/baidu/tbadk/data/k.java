package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.widget.vote.a {
    private String aeD;
    private long azH;
    private int azI;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public k(int i, String str, String str2, long j) {
        this.mId = i;
        this.aeD = str;
        this.mUrl = str2;
        this.azH = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.azI = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cd() {
        return this.aeD;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ce() {
        return this.azH + TbadkCoreApplication.getInst().getString(d.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cf() {
        return this.azI + TbadkCoreApplication.getInst().getString(d.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ch() {
        return this.azI;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ci() {
        return this.mUrl;
    }
}
