package com.baidu.tieba.ala.alasquare.recent_history.b;

import com.baidu.tbadk.core.data.bw;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public bw dUS;
    public long fJi;
    public boolean isFollow;
    public List<a> tagList;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.isFollow = jSONObject.optInt("is_follow") == 1;
            this.fJi = jSONObject.optLong("last_watch_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
            if (optJSONObject != null) {
                this.dUS = new bw();
                this.dUS.parserJson(optJSONObject);
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

    /* loaded from: classes4.dex */
    public static class a {
        public int aCR;
        public String fJj;

        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aCR = jSONObject.optInt("tag_type");
                this.fJj = jSONObject.optString("tag_word");
            }
        }
    }
}
