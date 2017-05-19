package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.widget.vote.a {
    private String adE;
    private long axY;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public k(int i, String str, String str2, long j) {
        this.mId = i;
        this.adE = str;
        this.mUrl = str2;
        this.axY = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void cf(int i) {
        this.mPercent = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BW() {
        return this.adE;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BX() {
        return String.valueOf(this.axY) + TbadkCoreApplication.m9getInst().getString(w.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BY() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(w.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int BZ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ca() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cb() {
        return this.mUrl;
    }
}
