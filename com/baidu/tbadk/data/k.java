package com.baidu.tbadk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.widget.vote.a {
    private String aer;
    private long azv;
    private int azw;
    private boolean isSelected = false;
    private int mId;
    private String mUrl;

    public k(int i, String str, String str2, long j) {
        this.mId = i;
        this.aer = str;
        this.mUrl = str2;
        this.azv = j;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setPercent(int i) {
        this.azw = i;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BX() {
        return this.aer;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BY() {
        return this.azv + TbadkCoreApplication.getInst().getString(d.l.vote_unit);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BZ() {
        return this.azw + TbadkCoreApplication.getInst().getString(d.l.vote_percent);
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ca() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cb() {
        return this.azw;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cc() {
        return this.mUrl;
    }
}
