package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String bax() {
        com.baidu.l.a dlC = com.baidu.l.c.fu(TbadkCoreApplication.getInst()).dlC();
        if (dlC == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dlB = dlC.dlB();
            if (!TextUtils.isEmpty(dlB)) {
                jSONObject.put("v", dlB);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dlC.getStatusCode());
            jSONObject.put("sup", dlC.isSupport() ? 1 : 0);
            jSONObject.put("tl", dlC.dlA() ? 1 : 0);
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
