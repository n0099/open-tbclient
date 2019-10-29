package com.baidu.tieba.ala.live.personcenter.guardian;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends BaseData {
    private ArrayList<a> dSR = new ArrayList<>();

    public ArrayList<a> aMH() {
        return this.dSR;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                aVar.parserJson(optJSONArray.optJSONObject(i));
                this.dSR.add(aVar);
            }
        }
    }
}
