package com.baidu.tieba.frs.gametabs;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends n {
    public e(l lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String vC() {
        return "TBHY_COMMON_IS_GAME_INSTALL";
    }

    @o(Bb = false, value = "isGameInstall")
    private JSONObject isGameInstall(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        String optString = jSONObject.optString("packagename");
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(optString, 0);
            if (packageInfo != null && packageInfo.packageName.equals(optString)) {
                jSONObject2.put("isInstall", true);
            } else {
                jSONObject2.put("isInstall", false);
            }
            return jSONObject2;
        } catch (PackageManager.NameNotFoundException e) {
            try {
                jSONObject2.put("isInstall", false);
                return jSONObject2;
            } catch (JSONException e2) {
                BdLog.e(e.getMessage());
                return jSONObject2;
            }
        } catch (JSONException e3) {
            BdLog.e(e3.getMessage());
            return jSONObject2;
        }
    }
}
