package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends ah {

    /* renamed from: a  reason: collision with root package name */
    private List f971a = new ArrayList();
    private boolean b;

    public boolean a() {
        return this.b;
    }

    public List b() {
        return this.f971a;
    }

    @Override // com.baidu.tieba.data.ah
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optInt("is_selected", 0) == 1;
                super.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("level2_info");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ah ahVar = new ah();
                        ahVar.a(optJSONArray.getJSONObject(i));
                        this.f971a.add(ahVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("LabelBigBallData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
