package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.bw;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public static bw Jd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bw bwVar = new bw();
            bwVar.downloadUrl = jSONObject.optString("download_url");
            bwVar.aSv = jSONObject.optString("download_md5");
            bwVar.videoPath = jSONObject.optString(VrPlayerActivityConfig.RES_PATH);
            bwVar.videoMd5 = jSONObject.optString("video_md5");
            return bwVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", bwVar.downloadUrl);
            jSONObject.put("download_md5", bwVar.aSv);
            jSONObject.put(VrPlayerActivityConfig.RES_PATH, bwVar.videoPath);
            jSONObject.put("video_md5", bwVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
