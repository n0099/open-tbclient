package com.baidu.tbadk.img;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UploadedImageInfo implements Serializable {
    public static final String POST_BJH_FORMAT = "#(pic_bos,%s,%d,%d,%b)";
    public static final String POST_FORMAT = "#(pic,%s,%d,%d)";
    public boolean isBJH;
    public boolean isGif;
    public String pic_id = null;
    public int width = 0;
    public int height = 0;

    public int getHeight() {
        return this.height;
    }

    public String getPic_id() {
        return this.pic_id;
    }

    public int getWidth() {
        return this.width;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setPic_id(String str) {
        this.pic_id = str;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public String toPostString() {
        String str = this.pic_id;
        return str != null ? this.isBJH ? String.format(POST_BJH_FORMAT, str, Integer.valueOf(this.width), Integer.valueOf(this.height), Boolean.valueOf(this.isGif)) : String.format(POST_FORMAT, str, Integer.valueOf(this.width), Integer.valueOf(this.height)) : "";
    }

    public String toString() {
        return toPostString();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.pic_id = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            this.width = jSONObject.optInt("width", 0);
            this.height = jSONObject.optInt("height", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
