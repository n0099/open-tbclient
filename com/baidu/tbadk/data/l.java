package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.vote.a {
    private String YI;
    private long aso;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public l(int i, String str, String str2, long j) {
        this.mId = i;
        this.YI = str;
        this.mUrl = str2;
        this.aso = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ci(int i) {
        this.mPercent = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ca() {
        return this.YI;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cb() {
        return String.valueOf(this.aso) + TbadkCoreApplication.m9getInst().getString(r.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cc() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(r.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cd() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ce() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cf() {
        return this.mUrl;
    }
}
