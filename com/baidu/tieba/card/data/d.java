package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String dbs = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo dbr = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.dbr != null && this.dbr.getType() == AdvertAppInfo.apC) {
            return AdvertAppInfo.apI;
        }
        if (this.dbr != null && this.dbr.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.apL;
            switch (this.dbr.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.apM;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.apN;
                case 7:
                    return AdvertAppInfo.apO;
                case 9:
                    return AdvertAppInfo.apQ;
                case 10:
                    return AdvertAppInfo.apP;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.dbr != null ? this.dbr.adPosition : AiAppsAudioPlayer.ERROR_UNKNOWN, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean arg() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fC(boolean z) {
    }

    public AdvertAppInfo arh() {
        return this.dbr;
    }
}
