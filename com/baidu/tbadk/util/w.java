package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String aSm() {
        com.baidu.n.a dhT = com.baidu.n.c.gc(TbadkCoreApplication.getInst()).dhT();
        if (dhT == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dhS = dhT.dhS();
            if (!TextUtils.isEmpty(dhS)) {
                jSONObject.put("v", dhS);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dhT.getStatusCode());
            jSONObject.put("sup", dhT.isSupport() ? 1 : 0);
            jSONObject.put("tl", dhT.dhR() ? 1 : 0);
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
