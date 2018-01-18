package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String cWM = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cWL = null;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.cWL != null && this.cWL.getType() == AdvertAppInfo.aIS) {
            return AdvertAppInfo.aIY;
        }
        if (this.cWL != null && this.cWL.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aJb;
            switch (this.cWL.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.aJc;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.aJd;
                case 7:
                    return AdvertAppInfo.aJe;
                case 9:
                    return AdvertAppInfo.aJg;
                case 10:
                    return AdvertAppInfo.aJf;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.h(this.cWL != null ? this.cWL.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akS() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eH(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eI(boolean z) {
    }

    public AdvertAppInfo akT() {
        return this.cWL;
    }
}
