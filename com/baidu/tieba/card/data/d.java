package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String azE = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bUH = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bUH != null && this.bUH.getType() == AdvertAppInfo.TS) {
            return AdvertAppInfo.Ub;
        }
        if (this.bUH != null && this.bUH.legoCard != null) {
            return AdvertAppInfo.Ue;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bUH != null ? this.bUH.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aaf() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
    }

    public AdvertAppInfo aag() {
        return this.bUH;
    }
}
