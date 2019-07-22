package com.baidu.tieba.aiapps.apps.openstat;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.ubc.l;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.ubc.l
    public boolean s(JSONArray jSONArray) {
        if (DEBUG) {
            Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
        }
        String token = com.baidu.swan.b.c.getToken();
        if (DEBUG) {
            Log.d("OpenBehaviorUploader", "OpenStat upload token is : " + token);
        }
        if (TextUtils.isEmpty(token)) {
            return false;
        }
        com.baidu.tieba.aiapps.apps.openstat.imupload.c cVar = new com.baidu.tieba.aiapps.apps.openstat.imupload.c();
        HashMap hashMap = new HashMap(2);
        hashMap.put("officialNo", "1");
        hashMap.put("containerNo", "2");
        com.baidu.tieba.aiapps.apps.openstat.imupload.b.aGY().a(hashMap, jSONArray.toString().getBytes(), token, cVar);
        if (DEBUG) {
            Log.d("OpenBehaviorUploader", "errorCode : " + cVar.errorCode);
            Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.errMsg);
        }
        switch (cVar.errorCode) {
            case 1:
            case 2:
            case 4:
                com.baidu.swan.b.c.Yz();
                return false;
            case 3:
            default:
                return true;
        }
    }
}
