package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private String hzN;
    private int hzP;
    private List<b> list = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.hzN = jSONObject.optString("mark_type_name");
        this.hzP = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.parserJson(optJSONArray.optJSONObject(i));
                bVar.Iq(this.hzN);
                bVar.wl(this.hzP);
                this.list.add(bVar);
            }
        }
    }

    public String chh() {
        return this.hzN;
    }

    public List<b> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }
}
