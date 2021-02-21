package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.cc;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j {
    public static cc Ix(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cc ccVar = new cc();
            ccVar.downloadUrl = jSONObject.optString("download_url");
            ccVar.aQJ = jSONObject.optString("download_md5");
            ccVar.videoPath = jSONObject.optString(VrPlayerActivityConfig.RES_PATH);
            ccVar.videoMd5 = jSONObject.optString("video_md5");
            return ccVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(cc ccVar) {
        if (ccVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", ccVar.downloadUrl);
            jSONObject.put("download_md5", ccVar.aQJ);
            jSONObject.put(VrPlayerActivityConfig.RES_PATH, ccVar.videoPath);
            jSONObject.put("video_md5", ccVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
