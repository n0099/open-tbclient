package com.baidu.tieba.ala.alaar.messages;

import androidx.annotation.IntRange;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes11.dex */
public class d extends HttpMessage {
    private long buN;
    public AlaLiveStickerInfo gsP;
    @IntRange(from = 1, to = 3)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.buN = j;
        this.mRequestType = i;
        this.gsP = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.buN);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.gsP.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.gsP.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.gsP.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.gsP.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.gsP.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.gsP.centerY);
    }
}
