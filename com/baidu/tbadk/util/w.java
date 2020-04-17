package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String baz() {
        com.baidu.l.a dlE = com.baidu.l.c.fG(TbadkCoreApplication.getInst()).dlE();
        if (dlE == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dlD = dlE.dlD();
            if (!TextUtils.isEmpty(dlD)) {
                jSONObject.put("v", dlD);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dlE.getStatusCode());
            jSONObject.put("sup", dlE.isSupport() ? 1 : 0);
            jSONObject.put("tl", dlE.dlC() ? 1 : 0);
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
