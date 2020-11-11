package com.baidu.tieba.ad.browser;

import android.os.Build;
import com.baidu.adp.lib.util.j;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes21.dex */
class a extends n {
    /* JADX INFO: Access modifiers changed from: protected */
    public a(l lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String bji() {
        return "TBHY_COMMON_Utils";
    }

    @o(bpS = false, value = PopItemMethodConstant.showToast)
    private void showToast(JSONObject jSONObject) {
        if (jSONObject != null) {
            BdToast.b(getContext(), jSONObject.optString("message")).bpi();
        }
    }

    @o(bpS = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        String str = "NotReachable";
        if (j.isWifiNet()) {
            i = 1;
            str = "WIFI";
        } else if (j.is2GNet()) {
            i = 3;
            str = "2G";
        } else if (j.is3GNet()) {
            i = 4;
            str = "3G";
        } else if (j.is4GNet()) {
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

    @o(bpS = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        String cuid = TbadkCoreApplication.getInst().getCuid();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String str3 = String.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext())) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(getContext()));
        String versionName = TbadkCoreApplication.getInst().getVersionName();
        try {
            jSONObject.put("systemName", "android");
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
