package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String azM = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bUU = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bUU != null && this.bUU.getType() == AdvertAppInfo.TS) {
            return AdvertAppInfo.Ub;
        }
        if (this.bUU != null && this.bUU.legoCard != null) {
            return AdvertAppInfo.Ue;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bUU != null ? this.bUU.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aar() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
    }

    public AdvertAppInfo aas() {
        return this.bUU;
    }
}
