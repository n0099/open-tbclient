package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public static final String bvE() {
        com.baidu.q.a dMW = com.baidu.q.c.ga(TbadkCoreApplication.getInst()).dMW();
        if (dMW == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dMV = dMW.dMV();
            if (!TextUtils.isEmpty(dMV)) {
                jSONObject.put("v", dMV);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dMW.getStatusCode());
            jSONObject.put("sup", dMW.isSupport() ? 1 : 0);
            jSONObject.put("tl", dMW.dMU() ? 1 : 0);
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
