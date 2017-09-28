package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String azf = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bNp = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bNp != null && this.bNp.getType() == AdvertAppInfo.TL) {
            return AdvertAppInfo.TV;
        }
        if (this.bNp != null && this.bNp.legoCard != null) {
            return AdvertAppInfo.TY;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bNp != null ? this.bNp.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XZ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dE(boolean z) {
    }

    public AdvertAppInfo Ya() {
        return this.bNp;
    }
}
