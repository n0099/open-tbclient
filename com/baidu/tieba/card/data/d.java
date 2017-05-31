package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String bur = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bDc = null;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bDc != null && this.bDc.legoCard != null) {
            return AdvertAppInfo.SW;
        }
        if (this.bDc != null && this.bDc.getType() == AdvertAppInfo.SK) {
            return AdvertAppInfo.ST;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bDc != null ? this.bDc.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean UG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void du(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dv(boolean z) {
    }

    public AdvertAppInfo UH() {
        return this.bDc;
    }
}
