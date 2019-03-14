package com.baidu.tieba.easterEgg.a;

import android.support.v4.app.NotificationCompat;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.util.ap;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private String ezD = "";
    private HashMap<String, String> ezE;
    private boolean isOpen;

    public void be(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) != null) {
            this.ezD = optJSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.isOpen = optJSONObject.optInt("open", 0) == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("config");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.ezE = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    if (optJSONObject3 != null) {
                        String optString = optJSONObject3.optString(NotificationCompat.CATEGORY_EVENT);
                        String optString2 = optJSONObject3.optString("rule");
                        if (!ap.isEmpty(optString) && !ap.isEmpty(optString2)) {
                            this.ezE.put(optString, optString2);
                        }
                    }
                }
            }
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public HashMap<String, String> aVv() {
        return this.ezE;
    }

    public String aVw() {
        return this.ezD;
    }
}
