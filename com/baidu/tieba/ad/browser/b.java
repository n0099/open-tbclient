package com.baidu.tieba.ad.browser;

import android.os.Build;
import com.baidu.adp.lib.util.j;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b extends n {
    /* JADX INFO: Access modifiers changed from: protected */
    public b(l lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String sB() {
        return "TBHY_COMMON_Utils";
    }

    @o(value = "showToast", xV = false)
    private void showToast(JSONObject jSONObject) {
        if (jSONObject != null) {
            BdToast.a(getContext(), jSONObject.optString("message")).xv();
        }
    }

    @o(value = "showNetStatus", xV = false)
    private JSONObject showNetStatus() {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        String str = "NotReachable";
        if (j.jE()) {
            i = 1;
            str = "WIFI";
        } else if (j.jI()) {
            i = 3;
            str = "2G";
        } else if (j.jH()) {
            i = 4;
            str = "3G";
        } else if (j.jG()) {
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

    @o(value = "showDeviceInfo", xV = false)
    private JSONObject showDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        String cuid = TbadkCoreApplication.getInst().getCuid();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String str3 = String.valueOf(com.baidu.adp.lib.util.l.ah(getContext())) + "," + String.valueOf(com.baidu.adp.lib.util.l.aj(getContext()));
        String versionName = TbadkCoreApplication.getInst().getVersionName();
        try {
            jSONObject.put("systemName", HttpConstants.OS_TYPE_VALUE);
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
