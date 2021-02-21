package com.baidu.tieba.ala.live.personcenter.guardian;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends BaseData {
    private ArrayList<a> hmj = new ArrayList<>();

    public ArrayList<a> bYG() {
        return this.hmj;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                aVar.parserJson(optJSONArray.optJSONObject(i));
                this.hmj.add(aVar);
            }
        }
    }
}
