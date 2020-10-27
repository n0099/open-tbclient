package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.bs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static bs Iw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bs bsVar = new bs();
            bsVar.downloadUrl = jSONObject.optString("download_url");
            bsVar.aPt = jSONObject.optString("download_md5");
            bsVar.videoPath = jSONObject.optString("video_path");
            bsVar.videoMd5 = jSONObject.optString("video_md5");
            return bsVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(bs bsVar) {
        if (bsVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", bsVar.downloadUrl);
            jSONObject.put("download_md5", bsVar.aPt);
            jSONObject.put("video_path", bsVar.videoPath);
            jSONObject.put("video_md5", bsVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
