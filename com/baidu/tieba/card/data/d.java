package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.sina.weibo.sdk.exception.WeiboAuthException;
/* loaded from: classes.dex */
public class d extends b implements q {
    public String cZL = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cZK = null;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.cZK != null && this.cZK.getType() == AdvertAppInfo.aKe) {
            return AdvertAppInfo.aKk;
        }
        if (this.cZK != null && this.cZK.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aKn;
            switch (this.cZK.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.aKo;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.aKp;
                case 7:
                    return AdvertAppInfo.aKq;
                case 9:
                    return AdvertAppInfo.aKs;
                case 10:
                    return AdvertAppInfo.aKr;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.g.b.h(this.cZK != null ? this.cZK.adPosition : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, -1);
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
        return this.cZK;
    }
}
