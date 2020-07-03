package com.baidu.tieba.easterEgg.a;

import android.support.v4.app.NotificationCompat;
import com.baidu.tbadk.core.util.ar;
import com.heytap.mcssdk.mode.Message;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String gZq = "";
    private HashMap<String, String> gZr;
    private boolean isOpen;

    public void dh(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) != null) {
            this.gZq = optJSONObject.optString("link");
            this.isOpen = optJSONObject.optInt("open", 0) == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("config");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.gZr = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    if (optJSONObject3 != null) {
                        String optString = optJSONObject3.optString(NotificationCompat.CATEGORY_EVENT);
                        String optString2 = optJSONObject3.optString(Message.RULE);
                        if (!ar.isEmpty(optString) && !ar.isEmpty(optString2)) {
                            this.gZr.put(optString, optString2);
                        }
                    }
                }
            }
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public HashMap<String, String> bQz() {
        return this.gZr;
    }

    public String bQA() {
        return this.gZq;
    }
}
