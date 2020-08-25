package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes2.dex */
public class e extends b implements q {
    public String eVt = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo hmD = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.hmD != null && this.hmD.getType() == AdvertAppInfo.dVO) {
            return AdvertAppInfo.dVU;
        }
        if (this.hmD != null && this.hmD.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dVX;
            switch (this.hmD.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dVY;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dVZ;
                case 7:
                case 14:
                    return AdvertAppInfo.dWa;
                case 12:
                    return AdvertAppInfo.dWc;
                case 13:
                    return AdvertAppInfo.dWb;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.hmD != null ? this.hmD.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccq() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nn(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void no(boolean z) {
    }

    public AdvertAppInfo ccr() {
        return this.hmD;
    }
}
