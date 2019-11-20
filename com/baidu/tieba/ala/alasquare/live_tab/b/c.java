package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public ArrayList<bh> dwm;
    public boolean dwp = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dwp = jSONObject.optInt("need_show") == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("live_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.dwm = new ArrayList<>(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bh bhVar = new bh();
                        bhVar.parserJson(optJSONObject);
                        this.dwm.add(bhVar);
                    }
                }
            }
        }
    }
}
