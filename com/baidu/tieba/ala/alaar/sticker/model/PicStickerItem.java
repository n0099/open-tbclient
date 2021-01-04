package com.baidu.tieba.ala.alaar.sticker.model;

import android.graphics.Bitmap;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PicStickerItem extends FuFaceItem {
    public Bitmap bitmap;
    public String client_type;
    public String max_version;
    public String min_version;
    public int resId;
    public int sticker_type = 1;
    public String type;
    public String url;

    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    public File getStickerFile() {
        return null;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    public String getFilePath() {
        return "";
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    public boolean isResLoaded() {
        return true;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.url = jSONObject.optString("url");
            this.type = jSONObject.optString("type");
            if ("1".equals(this.type)) {
                this.sticker_type = 1;
            } else if ("2".equals(this.type)) {
                this.sticker_type = 2;
            }
            this.min_version = jSONObject.optString("min_version");
            this.max_version = jSONObject.optString("max_version");
            this.client_type = jSONObject.optString("client_type");
        }
    }
}
