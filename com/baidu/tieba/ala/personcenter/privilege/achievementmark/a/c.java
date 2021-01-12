package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private String hWO;
    private int hWQ;
    private List<b> list = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.hWO = jSONObject.optString("mark_type_name");
        this.hWQ = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.parserJson(optJSONArray.optJSONObject(i));
                bVar.HJ(this.hWO);
                bVar.wi(this.hWQ);
                this.list.add(bVar);
            }
        }
    }

    public String clY() {
        return this.hWO;
    }

    public List<b> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }
}
