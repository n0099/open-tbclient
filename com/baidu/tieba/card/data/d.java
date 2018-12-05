package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String cXO = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cXN = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.cXN != null && this.cXN.getType() == AdvertAppInfo.aoY) {
            return AdvertAppInfo.ape;
        }
        if (this.cXN != null && this.cXN.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aph;
            switch (this.cXN.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.api;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.apj;
                case 7:
                    return AdvertAppInfo.apk;
                case 9:
                    return AdvertAppInfo.apm;
                case 10:
                    return AdvertAppInfo.apl;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.cXN != null ? this.cXN.adPosition : AiAppsAudioPlayer.ERROR_UNKNOWN, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean apU() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fw(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fx(boolean z) {
    }

    public AdvertAppInfo apV() {
        return this.cXN;
    }
}
