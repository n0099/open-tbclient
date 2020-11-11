package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class e extends b implements q {
    public String fyR = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo iaY = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.iaY != null && this.iaY.getType() == AdvertAppInfo.eyx) {
            return AdvertAppInfo.eyD;
        }
        if (this.iaY != null && this.iaY.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.eyG;
            switch (this.iaY.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.eyH;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.eyI;
                case 7:
                case 14:
                    return AdvertAppInfo.eyJ;
                case 12:
                    return AdvertAppInfo.eyL;
                case 13:
                    return AdvertAppInfo.eyK;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.iaY != null ? this.iaY.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean coK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void oC(boolean z) {
    }

    public AdvertAppInfo coL() {
        return this.iaY;
    }
}
