package com.baidu.tieba.ala.alasquare.recent_history.b;

import com.baidu.tbadk.core.data.by;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public by eCR;
    public long gwC;
    public boolean isFollow;
    public List<a> tagList;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.isFollow = jSONObject.optInt("is_follow") == 1;
            this.gwC = jSONObject.optLong("last_watch_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
            if (optJSONObject != null) {
                this.eCR = new by();
                this.eCR.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.tagList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        a aVar = new a();
                        aVar.parse(optJSONObject2);
                        this.tagList.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public int aIC;
        public String gwD;

        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aIC = jSONObject.optInt("tag_type");
                this.gwD = jSONObject.optString("tag_word");
            }
        }
    }
}
