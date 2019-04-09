package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String ekN = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo ekM = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.ekM != null && this.ekM.getType() == AdvertAppInfo.bwq) {
            return AdvertAppInfo.bww;
        }
        if (this.ekM != null && this.ekM.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bwz;
            switch (this.ekM.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bwA;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bwB;
                case 7:
                    return AdvertAppInfo.bwC;
                case 9:
                    return AdvertAppInfo.bwE;
                case 10:
                    return AdvertAppInfo.bwD;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.ekM != null ? this.ekM.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
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
        return this.ekM;
    }
}
