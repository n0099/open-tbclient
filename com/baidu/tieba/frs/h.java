package com.baidu.tieba.frs;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class h {
    private ArrayList<g> a = new ArrayList<>();

    public final ArrayList<g> a() {
        return this.a;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(PushConstants.EXTRA_APP);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        g gVar = new g();
                        gVar.a(optJSONArray.optJSONObject(i));
                        this.a.add(gVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
