package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.sina.weibo.sdk.exception.WeiboAuthException;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String crJ = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo crI = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.crI != null && this.crI.getType() == AdvertAppInfo.Vy) {
            return AdvertAppInfo.VE;
        }
        if (this.crI != null && this.crI.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.VH;
            switch (this.crI.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.VI;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.VJ;
                case 7:
                    return AdvertAppInfo.VK;
                case 9:
                    return AdvertAppInfo.VM;
                case 10:
                    return AdvertAppInfo.VL;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.crI != null ? this.crI.adPosition : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean afO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ev(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
    }

    public AdvertAppInfo afP() {
        return this.crI;
    }
}
