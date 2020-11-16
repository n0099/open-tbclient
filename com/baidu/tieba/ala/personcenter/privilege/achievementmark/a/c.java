package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private String hFr;
    private int hFt;
    private List<b> list = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.hFr = jSONObject.optString("mark_type_name");
        this.hFt = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.parserJson(optJSONArray.optJSONObject(i));
                bVar.Ii(this.hFr);
                bVar.wW(this.hFt);
                this.list.add(bVar);
            }
        }
    }

    public String cjc() {
        return this.hFr;
    }

    public List<b> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }
}
