package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String cQb = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cQa = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.cQa != null && this.cQa.getType() == AdvertAppInfo.akK) {
            return AdvertAppInfo.akQ;
        }
        if (this.cQa != null && this.cQa.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.akT;
            switch (this.cQa.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.akU;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.akV;
                case 7:
                    return AdvertAppInfo.akW;
                case 9:
                    return AdvertAppInfo.akY;
                case 10:
                    return AdvertAppInfo.akX;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.cQa != null ? this.cQa.adPosition : AiAppsAudioPlayer.ERROR_UNKNOWN, -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aoF() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fk(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void fl(boolean z) {
    }

    public AdvertAppInfo aoG() {
        return this.cQa;
    }
}
