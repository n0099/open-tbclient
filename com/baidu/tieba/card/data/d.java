package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.am;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements am, p {
    private boolean eNl;
    public String fOD;
    public AdvertAppInfo iCk;
    public String mPageType;
    public int mPn;

    public d(AdvertAppInfo advertAppInfo) {
        this.fOD = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eNl = false;
        this.iCk = advertAppInfo;
        this.position = this.iCk.position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this.fOD = "";
        this.mPn = 0;
        this.mPageType = "";
        this.eNl = false;
        this.iCk = null;
        this.position = -1;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.iCk != null && this.iCk.getType() == AdvertAppInfo.eMB) {
            return AdvertAppInfo.eMH;
        }
        if (this.iCk != null && this.iCk.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.eMK;
            switch (this.iCk.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.eMO;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.eMP;
                case 7:
                case 14:
                    return AdvertAppInfo.eMQ;
                case 12:
                    return AdvertAppInfo.eMS;
                case 13:
                    return AdvertAppInfo.eMR;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.iCk != null ? this.iCk.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cte() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
    }

    public AdvertAppInfo ctf() {
        return this.iCk;
    }

    @Override // com.baidu.tbadk.core.data.am
    public AdvertAppInfo blJ() {
        return this.iCk;
    }

    @Override // com.baidu.tbadk.core.data.am
    public void setPosition(int i) {
        this.position = i;
        this.iCk.position = i;
        this.eNl = true;
    }

    @Override // com.baidu.tbadk.core.data.am
    public int blK() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.am
    public boolean blL() {
        return this.eNl;
    }
}
