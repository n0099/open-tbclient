package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public static final String bmQ() {
        com.baidu.m.a dAY = com.baidu.m.c.fN(TbadkCoreApplication.getInst()).dAY();
        if (dAY == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dAX = dAY.dAX();
            if (!TextUtils.isEmpty(dAX)) {
                jSONObject.put("v", dAX);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dAY.getStatusCode());
            jSONObject.put("sup", dAY.isSupport() ? 1 : 0);
            jSONObject.put("tl", dAY.dAW() ? 1 : 0);
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
