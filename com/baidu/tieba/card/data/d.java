package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String ePT = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo ePS = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.ePS != null && this.ePS.getType() == AdvertAppInfo.bWT) {
            return AdvertAppInfo.bWZ;
        }
        if (this.ePS != null && this.ePS.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bXc;
            switch (this.ePS.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bXd;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bXe;
                case 7:
                    return AdvertAppInfo.bXf;
                case 9:
                    return AdvertAppInfo.bXh;
                case 10:
                    return AdvertAppInfo.bXg;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.toInt(this.ePS != null ? this.ePS.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baM() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
    }

    public AdvertAppInfo baN() {
        return this.ePS;
    }
}
