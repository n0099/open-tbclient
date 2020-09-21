package com.baidu.tieba.ala.alaar.sticker.download;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int progress;
    private String savePath;
    private String name = "";
    private String id = "";
    private String image = "";
    private String url = "";
    private String downloadPerSize = "";
    private int status = 0;

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("id", this.id);
            jSONObject.put("image", this.image);
            jSONObject.put("url", this.url);
            jSONObject.put("progress", this.progress);
            jSONObject.put("downloadPerSize", this.downloadPerSize);
            jSONObject.put("status", this.status);
            jSONObject.put("savePath", this.savePath);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.name = jSONObject.optString("name");
            this.id = jSONObject.optString("id");
            this.image = jSONObject.optString("image");
            this.url = jSONObject.optString("url");
            this.progress = jSONObject.optInt("progress");
            this.downloadPerSize = jSONObject.optString("downloadPerSize");
            this.status = jSONObject.optInt("status");
            this.savePath = jSONObject.optString("savePath");
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public String getUrl() {
        return this.url;
    }

    public void setDownloadPerSize(String str) {
        this.downloadPerSize = str;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }
}
