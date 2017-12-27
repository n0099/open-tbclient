package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String cSk = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cSj = null;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.cSj != null && this.cSj.getType() == AdvertAppInfo.aIU) {
            return AdvertAppInfo.aJa;
        }
        if (this.cSj != null && this.cSj.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aJd;
            switch (this.cSj.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.aJe;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.aJf;
                case 7:
                    return AdvertAppInfo.aJg;
                case 9:
                    return AdvertAppInfo.aJi;
                case 10:
                    return AdvertAppInfo.aJh;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.h(this.cSj != null ? this.cSj.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ajP() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eD(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eE(boolean z) {
    }

    public AdvertAppInfo ajQ() {
        return this.cSj;
    }
}
