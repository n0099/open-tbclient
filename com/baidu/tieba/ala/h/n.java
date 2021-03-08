package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.cd;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n {
    public static cd IH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cd cdVar = new cd();
            cdVar.downloadUrl = jSONObject.optString("download_url");
            cdVar.aSj = jSONObject.optString("download_md5");
            cdVar.videoPath = jSONObject.optString(VrPlayerActivityConfig.RES_PATH);
            cdVar.videoMd5 = jSONObject.optString("video_md5");
            return cdVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(cd cdVar) {
        if (cdVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", cdVar.downloadUrl);
            jSONObject.put("download_md5", cdVar.aSj);
            jSONObject.put(VrPlayerActivityConfig.RES_PATH, cdVar.videoPath);
            jSONObject.put("video_md5", cdVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
