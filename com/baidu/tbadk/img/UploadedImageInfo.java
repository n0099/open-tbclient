package com.baidu.tbadk.img;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UploadedImageInfo implements Serializable {
    private String pic_id = null;
    private int width = 0;
    private int height = 0;

    public String toPostString() {
        if (this.pic_id == null) {
            return "";
        }
        return String.format("#(pic,%s,%d,%d)", this.pic_id, Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public String toString() {
        return toPostString();
    }

    public String getPic_id() {
        return this.pic_id;
    }

    public void setPic_id(String str) {
        this.pic_id = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pic_id = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.width = jSONObject.optInt("width", 0);
                this.height = jSONObject.optInt("height", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
