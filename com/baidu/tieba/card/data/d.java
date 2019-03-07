package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String ele = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo eld = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.eld != null && this.eld.getType() == AdvertAppInfo.bwk) {
            return AdvertAppInfo.bwq;
        }
        if (this.eld != null && this.eld.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.bwt;
            switch (this.eld.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.bwu;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.bwv;
                case 7:
                    return AdvertAppInfo.bww;
                case 9:
                    return AdvertAppInfo.bwy;
                case 10:
                    return AdvertAppInfo.bwx;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.eld != null ? this.eld.adPosition : LivenessStat.TYPE_STRING_DEFAULT, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQV() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
    }

    public AdvertAppInfo aQW() {
        return this.eld;
    }
}
