package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.al;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements al, p {
    private boolean eEu;
    public String fFV;
    public AdvertAppInfo imN;
    public String mPageType;
    public int mPn;

    public d(AdvertAppInfo advertAppInfo) {
        this.fFV = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eEu = false;
        this.imN = advertAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.fFV = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eEu = false;
        this.imN = null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.imN != null && this.imN.getType() == AdvertAppInfo.eDM) {
            return AdvertAppInfo.eDS;
        }
        if (this.imN != null && this.imN.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.eDV;
            switch (this.imN.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.eDW;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.eDX;
                case 7:
                case 14:
                    return AdvertAppInfo.eDY;
                case 12:
                    return AdvertAppInfo.eEa;
                case 13:
                    return AdvertAppInfo.eDZ;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.imN != null ? this.imN.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csC() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pb(boolean z) {
    }

    public AdvertAppInfo csD() {
        return this.imN;
    }

    @Override // com.baidu.tbadk.core.data.al
    public AdvertAppInfo bmI() {
        return this.imN;
    }

    @Override // com.baidu.tbadk.core.data.al
    public void setPosition(int i) {
        this.position = i;
        this.imN.position = i;
        this.eEu = true;
    }

    @Override // com.baidu.tbadk.core.data.al
    public int bmJ() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.al
    public boolean bmK() {
        return this.eEu;
    }
}
