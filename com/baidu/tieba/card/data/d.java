package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String aAB = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bJr = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bJr != null && this.bJr.getType() == AdvertAppInfo.Us) {
            return AdvertAppInfo.UC;
        }
        if (this.bJr != null && this.bJr.legoCard != null) {
            return AdvertAppInfo.UF;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bJr != null ? this.bJr.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean WK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dF(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    public AdvertAppInfo WL() {
        return this.bJr;
    }
}
