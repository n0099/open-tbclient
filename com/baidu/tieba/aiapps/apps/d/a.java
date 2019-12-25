package com.baidu.tieba.aiapps.apps.d;

import android.graphics.Bitmap;
import com.baidu.swan.apps.adaptation.a.s;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements s {
    @Override // com.baidu.swan.apps.adaptation.a.s
    public void a(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, s.a aVar) {
        a(aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.s
    public void a(HashMap<String, String> hashMap, File file, s.a aVar) {
        a(aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.s
    public void a(HashMap<String, String> hashMap, File file, s.a aVar, String str) {
        a(aVar);
    }

    private void a(s.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "success");
            aVar.onResult(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
