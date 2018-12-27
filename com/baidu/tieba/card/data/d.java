package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public int daz;
    public String daG = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo daF = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.daF != null && this.daF.getType() == AdvertAppInfo.aoY) {
            return AdvertAppInfo.ape;
        }
        if (this.daF != null && this.daF.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.aph;
            switch (this.daF.legoCard.getGoodsStyle()) {
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
        return com.baidu.adp.lib.g.b.l(this.daF != null ? this.daF.adPosition : AiAppsAudioPlayer.ERROR_UNKNOWN, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aqJ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fz(boolean z) {
    }

    public AdvertAppInfo aqK() {
        return this.daF;
    }
}
