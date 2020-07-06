package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eEs = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo gUg = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.gUg != null && this.gUg.getType() == AdvertAppInfo.dGu) {
            return AdvertAppInfo.dGA;
        }
        if (this.gUg != null && this.gUg.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dGD;
            switch (this.gUg.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dGE;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dGF;
                case 7:
                case 14:
                    return AdvertAppInfo.dGG;
                case 12:
                    return AdvertAppInfo.dGI;
                case 13:
                    return AdvertAppInfo.dGH;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.gUg != null ? this.gUg.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bOT() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mf(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void mg(boolean z) {
    }

    public AdvertAppInfo bOU() {
        return this.gUg;
    }
}
