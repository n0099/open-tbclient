package com.baidu.tieba.ala.alasquare.recent_history.b;

import com.baidu.tbadk.core.data.bj;
import com.coloros.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public bj cRf;
    public long eqq;
    public boolean isFollow;
    public List<a> tagList;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.isFollow = jSONObject.optInt("is_follow") == 1;
            this.eqq = jSONObject.optLong("last_watch_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
            if (optJSONObject != null) {
                this.cRf = new bj();
                this.cRf.parserJson(optJSONObject);
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

    /* loaded from: classes3.dex */
    public static class a {
        public int Xk;
        public String eqr;

        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.Xk = jSONObject.optInt("tag_type");
                this.eqr = jSONObject.optString("tag_word");
            }
        }
    }
}
