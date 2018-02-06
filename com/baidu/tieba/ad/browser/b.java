package com.baidu.tieba.ad.browser;

import android.os.Build;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.p;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b extends o {
    /* JADX INFO: Access modifiers changed from: protected */
    public b(m mVar) {
        super(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.o
    public String ww() {
        return "TBHY_COMMON_Utils";
    }

    @p(BC = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        if (jSONObject != null) {
            BdToast.a(getContext(), jSONObject.optString("message")).Bc();
        }
    }

    @p(BC = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        String str = "NotReachable";
        if (j.oK()) {
            i = 1;
            str = "WIFI";
        } else if (j.oO()) {
            i = 3;
            str = "2G";
        } else if (j.oN()) {
            i = 4;
            str = "3G";
        } else if (j.oM()) {
            i = 5;
            str = "4G";
        }
        try {
            jSONObject.put("netStatus", i);
            jSONObject.put("netDesc", str);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    @p(BC = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        String cuid = TbadkCoreApplication.getInst().getCuid();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String str3 = String.valueOf(l.ao(getContext())) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(l.aq(getContext()));
        String versionName = TbadkCoreApplication.getInst().getVersionName();
        try {
            jSONObject.put("systemName", com.baidu.ar.util.Constants.OS_TYPE_VALUE);
            jSONObject.put("systemVersion", str);
            jSONObject.put("model", str2);
            jSONObject.put("cuid", cuid);
            jSONObject.put("resolution", str3);
            jSONObject.put("appVersion", versionName);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
