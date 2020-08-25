package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x {
    public static final String bvD() {
        com.baidu.q.a dMN = com.baidu.q.c.ga(TbadkCoreApplication.getInst()).dMN();
        if (dMN == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dMM = dMN.dMM();
            if (!TextUtils.isEmpty(dMM)) {
                jSONObject.put("v", dMM);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dMN.getStatusCode());
            jSONObject.put("sup", dMN.isSupport() ? 1 : 0);
            jSONObject.put("tl", dMN.dML() ? 1 : 0);
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
