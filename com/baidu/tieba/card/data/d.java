package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eFy = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo eFx = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.eFx != null && this.eFx.getType() == AdvertAppInfo.bEC) {
            return AdvertAppInfo.bEI;
        }
        if (this.eFx != null && this.eFx.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bEL;
            switch (this.eFx.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bEM;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bEN;
                case 7:
                    return AdvertAppInfo.bEO;
                case 9:
                    return AdvertAppInfo.bEQ;
                case 10:
                    return AdvertAppInfo.bEP;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.f(this.eFx != null ? this.eFx.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bae() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
    }

    public AdvertAppInfo baf() {
        return this.eFx;
    }
}
