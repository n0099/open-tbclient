package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VideoEasterEggData implements Serializable {
    public String activityID;
    public String popImageUrl;
    public String popText;
    public String shareContent;
    public String shareImageUrl;
    public String shareTitle;
    public String shareUrl;
    public String videoUrl;

    public String getActivityID() {
        return this.activityID;
    }

    public String getPopImageUrl() {
        return this.popImageUrl;
    }

    public String getPopText() {
        return this.popText;
    }

    public String getShareContent() {
        return this.shareContent;
    }

    public String getShareImageUrl() {
        return this.shareImageUrl;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.activityID = jSONObject.optString("activity_id", "");
        this.videoUrl = jSONObject.optString("video_url", "");
        this.popText = jSONObject.optString("pop_text", "");
        this.popImageUrl = jSONObject.optString("pop_imageurl", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("share_info");
        if (optJSONObject != null) {
            this.shareTitle = optJSONObject.optString("title", "");
            this.shareContent = optJSONObject.optString("content", "");
            this.shareUrl = optJSONObject.optString("url", "");
            this.shareImageUrl = optJSONObject.optString("imageurl", "");
        }
    }
}
