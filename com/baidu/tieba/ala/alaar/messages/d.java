package com.baidu.tieba.ala.alaar.messages;

import androidx.annotation.IntRange;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes10.dex */
public class d extends HttpMessage {
    private long brk;
    public AlaLiveStickerInfo gpR;
    @IntRange(from = 1, to = 3)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.brk = j;
        this.mRequestType = i;
        this.gpR = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.brk);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.gpR.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.gpR.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.gpR.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.gpR.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.gpR.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.gpR.centerY);
    }
}
