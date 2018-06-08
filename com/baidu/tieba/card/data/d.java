package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.sina.weibo.sdk.exception.WeiboAuthException;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String cBu = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cBt = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.cBt != null && this.cBt.getType() == AdvertAppInfo.adu) {
            return AdvertAppInfo.adA;
        }
        if (this.cBt != null && this.cBt.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.adD;
            switch (this.cBt.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.adE;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.adF;
                case 7:
                    return AdvertAppInfo.adG;
                case 9:
                    return AdvertAppInfo.adI;
                case 10:
                    return AdvertAppInfo.adH;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.cBt != null ? this.cBt.adPosition : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
    }

    public AdvertAppInfo ajx() {
        return this.cBt;
    }
}
