package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.am;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements am, p {
    private boolean eLL;
    public String fNd;
    public AdvertAppInfo iAn;
    public String mPageType;
    public int mPn;

    public d(AdvertAppInfo advertAppInfo) {
        this.fNd = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eLL = false;
        this.iAn = advertAppInfo;
        this.position = this.iAn.position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.fNd = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eLL = false;
        this.iAn = null;
        this.position = -1;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.iAn != null && this.iAn.getType() == AdvertAppInfo.eLa) {
            return AdvertAppInfo.eLg;
        }
        if (this.iAn != null && this.iAn.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.eLj;
            switch (this.iAn.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.eLn;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.eLo;
                case 7:
                case 14:
                    return AdvertAppInfo.eLp;
                case 12:
                    return AdvertAppInfo.eLr;
                case 13:
                    return AdvertAppInfo.eLq;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.iAn != null ? this.iAn.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csR() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
    }

    public AdvertAppInfo csS() {
        return this.iAn;
    }

    @Override // com.baidu.tbadk.core.data.am
    public AdvertAppInfo blH() {
        return this.iAn;
    }

    @Override // com.baidu.tbadk.core.data.am
    public void setPosition(int i) {
        this.position = i;
        this.iAn.position = i;
        this.eLL = true;
    }

    @Override // com.baidu.tbadk.core.data.am
    public int blI() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.am
    public boolean blJ() {
        return this.eLL;
    }
}
