package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoEasterEggData implements Serializable {
    private String activityID;
    private String popImageUrl;
    private String popText;
    private String shareContent;
    private String shareImageUrl;
    private String shareTitle;
    private String shareUrl;
    private String videoUrl;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.activityID = jSONObject.optString(GroupActivityActivityConfig.ACTIVITY_ID, "");
            this.videoUrl = jSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL, "");
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

    public String getActivityID() {
        return this.activityID;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getPopText() {
        return this.popText;
    }

    public String getPopImageUrl() {
        return this.popImageUrl;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareContent() {
        return this.shareContent;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getShareImageUrl() {
        return this.shareImageUrl;
    }
}
