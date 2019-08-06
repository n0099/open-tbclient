package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eFF = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo eFE = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.eFE != null && this.eFE.getType() == AdvertAppInfo.bED) {
            return AdvertAppInfo.bEJ;
        }
        if (this.eFE != null && this.eFE.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bEM;
            switch (this.eFE.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bEN;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bEO;
                case 7:
                    return AdvertAppInfo.bEP;
                case 9:
                    return AdvertAppInfo.bER;
                case 10:
                    return AdvertAppInfo.bEQ;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.f(this.eFE != null ? this.eFE.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bag() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
    }

    public AdvertAppInfo bah() {
        return this.eFE;
    }
}
