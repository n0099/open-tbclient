package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eQk = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo gsg = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.gsg != null && this.gsg.getType() == AdvertAppInfo.dmb) {
            return AdvertAppInfo.dmh;
        }
        if (this.gsg != null && this.gsg.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dmk;
            switch (this.gsg.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dml;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dmm;
                case 7:
                    return AdvertAppInfo.dmn;
                case 12:
                    return AdvertAppInfo.dmp;
                case 13:
                    return AdvertAppInfo.dmo;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.gsg != null ? this.gsg.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bFl() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void lB(boolean z) {
    }

    public AdvertAppInfo bFm() {
        return this.gsg;
    }
}
