package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.bt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static bt Io(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bt btVar = new bt();
            btVar.downloadUrl = jSONObject.optString("download_url");
            btVar.aOF = jSONObject.optString("download_md5");
            btVar.videoPath = jSONObject.optString("video_path");
            btVar.videoMd5 = jSONObject.optString("video_md5");
            return btVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(bt btVar) {
        if (btVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", btVar.downloadUrl);
            jSONObject.put("download_md5", btVar.aOF);
            jSONObject.put("video_path", btVar.videoPath);
            jSONObject.put("video_md5", btVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
