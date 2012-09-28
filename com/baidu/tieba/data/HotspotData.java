package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class HotspotData {
    private int Id = -1;
    private String imageUrl;
    private String pbKey;
    private String title;

    public void setId(int id) {
        this.Id = id;
    }

    public int getId() {
        return this.Id;
    }

    public void setBitmap(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPbKey(String pbKey) {
        this.pbKey = pbKey;
    }

    public String getPbKey() {
        return this.pbKey;
    }

    public String getBitmap() {
        return this.imageUrl;
    }

    public void setHotspot(HotspotData src) {
        this.title = src.title;
        this.imageUrl = src.imageUrl;
        this.pbKey = src.pbKey;
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.title = json.optString("title");
                this.imageUrl = json.optString("pic");
                String temp = json.optString("href");
                this.pbKey = temp.substring(temp.lastIndexOf("/") + 1);
            } catch (Exception ex) {
                TiebaLog.e("HotspotData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }
}
