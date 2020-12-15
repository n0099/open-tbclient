package com.baidu.tieba.ala.alaar.messages;

import android.support.annotation.IntRange;
import android.support.v4.media.MediaDescriptionCompat;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveStickerInfo;
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    private long brr;
    public AlaLiveStickerInfo gjZ;
    @IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS)
    public int mRequestType;

    public d(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        super(1021206);
        this.brr = j;
        this.mRequestType = i;
        this.gjZ = alaLiveStickerInfo;
    }

    public void setParams() {
        addParam("live_id", this.brr);
        addParam("type", this.mRequestType);
        if (1 != this.mRequestType) {
            addParam(AlaLiveStickerInfo.STICKER_ID, String.valueOf(this.gjZ.id));
        }
        addParam(AlaLiveStickerInfo.STICKER_TYPE, this.gjZ.type);
        addParam(AlaLiveStickerInfo.STICKER_LINK, this.gjZ.link);
        addParam(AlaLiveStickerInfo.STICKER_TEXT, this.gjZ.text);
        addParam(AlaLiveStickerInfo.STICKER_CENTERX, this.gjZ.centerX);
        addParam(AlaLiveStickerInfo.STICKER_CENTERY, this.gjZ.centerY);
    }
}
