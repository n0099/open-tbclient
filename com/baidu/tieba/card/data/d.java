package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String cRh = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cRg = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.cRg != null && this.cRg.getType() == AdvertAppInfo.aly) {
            return AdvertAppInfo.alE;
        }
        if (this.cRg != null && this.cRg.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.alH;
            switch (this.cRg.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.alI;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.alJ;
                case 7:
                    return AdvertAppInfo.alK;
                case 9:
                    return AdvertAppInfo.alM;
                case 10:
                    return AdvertAppInfo.alL;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.cRg != null ? this.cRg.adPosition : AiAppsAudioPlayer.ERROR_UNKNOWN, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aoh() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fv(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fw(boolean z) {
    }

    public AdvertAppInfo aoi() {
        return this.cRg;
    }
}
