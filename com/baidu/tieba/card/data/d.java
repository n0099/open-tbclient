package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.sina.weibo.sdk.exception.WeiboAuthException;
/* loaded from: classes.dex */
public class d extends b implements q {
    public String cZI = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cZH = null;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.cZH != null && this.cZH.getType() == AdvertAppInfo.aKd) {
            return AdvertAppInfo.aKj;
        }
        if (this.cZH != null && this.cZH.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aKm;
            switch (this.cZH.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.aKn;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.aKo;
                case 7:
                    return AdvertAppInfo.aKp;
                case 9:
                    return AdvertAppInfo.aKr;
                case 10:
                    return AdvertAppInfo.aKq;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.g.b.h(this.cZH != null ? this.cZH.adPosition : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alF() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
    }

    public AdvertAppInfo alG() {
        return this.cZH;
    }
}
