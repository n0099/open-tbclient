package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.al;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements al, p {
    private boolean eJz;
    public String fKR;
    public AdvertAppInfo iuD;
    public String mPageType;
    public int mPn;

    public d(AdvertAppInfo advertAppInfo) {
        this.fKR = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eJz = false;
        this.iuD = advertAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.fKR = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eJz = false;
        this.iuD = null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.iuD != null && this.iuD.getType() == AdvertAppInfo.eIO) {
            return AdvertAppInfo.eIU;
        }
        if (this.iuD != null && this.iuD.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.eIX;
            switch (this.iuD.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.eJb;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.eJc;
                case 7:
                case 14:
                    return AdvertAppInfo.eJd;
                case 12:
                    return AdvertAppInfo.eJf;
                case 13:
                    return AdvertAppInfo.eJe;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.iuD != null ? this.iuD.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean crF() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pu(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pv(boolean z) {
    }

    public AdvertAppInfo crG() {
        return this.iuD;
    }

    @Override // com.baidu.tbadk.core.data.al
    public AdvertAppInfo blp() {
        return this.iuD;
    }

    @Override // com.baidu.tbadk.core.data.al
    public void setPosition(int i) {
        this.position = i;
        this.iuD.position = i;
        this.eJz = true;
    }

    @Override // com.baidu.tbadk.core.data.al
    public int blq() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.al
    public boolean blr() {
        return this.eJz;
    }
}
