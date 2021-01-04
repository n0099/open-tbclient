package com.baidu.tieba.ala.poke.startanim;

import android.text.TextUtils;
import com.baidu.live.data.by;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public static by Jb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            by byVar = new by();
            byVar.downloadUrl = jSONObject.optString("download_url");
            byVar.aSv = jSONObject.optString("download_md5");
            byVar.videoPath = jSONObject.optString(VrPlayerActivityConfig.RES_PATH);
            byVar.videoMd5 = jSONObject.optString("video_md5");
            return byVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(by byVar) {
        if (byVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", byVar.downloadUrl);
            jSONObject.put("download_md5", byVar.aSv);
            jSONObject.put(VrPlayerActivityConfig.RES_PATH, byVar.videoPath);
            jSONObject.put("video_md5", byVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
