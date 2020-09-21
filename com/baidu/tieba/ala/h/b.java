package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.bo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static bo Hj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bo boVar = new bo();
            boVar.downloadUrl = jSONObject.optString("download_url");
            boVar.aLJ = jSONObject.optString("download_md5");
            boVar.videoPath = jSONObject.optString("video_path");
            boVar.videoMd5 = jSONObject.optString("video_md5");
            return boVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(bo boVar) {
        if (boVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", boVar.downloadUrl);
            jSONObject.put("download_md5", boVar.aLJ);
            jSONObject.put("video_path", boVar.videoPath);
            jSONObject.put("video_md5", boVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
