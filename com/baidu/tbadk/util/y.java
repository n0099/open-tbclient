package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    public static final String bzx() {
        com.baidu.q.a dUF = com.baidu.q.c.go(TbadkCoreApplication.getInst()).dUF();
        if (dUF == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dUE = dUF.dUE();
            if (!TextUtils.isEmpty(dUE)) {
                jSONObject.put("v", dUE);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dUF.getStatusCode());
            jSONObject.put("sup", dUF.isSupport() ? 1 : 0);
            jSONObject.put("tl", dUF.dUD() ? 1 : 0);
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
