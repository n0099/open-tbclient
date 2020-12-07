package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.bu;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static bu Jf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bu buVar = new bu();
            buVar.downloadUrl = jSONObject.optString("download_url");
            buVar.aRG = jSONObject.optString("download_md5");
            buVar.videoPath = jSONObject.optString("video_path");
            buVar.videoMd5 = jSONObject.optString("video_md5");
            return buVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(bu buVar) {
        if (buVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", buVar.downloadUrl);
            jSONObject.put("download_md5", buVar.aRG);
            jSONObject.put("video_path", buVar.videoPath);
            jSONObject.put("video_md5", buVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
