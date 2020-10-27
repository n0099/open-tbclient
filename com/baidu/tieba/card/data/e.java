package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class e extends b implements q {
    public String fsZ = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo hVb = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.hVb != null && this.hVb.getType() == AdvertAppInfo.esD) {
            return AdvertAppInfo.esJ;
        }
        if (this.hVb != null && this.hVb.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.esM;
            switch (this.hVb.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.esN;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.esO;
                case 7:
                case 14:
                    return AdvertAppInfo.esP;
                case 12:
                    return AdvertAppInfo.esR;
                case 13:
                    return AdvertAppInfo.esQ;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.hVb != null ? this.hVb.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cmj() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void os(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void ot(boolean z) {
    }

    public AdvertAppInfo cmk() {
        return this.hVb;
    }
}
