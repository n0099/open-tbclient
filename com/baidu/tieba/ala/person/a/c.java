package com.baidu.tieba.ala.person.a;

import com.baidu.live.data.bl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public int has_more;
    public List<bl> user_list;

    public void parserJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        parserJson(jSONObject);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.user_list = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bl blVar = new bl();
                        blVar.parserJson(optJSONObject);
                        this.user_list.add(blVar);
                    }
                }
            }
            this.has_more = jSONObject.optInt("has_more");
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (this.user_list != null && !this.user_list.isEmpty()) {
            for (bl blVar : this.user_list) {
                jSONArray.put(blVar.toString());
            }
        }
        try {
            jSONObject.put("user_list", jSONArray.toString());
            jSONObject.put("has_more", this.has_more);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
