package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.widget.vote.a {
    private String aTs;
    private long bpl;
    private int bpm;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public j(int i, String str, String str2, long j) {
        this.mId = i;
        this.aTs = str;
        this.mUrl = str2;
        this.bpl = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.bpm = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ka() {
        return this.aTs;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kb() {
        return this.bpl + TbadkCoreApplication.getInst().getString(d.j.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kc() {
        return this.bpm + TbadkCoreApplication.getInst().getString(d.j.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kd() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ke() {
        return this.bpm;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kf() {
        return this.mUrl;
    }
}
