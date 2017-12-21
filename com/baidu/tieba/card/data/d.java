package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String aAv = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cdG = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.cdG != null && this.cdG.getType() == AdvertAppInfo.Uw) {
            return AdvertAppInfo.UD;
        }
        if (this.cdG != null && this.cdG.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.UG;
            switch (this.cdG.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.UH;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.UI;
                case 7:
                    return AdvertAppInfo.UJ;
                case 9:
                    return AdvertAppInfo.UL;
                case 10:
                    return AdvertAppInfo.UK;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.cdG != null ? this.cdG.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean acj() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
    }

    public AdvertAppInfo ack() {
        return this.cdG;
    }
}
