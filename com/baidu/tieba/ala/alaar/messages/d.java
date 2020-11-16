package com.baidu.tieba.ala.alaar.messages;

import android.support.annotation.IntRange;
import android.support.v4.media.MediaDescriptionCompat;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    private long bmk;
    public AlaLiveStickerInfo gbM;
    @IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.bmk = j;
        this.mRequestType = i;
        this.gbM = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.bmk);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.gbM.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.gbM.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.gbM.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.gbM.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.gbM.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.gbM.centerY);
    }
}
