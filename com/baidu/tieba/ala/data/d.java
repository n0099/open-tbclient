package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public boolean ezE;
    public ArrayList<a> ezF;
    public long ezm;
    public String portrait;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("send_user");
        if (optJSONObject != null) {
            this.userName = optJSONObject.optString("user_name");
            this.portrait = optJSONObject.optString("bd_portrait");
        }
        this.ezE = jSONObject.optInt("loot_result") == 1;
        this.ezm = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        JSONArray optJSONArray = jSONObject.optJSONArray("loot_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            this.ezF = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                if (jSONObject2 != null) {
                    a aVar = new a();
                    aVar.parserJson(jSONObject2);
                    this.ezF.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public long ezG;
        public String portrait;
        public String userId;
        public String userName;

        public void parserJson(JSONObject jSONObject) {
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("bd_portrait");
            this.ezG = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
