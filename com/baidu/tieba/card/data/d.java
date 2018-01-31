package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String cXh = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cXg = null;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.cXg != null && this.cXg.getType() == AdvertAppInfo.aIV) {
            return AdvertAppInfo.aJb;
        }
        if (this.cXg != null && this.cXg.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aJe;
            switch (this.cXg.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.aJf;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.aJg;
                case 7:
                    return AdvertAppInfo.aJh;
                case 9:
                    return AdvertAppInfo.aJj;
                case 10:
                    return AdvertAppInfo.aJi;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.h(this.cXg != null ? this.cXg.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akX() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eJ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eK(boolean z) {
    }

    public AdvertAppInfo akY() {
        return this.cXg;
    }
}
