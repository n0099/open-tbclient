package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eHo = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo eHn = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.eHn != null && this.eHn.getType() == AdvertAppInfo.bFb) {
            return AdvertAppInfo.bFh;
        }
        if (this.eHn != null && this.eHn.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bFk;
            switch (this.eHn.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bFl;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bFm;
                case 7:
                    return AdvertAppInfo.bFn;
                case 9:
                    return AdvertAppInfo.bFp;
                case 10:
                    return AdvertAppInfo.bFo;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.f(this.eHn != null ? this.eHn.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iL(boolean z) {
    }

    public AdvertAppInfo baL() {
        return this.eHn;
    }
}
