package com.baidu.tieba.ala.alaar.messages;

import android.support.annotation.IntRange;
import android.support.v4.media.MediaDescriptionCompat;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    private long blh;
    public AlaLiveStickerInfo fNd;
    @IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.blh = j;
        this.mRequestType = i;
        this.fNd = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.blh);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.fNd.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.fNd.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.fNd.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.fNd.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.fNd.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.fNd.centerY);
    }
}
