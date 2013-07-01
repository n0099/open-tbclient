package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y extends z {

    /* renamed from: a  reason: collision with root package name */
    private List f805a = new ArrayList();
    private boolean b;

    public boolean a() {
        return this.b;
    }

    public List b() {
        return this.f805a;
    }

    @Override // com.baidu.tieba.data.z
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optInt("is_selected", 0) == 1;
                super.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("level2_info");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        z zVar = new z();
                        zVar.a(optJSONArray.getJSONObject(i));
                        this.f805a.add(zVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("LabelBigBallData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
