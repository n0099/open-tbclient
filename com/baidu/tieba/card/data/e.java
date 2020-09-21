package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class e extends b implements q {
    public String eYo = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo htK = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.htK != null && this.htK.getType() == AdvertAppInfo.dYc) {
            return AdvertAppInfo.dYi;
        }
        if (this.htK != null && this.htK.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dYl;
            switch (this.htK.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dYm;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dYn;
                case 7:
                case 14:
                    return AdvertAppInfo.dYo;
                case 12:
                    return AdvertAppInfo.dYq;
                case 13:
                    return AdvertAppInfo.dYp;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.htK != null ? this.htK.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cfG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nv(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void nw(boolean z) {
    }

    public AdvertAppInfo cfH() {
        return this.htK;
    }
}
