package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.vote.a {
    private String aem;
    private long ayb;
    private boolean isSelected = false;
    private int mId;
    private int mPercent;
    private String mUrl;

    public l(int i, String str, String str2, long j) {
        this.mId = i;
        this.aem = str;
        this.mUrl = str2;
        this.ayb = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void ch(int i) {
        this.mPercent = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CR() {
        return this.aem;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CS() {
        return String.valueOf(this.ayb) + TbadkCoreApplication.m9getInst().getString(w.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CT() {
        return String.valueOf(this.mPercent) + TbadkCoreApplication.m9getInst().getString(w.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CU() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CV() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CW() {
        return this.mUrl;
    }
}
