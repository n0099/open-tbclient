package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class e extends b implements q {
    public String fkA = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo hIE = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.hIE != null && this.hIE.getType() == AdvertAppInfo.eke) {
            return AdvertAppInfo.ekk;
        }
        if (this.hIE != null && this.hIE.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.ekn;
            switch (this.hIE.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.eko;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.ekp;
                case 7:
                case 14:
                    return AdvertAppInfo.ekq;
                case 12:
                    return AdvertAppInfo.eks;
                case 13:
                    return AdvertAppInfo.ekr;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.hIE != null ? this.hIE.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cjc() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void ob(boolean z) {
    }

    public AdvertAppInfo cjd() {
        return this.hIE;
    }
}
