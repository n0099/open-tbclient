package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.sina.weibo.sdk.exception.WeiboAuthException;
/* loaded from: classes.dex */
public class d extends b implements q {
    public String cZU = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cZT = null;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.cZT != null && this.cZT.getType() == AdvertAppInfo.aKo) {
            return AdvertAppInfo.aKu;
        }
        if (this.cZT != null && this.cZT.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aKx;
            switch (this.cZT.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.aKy;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.aKz;
                case 7:
                    return AdvertAppInfo.aKA;
                case 9:
                    return AdvertAppInfo.aKC;
                case 10:
                    return AdvertAppInfo.aKB;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.g.b.h(this.cZT != null ? this.cZT.adPosition : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
    }

    public AdvertAppInfo alH() {
        return this.cZT;
    }
}
