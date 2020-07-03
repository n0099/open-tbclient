package com.baidu.tieba.ala.alaar.messages;

import android.support.annotation.IntRange;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private long aZe;
    public AlaLiveStickerInfo fha;
    @IntRange(from = 1, to = 3)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.aZe = j;
        this.mRequestType = i;
        this.fha = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.aZe);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.fha.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.fha.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.fha.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.fha.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.fha.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.fha.centerY);
    }
}
