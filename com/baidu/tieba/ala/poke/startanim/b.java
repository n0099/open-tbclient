package com.baidu.tieba.ala.poke.startanim;

import android.text.TextUtils;
import com.baidu.live.data.cf;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static cf ID(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cf cfVar = new cf();
            cfVar.downloadUrl = jSONObject.optString("download_url");
            cfVar.aSj = jSONObject.optString("download_md5");
            cfVar.videoPath = jSONObject.optString(VrPlayerActivityConfig.RES_PATH);
            cfVar.videoMd5 = jSONObject.optString("video_md5");
            return cfVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(cf cfVar) {
        if (cfVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", cfVar.downloadUrl);
            jSONObject.put("download_md5", cfVar.aSj);
            jSONObject.put(VrPlayerActivityConfig.RES_PATH, cfVar.videoPath);
            jSONObject.put("video_md5", cfVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
