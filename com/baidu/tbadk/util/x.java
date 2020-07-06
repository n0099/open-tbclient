package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public static final String biX() {
        com.baidu.l.a dxM = com.baidu.l.c.fK(TbadkCoreApplication.getInst()).dxM();
        if (dxM == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dxL = dxM.dxL();
            if (!TextUtils.isEmpty(dxL)) {
                jSONObject.put("v", dxL);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dxM.getStatusCode());
            jSONObject.put("sup", dxM.isSupport() ? 1 : 0);
            jSONObject.put("tl", dxM.dxK() ? 1 : 0);
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
