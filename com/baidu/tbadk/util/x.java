package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public static final String bmQ() {
        com.baidu.m.a dAZ = com.baidu.m.c.fN(TbadkCoreApplication.getInst()).dAZ();
        if (dAZ == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dAY = dAZ.dAY();
            if (!TextUtils.isEmpty(dAY)) {
                jSONObject.put("v", dAY);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dAZ.getStatusCode());
            jSONObject.put("sup", dAZ.isSupport() ? 1 : 0);
            jSONObject.put("tl", dAZ.dAX() ? 1 : 0);
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
