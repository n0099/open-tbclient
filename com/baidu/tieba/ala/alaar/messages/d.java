package com.baidu.tieba.ala.alaar.messages;

import androidx.annotation.IntRange;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes11.dex */
public class d extends HttpMessage {
    private long bvY;
    public AlaLiveStickerInfo guy;
    @IntRange(from = 1, to = 3)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.bvY = j;
        this.mRequestType = i;
        this.guy = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.bvY);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.guy.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.guy.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.guy.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.guy.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.guy.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.guy.centerY);
    }
}
