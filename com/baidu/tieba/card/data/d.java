package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String dbr = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo dbq = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.dbq != null && this.dbq.getType() == AdvertAppInfo.apB) {
            return AdvertAppInfo.apH;
        }
        if (this.dbq != null && this.dbq.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.apK;
            switch (this.dbq.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.apL;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.apM;
                case 7:
                    return AdvertAppInfo.apN;
                case 9:
                    return AdvertAppInfo.apP;
                case 10:
                    return AdvertAppInfo.apO;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.dbq != null ? this.dbq.adPosition : AiAppsAudioPlayer.ERROR_UNKNOWN, -1);
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
        return this.dbq;
    }
}
