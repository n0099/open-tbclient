package com.baidu.tieba;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private ArrayList<a> bhP;

    /* loaded from: classes3.dex */
    public static class a {
        public String bhQ;
        public String threadId;
        public String title;
        public String url;
    }

    public void parseData(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("thread_info")) != null) {
            this.bhP = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.threadId = optJSONObject.optString("thread_id");
                    aVar.bhQ = optJSONObject.optString("abstract");
                    aVar.url = optJSONObject.optString("url");
                    aVar.title = optJSONObject.optString("title");
                    this.bhP.add(aVar);
                }
            }
        }
    }

    public ArrayList<a> Pc() {
        return this.bhP;
    }
}
