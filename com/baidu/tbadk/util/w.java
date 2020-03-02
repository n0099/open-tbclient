package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String aSl() {
        com.baidu.n.a dhS = com.baidu.n.c.gc(TbadkCoreApplication.getInst()).dhS();
        if (dhS == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dhR = dhS.dhR();
            if (!TextUtils.isEmpty(dhR)) {
                jSONObject.put("v", dhR);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dhS.getStatusCode());
            jSONObject.put("sup", dhS.isSupport() ? 1 : 0);
            jSONObject.put("tl", dhS.dhQ() ? 1 : 0);
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
