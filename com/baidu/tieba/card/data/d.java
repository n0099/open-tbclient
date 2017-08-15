package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String aAC = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bKa = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bKa != null && this.bKa.getType() == AdvertAppInfo.Uu) {
            return AdvertAppInfo.UE;
        }
        if (this.bKa != null && this.bKa.legoCard != null) {
            return AdvertAppInfo.UH;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bKa != null ? this.bKa.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Xg() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
    }

    public AdvertAppInfo Xh() {
        return this.bKa;
    }
}
