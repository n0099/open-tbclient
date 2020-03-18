package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String aSq() {
        com.baidu.n.a diq = com.baidu.n.c.gb(TbadkCoreApplication.getInst()).diq();
        if (diq == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dip = diq.dip();
            if (!TextUtils.isEmpty(dip)) {
                jSONObject.put("v", dip);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, diq.getStatusCode());
            jSONObject.put("sup", diq.isSupport() ? 1 : 0);
            jSONObject.put("tl", diq.dio() ? 1 : 0);
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
