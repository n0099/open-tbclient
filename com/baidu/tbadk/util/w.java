package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String aPS() {
        com.baidu.n.a dgA = com.baidu.n.c.ge(TbadkCoreApplication.getInst()).dgA();
        if (dgA == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dgz = dgA.dgz();
            if (!TextUtils.isEmpty(dgz)) {
                jSONObject.put("v", dgz);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dgA.getStatusCode());
            jSONObject.put("sup", dgA.isSupport() ? 1 : 0);
            jSONObject.put("tl", dgA.dgy() ? 1 : 0);
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
