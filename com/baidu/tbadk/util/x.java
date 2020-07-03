package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public static final String biW() {
        com.baidu.l.a dxI = com.baidu.l.c.fK(TbadkCoreApplication.getInst()).dxI();
        if (dxI == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dxH = dxI.dxH();
            if (!TextUtils.isEmpty(dxH)) {
                jSONObject.put("v", dxH);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dxI.getStatusCode());
            jSONObject.put("sup", dxI.isSupport() ? 1 : 0);
            jSONObject.put("tl", dxI.dxG() ? 1 : 0);
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
