package com.baidu.tieba.easterEgg.a;

import com.baidu.tbadk.core.util.au;
import com.heytap.mcssdk.mode.Message;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class a {
    private boolean isOpen;
    private String isa = "";
    private HashMap<String, String> isb;

    public void parserData(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) != null) {
            this.isa = optJSONObject.optString("link");
            this.isOpen = optJSONObject.optInt("open", 0) == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("config");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.isb = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    if (optJSONObject3 != null) {
                        String optString = optJSONObject3.optString("event");
                        String optString2 = optJSONObject3.optString(Message.RULE);
                        if (!au.isEmpty(optString) && !au.isEmpty(optString2)) {
                            this.isb.put(optString, optString2);
                        }
                    }
                }
            }
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public HashMap<String, String> cui() {
        return this.isb;
    }

    public String cuj() {
        return this.isa;
    }
}
