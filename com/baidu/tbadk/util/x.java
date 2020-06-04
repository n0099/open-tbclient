package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    public static final String bgJ() {
        com.baidu.l.a dtf = com.baidu.l.c.fJ(TbadkCoreApplication.getInst()).dtf();
        if (dtf == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dte = dtf.dte();
            if (!TextUtils.isEmpty(dte)) {
                jSONObject.put("v", dte);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dtf.getStatusCode());
            jSONObject.put("sup", dtf.isSupport() ? 1 : 0);
            jSONObject.put("tl", dtf.dtd() ? 1 : 0);
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
