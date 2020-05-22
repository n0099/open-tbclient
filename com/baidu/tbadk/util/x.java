package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public static final String bgI() {
        com.baidu.l.a dsR = com.baidu.l.c.fJ(TbadkCoreApplication.getInst()).dsR();
        if (dsR == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dsQ = dsR.dsQ();
            if (!TextUtils.isEmpty(dsQ)) {
                jSONObject.put("v", dsQ);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dsR.getStatusCode());
            jSONObject.put("sup", dsR.isSupport() ? 1 : 0);
            jSONObject.put("tl", dsR.dsP() ? 1 : 0);
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
