package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String ekM = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo ekL = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.ekL != null && this.ekL.getType() == AdvertAppInfo.bwp) {
            return AdvertAppInfo.bwv;
        }
        if (this.ekL != null && this.ekL.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bwy;
            switch (this.ekL.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bwz;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bwA;
                case 7:
                    return AdvertAppInfo.bwB;
                case 9:
                    return AdvertAppInfo.bwD;
                case 10:
                    return AdvertAppInfo.bwC;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.ekL != null ? this.ekL.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQT() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
    }

    public AdvertAppInfo aQU() {
        return this.ekL;
    }
}
