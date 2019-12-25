package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public ArrayList<bj> eho;
    public boolean ehr = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ehr = jSONObject.optInt("need_show") == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("live_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eho = new ArrayList<>(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bj bjVar = new bj();
                        bjVar.parserJson(optJSONObject);
                        this.eho.add(bjVar);
                    }
                }
            }
        }
    }
}
