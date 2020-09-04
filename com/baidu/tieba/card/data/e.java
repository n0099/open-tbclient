package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class e extends b implements q {
    public String eVx = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo hmH = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.hmH != null && this.hmH.getType() == AdvertAppInfo.dVS) {
            return AdvertAppInfo.dVY;
        }
        if (this.hmH != null && this.hmH.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dWb;
            switch (this.hmH.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dWc;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dWd;
                case 7:
                case 14:
                    return AdvertAppInfo.dWe;
                case 12:
                    return AdvertAppInfo.dWg;
                case 13:
                    return AdvertAppInfo.dWf;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.hmH != null ? this.hmH.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccr() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void np(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void nq(boolean z) {
    }

    public AdvertAppInfo ccs() {
        return this.hmH;
    }
}
