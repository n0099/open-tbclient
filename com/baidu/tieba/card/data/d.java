package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.al;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements al, p {
    private boolean eOk;
    public String fPy;
    public AdvertAppInfo izk;
    public String mPageType;
    public int mPn;

    public d(AdvertAppInfo advertAppInfo) {
        this.fPy = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eOk = false;
        this.izk = advertAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.fPy = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eOk = false;
        this.izk = null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.izk != null && this.izk.getType() == AdvertAppInfo.eNz) {
            return AdvertAppInfo.eNF;
        }
        if (this.izk != null && this.izk.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.eNI;
            switch (this.izk.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.eNM;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.eNN;
                case 7:
                case 14:
                    return AdvertAppInfo.eNO;
                case 12:
                    return AdvertAppInfo.eNQ;
                case 13:
                    return AdvertAppInfo.eNP;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.izk != null ? this.izk.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cvw() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void py(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pz(boolean z) {
    }

    public AdvertAppInfo cvx() {
        return this.izk;
    }

    @Override // com.baidu.tbadk.core.data.al
    public AdvertAppInfo bpi() {
        return this.izk;
    }

    @Override // com.baidu.tbadk.core.data.al
    public void setPosition(int i) {
        this.position = i;
        this.izk.position = i;
        this.eOk = true;
    }

    @Override // com.baidu.tbadk.core.data.al
    public int bpj() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.al
    public boolean bpk() {
        return this.eOk;
    }
}
