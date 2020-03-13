package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String emo = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo fML = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.fML != null && this.fML.getType() == AdvertAppInfo.cMG) {
            return AdvertAppInfo.cMM;
        }
        if (this.fML != null && this.fML.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.cMP;
            switch (this.fML.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.cMQ;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.cMR;
                case 7:
                    return AdvertAppInfo.cMS;
                case 9:
                    return AdvertAppInfo.cMU;
                case 10:
                    return AdvertAppInfo.cMT;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.fML != null ? this.fML.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvx() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
    }

    public AdvertAppInfo bvy() {
        return this.fML;
    }
}
