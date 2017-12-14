package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String aAs = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cdC = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.cdC != null && this.cdC.getType() == AdvertAppInfo.Ut) {
            return AdvertAppInfo.Uz;
        }
        if (this.cdC != null && this.cdC.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.UD;
            switch (this.cdC.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.UE;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.UF;
                case 7:
                    return AdvertAppInfo.UG;
                case 9:
                    return AdvertAppInfo.UI;
                case 10:
                    return AdvertAppInfo.UH;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.cdC != null ? this.cdC.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ack() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
    }

    public AdvertAppInfo acl() {
        return this.cdC;
    }
}
