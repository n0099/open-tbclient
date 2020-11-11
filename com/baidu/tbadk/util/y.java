package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    public static final String bDP() {
        com.baidu.q.a eef = com.baidu.q.c.gq(TbadkCoreApplication.getInst()).eef();
        if (eef == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String eee = eef.eee();
            if (!TextUtils.isEmpty(eee)) {
                jSONObject.put("v", eee);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, eef.getStatusCode());
            jSONObject.put("sup", eef.isSupport() ? 1 : 0);
            jSONObject.put("tl", eef.eed() ? 1 : 0);
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
