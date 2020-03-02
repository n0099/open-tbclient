package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private String fvO;
    private int fvQ;
    private List<b> list = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.fvO = jSONObject.optString("mark_type_name");
        this.fvQ = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.parserJson(optJSONArray.optJSONObject(i));
                bVar.zE(this.fvO);
                bVar.qO(this.fvQ);
                this.list.add(bVar);
            }
        }
    }

    public String bsn() {
        return this.fvO;
    }

    public List<b> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }
}
