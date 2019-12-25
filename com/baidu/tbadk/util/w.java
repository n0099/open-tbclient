package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String aPz() {
        com.baidu.n.a dfy = com.baidu.n.c.gc(TbadkCoreApplication.getInst()).dfy();
        if (dfy == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dfx = dfy.dfx();
            if (!TextUtils.isEmpty(dfx)) {
                jSONObject.put("v", dfx);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dfy.getStatusCode());
            jSONObject.put("sup", dfy.isSupport() ? 1 : 0);
            jSONObject.put("tl", dfy.dfw() ? 1 : 0);
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
