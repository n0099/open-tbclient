package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eAC = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo eAB = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.eAB != null && this.eAB.getType() == AdvertAppInfo.bDC) {
            return AdvertAppInfo.bDI;
        }
        if (this.eAB != null && this.eAB.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bDL;
            switch (this.eAB.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bDM;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bDN;
                case 7:
                    return AdvertAppInfo.bDO;
                case 9:
                    return AdvertAppInfo.bDQ;
                case 10:
                    return AdvertAppInfo.bDP;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.f(this.eAB != null ? this.eAB.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aYf() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iz(boolean z) {
    }

    public AdvertAppInfo aYg() {
        return this.eAB;
    }
}
