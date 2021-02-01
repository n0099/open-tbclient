package com.baidu.tieba.ala.alaar.messages;

import androidx.annotation.IntRange;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes11.dex */
public class d extends HttpMessage {
    private long buN;
    public AlaLiveStickerInfo gsB;
    @IntRange(from = 1, to = 3)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.buN = j;
        this.mRequestType = i;
        this.gsB = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.buN);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.gsB.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.gsB.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.gsB.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.gsB.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.gsB.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.gsB.centerY);
    }
}
