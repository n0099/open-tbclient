package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.sina.weibo.sdk.exception.WeiboAuthException;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String csP = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo csO = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.csO != null && this.csO.getType() == AdvertAppInfo.Vu) {
            return AdvertAppInfo.VA;
        }
        if (this.csO != null && this.csO.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.VD;
            switch (this.csO.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.VE;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.VF;
                case 7:
                    return AdvertAppInfo.VG;
                case 9:
                    return AdvertAppInfo.VI;
                case 10:
                    return AdvertAppInfo.VH;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.csO != null ? this.csO.adPosition : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean afO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void ex(boolean z) {
    }

    public AdvertAppInfo afP() {
        return this.csO;
    }
}
