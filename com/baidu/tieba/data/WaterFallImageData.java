package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WaterFallImageData {
    private String mId = null;
    private int mImageDisplayHeight = 0;
    private int mImageOriWidth = 0;
    private int mImageOriHeight = 0;
    private int mImageDisplayWidth = 0;

    public int getImageOriWidth() {
        return this.mImageOriWidth;
    }

    public void setImageOriWidth(int width) {
        this.mImageOriWidth = width;
    }

    public int getImageOriHeight() {
        return this.mImageOriHeight;
    }

    public void setImageOriHeight(int height) {
        this.mImageOriHeight = height;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getId() {
        return this.mId;
    }

    public int getImageDisplayHeight() {
        return this.mImageDisplayHeight;
    }

    public void setImageDisplayHeight(int imageDisplayHeight) {
        this.mImageDisplayHeight = imageDisplayHeight;
    }

    public int getImageDisplayWidth() {
        return this.mImageDisplayWidth;
    }

    public void setImageDisplayWidth(int imageDisplayWidth) {
        this.mImageDisplayWidth = imageDisplayWidth;
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.mId = json.optString("id");
                this.mImageOriWidth = json.optInt("width", 0);
                this.mImageOriHeight = json.optInt("height", 0);
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", "error = " + ex.getMessage());
        }
    }
}
