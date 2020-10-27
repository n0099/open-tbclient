package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    public static final String bBq() {
        com.baidu.q.a eax = com.baidu.q.c.gq(TbadkCoreApplication.getInst()).eax();
        if (eax == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String eaw = eax.eaw();
            if (!TextUtils.isEmpty(eaw)) {
                jSONObject.put("v", eaw);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, eax.getStatusCode());
            jSONObject.put("sup", eax.isSupport() ? 1 : 0);
            jSONObject.put("tl", eax.eav() ? 1 : 0);
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
