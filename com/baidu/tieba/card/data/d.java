package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String ePc = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo ePb = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.ePb != null && this.ePb.getType() == AdvertAppInfo.bWc) {
            return AdvertAppInfo.bWi;
        }
        if (this.ePb != null && this.ePb.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bWl;
            switch (this.ePb.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bWm;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bWn;
                case 7:
                    return AdvertAppInfo.bWo;
                case 9:
                    return AdvertAppInfo.bWq;
                case 10:
                    return AdvertAppInfo.bWp;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.toInt(this.ePb != null ? this.ePb.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
    }

    public AdvertAppInfo baL() {
        return this.ePb;
    }
}
