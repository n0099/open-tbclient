package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static final String aSj() {
        com.baidu.n.a dhQ = com.baidu.n.c.gc(TbadkCoreApplication.getInst()).dhQ();
        if (dhQ == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String dhP = dhQ.dhP();
            if (!TextUtils.isEmpty(dhP)) {
                jSONObject.put("v", dhP);
            }
            jSONObject.put(Config.STAT_SDK_CHANNEL, dhQ.getStatusCode());
            jSONObject.put("sup", dhQ.isSupport() ? 1 : 0);
            jSONObject.put("tl", dhQ.dhO() ? 1 : 0);
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
