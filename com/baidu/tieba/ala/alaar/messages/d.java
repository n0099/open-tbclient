package com.baidu.tieba.ala.alaar.messages;

import android.support.annotation.IntRange;
import android.support.v4.media.MediaDescriptionCompat;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes7.dex */
public class d extends HttpMessage {
    private long bew;
    public AlaLiveStickerInfo fxE;
    @IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.bew = j;
        this.mRequestType = i;
        this.fxE = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.bew);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.fxE.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.fxE.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.fxE.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.fxE.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.fxE.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.fxE.centerY);
    }
}
