package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String bax() {
        com.baidu.l.a dlB = com.baidu.l.c.fu(TbadkCoreApplication.getInst()).dlB();
        if (dlB == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dlA = dlB.dlA();
            if (!TextUtils.isEmpty(dlA)) {
                jSONObject.put("v", dlA);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dlB.getStatusCode());
            jSONObject.put("sup", dlB.isSupport() ? 1 : 0);
            jSONObject.put("tl", dlB.dlz() ? 1 : 0);
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
