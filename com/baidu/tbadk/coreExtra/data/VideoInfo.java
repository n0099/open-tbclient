package com.baidu.tbadk.coreExtra.data;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoInfo implements Serializable {
    public static final String DRAFT_JSON_NAME = "video_info";
    public static final String KEY_DURATION = "key_duration";
    public static final String KEY_THUMB_PICTURE_ID = "key_thumb_picture_id";
    public static final String KEY_THUMB_URL = "key_thumb_url";
    public static final String KEY_VIDEO_HEIGHT = "key_video_height";
    public static final String KEY_VIDEO_SWF_URL = "key_video_swf_url";
    public static final String KEY_VIDEO_URL = "key_video_url";
    public static final String KEY_VIDEO_WIDTH = "key_video_width";
    private static final long serialVersionUID = 2268559006566847573L;
    private int duration;
    private String pictureId;
    private String swfUrl;
    private String thumbUrl;
    private int videoHeight;
    private String videoUrl;
    private int videoWidth;

    public void parseIntent(Intent intent) {
        if (intent != null) {
            this.videoUrl = intent.getStringExtra(KEY_VIDEO_URL);
            this.videoHeight = intent.getIntExtra(KEY_VIDEO_HEIGHT, 0);
            this.videoWidth = intent.getIntExtra(KEY_VIDEO_WIDTH, 0);
            this.thumbUrl = intent.getStringExtra(KEY_THUMB_URL);
            this.duration = intent.getIntExtra(KEY_DURATION, 0);
            this.swfUrl = intent.getStringExtra(KEY_VIDEO_SWF_URL);
        }
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoUrl) && !StringUtils.isNull(this.thumbUrl) && this.videoHeight > 0 && this.videoWidth > 0;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getSwfUrl() {
        return this.swfUrl;
    }

    public String buildWriteContent(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("#(xiaoying,");
        if (StringUtils.isNull(this.pictureId)) {
            this.pictureId = getPictureIdInBackground(str);
        }
        sb.append(this.pictureId).append(",");
        sb.append(String.valueOf(this.videoWidth)).append(",");
        sb.append(String.valueOf(this.videoHeight)).append(",");
        sb.append(this.videoUrl).append(",");
        sb.append(this.duration).append(",");
        sb.append(String.valueOf(this.videoWidth)).append(",");
        sb.append(String.valueOf(this.videoHeight)).append(",");
        sb.append(this.swfUrl).append(")");
        return sb.toString();
    }

    public String getPictureIdInBackground(String str) {
        JSONArray optJSONArray;
        v vVar = new v(TbConfig.TRANSFER_PICTURE_ID);
        vVar.o("urls[]", this.thumbUrl);
        vVar.o("kw", str);
        try {
            JSONObject jSONObject = new JSONObject(vVar.tI());
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pics")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("url");
                        String optString2 = jSONObject2.optString(Info.kBaiduPIDKey);
                        if (TextUtils.equals(optString, this.thumbUrl)) {
                            return optString2;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_VIDEO_URL, this.videoUrl);
            jSONObject.put(KEY_DURATION, this.duration);
            jSONObject.put(KEY_THUMB_PICTURE_ID, this.pictureId);
            jSONObject.put(KEY_THUMB_URL, this.thumbUrl);
            jSONObject.put(KEY_VIDEO_HEIGHT, this.videoHeight);
            jSONObject.put(KEY_VIDEO_WIDTH, this.videoWidth);
            jSONObject.put(KEY_VIDEO_SWF_URL, this.swfUrl);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void parseJsonObject(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.videoUrl = jSONObject.optString(KEY_VIDEO_URL);
            this.pictureId = jSONObject.optString(KEY_THUMB_PICTURE_ID);
            this.swfUrl = jSONObject.optString(KEY_VIDEO_SWF_URL);
            this.thumbUrl = jSONObject.optString(KEY_THUMB_URL);
            this.duration = jSONObject.optInt(KEY_DURATION);
            this.videoHeight = jSONObject.optInt(KEY_VIDEO_HEIGHT);
            this.videoWidth = jSONObject.optInt(KEY_VIDEO_WIDTH);
        }
    }

    public void copy(VideoInfo videoInfo) {
        if (videoInfo != null) {
            this.videoUrl = videoInfo.videoUrl;
            this.pictureId = videoInfo.pictureId;
            this.swfUrl = videoInfo.swfUrl;
            this.thumbUrl = videoInfo.thumbUrl;
            this.duration = videoInfo.duration;
            this.videoHeight = videoInfo.videoHeight;
            this.videoWidth = videoInfo.videoWidth;
        }
    }
}
