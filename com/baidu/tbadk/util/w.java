package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String aPS() {
        com.baidu.n.a dgC = com.baidu.n.c.ge(TbadkCoreApplication.getInst()).dgC();
        if (dgC == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dgB = dgC.dgB();
            if (!TextUtils.isEmpty(dgB)) {
                jSONObject.put("v", dgB);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dgC.getStatusCode());
            jSONObject.put("sup", dgC.isSupport() ? 1 : 0);
            jSONObject.put("tl", dgC.dgA() ? 1 : 0);
            return jSONObject.toString();
        } catch (JSONException e) {
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}
