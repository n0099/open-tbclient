package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String aAD = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bKb = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bKb != null && this.bKb.getType() == AdvertAppInfo.Uv) {
            return AdvertAppInfo.UF;
        }
        if (this.bKb != null && this.bKb.legoCard != null) {
            return AdvertAppInfo.UI;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bKb != null ? this.bKb.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Xd() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
    }

    public AdvertAppInfo Xe() {
        return this.bKb;
    }
}
