package com.baidu.tieba.easterEgg.a;

import com.baidu.tbadk.core.util.at;
import com.heytap.mcssdk.mode.Message;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private String iEp = "";
    private HashMap<String, String> iEq;
    private boolean isOpen;

    public void parserData(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) != null) {
            this.iEp = optJSONObject.optString("link");
            this.isOpen = optJSONObject.optInt("open", 0) == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("config");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.iEq = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    if (optJSONObject3 != null) {
                        String optString = optJSONObject3.optString("event");
                        String optString2 = optJSONObject3.optString(Message.RULE);
                        if (!at.isEmpty(optString) && !at.isEmpty(optString2)) {
                            this.iEq.put(optString, optString2);
                        }
                    }
                }
            }
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public HashMap<String, String> cxc() {
        return this.iEq;
    }

    public String cxd() {
        return this.iEp;
    }
}
