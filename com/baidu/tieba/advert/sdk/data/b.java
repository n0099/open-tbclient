package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.ala.helper.AlaConstants;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class b {
    private long endShowTime;
    private long startShowTime;
    private int videoDuration;
    private int videoHeight;
    private int videoWidth;
    public String videoLocalPath = "";
    public String adVideoUrl = "";
    public String videoJumpUrl = "";
    public String videoMd5 = "";
    public String redirectUrl = "";
    public String adImgUrl = "";

    private b() {
    }

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo != null) {
            bVar.adImgUrl = adInfo.adImgUrl;
            bVar.redirectUrl = adInfo.redirectUrl;
            bVar.startShowTime = adInfo.startShowTime;
            bVar.endShowTime = adInfo.endShowTime;
            bVar.videoLocalPath = adInfo.videoLocalPath;
            bVar.videoJumpUrl = adInfo.videoJumpUrl;
            bVar.videoMd5 = adInfo.videoMd5;
            bVar.videoDuration = adInfo.videoDuration;
            bVar.videoWidth = adInfo.videoWidth;
            bVar.videoHeight = adInfo.videoHight;
            bVar.adVideoUrl = adInfo.adVideoUrl;
        }
        return bVar;
    }

    public static b DV(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.adImgUrl = jSONObject.optString("adImgUrl");
            bVar.redirectUrl = jSONObject.optString("redirectUrl");
            bVar.videoLocalPath = jSONObject.optString("videoLocalPath");
            bVar.startShowTime = jSONObject.optLong("startShowTime");
            bVar.endShowTime = jSONObject.optLong("endShowTime");
            bVar.videoJumpUrl = jSONObject.optString("videoJumpUrl");
            bVar.videoMd5 = jSONObject.optString("videoMd5");
            bVar.videoDuration = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.videoWidth = jSONObject.optInt("videoWidth");
            bVar.videoHeight = jSONObject.optInt(AlaConstants.STAT_VIDEO_HEIGHT);
            bVar.adVideoUrl = jSONObject.optString("adVideoUrl");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.adImgUrl);
            jSONObject.put("redirectUrl", this.redirectUrl);
            jSONObject.put("videoLocalPath", this.videoLocalPath);
            jSONObject.put("startShowTime", this.startShowTime);
            jSONObject.put("endShowTime", this.endShowTime);
            jSONObject.put("videoMd5", this.videoMd5);
            jSONObject.put("videoJumpUrl", this.videoJumpUrl);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.videoDuration);
            jSONObject.put("videoWidth", this.videoWidth);
            jSONObject.put(AlaConstants.STAT_VIDEO_HEIGHT, this.videoHeight);
            jSONObject.put("adVideoUrl", this.adVideoUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean isValidate() {
        return (System.currentTimeMillis() / 1000 >= this.startShowTime && System.currentTimeMillis() / 1000 <= this.endShowTime) || (this.startShowTime == 0 && this.endShowTime == 0);
    }

    public boolean bcy() {
        return !TextUtils.isEmpty(this.videoLocalPath);
    }
}
