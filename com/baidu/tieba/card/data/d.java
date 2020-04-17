package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eQf = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo gsa = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.gsa != null && this.gsa.getType() == AdvertAppInfo.dlX) {
            return AdvertAppInfo.dmd;
        }
        if (this.gsa != null && this.gsa.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dmg;
            switch (this.gsa.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dmh;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dmi;
                case 7:
                    return AdvertAppInfo.dmj;
                case 12:
                    return AdvertAppInfo.dml;
                case 13:
                    return AdvertAppInfo.dmk;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.gsa != null ? this.gsa.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bFn() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void lB(boolean z) {
    }

    public AdvertAppInfo bFo() {
        return this.gsa;
    }
}
