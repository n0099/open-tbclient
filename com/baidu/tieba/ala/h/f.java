package com.baidu.tieba.ala.h;

import android.text.TextUtils;
import com.baidu.live.data.cb;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public static cb Iw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cb cbVar = new cb();
            cbVar.downloadUrl = jSONObject.optString("download_url");
            cbVar.aQJ = jSONObject.optString("download_md5");
            cbVar.videoPath = jSONObject.optString(VrPlayerActivityConfig.RES_PATH);
            cbVar.videoMd5 = jSONObject.optString("video_md5");
            return cbVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_url", cbVar.downloadUrl);
            jSONObject.put("download_md5", cbVar.aQJ);
            jSONObject.put(VrPlayerActivityConfig.RES_PATH, cbVar.videoPath);
            jSONObject.put("video_md5", cbVar.videoMd5);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
