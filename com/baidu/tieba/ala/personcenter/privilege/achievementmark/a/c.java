package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private String gDg;
    private int gDi;
    private List<b> list = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.gDg = jSONObject.optString("mark_type_name");
        this.gDi = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.parserJson(optJSONArray.optJSONObject(i));
                bVar.Dz(this.gDg);
                bVar.sm(this.gDi);
                this.list.add(bVar);
            }
        }
    }

    public String bLB() {
        return this.gDg;
    }

    public List<b> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }
}
