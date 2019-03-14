package com.baidu.tieba.aiapps.apps.e;

import android.os.Bundle;
import com.baidu.swan.apps.b.b.g;
import com.baidu.swan.apps.y.c;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.b.b.g
    public void a(Bundle bundle, g.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "success");
            aVar.onResult(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.swan.apps.b.b.g
    public void a(c cVar, HashMap<String, String> hashMap, File[] fileArr, g.a aVar) {
    }
}
