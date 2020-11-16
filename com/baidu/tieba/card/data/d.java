package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements p {
    public String fyg = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo ibQ = null;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.ibQ != null && this.ibQ.getType() == AdvertAppInfo.ewL) {
            return AdvertAppInfo.ewR;
        }
        if (this.ibQ != null && this.ibQ.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.ewU;
            switch (this.ibQ.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.ewV;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.ewW;
                case 7:
                case 14:
                    return AdvertAppInfo.ewX;
                case 12:
                    return AdvertAppInfo.ewZ;
                case 13:
                    return AdvertAppInfo.ewY;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.ibQ != null ? this.ibQ.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cop() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void oE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void oF(boolean z) {
    }

    public AdvertAppInfo coq() {
        return this.ibQ;
    }
}
