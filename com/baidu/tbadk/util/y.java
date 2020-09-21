package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    public static final String bwN() {
        com.baidu.q.a dQU = com.baidu.q.c.gh(TbadkCoreApplication.getInst()).dQU();
        if (dQU == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dQT = dQU.dQT();
            if (!TextUtils.isEmpty(dQT)) {
                jSONObject.put("v", dQT);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dQU.getStatusCode());
            jSONObject.put("sup", dQU.isSupport() ? 1 : 0);
            jSONObject.put("tl", dQU.dQS() ? 1 : 0);
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
